package d.b.g0.a.e0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends f {
    public static final boolean I = d.b.g0.a.k.f45051a;
    public Timer G;
    public final d.b.g0.a.r1.e H;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public a(g gVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.b.g0.a.e0.f.k("pms_getPkg", "PMS获取包接口返回超过3秒");
        }
    }

    public g(d.b.g0.a.r1.e eVar) {
        super(eVar.f45740f);
        this.H = eVar;
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        if (I) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        d.b.g0.a.f2.a aVar2 = new d.b.g0.a.f2.a();
        aVar2.j(10L);
        aVar2.h(aVar.f48914a);
        aVar2.c(aVar.f48915b);
        aVar2.p(aVar.f48916c);
        if (aVar.f48914a == 1013 && d.b.g0.a.w0.a.E().a(d.b.g0.a.w0.a.c(), this.r, aVar2)) {
            r0(aVar2, false);
            F0(this.H.J(), aVar2);
        } else if (aVar.f48914a == 1020) {
            r0(aVar2, false);
            F0(this.H.J(), aVar2);
        } else {
            r0(aVar2, true);
        }
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void D() {
        if (this.H.h() != 1) {
            synchronized (g.class) {
                Timer timer = new Timer();
                this.G = timer;
                timer.schedule(new a(this), 3000L);
            }
        }
        d.b.g0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_start_req"));
        super.D();
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void E() {
        super.E();
        d.b.g0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_end_req"));
        if (this.H.h() != 1) {
            synchronized (g.class) {
                if (this.G != null) {
                    this.G.cancel();
                    this.G = null;
                }
            }
            if (I) {
                Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
            }
        }
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        if (this.q != null) {
            s0();
        }
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(10L);
        aVar.h(2901L);
        aVar.c("同步获取-> Server无包");
        r0(aVar, true);
    }

    public final void F0(d.b.g0.a.y0.e.b bVar, d.b.g0.a.f2.a aVar) {
        if (bVar == null) {
            return;
        }
        d.b.g0.a.z1.k.f fVar = new d.b.g0.a.z1.k.f();
        fVar.f47251a = d.b.g0.a.z1.h.n(bVar.F());
        fVar.f47255e = bVar.G();
        fVar.f47253c = bVar.S();
        fVar.f47252b = Config.LAUNCH;
        fVar.f47254d = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.f().toString());
        }
        fVar.d(bVar.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        d.b.g0.a.z1.h.onEvent(fVar);
        HybridUbcFlow d2 = d.b.g0.a.j1.i.d("startup");
        if (d2 != null) {
            d2.z("value", "na_success");
        }
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void G(d.b.g0.l.r.f fVar) {
        d.b.g0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_start_download"));
        super.G(fVar);
    }

    public d.b.g0.a.y0.e.b G0() {
        return this.H.J();
    }

    @Override // d.b.g0.l.h.g
    public void H(String str, int i) {
        super.H(str, i);
        d.b.g0.l.l.c a2 = d.b.g0.l.l.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.b.g0.l.r.e.b(a2.c());
        d.b.g0.a.c0.c.g("PkgSyncDownloadCallback", "resetCore: " + b2);
        if (b2) {
            d.b.g0.a.n1.c.a e2 = d.b.g0.a.n1.c.a.e();
            d.b.g0.a.n1.c.c cVar = new d.b.g0.a.n1.c.c(129);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0013 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // d.b.g0.l.h.g
    public void I(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            return;
        }
        if (I) {
            String str3 = 0;
            str3 = 0;
            try {
                try {
                    jSONObject2 = jSONObject.toString(4);
                    str3 = new StringBuilder();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject2 = jSONObject.toString();
                    str3 = new StringBuilder();
                }
                str3.append("onStatRecord: url:");
                str3.append(str);
                str3.append(" networkStatRecord:\n");
                str3.append(jSONObject2);
                Log.i("PkgSyncDownloadCallback", str3.toString());
            } catch (Throwable th) {
                Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong("startTime", optLong);
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        o.A(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        o.A(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        o.A(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        o.A(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        o.A(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        o.A(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        o.A(ubcFlowEvent7);
        d.b.g0.a.c0.c.g("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        d.b.g0.a.c0.c.g("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 1;
    }

    @Override // d.b.g0.l.h.g, d.b.g0.l.h.e
    @NonNull
    public Bundle g(@NonNull Bundle bundle, Set<String> set) {
        Bundle g2 = super.g(bundle, set);
        if (set.contains("get_launch_id")) {
            g2.putString("launch_id", this.H.J().U());
        }
        return g2;
    }

    @Override // d.b.g0.a.e0.p.f
    public int h0() {
        return 200;
    }

    @Override // d.b.g0.a.e0.p.f
    public PMSDownloadType i0() {
        return PMSDownloadType.SYNC;
    }

    @Override // d.b.g0.l.h.g, d.b.g0.l.h.d
    public void k(String str, String str2) {
        List<UbcFlowEvent> list;
        super.k(str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 53647) {
            if (hashCode == 54608 && str.equals("770")) {
                c2 = 1;
            }
        } else if (str.equals("670")) {
            c2 = 0;
        }
        if (c2 == 0) {
            d.b.g0.a.j1.i.o("startup").A(new UbcFlowEvent(str2));
        } else if (c2 == 1 && (list = this.s) != null) {
            list.add(new UbcFlowEvent(str2));
        }
    }

    @Override // d.b.g0.a.e0.p.f
    public void t0() {
        super.t0();
        if (I) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        o.A(new UbcFlowEvent("aps_end_download"));
        o.z("type", "0");
        d.b.g0.a.s0.k.f.b.d("0");
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.b.g0.a.f2.a D0 = D0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (D0 == null) {
            if (I) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            d.b.g0.a.y0.e.b G0 = G0();
            d.b.g0.l.k.d dVar = this.o;
            if (dVar != null && dVar.f48924h == 0) {
                G0.Q0(d.b.g0.a.b2.b.d(0));
                G0.D(1);
            }
            d.b.g0.l.k.d dVar2 = this.o;
            if (dVar2 != null && dVar2.f48924h == 1) {
                G0.Q0(d.b.g0.a.b2.b.d(1));
                G0.D(1);
            }
            d.b.g0.l.k.b bVar = this.p;
            if (bVar != null && bVar.f48924h == 0) {
                G0.x0(d.b.g0.a.l0.b.b(0));
                G0.D(2);
            }
            d.b.g0.l.k.b bVar2 = this.p;
            if (bVar2 != null && bVar2.f48924h == 1) {
                G0.x0(d.b.g0.a.l0.b.b(1));
                G0.D(2);
            }
            d.b.g0.l.k.g gVar = this.u;
            if (gVar != null) {
                G0.A0(gVar.r);
                G0.N0(this.u.p);
            }
            q0(this.q);
            y0("main_download", "0");
            return;
        }
        if (I) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        r0(D0, true);
    }

    @Override // d.b.g0.a.e0.p.f
    public void u0(Throwable th) {
        d.b.g0.a.f2.a aVar;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (I) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            aVar = pkgDownloadError.getErrCode();
        } else {
            if (I) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            aVar = new d.b.g0.a.f2.a();
            aVar.j(10L);
            aVar.h(2900L);
            aVar.c("包下载过程未知错误");
        }
        r0(aVar, true);
    }
}
