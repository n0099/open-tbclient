package com.repackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends no0<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky0 a;

        public a(ky0 ky0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky0Var;
        }

        @Override // com.repackage.lo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                iy0.b(this.a.a(i, exc.getMessage()));
            }
        }

        @Override // com.repackage.mo0
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                iy0.b(this.a.a(i, "success"));
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    public static void a(@Nullable ky0 ky0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, ky0Var) == null) || ky0Var == null || TextUtils.isEmpty(ky0Var.d())) {
            return;
        }
        if (!ky0Var.c()) {
            b(ky0Var.d());
            return;
        }
        uo0 uo0Var = new uo0();
        uo0Var.k(ky0Var.d());
        uo0Var.g(3000);
        uo0Var.d("User-Agent", hh0.e());
        uo0Var.c();
        co0.b().a().a(uo0Var, new a(ky0Var));
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        uo0 uo0Var = new uo0();
        uo0Var.k(str);
        uo0Var.g(3000);
        uo0Var.d("User-Agent", hh0.e());
        uo0Var.c();
        co0.b().a().a(uo0Var, null);
    }
}
