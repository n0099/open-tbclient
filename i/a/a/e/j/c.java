package i.a.a.e.j;

import d.r.b.a.a.i.c.h;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static h f68874a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f68875b = "https://web.yy.com/yy_wallet/pay-protocol.html?";

    /* renamed from: c  reason: collision with root package name */
    public static String f68876c = "https://web.yy.com/yy_wallet/wallet.html?";

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
        String token = payUIKitConfig.revenueConfig.getToken();
        if (payUIKitConfig.revenueConfig.getTokenCallback() != null) {
            token = payUIKitConfig.revenueConfig.getTokenCallback().onUpdateToken();
        }
        sb.append("&ticket=" + token);
        return sb.toString();
    }

    public static String b(PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
            return a(f68876c, payUIKitConfig);
        }
        return f68876c;
    }

    public static String c(PayUIKitConfig payUIKitConfig) {
        if (payUIKitConfig == null && payUIKitConfig.revenueConfig == null) {
            return f68875b;
        }
        return a(f68875b, payUIKitConfig);
    }

    public static void d(boolean z) {
        if (z) {
            f68875b = "https://webtest.yy.com/yy_wallet/pay-protocol.html?";
            f68876c = "https://webtest.yy.com/yy_wallet/wallet.html?";
            return;
        }
        f68875b = "https://web.yy.com/yy_wallet/pay-protocol.html?";
        f68876c = "https://web.yy.com/yy_wallet/wallet.html?";
    }
}
