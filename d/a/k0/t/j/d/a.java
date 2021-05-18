package d.a.k0.t.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.a.j0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f61762a;

    public String a() {
        return this.f61762a;
    }

    @Override // d.a.j0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f61762a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
