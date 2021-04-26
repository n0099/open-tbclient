package d.a.j0.t.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.a.i0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f61038a;

    public String a() {
        return this.f61038a;
    }

    @Override // d.a.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f61038a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
