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
/* loaded from: classes5.dex */
public class d13 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755820309, "Lcom/repackage/d13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755820309, "Lcom/repackage/d13;");
                return;
            }
        }
        b = rg1.a;
    }

    public d13() {
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

    @Override // com.repackage.e13
    public void a() {
        List<e23> b2;
        List<e23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new xk2(this));
            b(new ux1(this));
            b(new zx1(this));
            b(new nx1(this));
            b(new a23(this));
            b(new l13(this));
            b(new m33(this));
            b(new bb2(this));
            b(new kb2(this));
            b(new cb2(this));
            b(new gb2(this));
            b(new hb2(this));
            b(new fb2(this));
            b(new lb2(this));
            b(new eb2(this));
            b(new jb2(this));
            b(new yf3(this));
            b(new ib2(this));
            b(new db2(this));
            mh1 d = pj2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (e23 e23Var : a) {
                    b(e23Var);
                }
            }
            if (b) {
                b(new mb2(this));
                b(new f13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (e23 e23Var2 : b2) {
                    b(e23Var2);
                }
            }
        }
    }
}
