package com.repackage;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u25 {
    public static /* synthetic */ Interceptable $ic;
    public static u25 g;
    public transient /* synthetic */ FieldHolder $fh;
    public zf<String, um> a;
    public zf<String, um> b;
    public zf<String, Bitmap> c;
    public zf<String, um> d;
    public ag<sd5> e;
    public xd5 f;

    /* loaded from: classes7.dex */
    public class a extends zf<String, um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u25 u25Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u25Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: o */
        public void b(boolean z, String str, um umVar, um umVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, umVar, umVar2}) == null) || umVar == null) {
                return;
            }
            umVar.x();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends zf<String, um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u25 u25Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u25Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: o */
        public void b(boolean z, String str, um umVar, um umVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, umVar, umVar2}) == null) || umVar == null) {
                return;
            }
            BdLog.isDebugMode();
            umVar.x();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016308, str));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: p */
        public int m(String str, um umVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, umVar)) == null) {
                if (umVar != null) {
                    return umVar.B();
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends zf<String, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u25 u25Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u25Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zf
        /* renamed from: o */
        public void b(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, bitmap, bitmap2}) == null) || bitmap == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312839, "Lcom/repackage/u25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312839, "Lcom/repackage/u25;");
                return;
            }
        }
        g = new u25();
    }

    public u25() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = new a(this, 0);
        this.b = new b(this, 0);
        this.c = new c(this, 0);
        this.d = new zf<>(Integer.MAX_VALUE);
    }

    public static u25 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? g : (u25) invokeV.objValue;
    }

    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) || StringUtils.isNull(str) || bitmap == null) {
            return;
        }
        this.c.h(str, bitmap);
    }

    public void b(String str, um umVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, umVar) == null) {
            c(str, umVar, false);
        }
    }

    public void c(String str, um umVar, boolean z) {
        zf<String, um> zfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, umVar, z) == null) || umVar == null || (zfVar = this.a) == null) {
            return;
        }
        zfVar.h(str, umVar);
    }

    public void d(String str, um umVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, umVar) == null) {
            e(str, umVar, false);
        }
    }

    public void e(String str, um umVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, str, umVar, z) == null) || umVar == null || this.b == null) {
            return;
        }
        BdLog.isDebugMode();
        this.b.h(str, umVar);
    }

    public void f(String str, um umVar) {
        zf<String, um> zfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, umVar) == null) || umVar == null || (zfVar = this.d) == null) {
            return;
        }
        zfVar.h(str, umVar);
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a.i(str);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.b.i(str);
        }
    }

    public boolean i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? this.b.e(i) : invokeI.booleanValue;
    }

    public Bitmap j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.c.f(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public um l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.a.f(str) : (um) invokeL.objValue;
    }

    public um m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.b.f(str) : (um) invokeL.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.b.g() : invokeV.intValue;
    }

    public um o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.d.f(str);
        }
        return (um) invokeL.objValue;
    }

    public ag<sd5> p(int i) {
        InterceptResult invokeI;
        xd5 xd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (this.e != null && (xd5Var = this.f) != null) {
                if (xd5Var.g() == i) {
                    return this.e;
                }
                this.f.j(i);
                this.e.c();
            }
            if (this.f == null) {
                this.f = new xd5(i);
            }
            if (this.e == null) {
                this.e = new ag<>(this.f, 6, 0);
            }
            return this.e;
        }
        return (ag) invokeI.objValue;
    }

    public void q(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            t(i);
            u(i2);
            s(60);
        }
    }

    public void r() {
        ag<sd5> agVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (agVar = this.e) == null) {
            return;
        }
        agVar.g(0);
        this.e.f(0);
        this.e.c();
        this.e = null;
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c.k(i);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a.k(i);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "pic:" + this.b.toString() + "  photo:" + this.a.toString();
        }
        return (String) invokeV.objValue;
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.b.k(i);
        }
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b.l() + "/" + this.b.g() + "/" + this.b.d() + "_" + this.a.l() + "/" + this.a.g() + "/" + this.a.d();
        }
        return (String) invokeV.objValue;
    }
}
