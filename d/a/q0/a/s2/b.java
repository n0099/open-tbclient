package d.a.q0.a.s2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.l;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50619a;

    /* renamed from: b  reason: collision with root package name */
    public static String f50620b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: f  reason: collision with root package name */
        public static String f50621f = "%s/%s";

        /* renamed from: g  reason: collision with root package name */
        public static String f50622g = "%s-%s/%s";

        /* renamed from: h  reason: collision with root package name */
        public static String f50623h = "(Baidu; P1 %s)";

        /* renamed from: i  reason: collision with root package name */
        public static String f50624i = "%s/%s";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50625a;

        /* renamed from: b  reason: collision with root package name */
        public String f50626b;

        /* renamed from: c  reason: collision with root package name */
        public String f50627c;

        /* renamed from: d  reason: collision with root package name */
        public String f50628d;

        /* renamed from: e  reason: collision with root package name */
        public String f50629e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1935121875, "Ld/a/q0/a/s2/b$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1935121875, "Ld/a/q0/a/s2/b$a;");
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String format = String.format(f50621f, this.f50625a, this.f50626b);
                String format2 = String.format(f50622g, this.f50625a, this.f50627c, this.f50628d);
                String format3 = String.format(f50624i, this.f50627c, this.f50628d);
                String format4 = String.format(f50623h, this.f50629e);
                if (e()) {
                    return String.format("%s %s %s %s", format, format2, format3, format4);
                }
                return String.format("%s %s %s", format, format2, format4);
            }
            return (String) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f50625a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f50627c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f50628d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, this.f50627c) : invokeV.booleanValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f50629e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f50626b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(127153200, "Ld/a/q0/a/s2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(127153200, "Ld/a/q0/a/s2/b;");
                return;
            }
        }
        f50619a = k.f49133a;
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a.q0.a.c1.a.b() : (Context) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? e(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME) : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? e("swan") : (String) invokeV.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            String a2 = d.a.q0.a.c1.a.m().a();
            a aVar = new a();
            aVar.b(str);
            aVar.g(l.a());
            aVar.c(a2);
            aVar.d(f());
            aVar.f(b());
            return aVar.a();
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (!TextUtils.isEmpty(f50620b)) {
                return f50620b;
            }
            try {
                String str = a().getPackageManager().getPackageInfo(a().getPackageName(), 0).versionName;
                f50620b = str;
                return str;
            } catch (PackageManager.NameNotFoundException e2) {
                if (f50619a) {
                    e2.printStackTrace();
                    return "0.8";
                }
                return "0.8";
            }
        }
        return (String) invokeV.objValue;
    }
}
