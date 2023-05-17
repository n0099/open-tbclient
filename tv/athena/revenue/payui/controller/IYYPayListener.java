package tv.athena.revenue.payui.controller;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
@Keep
/* loaded from: classes2.dex */
public interface IYYPayListener {
    void onFail(int i, String str, PayCallBackBean payCallBackBean);

    void onSuccess(CurrencyChargeMessage currencyChargeMessage);
}
