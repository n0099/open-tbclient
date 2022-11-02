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
/* loaded from: classes8.dex */
public final class ed {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ed a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f303a;

    /* renamed from: a  reason: collision with other field name */
    public Context f304a;

    /* renamed from: a  reason: collision with other field name */
    public eh f305a;

    /* renamed from: a  reason: collision with other field name */
    public String f306a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<ef, eg> f307a;
    public String b;

    public ed(Context context) {
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
        HashMap<ef, eg> hashMap = new HashMap<>();
        this.f307a = hashMap;
        this.f304a = context;
        hashMap.put(ef.b, new ej());
        this.f307a.put(ef.c, new ek());
        this.f307a.put(ef.a, new eb());
        this.f307a.put(ef.d, new ei());
    }

    public static ed a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (ed.class) {
                    if (a == null) {
                        a = new ed(context);
                    }
                }
            }
            return a;
        }
        return (ed) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ef efVar, Context context, ec ecVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, efVar, context, ecVar) == null) {
            this.f307a.get(efVar).a(context, ecVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m305a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? com.xiaomi.push.service.al.m607a(context, context.getPackageName()) : invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f303a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eh m306a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f305a : (eh) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m307a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f306a : (String) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f303a = i;
        }
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, Integer.valueOf(i), str2, str3}) == null) {
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                a(i);
                al.a(this.f304a).a(new ee(this, str, context, str2, str3));
                return;
            }
            dz.a(context, "" + str, 1008, "A receive a incorrect message");
        }
    }

    public void a(ef efVar, Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, efVar, context, intent, str) == null) {
            if (efVar != null) {
                this.f307a.get(efVar).a(context, intent, str);
            } else {
                dz.a(context, StringUtil.NULL_STRING, 1008, "A receive a incorrect message with empty type");
            }
        }
    }

    public void a(eh ehVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ehVar) == null) {
            this.f305a = ehVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f306a = str;
        }
    }

    public void a(String str, String str2, int i, eh ehVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i, ehVar) == null) {
            a(str);
            b(str2);
            a(i);
            a(ehVar);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.b = str;
        }
    }
}
