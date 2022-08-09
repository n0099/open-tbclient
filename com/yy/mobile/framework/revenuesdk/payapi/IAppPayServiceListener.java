package com.yy.mobile.framework.revenuesdk.payapi;

import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import kotlin.Deprecated;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/IAppPayServiceListener;", "Lkotlin/Any;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/AccountDelayMessage;", "message", "", "onAccountDelayMessage", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/AccountDelayMessage;)V", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ConsumeConfirmMessage;", "onConsumeConfirmMessage", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ConsumeConfirmMessage;)V", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;", "onCurrencyChargeMessage", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/CurrencyChargeMessage;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface IAppPayServiceListener {
    @Deprecated(message = "废弃")
    void onAccountDelayMessage(AccountDelayMessage accountDelayMessage);

    @Deprecated(message = "废弃")
    void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage);

    void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage);
}
