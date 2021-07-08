package d.f.b.a.a0.t;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.a0.l;
import d.f.b.a.a0.t.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class v implements d.f.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public static final long l;
    public static final long m;
    public static final long n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f69661a;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.f.b.a.i0.s> f69662b;

    /* renamed from: c  reason: collision with root package name */
    public final d.f.b.a.i0.l f69663c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f69664d;

    /* renamed from: e  reason: collision with root package name */
    public final w.c f69665e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<w> f69666f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseBooleanArray f69667g;

    /* renamed from: h  reason: collision with root package name */
    public d.f.b.a.a0.g f69668h;

    /* renamed from: i  reason: collision with root package name */
    public int f69669i;
    public boolean j;
    public w k;

    /* loaded from: classes8.dex */
    public class a implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.i0.k f69670a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v f69671b;

        public a(v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69671b = vVar;
            this.f69670a = new d.f.b.a.i0.k(new byte[4]);
        }

        @Override // d.f.b.a.a0.t.r
        public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            }
        }

        @Override // d.f.b.a.a0.t.r
        public void c(d.f.b.a.i0.l lVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) && lVar.x() == 0) {
                lVar.K(7);
                int a2 = lVar.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    lVar.f(this.f69670a, 4);
                    int g2 = this.f69670a.g(16);
                    this.f69670a.n(3);
                    if (g2 == 0) {
                        this.f69670a.n(13);
                    } else {
                        int g3 = this.f69670a.g(13);
                        this.f69671b.f69666f.put(g3, new s(new b(this.f69671b, g3)));
                        v.i(this.f69671b);
                    }
                }
                if (this.f69671b.f69661a != 2) {
                    this.f69671b.f69666f.remove(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.f.b.a.i0.k f69672a;

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<w> f69673b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseIntArray f69674c;

        /* renamed from: d  reason: collision with root package name */
        public final int f69675d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v f69676e;

        public b(v vVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69676e = vVar;
            this.f69672a = new d.f.b.a.i0.k(new byte[5]);
            this.f69673b = new SparseArray<>();
            this.f69674c = new SparseIntArray();
            this.f69675d = i2;
        }

        @Override // d.f.b.a.a0.t.r
        public void a(d.f.b.a.i0.s sVar, d.f.b.a.a0.g gVar, w.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, sVar, gVar, dVar) == null) {
            }
        }

        public final w.b b(d.f.b.a.i0.l lVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, i2)) == null) {
                int c2 = lVar.c();
                int i3 = i2 + c2;
                String str = null;
                ArrayList arrayList = null;
                int i4 = -1;
                while (lVar.c() < i3) {
                    int x = lVar.x();
                    int c3 = lVar.c() + lVar.x();
                    if (x == 5) {
                        long z = lVar.z();
                        if (z != v.l) {
                            if (z != v.m) {
                                if (z == v.n) {
                                    i4 = 36;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    } else {
                        if (x != 106) {
                            if (x != 122) {
                                if (x == 123) {
                                    i4 = 138;
                                } else if (x == 10) {
                                    str = lVar.u(3).trim();
                                } else if (x == 89) {
                                    arrayList = new ArrayList();
                                    while (lVar.c() < c3) {
                                        String trim = lVar.u(3).trim();
                                        int x2 = lVar.x();
                                        byte[] bArr = new byte[4];
                                        lVar.g(bArr, 0, 4);
                                        arrayList.add(new w.a(trim, x2, bArr));
                                    }
                                    i4 = 89;
                                }
                            }
                            i4 = 135;
                        }
                        i4 = 129;
                    }
                    lVar.K(c3 - lVar.c());
                }
                lVar.J(i3);
                return new w.b(i4, str, arrayList, Arrays.copyOfRange(lVar.f70489a, c2, i3));
            }
            return (w.b) invokeLI.objValue;
        }

        @Override // d.f.b.a.a0.t.r
        public void c(d.f.b.a.i0.l lVar) {
            d.f.b.a.i0.s sVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) && lVar.x() == 2) {
                if (this.f69676e.f69661a == 1 || this.f69676e.f69661a == 2 || this.f69676e.f69669i == 1) {
                    sVar = (d.f.b.a.i0.s) this.f69676e.f69662b.get(0);
                } else {
                    sVar = new d.f.b.a.i0.s(((d.f.b.a.i0.s) this.f69676e.f69662b.get(0)).c());
                    this.f69676e.f69662b.add(sVar);
                }
                lVar.K(2);
                int D = lVar.D();
                int i2 = 5;
                lVar.K(5);
                lVar.f(this.f69672a, 2);
                int i3 = 4;
                this.f69672a.n(4);
                lVar.K(this.f69672a.g(12));
                if (this.f69676e.f69661a == 2 && this.f69676e.k == null) {
                    w.b bVar = new w.b(21, null, null, new byte[0]);
                    v vVar = this.f69676e;
                    vVar.k = vVar.f69665e.a(21, bVar);
                    this.f69676e.k.a(sVar, this.f69676e.f69668h, new w.d(D, 21, 8192));
                }
                this.f69673b.clear();
                this.f69674c.clear();
                int a2 = lVar.a();
                while (a2 > 0) {
                    lVar.f(this.f69672a, i2);
                    int g2 = this.f69672a.g(8);
                    this.f69672a.n(3);
                    int g3 = this.f69672a.g(13);
                    this.f69672a.n(i3);
                    int g4 = this.f69672a.g(12);
                    w.b b2 = b(lVar, g4);
                    if (g2 == 6) {
                        g2 = b2.f69679a;
                    }
                    a2 -= g4 + 5;
                    int i4 = this.f69676e.f69661a == 2 ? g2 : g3;
                    if (!this.f69676e.f69667g.get(i4)) {
                        w a3 = (this.f69676e.f69661a == 2 && g2 == 21) ? this.f69676e.k : this.f69676e.f69665e.a(g2, b2);
                        if (this.f69676e.f69661a != 2 || g3 < this.f69674c.get(i4, 8192)) {
                            this.f69674c.put(i4, g3);
                            this.f69673b.put(i4, a3);
                        }
                    }
                    i2 = 5;
                    i3 = 4;
                }
                int size = this.f69674c.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = this.f69674c.keyAt(i5);
                    this.f69676e.f69667g.put(keyAt, true);
                    w valueAt = this.f69673b.valueAt(i5);
                    if (valueAt != null) {
                        if (valueAt != this.f69676e.k) {
                            valueAt.a(sVar, this.f69676e.f69668h, new w.d(D, keyAt, 8192));
                        }
                        this.f69676e.f69666f.put(this.f69674c.valueAt(i5), valueAt);
                    }
                }
                if (this.f69676e.f69661a == 2) {
                    if (this.f69676e.j) {
                        return;
                    }
                    this.f69676e.f69668h.j();
                    this.f69676e.f69669i = 0;
                    this.f69676e.j = true;
                    return;
                }
                this.f69676e.f69666f.remove(this.f69675d);
                v vVar2 = this.f69676e;
                vVar2.f69669i = vVar2.f69661a != 1 ? this.f69676e.f69669i - 1 : 0;
                if (this.f69676e.f69669i == 0) {
                    this.f69676e.f69668h.j();
                    this.f69676e.j = true;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1942729381, "Ld/f/b/a/a0/t/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1942729381, "Ld/f/b/a/a0/t/v;");
                return;
            }
        }
        l = d.f.b.a.i0.v.q("AC-3");
        m = d.f.b.a.i0.v.q("EAC3");
        n = d.f.b.a.i0.v.q("HEVC");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(int i2, int i3) {
        this(i2, new d.f.b.a.i0.s(0L), new e(i3));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (d.f.b.a.i0.s) objArr2[1], (w.c) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int i(v vVar) {
        int i2 = vVar.f69669i;
        vVar.f69669i = i2 + 1;
        return i2;
    }

    @Override // d.f.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int size = this.f69662b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f69662b.get(i2).g();
            }
            this.f69663c.F();
            this.f69664d.clear();
            u();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        r2 = r2 + 1;
     */
    @Override // d.f.b.a.a0.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            byte[] bArr = this.f69663c.f70489a;
            fVar.c(bArr, 0, CyberPlayerManager.MEDIA_INFO_VIDEO_FRAMERATE);
            int i2 = 0;
            while (i2 < 188) {
                for (int i3 = 0; i3 != 5; i3++) {
                    if (bArr[(i3 * Opcodes.NEWARRAY) + i2] != 71) {
                        break;
                    }
                }
                fVar.h(i2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.f.b.a.a0.e
    public int e(d.f.b.a.a0.f fVar, d.f.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, kVar)) == null) {
            d.f.b.a.i0.l lVar = this.f69663c;
            byte[] bArr = lVar.f70489a;
            if (9400 - lVar.c() < 188) {
                int a2 = this.f69663c.a();
                if (a2 > 0) {
                    System.arraycopy(bArr, this.f69663c.c(), bArr, 0, a2);
                }
                this.f69663c.H(bArr, a2);
            }
            while (this.f69663c.a() < 188) {
                int d2 = this.f69663c.d();
                int read = fVar.read(bArr, d2, 9400 - d2);
                if (read == -1) {
                    return -1;
                }
                this.f69663c.I(d2 + read);
            }
            int d3 = this.f69663c.d();
            int c2 = this.f69663c.c();
            while (c2 < d3 && bArr[c2] != 71) {
                c2++;
            }
            this.f69663c.J(c2);
            int i2 = c2 + Opcodes.NEWARRAY;
            if (i2 > d3) {
                return 0;
            }
            int i3 = this.f69663c.i();
            if ((8388608 & i3) != 0) {
                this.f69663c.J(i2);
                return 0;
            }
            boolean z = (4194304 & i3) != 0;
            int i4 = (2096896 & i3) >> 8;
            boolean z2 = (i3 & 32) != 0;
            w wVar = (i3 & 16) != 0 ? this.f69666f.get(i4) : null;
            if (wVar == null) {
                this.f69663c.J(i2);
                return 0;
            }
            if (this.f69661a != 2) {
                int i5 = i3 & 15;
                int i6 = this.f69664d.get(i4, i5 - 1);
                this.f69664d.put(i4, i5);
                if (i6 == i5) {
                    this.f69663c.J(i2);
                    return 0;
                } else if (i5 != ((i6 + 1) & 15)) {
                    wVar.b();
                }
            }
            if (z2) {
                this.f69663c.K(this.f69663c.x());
            }
            this.f69663c.I(i2);
            wVar.c(this.f69663c, z);
            this.f69663c.I(d3);
            this.f69663c.J(i2);
            return 0;
        }
        return invokeLL.intValue;
    }

    @Override // d.f.b.a.a0.e
    public void f(d.f.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            this.f69668h = gVar;
            gVar.p(new l.a(-9223372036854775807L));
        }
    }

    @Override // d.f.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f69667g.clear();
            this.f69666f.clear();
            SparseArray<w> b2 = this.f69665e.b();
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f69666f.put(b2.keyAt(i2), b2.valueAt(i2));
            }
            this.f69666f.put(0, new s(new a(this)));
            this.k = null;
        }
    }

    public v(int i2, d.f.b.a.i0.s sVar, w.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), sVar, cVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.e(cVar);
        this.f69665e = cVar;
        this.f69661a = i2;
        if (i2 != 1 && i2 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f69662b = arrayList;
            arrayList.add(sVar);
        } else {
            this.f69662b = Collections.singletonList(sVar);
        }
        this.f69663c = new d.f.b.a.i0.l(9400);
        this.f69667g = new SparseBooleanArray();
        this.f69666f = new SparseArray<>();
        this.f69664d = new SparseIntArray();
        u();
    }
}
