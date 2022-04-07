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
public class f13 extends g13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755760727, "Lcom/repackage/f13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755760727, "Lcom/repackage/f13;");
                return;
            }
        }
        b = tg1.a;
    }

    public f13() {
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

    @Override // com.repackage.g13
    public void a() {
        List<g23> b2;
        List<g23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new zk2(this));
            b(new wx1(this));
            b(new by1(this));
            b(new px1(this));
            b(new c23(this));
            b(new n13(this));
            b(new o33(this));
            b(new db2(this));
            b(new mb2(this));
            b(new eb2(this));
            b(new ib2(this));
            b(new jb2(this));
            b(new hb2(this));
            b(new nb2(this));
            b(new gb2(this));
            b(new lb2(this));
            b(new ag3(this));
            b(new kb2(this));
            b(new fb2(this));
            oh1 d = rj2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (g23 g23Var : a) {
                    b(g23Var);
                }
            }
            if (b) {
                b(new ob2(this));
                b(new h13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (g23 g23Var2 : b2) {
                    b(g23Var2);
                }
            }
        }
    }
}
