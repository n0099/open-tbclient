package d.b.g0.a.f1;

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
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.g0.a.h;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.p.c.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44412a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44413b;

    /* loaded from: classes3.dex */
    public static class a implements SwanAppNetworkUtils.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44414a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44415b;

        public a(String str, String str2) {
            this.f44414a = str;
            this.f44415b = str2;
        }

        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i) {
            if (i == 1) {
                d.b.g0.a.e0.f.d(this.f44414a + "; 网络：正常");
                d.b.g0.a.e0.d.c("white_screen", this.f44415b, FrsActivityConfig.GOOD);
                d.b.g0.a.e0.c.f(h.swanapp_tip_load_fail);
            } else if (i == 2) {
                d.b.g0.a.e0.f.d(this.f44414a + "; 网络：较差");
                d.b.g0.a.e0.d.c("white_screen", this.f44415b, "bad");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            } else if (i != 3) {
                d.b.g0.a.e0.f.d(this.f44414a + "; 网络：未知");
                d.b.g0.a.e0.d.c("white_screen", this.f44415b, "unknown");
                d.b.g0.a.e0.c.f(h.swanapp_tip_load_fail);
            } else {
                d.b.g0.a.e0.f.d(this.f44414a + "; 网络：离线");
                d.b.g0.a.e0.d.c("white_screen", this.f44415b, "offline");
                d.b.g0.a.e0.c.f(h.swanapp_tip_net_unavailable);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* loaded from: classes3.dex */
        public class a implements w.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File[] f44416a;

            public a(b bVar, File[] fileArr) {
                this.f44416a = fileArr;
            }

            @Override // d.b.g0.a.p.c.w.a
            public void onResult(String str) {
                if (str == null || !str.contains("success")) {
                    return;
                }
                for (File file : this.f44416a) {
                    d.b.g0.p.d.w(file);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Bitmap n = h0.n();
            w q = d.b.g0.a.w0.a.q();
            d.b.g0.a.y1.a.d().b();
            File[] c2 = d.b.g0.a.y1.a.d().f().c();
            File c3 = d.b.g0.a.w0.a.g().c(AppRuntime.getAppContext(), d.b.g0.a.r1.e.T());
            if (c2 != null) {
                int length = c2.length;
                fileArr = (File[]) Arrays.copyOf(c2, length + 1);
                fileArr[length] = c3;
            } else {
                fileArr = new File[]{c3};
            }
            if (q != null) {
                q.d(n, null, fileArr, new a(this, fileArr));
            }
        }
    }

    static {
        d.b.g0.a.w0.a.N().getSwitch("swan_white_screent_webview_progress_bar_switch", false);
        f44413b = false;
    }

    public static void a() {
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null || W.m() == null) {
            return;
        }
        p.k(new b(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, d.b.g0.a.e0.l.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar D1 = eVar.D1();
        if (D1 == null) {
            return null;
        }
        int[] iArr2 = new int[2];
        D1.getLocationOnScreen(iArr2);
        iArr[1] = Math.max(iArr[1], iArr2[1] + D1.getHeight() + 1);
        if (f44413b) {
            if (f44412a) {
                Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
            }
            d.b.g0.a.p.d.b T2 = eVar.T2();
            if (T2 != null) {
                d.b.g0.a.p.d.e n = T2.n();
                if (n instanceof SwanAppWebViewWidget) {
                    if (f44412a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int y1 = ((SwanAppWebViewWidget) n).y1();
                    if (f44412a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + y1);
                    }
                    if (y1 > 0) {
                        iArr[1] = iArr[1] + y1 + 1;
                    }
                    if (f44412a) {
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

    public static int d(d.b.g0.a.e0.l.e eVar) {
        if (eVar != null) {
            d.b.g0.a.r1.n.c y1 = eVar.y1();
            if (y1 != null) {
                return y1.f45774e;
            }
            FrameLayout b3 = eVar.b3();
            if (b3 != null) {
                Drawable background = b3.getBackground();
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
            if (d.b.g0.a.r1.e.y() != null) {
                jSONObject.put("name", d.b.g0.a.r1.e.y().M());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, d.b.g0.a.w0.a.l().i(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.e());
            jSONObject.put("swaninfo", d.b.g0.a.b2.b.d(d.b.g0.a.r1.d.e().h()).toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static d.b.g0.a.e0.l.e f() {
        d.b.g0.a.e0.l.f swanAppFragmentManager;
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
            return null;
        }
        d.b.g0.a.e0.l.c m = swanAppFragmentManager.m();
        if (m instanceof d.b.g0.a.e0.l.e) {
            return (d.b.g0.a.e0.l.e) m;
        }
        return null;
    }

    public static boolean g() {
        d.b.g0.a.q1.b.c.a floatLayer;
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.e() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView;
    }

    public static boolean h() {
        return d.b.g0.a.z0.f.V().getActivity().getFloatLayer().f();
    }

    public static void i(boolean z) {
        String T = d.b.g0.a.r1.e.T();
        Context activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null) {
            activity = AppRuntime.getAppContext();
        }
        if (TextUtils.isEmpty(T)) {
            return;
        }
        if (T.lastIndexOf("_dev") <= 0 && T.lastIndexOf("_trial") <= 0) {
            if (z) {
                j("whiteScreen_L1", "检测到纯白屏");
                return;
            }
            return;
        }
        d.b.g0.a.q1.b.f.d e2 = d.b.g0.a.q1.b.f.d.e(activity, h.aiapps_swan_app_error_page_hint);
        e2.k(5);
        e2.o(3);
        e2.C();
    }

    public static void j(String str, String str2) {
        d.b.g0.a.e0.f.b(new a(str2, str));
    }
}
