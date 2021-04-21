package d.b.i0.a;

import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes3.dex */
public class b {
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
    public static String U = "total_limit";
    public static int V = -1;
    public static int W = 1;
    public static int X = 2;
    public static int Y = 3;
    public static int Z = 8;
    public static int a0 = 9;
    public static int b0 = -1;
    public static int c0 = 0;
    public static int d0 = 1;
    public static int e0 = 2;
    public static int f0 = 3;
    public String A;
    public final ArrayList<h> B;

    /* renamed from: a  reason: collision with root package name */
    public int f50231a;

    /* renamed from: b  reason: collision with root package name */
    public int f50232b;

    /* renamed from: c  reason: collision with root package name */
    public int f50233c;

    /* renamed from: d  reason: collision with root package name */
    public long f50234d;

    /* renamed from: e  reason: collision with root package name */
    public String f50235e;

    /* renamed from: f  reason: collision with root package name */
    public int f50236f;

    /* renamed from: g  reason: collision with root package name */
    public int f50237g;

    /* renamed from: h  reason: collision with root package name */
    public long f50238h;
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

    public b() {
        this.p = b0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
    }

    public int A() {
        return this.f50236f;
    }

    public String B() {
        return this.m;
    }

    public long C() {
        return this.f50238h;
    }

    public final long D(int i) {
        long u = u();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - u;
    }

    public String E() {
        return this.A;
    }

    public int F() {
        return this.x;
    }

    public synchronized int G() {
        int i;
        i = this.v + 1;
        this.v = i;
        return i;
    }

    public synchronized int H() {
        int i;
        i = this.y + 1;
        this.y = i;
        return i;
    }

    public synchronized int I() {
        int i;
        i = this.u + 1;
        this.u = i;
        return i;
    }

    public boolean J(long j) {
        for (int i = 0; i < this.B.size(); i++) {
            h hVar = (h) ListUtils.getItem(this.B, i);
            if (hVar != null) {
                long m = m(hVar);
                if (m > 0 && m == j && hVar.e()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean K() {
        return this.f50231a > 0 && this.f50232b > 0 && this.f50233c > 0 && this.f50234d > 0;
    }

    public boolean L() {
        return this.w;
    }

    public boolean M() {
        return System.currentTimeMillis() > t() * 1000;
    }

    public boolean N(String str) {
        if (d.b.c.e.p.k.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f50231a = jSONObject.optInt(C);
            this.f50232b = jSONObject.optInt(D);
            this.j = jSONObject.optString(E);
            this.l = jSONObject.optString(F);
            this.k = jSONObject.optString(G);
            this.t = jSONObject.optInt(H);
            this.f50233c = jSONObject.optInt(I);
            String optString = jSONObject.optString(J);
            this.f50235e = optString;
            this.r = Q(optString);
            this.f50234d = jSONObject.optLong(K);
            this.f50236f = jSONObject.optInt(L);
            this.f50237g = jSONObject.optInt(M);
            this.p = jSONObject.optInt(N);
            this.q = jSONObject.optLong(O);
            this.s = c();
            this.f50238h = jSONObject.optLong(P);
            this.i = jSONObject.optLong(Q);
            this.m = jSONObject.optString(R);
            this.n = jSONObject.optString(S);
            this.o = jSONObject.optLong(T);
            int optInt = jSONObject.optInt(U);
            if (optInt > 0) {
                this.x = optInt;
                return true;
            }
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void O(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        if (activeCenterMissionData != null) {
            b0(activeCenterMissionData.mission_id);
            m0(activeCenterMissionData.total_limit);
            f0(activeCenterMissionData.task_type);
            S(activeCenterMissionData.active_id);
            Y(activeCenterMissionData.cleartype);
            X(activeCenterMissionData.cleartime);
        }
    }

    public void P(int i, String str) {
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
                        k kVar = new k(this, optLong);
                        kVar.f(optBoolean);
                        kVar.g(optLong2);
                        kVar.h(optInt);
                        a(kVar);
                    }
                } else if (i == 1) {
                    if (optLong > 0) {
                        m mVar = new m(this, optLong);
                        mVar.f(optBoolean);
                        mVar.g(optLong2);
                        mVar.h(optInt);
                        a(mVar);
                    }
                } else if (i == 2) {
                    if (optLong > 0) {
                        j jVar = new j(this, optLong);
                        jVar.f(optBoolean);
                        jVar.g(optLong2);
                        jVar.h(optInt);
                        a(jVar);
                    }
                } else if (i == 4) {
                    i iVar = new i(this);
                    iVar.f(optBoolean);
                    iVar.g(optLong2);
                    iVar.h(optInt);
                    a(iVar);
                } else if (i == 8) {
                    l lVar = new l(this);
                    lVar.f(optBoolean);
                    lVar.g(optLong2);
                    lVar.h(optInt);
                    a(lVar);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final int[] Q(String str) {
        int i = this.f50233c;
        if (i == 8) {
            return new int[]{V};
        }
        if (i == 7) {
            return new int[]{W, Z, a0};
        }
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            int d2 = d.b.c.e.m.b.d(split[i2], 0);
            if (d2 > 0) {
                iArr[i2] = d2;
            }
        }
        return iArr;
    }

    public void R() {
        this.B.clear();
        this.u = 0;
        this.v = 0;
        this.y = 0;
    }

    public void S(int i) {
        this.f50231a = i;
    }

    public void T(String str) {
        this.j = str;
    }

    public void U(long j) {
        this.f50234d = j;
    }

    public void V(String str) {
        this.f50235e = str;
        this.r = Q(str);
    }

    public void W(int i) {
        this.t = i;
    }

    public void X(long j) {
        this.q = j;
    }

    public void Y(int i) {
        this.p = i;
    }

    public void Z(long j) {
        this.i = j;
    }

    public void a(h hVar) {
        if (this.f50233c == 7 && (hVar instanceof k)) {
            if (this.B.contains(hVar)) {
                return;
            }
            this.B.add(hVar);
        } else if (this.f50233c == 1 && (hVar instanceof m)) {
            if (this.B.contains(hVar)) {
                return;
            }
            this.B.add(hVar);
        } else if (this.f50233c == 2 && (hVar instanceof j)) {
            if (this.B.contains(hVar)) {
                return;
            }
            this.B.add(hVar);
        } else if (this.f50233c == 4 && (hVar instanceof i)) {
            if (this.B.contains(hVar)) {
                return;
            }
            this.B.add(hVar);
        } else if (this.f50233c == 8 && (hVar instanceof l) && !this.B.contains(hVar)) {
            this.B.add(hVar);
        }
    }

    public void a0(int i) {
        this.f50237g = i;
    }

    public String b() {
        try {
            ArrayList<h> arrayList = this.B;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                h hVar = (h) ListUtils.getItem(arrayList, i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i", m(hVar));
                jSONObject.put("t", hVar.b());
                jSONObject.put("c", hVar.e());
                jSONObject.put("a", hVar.d());
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "[]";
        }
    }

    public void b0(int i) {
        this.f50232b = i;
    }

    public long c() {
        int i = this.p;
        if (i == b0) {
            return 0L;
        }
        if (i == c0) {
            return this.q + (System.currentTimeMillis() / 1000);
        } else if (i == d0) {
            long u = this.q + (u() / 1000);
            return System.currentTimeMillis() > u ? u + 86400 : u;
        } else if (i == e0) {
            return r((int) this.q, D(4)) / 1000;
        } else {
            if (i == f0) {
                return this.q / 1000;
            }
            return 0L;
        }
    }

    public void c0(boolean z) {
        this.w = z;
    }

    public int d() {
        return this.f50231a;
    }

    public void d0(long j) {
        this.s = j;
    }

    public String e() {
        return this.j;
    }

    public void e0(int i) {
        this.y = i;
    }

    public long f() {
        return this.f50234d;
    }

    public void f0(int i) {
        this.f50233c = i;
    }

    public String g() {
        return this.f50235e;
    }

    public void g0(long j) {
        this.o = j;
    }

    public int[] h() {
        return this.r;
    }

    public void h0(String str) {
        this.n = str;
    }

    public int i() {
        return this.t;
    }

    public void i0(int i) {
        this.f50236f = i;
    }

    public long j() {
        return this.q;
    }

    public void j0(String str) {
        this.m = str;
    }

    public int k() {
        return this.p;
    }

    public void k0(long j) {
        this.f50238h = j;
    }

    public int l() {
        int size = this.B.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) ListUtils.getItem(this.B, i2);
            if ((hVar instanceof k) && ((k) hVar).d() == w()) {
                i++;
            }
        }
        return i;
    }

    public void l0(String str) {
        this.A = str;
    }

    public long m(h hVar) {
        if (hVar == null) {
            return 0L;
        }
        if (this.f50233c == 7 && (hVar instanceof k)) {
            return ((k) hVar).i();
        }
        if (this.f50233c == 1 && (hVar instanceof m)) {
            return ((m) hVar).i();
        }
        if (this.f50233c == 2 && (hVar instanceof j)) {
            return ((j) hVar).i();
        }
        return 0L;
    }

    public void m0(int i) {
        this.x = i;
    }

    public ArrayList<h> n() {
        return this.B;
    }

    public void n0() {
        int size = this.B.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) ListUtils.getItem(this.B, i);
            if (hVar != null) {
                hVar.f(true);
            }
        }
    }

    public long o() {
        return this.i;
    }

    public int p() {
        return this.f50237g;
    }

    public int q() {
        return this.f50232b;
    }

    public final long r(int i, long j) {
        long timeInMillis;
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

    public String s() {
        return this.l;
    }

    public long t() {
        return this.s;
    }

    public final long u() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public String v() {
        return this.k;
    }

    public int w() {
        return this.y;
    }

    public int x() {
        return this.f50233c;
    }

    public long y() {
        return this.o;
    }

    public String z() {
        return this.n;
    }

    public b(String str) {
        this.p = b0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.B = new ArrayList<>();
        N(str);
    }

    public b(MissionInfo missionInfo) {
        this.p = b0;
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
        this.f50231a = missionInfo.activityid.intValue();
        this.f50232b = missionInfo.missionid.intValue();
        this.f50233c = missionInfo.tasktype.intValue();
        this.p = missionInfo.cleartype.intValue();
        this.q = missionInfo.cleartime.intValue();
        this.s = c();
        String str = missionInfo.browsetimepage;
        this.f50235e = str;
        this.r = Q(str);
        if (missionInfo.threadnum.intValue() > 0) {
            this.f50236f = missionInfo.threadnum.intValue();
        }
        if (missionInfo.browsetime.intValue() > 0) {
            this.f50234d = missionInfo.browsetime.intValue();
        }
        if (missionInfo.total_limit.intValue() > 0) {
            this.x = missionInfo.total_limit.intValue();
        }
    }
}
