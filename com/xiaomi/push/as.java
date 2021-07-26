package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes6.dex */
public class as implements ar, InvocationHandler {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[][] f40120a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f124a;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f125a;

    /* renamed from: a  reason: collision with other field name */
    public Context f126a;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f127a;

    /* renamed from: a  reason: collision with other field name */
    public Class f128a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f129a;

    /* renamed from: a  reason: collision with other field name */
    public Method f130a;

    /* renamed from: b  reason: collision with root package name */
    public Class f40121b;

    /* renamed from: b  reason: collision with other field name */
    public Method f131b;

    /* renamed from: c  reason: collision with root package name */
    public Method f40122c;

    /* renamed from: d  reason: collision with root package name */
    public Method f40123d;

    /* renamed from: e  reason: collision with root package name */
    public Method f40124e;

    /* renamed from: f  reason: collision with root package name */
    public Method f40125f;

    /* renamed from: g  reason: collision with root package name */
    public Method f40126g;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ as f40127a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f132a;

        /* renamed from: a  reason: collision with other field name */
        public String f133a;

        /* renamed from: b  reason: collision with root package name */
        public String f40128b;

        /* renamed from: c  reason: collision with root package name */
        public String f40129c;

        /* renamed from: d  reason: collision with root package name */
        public String f40130d;

        public a(as asVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40127a = asVar;
            this.f132a = null;
            this.f133a = null;
            this.f40128b = null;
            this.f40129c = null;
            this.f40130d = null;
        }

        public /* synthetic */ a(as asVar, at atVar) {
            this(asVar);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f133a) || !TextUtils.isEmpty(this.f40128b) || !TextUtils.isEmpty(this.f40129c) || !TextUtils.isEmpty(this.f40130d)) {
                    this.f132a = Boolean.TRUE;
                }
                return this.f132a != null;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379314, "Lcom/xiaomi/push/as;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379314, "Lcom/xiaomi/push/as;");
                return;
            }
        }
        f40120a = new String[][]{new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    }

    public as(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f128a = null;
        this.f40121b = null;
        this.f130a = null;
        this.f131b = null;
        this.f40122c = null;
        this.f40123d = null;
        this.f40124e = null;
        this.f40125f = null;
        this.f40126g = null;
        this.f129a = new Object();
        this.f124a = 0;
        this.f125a = 0L;
        this.f127a = null;
        this.f126a = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class<?> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return t.a(context, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Class) invokeLL.objValue;
    }

    public static <T> T a(Method method, Object obj, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, method, obj, objArr)) == null) {
            if (method != null) {
                try {
                    T t = (T) method.invoke(obj, objArr);
                    if (t != null) {
                        return t;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str, clsArr)) == null) {
            if (cls != null) {
                try {
                    return cls.getMethod(str, clsArr);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            synchronized (this.f129a) {
                try {
                    this.f129a.notifyAll();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
            Class<?> cls = null;
            Class<?> cls2 = null;
            int i2 = 0;
            while (true) {
                String[][] strArr = f40120a;
                if (i2 >= strArr.length) {
                    break;
                }
                String[] strArr2 = strArr[i2];
                Class<?> a3 = a(context, strArr2[0]);
                Class<?> a4 = a(context, strArr2[1]);
                if (a3 != null && a4 != null) {
                    b("found class in index " + i2);
                    cls2 = a4;
                    cls = a3;
                    break;
                }
                i2++;
                cls2 = a4;
                cls = a3;
            }
            this.f128a = a2;
            this.f130a = a(a2, "InitSdk", Context.class, cls);
            this.f40121b = cls;
            this.f131b = a(cls2, "getUDID", new Class[0]);
            this.f40122c = a(cls2, "getOAID", new Class[0]);
            this.f40123d = a(cls2, "getVAID", new Class[0]);
            this.f40124e = a(cls2, "getAAID", new Class[0]);
            this.f40125f = a(cls2, "isSupported", new Class[0]);
            this.f40126g = a(cls2, "shutDown", new Class[0]);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && this.f127a == null) {
            long j = this.f125a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
            int i2 = this.f124a;
            if (elapsedRealtime > 3000 && i2 < 3) {
                synchronized (this.f129a) {
                    if (this.f125a == j && this.f124a == i2) {
                        b("retry, current count is " + i2);
                        this.f124a = this.f124a + 1;
                        b(this.f126a);
                        j = this.f125a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                    }
                }
            }
            if (this.f127a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            synchronized (this.f129a) {
                if (this.f127a == null) {
                    try {
                        b(str + " wait...");
                        this.f129a.wait(3000L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static boolean a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) : invokeL.booleanValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = -elapsedRealtime;
            Class cls = this.f40121b;
            if (cls != null) {
                try {
                    ClassLoader classLoader = cls.getClassLoader();
                    if (classLoader == null) {
                        classLoader = context.getClassLoader();
                    }
                    a(this.f130a, this.f128a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f40121b}, this));
                } catch (Throwable th) {
                    b("call init sdk error:" + th);
                }
                this.f125a = elapsedRealtime;
            }
            elapsedRealtime = j;
            this.f125a = elapsedRealtime;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m70a("mdid:" + str);
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getUDID");
            if (this.f127a == null) {
                return null;
            }
            return this.f127a.f133a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a("isSupported");
            return this.f127a != null && Boolean.TRUE.equals(this.f127a.f132a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo149b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a("getOAID");
            if (this.f127a == null) {
                return null;
            }
            return this.f127a.f40128b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a("getVAID");
            if (this.f127a == null) {
                return null;
            }
            return this.f127a.f40129c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a("getAAID");
            if (this.f127a == null) {
                return null;
            }
            return this.f127a.f40130d;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, obj, method, objArr)) == null) {
            this.f125a = SystemClock.elapsedRealtime();
            if (objArr != null) {
                a aVar = new a(this, null);
                int length = objArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Object obj2 = objArr[i2];
                    if (obj2 != null && !a(obj2)) {
                        aVar.f133a = (String) a(this.f131b, obj2, new Object[0]);
                        aVar.f40128b = (String) a(this.f40122c, obj2, new Object[0]);
                        aVar.f40129c = (String) a(this.f40123d, obj2, new Object[0]);
                        aVar.f40130d = (String) a(this.f40124e, obj2, new Object[0]);
                        aVar.f132a = (Boolean) a(this.f40125f, obj2, new Object[0]);
                        a(this.f40126g, obj2, new Object[0]);
                        if (aVar.a()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("has get succ, check duplicate:");
                            sb.append(this.f127a != null);
                            b(sb.toString());
                            synchronized (as.class) {
                                if (this.f127a == null) {
                                    this.f127a = aVar;
                                }
                            }
                        }
                    }
                    i2++;
                }
            }
            a();
            return null;
        }
        return invokeLLL.objValue;
    }
}
