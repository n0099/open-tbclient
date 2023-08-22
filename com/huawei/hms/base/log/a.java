package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public b c;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 4;
        this.c = new e();
    }

    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (b) invokeV.objValue;
    }

    public final c a(int i, String str, String str2, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, th})) == null) {
            c cVar = new c(8, this.b, i, str);
            cVar.a((c) str2);
            cVar.a(th);
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) && a(i)) {
            c a = a(i, str, str2, null);
            this.c.a(a.c() + a.a(), i, str, str2);
        }
    }

    public void a(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, context, i, str) == null) {
            this.a = i;
            this.b = str;
            this.c.a(context, "HMSCore");
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            c a = a(4, str, str2, null);
            this.c.a(a.c() + '\n' + a.a(), 4, str, str2);
        }
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i >= this.a) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void b(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) && a(i)) {
            c a = a(i, str, str2, th);
            b bVar = this.c;
            bVar.a(a.c() + a.a(), i, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }
}
