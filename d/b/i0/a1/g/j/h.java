package d.b.i0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f52810e;

    /* renamed from: f  reason: collision with root package name */
    public int f52811f;

    /* renamed from: g  reason: collision with root package name */
    public String f52812g;

    /* renamed from: h  reason: collision with root package name */
    public String f52813h;

    public void g(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f52812g = liveAnswer.banner_url;
        this.f52810e = liveAnswer.banner_high.intValue();
        this.f52811f = liveAnswer.banner_width.intValue();
        this.f52813h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f52811f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f52812g);
            jSONObject.put("img_height", this.f52810e);
            jSONObject.put("jump_url", this.f52813h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
