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
/* loaded from: classes8.dex */
public class av implements au, InvocationHandler {
    public static /* synthetic */ Interceptable $ic;
    public static final String[][] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public volatile int f106a;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f107a;

    /* renamed from: a  reason: collision with other field name */
    public Context f108a;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f109a;

    /* renamed from: a  reason: collision with other field name */
    public Class f110a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f111a;

    /* renamed from: a  reason: collision with other field name */
    public Method f112a;
    public Class b;

    /* renamed from: b  reason: collision with other field name */
    public Method f113b;
    public Method c;
    public Method d;
    public Method e;
    public Method f;
    public Method g;

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f114a;

        /* renamed from: a  reason: collision with other field name */
        public String f115a;
        public String b;
        public String c;
        public String d;

        public a(av avVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = avVar;
            this.f114a = null;
            this.f115a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }

        public /* synthetic */ a(av avVar, aw awVar) {
            this(avVar);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!TextUtils.isEmpty(this.f115a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                    this.f114a = Boolean.TRUE;
                }
                return this.f114a != null;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56379221, "Lcom/xiaomi/push/av;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56379221, "Lcom/xiaomi/push/av;");
                return;
            }
        }
        a = new String[][]{new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    }

    public av(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f110a = null;
        this.b = null;
        this.f112a = null;
        this.f113b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f111a = new Object();
        this.f106a = 0;
        this.f107a = 0L;
        this.f109a = null;
        this.f108a = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class<?> a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return v.a(context, str);
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
            synchronized (this.f111a) {
                try {
                    this.f111a.notifyAll();
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
            int i = 0;
            while (true) {
                String[][] strArr = a;
                if (i >= strArr.length) {
                    break;
                }
                String[] strArr2 = strArr[i];
                Class<?> a3 = a(context, strArr2[0]);
                Class<?> a4 = a(context, strArr2[1]);
                if (a3 != null && a4 != null) {
                    b("found class in index " + i);
                    cls2 = a4;
                    cls = a3;
                    break;
                }
                i++;
                cls2 = a4;
                cls = a3;
            }
            this.f110a = a2;
            this.f112a = a(a2, "InitSdk", Context.class, cls);
            this.b = cls;
            this.f113b = a(cls2, "getUDID", new Class[0]);
            this.c = a(cls2, "getOAID", new Class[0]);
            this.d = a(cls2, "getVAID", new Class[0]);
            this.e = a(cls2, "getAAID", new Class[0]);
            this.f = a(cls2, "isSupported", new Class[0]);
            this.g = a(cls2, "shutDown", new Class[0]);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && this.f109a == null) {
            long j = this.f107a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
            int i = this.f106a;
            if (elapsedRealtime > 3000 && i < 3) {
                synchronized (this.f111a) {
                    if (this.f107a == j && this.f106a == i) {
                        b("retry, current count is " + i);
                        this.f106a = this.f106a + 1;
                        b(this.f108a);
                        j = this.f107a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                    }
                }
            }
            if (this.f109a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            synchronized (this.f111a) {
                if (this.f109a == null) {
                    try {
                        b(str + " wait...");
                        this.f111a.wait(3000L);
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
            Class cls = this.b;
            if (cls != null) {
                try {
                    ClassLoader classLoader = cls.getClassLoader();
                    if (classLoader == null) {
                        classLoader = context.getClassLoader();
                    }
                    a(this.f112a, this.f110a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
                } catch (Throwable th) {
                    b("call init sdk error:" + th);
                }
                this.f107a = elapsedRealtime;
            }
            elapsedRealtime = j;
            this.f107a = elapsedRealtime;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("mdid:" + str);
        }
    }

    @Override // com.xiaomi.push.au
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getOAID");
            if (this.f109a == null) {
                return null;
            }
            return this.f109a.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.au
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a("isSupported");
            return this.f109a != null && Boolean.TRUE.equals(this.f109a.f114a);
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
            this.f107a = SystemClock.elapsedRealtime();
            if (objArr != null) {
                a aVar = new a(this, null);
                int length = objArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Object obj2 = objArr[i];
                    if (obj2 != null && !a(obj2)) {
                        aVar.f115a = (String) a(this.f113b, obj2, new Object[0]);
                        aVar.b = (String) a(this.c, obj2, new Object[0]);
                        aVar.c = (String) a(this.d, obj2, new Object[0]);
                        aVar.d = (String) a(this.e, obj2, new Object[0]);
                        aVar.f114a = (Boolean) a(this.f, obj2, new Object[0]);
                        a(this.g, obj2, new Object[0]);
                        if (aVar.a()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("has get succ, check duplicate:");
                            sb.append(this.f109a != null);
                            b(sb.toString());
                            synchronized (av.class) {
                                if (this.f109a == null) {
                                    this.f109a = aVar;
                                }
                            }
                        }
                    }
                    i++;
                }
            }
            a();
            return null;
        }
        return invokeLLL.objValue;
    }
}
