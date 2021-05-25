package d.a.l0.a.n0.l;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.n0.l.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f43678a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43679b;

    public a(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        this.f43679b = jSONObject;
        this.f43678a = str;
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

    @Override // d.a.l0.a.n0.l.b.a
    public String a() {
        return this.f43678a;
    }

    @Override // d.a.l0.a.n0.l.b.a
    public JSONObject b() {
        return this.f43679b;
    }

    public final void d() throws JSONException {
        PMSAppInfo s;
        if (!isValid() || (s = d.a.l0.n.g.a.h().s(this.f43678a)) == null) {
            return;
        }
        this.f43679b.put("app_name", s.appName);
        this.f43679b.put("pkg_vername", s.versionName);
        this.f43679b.put("pkg_vercode", s.versionCode);
        this.f43679b.put("create_time", s.createTime);
        this.f43679b.put("last_launch_time", s.g());
        this.f43679b.put("launch_count", s.h());
        this.f43679b.put("install_src", s.f());
    }

    @Override // d.a.l0.a.n0.l.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f43678a);
    }
}
