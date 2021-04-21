package d.b.h0.a.y0.e;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.kwai.video.player.KsMediaMeta;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class e<SelfT extends e<SelfT>> extends d.b.h0.a.y0.e.f.c<SelfT> {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47811h = k.f45772a;

    /* renamed from: g  reason: collision with root package name */
    public Pair<String, JSONObject> f47812g;

    public SelfT A0(boolean z) {
        return (SelfT) q("swan_app_independent", z);
    }

    public SelfT B0(boolean z) {
        q("cts_launch_mode", z);
        return (SelfT) a();
    }

    public SelfT C0(int i) {
        return (SelfT) t("launchFlags", i);
    }

    public SelfT D(int i) {
        return C0(i | R());
    }

    public SelfT D0(String str) {
        w("mFromLast", S());
        return (SelfT) w("mFrom", str);
    }

    public String E() {
        return m("launch_app_download_url");
    }

    public SelfT E0(String str) {
        return (SelfT) w("launch_id", str);
    }

    public int F() {
        return h("appFrameType");
    }

    public SelfT F0(String str) {
        return (SelfT) w("launchScheme", str);
    }

    public String G() {
        return n("mAppId", "");
    }

    public SelfT G0(long j) {
        if (KsMediaMeta.AV_CH_WIDE_LEFT != j) {
            u("navigate_bar_color_key", j);
        }
        return (SelfT) a();
    }

    public String H() {
        return m("mAppKey");
    }

    public SelfT H0(String str) {
        return (SelfT) w("notInHistory", str);
    }

    public String I() {
        return m("launch_app_open_url");
    }

    public SelfT I0(int i) {
        return (SelfT) t("appFrameOrientation", i);
    }

    public String J() {
        return m("mAppTitle");
    }

    public SelfT J0(String str) {
        return (SelfT) w("mPage", str);
    }

    public String K() {
        return m("mClickId");
    }

    public SelfT K0(PMSAppInfo pMSAppInfo) {
        return (SelfT) v("pms_db_info_onload", pMSAppInfo);
    }

    public JSONObject L() {
        String V = V();
        Pair<String, JSONObject> pair = this.f47812g;
        if (pair != null && TextUtils.equals((CharSequence) pair.first, V)) {
            return (JSONObject) this.f47812g.second;
        }
        this.f47812g = null;
        if (TextUtils.isEmpty(V)) {
            this.f47812g = null;
            return null;
        }
        String queryParameter = Uri.parse(V).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.f47812g = new Pair<>(V, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e2) {
                if (f47811h) {
                    e2.printStackTrace();
                }
            }
        }
        Pair<String, JSONObject> pair2 = this.f47812g;
        if (pair2 == null) {
            return null;
        }
        return (JSONObject) pair2.second;
    }

    public SelfT L0(String str) {
        return (SelfT) w("remoteDebugUrl", str);
    }

    public long M() {
        return j("last_start_timestamp");
    }

    public SelfT M0(String str) {
        return (SelfT) a();
    }

    public ExtensionCore N() {
        return (ExtensionCore) l("extensionCore");
    }

    public SelfT N0(String str) {
        return (SelfT) w("swan_app_sub_root_path", str);
    }

    public Bundle O() {
        return e("mExtraData");
    }

    public SelfT O0(String str) {
        return (SelfT) a();
    }

    public String P() {
        return m("app_icon_url");
    }

    public SelfT P0(long j) {
        return (SelfT) a();
    }

    public boolean Q() {
        return d("cts_launch_mode", false);
    }

    public SelfT Q0(SwanCoreVersion swanCoreVersion) {
        return (SelfT) v("swanCoreVersion", swanCoreVersion);
    }

    public int R() {
        return i("launchFlags", 0);
    }

    public SelfT R0(String str) {
        return (SelfT) w("targetSwanVersion", str);
    }

    public String S() {
        return m("mFrom");
    }

    public SelfT S0(String str) {
        return (SelfT) a();
    }

    public String T() {
        return m("mFromLast");
    }

    public SelfT T0(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            v("pms_db_info_updated", pMSAppInfo);
            if (!h0()) {
                K0(pMSAppInfo);
            }
        }
        return (SelfT) a();
    }

    public String U() {
        return m("launch_id");
    }

    public String V() {
        return m("launchScheme");
    }

    public String W() {
        return m("max_swan_version");
    }

    public String X() {
        return m("min_swan_version");
    }

    public long Y() {
        return k("navigate_bar_color_key", KsMediaMeta.AV_CH_WIDE_LEFT);
    }

    public String Z() {
        return m("notInHistory");
    }

    public int a0() {
        int i = i("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public String b0() {
        return m("mPage");
    }

    public PMSAppInfo c0() {
        return (PMSAppInfo) l("pms_db_info_onload");
    }

    public String d0() {
        return m("remoteDebugUrl");
    }

    public String e0() {
        return m("swan_app_sub_root_path");
    }

    public SwanCoreVersion f0() {
        return (SwanCoreVersion) l("swanCoreVersion");
    }

    public String g0() {
        return m("targetSwanVersion");
    }

    public boolean h0() {
        return c("pms_db_info_onload") && c0() != null;
    }

    public boolean i0() {
        return d("console_switch", false);
    }

    public boolean j0() {
        return d("mIsDebug", false);
    }

    public boolean k0() {
        return d("swan_app_independent", false);
    }

    public SelfT l0(String str, long j) {
        n0().putLong(str, j);
        return (SelfT) a();
    }

    public SelfT m0(String str, String str2) {
        if (str != null && str2 != null) {
            n0().putString(str, str2);
        }
        return (SelfT) a();
    }

    @NonNull
    public Bundle n0() {
        Bundle O = O();
        if (O == null) {
            Bundle bundle = new Bundle();
            y0(bundle);
            return bundle;
        }
        return O;
    }

    public SelfT o0(String str) {
        return (SelfT) a();
    }

    public SelfT p0(int i) {
        return (SelfT) t("appFrameType", i);
    }

    public SelfT q0(String str) {
        w("mAppId", str);
        return (SelfT) a();
    }

    public SelfT r0(String str) {
        w("mAppKey", str);
        return (SelfT) a();
    }

    public SelfT s0(String str) {
        w("mAppTitle", str);
        return (SelfT) a();
    }

    public SelfT t0(String str) {
        return (SelfT) w("mClickId", str);
    }

    public SelfT u0(boolean z) {
        return (SelfT) q("console_switch", z);
    }

    public SelfT v0(boolean z) {
        return (SelfT) q("mIsDebug", z);
    }

    public SelfT w0(long j) {
        return (SelfT) u("last_start_timestamp", j);
    }

    public SelfT x0(ExtensionCore extensionCore) {
        return (SelfT) v("extensionCore", extensionCore);
    }

    public SelfT y0(Bundle bundle) {
        return (SelfT) r("mExtraData", bundle);
    }

    public SelfT z0(String str) {
        w("app_icon_url", str);
        return (SelfT) a();
    }
}
