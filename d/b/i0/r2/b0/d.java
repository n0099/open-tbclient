package d.b.i0.r2.b0;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.b.i0.c3.h0.o;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f59766a;

    public static void a(c cVar, int i) {
        cVar.j(706);
        boolean z = i == 1000;
        cVar.c(z ? "APP" : "URL");
        if (!z) {
            cVar.l(i);
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

    public static void d(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        c b2 = h.b(advertAppInfo, 2, i);
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        b2.c(str);
        e.b().d(b2);
        a(b2, i2);
        e.b().d(b2);
    }

    public static void e(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        d(advertAppInfo, i, b(hashMap), i2);
    }

    public static void f(AdvertAppInfo advertAppInfo, int i, int i2) {
        g(advertAppInfo, i, i2, -999, -999);
    }

    public static void g(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        AdvertAppInfo.a aVar;
        int i5;
        if (advertAppInfo == null || (aVar = advertAppInfo.U3) == null || (i5 = aVar.f13210h) == 1001 || i5 == -1001) {
            return;
        }
        c h2 = h.h(advertAppInfo, 5, i, i2);
        if (i3 != -999) {
            h2.l(i3);
        }
        if (i4 != -999) {
            h2.m(i4);
        }
        if (i2 == 31) {
            if (TextUtils.isEmpty(f59766a)) {
                f59766a = c();
            }
            h2.p(f59766a);
        }
        e.b().d(h2);
        AppData appData = advertAppInfo.e4;
        if (appData != null) {
            appData.mDiscardReason = 2;
        }
    }

    public static void h(o oVar, int i) {
        i(oVar, i, -999, -999);
    }

    public static void i(o oVar, int i, int i2, int i3) {
        if (oVar == null || oVar.B0() == null || oVar.B0().goods == null || oVar.B0().goods.goods_style == 1001 || oVar.B0().goods.goods_style == -1001) {
            return;
        }
        c e2 = h.e(oVar, 5);
        e2.k(i);
        if (i2 != -999) {
            e2.l(i2);
        }
        if (i3 != -999) {
            e2.m(i3);
        }
        e.b().d(e2);
        if (oVar == null || oVar.B0() == null) {
            return;
        }
        oVar.B0().mDiscardReason = i;
    }

    public static void j(AdvertAppInfo advertAppInfo, int i, String str, String str2, String str3) {
        d.b.h0.u.a.l().u(advertAppInfo, str, 0L, advertAppInfo.c4, PrefetchEvent.STATE_CLICK, i);
        c c2 = h.c(advertAppInfo, 2, i);
        c2.t(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "hotarea";
        }
        c2.c(str3);
        e.b().d(c2);
    }

    public static void k(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        j(advertAppInfo, i, str, str2, b(hashMap));
    }
}
