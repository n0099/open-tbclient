package d.b.h0.m.a.a;

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
import d.b.h0.m.a.a.b;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends d.b.h0.m.a.b.a {

    /* renamed from: d.b.h0.m.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC1055a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String[] f49784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Activity f49785f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f49786g;

        public RunnableC1055a(String[] strArr, Activity activity, int i) {
            this.f49784e = strArr;
            this.f49785f = activity;
            this.f49786g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f49784e.length];
            PackageManager packageManager = this.f49785f.getPackageManager();
            String packageName = this.f49785f.getPackageName();
            int length = this.f49784e.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f49784e[i], packageName);
            }
            ((b) this.f49785f).onRequestPermissionsResult(this.f49786g, this.f49784e, iArr);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* loaded from: classes3.dex */
    public static class c extends b.a {

        /* renamed from: a  reason: collision with root package name */
        public r f49787a;

        public c(r rVar) {
            this.f49787a = rVar;
        }

        @Override // d.b.h0.m.a.a.b.a
        public Parcelable a(View view, Matrix matrix, RectF rectF) {
            return this.f49787a.a(view, matrix, rectF);
        }

        @Override // d.b.h0.m.a.a.b.a
        public View b(Context context, Parcelable parcelable) {
            return this.f49787a.b(context, parcelable);
        }

        @Override // d.b.h0.m.a.a.b.a
        public void c(List<String> list, Map<String, View> map) {
            this.f49787a.c(list, map);
        }

        @Override // d.b.h0.m.a.a.b.a
        public void d(List<View> list) {
            this.f49787a.d(list);
        }

        @Override // d.b.h0.m.a.a.b.a
        public void e(List<String> list, List<View> list2, List<View> list3) {
            this.f49787a.e(list, list2, list3);
        }

        @Override // d.b.h0.m.a.a.b.a
        public void f(List<String> list, List<View> list2, List<View> list3) {
            this.f49787a.f(list, list2, list3);
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
            d.b.h0.m.a.a.b.b(activity);
        } else {
            activity.finish();
        }
    }

    public static void g(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.b.h0.m.a.a.b.c(activity);
        }
    }

    public static void h(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            d.b.h0.m.a.a.c.a(activity, strArr, i);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new RunnableC1055a(strArr, activity, i));
        }
    }

    public static void i(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.b.h0.m.a.a.b.d(activity, e(rVar));
        }
    }

    public static void j(Activity activity, r rVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.b.h0.m.a.a.b.e(activity, e(rVar));
        }
    }

    public static void k(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.b.h0.m.a.a.b.f(activity);
        }
    }
}
