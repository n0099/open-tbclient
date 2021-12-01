package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response;

import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;", "Lkotlin/Any;", "", "getMessage", "()Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "getRequest", "()Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "", "getResponseCode", "()I", "", "getResponseData", "()Ljava/lang/Object;", "getSeq", "", "isSuccess", "()Z", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IResponse {
    String getMessage();

    IRequest getRequest();

    int getResponseCode();

    Object getResponseData();

    String getSeq();

    boolean isSuccess();
}
