package d.a.n0.v.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.a.m0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f62050a;

    public String a() {
        return this.f62050a;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f62050a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
