package d.f.b.a.a0.q;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import d.f.b.a.a0.q.a;
import d.f.b.a.i0.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class g implements d.f.b.a.a0.e, d.f.b.a.a0.l {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f69837a;

    /* renamed from: b  reason: collision with root package name */
    public final d.f.b.a.i0.l f69838b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f69839c;

    /* renamed from: d  reason: collision with root package name */
    public final d.f.b.a.i0.l f69840d;

    /* renamed from: e  reason: collision with root package name */
    public final Stack<a.C1971a> f69841e;

    /* renamed from: f  reason: collision with root package name */
    public int f69842f;

    /* renamed from: g  reason: collision with root package name */
    public int f69843g;

    /* renamed from: h  reason: collision with root package name */
    public long f69844h;

    /* renamed from: i  reason: collision with root package name */
    public int f69845i;
    public d.f.b.a.i0.l j;
    public int k;
    public int l;
    public d.f.b.a.a0.g m;
    public a[] n;
    public long o;
    public boolean p;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final j f69846a;

        /* renamed from: b  reason: collision with root package name */
        public final m f69847b;

        /* renamed from: c  reason: collision with root package name */
        public final d.f.b.a.a0.m f69848c;

        /* renamed from: d  reason: collision with root package name */
        public int f69849d;

        public a(j jVar, m mVar, d.f.b.a.a0.m mVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, mVar, mVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69846a = jVar;
            this.f69847b = mVar;
            this.f69848c = mVar2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942639543, "Ld/f/b/a/a0/q/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942639543, "Ld/f/b/a/a0/q/g;");
                return;
            }
        }
        q = v.q("qt  ");
    }

    public g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69837a = i2;
        this.f69840d = new d.f.b.a.i0.l(16);
        this.f69841e = new Stack<>();
        this.f69838b = new d.f.b.a.i0.l(d.f.b.a.i0.j.f70923a);
        this.f69839c = new d.f.b.a.i0.l(4);
    }

    public static boolean l(d.f.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            lVar.J(8);
            if (lVar.i() == q) {
                return true;
            }
            lVar.K(4);
            while (lVar.a() > 0) {
                if (lVar.i() == q) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == d.f.b.a.a0.q.a.C || i2 == d.f.b.a.a0.q.a.E || i2 == d.f.b.a.a0.q.a.F || i2 == d.f.b.a.a0.q.a.G || i2 == d.f.b.a.a0.q.a.H || i2 == d.f.b.a.a0.q.a.Q : invokeI.booleanValue;
    }

    public static boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == d.f.b.a.a0.q.a.S || i2 == d.f.b.a.a0.q.a.D || i2 == d.f.b.a.a0.q.a.T || i2 == d.f.b.a.a0.q.a.U || i2 == d.f.b.a.a0.q.a.m0 || i2 == d.f.b.a.a0.q.a.n0 || i2 == d.f.b.a.a0.q.a.o0 || i2 == d.f.b.a.a0.q.a.R || i2 == d.f.b.a.a0.q.a.p0 || i2 == d.f.b.a.a0.q.a.q0 || i2 == d.f.b.a.a0.q.a.r0 || i2 == d.f.b.a.a0.q.a.s0 || i2 == d.f.b.a.a0.q.a.t0 || i2 == d.f.b.a.a0.q.a.P || i2 == d.f.b.a.a0.q.a.f69761b || i2 == d.f.b.a.a0.q.a.A0 : invokeI.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f69841e.clear();
            this.f69845i = 0;
            this.k = 0;
            this.l = 0;
            if (j == 0) {
                i();
            } else if (this.n != null) {
                s(j2);
            }
        }
    }

    @Override // d.f.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.f.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            long j2 = Long.MAX_VALUE;
            for (a aVar : this.n) {
                m mVar = aVar.f69847b;
                int a2 = mVar.a(j);
                if (a2 == -1) {
                    a2 = mVar.b(j);
                }
                long j3 = mVar.f69875b[a2];
                if (j3 < j2) {
                    j2 = j3;
                }
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.e
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? i.d(fVar) : invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.f69842f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return p(fVar, kVar);
                    }
                    throw new IllegalStateException();
                } else if (o(fVar, kVar)) {
                    return 1;
                }
            } else if (!n(fVar)) {
                return -1;
            }
        }
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.m = gVar;
        }
    }

    @Override // d.f.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o : invokeV.longValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f69842f = 0;
            this.f69845i = 0;
        }
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return invokeV.intValue;
        }
        int i2 = -1;
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.n;
            if (i3 >= aVarArr.length) {
                return i2;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.f69849d;
            m mVar = aVar.f69847b;
            if (i4 != mVar.f69874a) {
                long j2 = mVar.f69875b[i4];
                if (j2 < j) {
                    i2 = i3;
                    j = j2;
                }
            }
            i3++;
        }
    }

    public final void k(long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            while (!this.f69841e.isEmpty() && this.f69841e.peek().P0 == j) {
                a.C1971a pop = this.f69841e.pop();
                if (pop.f69769a == d.f.b.a.a0.q.a.C) {
                    m(pop);
                    this.f69841e.clear();
                    this.f69842f = 2;
                } else if (!this.f69841e.isEmpty()) {
                    this.f69841e.peek().d(pop);
                }
            }
            if (this.f69842f != 2) {
                i();
            }
        }
    }

    public final void m(a.C1971a c1971a) throws ParserException {
        Metadata metadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c1971a) == null) {
            ArrayList arrayList = new ArrayList();
            d.f.b.a.a0.i iVar = new d.f.b.a.a0.i();
            a.b g2 = c1971a.g(d.f.b.a.a0.q.a.A0);
            if (g2 != null) {
                metadata = b.u(g2, this.p);
                if (metadata != null) {
                    iVar.c(metadata);
                }
            } else {
                metadata = null;
            }
            long j = -9223372036854775807L;
            long j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < c1971a.R0.size(); i2++) {
                a.C1971a c1971a2 = c1971a.R0.get(i2);
                if (c1971a2.f69769a == d.f.b.a.a0.q.a.E) {
                    j t = b.t(c1971a2, c1971a.g(d.f.b.a.a0.q.a.D), -9223372036854775807L, null, (this.f69837a & 1) != 0, this.p);
                    if (t != null) {
                        m p = b.p(t, c1971a2.f(d.f.b.a.a0.q.a.F).f(d.f.b.a.a0.q.a.G).f(d.f.b.a.a0.q.a.H), iVar);
                        if (p.f69874a != 0) {
                            a aVar = new a(t, p, this.m.a(i2, t.f69853b));
                            Format copyWithMaxInputSize = t.f69857f.copyWithMaxInputSize(p.f69877d + 30);
                            if (t.f69853b == 1) {
                                if (iVar.a()) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithGaplessInfo(iVar.f69670a, iVar.f69671b);
                                }
                                if (metadata != null) {
                                    copyWithMaxInputSize = copyWithMaxInputSize.copyWithMetadata(metadata);
                                }
                            }
                            aVar.f69848c.b(copyWithMaxInputSize);
                            long max = Math.max(j, t.f69856e);
                            arrayList.add(aVar);
                            long j3 = p.f69875b[0];
                            if (j3 < j2) {
                                j = max;
                                j2 = j3;
                            } else {
                                j = max;
                            }
                        }
                    }
                }
            }
            this.o = j;
            this.n = (a[]) arrayList.toArray(new a[arrayList.size()]);
            this.m.j();
            this.m.p(this);
        }
    }

    public final boolean n(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
            if (this.f69845i == 0) {
                if (!fVar.a(this.f69840d.f70943a, 0, 8, true)) {
                    return false;
                }
                this.f69845i = 8;
                this.f69840d.J(0);
                this.f69844h = this.f69840d.z();
                this.f69843g = this.f69840d.i();
            }
            long j = this.f69844h;
            if (j == 1) {
                fVar.readFully(this.f69840d.f70943a, 8, 8);
                this.f69845i += 8;
                this.f69844h = this.f69840d.C();
            } else if (j == 0) {
                long length = fVar.getLength();
                if (length == -1 && !this.f69841e.isEmpty()) {
                    length = this.f69841e.peek().P0;
                }
                if (length != -1) {
                    this.f69844h = (length - fVar.getPosition()) + this.f69845i;
                }
            }
            if (this.f69844h >= this.f69845i) {
                if (q(this.f69843g)) {
                    long position = (fVar.getPosition() + this.f69844h) - this.f69845i;
                    this.f69841e.add(new a.C1971a(this.f69843g, position));
                    if (this.f69844h == this.f69845i) {
                        k(position);
                    } else {
                        i();
                    }
                } else if (r(this.f69843g)) {
                    d.f.b.a.i0.a.f(this.f69845i == 8);
                    d.f.b.a.i0.a.f(this.f69844h <= 2147483647L);
                    d.f.b.a.i0.l lVar = new d.f.b.a.i0.l((int) this.f69844h);
                    this.j = lVar;
                    System.arraycopy(this.f69840d.f70943a, 0, lVar.f70943a, 0, 8);
                    this.f69842f = 1;
                } else {
                    this.j = null;
                    this.f69842f = 1;
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    public final boolean o(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048588, this, fVar, kVar)) != null) {
            return invokeLL.booleanValue;
        }
        long j = this.f69844h - this.f69845i;
        long position = fVar.getPosition() + j;
        d.f.b.a.i0.l lVar = this.j;
        if (lVar != null) {
            fVar.readFully(lVar.f70943a, this.f69845i, (int) j);
            if (this.f69843g == d.f.b.a.a0.q.a.f69761b) {
                this.p = l(this.j);
            } else if (!this.f69841e.isEmpty()) {
                this.f69841e.peek().e(new a.b(this.f69843g, this.j));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            fVar.h((int) j);
        } else {
            kVar.f69681a = fVar.getPosition() + j;
            z = true;
            k(position);
            return (z || this.f69842f == 2) ? false : true;
        }
        z = false;
        k(position);
        if (z) {
        }
    }

    public final int p(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, fVar, kVar)) == null) {
            int j = j();
            if (j == -1) {
                return -1;
            }
            a aVar = this.n[j];
            d.f.b.a.a0.m mVar = aVar.f69848c;
            int i2 = aVar.f69849d;
            m mVar2 = aVar.f69847b;
            long j2 = mVar2.f69875b[i2];
            int i3 = mVar2.f69876c[i2];
            if (aVar.f69846a.f69858g == 1) {
                j2 += 8;
                i3 -= 8;
            }
            long position = (j2 - fVar.getPosition()) + this.k;
            if (position >= 0 && position < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                fVar.h((int) position);
                int i4 = aVar.f69846a.j;
                if (i4 == 0) {
                    while (true) {
                        int i5 = this.k;
                        if (i5 >= i3) {
                            break;
                        }
                        int d2 = mVar.d(fVar, i3 - i5, false);
                        this.k += d2;
                        this.l -= d2;
                    }
                } else {
                    byte[] bArr = this.f69839c.f70943a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i6 = 4 - i4;
                    while (this.k < i3) {
                        int i7 = this.l;
                        if (i7 == 0) {
                            fVar.readFully(this.f69839c.f70943a, i6, i4);
                            this.f69839c.J(0);
                            this.l = this.f69839c.B();
                            this.f69838b.J(0);
                            mVar.a(this.f69838b, 4);
                            this.k += 4;
                            i3 += i6;
                        } else {
                            int d3 = mVar.d(fVar, i7, false);
                            this.k += d3;
                            this.l -= d3;
                        }
                    }
                }
                m mVar3 = aVar.f69847b;
                mVar.c(mVar3.f69878e[i2], mVar3.f69879f[i2], i3, 0, null);
                aVar.f69849d++;
                this.k = 0;
                this.l = 0;
                return 0;
            }
            kVar.f69681a = j2;
            return 1;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void s(long j) {
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            for (a aVar : this.n) {
                m mVar = aVar.f69847b;
                int a2 = mVar.a(j);
                if (a2 == -1) {
                    a2 = mVar.b(j);
                }
                aVar.f69849d = a2;
            }
        }
    }
}
