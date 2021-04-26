package d.a.h0.a.b0;

import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        return "https://gamecenter.baidu.com";
    }

    public static String b() {
        return String.format("%s/smtapp/ad/auto", d());
    }

    public static String c() {
        return String.format("%s/smtapp/ad/similar", d());
    }

    public static String d() {
        return BaseUrlManager.ONLINE_URL;
    }

    public static String e() {
        return String.format("%s/searchbox?action=userx&type=attribute", d());
    }
}
