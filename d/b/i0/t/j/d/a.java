package d.b.i0.t.j.d;

import com.baidu.searchbox.account.contants.LoginConstants;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends d.b.h0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public String f62418a;

    public String a() {
        return this.f62418a;
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f62418a = jSONObject.optString(LoginConstants.QQ_LOGIN, "");
        }
    }
}
