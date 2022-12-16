package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class bw {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bw a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f172a;

    public bw(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f172a = context;
    }

    public static bw a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (bw.class) {
                    if (a == null) {
                        a = new bw(context);
                    }
                }
            }
            return a;
        }
        return (bw) invokeL.objValue;
    }

    public synchronized long a(String str, String str2, long j) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            synchronized (this) {
                try {
                    j2 = this.f172a.getSharedPreferences(str, 4).getLong(str2, j);
                } catch (Throwable unused) {
                    return j;
                }
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public synchronized String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            synchronized (this) {
                try {
                    string = this.f172a.getSharedPreferences(str, 4).getString(str2, str3);
                } catch (Throwable unused) {
                    return str3;
                }
            }
            return string;
        }
        return (String) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m221a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = this.f172a.getSharedPreferences(str, 4).edit();
                edit.putLong(str2, j);
                edit.commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m222a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = this.f172a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        }
    }
}
