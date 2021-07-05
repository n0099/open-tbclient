package d.f.b.a;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class a implements r, s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f72086e;

    /* renamed from: f  reason: collision with root package name */
    public t f72087f;

    /* renamed from: g  reason: collision with root package name */
    public int f72088g;

    /* renamed from: h  reason: collision with root package name */
    public int f72089h;

    /* renamed from: i  reason: collision with root package name */
    public d.f.b.a.d0.o f72090i;
    public long j;
    public boolean k;
    public boolean l;

    public a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72086e = i2;
        this.k = true;
    }

    public static boolean D(@Nullable d.f.b.a.z.a<?> aVar, @Nullable DrmInitData drmInitData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, drmInitData)) == null) {
            if (drmInitData == null) {
                return true;
            }
            if (aVar == null) {
                return false;
            }
            return aVar.b(drmInitData);
        }
        return invokeLL.booleanValue;
    }

    public void A(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, formatArr, j) == null) {
        }
    }

    public final int B(l lVar, d.f.b.a.y.e eVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, eVar, z)) == null) {
            int f2 = this.f72090i.f(lVar, eVar, z);
            if (f2 == -4) {
                if (eVar.j()) {
                    this.k = true;
                    return this.l ? -4 : -3;
                }
                eVar.f73653h += this.j;
            } else if (f2 == -5) {
                Format format = lVar.f73492a;
                long j = format.subsampleOffsetUs;
                if (j != Long.MAX_VALUE) {
                    lVar.f73492a = format.copyWithSubsampleOffsetUs(j + this.j);
                }
            }
            return f2;
        }
        return invokeLLZ.intValue;
    }

    public int C(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f72090i.j(j - this.j) : invokeJ.intValue;
    }

    @Override // d.f.b.a.r
    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // d.f.b.a.r
    public final void f(t tVar, Format[] formatArr, d.f.b.a.d0.o oVar, long j, boolean z, long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tVar, formatArr, oVar, Long.valueOf(j), Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
            d.f.b.a.i0.a.f(this.f72089h == 0);
            this.f72087f = tVar;
            this.f72089h = 1;
            w(z);
            r(formatArr, oVar, j2);
            x(j, z);
        }
    }

    @Override // d.f.b.a.g.a
    public void g(int i2, Object obj) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, obj) == null) {
        }
    }

    @Override // d.f.b.a.r
    public final int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72089h : invokeV.intValue;
    }

    @Override // d.f.b.a.r
    public final d.f.b.a.d0.o getStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72090i : (d.f.b.a.d0.o) invokeV.objValue;
    }

    @Override // d.f.b.a.r, d.f.b.a.s
    public final int getTrackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72086e : invokeV.intValue;
    }

    @Override // d.f.b.a.r
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.f.b.a.i0.a.f(this.f72089h == 1);
            this.f72089h = 0;
            this.f72090i = null;
            this.l = false;
            v();
        }
    }

    @Override // d.f.b.a.r
    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.booleanValue;
    }

    @Override // d.f.b.a.r
    public final void k(long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.l = false;
            this.k = false;
            x(j, false);
        }
    }

    @Override // d.f.b.a.r
    public d.f.b.a.i0.h l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (d.f.b.a.i0.h) invokeV.objValue;
    }

    @Override // d.f.b.a.r
    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l = true;
        }
    }

    @Override // d.f.b.a.r
    public final void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f72090i.a();
        }
    }

    @Override // d.f.b.a.r
    public final s o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this : (s) invokeV.objValue;
    }

    public int q() throws ExoPlaybackException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.r
    public final void r(Format[] formatArr, d.f.b.a.d0.o oVar, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{formatArr, oVar, Long.valueOf(j)}) == null) {
            d.f.b.a.i0.a.f(!this.l);
            this.f72090i = oVar;
            this.k = false;
            this.j = j;
            A(formatArr, j);
        }
    }

    public final t s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f72087f : (t) invokeV.objValue;
    }

    @Override // d.f.b.a.r
    public final void setIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f72088g = i2;
        }
    }

    @Override // d.f.b.a.r
    public final void start() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.f.b.a.i0.a.f(this.f72089h == 1);
            this.f72089h = 2;
            y();
        }
    }

    @Override // d.f.b.a.r
    public final void stop() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            d.f.b.a.i0.a.f(this.f72089h == 2);
            this.f72089h = 1;
            z();
        }
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f72088g : invokeV.intValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k ? this.l : this.f72090i.isReady() : invokeV.booleanValue;
    }

    public abstract void v();

    public void w(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    public abstract void x(long j, boolean z) throws ExoPlaybackException;

    public void y() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void z() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }
}
