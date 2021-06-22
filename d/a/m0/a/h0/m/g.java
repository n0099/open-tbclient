package d.a.m0.a.h0.m;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends f {
    public static final boolean H = d.a.m0.a.k.f46983a;
    public Timer F;
    public final d.a.m0.a.a2.e G;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public a(g gVar) {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            g.H0();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements SwanAppNetworkUtils.b {
        @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
        public void onResult(int i2) {
            if (i2 == 1) {
                d.a.m0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：正常");
                d.a.m0.a.h0.i.f.d("pms_getPkg", FrsActivityConfig.GOOD);
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_waiting_and_retry);
            } else if (i2 == 2) {
                d.a.m0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：弱网");
                d.a.m0.a.h0.i.f.d("pms_getPkg", "bad");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
            } else if (i2 != 3) {
                d.a.m0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：未知");
                d.a.m0.a.h0.i.f.d("pms_getPkg", "unknown");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_waiting_and_retry);
            } else {
                d.a.m0.a.h0.i.i.i("PMS获取包接口返回超过3秒; 网络：离线");
                d.a.m0.a.h0.i.f.d("pms_getPkg", "offline");
                d.a.m0.a.h0.i.e.f(d.a.m0.a.h.swanapp_tip_net_unavailable);
            }
        }
    }

    public g(d.a.m0.a.a2.e eVar) {
        super(eVar.f44533f);
        this.G = eVar;
    }

    public static void F0(d.a.m0.a.f1.e.b bVar, d.a.m0.a.q2.a aVar) {
        if (bVar == null) {
            return;
        }
        d.a.m0.a.j2.p.f fVar = new d.a.m0.a.j2.p.f();
        fVar.f46969a = d.a.m0.a.j2.k.m(bVar.G());
        fVar.f46974f = bVar.H();
        fVar.f46971c = bVar.T();
        fVar.f46970b = "launch";
        fVar.f46973e = "success";
        fVar.a("status", "1");
        if (aVar != null) {
            fVar.a("errcode", String.valueOf(aVar.a()));
            fVar.a("msg", aVar.f().toString());
        }
        fVar.d(bVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.j(bVar);
        d.a.m0.a.j2.k.onEvent(fVar);
        HybridUbcFlow d2 = d.a.m0.a.r1.h.d("startup");
        if (d2 != null) {
            d2.B("value", "na_success");
        }
    }

    public static void H0() {
        SwanAppNetworkUtils.b(new b());
    }

    @Override // d.a.m0.a.h0.m.f, d.a.m0.n.f.g
    public void B(d.a.m0.n.h.a aVar) {
        super.B(aVar);
        if (H) {
            Log.e("PkgSyncDownloadCallback", "onFetchError: " + aVar.toString());
        }
        d.a.m0.a.q2.a aVar2 = new d.a.m0.a.q2.a();
        aVar2.j(10L);
        aVar2.h(aVar.f51784a);
        aVar2.c(aVar.f51785b);
        aVar2.p(aVar.f51786c);
        if (aVar.f51784a == 1013 && d.a.m0.a.c1.a.O().a(d.a.m0.a.c1.a.b(), this.r, aVar2)) {
            q0(aVar2, false);
            F0(this.G.L(), aVar2);
        } else if (aVar.f51784a == 1020) {
            q0(aVar2, false);
            F0(this.G.L(), aVar2);
        } else {
            q0(aVar2, true);
        }
    }

    @Override // d.a.m0.a.h0.m.f, d.a.m0.n.f.g
    public void C() {
        I0();
        d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_start_req"));
        super.C();
    }

    @Override // d.a.m0.a.h0.m.f, d.a.m0.n.f.g
    public void D() {
        super.D();
        d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_end_req"));
        J0();
    }

    @Override // d.a.m0.n.f.g
    public void E() {
        super.E();
        if (this.q != null) {
            r0();
        }
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(10L);
        aVar.h(2901L);
        aVar.c("同步获取-> Server无包");
        q0(aVar, true);
    }

    @Override // d.a.m0.a.h0.m.f, d.a.m0.n.f.g
    public void F(d.a.m0.n.o.f fVar) {
        d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent("aps_start_download"));
        super.F(fVar);
    }

    @Override // d.a.m0.n.f.g
    public void G(String str, int i2) {
        super.G(str, i2);
        d.a.m0.n.i.c a2 = d.a.m0.n.i.c.a(str);
        if (a2 == null) {
            return;
        }
        boolean b2 = d.a.m0.n.o.e.b(a2.c());
        d.a.m0.a.e0.d.g("PkgSyncDownloadCallback", "resetCore: " + b2 + ";statusCode:" + i2);
        if (b2) {
            d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
            d.a.m0.a.v1.c.c cVar = new d.a.m0.a.v1.c.c(129);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    public d.a.m0.a.f1.e.b G0() {
        return this.G.L();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0013 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // d.a.m0.n.f.g
    public void H(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            return;
        }
        if (H) {
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
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.C(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.C(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.C(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.C(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.C(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.C(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.C(ubcFlowEvent7);
        d.a.m0.a.e0.d.g("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        d.a.m0.a.e0.d.g("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public final void I0() {
        if (this.G.l() != 1) {
            synchronized (g.class) {
                Timer timer = new Timer();
                this.F = timer;
                timer.schedule(new a(this), 3000L);
            }
        }
    }

    @Override // d.a.m0.a.h0.m.j
    public int J() {
        return 1;
    }

    public final void J0() {
        if (this.G.l() != 1) {
            synchronized (g.class) {
                if (this.F != null) {
                    this.F.cancel();
                    this.F = null;
                }
            }
            if (H) {
                Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
            }
        }
    }

    @Override // d.a.m0.a.h0.m.f
    public int g0() {
        return 200;
    }

    @Override // d.a.m0.a.h0.m.f
    public PMSDownloadType h0() {
        return PMSDownloadType.SYNC;
    }

    @Override // d.a.m0.n.f.g, d.a.m0.n.f.e
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        Bundle m = super.m(bundle, set);
        if (set.contains("get_launch_id")) {
            m.putString("launch_id", this.G.L().V());
        }
        return m;
    }

    @Override // d.a.m0.n.f.g, d.a.m0.n.f.d
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
            d.a.m0.a.r1.h.p("startup").C(new UbcFlowEvent(str2));
        } else if (c2 == 1 && (list = this.s) != null) {
            list.add(new UbcFlowEvent(str2));
        }
    }

    @Override // d.a.m0.a.h0.m.f
    public void s0() {
        super.s0();
        if (H) {
            Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
        }
        HybridUbcFlow p = d.a.m0.a.r1.h.p("startup");
        p.C(new UbcFlowEvent("aps_end_download"));
        p.B("type", "0");
        if (d.a.m0.a.h0.n.a.a.c()) {
            d.a.m0.a.y0.k.f.b.d("0");
        } else {
            d.a.m0.a.y0.k.f.b.e("0");
        }
        this.s.add(new UbcFlowEvent("na_start_update_db"));
        d.a.m0.a.q2.a C0 = C0();
        this.s.add(new UbcFlowEvent("na_end_update_db"));
        if (C0 == null) {
            if (H) {
                Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
            }
            d.a.m0.a.f1.e.b G0 = G0();
            d.a.m0.n.h.d dVar = this.o;
            if (dVar != null && dVar.f51795h == 0) {
                G0.X0(d.a.m0.a.m2.b.e(0));
                G0.E(1);
            }
            d.a.m0.n.h.d dVar2 = this.o;
            if (dVar2 != null && dVar2.f51795h == 1) {
                G0.X0(d.a.m0.a.m2.b.e(1));
                G0.E(1);
            }
            d.a.m0.n.h.b bVar = this.p;
            if (bVar != null && bVar.f51795h == 0) {
                G0.B0(d.a.m0.a.p0.b.c(0));
                G0.E(2);
            }
            d.a.m0.n.h.b bVar2 = this.p;
            if (bVar2 != null && bVar2.f51795h == 1) {
                G0.B0(d.a.m0.a.p0.b.c(1));
                G0.E(2);
            }
            d.a.m0.n.h.g gVar = this.t;
            if (gVar != null) {
                G0.E0(gVar.r);
                G0.U0(this.t.p);
            }
            p0(this.q);
            x0("main_download", "0");
            return;
        }
        if (H) {
            Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
        }
        q0(C0, true);
    }

    @Override // d.a.m0.a.h0.m.f
    public void t0(Throwable th) {
        d.a.m0.a.q2.a aVar;
        if (th instanceof PkgDownloadError) {
            PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
            if (H) {
                Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
            }
            aVar = pkgDownloadError.getErrCode();
        } else {
            if (H) {
                Log.e("PkgSyncDownloadCallback", "未知错误");
            }
            aVar = new d.a.m0.a.q2.a();
            aVar.j(10L);
            aVar.h(2900L);
            aVar.c("包下载过程未知错误");
        }
        q0(aVar, true);
    }
}
