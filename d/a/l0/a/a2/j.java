package d.a.l0.a.a2;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.facebook.common.internal.Sets;
import d.a.l0.a.a2.i;
import d.a.l0.a.j2.n;
import d.a.l0.a.v2.q0;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j extends d {
    public static final boolean t = d.a.l0.a.k.f46875a;
    public volatile e p;
    public SwanAppActivity r;
    public final d.a.l0.a.v1.c.e.a q = new d.a.l0.a.v1.c.e.a(this);
    public boolean s = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(j jVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.t) {
                Log.w("SwanImpl", "kill process myself");
            }
            Process.killProcess(Process.myPid());
        }
    }

    public static String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                return jSONObject.toString();
            }
        } catch (JSONException e2) {
            if (t) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    @Override // d.a.l0.a.a2.h
    public boolean C() {
        return r().C();
    }

    public final boolean H(String str) {
        return h.K0.contains(str);
    }

    public final boolean I(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    public final boolean J(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    public final void K(@NonNull Bundle bundle, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = bundle.getLong("launch_time");
        long j2 = currentTimeMillis - j;
        long millis = TimeUnit.SECONDS.toMillis(10L);
        boolean z2 = false;
        z2 = (bundle.getBoolean("should_ignore_launch_time", false) || j <= 1 || j2 > millis) ? true : true;
        if (z2) {
            bundle.putLong("launch_time", currentTimeMillis);
            j = currentTimeMillis;
        }
        long j3 = bundle.getLong("start_activity_time");
        if (z2 || j3 < 1) {
            j3 = j;
        }
        long j4 = bundle.getLong("receive_launch_intent_time");
        long j5 = (z2 || j4 < 1) ? j3 : j4;
        HybridUbcFlow p = d.a.l0.a.r1.h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("naStart");
        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent.h(j);
        p.C(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_last_start");
        ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent2.h(j);
        p.C(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_launch_activity");
        ubcFlowEvent3.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent3.h(j3);
        p.C(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("na_receive_intent");
        ubcFlowEvent4.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent4.h(j5);
        p.C(ubcFlowEvent4);
        p.A("process", String.valueOf(SwanAppProcessInfo.current()));
        p.A("reuse", z ? "1" : "0");
        long j6 = bundle.getLong("veloce_start_time", 0L);
        if (j6 > 0) {
            UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("na_veloce_start");
            ubcFlowEvent5.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent5.h(j6);
            p.C(ubcFlowEvent5);
        }
        long j7 = bundle.getLong("t7_loading_start", -1L);
        int i2 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
        if (i2 > 0) {
            UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("na_t7_load_start");
            ubcFlowEvent6.h(j7);
            p.C(ubcFlowEvent6);
        }
        long j8 = bundle.getLong("t7_loading_end", -1L);
        if (i2 > 0) {
            UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("na_t7_load_end");
            ubcFlowEvent7.h(j8);
            p.C(ubcFlowEvent7);
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String G = G(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(G)) {
                p.A(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, G);
            }
            p.A("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j9 = bundle2.getLong("click_time", -1L);
            if (j9 > 0) {
                HybridUbcFlow p2 = d.a.l0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent8 = new UbcFlowEvent("user_action");
                ubcFlowEvent8.h(j9);
                p2.C(ubcFlowEvent8);
            }
        }
        d.a.l0.a.r1.h.n();
        this.p.L().F1(j3);
        this.p.L().A0(j3);
        d.a.l0.a.r1.k.f.j().b(j);
        d.a.l0.a.r1.r.a.f().d("updateLaunchInfo");
        n.d();
        long j10 = bundle.getLong("launch_flag_for_statistic");
        long j11 = bundle.getLong("page_display_flag_for_statistic");
        if (j10 < 1 || j11 < 1 || currentTimeMillis - j10 > millis || currentTimeMillis - j11 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    @Override // d.a.l0.a.a2.d
    public d.a.l0.n.i.g e() {
        return new d.a.l0.a.h0.m.n.b(this);
    }

    @Override // d.a.l0.a.a2.d
    public d.a.l0.a.c2.f.g0.a f() {
        return new d.a.l0.a.c2.f.g0.b(this);
    }

    @Override // d.a.l0.a.a2.h
    public String getAppId() {
        return this.p == null ? "" : this.p.getAppId();
    }

    @Override // d.a.l0.a.a2.h
    public int l() {
        return r().l();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x014f A[Catch: all -> 0x018f, TryCatch #0 {, blocks: (B:4:0x0007, B:8:0x000f, B:10:0x0055, B:11:0x0070, B:13:0x0076, B:16:0x007e, B:18:0x008b, B:20:0x0095, B:22:0x009b, B:24:0x00a1, B:25:0x00a4, B:29:0x00b7, B:31:0x00bd, B:32:0x00c1, B:34:0x00d3, B:37:0x00db, B:38:0x00e1, B:40:0x00f5, B:43:0x010b, B:44:0x011b, B:46:0x011f, B:51:0x012b, B:53:0x0143, B:58:0x014f, B:60:0x0160, B:63:0x0169, B:65:0x0173, B:66:0x0183), top: B:72:0x0007 }] */
    @Override // d.a.l0.a.a2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m(Bundle bundle, String str) {
        long j;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean q0;
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("mAppId");
        d.a.l0.a.e0.d.h("SwanImpl", "updateSwanApp updateTag:" + str + ",old appId:" + getAppId() + ",new appId:" + string);
        String string2 = bundle.getString("launch_id");
        d.a.l0.a.r1.l.d.b(string2);
        HybridUbcFlow p = d.a.l0.a.r1.h.p("startup");
        boolean z4 = true;
        if (!p.K(string2)) {
            d.a.l0.a.r1.h.r("startup");
            p = d.a.l0.a.r1.h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("resetFlow");
            ubcFlowEvent.a(true);
            p.C(ubcFlowEvent);
            p.K(string2);
        }
        if (!J(str) && !I(str)) {
            boolean H = H(str);
            if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !d.a.l0.a.e0.f.e.e.d())) {
                j = 0;
                j2 = 0;
                z = false;
                z2 = false;
            } else {
                if (d.a.l0.a.e0.f.e.e.d()) {
                    d.a.l0.a.e0.f.e.e.e(str);
                }
                j = System.currentTimeMillis();
                boolean z5 = !TextUtils.isEmpty(o(new String[0]));
                long currentTimeMillis2 = System.currentTimeMillis();
                if (z5) {
                    d.a.l0.a.j2.j.c(3);
                }
                this.p = new e(this, string);
                z = z5;
                j2 = currentTimeMillis2;
                H = true;
                z2 = true;
            }
            if (C()) {
                if (H) {
                    SwanLauncher.g(bundle);
                    K(bundle, z);
                }
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_start");
                ubcFlowEvent2.h(currentTimeMillis);
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
                if (j > 0) {
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_update_reset_start");
                    ubcFlowEvent3.h(j);
                    ubcFlowEvent3.a(true);
                    p.C(ubcFlowEvent3);
                }
                long j3 = j2;
                if (j3 > 0) {
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_update_reset_ok");
                    ubcFlowEvent4.h(j3);
                    ubcFlowEvent4.a(true);
                    p.C(ubcFlowEvent4);
                }
                e eVar = this.p;
                if (!z2 && this.p.e()) {
                    z3 = false;
                    q0 = eVar.q0(bundle, str, z3);
                    this.p.v0(str);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("swan_app_update_end");
                    ubcFlowEvent5.a(true);
                    p.C(ubcFlowEvent5);
                    if (!q0 || !this.p.e()) {
                        z4 = false;
                    }
                    if (z4) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        w("event_on_app_updated", bundle2);
                    }
                }
                z3 = true;
                q0 = eVar.q0(bundle, str, z3);
                this.p.v0(str);
                UbcFlowEvent ubcFlowEvent52 = new UbcFlowEvent("swan_app_update_end");
                ubcFlowEvent52.a(true);
                p.C(ubcFlowEvent52);
                if (!q0) {
                }
                z4 = false;
                if (z4) {
                }
            }
            if (z2) {
                d.a.l0.a.h0.u.g.N().H(z);
            }
            return;
        }
        if (!TextUtils.equals(string, getAppId())) {
            o("flag_not_unregister");
            this.p = new e(this, string);
        }
        this.p.w0(bundle);
        this.p.v0(str);
    }

    @Override // d.a.l0.a.a2.h
    public SwanAppCores n() {
        return r().n();
    }

    @Override // d.a.l0.a.a2.h
    public synchronized String o(String... strArr) {
        if (this.s) {
            return "";
        }
        this.s = true;
        String str = "";
        if (this.p != null && this.p.C()) {
            str = this.p.p0(strArr);
            this.p = null;
            A((i.a) new i.a("event_on_app_reseted").z("event_params_reset_flags", strArr));
            if (strArr == null || !Sets.newHashSet(strArr).contains("flag_not_unregister")) {
                d.a.l0.a.v1.c.a.e().h(new d.a.l0.a.v1.c.c(2));
            }
        }
        this.s = false;
        return str;
    }

    @Override // d.a.l0.a.a2.h
    @NonNull
    public e r() {
        if (this.p == null) {
            synchronized (this) {
                if (this.p == null) {
                    this.p = new e(this, "");
                }
            }
        }
        return this.p;
    }

    @Override // d.a.l0.a.a2.h
    public void s(SwanAppActivity swanAppActivity) {
        this.r = null;
    }

    @Override // d.a.l0.a.a2.h
    public void t() {
        if (this.p == null || !this.p.C()) {
            return;
        }
        this.p.t();
        o("flag_finish_activity", "flag_remove_task");
        q0.X(new a(this));
    }

    @Override // d.a.l0.a.a2.h
    public void u(SwanAppActivity swanAppActivity) {
        SwanAppActivity swanAppActivity2;
        if (swanAppActivity == null || (swanAppActivity2 = this.r) == swanAppActivity) {
            return;
        }
        if (swanAppActivity2 != null) {
            s(swanAppActivity2);
        }
        this.r = swanAppActivity;
    }

    @Override // d.a.l0.a.a2.h
    public SwanAppActivity x() {
        return this.r;
    }

    @Override // d.a.l0.a.a2.h
    @Nullable
    public d.a.l0.a.v1.c.e.a z() {
        return this.q;
    }
}
