package i.a.a.e.k;

import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes9.dex */
public interface c {
    PayUIKitConfig getPayUIKitConfig();

    void notifyYYPayFailListener(int i2, String str, PayCallBackBean payCallBackBean);
}
