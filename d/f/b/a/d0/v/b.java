package d.f.b.a.d0.v;

import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import d.f.b.a.d0.b;
import d.f.b.a.d0.k;
import d.f.b.a.d0.o;
import d.f.b.a.d0.p;
import d.f.b.a.d0.s;
import d.f.b.a.d0.t;
import d.f.b.a.d0.u.f;
import d.f.b.a.d0.v.a;
import d.f.b.a.d0.v.g.g;
import d.f.b.a.h0.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public final class b implements k, p.a<d.f.b.a.d0.u.f<d.f.b.a.d0.v.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f72789e;

    /* renamed from: f  reason: collision with root package name */
    public final a.InterfaceC2009a f72790f;

    /* renamed from: g  reason: collision with root package name */
    public final int f72791g;

    /* renamed from: h  reason: collision with root package name */
    public final b.a f72792h;

    /* renamed from: i  reason: collision with root package name */
    public final long f72793i;
    public final n j;
    public final d.f.b.a.h0.b k;
    public final t l;
    public final a[] m;
    public k.a n;
    public d.f.b.a.d0.u.f<d.f.b.a.d0.v.a>[] o;
    public d.f.b.a.d0.e p;
    public d.f.b.a.d0.v.g.b q;
    public int r;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int[] f72794a;

        /* renamed from: b  reason: collision with root package name */
        public final int f72795b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f72796c;

        /* renamed from: d  reason: collision with root package name */
        public final int f72797d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f72798e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f72799f;

        public a(int i2, int[] iArr, int i3, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), iArr, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72795b = i2;
            this.f72794a = iArr;
            this.f72797d = i3;
            this.f72796c = z;
            this.f72798e = z2;
            this.f72799f = z3;
        }
    }

    public b(int i2, d.f.b.a.d0.v.g.b bVar, int i3, a.InterfaceC2009a interfaceC2009a, int i4, b.a aVar, long j, n nVar, d.f.b.a.h0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), bVar, Integer.valueOf(i3), interfaceC2009a, Integer.valueOf(i4), aVar, Long.valueOf(j), nVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72789e = i2;
        this.q = bVar;
        this.r = i3;
        this.f72790f = interfaceC2009a;
        this.f72791g = i4;
        this.f72792h = aVar;
        this.f72793i = j;
        this.j = nVar;
        this.k = bVar2;
        d.f.b.a.d0.u.f<d.f.b.a.d0.v.a>[] t = t(0);
        this.o = t;
        this.p = new d.f.b.a.d0.e(t);
        Pair<t, a[]> f2 = f(bVar.a(i3).f72866c);
        this.l = (t) f2.first;
        this.m = (a[]) f2.second;
    }

    public static Pair<t, a[]> f(List<d.f.b.a.d0.v.g.a> list) {
        InterceptResult invokeL;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            int[][] n = n(list);
            int length = n.length;
            boolean[] zArr = new boolean[length];
            boolean[] zArr2 = new boolean[length];
            char c2 = 0;
            int i3 = length;
            int i4 = 0;
            while (true) {
                i2 = 1;
                if (i4 >= length) {
                    break;
                }
                if (s(list, n[i4])) {
                    zArr[i4] = true;
                    i3++;
                }
                if (p(list, n[i4])) {
                    zArr2[i4] = true;
                    i3++;
                }
                i4++;
            }
            s[] sVarArr = new s[i3];
            a[] aVarArr = new a[i3];
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int[] iArr = n[i5];
                ArrayList arrayList = new ArrayList();
                for (int i7 : iArr) {
                    arrayList.addAll(list.get(i7).f72838c);
                }
                int size = arrayList.size();
                Format[] formatArr = new Format[size];
                for (int i8 = 0; i8 < size; i8++) {
                    formatArr[i8] = ((g) arrayList.get(i8)).f72871a;
                }
                d.f.b.a.d0.v.g.a aVar = list.get(iArr[c2]);
                boolean z = zArr[i5];
                boolean z2 = zArr2[i5];
                sVarArr[i6] = new s(formatArr);
                int i9 = i6 + 1;
                aVarArr[i6] = new a(aVar.f72837b, iArr, i6, true, z, z2);
                if (z) {
                    Format[] formatArr2 = new Format[i2];
                    formatArr2[0] = Format.createSampleFormat(aVar.f72836a + ":emsg", "application/x-emsg", null, -1, null);
                    sVarArr[i9] = new s(formatArr2);
                    str = null;
                    aVarArr[i9] = new a(4, iArr, i6, false, false, false);
                    i9++;
                } else {
                    str = null;
                }
                if (z2) {
                    sVarArr[i9] = new s(Format.createTextSampleFormat(aVar.f72836a + ":cea608", "application/cea-608", 0, str));
                    aVarArr[i9] = new a(3, iArr, i6, false, false, false);
                    i9++;
                }
                i5++;
                i6 = i9;
                c2 = 0;
                i2 = 1;
            }
            return Pair.create(new t(sVarArr), aVarArr);
        }
        return (Pair) invokeL.objValue;
    }

    public static d.f.b.a.d0.v.g.d m(List<d.f.b.a.d0.v.g.d> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                d.f.b.a.d0.v.g.d dVar = list.get(i2);
                if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar.f72861a)) {
                    return dVar;
                }
            }
            return null;
        }
        return (d.f.b.a.d0.v.g.d) invokeL.objValue;
    }

    public static int[][] n(List<d.f.b.a.d0.v.g.a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            int size = list.size();
            SparseIntArray sparseIntArray = new SparseIntArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                sparseIntArray.put(list.get(i2).f72836a, i2);
            }
            int[][] iArr = new int[size];
            boolean[] zArr = new boolean[size];
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (!zArr[i4]) {
                    zArr[i4] = true;
                    d.f.b.a.d0.v.g.d m = m(list.get(i4).f72840e);
                    if (m == null) {
                        int[] iArr2 = new int[1];
                        iArr2[0] = i4;
                        iArr[i3] = iArr2;
                        i3++;
                    } else {
                        String[] split = m.f72862b.split(",");
                        int[] iArr3 = new int[split.length + 1];
                        iArr3[0] = i4;
                        int i5 = 0;
                        while (i5 < split.length) {
                            int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                            zArr[i6] = true;
                            i5++;
                            iArr3[i5] = i6;
                        }
                        iArr[i3] = iArr3;
                        i3++;
                    }
                }
            }
            return i3 < size ? (int[][]) Arrays.copyOf(iArr, i3) : iArr;
        }
        return (int[][]) invokeL.objValue;
    }

    public static boolean p(List<d.f.b.a.d0.v.g.a> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, list, iArr)) == null) {
            for (int i2 : iArr) {
                List<d.f.b.a.d0.v.g.d> list2 = list.get(i2).f72839d;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i3).f72861a)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean s(List<d.f.b.a.d0.v.g.a> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, iArr)) == null) {
            for (int i2 : iArr) {
                List<g> list2 = list.get(i2).f72838c;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if (!list2.get(i3).f72874d.isEmpty()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static d.f.b.a.d0.u.f<d.f.b.a.d0.v.a>[] t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? new d.f.b.a.d0.u.f[i2] : (d.f.b.a.d0.u.f[]) invokeI.objValue;
    }

    public static void w(o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, oVar) == null) && (oVar instanceof f.a)) {
            ((f.a) oVar).b();
        }
    }

    public final d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> a(a aVar, d.f.b.a.f0.f fVar, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{aVar, fVar, Long.valueOf(j)})) == null) {
            int[] iArr = new int[2];
            boolean z = aVar.f72798e;
            int i2 = 0;
            if (z) {
                iArr[0] = 4;
                i2 = 1;
            }
            boolean z2 = aVar.f72799f;
            if (z2) {
                iArr[i2] = 3;
                i2++;
            }
            if (i2 < 2) {
                iArr = Arrays.copyOf(iArr, i2);
            }
            return new d.f.b.a.d0.u.f<>(aVar.f72795b, iArr, this.f72790f.a(this.j, this.q, this.r, aVar.f72794a, fVar, aVar.f72795b, this.f72793i, z, z2), this, this.k, j, this.f72791g, this.f72792h);
        }
        return (d.f.b.a.d0.u.f) invokeCommon.objValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public boolean b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? this.p.b(j) : invokeJ.booleanValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.p.c() : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k, d.f.b.a.d0.p
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.p.d() : invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long e(d.f.b.a.f0.f[] fVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        o D;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{fVarArr, zArr, oVarArr, zArr2, Long.valueOf(j)})) == null) {
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < fVarArr.length; i2++) {
                if (oVarArr[i2] instanceof d.f.b.a.d0.u.f) {
                    d.f.b.a.d0.u.f fVar = (d.f.b.a.d0.u.f) oVarArr[i2];
                    if (fVarArr[i2] != null && zArr[i2]) {
                        hashMap.put(Integer.valueOf(this.l.b(fVarArr[i2].d())), fVar);
                    } else {
                        fVar.B();
                        oVarArr[i2] = null;
                    }
                }
                if (oVarArr[i2] == null && fVarArr[i2] != null) {
                    int b2 = this.l.b(fVarArr[i2].d());
                    a aVar = this.m[b2];
                    if (aVar.f72796c) {
                        d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> a2 = a(aVar, fVarArr[i2], j);
                        hashMap.put(Integer.valueOf(b2), a2);
                        oVarArr[i2] = a2;
                        zArr2[i2] = true;
                    }
                }
            }
            for (int i3 = 0; i3 < fVarArr.length; i3++) {
                if (((oVarArr[i3] instanceof f.a) || (oVarArr[i3] instanceof d.f.b.a.d0.g)) && (fVarArr[i3] == null || !zArr[i3])) {
                    w(oVarArr[i3]);
                    oVarArr[i3] = null;
                }
                if (fVarArr[i3] != null) {
                    a aVar2 = this.m[this.l.b(fVarArr[i3].d())];
                    if (!aVar2.f72796c) {
                        d.f.b.a.d0.u.f fVar2 = (d.f.b.a.d0.u.f) hashMap.get(Integer.valueOf(aVar2.f72797d));
                        o oVar = oVarArr[i3];
                        if (fVar2 == null) {
                            z = oVar instanceof d.f.b.a.d0.g;
                        } else {
                            z = (oVar instanceof f.a) && ((f.a) oVar).f72782e == fVar2;
                        }
                        if (!z) {
                            w(oVar);
                            if (fVar2 == null) {
                                D = new d.f.b.a.d0.g();
                            } else {
                                D = fVar2.D(j, aVar2.f72795b);
                            }
                            oVarArr[i3] = D;
                            zArr2[i3] = true;
                        }
                    }
                }
            }
            this.o = t(hashMap.size());
            hashMap.values().toArray(this.o);
            this.p = new d.f.b.a.d0.e(this.o);
            return j;
        }
        return invokeCommon.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            for (d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> fVar : this.o) {
                fVar.C(j);
            }
            return j;
        }
        return invokeJ.longValue;
    }

    @Override // d.f.b.a.d0.k
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    @Override // d.f.b.a.d0.k
    public t k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.l : (t) invokeV.objValue;
    }

    @Override // d.f.b.a.d0.k
    public void o(k.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, aVar, j) == null) {
            this.n = aVar;
            aVar.l(this);
        }
    }

    @Override // d.f.b.a.d0.k
    public void q() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.a();
        }
    }

    @Override // d.f.b.a.d0.k
    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            for (d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> fVar : this.o) {
                fVar.t(j);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.f.b.a.d0.p.a
    /* renamed from: u */
    public void j(d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fVar) == null) {
            this.n.j(this);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> fVar : this.o) {
                fVar.B();
            }
        }
    }

    public void x(d.f.b.a.d0.v.g.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, bVar, i2) == null) {
            this.q = bVar;
            this.r = i2;
            d.f.b.a.d0.u.f<d.f.b.a.d0.v.a>[] fVarArr = this.o;
            if (fVarArr != null) {
                for (d.f.b.a.d0.u.f<d.f.b.a.d0.v.a> fVar : fVarArr) {
                    fVar.u().e(bVar, i2);
                }
                this.n.j(this);
            }
        }
    }
}
