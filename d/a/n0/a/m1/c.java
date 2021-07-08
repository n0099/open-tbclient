package d.a.n0.a.m1;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.n0.a.h;
import d.a.n0.a.h0.i.g;
import d.a.n0.a.h0.i.i;
import d.a.n0.a.k;
import d.a.n0.a.p.d.e0;
import d.a.n0.a.v2.n0;
import d.a.n0.a.v2.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46086a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46087b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46088a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46089b;

        public a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46088a = str;
            this.f46089b = str2;
        }

        @Override // d.a.n0.a.h0.i.g.a
        public void a(@NonNull d.a.n0.a.h0.i.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                d.a.n0.a.h0.i.f.c(this.f46088a, gVar);
                boolean c0 = d.a.n0.a.h0.u.g.N().c0();
                long o = d.a.n0.a.c1.a.Z().o();
                if (o >= 6000 || c0) {
                    i.r(gVar);
                }
                i.i(d.a.n0.a.h0.i.c.c(this.f46089b, gVar, o, c0));
                i.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class a implements e0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File[] f46090a;

            public a(b bVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46090a = fileArr;
            }

            @Override // d.a.n0.a.p.d.e0.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.f46090a) {
                        d.a.n0.t.d.K(file);
                    }
                }
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap p = n0.p();
                e0 t = d.a.n0.a.c1.a.t();
                d.a.n0.a.i2.a.d().b();
                File[] c2 = d.a.n0.a.i2.a.d().f().c();
                File b2 = d.a.n0.a.c1.a.h().b(AppRuntime.getAppContext(), d.a.n0.a.a2.e.V());
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(711122829, "Ld/a/n0/a/m1/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(711122829, "Ld/a/n0/a/m1/c;");
                return;
            }
        }
        f46086a = k.f45831a;
        d.a.n0.a.c1.a.Z().getSwitch("swan_white_screent_webview_progress_bar_switch", false);
        f46087b = false;
    }

    public static void a() {
        d.a.n0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (W = d.a.n0.a.g1.f.V().W()) == null || W.m() == null) {
            return;
        }
        q.j(new b(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, d.a.n0.a.h0.g.f fVar, View view) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, fVar, view)) == null) {
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
            if (f46087b) {
                if (f46086a) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                d.a.n0.a.p.e.b b3 = fVar.b3();
                if (b3 != null) {
                    d.a.n0.a.p.e.e m = b3.m();
                    if (m instanceof SwanAppWebViewWidget) {
                        if (f46086a) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int J1 = ((SwanAppWebViewWidget) m).J1();
                        if (f46086a) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + J1);
                        }
                        if (J1 > 0) {
                            iArr[1] = iArr[1] + J1 + 1;
                        }
                        if (f46086a) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
                        }
                    }
                }
            }
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return (Rect) invokeLLL.objValue;
    }

    public static String c(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            if (bitmap == null) {
                return "";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        }
        return (String) invokeL.objValue;
    }

    public static int d(d.a.n0.a.h0.g.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            if (fVar != null) {
                d.a.n0.a.a2.n.g D1 = fVar.D1();
                if (D1 != null) {
                    return D1.f43428e;
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
        return invokeL.intValue;
    }

    public static JSONObject e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (d.a.n0.a.a2.e.i() != null) {
                    jSONObject.put("name", d.a.n0.a.a2.e.i().O());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, d.a.n0.a.c1.a.n().x(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", d.a.n0.a.m2.b.e(d.a.n0.a.a2.d.g().l()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static d.a.n0.a.h0.g.f f() {
        InterceptResult invokeV;
        d.a.n0.a.h0.g.g swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
            if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
                return null;
            }
            d.a.n0.a.h0.g.d m = swanAppFragmentManager.m();
            if (m instanceof d.a.n0.a.h0.g.f) {
                return (d.a.n0.a.h0.g.f) m;
            }
            return null;
        }
        return (d.a.n0.a.h0.g.f) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        d.a.n0.a.z1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
            if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.e() instanceof FrameLayout)) {
                return false;
            }
            return ((FrameLayout) floatLayer.e()).getChildAt(0) instanceof LoadingView;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.a.n0.a.g1.f.V().getActivity().getFloatLayer().f() : invokeV.booleanValue;
    }

    public static void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            String V = d.a.n0.a.a2.e.V();
            Context activity = d.a.n0.a.g1.f.V().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (TextUtils.isEmpty(V)) {
                return;
            }
            if (V.lastIndexOf("_dev") > 0 || V.lastIndexOf("_trial") > 0) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(activity, h.aiapps_swan_app_error_page_hint);
                f2.l(5);
                f2.p(3);
                f2.F();
            }
            if (z) {
                j("whiteScreen_L1", "检测到纯白屏；");
            }
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            i.d(new a(str, str2));
        }
    }
}
