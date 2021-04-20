package d.b.g0.a.r1;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.r1.i;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j extends d {
    public static final boolean s = d.b.g0.a.k.f45443a;
    public e o;
    public SwanAppActivity q;
    public final d.b.g0.a.n1.c.e.a p = new d.b.g0.a.n1.c.e.a(this);
    public boolean r = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(j jVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    }

    public static String B(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.equals(jSONObject.optString("token"), "swanubc")) {
                return jSONObject.toString();
            }
        } catch (JSONException e2) {
            if (s) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public final boolean C(String str) {
        return h.I0.contains(str);
    }

    public final boolean D(String str) {
        return TextUtils.equals("update_tag_by_app_launch", str);
    }

    public final boolean E(String str) {
        return TextUtils.equals("update_tag_by_prefetch", str);
    }

    public final void F(@NonNull Bundle bundle, boolean z) {
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
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("naStart");
        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent.h(j);
        o.A(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_last_start");
        ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent2.h(j);
        o.A(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_launch_activity");
        ubcFlowEvent3.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent3.h(j3);
        o.A(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("na_receive_intent");
        ubcFlowEvent4.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
        ubcFlowEvent4.h(j5);
        o.A(ubcFlowEvent4);
        o.y("process", String.valueOf(SwanAppProcessInfo.current()));
        o.y("reuse", z ? "1" : "0");
        long j6 = bundle.getLong("veloce_start_time", 0L);
        if (j6 > 0) {
            UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("na_veloce_start");
            ubcFlowEvent5.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
            ubcFlowEvent5.h(j6);
            o.A(ubcFlowEvent5);
        }
        Bundle bundle2 = bundle.getBundle("mExtraData");
        if (bundle2 != null) {
            String B = B(bundle2.getString(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, ""));
            if (!TextUtils.isEmpty(B)) {
                o.y(TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT, B);
            }
            o.y("abtest", bundle2.getString("aiapp_abtest_info", ""));
            long j7 = bundle2.getLong("click_time", -1L);
            if (j7 > 0) {
                HybridUbcFlow o2 = d.b.g0.a.j1.i.o("startup");
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("user_action");
                ubcFlowEvent6.h(j7);
                o2.A(ubcFlowEvent6);
            }
        }
        d.b.g0.a.j1.i.m();
        this.o.J().y1(j3);
        this.o.J().w0(j3);
        d.b.g0.a.j1.l.f.h().b(j);
        long j8 = bundle.getLong("launch_flag_for_statistic");
        long j9 = bundle.getLong("page_display_flag_for_statistic");
        if (j8 < 1 || j9 < 1 || currentTimeMillis - j8 > millis || currentTimeMillis - j9 > millis) {
            bundle.putLong("launch_flag_for_statistic", currentTimeMillis);
            bundle.putLong("page_display_flag_for_statistic", currentTimeMillis);
        }
    }

    @Override // d.b.g0.a.r1.d
    public d.b.g0.l.l.f d() {
        return new d.b.g0.a.e0.p.n.b(this);
    }

    @Override // d.b.g0.a.r1.h
    public String getAppId() {
        e eVar = this.o;
        return eVar == null ? "" : eVar.getAppId();
    }

    @Override // d.b.g0.a.r1.h
    public int h() {
        return s().h();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0137 A[Catch: all -> 0x0169, TryCatch #0 {, blocks: (B:4:0x0007, B:8:0x000f, B:10:0x0013, B:11:0x0029, B:13:0x0042, B:14:0x005d, B:16:0x0063, B:19:0x006b, B:21:0x0078, B:23:0x0082, B:25:0x0088, B:27:0x008e, B:28:0x0091, B:32:0x00a4, B:34:0x00aa, B:35:0x00ae, B:37:0x00c0, B:40:0x00c8, B:41:0x00ce, B:43:0x00e2, B:46:0x00f8, B:47:0x0108, B:49:0x010c, B:54:0x0118, B:56:0x012b, B:61:0x0137, B:63:0x0148, B:66:0x0151, B:68:0x015b, B:69:0x0162), top: B:75:0x0007 }] */
    @Override // d.b.g0.a.r1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void j(Bundle bundle, String str) {
        long j;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean l0;
        long currentTimeMillis = System.currentTimeMillis();
        if (bundle == null) {
            return;
        }
        if (s) {
            Log.i("SwanImpl", "updateSwanApp: " + str);
        }
        String string = bundle.getString("mAppId");
        String string2 = bundle.getString("launch_id");
        HybridUbcFlow o = d.b.g0.a.j1.i.o("startup");
        boolean z4 = true;
        if (!o.I(string2)) {
            d.b.g0.a.j1.i.q("startup");
            o = d.b.g0.a.j1.i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("resetFlow");
            ubcFlowEvent.a(true);
            o.A(ubcFlowEvent);
            o.I(string2);
        }
        if (!E(str) && !D(str)) {
            boolean C = C(str);
            if (TextUtils.isEmpty(string) || (TextUtils.equals(string, getAppId()) && !d.b.g0.a.c0.d.d.e.d())) {
                j = 0;
                j2 = 0;
                z = false;
                z2 = false;
            } else {
                if (d.b.g0.a.c0.d.d.e.d()) {
                    d.b.g0.a.c0.d.d.e.e(str);
                }
                j = System.currentTimeMillis();
                boolean z5 = !TextUtils.isEmpty(m(new String[0]));
                long currentTimeMillis2 = System.currentTimeMillis();
                if (z5) {
                    d.b.g0.a.z1.g.c(3);
                }
                this.o = new e(this, string);
                z = z5;
                j2 = currentTimeMillis2;
                C = true;
                z2 = true;
            }
            if (x()) {
                if (C) {
                    SwanLauncher.g(bundle);
                    F(bundle, z);
                }
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_start");
                ubcFlowEvent2.h(currentTimeMillis);
                ubcFlowEvent2.a(true);
                o.A(ubcFlowEvent2);
                if (j > 0) {
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_update_reset_start");
                    ubcFlowEvent3.h(j);
                    ubcFlowEvent3.a(true);
                    o.A(ubcFlowEvent3);
                }
                long j3 = j2;
                if (j3 > 0) {
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_update_reset_ok");
                    ubcFlowEvent4.h(j3);
                    ubcFlowEvent4.a(true);
                    o.A(ubcFlowEvent4);
                }
                e eVar = this.o;
                if (!z2 && this.o.d()) {
                    z3 = false;
                    l0 = eVar.l0(bundle, str, z3);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("swan_app_update_end");
                    ubcFlowEvent5.a(true);
                    o.A(ubcFlowEvent5);
                    if (!l0 || !this.o.d()) {
                        z4 = false;
                    }
                    if (z4) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("app_update_tag", str);
                        l("event_on_app_updated", bundle2);
                    }
                }
                z3 = true;
                l0 = eVar.l0(bundle, str, z3);
                UbcFlowEvent ubcFlowEvent52 = new UbcFlowEvent("swan_app_update_end");
                ubcFlowEvent52.a(true);
                o.A(ubcFlowEvent52);
                if (!l0) {
                }
                z4 = false;
                if (z4) {
                }
            }
            if (z2) {
                d.b.g0.a.e0.w.d.L().F(z);
            }
            return;
        }
        if (!TextUtils.equals(string, getAppId())) {
            this.o = new e(this, string);
        }
        this.o.q0(bundle);
    }

    @Override // d.b.g0.a.r1.h
    public SwanAppCores k() {
        return s().k();
    }

    @Override // d.b.g0.a.r1.h
    public synchronized String m(String... strArr) {
        if (this.r) {
            return "";
        }
        this.r = true;
        String str = "";
        if (this.o != null && this.o.x()) {
            str = this.o.k0(strArr);
            this.o = null;
            t((i.a) new i.a("event_on_app_reseted").x("event_params_reset_flags", strArr));
            d.b.g0.a.n1.c.a.e().h(new d.b.g0.a.n1.c.c(2));
        }
        this.r = false;
        return str;
    }

    @Override // d.b.g0.a.r1.h
    public SwanAppActivity n() {
        return this.q;
    }

    @Override // d.b.g0.a.r1.h
    @Nullable
    public d.b.g0.a.n1.c.e.a q() {
        return this.p;
    }

    @Override // d.b.g0.a.r1.h
    @NonNull
    public e s() {
        if (this.o == null) {
            this.o = new e(this, "");
        }
        return this.o;
    }

    @Override // d.b.g0.a.r1.h
    public void u(SwanAppActivity swanAppActivity) {
        this.q = null;
    }

    @Override // d.b.g0.a.r1.h
    public void v() {
        e eVar = this.o;
        if (eVar == null || !eVar.x()) {
            return;
        }
        this.o.v();
        m("flag_finish_activity", "flag_remove_task");
        k0.T(new a(this));
    }

    @Override // d.b.g0.a.r1.h
    public void w(SwanAppActivity swanAppActivity) {
        SwanAppActivity swanAppActivity2;
        if (swanAppActivity == null || (swanAppActivity2 = this.q) == swanAppActivity) {
            return;
        }
        if (swanAppActivity2 != null) {
            u(swanAppActivity2);
        }
        this.q = swanAppActivity;
    }

    @Override // d.b.g0.a.r1.h
    public boolean x() {
        return s().x();
    }
}
