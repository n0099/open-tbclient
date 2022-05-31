package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tu9;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class ow9 extends tu9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ow9 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public final class a extends tu9.a implements xu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jz9 a;
        public final /* synthetic */ ow9 b;

        public a(ow9 ow9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ow9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ow9Var;
            this.a = new jz9();
        }

        @Override // com.repackage.tu9.a
        public xu9 b(dv9 dv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dv9Var)) == null) {
                dv9Var.call();
                return nz9.c();
            }
            return (xu9) invokeL.objValue;
        }

        @Override // com.repackage.tu9.a
        public xu9 c(dv9 dv9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dv9Var, Long.valueOf(j), timeUnit})) == null) ? b(new sw9(dv9Var, this, this.b.now() + timeUnit.toMillis(j))) : (xu9) invokeCommon.objValue;
        }

        @Override // com.repackage.xu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.xu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.unsubscribe();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755425152, "Lcom/repackage/ow9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755425152, "Lcom/repackage/ow9;");
                return;
            }
        }
        a = new ow9();
    }

    public ow9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.tu9
    public tu9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (tu9.a) invokeV.objValue;
    }
}
