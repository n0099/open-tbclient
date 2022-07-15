package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nu6;
import com.squareup.wire.Message;
/* loaded from: classes6.dex */
public class ls6 implements fe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nu6.d a;

    public ls6(nu6.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
    }

    @Override // com.repackage.fe7
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            ms6 ms6Var = new ms6();
            yd7 yd7Var = new yd7();
            yd7Var.a = j;
            yd7Var.b = str;
            ud7 a = de7.d().a(yd7Var);
            if (a != null) {
                a.d(z, message, z2, i);
            }
            ms6Var.b(a);
            nu6.d dVar = this.a;
            if (dVar != null) {
                dVar.e(z, ms6Var, z2, "", str, true);
            }
        }
    }

    @Override // com.repackage.fe7
    public void b(long j, String str, String str2, int i) {
        nu6.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) || (dVar = this.a) == null) {
            return;
        }
        dVar.c(str, str2, i, true, 1);
    }

    @Override // com.repackage.fe7
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
