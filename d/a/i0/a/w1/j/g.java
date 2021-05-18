package d.a.i0.a.w1.j;

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
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45456a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f45458b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f45459c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.i1.d.d.c f45460d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f45461e;

        public a(int i2, boolean z, Activity activity, d.a.i0.a.i1.d.d.c cVar, Context context) {
            this.f45457a = i2;
            this.f45458b = z;
            this.f45459c = activity;
            this.f45460d = cVar;
            this.f45461e = context;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("swanAppId", d.a.i0.a.a2.e.V());
            bundle.putInt("count", this.f45457a);
            bundle.putBoolean("compressed", this.f45458b);
            bundle.putString("launchType", "Image");
            bundle.putString("swanTmpPath", d.a.i0.a.g1.f.V().I().k());
            d.a.i0.a.i1.d.c.d.l(this.f45459c, bundle, this.f45460d);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            if (g.f45456a) {
                Log.i(ViewUtil.TAG, str + "");
            }
            Toast.makeText(this.f45461e, str, 1).show();
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
            if (f45456a) {
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
        if (f45456a) {
            Log.d(ViewUtil.TAG, "refreshHeight, originalHeight: " + view.getHeight() + ", aimHeight: " + i2);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
        } else {
            layoutParams.height = i2;
            view.requestLayout();
        }
        if (f45456a) {
            Log.d(ViewUtil.TAG, "refreshHeight, newHeight: " + view.getHeight());
            return true;
        }
        return true;
    }

    public static void h(@NonNull Context context, @StringRes int i2) {
        d.a.i0.a.z1.b.f.e.f(context, i2).F();
    }

    public static void i(int i2, d.a.i0.a.i1.d.d.c cVar) {
        j(i2, false, cVar);
    }

    public static void j(int i2, boolean z, d.a.i0.a.i1.d.d.c cVar) {
        Context appContext = AppRuntime.getAppContext();
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        SwanAppActivity x = Q.x();
        d.a.i0.a.s1.e.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, 3, x, new a(i2, z, x, cVar, appContext));
    }
}
