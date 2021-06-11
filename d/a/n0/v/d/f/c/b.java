package d.a.n0.v.d.f.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65430g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f65431e;

    /* renamed from: f  reason: collision with root package name */
    public String f65432f;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65431e = jSONObject.optString("url");
        this.f65432f = jSONObject.optString("pic");
        jSONObject.optLong("start_time", 0L);
        jSONObject.optLong(ResultTB.ENDTIME, 0L);
        jSONObject.optString("name");
        jSONObject.optInt("id");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f65430g;
    }
}
