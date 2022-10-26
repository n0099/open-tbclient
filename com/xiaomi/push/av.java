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
    public volatile int f114a;

    /* renamed from: a  reason: collision with other field name */
    public volatile long f115a;

    /* renamed from: a  reason: collision with other field name */
    public Context f116a;

    /* renamed from: a  reason: collision with other field name */
    public volatile a f117a;

    /* renamed from: a  reason: collision with other field name */
    public Class f118a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f119a;

    /* renamed from: a  reason: collision with other field name */
    public Method f120a;
    public Class b;

    /* renamed from: b  reason: collision with other field name */
    public Method f121b;
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
        public Boolean f122a;

        /* renamed from: a  reason: collision with other field name */
        public String f123a;
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
            this.f122a = null;
            this.f123a = null;
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
                if (!TextUtils.isEmpty(this.f123a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                    this.f122a = Boolean.TRUE;
                }
                return this.f122a != null;
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
        this.f118a = null;
        this.b = null;
        this.f120a = null;
        this.f121b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.f119a = new Object();
        this.f114a = 0;
        this.f115a = 0L;
        this.f117a = null;
        this.f116a = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class a(Context context, String str) {
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

    public static Object a(Method method, Object obj, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, method, obj, objArr)) == null) {
            if (method != null) {
                try {
                    Object invoke = method.invoke(obj, objArr);
                    if (invoke != null) {
                        return invoke;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Method a(Class cls, String str, Class... clsArr) {
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
            synchronized (this.f119a) {
                try {
                    this.f119a.notifyAll();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            Class a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
            Class cls = null;
            Class cls2 = null;
            int i = 0;
            while (true) {
                String[][] strArr = a;
                if (i >= strArr.length) {
                    break;
                }
                String[] strArr2 = strArr[i];
                Class a3 = a(context, strArr2[0]);
                Class a4 = a(context, strArr2[1]);
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
            this.f118a = a2;
            this.f120a = a(a2, "InitSdk", Context.class, cls);
            this.b = cls;
            this.f121b = a(cls2, "getUDID", new Class[0]);
            this.c = a(cls2, "getOAID", new Class[0]);
            this.d = a(cls2, "getVAID", new Class[0]);
            this.e = a(cls2, "getAAID", new Class[0]);
            this.f = a(cls2, "isSupported", new Class[0]);
            this.g = a(cls2, "shutDown", new Class[0]);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, this, str) == null) && this.f117a == null) {
            long j = this.f115a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
            int i = this.f114a;
            if (elapsedRealtime > 3000 && i < 3) {
                synchronized (this.f119a) {
                    if (this.f115a == j && this.f114a == i) {
                        b("retry, current count is " + i);
                        this.f114a = this.f114a + 1;
                        b(this.f116a);
                        j = this.f115a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                    }
                }
            }
            if (this.f117a != null || j < 0 || elapsedRealtime > 3000 || Looper.myLooper() == Looper.getMainLooper()) {
                return;
            }
            synchronized (this.f119a) {
                if (this.f117a == null) {
                    try {
                        b(str + " wait...");
                        this.f119a.wait(3000L);
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
                    a(this.f120a, this.f118a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
                } catch (Throwable th) {
                    b("call init sdk error:" + th);
                }
                this.f115a = elapsedRealtime;
            }
            elapsedRealtime = j;
            this.f115a = elapsedRealtime;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            com.xiaomi.channel.commonutils.logger.b.m89a("mdid:" + str);
        }
    }

    @Override // com.xiaomi.push.au
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a("getOAID");
            if (this.f117a == null) {
                return null;
            }
            return this.f117a.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.au
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a("isSupported");
            return this.f117a != null && Boolean.TRUE.equals(this.f117a.f122a);
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
            this.f115a = SystemClock.elapsedRealtime();
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
                        aVar.f123a = (String) a(this.f121b, obj2, new Object[0]);
                        aVar.b = (String) a(this.c, obj2, new Object[0]);
                        aVar.c = (String) a(this.d, obj2, new Object[0]);
                        aVar.d = (String) a(this.e, obj2, new Object[0]);
                        aVar.f122a = (Boolean) a(this.f, obj2, new Object[0]);
                        a(this.g, obj2, new Object[0]);
                        if (aVar.a()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("has get succ, check duplicate:");
                            sb.append(this.f117a != null);
                            b(sb.toString());
                            synchronized (av.class) {
                                if (this.f117a == null) {
                                    this.f117a = aVar;
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
