package d.a.t.f.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ConectivityUtils;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class p implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static HashMap<String, Integer> f70313a;

        /* renamed from: b  reason: collision with root package name */
        public static a f70314b;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.t.f.a.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C1936a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public String f70315a;

            /* renamed from: b  reason: collision with root package name */
            public String f70316b;

            /* renamed from: c  reason: collision with root package name */
            public String f70317c;

            /* renamed from: d  reason: collision with root package name */
            public int f70318d;

            public C1936a(Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                b(context);
            }

            public final void a(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, context, networkInfo) == null) {
                    if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
                        if (lowerCase.startsWith(ConectivityUtils.APN_CMWAP) || lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) || lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                            this.f70315a = lowerCase;
                            this.f70316b = "10.0.0.172";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                            this.f70315a = lowerCase;
                            this.f70316b = "10.0.0.200";
                            return;
                        } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                            this.f70315a = lowerCase;
                            return;
                        }
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost == null || defaultHost.length() <= 0) {
                        return;
                    }
                    this.f70316b = defaultHost;
                    if ("10.0.0.172".equals(defaultHost.trim()) || "10.0.0.200".equals(this.f70316b.trim())) {
                        return;
                    }
                    Integer.toString(defaultPort);
                }
            }

            @SuppressLint({"MissingPermission"})
            public final void b(Context context) {
                NetworkInfo networkInfo;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
                    try {
                        networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    } catch (Exception unused) {
                        networkInfo = null;
                    }
                    if (networkInfo != null) {
                        if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                            this.f70317c = "wifi";
                        } else {
                            a(context, networkInfo);
                            this.f70317c = this.f70315a;
                        }
                        this.f70318d = networkInfo.getSubtype();
                        networkInfo.getSubtypeName();
                    }
                }
            }

            public int c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70318d : invokeV.intValue;
            }

            public String d() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f70317c : (String) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639628763, "Ld/a/t/f/a/p$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1639628763, "Ld/a/t/f/a/p$a;");
                    return;
                }
            }
            HashMap<String, Integer> hashMap = new HashMap<>();
            f70313a = hashMap;
            hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
            f70313a.put("3GNET", 21);
            f70313a.put("3GWAP", 22);
            f70313a.put("CMNET", 31);
            f70313a.put("UNINET", 32);
            f70313a.put("CTNET", 33);
            f70313a.put("CMWAP", 41);
            f70313a.put("UNIWAP", 42);
            f70313a.put("CTWAP", 43);
            f70314b = new a();
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

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f70314b : (a) invokeV.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            StringBuilder sb;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                C1936a c1936a = new C1936a(context);
                String d2 = c1936a.d();
                int c2 = c1936a.c();
                if (TextUtils.isEmpty(d2)) {
                    sb = new StringBuilder();
                } else {
                    Integer num = f70313a.get(d2.toUpperCase());
                    r3 = num != null ? num : 5;
                    sb = new StringBuilder();
                }
                sb.append(r3);
                sb.append("_");
                sb.append(c2);
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static b f70319c;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70320a;

        /* renamed from: b  reason: collision with root package name */
        public DisplayMetrics f70321b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639628732, "Ld/a/t/f/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1639628732, "Ld/a/t/f/a/p$b;");
                    return;
                }
            }
            f70319c = new b();
        }

        public b() {
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

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f70319c : (b) invokeV.objValue;
        }

        public static String d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    return "0.8";
                }
            }
            return (String) invokeL.objValue;
        }

        public String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                synchronized (b.class) {
                    if (TextUtils.isEmpty(this.f70320a)) {
                        this.f70320a = c(context);
                    }
                }
                return this.f70320a;
            }
            return (String) invokeL.objValue;
        }

        public final String c(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                int e2 = e(context.getApplicationContext());
                int f2 = f(context.getApplicationContext());
                int g2 = g(context.getApplicationContext());
                String d2 = d(context.getApplicationContext());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e2);
                stringBuffer.append("_");
                stringBuffer.append(f2);
                stringBuffer.append("_");
                stringBuffer.append("android");
                stringBuffer.append("_");
                stringBuffer.append(d2);
                stringBuffer.append("_");
                stringBuffer.append(g2);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }

        public final int e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f70321b;
                if (displayMetrics != null) {
                    return displayMetrics.widthPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f70321b;
                if (displayMetrics != null) {
                    return displayMetrics.heightPixels;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final int g(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                h(context);
                DisplayMetrics displayMetrics = this.f70321b;
                if (displayMetrics != null) {
                    return displayMetrics.densityDpi;
                }
                return 0;
            }
            return invokeL.intValue;
        }

        public final void h(Context context) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && context != null && this.f70321b == null) {
                this.f70321b = context.getResources().getDisplayMetrics();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static c f70322e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f70323a;

        /* renamed from: b  reason: collision with root package name */
        public String f70324b;

        /* renamed from: c  reason: collision with root package name */
        public String f70325c;

        /* renamed from: d  reason: collision with root package name */
        public String f70326d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1639628701, "Ld/a/t/f/a/p$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1639628701, "Ld/a/t/f/a/p$c;");
                    return;
                }
            }
            f70322e = new c();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            c();
        }

        public static c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f70322e : (c) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f70326d : (String) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                String str = Build.MODEL;
                this.f70323a = str;
                if (TextUtils.isEmpty(str)) {
                    this.f70323a = "NUL";
                } else {
                    this.f70323a = this.f70323a.replace("_", "-");
                }
                String str2 = Build.MANUFACTURER;
                this.f70324b = str2;
                if (TextUtils.isEmpty(str2)) {
                    this.f70324b = "NUL";
                } else {
                    this.f70324b = this.f70324b.replace("_", "-");
                }
                String str3 = Build.VERSION.RELEASE;
                this.f70325c = str3;
                this.f70325c = TextUtils.isEmpty(str3) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : this.f70325c.replace("_", "-");
                this.f70326d = d();
            }
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                String str = this.f70323a;
                String str2 = this.f70325c;
                int i2 = Build.VERSION.SDK_INT;
                String str3 = this.f70324b;
                return str + "_" + str2 + "_" + i2 + "_" + str3;
            }
            return (String) invokeV.objValue;
        }
    }

    public p() {
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

    @Override // d.a.t.f.a.l
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a().b() : (String) invokeV.objValue;
    }

    @Override // d.a.t.f.a.l
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? b.a().b(context) : (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.l
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? System.currentTimeMillis() : invokeV.longValue;
    }

    @Override // d.a.t.f.a.l
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) ? (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName() : (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.l
    public String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? d.a.t.b.d(context).f() : (String) invokeL.objValue;
    }

    @Override // d.a.t.f.a.l
    public String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? a.a().b(context) : (String) invokeL.objValue;
    }
}
