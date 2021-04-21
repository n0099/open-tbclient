package d.b.j0.t.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.b.i0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f62839a;

    public String a() {
        return this.f62839a;
    }

    @Override // d.b.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f62839a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
