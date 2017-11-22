package com.dieche.wl.model;

import com.dieche.wl.constants.Constants;

import java.io.Serializable;
import java.util.Map;

public class GlobalRequestResult implements Serializable{
    public static final String errorCodeKey = "errorCode";

    public static final String errorMsgKey = "errorMsg";

    private Integer code = 0;

    private Object data;

    private Map<String, String> error;

    private String errorMsg;

    private String succMsg;

    private Boolean flag;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map<String, String> getError() {
        return error;
    }

    public void setError(Map<String, String> error) {
        this.error = error;
        this.errorMsg = error == null ? null : error.get(Constants.ERROR_PAGE_MSG);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccMsg() {
        return succMsg;
    }

    public void setSuccMsg(String succMsg) {
        this.succMsg = succMsg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public static GlobalRequestResult wrapSuccessResult(){
        GlobalRequestResult globalRequestResult = new GlobalRequestResult();
        globalRequestResult.setFlag(true);
        return globalRequestResult;
    }

    public static GlobalRequestResult wrapSuccessMsgResult(String succMsg){
        GlobalRequestResult globalRequestResult = new GlobalRequestResult();
        globalRequestResult.setFlag(true);
        globalRequestResult.setSuccMsg(succMsg);
        return globalRequestResult;
    }

    public static GlobalRequestResult wrapSuccessResult(Object data){
        GlobalRequestResult globalRequestResult = new GlobalRequestResult();
        globalRequestResult.setFlag(true);
        globalRequestResult.setData(data);
        return globalRequestResult;
    }

    public static GlobalRequestResult wrapSuccessResultWitMsg(Object data, String succMsg){
        GlobalRequestResult globalRequestResult = wrapSuccessMsgResult(succMsg);
        globalRequestResult.setData(data);
        return globalRequestResult;
    }

    public static GlobalRequestResult wrapErrorResult(String errorMsg){
        GlobalRequestResult globalRequestResult = new GlobalRequestResult();
        globalRequestResult.setFlag(false);
        globalRequestResult.setErrorMsg(errorMsg);
        return globalRequestResult;
    }

    public static GlobalRequestResult wrapErrorResult(int code, String errorMsg){
        GlobalRequestResult globalRequestResult = new GlobalRequestResult();
        globalRequestResult.setFlag(false);
        globalRequestResult.setCode(code);
        globalRequestResult.setErrorMsg(errorMsg);
        return globalRequestResult;
    }
}
