package d.a.y0.p.d;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import d.a.y0.p.f.a;
import java.io.File;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71320a;

    /* renamed from: b  reason: collision with root package name */
    public int f71321b;

    /* renamed from: c  reason: collision with root package name */
    public int f71322c;

    /* renamed from: d  reason: collision with root package name */
    public int f71323d;

    /* renamed from: e  reason: collision with root package name */
    public float f71324e;

    /* renamed from: f  reason: collision with root package name */
    public float f71325f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.y0.p.f.a f71326g;

    /* renamed from: h  reason: collision with root package name */
    public a.f f71327h;

    /* renamed from: i  reason: collision with root package name */
    public a.b f71328i;
    public a.e j;
    public d.a.y0.p.g.b k;
    public String l;
    public int m;
    public SurfaceTexture n;
    public int o;
    public int p;
    public d.a.y0.p.g.c q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean v;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71320a = RecordConstants.VIDEO_CONSTANT_WIDTH;
        this.f71321b = RecordConstants.VIDEO_CONSTANT_HEIGHT;
        this.f71322c = RecordConstants.DEFAULT_BIT_RATE_GTE_API18;
        this.f71323d = 1;
        this.f71324e = 1.0f;
        this.f71325f = 0.0f;
        this.p = -100;
        this.s = false;
        this.t = 10000;
        this.u = 30;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.y0.p.f.a aVar = this.f71326g;
            if (aVar != null) {
                aVar.c();
                this.f71326g.l(null);
            }
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public void b(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f71325f = f2;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.o = i2;
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        if (this.o <= 0) {
            this.o = RecordConstants.VIDEO_CONSTANT_WIDTH;
        }
        this.f71320a = i2;
        this.f71321b = i3;
        if (i3 > i2) {
            int i4 = this.o;
            i3 = ((i3 * i4) / i2) - (((i4 * i3) / i2) % 16);
            i2 = i4;
        } else if (i3 < i2) {
            int i5 = this.o;
            i2 = ((i2 * i5) / i3) - (((i5 * i2) / i3) % 16);
            i3 = i5;
        }
        this.f71320a = i2;
        this.f71321b = i3;
    }

    public void e(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceTexture) == null) {
            this.n = surfaceTexture;
        }
    }

    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f71328i = bVar;
        }
    }

    public void g(a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void h(d.a.y0.p.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void i(d.a.y0.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.q = cVar;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.l = str;
            try {
                d.a.y0.p.f.a aVar = new d.a.y0.p.f.a();
                this.f71326g = aVar;
                aVar.d(this.f71324e);
                this.f71326g.B(this.p);
                if (this.f71325f != 0.0f) {
                    this.f71326g.A(this.f71325f);
                }
                this.f71326g.l(this.f71327h);
                this.f71326g.i(this.f71328i);
                this.f71326g.k(this.j);
                this.f71326g.r(this.q);
                this.f71326g.E(this.r);
                this.f71326g.I(this.s);
                this.f71326g.s(this.v);
            } catch (Throwable th) {
                d.a.y0.t.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f71322c = i2;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.r = z;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m++;
            try {
                if (this.f71326g != null && this.f71326g.u(2)) {
                    File file = new File(this.l);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (this.f71325f == 90.0f || this.f71325f == 270.0f) {
                        int i2 = this.f71320a;
                        this.f71320a = this.f71321b;
                        this.f71321b = i2;
                    }
                    this.f71326g.j(new a.d(file, this.f71320a, this.f71321b, this.f71322c, this.u, null, this.n.getTimestamp(), this.t));
                }
                if (this.f71326g == null || this.m % this.f71323d != 0 || this.k == null) {
                    return;
                }
                this.k.a(this.f71326g, this.n);
            } catch (Throwable th) {
                d.a.y0.t.c.c("VideoRecorder", th.toString());
            }
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.u = i2;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.s = z;
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.t = i2;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            d.a.y0.p.f.a aVar = this.f71326g;
            if (aVar != null) {
                return aVar.u(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.p = i2;
        }
    }

    public void t(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.f71324e = f2;
            if (Math.abs(f2 - 3.0f) < 0.01f) {
                this.f71323d = 2;
                return;
            }
            int i2 = (Math.abs(this.f71324e - 2.0f) > 0.01f ? 1 : (Math.abs(this.f71324e - 2.0f) == 0.01f ? 0 : -1));
            this.f71323d = 1;
        }
    }
}
