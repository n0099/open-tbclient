package d.a.n0.t2.i0;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import d.a.n0.e3.h0.o;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f61152a;

    public static void a(c cVar, int i2) {
        cVar.i(SDKLogTypeConstants.CLOSE_GAME_TYPE);
        boolean z = i2 == 1000;
        cVar.c(z ? "APP" : "URL");
        if (!z) {
            cVar.l(i2);
        }
        cVar.h("DEEPLINK");
    }

    public static String b(HashMap hashMap) {
        String valueOf = hashMap != null ? String.valueOf(hashMap.get("da_area")) : null;
        return TextUtils.isEmpty(valueOf) ? "hotarea" : valueOf;
    }

    public static String c() {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "GET_PROCESS_NAME_FAIL";
        } catch (Exception unused) {
            return "GET_PROCESS_NAME_FAIL";
        }
    }

    public static void d(AdvertAppInfo advertAppInfo, int i2) {
        e(advertAppInfo, 0, "", i2);
    }

    public static void e(AdvertAppInfo advertAppInfo, int i2, String str, int i3) {
        c b2 = g.b(advertAppInfo, 2, i2);
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        b2.c(str);
        e.b().d(b2);
        a(b2, i3);
        e.b().d(b2);
    }

    public static void f(AdvertAppInfo advertAppInfo, int i2, HashMap hashMap, int i3) {
        e(advertAppInfo, i2, b(hashMap), i3);
    }

    public static void g(AdvertAppInfo advertAppInfo, int i2, int i3) {
        h(advertAppInfo, i2, i3, BannerFocusImageViewGroup.f23593f, BannerFocusImageViewGroup.f23593f);
    }

    public static void h(AdvertAppInfo advertAppInfo, int i2, int i3, int i4, int i5) {
        int i6;
        if (advertAppInfo == null || (i6 = advertAppInfo.I3) == 1001 || i6 == -1001) {
            return;
        }
        c h2 = g.h(advertAppInfo, 5, i2, i3);
        if (i4 != -999) {
            h2.l(i4);
        }
        if (i5 != -999) {
            h2.m(i5);
        }
        if (i3 == 31) {
            if (TextUtils.isEmpty(f61152a)) {
                f61152a = c();
            }
            h2.q(f61152a);
        }
        e.b().d(h2);
    }

    public static void i(o oVar, int i2) {
        j(oVar, i2, BannerFocusImageViewGroup.f23593f, BannerFocusImageViewGroup.f23593f);
    }

    public static void j(o oVar, int i2, int i3, int i4) {
        if (oVar == null || oVar.getAdvertAppInfo() == null || oVar.getAdvertAppInfo().I3 == 1001 || oVar.getAdvertAppInfo().I3 == -1001) {
            return;
        }
        c e2 = g.e(oVar, 5);
        e2.j(i2);
        if (i3 != -999) {
            e2.l(i3);
        }
        if (i4 != -999) {
            e2.m(i4);
        }
        e.b().d(e2);
    }

    public static void k(AdvertAppInfo advertAppInfo) {
        e.b().d(g.b(advertAppInfo, 7, 0));
    }

    public static void l(AdvertAppInfo advertAppInfo) {
        m(advertAppInfo, 0, "", "", "");
    }

    public static void m(AdvertAppInfo advertAppInfo, int i2, String str, String str2, String str3) {
        c c2 = g.c(advertAppInfo, 2, i2);
        c2.u(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "hotarea";
        }
        c2.c(str3);
        e.b().d(c2);
    }

    public static void n(AdvertAppInfo advertAppInfo, int i2, String str, String str2, HashMap hashMap) {
        m(advertAppInfo, i2, str, str2, b(hashMap));
    }

    public static void o(AdvertAppInfo advertAppInfo) {
        e.b().d(g.b(advertAppInfo, 3, 0));
    }
}
