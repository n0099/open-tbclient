package d.a.o0.v.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.a.n0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f65890a;

    public String a() {
        return this.f65890a;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f65890a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
