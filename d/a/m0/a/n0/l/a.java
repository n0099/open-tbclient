package d.a.m0.a.n0.l;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.n0.l.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final String f47462a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f47463b;

    public a(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        this.f47463b = jSONObject;
        this.f47462a = str;
        try {
            jSONObject.put(IntentConfig.PKG_ID, str);
            if (z) {
                d();
            }
        } catch (JSONException e2) {
            if (b.e0) {
                e2.printStackTrace();
            }
        }
    }

    public static a c(String str) {
        return new a(str, true);
    }

    @Override // d.a.m0.a.n0.l.b.a
    public String a() {
        return this.f47462a;
    }

    @Override // d.a.m0.a.n0.l.b.a
    public JSONObject b() {
        return this.f47463b;
    }

    public final void d() throws JSONException {
        PMSAppInfo s;
        if (!isValid() || (s = d.a.m0.n.g.a.h().s(this.f47462a)) == null) {
            return;
        }
        this.f47463b.put("app_name", s.appName);
        this.f47463b.put("pkg_vername", s.versionName);
        this.f47463b.put("pkg_vercode", s.versionCode);
        this.f47463b.put("create_time", s.createTime);
        this.f47463b.put("last_launch_time", s.g());
        this.f47463b.put("launch_count", s.h());
        this.f47463b.put("install_src", s.f());
    }

    @Override // d.a.m0.a.n0.l.b.a
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f47462a);
    }
}
