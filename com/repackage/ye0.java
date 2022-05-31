package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xe0;
import java.util.Map;
@Service
/* loaded from: classes7.dex */
public class ye0 extends hg0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements xe0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pg0 a;
        public final /* synthetic */ lg0 b;
        public final /* synthetic */ ye0 c;

        public a(ye0 ye0Var, pg0 pg0Var, lg0 lg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye0Var, pg0Var, lg0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ye0Var;
            this.a = pg0Var;
            this.b = lg0Var;
        }

        @Override // com.repackage.xe0.c
        public void onResult(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.c.c(this.a, this.b, z ? 0 : 1001, z);
            }
        }
    }

    public ye0() {
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

    @Override // com.repackage.hg0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "dlink" : (String) invokeV.objValue;
    }

    @Override // com.repackage.hg0
    public boolean b(@NonNull Context context, @NonNull lg0 lg0Var, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lg0Var, map, pg0Var)) == null) {
            super.b(context, lg0Var, map, pg0Var);
            new xe0().g(context, lg0Var.d(), new a(this, pg0Var, lg0Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
