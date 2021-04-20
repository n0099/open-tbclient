package d.b.h0.r.y.s;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.r.y.l;
import d.b.h0.r.y.n;
import d.b.h0.r.y.o;
import d.b.h0.t.h;
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
            h hVar = new h();
            hVar.a(optInt);
            hVar.c(optInt2);
            hVar.b(optString);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016492, hVar));
        }
    }

    @Override // d.b.h0.r.y.n
    public String g() {
        return "TBHY_EXT_FocusFeed";
    }
}
