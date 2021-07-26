package d.f.b.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import d.f.b.a.d0.l;
import d.f.b.a.g;
import d.f.b.a.q;
import d.f.b.a.w;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes8.dex */
public final class i implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final r[] f70898a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.f0.h f70899b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.f0.g f70900c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f70901d;

    /* renamed from: e  reason: collision with root package name */
    public final j f70902e;

    /* renamed from: f  reason: collision with root package name */
    public final CopyOnWriteArraySet<q.b> f70903f;

    /* renamed from: g  reason: collision with root package name */
    public final w.c f70904g;

    /* renamed from: h  reason: collision with root package name */
    public final w.b f70905h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70906i;
    public boolean j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public d.f.b.a.d0.t q;
    public d.f.b.a.f0.g r;
    public p s;
    public o t;
    public int u;
    public int v;
    public long w;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f70907a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70907a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f70907a.x(message);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public i(r[] rVarArr, d.f.b.a.f0.h hVar, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVarArr, hVar, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + d.f.b.a.i0.v.f70973e + PreferencesUtil.RIGHT_MOUNT);
        d.f.b.a.i0.a.f(rVarArr.length > 0);
        d.f.b.a.i0.a.e(rVarArr);
        this.f70898a = rVarArr;
        d.f.b.a.i0.a.e(hVar);
        this.f70899b = hVar;
        this.j = false;
        this.k = 0;
        this.l = false;
        this.m = 1;
        this.f70903f = new CopyOnWriteArraySet<>();
        this.f70900c = new d.f.b.a.f0.g(new d.f.b.a.f0.f[rVarArr.length]);
        this.f70904g = new w.c();
        this.f70905h = new w.b();
        this.q = d.f.b.a.d0.t.f70308d;
        this.r = this.f70900c;
        this.s = p.f71069d;
        this.f70901d = new a(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.t = new o(w.f71085a, null, 0, 0L);
        this.f70902e = new j(rVarArr, hVar, mVar, this.j, this.k, this.l, this.f70901d, this);
    }

    public void A(d.f.b.a.d0.l lVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                this.u = k();
                this.v = w();
                this.w = getCurrentPosition();
            } else {
                this.u = 0;
                this.v = 0;
                this.w = 0L;
            }
            if (z2) {
                if (!this.t.f71062a.p() || this.t.f71063b != null) {
                    this.t = this.t.c(w.f71085a, null);
                    Iterator<q.b> it = this.f70903f.iterator();
                    while (it.hasNext()) {
                        o oVar = this.t;
                        it.next().c(oVar.f71062a, oVar.f71063b);
                    }
                }
                if (this.f70906i) {
                    this.f70906i = false;
                    this.q = d.f.b.a.d0.t.f70308d;
                    this.r = this.f70900c;
                    this.f70899b.b(null);
                    Iterator<q.b> it2 = this.f70903f.iterator();
                    while (it2.hasNext()) {
                        it2.next().j(this.q, this.r);
                    }
                }
            }
            this.o++;
            this.f70902e.z(lVar, z);
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.t.f71062a.p() || this.n > 0 || this.o > 0 : invokeV.booleanValue;
    }

    @Override // d.f.b.a.g
    public void a(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr) == null) {
            this.f70902e.a(bVarArr);
        }
    }

    @Override // d.f.b.a.g
    public void b(d.f.b.a.d0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lVar) == null) {
            A(lVar, true, true);
        }
    }

    @Override // d.f.b.a.q
    public void c(@Nullable p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            if (pVar == null) {
                pVar = p.f71069d;
            }
            this.f70902e.T(pVar);
        }
    }

    @Override // d.f.b.a.q
    public p d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s : (p) invokeV.objValue;
    }

    @Override // d.f.b.a.q
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !B() && this.t.f71064c.b() : invokeV.booleanValue;
    }

    @Override // d.f.b.a.q
    public void f(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f70903f.remove(bVar);
        }
    }

    @Override // d.f.b.a.q
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.booleanValue;
    }

    @Override // d.f.b.a.q
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (B()) {
                return this.w;
            }
            return z(this.t.f71067f);
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.q
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            w wVar = this.t.f71062a;
            if (wVar.p()) {
                return -9223372036854775807L;
            }
            if (e()) {
                l.b bVar = this.t.f71064c;
                wVar.f(bVar.f70266a, this.f70905h);
                return b.b(this.f70905h.b(bVar.f70267b, bVar.f70268c));
            }
            return wVar.l(k(), this.f70904g).b();
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.q
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.l == z) {
            return;
        }
        this.l = z;
        this.f70902e.Y(z);
        Iterator<q.b> it = this.f70903f.iterator();
        while (it.hasNext()) {
            it.next().b(z);
        }
    }

    @Override // d.f.b.a.q
    public void i(q.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.f70903f.add(bVar);
        }
    }

    @Override // d.f.b.a.q
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            long t = t();
            long duration = getDuration();
            if (t == -9223372036854775807L || duration == -9223372036854775807L) {
                return 0;
            }
            if (duration == 0) {
                return 100;
            }
            return d.f.b.a.i0.v.k((int) ((t * 100) / duration), 0, 100);
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (B()) {
                return this.u;
            }
            o oVar = this.t;
            return oVar.f71062a.f(oVar.f71064c.f70266a, this.f70905h).f71088c;
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.j == z) {
            return;
        }
        this.j = z;
        this.f70902e.R(z);
        Iterator<q.b> it = this.f70903f.iterator();
        while (it.hasNext()) {
            it.next().m(z, this.m);
        }
    }

    @Override // d.f.b.a.q
    public w m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.t.f71062a : (w) invokeV.objValue;
    }

    @Override // d.f.b.a.q
    public d.f.b.a.f0.g n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.r : (d.f.b.a.f0.g) invokeV.objValue;
    }

    @Override // d.f.b.a.q
    public int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? this.f70898a[i2].e() : invokeI.intValue;
    }

    @Override // d.f.b.a.q
    public void p(int i2, long j) {
        long a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            w wVar = this.t.f71062a;
            if (i2 >= 0 && (wVar.p() || i2 < wVar.o())) {
                if (e()) {
                    Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    if (this.n == 0) {
                        Iterator<q.b> it = this.f70903f.iterator();
                        while (it.hasNext()) {
                            it.next().e();
                        }
                        return;
                    }
                    return;
                }
                this.n++;
                this.u = i2;
                if (wVar.p()) {
                    this.w = j == -9223372036854775807L ? 0L : j;
                    this.v = 0;
                } else {
                    wVar.l(i2, this.f70904g);
                    if (j == -9223372036854775807L) {
                        a2 = this.f70904g.a();
                    } else {
                        a2 = b.a(j);
                    }
                    w.c cVar = this.f70904g;
                    int i3 = cVar.f71100f;
                    long c2 = cVar.c() + a2;
                    long h2 = wVar.f(i3, this.f70905h).h();
                    while (h2 != -9223372036854775807L && c2 >= h2 && i3 < this.f70904g.f71101g) {
                        c2 -= h2;
                        i3++;
                        h2 = wVar.f(i3, this.f70905h).h();
                    }
                    this.w = b.b(a2);
                    this.v = i3;
                }
                this.f70902e.L(wVar, i2, b.a(j));
                Iterator<q.b> it2 = this.f70903f.iterator();
                while (it2.hasNext()) {
                    it2.next().l(1);
                }
                return;
            }
            throw new IllegalSeekPositionException(wVar, i2, j);
        }
    }

    @Override // d.f.b.a.q
    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (e()) {
                o oVar = this.t;
                oVar.f71062a.f(oVar.f71064c.f70266a, this.f70905h);
                return this.f70905h.j() + b.b(this.t.f71066e);
            }
            return getCurrentPosition();
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.q
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            w wVar = this.t.f71062a;
            if (wVar.p()) {
                return -1;
            }
            return wVar.k(k(), this.k, this.l);
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.6.0] [" + d.f.b.a.i0.v.f70973e + "] [" + k.b() + PreferencesUtil.RIGHT_MOUNT);
            this.f70902e.B();
            this.f70901d.removeCallbacksAndMessages(null);
        }
    }

    @Override // d.f.b.a.g
    public void s(g.b... bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVarArr) == null) {
            this.f70902e.O(bVarArr);
        }
    }

    @Override // d.f.b.a.q
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || this.k == i2) {
            return;
        }
        this.k = i2;
        this.f70902e.W(i2);
        Iterator<q.b> it = this.f70903f.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(i2);
        }
    }

    @Override // d.f.b.a.q
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f70902e.d0();
        }
    }

    @Override // d.f.b.a.q
    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (B()) {
                return this.w;
            }
            return z(this.t.f71068g);
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.q
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            w wVar = this.t.f71062a;
            if (wVar.p()) {
                return -1;
            }
            return wVar.e(k(), this.k, this.l);
        }
        return invokeV.intValue;
    }

    @Override // d.f.b.a.q
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (B()) {
                return this.v;
            }
            return this.t.f71064c.f70266a;
        }
        return invokeV.intValue;
    }

    public void x(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, message) == null) {
            switch (message.what) {
                case 0:
                    this.m = message.arg1;
                    Iterator<q.b> it = this.f70903f.iterator();
                    while (it.hasNext()) {
                        it.next().m(this.j, this.m);
                    }
                    return;
                case 1:
                    this.p = message.arg1 != 0;
                    Iterator<q.b> it2 = this.f70903f.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(this.p);
                    }
                    return;
                case 2:
                    if (this.o == 0) {
                        d.f.b.a.f0.i iVar = (d.f.b.a.f0.i) message.obj;
                        this.f70906i = true;
                        this.q = iVar.f70810a;
                        this.r = iVar.f70812c;
                        this.f70899b.b(iVar.f70813d);
                        Iterator<q.b> it3 = this.f70903f.iterator();
                        while (it3.hasNext()) {
                            it3.next().j(this.q, this.r);
                        }
                        return;
                    }
                    return;
                case 3:
                    y((o) message.obj, 0, 1, message.arg1 != 0, 2);
                    return;
                case 4:
                    y((o) message.obj, 0, 0, true, message.arg1);
                    return;
                case 5:
                    y((o) message.obj, message.arg1, message.arg2, false, 3);
                    return;
                case 6:
                    p pVar = (p) message.obj;
                    if (this.s.equals(pVar)) {
                        return;
                    }
                    this.s = pVar;
                    Iterator<q.b> it4 = this.f70903f.iterator();
                    while (it4.hasNext()) {
                        it4.next().k(pVar);
                    }
                    return;
                case 7:
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator<q.b> it5 = this.f70903f.iterator();
                    while (it5.hasNext()) {
                        it5.next().d(exoPlaybackException);
                    }
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public final void y(o oVar, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{oVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            d.f.b.a.i0.a.e(oVar.f71062a);
            int i5 = this.o - i2;
            this.o = i5;
            int i6 = this.n - i3;
            this.n = i6;
            if (i5 == 0 && i6 == 0) {
                o oVar2 = this.t;
                boolean z2 = (oVar2.f71062a == oVar.f71062a && oVar2.f71063b == oVar.f71063b) ? false : true;
                this.t = oVar;
                if (oVar.f71062a.p()) {
                    this.v = 0;
                    this.u = 0;
                    this.w = 0L;
                }
                if (z2) {
                    Iterator<q.b> it = this.f70903f.iterator();
                    while (it.hasNext()) {
                        it.next().c(oVar.f71062a, oVar.f71063b);
                    }
                }
                if (z) {
                    Iterator<q.b> it2 = this.f70903f.iterator();
                    while (it2.hasNext()) {
                        it2.next().l(i4);
                    }
                }
            }
            if (this.n != 0 || i3 <= 0) {
                return;
            }
            Iterator<q.b> it3 = this.f70903f.iterator();
            while (it3.hasNext()) {
                it3.next().e();
            }
        }
    }

    public final long z(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j)) == null) {
            long b2 = b.b(j);
            if (this.t.f71064c.b()) {
                return b2;
            }
            o oVar = this.t;
            oVar.f71062a.f(oVar.f71064c.f70266a, this.f70905h);
            return b2 + this.f70905h.j();
        }
        return invokeJ.longValue;
    }
}
