package d.a.h0.a.j0.j;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.j0.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f42907a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f42908b;

    public a(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        this.f42908b = jSONObject;
        this.f42907a = str;
        try {
            jSONObject.put(IntentConfig.PKG_ID, str);
            if (z) {
                d();
            }
        } catch (JSONException e2) {
            if (b.G0) {
                e2.printStackTrace();
            }
        }
    }

    public static a c(String str) {
        return new a(str, true);
    }

    @Override // d.a.h0.a.j0.j.b.a
    public String a() {
        return this.f42907a;
    }

    @Override // d.a.h0.a.j0.j.b.a
    public JSONObject b() {
        return this.f42908b;
    }

    public final void d() throws JSONException {
        PMSAppInfo r;
        if (!isValid() || (r = d.a.h0.l.i.a.h().r(this.f42907a)) == null) {
            return;
        }
        this.f42908b.put(DpStatConstants.KEY_APP_NAME, r.appName);
        this.f42908b.put("pkg_vername", r.versionName);
        this.f42908b.put("pkg_vercode", r.versionCode);
        this.f42908b.put("create_time", r.createTime);
        this.f42908b.put("last_launch_time", r.g());
        this.f42908b.put("launch_count", r.h());
        this.f42908b.put("install_src", r.f());
    }

    @Override // d.a.h0.a.j0.j.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f42907a);
    }
}
