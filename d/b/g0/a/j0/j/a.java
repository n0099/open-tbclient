package d.b.g0.a.j0.j;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.j0.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f45255a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f45256b;

    public a(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        this.f45256b = jSONObject;
        this.f45255a = str;
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

    @Override // d.b.g0.a.j0.j.b.a
    public String a() {
        return this.f45255a;
    }

    @Override // d.b.g0.a.j0.j.b.a
    public JSONObject b() {
        return this.f45256b;
    }

    public final void d() throws JSONException {
        PMSAppInfo r;
        if (!isValid() || (r = d.b.g0.l.i.a.h().r(this.f45255a)) == null) {
            return;
        }
        this.f45256b.put(DpStatConstants.KEY_APP_NAME, r.appName);
        this.f45256b.put("pkg_vername", r.versionName);
        this.f45256b.put("pkg_vercode", r.versionCode);
        this.f45256b.put("create_time", r.createTime);
        this.f45256b.put("last_launch_time", r.g());
        this.f45256b.put("launch_count", r.h());
        this.f45256b.put("install_src", r.f());
    }

    @Override // d.b.g0.a.j0.j.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f45255a);
    }
}
