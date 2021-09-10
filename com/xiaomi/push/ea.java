package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class ea {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ea f77558a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f315a;

    /* renamed from: a  reason: collision with other field name */
    public Context f316a;

    /* renamed from: a  reason: collision with other field name */
    public ee f317a;

    /* renamed from: a  reason: collision with other field name */
    public String f318a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<ec, ed> f319a;

    /* renamed from: b  reason: collision with root package name */
    public String f77559b;

    public ea(Context context) {
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
        HashMap<ec, ed> hashMap = new HashMap<>();
        this.f319a = hashMap;
        this.f316a = context;
        hashMap.put(ec.f77564b, new eg());
        this.f319a.put(ec.f77565c, new eh());
        this.f319a.put(ec.f77563a, new dy());
        this.f319a.put(ec.f77566d, new ef());
    }

    public static ea a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f77558a == null) {
                synchronized (ea.class) {
                    if (f77558a == null) {
                        f77558a = new ea(context);
                    }
                }
            }
            return f77558a;
        }
        return (ea) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ec ecVar, Context context, dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, ecVar, context, dzVar) == null) {
            this.f319a.get(ecVar).a(context, dzVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m285a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? com.xiaomi.push.service.ac.m577a(context, context.getPackageName()) : invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f315a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ee m286a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f317a : (ee) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m287a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f318a : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f315a = i2;
        }
    }

    public void a(Context context, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, Integer.valueOf(i2), str2, str3}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                a(i2);
                ai.a(this.f316a).a(new eb(this, str, context, str2, str3));
                return;
            }
            dw.a(context, "" + str, 1008, "A receive a incorrect message");
        }
    }

    public void a(ec ecVar, Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, ecVar, context, intent, str) == null) {
            if (ecVar != null) {
                this.f319a.get(ecVar).a(context, intent, str);
            } else {
                dw.a(context, StringUtil.NULL_STRING, 1008, "A receive a incorrect message with empty type");
            }
        }
    }

    public void a(ee eeVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eeVar) == null) {
            this.f317a = eeVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f318a = str;
        }
    }

    public void a(String str, String str2, int i2, ee eeVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2, eeVar) == null) {
            a(str);
            b(str2);
            a(i2);
            a(eeVar);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f77559b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f77559b = str;
        }
    }
}
