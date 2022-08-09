package com.repackage;

import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Service
/* loaded from: classes7.dex */
public class v13 extends w13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755284071, "Lcom/repackage/v13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755284071, "Lcom/repackage/v13;");
                return;
            }
        }
        b = jh1.a;
    }

    public v13() {
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

    @Override // com.repackage.w13
    public void a() {
        List<w23> b2;
        List<w23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new pl2(this));
            b(new my1(this));
            b(new ry1(this));
            b(new fy1(this));
            b(new s23(this));
            b(new d23(this));
            b(new e43(this));
            b(new tb2(this));
            b(new cc2(this));
            b(new ub2(this));
            b(new yb2(this));
            b(new zb2(this));
            b(new xb2(this));
            b(new dc2(this));
            b(new wb2(this));
            b(new bc2(this));
            b(new qg3(this));
            b(new ac2(this));
            b(new vb2(this));
            ei1 d = hk2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (w23 w23Var : a) {
                    b(w23Var);
                }
            }
            if (b) {
                b(new ec2(this));
                b(new x13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (w23 w23Var2 : b2) {
                    b(w23Var2);
                }
            }
        }
    }
}
