package d.b.i0.z0.g.j;

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
    public int f63190e;

    /* renamed from: f  reason: collision with root package name */
    public int f63191f;

    /* renamed from: g  reason: collision with root package name */
    public String f63192g;

    /* renamed from: h  reason: collision with root package name */
    public String f63193h;

    public void g(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f63192g = liveAnswer.banner_url;
        this.f63190e = liveAnswer.banner_high.intValue();
        this.f63191f = liveAnswer.banner_width.intValue();
        this.f63193h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f63191f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f63192g);
            jSONObject.put("img_height", this.f63190e);
            jSONObject.put("jump_url", this.f63193h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
