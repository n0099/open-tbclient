package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response;

import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010!\u001a\u00020\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001b¨\u0006%"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/ServiceResponse;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;", "", "getMessage", "()Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "getRequest", "()Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "", "getResponseCode", "()I", "", "getResponseData", "()Ljava/lang/Object;", "getSeq", "", "isSuccess", "()Z", "command", "I", "getCommand", "data", "Ljava/lang/Object;", "getData", "setData", "(Ljava/lang/Object;)V", "msg", "Ljava/lang/String;", "req", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "getReq", "setReq", "(Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;)V", "result", "seq", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ServiceResponse implements IResponse {
    public final int command;
    public Object data;
    public final String msg;
    public IRequest req;
    public final int result;
    public final String seq;

    public ServiceResponse(int i, String str, int i2, String str2) {
        this.command = i;
        this.seq = str;
        this.result = i2;
        this.msg = str2;
    }

    public final int getCommand() {
        return this.command;
    }

    public final Object getData() {
        return this.data;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public String getMessage() {
        return this.msg;
    }

    public final IRequest getReq() {
        return this.req;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public IRequest getRequest() {
        return this.req;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public int getResponseCode() {
        return this.result;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public Object getResponseData() {
        return this.data;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public String getSeq() {
        return this.seq;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse
    public boolean isSuccess() {
        if (this.result == 1) {
            return true;
        }
        return false;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setReq(IRequest iRequest) {
        this.req = iRequest;
    }
}
