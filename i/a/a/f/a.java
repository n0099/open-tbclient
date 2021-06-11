package i.a.a.f;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.bean.AccountDelayMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ConsumeConfirmMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes8.dex */
public final class a implements IAppPayServiceListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f72254a = new a();

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onAccountDelayMessage(AccountDelayMessage accountDelayMessage) {
        RLog.debug("GiftEventCallbackImpl", "onAccountDelayMessage appId == " + accountDelayMessage.appid);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onConsumeConfirmMessage(ConsumeConfirmMessage consumeConfirmMessage) {
        RLog.debug("GiftEventCallbackImpl", "onConsumeConfirmMessage appId == " + consumeConfirmMessage.appid);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
    public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        RLog.debug("GiftEventCallbackImpl", "onCurrencyChargeMessage appId == " + currencyChargeMessage.appid);
    }
}
