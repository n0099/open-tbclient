package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes4.dex */
public class as implements ar, InvocationHandler {
    public static /* synthetic */ Interceptable $ic;
    public static final String[][] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f129a;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f130a;

    /* renamed from: a  reason: collision with other field name */
    public Context f131a;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f132a;

    /* renamed from: a  reason: collision with other field name */
    public Class f133a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f134a;

    /* renamed from: a  reason: collision with other field name */
    public Method f135a;

    /* renamed from: b  reason: collision with root package name */
    public Class f63292b;

    /* renamed from: b  reason: collision with other field name */
    public Method f136b;

    /* renamed from: c  reason: collision with root package name */
    public Method f63293c;

    /* renamed from: d  reason: collision with root package name */
    public Method f63294d;

    /* renamed from: e  reason: collision with root package name */
    public Method f63295e;

    /* renamed from: f  reason: collision with root package name */
    public Method f63296f;

    /* renamed from: g  reason: collision with root package name */
    public Method f63297g;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f137a;

        /* renamed from: a  reason: collision with other field name */
        public String f138a;

        /* renamed from: b  reason: collision with root package name */
        public String f63298b;

        /* renamed from: c  reason: collision with root package name */
        public String f63299c;

        /* renamed from: d  reason: collision with root package name */
        public String f63300d;

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
            this.a = asVar;
            this.f137a = null;
            this.f138a = null;
            this.f63298b = null;
            this.f63299c = null;
            this.f63300d = null;
        }

        public /* synthetic */ a(as asVar, at atVar) {
            this(asVar);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f138a) || !TextUtils.isEmpty(this.f63298b) || !TextUtils.isEmpty(this.f63299c) || !TextUtils.isEmpty(this.f63300d)) {
                    this.f137a = Boolean.TRUE;
                }
                return this.f137a != null;
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
        a = new String[][]{new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
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
        this.f133a = null;
        this.f63292b = null;
        this.f135a = null;
        this.f136b = null;
        this.f63293c = null;
        this.f63294d = null;
        this.f63295e = null;
        this.f63296f = null;
        this.f63297g = null;
        this.f134a = new Object();
        this.f129a = 0;
        this.f130a = 0L;
        this.f132a = null;
        this.f131a = context.getApplicationContext();
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
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            synchronized (this.f134a) {
                try {
                    this.f134a.notifyAll();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
            Class<?> cls = null;
            Class<?> cls2 = null;
            int i2 = 0;
            while (true) {
                String[][] strArr = a;
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
            this.f133a = a2;
            this.f135a = a(a2, "InitSdk", Context.class, cls);
            this.f63292b = cls;
            this.f136b = a(cls2, "getUDID", new Class[0]);
            this.f63293c = a(cls2, "getOAID", new Class[0]);
            this.f63294d = a(cls2, "getVAID", new Class[0]);
            this.f63295e = a(cls2, "getAAID", new Class[0]);
            this.f63296f = a(cls2, "isSupported", new Class[0]);
            this.f63297g = a(cls2, "shutDown", new Class[0]);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && this.f132a == null) {
            long j2 = this.f130a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
            int i2 = this.f129a;
            if (elapsedRealtime > 3000 && i2 < 3) {
                synchronized (this.f134a) {
                    if (this.f130a == j2 && this.f129a == i2) {
                        b("retry, current count is " + i2);
                        this.f129a = this.f129a + 1;
                        b(this.f131a);
                        j2 = this.f130a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                    }
                }
            }
            if (this.f132a != null || j2 < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            synchronized (this.f134a) {
                if (this.f132a == null) {
                    try {
                        b(str + " wait...");
                        this.f134a.wait(3000L);
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
            long j2 = -elapsedRealtime;
            Class cls = this.f63292b;
            if (cls != null) {
                try {
                    ClassLoader classLoader = cls.getClassLoader();
                    if (classLoader == null) {
                        classLoader = context.getClassLoader();
                    }
                    a(this.f135a, this.f133a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f63292b}, this));
                } catch (Throwable th) {
                    b("call init sdk error:" + th);
                }
                this.f130a = elapsedRealtime;
            }
            elapsedRealtime = j2;
            this.f130a = elapsedRealtime;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m122a("mdid:" + str);
        }
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getUDID");
            if (this.f132a == null) {
                return null;
            }
            return this.f132a.f138a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a("isSupported");
            return this.f132a != null && Boolean.TRUE.equals(this.f132a.f137a);
        }
        return invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo201b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a("getOAID");
            if (this.f132a == null) {
                return null;
            }
            return this.f132a.f63298b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            a("getVAID");
            if (this.f132a == null) {
                return null;
            }
            return this.f132a.f63299c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a("getAAID");
            if (this.f132a == null) {
                return null;
            }
            return this.f132a.f63300d;
        }
        return (String) invokeV.objValue;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, obj, method, objArr)) == null) {
            this.f130a = SystemClock.elapsedRealtime();
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
                        aVar.f138a = (String) a(this.f136b, obj2, new Object[0]);
                        aVar.f63298b = (String) a(this.f63293c, obj2, new Object[0]);
                        aVar.f63299c = (String) a(this.f63294d, obj2, new Object[0]);
                        aVar.f63300d = (String) a(this.f63295e, obj2, new Object[0]);
                        aVar.f137a = (Boolean) a(this.f63296f, obj2, new Object[0]);
                        a(this.f63297g, obj2, new Object[0]);
                        if (aVar.a()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("has get succ, check duplicate:");
                            sb.append(this.f132a != null);
                            b(sb.toString());
                            synchronized (as.class) {
                                if (this.f132a == null) {
                                    this.f132a = aVar;
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
