package com.yy.mobile.framework.revenuesdk.payapi;

import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataReceiver;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/IRevenueService;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IRevenueDataReceiver;", "Lkotlin/Any;", "Lcom/yy/mobile/framework/revenuesdk/payapi/IRevenueService$DataReceiveListener;", "listener", "", "addDataReceiveListener", "(Lcom/yy/mobile/framework/revenuesdk/payapi/IRevenueService$DataReceiveListener;)V", "removeDataReceiveListener", "DataReceiveListener", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IRevenueService extends IRevenueDataReceiver {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/IRevenueService$DataReceiveListener;", "Lkotlin/Any;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "message", "", "onCurrencyMessage", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface DataReceiveListener {
        void onCurrencyMessage(CurrencyChargeMessage currencyChargeMessage);
    }

    void addDataReceiveListener(DataReceiveListener dataReceiveListener);

    void removeDataReceiveListener(DataReceiveListener dataReceiveListener);
}
