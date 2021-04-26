package d.a.h0.a.e0.p;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
    public static final boolean I = d.a.h0.a.k.f43101a;
    public Timer G;
    public final d.a.h0.a.r1.e H;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public a(g gVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.a.h0.a.e0.f.k("pms_getPkg", "PMS获取包接口返回超过3秒");
        }
    }

    public g(d.a.h0.a.r1.e eVar) {
        super(eVar.f43823f);
        this.H = eVar;
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        if (I) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        d.a.h0.a.f2.a aVar2 = new d.a.h0.a.f2.a();
        aVar2.j(10L);
        aVar2.h(aVar.f47144a);
        aVar2.c(aVar.f47145b);
        aVar2.p(aVar.f47146c);
        if (aVar.f47144a == 1013 && d.a.h0.a.w0.a.E().a(d.a.h0.a.w0.a.c(), this.r, aVar2)) {
            q0(aVar2, false);
            E0(this.H.J(), aVar2);
        } else if (aVar.f47144a == 1020) {
            q0(aVar2, false);
            E0(this.H.J(), aVar2);
        } else {
            q0(aVar2, true);
        }
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void C() {
        if (this.H.j() != 1) {
            synchronized (g.class) {
                Timer timer = new Timer();
                this.G = timer;
                timer.schedule(new a(this), 3000L);
            }
        }
        d.a.h0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_start_req"));
        super.C();
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void D() {
        super.D();
        d.a.h0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_end_req"));
        if (this.H.j() != 1) {
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

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        if (this.q != null) {
            r0();
        }
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(10L);
        aVar.h(2901L);
        aVar.c("同步获取-> Server无包");
        q0(aVar, true);
    }

    public final void E0(d.a.h0.a.y0.e.b bVar, d.a.h0.a.f2.a aVar) {
        if (bVar == null) {
            return;
        }
        d.a.h0.a.z1.k.f fVar = new d.a.h0.a.z1.k.f();
        fVar.f45411a = d.a.h0.a.z1.h.n(bVar.F());
        fVar.f45415e = bVar.G();
        fVar.f45413c = bVar.S();
        fVar.f45412b = "launch";
        fVar.f45414d = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.f().toString());
        }
        fVar.d(bVar.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        d.a.h0.a.z1.h.onEvent(fVar);
        HybridUbcFlow d2 = d.a.h0.a.j1.i.d("startup");
        if (d2 != null) {
            d2.z("value", "na_success");
        }
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void F(d.a.h0.l.r.f fVar) {
        d.a.h0.a.j1.i.o("startup").A(new UbcFlowEvent("aps_start_download"));
        super.F(fVar);
    }

    public d.a.h0.a.y0.e.b F0() {
        return this.H.J();
    }

    @Override // d.a.h0.l.h.g
    public void G(String str, int i2) {
        super.G(str, i2);
        d.a.h0.l.l.c a2 = d.a.h0.l.l.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.a.h0.l.r.e.b(a2.c());
        d.a.h0.a.c0.c.g("PkgSyncDownloadCallback", "resetCore: " + b2);
        if (b2) {
            d.a.h0.a.n1.c.a e2 = d.a.h0.a.n1.c.a.e();
            d.a.h0.a.n1.c.c cVar = new d.a.h0.a.n1.c.c(129);
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
    @Override // d.a.h0.l.h.g
    public void H(String str, String str2, JSONObject jSONObject) {
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
        HybridUbcFlow o = d.a.h0.a.j1.i.o("startup");
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
        d.a.h0.a.c0.c.g("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        d.a.h0.a.c0.c.g("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    @Override // d.a.h0.a.e0.p.j
    public int J() {
        return 1;
    }

    @Override // d.a.h0.a.e0.p.f
    public int g0() {
        return 200;
    }

    @Override // d.a.h0.a.e0.p.f
    public PMSDownloadType h0() {
        return PMSDownloadType.SYNC;
    }

    @Override // d.a.h0.l.h.g, d.a.h0.l.h.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle m = super.m(bundle, set);
        if (set.contains("get_launch_id")) {
            m.putString("launch_id", this.H.J().U());
        }
        return m;
    }

    @Override // d.a.h0.l.h.g, d.a.h0.l.h.d
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        super.n(str, str2);
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
            d.a.h0.a.j1.i.o("startup").A(new UbcFlowEvent(str2));
        } else if (c2 == 1 && (list = this.s) != null) {
            list.add(new UbcFlowEvent(str2));
        }
    }

    @Override // d.a.h0.a.e0.p.f
    public void s0() {
        super.s0();
        if (I) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        HybridUbcFlow o = d.a.h0.a.j1.i.o("startup");
        o.A(new UbcFlowEvent("aps_end_download"));
        o.z("type", "0");
        d.a.h0.a.s0.k.f.b.d("0");
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.a.h0.a.f2.a C0 = C0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (C0 == null) {
            if (I) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            d.a.h0.a.y0.e.b F0 = F0();
            d.a.h0.l.k.d dVar = this.o;
            if (dVar != null && dVar.f47154h == 0) {
                F0.Q0(d.a.h0.a.b2.b.d(0));
                F0.D(1);
            }
            d.a.h0.l.k.d dVar2 = this.o;
            if (dVar2 != null && dVar2.f47154h == 1) {
                F0.Q0(d.a.h0.a.b2.b.d(1));
                F0.D(1);
            }
            d.a.h0.l.k.b bVar = this.p;
            if (bVar != null && bVar.f47154h == 0) {
                F0.x0(d.a.h0.a.l0.b.b(0));
                F0.D(2);
            }
            d.a.h0.l.k.b bVar2 = this.p;
            if (bVar2 != null && bVar2.f47154h == 1) {
                F0.x0(d.a.h0.a.l0.b.b(1));
                F0.D(2);
            }
            d.a.h0.l.k.g gVar = this.u;
            if (gVar != null) {
                F0.A0(gVar.r);
                F0.N0(this.u.p);
            }
            p0(this.q);
            x0("main_download", "0");
            return;
        }
        if (I) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        q0(C0, true);
    }

    @Override // d.a.h0.a.e0.p.f
    public void t0(Throwable th) {
        d.a.h0.a.f2.a aVar;
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
            aVar = new d.a.h0.a.f2.a();
            aVar.j(10L);
            aVar.h(2900L);
            aVar.c("包下载过程未知错误");
        }
        q0(aVar, true);
    }
}
