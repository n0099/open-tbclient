package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ou6;
import com.squareup.wire.Message;
/* loaded from: classes7.dex */
public class qs6 implements oe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ou6.d a;

    public qs6(ou6.d dVar) {
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

    @Override // com.repackage.oe7
    public void a(boolean z, Message message, boolean z2, long j, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i)}) == null) {
            rs6 rs6Var = new rs6();
            he7 he7Var = new he7();
            he7Var.a = j;
            he7Var.b = str;
            de7 a = me7.d().a(he7Var);
            if (a != null) {
                a.c(z, message, z2, i);
            }
            rs6Var.b(a);
            ou6.d dVar = this.a;
            if (dVar != null) {
                dVar.e(z, rs6Var, z2, "", str, true);
            }
        }
    }

    @Override // com.repackage.oe7
    public void b(long j, String str, String str2, int i) {
        ou6.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) || (dVar = this.a) == null) {
            return;
        }
        dVar.c(str, str2, i, true, 1);
    }

    @Override // com.repackage.oe7
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
