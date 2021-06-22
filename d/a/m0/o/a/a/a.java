package d.a.m0.o.a.a;

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
import d.a.m0.o.a.a.b;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends d.a.m0.o.a.b.a {

    /* renamed from: d.a.m0.o.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1138a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String[] f51971e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f51972f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f51973g;

        public RunnableC1138a(String[] strArr, Activity activity, int i2) {
            this.f51971e = strArr;
            this.f51972f = activity;
            this.f51973g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f51971e.length];
            PackageManager packageManager = this.f51972f.getPackageManager();
            String packageName = this.f51972f.getPackageName();
            int length = this.f51971e.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.f51971e[i2], packageName);
            }
            ((b) this.f51972f).onRequestPermissionsResult(this.f51973g, this.f51971e, iArr);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes3.dex */
    public static class c extends b.a {

        /* renamed from: a  reason: collision with root package name */
        public s f51974a;

        public c(s sVar) {
            this.f51974a = sVar;
        }

        @Override // d.a.m0.o.a.a.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            return this.f51974a.a(view, matrix, rectF);
        }

        @Override // d.a.m0.o.a.a.b.a
        public View b(Context context, Parcelable parcelable) {
            return this.f51974a.b(context, parcelable);
        }

        @Override // d.a.m0.o.a.a.b.a
        public void c(List<String> list, Map<String, View> map) {
            this.f51974a.c(list, map);
        }

        @Override // d.a.m0.o.a.a.b.a
        public void d(List<View> list) {
            this.f51974a.d(list);
        }

        @Override // d.a.m0.o.a.a.b.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            this.f51974a.e(list, list2, list3);
        }

        @Override // d.a.m0.o.a.a.b.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            this.f51974a.f(list, list2, list3);
        }
    }

    public static b.a e(s sVar) {
        if (sVar != null) {
            return new c(sVar);
        }
        return null;
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.m0.o.a.a.b.b(activity);
        } else {
            activity.finish();
        }
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.m0.o.a.a.b.c(activity);
        }
    }

    public static void h(@NonNull Activity activity, @NonNull String[] strArr, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            d.a.m0.o.a.a.c.a(activity, strArr, i2);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new RunnableC1138a(strArr, activity, i2));
        }
    }

    public static void i(Activity activity, s sVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.m0.o.a.a.b.d(activity, e(sVar));
        }
    }

    public static void j(Activity activity, s sVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.m0.o.a.a.b.e(activity, e(sVar));
        }
    }

    public static boolean k(@NonNull Activity activity, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a.m0.o.a.a.c.b(activity, str);
        }
        return false;
    }

    public static void l(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a.m0.o.a.a.b.f(activity);
        }
    }
}
