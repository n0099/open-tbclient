package d.a.k0.t1;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.VideoPlatformStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i implements h {
    public long A;
    public long B;
    public long C;

    /* renamed from: a  reason: collision with root package name */
    public int f61920a;

    /* renamed from: c  reason: collision with root package name */
    public String f61922c;

    /* renamed from: d  reason: collision with root package name */
    public String f61923d;

    /* renamed from: e  reason: collision with root package name */
    public String f61924e;

    /* renamed from: f  reason: collision with root package name */
    public String f61925f;

    /* renamed from: g  reason: collision with root package name */
    public String f61926g;

    /* renamed from: h  reason: collision with root package name */
    public int f61927h;

    /* renamed from: i  reason: collision with root package name */
    public int f61928i;
    public long o;
    public long p;
    public boolean r;
    public int v;
    public boolean w;
    public String x;
    public List<b> y;
    public int z;
    public boolean s = true;
    public boolean t = false;
    public boolean u = false;
    public boolean D = false;
    public boolean E = false;

    /* renamed from: b  reason: collision with root package name */
    public String f61921b = UUID.randomUUID().toString();
    public Map<String, Long> k = new HashMap();
    public List<d.a.k0.l2.b> j = new ArrayList();
    public long l = 0;
    public long m = 0;
    public long n = 0;
    public ArrayList<Integer> q = new ArrayList<>();

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            int b2 = d.a.j0.s.e.g.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("baseInfo", i.this.s());
                jSONObject.put("kpiInfo", i.this.u());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b2 != 0 && (b2 != 4 || !i.this.s)) {
                if (b2 == 2) {
                    jSONObject.put("debugInfo", i.this.t());
                }
                d.a.k0.m3.e.h().k(jSONObject, !i.this.s);
                if (i.this.y == null) {
                    i.this.y.clear();
                    return null;
                }
                return null;
            }
            JSONObject t = i.this.t();
            t.put("running", i.this.w());
            jSONObject.put("debugInfo", t);
            d.a.k0.m3.e.h().k(jSONObject, !i.this.s);
            if (i.this.y == null) {
            }
        }
    }

    public i(String str, String str2, String str3) {
        this.f61920a = 0;
        this.f61920a = 0;
        this.f61922c = str;
        this.f61923d = str2;
        this.f61926g = str3;
        B();
    }

    public void A() {
        if (this.w) {
            return;
        }
        x();
        int b2 = d.a.j0.s.e.g.b();
        if ((d.a.j0.s.e.g.c() || !this.s) && b2 != 3) {
            this.w = true;
            new a().execute(new Void[0]);
        }
    }

    public final void B() {
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
    }

    @Override // d.a.k0.t1.h
    public void a(boolean z) {
        this.r = z;
        this.j.add(new d.a.k0.l2.a(1));
        this.f61920a = 1;
    }

    @Override // d.a.k0.t1.h
    public void b(boolean z, boolean z2) {
        this.D = z;
        this.E = z2;
    }

    @Override // d.a.k0.t1.h
    public void c(long j, long j2, long j3) {
        this.A = j;
        this.B = j2;
        this.C = j3;
    }

    @Override // d.a.k0.t1.h
    public boolean d(String str, String str2) {
        int i2 = this.f61920a;
        if (i2 == 8 || i2 == 7 || i2 == 6 || i2 == -1 || i2 == 1) {
            return false;
        }
        this.f61924e = VideoPlatformStatic.a(str);
        this.f61925f = str2;
        y();
        this.j.add(new d.a.k0.l2.a(207));
        this.f61920a = 7;
        A();
        return true;
    }

    @Override // d.a.k0.t1.h
    public String e(String str, String str2) {
        int i2 = this.f61920a;
        if (i2 != 8 && i2 != 7 && i2 != 6 && i2 != -1) {
            this.f61924e = VideoPlatformStatic.a(str);
            this.f61925f = str2;
            y();
            this.k.put("stallDuration", Long.valueOf(this.p));
            this.j.add(new d.a.k0.l2.a(206));
            this.f61920a = 6;
            A();
            return this.f61921b;
        }
        return this.f61921b;
    }

    @Override // d.a.k0.t1.h
    public void f() {
        int i2 = this.f61920a;
        if (i2 == 4 || i2 == 3) {
            if (this.m != 0) {
                this.n += System.currentTimeMillis() - this.m;
                this.m = 0L;
            }
            this.j.add(new d.a.k0.l2.a(203));
            this.f61920a = 5;
        }
    }

    @Override // d.a.k0.t1.h
    public void g(long j, int i2) {
        this.o++;
        this.p += j;
        this.q.add(Integer.valueOf(i2));
    }

    @Override // d.a.k0.t1.h
    public void h(int i2) {
        int i3 = this.f61920a;
        if (i3 == 5) {
            z();
        } else if (i3 != 3) {
        } else {
            this.f61927h = i2;
            this.m = System.currentTimeMillis();
            this.j.add(new d.a.k0.l2.a(200));
            this.f61920a = 4;
        }
    }

    @Override // d.a.k0.t1.h
    public void i(int i2) {
        int i3 = this.f61920a;
        if (i3 == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f61927h = i2;
        this.s = true;
        this.t = true;
        this.k.put("loadingTime", 1L);
        this.l = 0L;
        this.j.add(new d.a.k0.l2.a(103));
        this.f61920a = 3;
    }

    @Override // d.a.k0.t1.h
    public void j() {
        this.l = System.currentTimeMillis();
        this.j.add(new d.a.k0.l2.a(3));
        this.f61920a = 0;
    }

    @Override // d.a.k0.t1.h
    public void k(String str, String str2) {
        int i2 = this.f61920a;
        if (i2 == 8 || i2 == 7 || i2 == 6 || i2 == -1) {
            return;
        }
        this.f61924e = VideoPlatformStatic.a(str);
        this.f61925f = str2;
        y();
        this.j.add(new d.a.k0.l2.a(205));
        this.f61920a = 8;
        A();
    }

    @Override // d.a.k0.t1.h
    public void l(int i2) {
        int i3 = this.f61920a;
        if (i3 == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f61927h = i2;
        this.s = true;
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        if (currentTimeMillis > 86400000) {
            currentTimeMillis = 10000;
        }
        this.k.put("loadingTime", Long.valueOf(currentTimeMillis));
        this.l = 0L;
        this.j.add(new d.a.k0.l2.a(102));
        this.f61920a = 3;
    }

    public final JSONObject s() {
        JSONObject c2 = VideoPlatformStatic.c();
        List<b> list = this.y;
        if (list != null) {
            try {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.y.get(i2).c(c2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return c2;
    }

    public final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.f61921b);
            if (!StringUtils.isNull(this.f61926g)) {
                jSONObject.put("parentUuid", this.f61926g);
            }
            jSONObject.put("tid", this.f61922c);
            jSONObject.put("videoUrl", this.f61923d);
            jSONObject.put("source", this.f61924e);
            jSONObject.put("playerType", VideoPlatformStatic.b(this.f61927h));
            jSONObject.put("urlType", this.f61928i);
            jSONObject.put("sub_error", this.z);
            jSONObject.put("current_pid", Process.myPid());
            jSONObject.put("directPrepare", this.t ? 1 : 0);
            jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
            jSONObject.put("stallTypes", this.q);
            String str = "1";
            jSONObject.put("pcdn_used", this.D ? "1" : "0");
            if (!this.E) {
                str = "0";
            }
            jSONObject.put("p2p_used", str);
            if (!StringUtils.isNull(this.x)) {
                jSONObject.put("error_stack", this.x);
            }
            if (this.y != null) {
                int size = this.y.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.y.get(i2).b(jSONObject);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Long> entry : this.k.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (!this.k.containsKey("loadingTime")) {
                jSONObject.put("loadingTime", 0L);
            }
            if (!this.k.containsKey("playDuration")) {
                jSONObject.put("playDuration", 0L);
            }
            if (!this.k.containsKey("stallCount")) {
                jSONObject.put("stallCount", 0);
            }
            if (!this.k.containsKey("stallDuration")) {
                jSONObject.put("stallDuration", 0L);
            }
            int i2 = 1;
            jSONObject.put("isCacheHit", this.r ? 1 : 0);
            jSONObject.put("playSuccess", this.s ? 1 : 0);
            jSONObject.put("startPlayTimeInfo", v());
            if (!this.u) {
                i2 = 0;
            }
            jSONObject.put("retryError", i2);
            jSONObject.put("error", this.v);
            if (this.y != null) {
                int size = this.y.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.y.get(i3).a(jSONObject);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preparedTime", this.A);
            jSONObject.put("startTime", this.B);
            jSONObject.put("totalTime", this.C);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        B();
        return jSONObject;
    }

    public final JSONArray w() {
        JSONArray jSONArray = new JSONArray();
        List<d.a.k0.l2.b> list = this.j;
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(this.j.get(i2).a());
        }
        return jSONArray;
    }

    public final void x() {
        if (d.a.j0.m0.k.d().g() && this.k != null) {
            d.a.c.e.n.a a2 = d.a.j0.m0.j.a();
            a2.b("action", "video_monitor");
            a2.c("play_time", this.k.get("playDuration"));
            a2.c("caton_time", this.k.get("stallDuration"));
            a2.c("loading_time", Long.valueOf(this.C));
            Object[] objArr = new Object[2];
            objArr[0] = "pcdn";
            objArr[1] = Integer.valueOf((this.E ? 2 : 0) | (this.D ? 1 : 0));
            a2.c(objArr);
            a2.c("hit_cache", Boolean.valueOf(this.r));
            a2.c("direct_play", Integer.valueOf(this.t ? 1 : 0));
            a2.b("page_code", this.f61925f);
            a2.b("nettype", d.a.c.e.n.d.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("video", a2);
        }
    }

    public final void y() {
        if (this.m != 0) {
            this.n += System.currentTimeMillis() - this.m;
        }
        this.k.put("playDuration", Long.valueOf(this.n));
        this.k.put("stallCount", Long.valueOf(this.o));
        this.k.put("stallDuration", Long.valueOf(this.p));
        if (!this.k.containsKey("loadingTime")) {
            this.k.put("loadingTime", 0L);
        }
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
    }

    public void z() {
        if (this.f61920a != 5) {
            return;
        }
        this.m = System.currentTimeMillis();
        this.j.add(new d.a.k0.l2.a(204));
        this.f61920a = 4;
    }
}
