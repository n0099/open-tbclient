package com.repackage;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import com.repackage.il1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.repackage.dr2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0400a implements il1.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File[] a;

            public C0400a(a aVar, File[] fileArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, fileArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fileArr;
            }

            @Override // com.repackage.il1.a
            public void onResult(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && str.contains("success")) {
                    for (File file : this.a) {
                        xg4.L(file);
                    }
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                Bitmap p = le3.p();
                il1 u = bk2.u();
                u63.d().b();
                File[] c = u63.d().f().c();
                File b = bk2.i().b(AppRuntime.getAppContext(), u03.f0());
                if (c != null) {
                    int length = c.length;
                    fileArr = (File[]) Arrays.copyOf(c, length + 1);
                    fileArr[length] = b;
                } else {
                    fileArr = new File[]{b};
                }
                if (u != null) {
                    u.d(p, null, fileArr, new C0400a(this, fileArr));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755757875, "Lcom/repackage/dr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755757875, "Lcom/repackage/dr2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void a() {
        d02 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (V = hm2.U().V()) == null || V.m() == null) {
            return;
        }
        od3.k(new a(), "feedback error page");
    }

    public static Rect b(Bitmap bitmap, c02 c02Var, View view2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bitmap, c02Var, view2)) == null) {
            if (bitmap == null || c02Var == null || view2 == null) {
                return null;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int min = Math.min(iArr[0] + view2.getMeasuredWidth(), bitmap.getWidth());
            int min2 = Math.min(iArr[1] + view2.getMeasuredHeight(), bitmap.getHeight());
            SwanAppActionBar J1 = c02Var.J1();
            if (J1 == null) {
                return null;
            }
            int[] iArr2 = new int[2];
            J1.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + J1.getHeight() + 1);
            an1 n3 = c02Var.n3();
            if (n3 != null) {
                dn1 m = n3.m();
                if (m instanceof SwanAppWebViewWidget) {
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                    }
                    int P1 = ((SwanAppWebViewWidget) m).P1();
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + P1);
                    }
                    if (P1 > 0) {
                        iArr[1] = iArr[1] + P1 + 1;
                    }
                    if (a) {
                        Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
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

    public static int d(c02 c02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c02Var)) == null) {
            if (c02Var != null) {
                j13 F1 = c02Var.F1();
                if (F1 != null) {
                    return F1.e;
                }
                FrameLayout w3 = c02Var.w3();
                if (w3 != null) {
                    Drawable background = w3.getBackground();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (u03.L() != null) {
                    jSONObject.put("name", u03.L().Y());
                } else {
                    jSONObject.put("name", RomUtils.UNKNOWN);
                }
                jSONObject.put(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, bk2.o().z(AppRuntime.getAppContext()));
                jSONObject.put("net", SwanAppNetworkUtils.e());
                jSONObject.put("swaninfo", z93.e(t03.J().l()).toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static c02 f() {
        InterceptResult invokeV;
        d02 swanAppFragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null || (swanAppFragmentManager = activity.getSwanAppFragmentManager()) == null) {
                return null;
            }
            a02 m = swanAppFragmentManager.m();
            if (m instanceof c02) {
                return (c02) m;
            }
            return null;
        }
        return (c02) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        b03 floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            SwanAppActivity activity = hm2.U().getActivity();
            if (activity == null || (floatLayer = activity.getFloatLayer()) == null || !(floatLayer.d() instanceof FrameLayout)) {
                return false;
            }
            return ((FrameLayout) floatLayer.d()).getChildAt(0) instanceof LoadingView;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? hm2.U().getActivity().getFloatLayer().f() : invokeV.booleanValue;
    }

    public static void i(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65545, null, z, str) == null) {
            String f0 = u03.f0();
            Context activity = hm2.U().getActivity();
            if (activity == null) {
                activity = AppRuntime.getAppContext();
            }
            if (TextUtils.isEmpty(f0)) {
                return;
            }
            if (f0.lastIndexOf("_dev") > 0 || f0.lastIndexOf("_trial") > 0) {
                m03 f = m03.f(activity, R.string.obfuscated_res_0x7f0f01d2);
                f.l(5);
                f.q(3);
                f.G();
            }
            if (z) {
                u12 u12Var = new u12();
                u12Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                u12Var.d(str);
            }
        }
    }
}
