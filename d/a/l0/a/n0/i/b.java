package d.a.l0.a.n0.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import d.a.l0.a.f1.e.c;
import d.a.l0.a.j2.p.f;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43611a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static long f43612b;

    /* renamed from: c  reason: collision with root package name */
    public static String f43613c;

    /* renamed from: d  reason: collision with root package name */
    public static String f43614d;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Bundle f43615e;

        public a(Bundle bundle) {
            this.f43615e = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a aVar = (c.a) new c.a().r(this.f43615e);
            f fVar = new f();
            fVar.f43185a = d.a.l0.a.j2.k.m(0);
            fVar.f43186b = "launch";
            fVar.f43189e = "repeatlaunch";
            fVar.a("launchInterval", Long.valueOf(aVar.l("launch_interval", -1L)));
            fVar.j(aVar);
            fVar.d(aVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
            fVar.b(d.a.l0.a.j2.k.k(aVar.W()));
            d.a.l0.a.j2.k.onEvent(fVar);
        }
    }

    public static long a() {
        return System.currentTimeMillis() - f43612b;
    }

    public static boolean b(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - f43612b;
        boolean z = currentTimeMillis < 800 && TextUtils.equals(f43613c, str) && TextUtils.equals(f43614d, str2);
        if (f43611a && z) {
            Log.d("SeriesLaunchChecker", "CurrentLaunchInterval:" + currentTimeMillis + ",PreventSeriesLaunchInterval:800");
        }
        return z;
    }

    public static void c() {
        f43612b = System.currentTimeMillis();
    }

    public static void d(Bundle bundle) {
        ExecutorUtilsExt.postOnElastic(new a(bundle), "SeriesLaunchChecker", 3);
    }

    public static void e(String str, String str2) {
        f43613c = str;
        f43614d = str2;
    }
}
