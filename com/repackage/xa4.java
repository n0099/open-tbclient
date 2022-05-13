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
/* loaded from: classes7.dex */
public class xa4 implements qa4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ea4> a;
    public k84 b;
    public List<q94> c;
    public List<q94> d;
    public List<q94> e;

    public xa4(k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k84Var};
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
        this.b = k84Var;
        this.a = new ArrayList();
        sa4.b().e(this);
    }

    @Override // com.repackage.qa4
    public <T> void a(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ua4Var) == null) {
        }
    }

    @Override // com.repackage.qa4
    public <T> void b(ua4<T> ua4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua4Var) == null) || ua4Var.k()) {
            return;
        }
        Iterator<ea4> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ea4 next = it.next();
            if (next.b(ua4Var)) {
                int i = ua4Var.i();
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

    public void c(ea4 ea4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ea4Var) == null) || ea4Var == null) {
            return;
        }
        this.a.add(ea4Var);
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a.isEmpty()) {
                this.b.b();
                sa4.b().g(this);
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
        for (ea4 ea4Var : this.a) {
            ea4Var.c(false);
        }
    }
}
