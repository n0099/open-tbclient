package d.l.a.b.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.a.a.d.d;
import d.l.a.a.a.f.f;
import d.l.a.e.b.f.v;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f A;
    public boolean B;
    public v C;
    public String D;
    public long E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public boolean J;
    public int K;

    /* renamed from: a  reason: collision with root package name */
    public long f71159a;

    /* renamed from: b  reason: collision with root package name */
    public long f71160b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71161c;

    /* renamed from: d  reason: collision with root package name */
    public int f71162d;

    /* renamed from: e  reason: collision with root package name */
    public String f71163e;

    /* renamed from: f  reason: collision with root package name */
    public String f71164f;

    /* renamed from: g  reason: collision with root package name */
    public String f71165g;

    /* renamed from: h  reason: collision with root package name */
    public d.l.a.a.a.f.b f71166h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f71167i;
    public JSONObject j;
    public String k;
    public List<String> l;
    public String m;
    public String n;
    public String o;
    public Map<String, String> p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public JSONObject u;
    public String v;
    public String w;
    public boolean x;
    public int y;
    public String z;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f71168a;

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
            this.f71168a = new c();
        }

        public a a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f71168a.f71162d = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        @Deprecated
        public a b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                j(j);
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a c(d.l.a.a.a.f.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                this.f71168a.f71166h = bVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(v vVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vVar)) == null) {
                this.f71168a.C = vVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f71168a.f71163e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jSONObject)) == null) {
                this.f71168a.j = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.f71168a.f71161c = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public c h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f71168a : (c) invokeV.objValue;
        }

        public a i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f71168a.y = i2;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a j(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                this.f71168a.f71159a = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                this.f71168a.f71164f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a l(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.f71168a.r = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a m(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j)) == null) {
                this.f71168a.f71160b = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a n(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
                this.f71168a.f71165g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.f71168a.x = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a p(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
                this.f71168a.k = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a q(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
                this.f71168a.B = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.f71168a.n = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a s(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.f71168a.o = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a t(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
                this.f71168a.z = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c() {
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
        this.f71161c = true;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = false;
        this.F = 2;
        this.J = true;
        this.K = 1;
    }

    @Override // d.l.a.a.a.d.d
    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71162d : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.d
    public f B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.A : (f) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.B : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public v D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.C : (v) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.l.a.a.a.g.b.f(d.l.a.e.b.j.a.g(p()), i()) : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.F : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.d
    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.K : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.d
    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.I : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.J : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public /* synthetic */ d a(String str) {
        g(str);
        return this;
    }

    @Override // d.l.a.a.a.d.d
    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f71159a : invokeV.longValue;
    }

    @Override // d.l.a.a.a.d.d
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.D : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.E : invokeV.longValue;
    }

    @Override // d.l.a.a.a.d.d
    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f71160b : invokeV.longValue;
    }

    @Override // d.l.a.a.a.d.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public Map<String, String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (Map) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.r : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.t : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public JSONObject p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.u : (JSONObject) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.x : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.y : invokeV.intValue;
    }

    @Override // d.l.a.a.a.d.d
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f71161c : invokeV.booleanValue;
    }

    @Override // d.l.a.a.a.d.d
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f71163e : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f71164f : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f71165g : (String) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public d.l.a.a.a.f.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f71166h : (d.l.a.a.a.f.b) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public List<String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f71167i : (List) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public JSONObject z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.j : (JSONObject) invokeV.objValue;
    }

    @Override // d.l.a.a.a.d.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.K = i2;
            return this;
        }
        return (c) invokeI.objValue;
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.f71160b = j;
        }
    }

    public c d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            this.f71159a = j;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            this.f71164f = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            this.k = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            this.v = str;
            return this;
        }
        return (c) invokeL.objValue;
    }
}
