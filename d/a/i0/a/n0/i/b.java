package d.a.i0.a.n0.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.i0.a.f1.e.c;
import d.a.i0.a.j2.p.f;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43437a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static long f43438b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43439c;

    /* renamed from: d  reason: collision with root package name */
    public static String f43440d;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f43441e;

        public a(Bundle bundle) {
            this.f43441e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a aVar = (c.a) new c.a().r(this.f43441e);
            f fVar = new f();
            fVar.f43011a = d.a.i0.a.j2.k.m(0);
            fVar.f43012b = "launch";
            fVar.f43015e = "repeatlaunch";
            fVar.a("launchInterval", Long.valueOf(aVar.l("launch_interval", -1L)));
            fVar.j(aVar);
            fVar.d(aVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.i0.a.j2.k.k(aVar.W()));
            d.a.i0.a.j2.k.onEvent(fVar);
        }
    }

    public static long a() {
        return System.currentTimeMillis() - f43438b;
    }

    public static boolean b(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - f43438b;
        boolean z = currentTimeMillis < 800 && TextUtils.equals(f43439c, str) && TextUtils.equals(f43440d, str2);
        if (f43437a && z) {
            Log.d("SeriesLaunchChecker", "CurrentLaunchInterval:" + currentTimeMillis + ",PreventSeriesLaunchInterval:800");
        }
        return z;
    }

    public static void c() {
        f43438b = System.currentTimeMillis();
    }

    public static void d(Bundle bundle) {
        ExecutorUtilsExt.postOnElastic(new a(bundle), "SeriesLaunchChecker", 3);
    }

    public static void e(String str, String str2) {
        f43439c = str;
        f43440d = str2;
    }
}
