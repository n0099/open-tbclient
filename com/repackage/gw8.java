package com.repackage;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.v99;
/* loaded from: classes6.dex */
public class gw8 implements v99.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gw8 k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public v99.b b;
    public v99.b c;
    public v99.b d;
    public boolean e;
    public v99.f f;
    public SurfaceTexture g;
    public int h;
    public boolean i;
    public v99.a j;

    /* loaded from: classes6.dex */
    public class a implements v99.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gw8 a;

        public a(gw8 gw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gw8Var;
        }

        @Override // com.repackage.v99.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.d.k(this.a.g, this.a.f);
                if (this.a.i) {
                    this.a.i = false;
                    this.a.d.n();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755663511, "Lcom/repackage/gw8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755663511, "Lcom/repackage/gw8;");
        }
    }

    public gw8(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = false;
        this.j = new a(this);
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - ew8.b.c() >= ew8.a) {
                ew8.b.k(0);
            }
            if (1 != ew8.b.d().intValue()) {
                this.c = dw8.U(tbPageContext);
            }
        }
        fw8 B = fw8.B(tbPageContext);
        this.b = B;
        this.d = B;
    }

    public static gw8 D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (gw8.class) {
                    if (k == null) {
                        k = new gw8(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (gw8) invokeL.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null) {
            return;
        }
        this.b.u(this.h);
        this.b.i(this.c.o());
        this.b.m(this.c.a());
        this.b.j(this.c.p());
        this.c.q();
        this.c.release();
        this.d = this.b;
        this.e = false;
    }

    @Override // com.repackage.v99.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v99.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.v99.b
    public void c(int i, int i2, int i3, int i4) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.c(i, i2, i3, i4);
    }

    @Override // com.repackage.v99.b
    public void d(byte[] bArr) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (bVar = this.d) == this.b && bVar != null) {
            bVar.d(bArr);
        }
    }

    @Override // com.repackage.v99.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.v99.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v99.b
    public void g(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.b.g(i, i2, i3, z);
            v99.b bVar = this.c;
            if (bVar != null) {
                bVar.g(i, i2, i3, z);
            }
        }
    }

    @Override // com.repackage.v99.b
    public void h(boolean z) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e = z;
            if (z && (bVar = this.c) != null) {
                bVar.s(this.j);
                this.d = this.c;
                return;
            }
            v99.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            this.d = this.b;
        }
    }

    @Override // com.repackage.v99.b
    public void i(boolean z) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.i(z);
    }

    @Override // com.repackage.v99.b
    public void j(boolean z) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.j(z);
    }

    @Override // com.repackage.v99.b
    public boolean k(SurfaceTexture surfaceTexture, v99.f fVar) {
        InterceptResult invokeLL;
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.g = surfaceTexture;
            this.f = fVar;
            if (this.e && (bVar = this.c) != null) {
                if (bVar.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                v99.b bVar2 = this.d;
                if (bVar2 != null) {
                    boolean k2 = bVar2.k(surfaceTexture, fVar);
                    if (this.i) {
                        this.i = false;
                        this.d.n();
                    }
                    return k2;
                }
                return false;
            }
            v99.b bVar3 = this.b;
            this.d = bVar3;
            if (bVar3 != null) {
                return bVar3.k(surfaceTexture, fVar);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.v99.b
    public void l(int i) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.l(i);
    }

    @Override // com.repackage.v99.b
    public void m(boolean z) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.m(z);
    }

    @Override // com.repackage.v99.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            v99.b bVar = this.d;
            if (bVar != null) {
                bVar.n();
            }
        }
    }

    @Override // com.repackage.v99.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v99.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.v99.b
    public void q() {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.q();
    }

    @Override // com.repackage.v99.b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.v99.b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.d = null;
            v99.b bVar = this.b;
            if (bVar != null) {
                bVar.release();
            }
            v99.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            k = null;
            this.f = null;
            this.g = null;
            this.j = null;
        }
    }

    @Override // com.repackage.v99.b
    public void s(v99.a aVar) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) || (bVar = this.c) == null) {
            return;
        }
        bVar.s(aVar);
    }

    @Override // com.repackage.v99.b
    public void t(int i, int i2, int i3, int i4) {
        v99.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048597, this, i, i2, i3, i4) == null) || (bVar = this.d) == null) {
            return;
        }
        bVar.t(i, i2, i3, i4);
    }

    @Override // com.repackage.v99.b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.h = i;
            v99.b bVar = this.d;
            if (bVar != null) {
                bVar.u(i);
            }
        }
    }

    @Override // com.repackage.v99.b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            v99.b bVar = this.d;
            if (bVar != null) {
                return bVar.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
