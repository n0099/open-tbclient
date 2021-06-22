package i.a.a.e.l;

import com.yy.mobile.framework.revenuesdk.payapi.bean.PaysSettingInfo;
import i.a.a.e.g;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThemeColorConfig;
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static PaysSettingInfo f72259a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f72260b = "https://web.yy.com/yy_wallet/pay-protocol.html?";

    /* renamed from: c  reason: collision with root package name */
    public static String f72261c = "https://web.yy.com/yy_wallet/wallet.html?";

    /* renamed from: d  reason: collision with root package name */
    public static String f72262d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";

    public static String a(String str, PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig == null || payUIKitConfig.revenueConfig == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("&uid=" + payUIKitConfig.revenueConfig.getUid());
        sb.append("&hostId=" + payUIKitConfig.revenueConfig.getHostId());
        sb.append("&appid=" + payUIKitConfig.revenueConfig.getAppId());
        sb.append("&usedChannel=" + payUIKitConfig.revenueConfig.getUseChannel());
        sb.append("&authType=" + payUIKitConfig.revenueConfig.getAuthType());
        sb.append("&clientVersion=" + payUIKitConfig.revenueConfig.getVersion());
        sb.append("&sdkVersion=4.2.20-bdpay");
        int i2 = 0;
        ThemeColorConfig themeColorConfig = payUIKitConfig.themeColorConfig;
        if (themeColorConfig != null && themeColorConfig.getThemeResId().intValue() == g.PayUi_Yellow_Theme) {
            i2 = 1;
        }
        sb.append("&theme=" + i2);
        String token = payUIKitConfig.revenueConfig.getToken();
        if (payUIKitConfig.revenueConfig.getTokenCallback() != null) {
            token = payUIKitConfig.revenueConfig.getTokenCallback().onUpdateToken();
        }
        sb.append("&ticket=" + token);
        return sb.toString();
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
            return a(f72262d, payUIKitConfig);
        }
        return f72262d;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
            return a(f72261c, payUIKitConfig);
        }
        return f72261c;
    }

    public static String d(PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
            return f72260b;
        }
        return a(f72260b, payUIKitConfig);
    }

    public static void e(boolean z) {
        if (z) {
            f72260b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
            f72261c = "https://webtest.yy.com/yy_wallet/wallet.html?";
            f72262d = "https://webtest.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
            return;
        }
        f72260b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
        f72261c = "https://web.yy.com/yy_wallet/wallet.html?";
        f72262d = "https://web.yy.com/yy_wallet/pay-success.html?&orderId=${orderId}";
    }
}
