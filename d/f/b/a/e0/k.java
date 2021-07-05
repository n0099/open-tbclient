package d.f.b.a.e0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import d.f.b.a.l;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public final class k extends d.f.b.a.a implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler m;
    public final j n;
    public final g o;
    public final l p;
    public boolean q;
    public boolean r;
    public int s;
    public Format t;
    public f u;
    public h v;
    public i w;
    public i x;
    public int y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        this(jVar, looper, g.f73035a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((j) objArr2[0], (Looper) objArr2[1], (g) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.f.b.a.a
    public void A(Format[] formatArr, long j) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, formatArr, j) == null) {
            Format format = formatArr[0];
            this.t = format;
            if (this.u != null) {
                this.s = 1;
            } else {
                this.u = this.o.b(format);
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            K(Collections.emptyList());
        }
    }

    public final long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.y;
            if (i2 == -1 || i2 >= this.w.b()) {
                return Long.MAX_VALUE;
            }
            return this.w.a(this.y);
        }
        return invokeV.longValue;
    }

    public final void G(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.n.i(list);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v = null;
            this.y = -1;
            i iVar = this.w;
            if (iVar != null) {
                iVar.m();
                this.w = null;
            }
            i iVar2 = this.x;
            if (iVar2 != null) {
                iVar2.m();
                this.x = null;
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            H();
            this.u.release();
            this.u = null;
            this.s = 0;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            I();
            this.u = this.o.b(this.t);
        }
    }

    public final void K(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            Handler handler = this.m;
            if (handler != null) {
                handler.obtainMessage(0, list).sendToTarget();
            } else {
                G(list);
            }
        }
    }

    @Override // d.f.b.a.s
    public int a(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, format)) == null) ? this.o.a(format) ? d.f.b.a.a.D(null, format.drmInitData) ? 4 : 2 : d.f.b.a.i0.i.h(format.sampleMimeType) ? 1 : 0 : invokeL.intValue;
    }

    @Override // d.f.b.a.r
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            if (message.what == 0) {
                G((List) message.obj);
                return true;
            }
            throw new IllegalStateException();
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.r
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.f.b.a.r
    public void j(long j, long j2) throws ExoPlaybackException {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.r) {
            return;
        }
        if (this.x == null) {
            this.u.b(j);
            try {
                this.x = this.u.c();
            } catch (SubtitleDecoderException e2) {
                throw ExoPlaybackException.createForRenderer(e2, t());
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.w != null) {
            long F = F();
            z = false;
            while (F <= j) {
                this.y++;
                F = F();
                z = true;
            }
        } else {
            z = false;
        }
        i iVar = this.x;
        if (iVar != null) {
            if (iVar.j()) {
                if (!z && F() == Long.MAX_VALUE) {
                    if (this.s == 2) {
                        J();
                    } else {
                        H();
                        this.r = true;
                    }
                }
            } else if (this.x.f73655f <= j) {
                i iVar2 = this.w;
                if (iVar2 != null) {
                    iVar2.m();
                }
                i iVar3 = this.x;
                this.w = iVar3;
                this.x = null;
                this.y = iVar3.c(j);
                z = true;
            }
        }
        if (z) {
            K(this.w.d(j));
        }
        if (this.s == 2) {
            return;
        }
        while (!this.q) {
            try {
                if (this.v == null) {
                    h a2 = this.u.a();
                    this.v = a2;
                    if (a2 == null) {
                        return;
                    }
                }
                if (this.s == 1) {
                    this.v.l(4);
                    this.u.d(this.v);
                    this.v = null;
                    this.s = 2;
                    return;
                }
                int B = B(this.p, this.v, false);
                if (B == -4) {
                    if (this.v.j()) {
                        this.q = true;
                    } else {
                        this.v.j = this.p.f73492a.subsampleOffsetUs;
                        this.v.o();
                    }
                    this.u.d(this.v);
                    this.v = null;
                } else if (B == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e3) {
                throw ExoPlaybackException.createForRenderer(e3, t());
            }
        }
    }

    @Override // d.f.b.a.a
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.t = null;
            E();
            I();
        }
    }

    @Override // d.f.b.a.a
    public void x(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            E();
            this.q = false;
            this.r = false;
            if (this.s != 0) {
                J();
                return;
            }
            H();
            this.u.flush();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper, g gVar) {
        super(3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, looper, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.e(jVar);
        this.n = jVar;
        this.m = looper == null ? null : new Handler(looper, this);
        this.o = gVar;
        this.p = new l();
    }
}
