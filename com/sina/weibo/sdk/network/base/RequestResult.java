package com.sina.weibo.sdk.network.base;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class RequestResult<T> {

    /* renamed from: e  reason: collision with root package name */
    public Exception f36575e;
    public ArrayList<Object> interceptResult;
    public T response;

    public Exception getE() {
        return this.f36575e;
    }

    public ArrayList<Object> getInterceptResult() {
        return this.interceptResult;
    }

    public T getResponse() {
        return this.response;
    }

    public void setE(Exception exc) {
        this.f36575e = exc;
    }

    public void setInterceptResult(ArrayList<Object> arrayList) {
        this.interceptResult = arrayList;
    }

    public void setResponse(T t) {
        this.response = t;
    }
}
