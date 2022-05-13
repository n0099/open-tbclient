package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes7.dex */
public class yi4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String C = "activityid";
    public static String D = "missionid";
    public static String E = "activitysource";
    public static String F = "source";
    public static String G = "tab";
    public static String H = "calltype";
    public static String I = "tasktype";
    public static String J = "browsetimepage";
    public static String K = "browsetime";
    public static String L = "threadnum";
    public static String M = "forumnum";
    public static String N = "cleartype";
    public static String O = "cleartime";
    public static String P = "tid";
    public static String Q = "fid";
    public static String R = "threadtext";
    public static String S = "threadimg";
    public static String T = "threadforum";
    public static String U = "tab_code";
    public static String V = "total_limit";
    public static int W = -1;
    public static int X = 1;
    public static int Y = 2;
    public static int Z = 3;
    public static int a0 = 8;
    public static int b0 = 9;
    public static int c0 = 10;
    public static int d0 = -1;
    public static int e0 = 0;
    public static int f0 = 1;
    public static int g0 = 2;
    public static int h0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public final ArrayList<ej4> B;
    public int a;
    public int b;
    public int c;
    public long d;
    public String e;
    public int f;
    public int g;
    public long h;
    public long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public long o;
    public int p;
    public long q;
    public int[] r;
    public long s;
    public int t;
    public volatile int u;
    public volatile int v;
    public boolean w;
    public int x;
    public volatile int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755140851, "Lcom/repackage/yi4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755140851, "Lcom/repackage/yi4;");
        }
    }

    public yi4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : invokeV.intValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : invokeV.longValue;
    }

    public final long D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            long u = u();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() - u;
        }
        return invokeI.longValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : invokeV.intValue;
    }

    public synchronized int G() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i = this.v + 1;
                this.v = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int H() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.y + 1;
                this.y = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int I() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i = this.u + 1;
                this.u = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean J(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            for (int i = 0; i < this.B.size(); i++) {
                ej4 ej4Var = (ej4) ListUtils.getItem(this.B, i);
                if (ej4Var != null) {
                    long m = m(ej4Var);
                    if (m > 0 && m == j && ej4Var.e()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a > 0 && this.b > 0 && this.c > 0 && this.d > 0 : invokeV.booleanValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? System.currentTimeMillis() > t() * 1000 : invokeV.booleanValue;
    }

    public boolean N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (li.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optInt(C);
                this.b = jSONObject.optInt(D);
                this.j = jSONObject.optString(E);
                this.l = jSONObject.optString(F);
                this.k = jSONObject.optString(G);
                this.t = jSONObject.optInt(H);
                int optInt = jSONObject.optInt(I);
                this.c = optInt;
                if (optInt == 15) {
                    this.c = 4;
                }
                String optString = jSONObject.optString(J);
                this.e = optString;
                this.r = Q(optString);
                this.d = jSONObject.optLong(K);
                this.f = jSONObject.optInt(L);
                this.g = jSONObject.optInt(M);
                this.p = jSONObject.optInt(N);
                this.q = jSONObject.optLong(O);
                this.s = c();
                this.h = jSONObject.optLong(P);
                this.i = jSONObject.optLong(Q);
                this.m = jSONObject.optString(R);
                this.n = jSONObject.optString(S);
                this.o = jSONObject.optLong(T);
                int optInt2 = jSONObject.optInt(V);
                if (optInt2 > 0) {
                    this.x = optInt2;
                }
                String optString2 = jSONObject.optString(U);
                if (TextUtils.isEmpty(optString2)) {
                    return true;
                }
                String valueOf = String.valueOf(optString2.hashCode());
                this.e = valueOf;
                this.r = Q(valueOf);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void O(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, activeCenterMissionData) == null) || activeCenterMissionData == null) {
            return;
        }
        b0(activeCenterMissionData.mission_id);
        m0(activeCenterMissionData.total_limit);
        f0(activeCenterMissionData.task_type);
        S(activeCenterMissionData.active_id);
        Y(activeCenterMissionData.cleartype);
        X(activeCenterMissionData.cleartime);
    }

    public void P(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, str) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    long optLong = jSONObject.optLong("i");
                    long optLong2 = jSONObject.optLong("t");
                    boolean optBoolean = jSONObject.optBoolean("c");
                    int optInt = jSONObject.optInt("a");
                    if (i == 7) {
                        if (optLong > 0) {
                            hj4 hj4Var = new hj4(this, optLong);
                            hj4Var.f(optBoolean);
                            hj4Var.g(optLong2);
                            hj4Var.h(optInt);
                            a(hj4Var);
                        }
                    } else if (i == 1) {
                        if (optLong > 0) {
                            jj4 jj4Var = new jj4(this, optLong);
                            jj4Var.f(optBoolean);
                            jj4Var.g(optLong2);
                            jj4Var.h(optInt);
                            a(jj4Var);
                        }
                    } else if (i == 2) {
                        if (optLong > 0) {
                            gj4 gj4Var = new gj4(this, optLong);
                            gj4Var.f(optBoolean);
                            gj4Var.g(optLong2);
                            gj4Var.h(optInt);
                            a(gj4Var);
                        }
                    } else if (i == 4) {
                        fj4 fj4Var = new fj4(this);
                        fj4Var.f(optBoolean);
                        fj4Var.g(optLong2);
                        fj4Var.h(optInt);
                        a(fj4Var);
                    } else if (i == 8) {
                        ij4 ij4Var = new ij4(this);
                        ij4Var.f(optBoolean);
                        ij4Var.g(optLong2);
                        ij4Var.h(optInt);
                        a(ij4Var);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final int[] Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            int i = this.c;
            if (i == 8) {
                return new int[]{W};
            }
            if (i == 7) {
                return new int[]{X, a0, b0};
            }
            if (str == null) {
                return null;
            }
            String[] split = str.split(",");
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                int e = kg.e(split[i2], 0);
                if (e != 0) {
                    iArr[i2] = e;
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.B.clear();
            this.u = 0;
            this.v = 0;
            this.y = 0;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a = i;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.j = str;
        }
    }

    public void U(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.d = j;
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.e = str;
            this.r = Q(str);
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.t = i;
        }
    }

    public void X(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.q = j;
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.p = i;
        }
    }

    public void Z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.i = j;
        }
    }

    public void a(ej4 ej4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ej4Var) == null) {
            if (this.c == 7 && (ej4Var instanceof hj4)) {
                if (this.B.contains(ej4Var)) {
                    return;
                }
                this.B.add(ej4Var);
            } else if (this.c == 1 && (ej4Var instanceof jj4)) {
                if (this.B.contains(ej4Var)) {
                    return;
                }
                this.B.add(ej4Var);
            } else if (this.c == 2 && (ej4Var instanceof gj4)) {
                if (this.B.contains(ej4Var)) {
                    return;
                }
                this.B.add(ej4Var);
            } else if (this.c == 4 && (ej4Var instanceof fj4)) {
                if (this.B.contains(ej4Var)) {
                    return;
                }
                this.B.add(ej4Var);
            } else if (this.c == 8 && (ej4Var instanceof ij4) && !this.B.contains(ej4Var)) {
                this.B.add(ej4Var);
            }
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.g = i;
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                ArrayList<ej4> arrayList = this.B;
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    ej4 ej4Var = (ej4) ListUtils.getItem(arrayList, i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("i", m(ej4Var));
                    jSONObject.put("t", ej4Var.b());
                    jSONObject.put("c", ej4Var.e());
                    jSONObject.put("a", ej4Var.d());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "[]";
            }
        }
        return (String) invokeV.objValue;
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.b = i;
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i = this.p;
            if (i == d0) {
                return 0L;
            }
            if (i == e0) {
                return this.q + (System.currentTimeMillis() / 1000);
            }
            if (i == f0) {
                long u = this.q + (u() / 1000);
                return System.currentTimeMillis() > u ? u + 86400 : u;
            } else if (i == g0) {
                return r((int) this.q, D(4)) / 1000;
            } else {
                if (i == h0) {
                    return this.q / 1000;
                }
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.w = z;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.a : invokeV.intValue;
    }

    public void d0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.s = j;
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.y = i;
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.d : invokeV.longValue;
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.c = i;
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public void g0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
            this.o = j;
        }
    }

    public int[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.r : (int[]) invokeV.objValue;
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.n = str;
        }
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.t : invokeV.intValue;
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.f = i;
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q : invokeV.longValue;
    }

    public void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.m = str;
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.p : invokeV.intValue;
    }

    public void k0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048623, this, j) == null) {
            this.h = j;
        }
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int size = this.B.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ej4 ej4Var = (ej4) ListUtils.getItem(this.B, i2);
                if ((ej4Var instanceof hj4) && ((hj4) ej4Var).d() == w()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.A = str;
        }
    }

    public long m(ej4 ej4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, ej4Var)) == null) {
            if (ej4Var == null) {
                return 0L;
            }
            if (this.c == 7 && (ej4Var instanceof hj4)) {
                return ((hj4) ej4Var).i();
            }
            if (this.c == 1 && (ej4Var instanceof jj4)) {
                return ((jj4) ej4Var).i();
            }
            if (this.c == 2 && (ej4Var instanceof gj4)) {
                return ((gj4) ej4Var).i();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.x = i;
        }
    }

    public ArrayList<ej4> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int size = this.B.size();
            for (int i = 0; i < size; i++) {
                ej4 ej4Var = (ej4) ListUtils.getItem(this.B, i);
                if (ej4Var != null) {
                    ej4Var.f(true);
                }
            }
        }
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.i : invokeV.longValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.g : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.b : invokeV.intValue;
    }

    public final long r(int i, long j) {
        InterceptResult invokeCommon;
        long timeInMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            switch (i) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 3;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 7;
                    break;
                case 7:
                    i = 1;
                    break;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            if (calendar.get(7) == i && System.currentTimeMillis() - timeInMillis2 < j) {
                timeInMillis = calendar.getTimeInMillis();
            } else {
                do {
                    calendar.add(5, 1);
                } while (calendar.get(7) != i);
                timeInMillis = calendar.getTimeInMillis();
            }
            return timeInMillis + j;
        }
        return invokeCommon.longValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.s : invokeV.longValue;
    }

    public final long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.y : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.c : invokeV.intValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.o : invokeV.longValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public yi4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
        N(str);
    }

    public yi4(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {missionInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = d0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
        if (missionInfo == null) {
            return;
        }
        this.a = missionInfo.activityid.intValue();
        this.b = missionInfo.missionid.intValue();
        this.c = missionInfo.tasktype.intValue();
        this.p = missionInfo.cleartype.intValue();
        this.q = missionInfo.cleartime.intValue();
        this.s = c();
        String str = missionInfo.browsetimepage;
        this.e = str;
        this.r = Q(str);
        if (missionInfo.threadnum.intValue() > 0) {
            this.f = missionInfo.threadnum.intValue();
        }
        if (missionInfo.browsetime.intValue() > 0) {
            this.d = missionInfo.browsetime.intValue();
        }
        if (missionInfo.total_limit.intValue() > 0) {
            this.x = missionInfo.total_limit.intValue();
        }
    }
}
