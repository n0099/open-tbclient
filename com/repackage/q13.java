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
/* loaded from: classes6.dex */
public class q13 extends r13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755433026, "Lcom/repackage/q13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755433026, "Lcom/repackage/q13;");
                return;
            }
        }
        b = eh1.a;
    }

    public q13() {
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

    @Override // com.repackage.r13
    public void a() {
        List<r23> b2;
        List<r23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new kl2(this));
            b(new hy1(this));
            b(new my1(this));
            b(new ay1(this));
            b(new n23(this));
            b(new y13(this));
            b(new z33(this));
            b(new ob2(this));
            b(new xb2(this));
            b(new pb2(this));
            b(new tb2(this));
            b(new ub2(this));
            b(new sb2(this));
            b(new yb2(this));
            b(new rb2(this));
            b(new wb2(this));
            b(new lg3(this));
            b(new vb2(this));
            b(new qb2(this));
            zh1 d = ck2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (r23 r23Var : a) {
                    b(r23Var);
                }
            }
            if (b) {
                b(new zb2(this));
                b(new s13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (r23 r23Var2 : b2) {
                    b(r23Var2);
                }
            }
        }
    }
}
