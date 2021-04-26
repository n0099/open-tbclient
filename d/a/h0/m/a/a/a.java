package d.a.h0.m.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import d.a.h0.m.a.a.b;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends d.a.h0.m.a.b.a {

    /* renamed from: d.a.h0.m.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0994a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String[] f47298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f47299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47300g;

        public RunnableC0994a(String[] strArr, Activity activity, int i2) {
            this.f47298e = strArr;
            this.f47299f = activity;
            this.f47300g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f47298e.length];
            PackageManager packageManager = this.f47299f.getPackageManager();
            String packageName = this.f47299f.getPackageName();
            int length = this.f47298e.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f47298e[i2], packageName);
            }
            ((b) this.f47299f).onRequestPermissionsResult(this.f47300g, this.f47298e, iArr);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes3.dex */
    public static class c extends b.a {

        /* renamed from: a  reason: collision with root package name */
        public r f47301a;

        public c(r rVar) {
            this.f47301a = rVar;
        }

        @Override // d.a.h0.m.a.a.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            return this.f47301a.a(view, matrix, rectF);
        }

        @Override // d.a.h0.m.a.a.b.a
        public View b(Context context, Parcelable parcelable) {
            return this.f47301a.b(context, parcelable);
        }

        @Override // d.a.h0.m.a.a.b.a
        public void c(List<String> list, Map<String, View> map) {
            this.f47301a.c(list, map);
        }

        @Override // d.a.h0.m.a.a.b.a
        public void d(List<View> list) {
            this.f47301a.d(list);
        }

        @Override // d.a.h0.m.a.a.b.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            this.f47301a.e(list, list2, list3);
        }

        @Override // d.a.h0.m.a.a.b.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            this.f47301a.f(list, list2, list3);
        }
    }

    public static b.a e(r rVar) {
        if (rVar != null) {
            return new c(rVar);
        }
        return null;
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.h0.m.a.a.b.b(activity);
        } else {
            activity.finish();
        }
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.h0.m.a.a.b.c(activity);
        }
    }

    public static void h(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            d.a.h0.m.a.a.c.a(activity, strArr, i2);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0994a(strArr, activity, i2));
        }
    }

    public static void i(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.h0.m.a.a.b.d(activity, e(rVar));
        }
    }

    public static void j(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.h0.m.a.a.b.e(activity, e(rVar));
        }
    }

    public static void k(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.h0.m.a.a.b.f(activity);
        }
    }
}
