package d.b.j0.a1.g.j;

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
    public int f53231e;

    /* renamed from: f  reason: collision with root package name */
    public int f53232f;

    /* renamed from: g  reason: collision with root package name */
    public String f53233g;

    /* renamed from: h  reason: collision with root package name */
    public String f53234h;

    public void g(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f53233g = liveAnswer.banner_url;
        this.f53231e = liveAnswer.banner_high.intValue();
        this.f53232f = liveAnswer.banner_width.intValue();
        this.f53234h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f53232f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f53233g);
            jSONObject.put("img_height", this.f53231e);
            jSONObject.put("jump_url", this.f53234h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
