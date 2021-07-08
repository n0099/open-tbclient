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
    public final t f69552a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f69553b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f69554c;

    /* renamed from: d  reason: collision with root package name */
    public final o f69555d;

    /* renamed from: e  reason: collision with root package name */
    public final o f69556e;

    /* renamed from: f  reason: collision with root package name */
    public final o f69557f;

    /* renamed from: g  reason: collision with root package name */
    public long f69558g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean[] f69559h;

    /* renamed from: i  reason: collision with root package name */
    public String f69560i;
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
        public final d.f.b.a.a0.m f69561a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f69562b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f69563c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<j.b> f69564d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<j.a> f69565e;

        /* renamed from: f  reason: collision with root package name */
        public final d.f.b.a.i0.m f69566f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f69567g;

        /* renamed from: h  reason: collision with root package name */
        public int f69568h;

        /* renamed from: i  reason: collision with root package name */
        public int f69569i;
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
            public boolean f69570a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f69571b;

            /* renamed from: c  reason: collision with root package name */
            public j.b f69572c;

            /* renamed from: d  reason: collision with root package name */
            public int f69573d;

            /* renamed from: e  reason: collision with root package name */
            public int f69574e;

            /* renamed from: f  reason: collision with root package name */
            public int f69575f;

            /* renamed from: g  reason: collision with root package name */
            public int f69576g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f69577h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f69578i;
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
                    this.f69571b = false;
                    this.f69570a = false;
                }
            }

            public final boolean c(a aVar) {
                InterceptResult invokeL;
                boolean z;
                boolean z2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (this.f69570a) {
                        if (!aVar.f69570a || this.f69575f != aVar.f69575f || this.f69576g != aVar.f69576g || this.f69577h != aVar.f69577h) {
                            return true;
                        }
                        if (this.f69578i && aVar.f69578i && this.j != aVar.j) {
                            return true;
                        }
                        int i2 = this.f69573d;
                        int i3 = aVar.f69573d;
                        if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                            return true;
                        }
                        if (this.f69572c.f70483h == 0 && aVar.f69572c.f70483h == 0 && (this.m != aVar.m || this.n != aVar.n)) {
                            return true;
                        }
                        if ((this.f69572c.f70483h == 1 && aVar.f69572c.f70483h == 1 && (this.o != aVar.o || this.p != aVar.p)) || (z = this.k) != (z2 = aVar.k)) {
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
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69571b && ((i2 = this.f69574e) == 7 || i2 == 2) : invokeV.booleanValue;
            }

            public void e(j.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10)}) == null) {
                    this.f69572c = bVar;
                    this.f69573d = i2;
                    this.f69574e = i3;
                    this.f69575f = i4;
                    this.f69576g = i5;
                    this.f69577h = z;
                    this.f69578i = z2;
                    this.j = z3;
                    this.k = z4;
                    this.l = i6;
                    this.m = i7;
                    this.n = i8;
                    this.o = i9;
                    this.p = i10;
                    this.f69570a = true;
                    this.f69571b = true;
                }
            }

            public void f(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                    this.f69574e = i2;
                    this.f69571b = true;
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
            this.f69561a = mVar;
            this.f69562b = z;
            this.f69563c = z2;
            this.f69564d = new SparseArray<>();
            this.f69565e = new SparseArray<>();
            this.m = new a(null);
            this.n = new a(null);
            byte[] bArr = new byte[128];
            this.f69567g = bArr;
            this.f69566f = new d.f.b.a.i0.m(bArr, 0, 0);
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
                byte[] bArr2 = this.f69567g;
                int length = bArr2.length;
                int i10 = this.f69568h;
                if (length < i10 + i9) {
                    this.f69567g = Arrays.copyOf(bArr2, (i10 + i9) * 2);
                }
                System.arraycopy(bArr, i2, this.f69567g, this.f69568h, i9);
                int i11 = this.f69568h + i9;
                this.f69568h = i11;
                this.f69566f.i(this.f69567g, 0, i11);
                if (this.f69566f.b(8)) {
                    this.f69566f.k();
                    int e2 = this.f69566f.e(2);
                    this.f69566f.l(5);
                    if (this.f69566f.c()) {
                        this.f69566f.h();
                        if (this.f69566f.c()) {
                            int h2 = this.f69566f.h();
                            if (!this.f69563c) {
                                this.k = false;
                                this.n.f(h2);
                            } else if (this.f69566f.c()) {
                                int h3 = this.f69566f.h();
                                if (this.f69565e.indexOfKey(h3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                j.a aVar = this.f69565e.get(h3);
                                j.b bVar = this.f69564d.get(aVar.f70474b);
                                if (bVar.f70480e) {
                                    if (!this.f69566f.b(2)) {
                                        return;
                                    }
                                    this.f69566f.l(2);
                                }
                                if (this.f69566f.b(bVar.f70482g)) {
                                    int e3 = this.f69566f.e(bVar.f70482g);
                                    if (bVar.f70481f) {
                                        z = false;
                                    } else if (!this.f69566f.b(1)) {
                                        return;
                                    } else {
                                        boolean d2 = this.f69566f.d();
                                        if (d2) {
                                            if (this.f69566f.b(1)) {
                                                z = d2;
                                                z3 = this.f69566f.d();
                                                z2 = true;
                                                z4 = this.f69569i != 5;
                                                if (z4) {
                                                    i4 = 0;
                                                } else if (!this.f69566f.c()) {
                                                    return;
                                                } else {
                                                    i4 = this.f69566f.h();
                                                }
                                                i5 = bVar.f70483h;
                                                if (i5 != 0) {
                                                    if (!this.f69566f.b(bVar.f70484i)) {
                                                        return;
                                                    }
                                                    int e4 = this.f69566f.e(bVar.f70484i);
                                                    if (aVar.f70475c && !z) {
                                                        if (this.f69566f.c()) {
                                                            i8 = this.f69566f.g();
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
                                                    if (this.f69566f.c()) {
                                                        int g3 = this.f69566f.g();
                                                        if (aVar.f70475c && !z) {
                                                            if (this.f69566f.c()) {
                                                                g2 = this.f69566f.g();
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
                                    if (this.f69569i != 5) {
                                    }
                                    if (z4) {
                                    }
                                    i5 = bVar.f70483h;
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
                if (this.f69569i == 9 || (this.f69563c && this.n.c(this.m))) {
                    if (this.o) {
                        d(i2 + ((int) (j - this.j)));
                    }
                    this.p = this.j;
                    this.q = this.l;
                    this.r = false;
                    this.o = true;
                }
                boolean z2 = this.r;
                int i3 = this.f69569i;
                if (i3 == 5 || (this.f69562b && i3 == 1 && this.n.d())) {
                    z = true;
                }
                this.r = z2 | z;
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69563c : invokeV.booleanValue;
        }

        public final void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                boolean z = this.r;
                this.f69561a.c(this.q, z ? 1 : 0, (int) (this.j - this.p), i2, null);
            }
        }

        public void e(j.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f69565e.append(aVar.f70473a, aVar);
            }
        }

        public void f(j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
                this.f69564d.append(bVar.f70476a, bVar);
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
                this.f69569i = i2;
                this.l = j2;
                this.j = j;
                if (!this.f69562b || i2 != 1) {
                    if (!this.f69563c) {
                        return;
                    }
                    int i3 = this.f69569i;
                    if (i3 != 5 && i3 != 1 && i3 != 2) {
                        return;
                    }
                }
                a aVar = this.m;
                this.m = this.n;
                this.n = aVar;
                aVar.b();
                this.f69568h = 0;
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
        this.f69552a = tVar;
        this.f69553b = z;
        this.f69554c = z2;
        this.f69559h = new boolean[3];
        this.f69555d = new o(7, 128);
        this.f69556e = new o(8, 128);
        this.f69557f = new o(6, 128);
        this.n = new d.f.b.a.i0.l();
    }

    public final void a(long j, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f69555d.b(i3);
                this.f69556e.b(i3);
                if (!this.l) {
                    if (this.f69555d.c() && this.f69556e.c()) {
                        ArrayList arrayList = new ArrayList();
                        o oVar = this.f69555d;
                        arrayList.add(Arrays.copyOf(oVar.f69624d, oVar.f69625e));
                        o oVar2 = this.f69556e;
                        arrayList.add(Arrays.copyOf(oVar2.f69624d, oVar2.f69625e));
                        o oVar3 = this.f69555d;
                        j.b i4 = d.f.b.a.i0.j.i(oVar3.f69624d, 3, oVar3.f69625e);
                        o oVar4 = this.f69556e;
                        j.a h2 = d.f.b.a.i0.j.h(oVar4.f69624d, 3, oVar4.f69625e);
                        this.j.b(Format.createVideoSampleFormat(this.f69560i, "video/avc", null, -1, -1, i4.f70477b, i4.f70478c, -1.0f, arrayList, -1, i4.f70479d, null));
                        this.l = true;
                        this.k.f(i4);
                        this.k.e(h2);
                        this.f69555d.d();
                        this.f69556e.d();
                    }
                } else if (this.f69555d.c()) {
                    o oVar5 = this.f69555d;
                    this.k.f(d.f.b.a.i0.j.i(oVar5.f69624d, 3, oVar5.f69625e));
                    this.f69555d.d();
                } else if (this.f69556e.c()) {
                    o oVar6 = this.f69556e;
                    this.k.e(d.f.b.a.i0.j.h(oVar6.f69624d, 3, oVar6.f69625e));
                    this.f69556e.d();
                }
            }
            if (this.f69557f.b(i3)) {
                o oVar7 = this.f69557f;
                this.n.H(this.f69557f.f69624d, d.f.b.a.i0.j.k(oVar7.f69624d, oVar7.f69625e));
                this.n.J(4);
                this.f69552a.a(j2, this.n);
            }
            this.k.b(j, i2);
        }
    }

    @Override // d.f.b.a.a0.t.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.f.b.a.i0.j.a(this.f69559h);
            this.f69555d.d();
            this.f69556e.d();
            this.f69557f.d();
            this.k.g();
            this.f69558g = 0L;
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
        byte[] bArr = lVar.f70489a;
        this.f69558g += lVar.a();
        this.j.a(lVar, lVar.a());
        while (true) {
            int c3 = d.f.b.a.i0.j.c(bArr, c2, d2, this.f69559h);
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
            long j = this.f69558g - i3;
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
            this.f69560i = dVar.b();
            d.f.b.a.a0.m a2 = gVar.a(dVar.c(), 2);
            this.j = a2;
            this.k = new b(a2, this.f69553b, this.f69554c);
            this.f69552a.b(gVar, dVar);
        }
    }

    public final void g(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (!this.l || this.k.c()) {
                this.f69555d.a(bArr, i2, i3);
                this.f69556e.a(bArr, i2, i3);
            }
            this.f69557f.a(bArr, i2, i3);
            this.k.a(bArr, i2, i3);
        }
    }

    public final void h(long j, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            if (!this.l || this.k.c()) {
                this.f69555d.e(i2);
                this.f69556e.e(i2);
            }
            this.f69557f.e(i2);
            this.k.h(j, i2, j2);
        }
    }
}
