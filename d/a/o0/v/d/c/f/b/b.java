package d.a.o0.v.d.c.f.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f65371e;

    /* renamed from: f  reason: collision with root package name */
    public String f65372f;

    /* renamed from: g  reason: collision with root package name */
    public String f65373g;

    /* renamed from: h  reason: collision with root package name */
    public String f65374h;

    /* renamed from: i  reason: collision with root package name */
    public String f65375i;
    public String j;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f65371e = jSONObject.optString("user_id");
        this.f65372f = jSONObject.optString("user_name");
        this.f65373g = jSONObject.optString("user_nickname");
        this.f65374h = jSONObject.optString("portrait");
        this.f65375i = jSONObject.optString("user_brief");
        jSONObject.optLong("start_time");
        this.j = jSONObject.optString("remark");
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
