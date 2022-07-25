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
public class e13 extends f13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755790518, "Lcom/repackage/e13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755790518, "Lcom/repackage/e13;");
                return;
            }
        }
        b = sg1.a;
    }

    public e13() {
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

    @Override // com.repackage.f13
    public void a() {
        List<f23> b2;
        List<f23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new yk2(this));
            b(new vx1(this));
            b(new ay1(this));
            b(new ox1(this));
            b(new b23(this));
            b(new m13(this));
            b(new n33(this));
            b(new cb2(this));
            b(new lb2(this));
            b(new db2(this));
            b(new hb2(this));
            b(new ib2(this));
            b(new gb2(this));
            b(new mb2(this));
            b(new fb2(this));
            b(new kb2(this));
            b(new zf3(this));
            b(new jb2(this));
            b(new eb2(this));
            nh1 d = qj2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (f23 f23Var : a) {
                    b(f23Var);
                }
            }
            if (b) {
                b(new nb2(this));
                b(new g13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (f23 f23Var2 : b2) {
                    b(f23Var2);
                }
            }
        }
    }
}
