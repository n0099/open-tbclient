package d.a.i0.a.d0;

import android.annotation.SuppressLint;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
/* loaded from: classes2.dex */
public class a {
    @SuppressLint({"BDOfflineUrl"})
    public static String a() {
        return "https://gamecenter.baidu.com";
    }

    public static String b() {
        return d.a.i0.a.r1.l.b.m() ? "https://minipro.baidu.com" : BaseUrlManager.ONLINE_URL;
    }

    public static String c() {
        return BaseUrlManager.ONLINE_URL;
    }

    @Deprecated
    public static String d() {
        return "https://minipro.baidu.com";
    }
}
