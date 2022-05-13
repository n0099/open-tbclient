package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d;
import com.repackage.e;
import com.repackage.w10;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class m implements w10, d.a, e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s10 a;
    public g b;
    public Executor c;
    public String d;
    public p e;
    public w10.a f;
    public int g;
    public i h;
    public d i;
    public List<e> j;

    public m(s10 s10Var, g gVar, Executor executor, String str, p pVar, w10.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s10Var, gVar, executor, str, pVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = s10Var;
        this.b = gVar;
        this.c = executor;
        this.d = str;
        this.e = pVar;
        this.f = aVar;
        this.h = new i(s10Var.b().toString(), this.a.c(), this.a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i iVar = this.h;
            File file = new File(iVar.b, iVar.a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            g gVar = this.b;
            gVar.b.n(j);
            gVar.b.o(j2);
            gVar.b.p((int) ((100 * j) / j2));
            gVar.b.r(104);
            gVar.a.a(gVar.b);
        }
    }

    public void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((h) this.i).d()) {
                e();
                return;
            }
            if (((h) this.i).c == 106) {
                h();
                return;
            }
            this.g = 108;
            g gVar = this.b;
            gVar.b.m(downloadException);
            gVar.b.r(108);
            gVar.a.a(gVar.b);
            i();
        }
    }

    @Override // com.repackage.w10
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d dVar = this.i;
            if (dVar != null) {
                ((h) dVar).c = 107;
            }
            Iterator<e> it = this.j.iterator();
            while (it.hasNext()) {
                ((o) it.next()).f = 107;
            }
            if (this.g != 104) {
                g();
            }
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<e> it = this.j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((o) it.next()).e != 105) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            if (z) {
                this.g = 105;
                g gVar = this.b;
                gVar.b.r(105);
                gVar.b.q(str);
                gVar.a.a(gVar.b);
                i();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.g = 107;
            g gVar = this.b;
            gVar.b.r(107);
            gVar.a.a(gVar.b);
            i();
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<e> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((o) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.g = 108;
                g gVar = this.b;
                gVar.b.m(downloadException);
                gVar.b.r(108);
                gVar.a.a(gVar.b);
                i();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<e> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((o) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                a();
                this.g = 107;
                g gVar = this.b;
                gVar.b.r(107);
                gVar.a.a(gVar.b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<e> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((o) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.g = 106;
                g gVar = this.b;
                gVar.b.r(106);
                gVar.a.a(gVar.b);
                i();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.a(this.d, this);
        }
    }

    @Override // com.repackage.w10
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w10
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d dVar = this.i;
            if (dVar != null) {
                ((h) dVar).c = 106;
            }
            Iterator<e> it = this.j.iterator();
            while (it.hasNext()) {
                ((o) it.next()).f = 106;
            }
            if (this.g != 104) {
                h();
            }
        }
    }

    @Override // com.repackage.w10
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = 101;
            g gVar = this.b;
            gVar.b.r(101);
            gVar.b.a().h();
            h hVar = new h(this.a.c(), this);
            this.i = hVar;
            this.c.execute(hVar);
        }
    }
}
