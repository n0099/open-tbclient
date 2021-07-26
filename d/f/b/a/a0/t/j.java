package d.f.b.a.a0.t;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.a0.t.w;
import d.f.b.a.i0.j;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class j implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f70006a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f70007b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f70008c;

    /* renamed from: d  reason: collision with root package name */
    public final o f70009d;

    /* renamed from: e  reason: collision with root package name */
    public final o f70010e;

    /* renamed from: f  reason: collision with root package name */
    public final o f70011f;

    /* renamed from: g  reason: collision with root package name */
    public long f70012g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f70013h;

    /* renamed from: i  reason: collision with root package name */
    public String f70014i;
    public d.f.b.a.a0.m j;
    public b k;
    public boolean l;
    public long m;
    public final d.f.b.a.i0.l n;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.a0.m f70015a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f70016b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f70017c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f70018d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f70019e;

        /* renamed from: f  reason: collision with root package name */
        public final d.f.b.a.i0.m f70020f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f70021g;

        /* renamed from: h  reason: collision with root package name */
        public int f70022h;

        /* renamed from: i  reason: collision with root package name */
        public int f70023i;
        public long j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public boolean f70024a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f70025b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f70026c;

            /* renamed from: d  reason: collision with root package name */
            public int f70027d;

            /* renamed from: e  reason: collision with root package name */
            public int f70028e;

            /* renamed from: f  reason: collision with root package name */
            public int f70029f;

            /* renamed from: g  reason: collision with root package name */
            public int f70030g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f70031h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f70032i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f70025b = false;
                    this.f70024a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f70024a) {
                        if (!aVar.f70024a || this.f70029f != aVar.f70029f || this.f70030g != aVar.f70030g || this.f70031h != aVar.f70031h) {
                            return true;
                        }
                        if (this.f70032i && aVar.f70032i && this.j != aVar.j) {
                            return true;
                        }
                        int i2 = this.f70027d;
                        int i3 = aVar.f70027d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f70026c.f70937h == 0 && aVar.f70026c.f70937h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f70026c.f70937h == 1 && aVar.f70026c.f70937h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
                            return true;
                        }
                        if (z && z2 && this.l != aVar.l) {
                            return true;
                        }
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public boolean d() {
                InterceptResult invokeV;
                int i2;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70025b && ((i2 = this.f70028e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f70026c = bVar;
                    this.f70027d = i2;
                    this.f70028e = i3;
                    this.f70029f = i4;
                    this.f70030g = i5;
                    this.f70031h = z;
                    this.f70032i = z2;
                    this.j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f70024a = true;
                    this.f70025b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f70028e = i2;
                    this.f70025b = true;
                }
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public b(d.f.b.a.a0.m mVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70015a = mVar;
            this.f70016b = z;
            this.f70017c = z2;
            this.f70018d = new SparseArray<>();
            this.f70019e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f70021g = bArr;
            this.f70020f = new d.f.b.a.i0.m(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0152  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i2, int i3) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int g2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.k) {
                int i9 = i3 - i2;
                byte[] bArr2 = this.f70021g;
                int length = bArr2.length;
                int i10 = this.f70022h;
                if (length < i10 + i9) {
                    this.f70021g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f70021g, this.f70022h, i9);
                int i11 = this.f70022h + i9;
                this.f70022h = i11;
                this.f70020f.i(this.f70021g, 0, i11);
                if (this.f70020f.b(8)) {
                    this.f70020f.k();
                    int e2 = this.f70020f.e(2);
                    this.f70020f.l(5);
                    if (this.f70020f.c()) {
                        this.f70020f.h();
                        if (this.f70020f.c()) {
                            int h2 = this.f70020f.h();
                            if (!this.f70017c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f70020f.c()) {
                                int h3 = this.f70020f.h();
                                if (this.f70019e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f70019e.get(h3);
                                j.b bVar = this.f70018d.get(aVar.f70928b);
                                if (bVar.f70934e) {
                                    if (!this.f70020f.b(2)) {
                                        return;
                                    }
                                    this.f70020f.l(2);
                                }
                                if (this.f70020f.b(bVar.f70936g)) {
                                    int e3 = this.f70020f.e(bVar.f70936g);
                                    if (bVar.f70935f) {
                                        z = false;
                                    } else if (!this.f70020f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f70020f.d();
                                        if (d2) {
                                            if (this.f70020f.b(1)) {
                                                z = d2;
                                                z3 = this.f70020f.d();
                                                z2 = true;
                                                z4 = this.f70023i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f70020f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f70020f.h();
                                                }
                                                i5 = bVar.f70937h;
                                                if (i5 != 0) {
                                                    if (!this.f70020f.b(bVar.f70938i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f70020f.e(bVar.f70938i);
                                                    if (aVar.f70929c && !z) {
                                                        if (this.f70020f.c()) {
                                                            i8 = this.f70020f.g();
                                                            i6 = e4;
                                                            i7 = 0;
                                                            g2 = 0;
                                                            this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i6 = e4;
                                                } else if (i5 == 1 && !bVar.j) {
                                                    if (this.f70020f.c()) {
                                                        int g3 = this.f70020f.g();
                                                        if (aVar.f70929c && !z) {
                                                            if (this.f70020f.c()) {
                                                                g2 = this.f70020f.g();
                                                                i7 = g3;
                                                                i6 = 0;
                                                                i8 = 0;
                                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                                this.k = false;
                                                            }
                                                            return;
                                                        }
                                                        i7 = g3;
                                                        i6 = 0;
                                                        i8 = 0;
                                                        g2 = 0;
                                                        this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                        this.k = false;
                                                    }
                                                    return;
                                                } else {
                                                    i6 = 0;
                                                }
                                                i8 = 0;
                                                i7 = 0;
                                                g2 = 0;
                                                this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = d2;
                                    }
                                    z2 = false;
                                    z3 = false;
                                    if (this.f70023i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f70937h;
                                    if (i5 != 0) {
                                    }
                                    i8 = 0;
                                    i7 = 0;
                                    g2 = 0;
                                    this.n.e(bVar, e2, h2, e3, h3, z, z2, z3, z4, i4, i6, i8, i7, g2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void b(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
                boolean z = false;
                if (this.f70023i == 9 || (this.f70017c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j - this.j)));
                    }
                    this.p = this.j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f70023i;
                if (i3 == 5 || (this.f70016b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70017c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f70015a.c(this.q, z ? 1 : 0, (int) (this.j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f70019e.append(aVar.f70927a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f70018d.append(bVar.f70930a, bVar);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.k = false;
                this.o = false;
                this.n.b();
            }
        }

        public void h(long j, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                this.f70023i = i2;
                this.l = j2;
                this.j = j;
                if (!this.f70016b || i2 != 1) {
                    if (!this.f70017c) {
                        return;
                    }
                    int i3 = this.f70023i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f70022h = 0;
                this.k = true;
            }
        }
    }

    public j(t tVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70006a = tVar;
        this.f70007b = z;
        this.f70008c = z2;
        this.f70013h = new boolean[3];
        this.f70009d = new o(7, 128);
        this.f70010e = new o(8, 128);
        this.f70011f = new o(6, 128);
        this.n = new d.f.b.a.i0.l();
    }

    public final void a(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f70009d.b(i3);
                this.f70010e.b(i3);
                if (!this.l) {
                    if (this.f70009d.c() && this.f70010e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f70009d;
                        arrayList.add(Arrays.copyOf(oVar.f70078d, oVar.f70079e));
                        o oVar2 = this.f70010e;
                        arrayList.add(Arrays.copyOf(oVar2.f70078d, oVar2.f70079e));
                        o oVar3 = this.f70009d;
                        j.b i4 = d.f.b.a.i0.j.i(oVar3.f70078d, 3, oVar3.f70079e);
                        o oVar4 = this.f70010e;
                        j.a h2 = d.f.b.a.i0.j.h(oVar4.f70078d, 3, oVar4.f70079e);
                        this.j.b(Format.createVideoSampleFormat(this.f70014i, "video/avc", null, -1, -1, i4.f70931b, i4.f70932c, -1.0f, arrayList, -1, i4.f70933d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f70009d.d();
                        this.f70010e.d();
                    }
                } else if (this.f70009d.c()) {
                    o oVar5 = this.f70009d;
                    this.k.f(d.f.b.a.i0.j.i(oVar5.f70078d, 3, oVar5.f70079e));
                    this.f70009d.d();
                } else if (this.f70010e.c()) {
                    o oVar6 = this.f70010e;
                    this.k.e(d.f.b.a.i0.j.h(oVar6.f70078d, 3, oVar6.f70079e));
                    this.f70010e.d();
                }
            }
            if (this.f70011f.b(i3)) {
                o oVar7 = this.f70011f;
                this.n.H(this.f70011f.f70078d, d.f.b.a.i0.j.k(oVar7.f70078d, oVar7.f70079e));
                this.n.J(4);
                this.f70006a.a(j2, this.n);
            }
            this.k.b(j, i2);
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.f.b.a.i0.j.a(this.f70013h);
            this.f70009d.d();
            this.f70010e.d();
            this.f70011f.d();
            this.k.g();
            this.f70012g = 0L;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void c(d.f.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) != null) {
            return;
        }
        int c2 = lVar.c();
        int d2 = lVar.d();
        byte[] bArr = lVar.f70943a;
        this.f70012g += lVar.a();
        this.j.a(lVar, lVar.a());
        while (true) {
            int c3 = d.f.b.a.i0.j.c(bArr, c2, d2, this.f70013h);
            if (c3 == d2) {
                g(bArr, c2, d2);
                return;
            }
            int f2 = d.f.b.a.i0.j.f(bArr, c3);
            int i2 = c3 - c2;
            if (i2 > 0) {
                g(bArr, c2, c3);
            }
            int i3 = d2 - c3;
            long j = this.f70012g - i3;
            a(j, i3, i2 < 0 ? -i2 : 0, this.m);
            h(j, f2, this.m);
            c2 = c3 + 3;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void e(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            this.m = j;
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void f(d.f.b.a.a0.g gVar, w.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, gVar, dVar) == null) {
            dVar.a();
            this.f70014i = dVar.b();
            d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.j = a2;
            this.k = new b(a2, this.f70007b, this.f70008c);
            this.f70006a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f70009d.a(bArr, i2, i3);
                this.f70010e.a(bArr, i2, i3);
            }
            this.f70011f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f70009d.e(i2);
                this.f70010e.e(i2);
            }
            this.f70011f.e(i2);
            this.k.h(j, i2, j2);
        }
    }
}
