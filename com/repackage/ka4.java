package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ka4 implements da4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<r94> a;
    public x74 b;
    public List<d94> c;
    public List<d94> d;
    public List<d94> e;

    public ka4(x74 x74Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x74Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = x74Var;
        this.a = new ArrayList();
        fa4.b().e(this);
    }

    @Override // com.repackage.da4
    public <T> void a(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ha4Var) == null) {
        }
    }

    @Override // com.repackage.da4
    public <T> void b(ha4<T> ha4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha4Var) == null) || ha4Var.k()) {
            return;
        }
        Iterator<r94> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            r94 next = it.next();
            if (next.b(ha4Var)) {
                int i = ha4Var.i();
                this.a.remove(next);
                if (i == 2) {
                    this.e.add(next.a().a.b);
                } else if (i == 3) {
                    this.d.add(next.a().a.b);
                } else if (i == 10) {
                    this.c.add(next.a().a.b);
                }
            }
        }
        d();
    }

    public void c(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r94Var) == null) || r94Var == null) {
            return;
        }
        this.a.add(r94Var);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                fa4.b().g(this);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || d()) {
            return;
        }
        for (r94 r94Var : this.a) {
            r94Var.c(false);
        }
    }
}
