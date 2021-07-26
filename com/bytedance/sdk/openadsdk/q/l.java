package com.bytedance.sdk.openadsdk.q;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statusbar.ImmersiveOSUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f32515a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f32516b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final CharSequence f32517c;

    /* renamed from: d  reason: collision with root package name */
    public static final CharSequence f32518d;

    /* renamed from: e  reason: collision with root package name */
    public static final CharSequence f32519e;

    /* renamed from: f  reason: collision with root package name */
    public static String f32520f = null;

    /* renamed from: g  reason: collision with root package name */
    public static int f32521g = Integer.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Callable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f32523a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32523a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String c2 = l.c(this.f32523a);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.bytedance.sdk.component.utils.k.b("RomUtils", "property:" + c2 + ",getSystemProperty use time :" + currentTimeMillis2);
                if (!TextUtils.isEmpty(c2)) {
                    try {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            com.bytedance.sdk.component.utils.k.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + c2);
                            com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", c2);
                        } else {
                            com.bytedance.sdk.component.utils.k.d("RomUtils", "SP-getPropertyFromSP:" + c2);
                            u.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).a("rom_property_info", c2);
                        }
                    } catch (Throwable unused) {
                    }
                }
                return c2;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98109634, "Lcom/bytedance/sdk/openadsdk/q/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98109634, "Lcom/bytedance/sdk/openadsdk/q/l;");
                return;
            }
        }
        f32517c = "sony";
        f32518d = "amigo";
        f32519e = "funtouch";
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!TextUtils.isEmpty(f32520f)) {
                return f32520f;
            }
            String a2 = com.bytedance.sdk.openadsdk.core.h.a("sdk_local_rom_info", 604800000L);
            f32520f = a2;
            if (TextUtils.isEmpty(a2)) {
                String u = u();
                f32520f = u;
                com.bytedance.sdk.openadsdk.core.h.a("sdk_local_rom_info", u);
            }
            return f32520f;
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return d("ro.build.uiversion") + "_" + Build.DISPLAY;
        }
        return (String) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = Build.MANUFACTURER + Build.BRAND;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            return lowerCase.contains("360") || lowerCase.contains("qiku");
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (!f32516b) {
                try {
                    if (Class.forName("miui.os.Build") != null) {
                        f32515a = true;
                        f32516b = true;
                        return true;
                    }
                } catch (Exception unused) {
                }
                f32516b = true;
            }
            return f32515a;
        }
        return invokeV.booleanValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
        }
        return (String) invokeV.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String d2 = d("ro.vivo.os.build.display.id");
            return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(f32519e);
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f32518d) : invokeV.booleanValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return Build.DISPLAY + "_" + d(RomUtils.KEY_VERSION_GIONEE);
        }
        return (String) invokeV.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (k()) {
                return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? !TextUtils.isEmpty(d("ro.letv.release.version")) : invokeV.booleanValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (e()) {
                return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            String n = n();
            if (n == null || !n.toLowerCase().contains("emotionui")) {
                return "";
            }
            return n + "_" + Build.DISPLAY;
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? d("ro.build.version.emui") : (String) invokeV.objValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? RomUtils.MANUFACTURER_SMARTISAN.equalsIgnoreCase(Build.MANUFACTURER) || RomUtils.MANUFACTURER_SMARTISAN.equalsIgnoreCase(Build.BRAND) : invokeV.booleanValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (o()) {
                try {
                    String d2 = d("ro.smartisan.version");
                    return "smartisan_" + d2;
                } catch (Throwable unused) {
                }
            }
            return Build.DISPLAY;
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            String str = Build.DISPLAY;
            return (str == null || !str.toLowerCase().contains(ImmersiveOSUtils.FLYME)) ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (f32521g == Integer.MAX_VALUE) {
                String str = Build.MANUFACTURER;
                String m = q.m("kllk");
                if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(m)) {
                    f32521g = 1;
                } else {
                    f32521g = 0;
                }
            }
            return f32521g == 1;
        }
        return invokeV.booleanValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            if (r()) {
                String m = q.m("ro.build.version.kllkrom");
                return "coloros_" + d(m) + "_" + Build.DISPLAY;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                    if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                        return false;
                    }
                    if (!Build.MANUFACTURER.toLowerCase().startsWith(RomUtils.MANUFACTURER_HUAWEI)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            if (o()) {
                return p();
            }
            if (e()) {
                return l();
            }
            if (b()) {
                return q();
            }
            if (r()) {
                return s();
            }
            String m = m();
            if (TextUtils.isEmpty(m)) {
                if (g()) {
                    return f();
                }
                if (h()) {
                    return i();
                }
                if (d()) {
                    return c();
                }
                String j = j();
                return !TextUtils.isEmpty(j) ? j : Build.DISPLAY;
            }
            return m;
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                    com.bytedance.sdk.component.utils.k.c("RomUtils", "get Property From SPMultiHelper..." + b2);
                    return b2;
                }
                String b3 = u.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).b("rom_property_info", "");
                com.bytedance.sdk.component.utils.k.c("RomUtils", "get Property From SP...=" + b3);
                return b3;
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? Build.DISPLAY.contains("Flyme") || Build.USER.equals(ImmersiveOSUtils.FLYME) : invokeV.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static String c(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Throwable th;
        Process exec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            String str2 = "";
            Process process = null;
            try {
                try {
                    try {
                        exec = Runtime.getRuntime().exec("getprop " + str);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                        } catch (IllegalThreadStateException unused) {
                            bufferedReader = null;
                        }
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                    }
                } catch (IllegalThreadStateException unused2) {
                    bufferedReader = null;
                }
            } catch (IOException e2) {
                com.bytedance.sdk.component.utils.k.c("ToolUtils", "Exception while closing InputStream", e2);
            }
            try {
                str2 = bufferedReader.readLine();
                exec.exitValue();
                bufferedReader.close();
            } catch (IllegalThreadStateException unused3) {
                process = exec;
                try {
                    process.destroy();
                } catch (Throwable unused4) {
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                try {
                    com.bytedance.sdk.component.utils.k.c("ToolUtils", "Unable to read sysprop " + str, th);
                    return str2;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            com.bytedance.sdk.component.utils.k.c("ToolUtils", "Exception while closing InputStream", e3);
                        }
                    }
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                str2 = v();
                try {
                    if (TextUtils.isEmpty(str2)) {
                        com.bytedance.sdk.component.d.f fVar = new com.bytedance.sdk.component.d.f(new a(str), 5, 2);
                        com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g("getSystemPropertyTask", fVar) { // from class: com.bytedance.sdk.openadsdk.q.l.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.component.d.f f32522a;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r7);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {r7, fVar};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        super((String) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f32522a = fVar;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f32522a.run();
                                }
                            }
                        });
                        str2 = (String) fVar.get(1L, TimeUnit.SECONDS);
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str2 = "";
            }
            return str2 == null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = n();
            }
            return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
        }
        return invokeL.booleanValue;
    }
}
