package d.a.l0.a.m1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.l0.a.h;
import d.a.l0.a.h0.i.g;
import d.a.l0.a.h0.i.i;
import d.a.l0.a.k;
import d.a.l0.a.p.d.e0;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47130a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47131b;

    /* loaded from: classes3.dex */
    public static class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47132a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f47133b;

        public a(String str, String str2) {
            this.f47132a = str;
            this.f47133b = str2;
        }

        @Override // d.a.l0.a.h0.i.g.a
        public void a(@NonNull d.a.l0.a.h0.i.g gVar) {
            d.a.l0.a.h0.i.f.c(this.f47132a, gVar);
            boolean c0 = d.a.l0.a.h0.u.g.N().c0();
            long o = d.a.l0.a.c1.a.Z().o();
            if (o >= 6000 || c0) {
                i.r(gVar);
            }
            i.i(d.a.l0.a.h0.i.c.c(this.f47133b, gVar, o, c0));
            i.k();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* loaded from: classes3.dex */
        public class a implements e0.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File[] f47134a;

            public a(b bVar, File[] fileArr) {
                this.f47134a = fileArr;
            }

            @Override // d.a.l0.a.p.d.e0.a
            public void onResult(String str) {
                if (str == null || !str.contains("success")) {
                    return;
                }
                for (File file : this.f47134a) {
                    d.a.l0.t.d.K(file);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Bitmap p = n0.p();
            e0 t = d.a.l0.a.c1.a.t();
            d.a.l0.a.i2.a.d().b();
            File[] c2 = d.a.l0.a.i2.a.d().f().c();
            File b2 = d.a.l0.a.c1.a.h().b(AppRuntime.getAppContext(), d.a.l0.a.a2.e.V());
            if (c2 != null) {
                int length = c2.length;
                fileArr = (File[]) Arrays.copyOf(c2, length + 1);
                fileArr[length] = b2;
            } else {
                fileArr = new File[]{b2};
            }
            if (t != null) {
                t.d(p, null, fileArr, new a(this, fileArr));
            }
        }
    }

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_white_screent_webview_progress_bar_switch", false);
        f47131b = false;
    }

    public static void a() {
        d.a.l0.a.h0.g.g W = d.a.l0.a.g1.f.V().W();
        if (W == null || W.m() == null) {
            return;
        }
        q.j(new b(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, d.a.l0.a.h0.g.f fVar, View view) {
        if (bitmap == null || fVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar H1 = fVar.H1();
        if (H1 == null) {
            return null;
        }
        int[] iArr2 = new int[2];
        H1.getLocationOnScreen(iArr2);
        iArr[1] = Math.max(iArr[1], iArr2[1] + H1.getHeight() + 1);
        if (f47131b) {
            if (f47130a) {
                Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
            }
            d.a.l0.a.p.e.b b3 = fVar.b3();
            if (b3 != null) {
                d.a.l0.a.p.e.e m = b3.m();
                if (m instanceof SwanAppWebViewWidget) {
                    if (f47130a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int J1 = ((SwanAppWebViewWidget) m).J1();
                    if (f47130a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + J1);
                    }
                    if (J1 > 0) {
                        iArr[1] = iArr[1] + J1 + 1;
                    }
                    if (f47130a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
                    }
                }
            }
        }
        return new Rect(iArr[0], iArr[1], min, min2);
    }

    public static String c(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static int d(d.a.l0.a.h0.g.f fVar) {
        if (fVar != null) {
            d.a.l0.a.a2.n.g D1 = fVar.D1();
            if (D1 != null) {
                return D1.f44472e;
            }
            FrameLayout k3 = fVar.k3();
            if (k3 != null) {
                Drawable background = k3.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public static JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.a.l0.a.a2.e.i() != null) {
                jSONObject.put("name", d.a.l0.a.a2.e.i().O());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, d.a.l0.a.c1.a.n().x(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.e());
            jSONObject.put("swaninfo", d.a.l0.a.m2.b.e(d.a.l0.a.a2.d.g().l()).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static d.a.l0.a.h0.g.f f() {
        d.a.l0.a.h0.g.g swanAppFragmentManager;
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
            return null;
        }
        d.a.l0.a.h0.g.d m = swanAppFragmentManager.m();
        if (m instanceof d.a.l0.a.h0.g.f) {
            return (d.a.l0.a.h0.g.f) m;
        }
        return null;
    }

    public static boolean g() {
        d.a.l0.a.z1.b.c.a floatLayer;
        SwanAppActivity activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.e() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView;
    }

    public static boolean h() {
        return d.a.l0.a.g1.f.V().getActivity().getFloatLayer().f();
    }

    public static void i(boolean z) {
        String V = d.a.l0.a.a2.e.V();
        Context activity = d.a.l0.a.g1.f.V().getActivity();
        if (activity == null) {
            activity = AppRuntime.getAppContext();
        }
        if (TextUtils.isEmpty(V)) {
            return;
        }
        if (V.lastIndexOf("_dev") > 0 || V.lastIndexOf("_trial") > 0) {
            d.a.l0.a.z1.b.f.e f2 = d.a.l0.a.z1.b.f.e.f(activity, h.aiapps_swan_app_error_page_hint);
            f2.l(5);
            f2.p(3);
            f2.F();
        }
        if (z) {
            j("whiteScreen_L1", "检测到纯白屏；");
        }
    }

    public static void j(String str, String str2) {
        i.d(new a(str, str2));
    }
}
