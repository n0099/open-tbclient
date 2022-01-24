package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import com.yy.mobile.framework.revenuesdk.payapi.request.RequestParams;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequest;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.response.IResponse;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ)\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService;", "Lkotlin/Any;", "Lcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;", "T", "", "command", "params", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "obtainRequest", "(ILcom/yy/mobile/framework/revenuesdk/payapi/request/RequestParams;)Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;", "req", "", "sendRequest", "(Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/request/IRequest;)V", "IRevenueServiceListener", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface IRevenueService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/IRevenueService$IRevenueServiceListener;", "Lkotlin/Any;", "", "command", "Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;", "response", "", "onRevenueResponse", "(ILcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/response/IResponse;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public interface IRevenueServiceListener {
        void onRevenueResponse(int i2, IResponse iResponse);
    }

    <T extends RequestParams> IRequest obtainRequest(int i2, T t);

    void sendRequest(IRequest iRequest);
}
