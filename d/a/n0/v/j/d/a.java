package d.a.n0.v.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.a.m0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f65765a;

    public String a() {
        return this.f65765a;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f65765a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
