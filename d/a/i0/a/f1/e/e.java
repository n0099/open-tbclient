package d.a.i0.a.f1.e;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.f1.e.e;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class e<SelfT extends e<SelfT>> extends d.a.i0.a.f1.e.f.c<SelfT> {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f41666g = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public Pair<String, JSONObject> f41667f;

    public SelfT A0(long j) {
        return (SelfT) w("last_start_timestamp", j);
    }

    public SelfT B0(ExtensionCore extensionCore) {
        return (SelfT) x("extensionCore", extensionCore);
    }

    public SelfT C0(Bundle bundle) {
        return (SelfT) t("mExtraData", bundle);
    }

    public SelfT D0(String str) {
        y("app_icon_url", str);
        return (SelfT) a();
    }

    public SelfT E(int i2) {
        return G0(i2 | S());
    }

    public SelfT E0(boolean z) {
        return (SelfT) s("swan_app_independent", z);
    }

    public String F() {
        return n("launch_app_download_url");
    }

    public SelfT F0(boolean z) {
        s("cts_launch_mode", z);
        return (SelfT) a();
    }

    public int G() {
        return i("appFrameType");
    }

    public SelfT G0(int i2) {
        return (SelfT) v("launchFlags", i2);
    }

    public String H() {
        return o("mAppId", "");
    }

    public SelfT H0(String str) {
        y("mFromLast", T());
        return (SelfT) y("mFrom", str);
    }

    public String I() {
        return n("mAppKey");
    }

    public SelfT I0(String str) {
        return (SelfT) y("launch_id", str);
    }

    public String J() {
        return n("launch_app_open_url");
    }

    public SelfT J0(String str) {
        return (SelfT) y("launchScheme", str);
    }

    public String K() {
        return n("mAppTitle");
    }

    public SelfT K0(boolean z) {
        return (SelfT) s("local_debug_switch", z);
    }

    public String L() {
        return n("mClickId");
    }

    public SelfT L0(String str) {
        return (SelfT) y("local_debug_ws_host", str);
    }

    public JSONObject M() {
        String W = W();
        Pair<String, JSONObject> pair = this.f41667f;
        if (pair != null && TextUtils.equals((CharSequence) pair.first, W)) {
            return (JSONObject) this.f41667f.second;
        }
        this.f41667f = null;
        if (TextUtils.isEmpty(W)) {
            this.f41667f = null;
            return null;
        }
        String queryParameter = Uri.parse(W).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.f41667f = new Pair<>(W, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e2) {
                if (f41666g) {
                    e2.printStackTrace();
                }
            }
        }
        Pair<String, JSONObject> pair2 = this.f41667f;
        if (pair2 == null) {
            return null;
        }
        return (JSONObject) pair2.second;
    }

    public SelfT M0(String str) {
        return (SelfT) y("local_debug_ws_port", str);
    }

    public long N() {
        return k("last_start_timestamp");
    }

    public SelfT N0(long j) {
        if (2147483648L != j) {
            w("navigate_bar_color_key", j);
        }
        return (SelfT) a();
    }

    public ExtensionCore O() {
        return (ExtensionCore) m("extensionCore");
    }

    public SelfT O0(String str) {
        return (SelfT) y("notInHistory", str);
    }

    public Bundle P() {
        return f("mExtraData");
    }

    public SelfT P0(int i2) {
        return (SelfT) v("appFrameOrientation", i2);
    }

    public String Q() {
        return n("app_icon_url");
    }

    public SelfT Q0(String str) {
        return (SelfT) y("mPage", str);
    }

    public boolean R() {
        return e("cts_launch_mode", false);
    }

    public SelfT R0(PMSAppInfo pMSAppInfo) {
        return (SelfT) x("pms_db_info_onload", pMSAppInfo);
    }

    public int S() {
        return j("launchFlags", 0);
    }

    public SelfT S0(String str) {
        return (SelfT) y("remoteDebugUrl", str);
    }

    public String T() {
        return n("mFrom");
    }

    public SelfT T0(String str) {
        return (SelfT) a();
    }

    public String U() {
        return n("mFromLast");
    }

    public SelfT U0(String str) {
        return (SelfT) y("swan_app_sub_root_path", str);
    }

    public String V() {
        return n("launch_id");
    }

    public SelfT V0(String str) {
        return (SelfT) a();
    }

    public String W() {
        return n("launchScheme");
    }

    public SelfT W0(long j) {
        return (SelfT) a();
    }

    public String X() {
        return n("local_debug_ws_host");
    }

    public SelfT X0(SwanCoreVersion swanCoreVersion) {
        return (SelfT) x("swanCoreVersion", swanCoreVersion);
    }

    public String Y() {
        return n("local_debug_ws_port");
    }

    public SelfT Y0(String str) {
        return (SelfT) y("targetSwanVersion", str);
    }

    public String Z() {
        return n("max_swan_version");
    }

    public SelfT Z0(String str) {
        return (SelfT) a();
    }

    public String a0() {
        return n("min_swan_version");
    }

    public SelfT a1(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            x("pms_db_info_updated", pMSAppInfo);
            if (!k0()) {
                R0(pMSAppInfo);
            }
        }
        return (SelfT) a();
    }

    public long b0() {
        return l("navigate_bar_color_key", 2147483648L);
    }

    public String c0() {
        return n("notInHistory");
    }

    public int d0() {
        int j = j("appFrameOrientation", -1);
        if (-1 < j) {
            return j;
        }
        return -1;
    }

    public String e0() {
        return n("mPage");
    }

    public PMSAppInfo f0() {
        return (PMSAppInfo) m("pms_db_info_onload");
    }

    public String g0() {
        return n("remoteDebugUrl");
    }

    public String h0() {
        return n("swan_app_sub_root_path");
    }

    public SwanCoreVersion i0() {
        return (SwanCoreVersion) m("swanCoreVersion");
    }

    public String j0() {
        return n("targetSwanVersion");
    }

    public boolean k0() {
        return c("pms_db_info_onload") && f0() != null;
    }

    public boolean l0() {
        return e("console_switch", false);
    }

    public boolean m0() {
        return e("mIsDebug", false);
    }

    public boolean n0() {
        return e("swan_app_independent", false);
    }

    public boolean o0() {
        return e("local_debug_switch", false);
    }

    public SelfT p0(String str, long j) {
        r0().putLong(str, j);
        return (SelfT) a();
    }

    public SelfT q0(String str, String str2) {
        if (str != null && str2 != null) {
            r0().putString(str, str2);
        }
        return (SelfT) a();
    }

    @NonNull
    public Bundle r0() {
        Bundle P = P();
        if (P == null) {
            Bundle bundle = new Bundle();
            C0(bundle);
            return bundle;
        }
        return P;
    }

    public SelfT s0(String str) {
        return (SelfT) a();
    }

    public SelfT t0(int i2) {
        return (SelfT) v("appFrameType", i2);
    }

    public SelfT u0(String str) {
        y("mAppId", str);
        return (SelfT) a();
    }

    public SelfT v0(String str) {
        y("mAppKey", str);
        return (SelfT) a();
    }

    public SelfT w0(String str) {
        y("mAppTitle", str);
        return (SelfT) a();
    }

    public SelfT x0(String str) {
        return (SelfT) y("mClickId", str);
    }

    public SelfT y0(boolean z) {
        return (SelfT) s("console_switch", z);
    }

    public SelfT z0(boolean z) {
        return (SelfT) s("mIsDebug", z);
    }
}
