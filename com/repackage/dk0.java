package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dk0 extends dc1<gk0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements gk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ck0 b;

        public a(dk0 dk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new ck0();
        }

        @Override // com.repackage.gk0
        public <T extends fk0> void a(@Nullable T t) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || t == null) {
                return;
            }
            this.b.b(t);
        }

        @Override // com.repackage.gk0
        public <T extends fk0> void b(@NonNull Object obj, @NonNull ik0<T> ik0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, ik0Var) == null) {
                this.b.d(obj, ik0Var);
            }
        }

        @Override // com.repackage.gk0
        public <T extends fk0> void c(@NonNull Object obj, int i, @NonNull ik0<T> ik0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, obj, i, ik0Var) == null) {
                this.b.c(obj, i, ik0Var);
            }
        }

        @Override // com.repackage.gk0
        public void unregister(@NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                this.b.g(obj);
            }
        }
    }

    public dk0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.dc1
    /* renamed from: a */
    public gk0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (gk0) invokeV.objValue;
    }
}
