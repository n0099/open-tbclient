package tv.athena.revenue.payui.view;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes9.dex */
public enum PaySplitOrderViewSource {
    SOURCE_FROM_INPUAT_DIALOG("支付输入弹框"),
    SOURCE_FROM_PAY_WAY_DIALOG("支付渠道弹窗");
    
    public final String source;

    PaySplitOrderViewSource(String str) {
        this.source = str;
    }
}
