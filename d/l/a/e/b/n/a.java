package d.l.a.e.b.n;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.g;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.d;
import d.l.a.e.b.f.q;
import d.l.a.e.b.f.r;
import d.l.a.e.b.f.t;
import d.l.a.e.b.f.v;
import d.l.a.e.b.f.x;
import d.l.a.e.b.f.y;
import d.l.a.e.b.f.z;
import d.l.a.e.b.g.e;
import d.l.a.e.b.g.f;
import d.l.a.e.b.g.i;
import d.l.a.e.b.g.j;
import d.l.a.e.b.g.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadInfo f74951a;

    /* renamed from: b  reason: collision with root package name */
    public i f74952b;

    /* renamed from: c  reason: collision with root package name */
    public j f74953c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<g, d.l.a.e.b.f.b> f74954d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseArray<g> f74955e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.f.b> f74956f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.f.b> f74957g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<d.l.a.e.b.f.b> f74958h;

    /* renamed from: i  reason: collision with root package name */
    public d f74959i;
    public y j;
    public r k;
    public z l;
    public DownloadInfo.b m;
    public x n;
    public t o;
    public s p;
    public d.l.a.e.b.f.i q;
    public boolean r;
    public v s;
    public final List<q> t;
    public int u;
    public boolean v;

    /* renamed from: d.l.a.e.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2078a implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2078a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.e.b.g.j
        public int a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                return 1;
            }
            return invokeJ.intValue;
        }
    }

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
                return;
            }
        }
        this.f74954d = new ConcurrentHashMap();
        this.f74955e = new SparseArray<>();
        this.r = false;
        this.t = new ArrayList();
        this.v = true;
        this.m = new DownloadInfo.b();
        this.f74956f = new SparseArray<>();
        this.f74957g = new SparseArray<>();
        this.f74958h = new SparseArray<>();
    }

    public a A(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xVar)) == null) {
            this.n = xVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a A0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.m.G(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.m.K(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a B0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.m.l0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public i C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f74952b : (i) invokeV.objValue;
    }

    public a C0(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) {
            this.p = sVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public j D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f74953c : (j) invokeV.objValue;
    }

    public a D0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.m.R(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public r E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (r) invokeV.objValue;
    }

    public a E0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.m.G0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public t F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (t) invokeV.objValue;
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f74951a.getThrottleNetSpeed() <= 0) {
            return;
        }
        l(new C2078a(this));
    }

    public q G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            synchronized (this.t) {
                if (i2 < this.t.size()) {
                    return this.t.get(i2);
                }
                return null;
            }
        }
        return (q) invokeI.objValue;
    }

    public a G0(List<q> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                for (q qVar : list) {
                    b(qVar);
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public List<q> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.t : (List) invokeV.objValue;
    }

    public void H0(SparseArray<d.l.a.e.b.f.b> sparseArray, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, sparseArray, gVar) == null) || sparseArray == null) {
            return;
        }
        try {
            if (gVar == g.f41460a) {
                synchronized (this.f74956f) {
                    n(this.f74956f, sparseArray);
                }
            } else if (gVar == g.f41461b) {
                synchronized (this.f74957g) {
                    n(this.f74957g, sparseArray);
                }
            } else if (gVar == g.f41462c) {
                synchronized (this.f74958h) {
                    n(this.f74958h, sparseArray);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DownloadInfo downloadInfo = this.f74951a;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.r = z;
        }
    }

    public DownloadInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f74951a : (DownloadInfo) invokeV.objValue;
    }

    public void J0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.f74959i = dVar;
        }
    }

    public d.l.a.e.b.f.b K(g gVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, gVar, i2)) == null) {
            SparseArray<d.l.a.e.b.f.b> M = M(gVar);
            if (M == null || i2 < 0) {
                return null;
            }
            synchronized (M) {
                if (i2 < M.size()) {
                    return M.get(M.keyAt(i2));
                }
                return null;
            }
        }
        return (d.l.a.e.b.f.b) invokeLI.objValue;
    }

    public a K0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            this.m.V(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public int L(g gVar) {
        InterceptResult invokeL;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, gVar)) == null) {
            SparseArray<d.l.a.e.b.f.b> M = M(gVar);
            if (M == null) {
                return 0;
            }
            synchronized (M) {
                size = M.size();
            }
            return size;
        }
        return invokeL.intValue;
    }

    public a L0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            this.m.c0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public SparseArray<d.l.a.e.b.f.b> M(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, gVar)) == null) {
            if (gVar == g.f41460a) {
                return this.f74956f;
            }
            if (gVar == g.f41461b) {
                return this.f74957g;
            }
            if (gVar == g.f41462c) {
                return this.f74958h;
            }
            return null;
        }
        return (SparseArray) invokeL.objValue;
    }

    public a M0(int i2, d.l.a.e.b.f.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, bVar)) == null) {
            if (bVar != null) {
                synchronized (this.f74957g) {
                    this.f74957g.put(i2, bVar);
                }
                this.f74954d.put(g.f41461b, bVar);
                synchronized (this.f74955e) {
                    this.f74955e.put(i2, g.f41461b);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public v N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.s : (v) invokeV.objValue;
    }

    public a N0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048603, this, j)) == null) {
            this.m.H(j);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public x O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.n : (x) invokeV.objValue;
    }

    public a O0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            this.m.I(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.u : invokeV.intValue;
    }

    public a P0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            this.m.O(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public y Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.j : (y) invokeV.objValue;
    }

    public z R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.l : (z) invokeV.objValue;
    }

    public d.l.a.e.b.f.i S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.q : (d.l.a.e.b.f.i) invokeV.objValue;
    }

    public d T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.f74959i : (d) invokeV.objValue;
    }

    public s U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.p : (s) invokeV.objValue;
    }

    public d.l.a.e.b.f.b V(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, gVar)) == null) ? this.f74954d.get(gVar) : (d.l.a.e.b.f.b) invokeL.objValue;
    }

    public a W(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
            this.m.t0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            this.m.r0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a Y(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, yVar)) == null) {
            this.j = yVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public final void a(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = sparseArray.keyAt(i2);
            sparseArray2.put(keyAt, sparseArray.get(keyAt));
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public a b(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, qVar)) == null) {
            synchronized (this.t) {
                if (qVar != null) {
                    if (!this.t.contains(qVar)) {
                        this.t.add(qVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (a) invokeL.objValue;
    }

    public a b0(d.l.a.e.b.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            c0(bVar.hashCode(), bVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void c(int i2, d.l.a.e.b.f.b bVar, g gVar, boolean z) {
        Map<g, d.l.a.e.b.f.b> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i2), bVar, gVar, Boolean.valueOf(z)}) == null) || bVar == null) {
            return;
        }
        if (z && (map = this.f74954d) != null) {
            map.put(gVar, bVar);
            synchronized (this.f74955e) {
                this.f74955e.put(i2, gVar);
            }
        }
        SparseArray<d.l.a.e.b.f.b> M = M(gVar);
        if (M == null) {
            return;
        }
        synchronized (M) {
            M.put(i2, bVar);
        }
    }

    public a c0(int i2, d.l.a.e.b.f.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, bVar)) == null) {
            if (bVar != null) {
                synchronized (this.f74956f) {
                    this.f74956f.put(i2, bVar);
                }
                this.f74954d.put(g.f41460a, bVar);
                synchronized (this.f74955e) {
                    this.f74955e.put(i2, g.f41460a);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            d.l.a.e.b.c.a.g("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
            DownloadInfo downloadInfo = this.f74951a;
            if (downloadInfo != null && !downloadInfo.isAddListenerToSameTask()) {
                this.f74951a.setAddListenerToSameTask(true);
            }
            e(g.f41460a);
            e(g.f41461b);
            d.l.a.e.b.e.a.e(this.l, this.f74951a, new BaseException(1003, "has another same task, add Listener to old task"), 0);
        }
    }

    public a d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            this.m.Q(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final void e(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, gVar) == null) {
            SparseArray<d.l.a.e.b.f.b> M = M(gVar);
            synchronized (M) {
                for (int i2 = 0; i2 < M.size(); i2++) {
                    d.l.a.e.b.f.b bVar = M.get(M.keyAt(i2));
                    if (bVar != null) {
                        f.c().q(I(), bVar, gVar, false);
                    }
                }
            }
        }
    }

    public a e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            this.m.h0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public synchronized int f() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            synchronized (this) {
                d.l.a.e.b.f.b V = V(g.f41460a);
                if (V == null) {
                    V = V(g.f41461b);
                }
                if (V != null) {
                    this.u = V.hashCode();
                }
                i2 = this.u;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public a f0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
            this.m.b0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048630, this, z)) == null) {
            this.m.Z(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a g0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            this.m.U(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            this.m.N(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a h0(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, zVar)) == null) {
            this.l = zVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, list)) == null) {
            this.m.J(list);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a i0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            this.m.o0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            DownloadInfo downloadInfo = this.f74951a;
            if (downloadInfo != null) {
                return downloadInfo.canShowNotification();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public a j0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            this.m.A(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a k(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, iVar)) == null) {
            this.f74952b = iVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a k0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048639, this, z)) == null) {
            this.m.w0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a l(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, jVar)) == null) {
            this.f74953c = jVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a l0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048641, this, z)) == null) {
            this.m.f0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, aVar) == null) {
            for (Map.Entry<g, d.l.a.e.b.f.b> entry : aVar.f74954d.entrySet()) {
                if (entry != null && !this.f74954d.containsKey(entry.getKey())) {
                    this.f74954d.put(entry.getKey(), entry.getValue());
                }
            }
            try {
                if (aVar.f74956f.size() != 0) {
                    synchronized (this.f74956f) {
                        y0(this.f74956f, aVar.f74956f);
                        a(aVar.f74956f, this.f74956f);
                    }
                }
                if (aVar.f74957g.size() != 0) {
                    synchronized (this.f74957g) {
                        y0(this.f74957g, aVar.f74957g);
                        a(aVar.f74957g, this.f74957g);
                    }
                }
                if (aVar.f74958h.size() != 0) {
                    synchronized (this.f74958h) {
                        y0(this.f74958h, aVar.f74958h);
                        a(aVar.f74958h, this.f74958h);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public a m0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048643, this, z)) == null) {
            this.m.S(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public final void n(SparseArray<d.l.a.e.b.f.b> sparseArray, SparseArray<d.l.a.e.b.f.b> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, sparseArray, sparseArray2) == null) {
            sparseArray.clear();
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                int keyAt = sparseArray2.keyAt(i2);
                d.l.a.e.b.f.b bVar = sparseArray2.get(keyAt);
                if (bVar != null) {
                    sparseArray.put(keyAt, bVar);
                }
            }
        }
    }

    public a n0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) {
            this.m.s0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a o(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, rVar)) == null) {
            this.k = rVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a o0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048647, this, z)) == null) {
            this.m.m0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a p(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, tVar)) == null) {
            this.o = tVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a p0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048649, this, z)) == null) {
            this.m.i0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048650, this, z)) == null) {
            this.m.E0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a q0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z)) == null) {
            this.m.p0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            this.f74951a = this.m.E();
            DownloadInfo b2 = e.M0().b(this.f74951a.getId());
            if (b2 == null) {
                this.f74951a.generateTaskId();
                d.l.a.e.b.e.a.i(this, null, 0);
            } else {
                this.f74951a.copyTaskIdFromCacheData(b2);
            }
            F0();
            f.c().j(this);
            DownloadInfo downloadInfo = this.f74951a;
            if (downloadInfo == null) {
                return 0;
            }
            return downloadInfo.getId();
        }
        return invokeV.intValue;
    }

    public a r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            this.m.A0(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a s(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, jSONObject)) == null) {
            this.m.C(jSONObject);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a s0(d.l.a.e.b.f.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, iVar)) == null) {
            this.q = iVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a t(com.ss.android.socialbase.downloader.constants.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, fVar)) == null) {
            this.m.z(fVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a t0(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, dVar)) == null) {
            this.f74959i = dVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048658, this, i2)) == null) {
            this.m.X(i2);
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a u0(d.l.a.e.b.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, bVar)) == null) {
            if (bVar == null) {
                return this;
            }
            v0(bVar.hashCode(), bVar);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a v(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048660, this, j)) == null) {
            this.m.y(j);
            return this;
        }
        return (a) invokeJ.objValue;
    }

    public a v0(int i2, d.l.a.e.b.f.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048661, this, i2, bVar)) == null) {
            if (bVar != null) {
                synchronized (this.f74958h) {
                    this.f74958h.put(i2, bVar);
                }
                this.f74954d.put(g.f41462c, bVar);
                synchronized (this.f74955e) {
                    this.f74955e.put(i2, g.f41462c);
                }
            }
            return this;
        }
        return (a) invokeIL.objValue;
    }

    public a w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, str)) == null) {
            this.m.Y(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a w0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048663, this, z)) == null) {
            this.m.D(z);
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public a x(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, list)) == null) {
            this.m.B(list);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) {
            this.m.e0(str);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a y(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, iArr)) == null) {
            this.m.L(iArr);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void y0(SparseArray sparseArray, SparseArray sparseArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048667, this, sparseArray, sparseArray2) == null) || sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.remove(sparseArray2.keyAt(i2));
        }
    }

    public a z(v vVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, vVar)) == null) {
            this.s = vVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void z0(int i2, d.l.a.e.b.f.b bVar, g gVar, boolean z) {
        int indexOfValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i2), bVar, gVar, Boolean.valueOf(z)}) == null) {
            SparseArray<d.l.a.e.b.f.b> M = M(gVar);
            if (M == null) {
                if (z && this.f74954d.containsKey(gVar)) {
                    this.f74954d.remove(gVar);
                    return;
                }
                return;
            }
            synchronized (M) {
                if (z) {
                    if (this.f74954d.containsKey(gVar)) {
                        bVar = this.f74954d.get(gVar);
                        this.f74954d.remove(gVar);
                    }
                    if (bVar != null && (indexOfValue = M.indexOfValue(bVar)) >= 0 && indexOfValue < M.size()) {
                        M.removeAt(indexOfValue);
                    }
                } else {
                    M.remove(i2);
                    synchronized (this.f74955e) {
                        g gVar2 = this.f74955e.get(i2);
                        if (gVar2 != null && this.f74954d.containsKey(gVar2)) {
                            this.f74954d.remove(gVar2);
                            this.f74955e.remove(i2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(DownloadInfo downloadInfo) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74951a = downloadInfo;
    }
}
