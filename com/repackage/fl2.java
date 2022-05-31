package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.optimization.quotasaver.QuotaSaver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
/* loaded from: classes5.dex */
public final class fl2 implements el2 {
    public static /* synthetic */ Interceptable $ic;
    public static final fl2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ el2 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755704059, "Lcom/repackage/fl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755704059, "Lcom/repackage/fl2;");
                return;
            }
        }
        b = new fl2();
    }

    public fl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        el2 d = QuotaSaver.l.b() ? QuotaSaver.l.d() : new dl2();
        hw1.i("OptSwitcher", "by " + d);
        Unit unit = Unit.INSTANCE;
        this.a = d;
    }

    @Override // com.repackage.el2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : invokeV.intValue;
    }

    @Override // com.repackage.el2
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.b() : invokeV.booleanValue;
    }

    @Override // com.repackage.el2
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.c() : invokeV.booleanValue;
    }

    @Override // com.repackage.el2
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.d() : invokeV.booleanValue;
    }

    @Override // com.repackage.el2
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.e() : invokeV.booleanValue;
    }
}
