package j.a.a.e.k;

import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes2.dex */
public interface d extends b {
    PayUIKitConfig getPayUIKitConfig();

    void notifyYYPayFailListener(int i2, String str, PayCallBackBean payCallBackBean);
}
