package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class bt {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bt a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f164a;

    public bt(Context context) {
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
        this.f164a = context;
    }

    public static bt a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (bt.class) {
                    if (a == null) {
                        a = new bt(context);
                    }
                }
            }
            return a;
        }
        return (bt) invokeL.objValue;
    }

    public synchronized long a(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j2)})) == null) {
            synchronized (this) {
                try {
                    j3 = this.f164a.getSharedPreferences(str, 4).getLong(str2, j2);
                } catch (Throwable unused) {
                    return j2;
                }
            }
            return j3;
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
                    string = this.f164a.getSharedPreferences(str, 4).getString(str2, str3);
                } catch (Throwable unused) {
                    return str3;
                }
            }
            return string;
        }
        return (String) invokeLLL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m252a(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = this.f164a.getSharedPreferences(str, 4).edit();
                edit.putLong(str2, j2);
                edit.commit();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m253a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            synchronized (this) {
                SharedPreferences.Editor edit = this.f164a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        }
    }
}
