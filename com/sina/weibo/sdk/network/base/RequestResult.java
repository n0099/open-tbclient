package com.sina.weibo.sdk.network.base;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class RequestResult<T> {
    private Exception e;
    private ArrayList<Object> interceptResult;
    private T response;

    public Exception getE() {
        return this.e;
    }

    public void setInterceptResult(ArrayList<Object> arrayList) {
        this.interceptResult = arrayList;
    }

    public ArrayList<Object> getInterceptResult() {
        return this.interceptResult;
    }

    public void setE(Exception exc) {
        this.e = exc;
    }

    public T getResponse() {
        return this.response;
    }

    public void setResponse(T t) {
        this.response = t;
    }
}
