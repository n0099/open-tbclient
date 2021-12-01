package j.a.a.e.k;

import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes3.dex */
public interface h extends d {
    PayUIKitConfig getPayUIKitConfig();

    void notifyYYPayFailListener(int i2, String str, PayCallBackBean payCallBackBean);
}
