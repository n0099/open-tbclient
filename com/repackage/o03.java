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
public class o03 extends p03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755493569, "Lcom/repackage/o03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755493569, "Lcom/repackage/o03;");
                return;
            }
        }
        b = cg1.a;
    }

    public o03() {
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

    @Override // com.repackage.p03
    public void a() {
        List<p13> b2;
        List<p13> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ik2(this));
            b(new fx1(this));
            b(new kx1(this));
            b(new yw1(this));
            b(new l13(this));
            b(new w03(this));
            b(new x23(this));
            b(new ma2(this));
            b(new va2(this));
            b(new na2(this));
            b(new ra2(this));
            b(new sa2(this));
            b(new qa2(this));
            b(new wa2(this));
            b(new pa2(this));
            b(new ua2(this));
            b(new jf3(this));
            b(new ta2(this));
            b(new oa2(this));
            xg1 d = aj2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (p13 p13Var : a) {
                    b(p13Var);
                }
            }
            if (b) {
                b(new xa2(this));
                b(new q03(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (p13 p13Var2 : b2) {
                    b(p13Var2);
                }
            }
        }
    }
}
