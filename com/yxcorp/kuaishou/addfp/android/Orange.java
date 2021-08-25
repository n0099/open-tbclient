package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import c.r.a.a.c.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Orange {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f78105a = true;

    /* renamed from: b  reason: collision with root package name */
    public static volatile Orange f78106b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-831239597, "Lcom/yxcorp/kuaishou/addfp/android/Orange;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-831239597, "Lcom/yxcorp/kuaishou/addfp/android/Orange;");
        }
    }

    public Orange() {
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
        h();
    }

    public static Orange a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f78106b == null) {
                synchronized (Orange.class) {
                    if (f78106b == null) {
                        f78106b = new Orange();
                    }
                }
            }
            return f78106b;
        }
        return (Orange) invokeV.objValue;
    }

    public static native String getClock(Context context, byte[] bArr, int i2);

    public static native byte[] getMagic(Context context, byte[] bArr, int i2);

    public static native Object jniCommand(int i2, Object obj, Object obj2, Object obj3);

    public synchronized String b(Context context, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, context, bArr, i2)) == null) {
            synchronized (this) {
                return i() ? "" : getClock(context, bArr, i2);
            }
        }
        return (String) invokeLLI.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return i() ? "" : (String) jniCommand(1114128, null, null, null);
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public synchronized byte[] d(Context context, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, bArr, i2)) == null) {
            synchronized (this) {
                if (i()) {
                    return null;
                }
                return getMagic(context, bArr, i2);
            }
        }
        return (byte[]) invokeLLI.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return i() ? "" : (String) jniCommand(1179649, null, null, null);
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return i() ? "" : (String) jniCommand(1179653, null, null, null);
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return i() ? "" : (String) jniCommand(1114131, null, null, null);
            } catch (Throwable th) {
                c.c(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                System.loadLibrary("sgcore");
                f78105a = false;
                c.f("so loaded");
            } catch (Throwable th) {
                c.f("so load failed");
                f78105a = true;
                c.c(th);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? f78105a : invokeV.booleanValue;
    }
}
