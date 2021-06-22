package d.a.m0.a.w1.j;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.utils.ViewUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.publisher.view.SPSwitchRootLinearLayout;
import com.google.protobuf.CodedInputStream;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49414a = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f49415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f49416b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f49417c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.i1.d.d.c f49418d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49419e;

        public a(int i2, boolean z, Activity activity, d.a.m0.a.i1.d.d.c cVar, Context context) {
            this.f49415a = i2;
            this.f49416b = z;
            this.f49417c = activity;
            this.f49418d = cVar;
            this.f49419e = context;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("swanAppId", d.a.m0.a.a2.e.V());
            bundle.putInt("count", this.f49415a);
            bundle.putBoolean("compressed", this.f49416b);
            bundle.putString("launchType", "Image");
            bundle.putString("swanTmpPath", d.a.m0.a.g1.f.V().I().k());
            d.a.m0.a.i1.d.c.d.l(this.f49417c, bundle, this.f49418d);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            if (g.f49414a) {
                Log.i(ViewUtil.TAG, str + "");
            }
            Toast.makeText(this.f49419e, str, 1).show();
        }
    }

    public static View b(View view) {
        View view2 = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof SPSwitchRootLinearLayout) {
                    view2 = childAt;
                }
                if (view2 != null) {
                    break;
                }
                view2 = b(childAt);
            }
        }
        return view2;
    }

    public static boolean c(Activity activity) {
        View b2 = b(activity.getWindow().getDecorView());
        if (b2 == null) {
            if (f49414a) {
                Log.d(ViewUtil.TAG, "#isFitsSystemWindows#, getSPSRootLayout is NULL");
                return false;
            }
            return false;
        }
        return b2.getFitsSystemWindows();
    }

    public static boolean d(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static boolean e(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0;
    }

    public static boolean f(Activity activity) {
        return (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0;
    }

    public static boolean g(View view, int i2) {
        if (view.getHeight() == i2) {
            return false;
        }
        if (f49414a) {
            Log.d(ViewUtil.TAG, "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
        } else {
            layoutParams.height = i2;
            view.requestLayout();
        }
        if (f49414a) {
            Log.d(ViewUtil.TAG, "refreshHeight, newHeight: " + view.getHeight());
            return true;
        }
        return true;
    }

    public static void h(@NonNull Context context, @StringRes int i2) {
        d.a.m0.a.z1.b.f.e.f(context, i2).F();
    }

    public static void i(int i2, d.a.m0.a.i1.d.d.c cVar) {
        j(i2, false, cVar);
    }

    public static void j(int i2, boolean z, d.a.m0.a.i1.d.d.c cVar) {
        Context appContext = AppRuntime.getAppContext();
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        SwanAppActivity x = Q.x();
        d.a.m0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, x, new a(i2, z, x, cVar, appContext));
    }
}
