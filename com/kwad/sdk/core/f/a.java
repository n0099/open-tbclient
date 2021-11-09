package com.kwad.sdk.core.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.f.a.b;
import com.kwad.sdk.core.f.a.d;
import com.kwad.sdk.core.f.a.e;
import com.kwad.sdk.core.f.a.f;
import com.kwad.sdk.core.f.a.h;
import com.kwad.sdk.core.f.a.i;
import com.kwad.sdk.core.f.a.j;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.g;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f64534a = "";

    /* renamed from: b  reason: collision with root package name */
    public static InterfaceC1903a f64535b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64536c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64537d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1903a {
        @WorkerThread
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1890011704, "Lcom/kwad/sdk/core/f/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1890011704, "Lcom/kwad/sdk/core/f/a;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            String a2 = a(context);
            return (TextUtils.isEmpty(a2) && TextUtils.isEmpty(ap.e(context))) ? c.Y() : a2;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f64534a)) {
                String e2 = am.e(context);
                f64534a = e2;
                if (TextUtils.isEmpty(e2)) {
                    b(context);
                    return f64534a;
                }
                return f64534a;
            }
            return f64534a;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"PrivateApi"})
    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) && TextUtils.isEmpty(f64534a) && context != null) {
            c(context);
        }
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, context) == null) || !TextUtils.isEmpty(f64534a) || context == null || f64536c) {
            return;
        }
        f64536c = true;
        if (context == null || f64537d) {
            return;
        }
        g.a(new Runnable(context.getApplicationContext()) { // from class: com.kwad.sdk.core.f.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f64538a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64538a = r6;
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // java.lang.Runnable
            public void run() {
                char c2;
                String a2;
                j jVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String upperCase = Build.MANUFACTURER.toUpperCase();
                    switch (upperCase.hashCode()) {
                        case -2053026509:
                            if (upperCase.equals("LENOVO")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1712043046:
                            if (upperCase.equals("SAMSUNG")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1706170181:
                            if (upperCase.equals("XIAOMI")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1134767290:
                            if (upperCase.equals("BLACKSHARK")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -602397472:
                            if (upperCase.equals(RomTypeUtil.ROM_ONEPLUS)) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 89163:
                            if (upperCase.equals("ZTE")) {
                                c2 = '\f';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2018896:
                            if (upperCase.equals("ASUS")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2432928:
                            if (upperCase.equals("OPPO")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2555124:
                            if (upperCase.equals("SSUI")) {
                                c2 = 14;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2634924:
                            if (upperCase.equals("VIVO")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 73239724:
                            if (upperCase.equals("MEIZU")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 74632627:
                            if (upperCase.equals(RomUtils.ROM_NUBIA)) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 630905871:
                            if (upperCase.equals("MOTOLORA")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 976565563:
                            if (upperCase.equals("FERRMEOS")) {
                                c2 = CharUtils.CR;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 2141820391:
                            if (upperCase.equals("HUAWEI")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            a2 = new b(this.f64538a).a();
                            String unused = a.f64534a = a2;
                            break;
                        case 1:
                        case 2:
                            a2 = new i(this.f64538a).a();
                            String unused2 = a.f64534a = a2;
                            break;
                        case 3:
                        case 4:
                            a2 = new f(this.f64538a).a();
                            String unused22 = a.f64534a = a2;
                            break;
                        case 5:
                            a2 = new h(this.f64538a).a();
                            String unused222 = a.f64534a = a2;
                            break;
                        case 6:
                        case 7:
                            a2 = new com.kwad.sdk.core.f.a.c(this.f64538a).a();
                            String unused2222 = a.f64534a = a2;
                            break;
                        case '\b':
                            a2 = new d(this.f64538a).a();
                            String unused22222 = a.f64534a = a2;
                            break;
                        case '\t':
                            a2 = new e(this.f64538a).a();
                            String unused222222 = a.f64534a = a2;
                            break;
                        case '\n':
                            a2 = new com.kwad.sdk.core.f.a.g(this.f64538a).a();
                            String unused2222222 = a.f64534a = a2;
                            break;
                        case 11:
                            a2 = new com.kwad.sdk.core.f.a.a(this.f64538a).a();
                            String unused22222222 = a.f64534a = a2;
                            break;
                        case '\f':
                        case '\r':
                        case 14:
                            jVar = new j(this.f64538a);
                            a2 = jVar.a();
                            String unused222222222 = a.f64534a = a2;
                            break;
                        default:
                            if (a.f() || a.g()) {
                                jVar = new j(this.f64538a);
                                a2 = jVar.a();
                                String unused2222222222 = a.f64534a = a2;
                                break;
                            }
                            break;
                    }
                    com.kwad.sdk.core.d.a.c("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + a.f64534a);
                    if (TextUtils.isEmpty(a.f64534a)) {
                        boolean unused3 = a.f64537d = true;
                    } else {
                        am.i(this.f64538a, a.f64534a);
                    }
                    a.h();
                    boolean unused4 = a.f64536c = false;
                }
            }
        });
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String b2 = b("ro.build.freeme.label");
            return !TextUtils.isEmpty(b2) && b2.equalsIgnoreCase("FREEMEOS");
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String b2 = b("ro.ssui.product");
            return (TextUtils.isEmpty(b2) || b2.equalsIgnoreCase("unknown")) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public static void h() {
        InterfaceC1903a interfaceC1903a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || (interfaceC1903a = f64535b) == null) {
            return;
        }
        interfaceC1903a.a(f64534a);
    }
}
