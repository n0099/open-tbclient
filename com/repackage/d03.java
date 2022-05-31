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
public class d03 extends e03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821270, "Lcom/repackage/d03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821270, "Lcom/repackage/d03;");
                return;
            }
        }
        b = rf1.a;
    }

    public d03() {
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

    @Override // com.repackage.e03
    public void a() {
        List<e13> b2;
        List<e13> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new xj2(this));
            b(new uw1(this));
            b(new zw1(this));
            b(new nw1(this));
            b(new a13(this));
            b(new l03(this));
            b(new m23(this));
            b(new ba2(this));
            b(new ka2(this));
            b(new ca2(this));
            b(new ga2(this));
            b(new ha2(this));
            b(new fa2(this));
            b(new la2(this));
            b(new ea2(this));
            b(new ja2(this));
            b(new ye3(this));
            b(new ia2(this));
            b(new da2(this));
            mg1 d = pi2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (e13 e13Var : a) {
                    b(e13Var);
                }
            }
            if (b) {
                b(new ma2(this));
                b(new f03(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (e13 e13Var2 : b2) {
                    b(e13Var2);
                }
            }
        }
    }
}
