package d.a.l0.a.n0.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.f1.e.c;
import d.a.l0.a.j2.p.f;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47287a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static long f47288b;

    /* renamed from: c  reason: collision with root package name */
    public static String f47289c;

    /* renamed from: d  reason: collision with root package name */
    public static String f47290d;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f47291e;

        public a(Bundle bundle) {
            this.f47291e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a aVar = (c.a) new c.a().r(this.f47291e);
            f fVar = new f();
            fVar.f46861a = d.a.l0.a.j2.k.m(0);
            fVar.f46862b = "launch";
            fVar.f46865e = "repeatlaunch";
            fVar.a("launchInterval", Long.valueOf(aVar.l("launch_interval", -1L)));
            fVar.j(aVar);
            fVar.d(aVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.l0.a.j2.k.k(aVar.W()));
            d.a.l0.a.j2.k.onEvent(fVar);
        }
    }

    public static long a() {
        return System.currentTimeMillis() - f47288b;
    }

    public static boolean b(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - f47288b;
        boolean z = currentTimeMillis < 800 && TextUtils.equals(f47289c, str) && TextUtils.equals(f47290d, str2);
        if (f47287a && z) {
            Log.d("SeriesLaunchChecker", "CurrentLaunchInterval:" + currentTimeMillis + ",PreventSeriesLaunchInterval:800");
        }
        return z;
    }

    public static void c() {
        f47288b = System.currentTimeMillis();
    }

    public static void d(Bundle bundle) {
        ExecutorUtilsExt.postOnElastic(new a(bundle), "SeriesLaunchChecker", 3);
    }

    public static void e(String str, String str2) {
        f47289c = str;
        f47290d = str2;
    }
}
