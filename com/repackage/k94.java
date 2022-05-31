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
public class k94 implements d94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<r84> a;
    public x64 b;
    public List<d84> c;
    public List<d84> d;
    public List<d84> e;

    public k94(x64 x64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x64Var};
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
        this.b = x64Var;
        this.a = new ArrayList();
        f94.b().e(this);
    }

    @Override // com.repackage.d94
    public <T> void a(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) {
        }
    }

    @Override // com.repackage.d94
    public <T> void b(h94<T> h94Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var) == null) || h94Var.k()) {
            return;
        }
        Iterator<r84> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            r84 next = it.next();
            if (next.b(h94Var)) {
                int i = h94Var.i();
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

    public void c(r84 r84Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r84Var) == null) || r84Var == null) {
            return;
        }
        this.a.add(r84Var);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                f94.b().g(this);
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
        for (r84 r84Var : this.a) {
            r84Var.c(false);
        }
    }
}
