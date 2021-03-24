package d.b.h0.r.y.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.r.y.l;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import d.b.h0.t.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends n {
    public b(l lVar) {
        super(lVar);
    }

    @o("appointNotice")
    public void appointNotice(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("activityId");
            int optInt2 = jSONObject.optInt("state");
            String optString = jSONObject.optString("curNum");
            g gVar = new g();
            gVar.d(optInt);
            gVar.f(optInt2);
            gVar.e(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016492, gVar));
        }
    }

    @Override // d.b.h0.r.y.n
    public String g() {
        return "TBHY_EXT_FocusFeed";
    }
}
