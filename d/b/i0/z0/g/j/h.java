package d.b.i0.z0.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes3.dex */
public class h extends BaseCardInfo {
    public static final BdUniqueId i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f63191e;

    /* renamed from: f  reason: collision with root package name */
    public int f63192f;

    /* renamed from: g  reason: collision with root package name */
    public String f63193g;

    /* renamed from: h  reason: collision with root package name */
    public String f63194h;

    public void g(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f63193g = liveAnswer.banner_url;
        this.f63191e = liveAnswer.banner_high.intValue();
        this.f63192f = liveAnswer.banner_width.intValue();
        this.f63194h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f63192f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f63193g);
            jSONObject.put("img_height", this.f63191e);
            jSONObject.put("jump_url", this.f63194h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
