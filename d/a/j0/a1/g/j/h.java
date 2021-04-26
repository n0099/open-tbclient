package d.a.j0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f50947i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f50948e;

    /* renamed from: f  reason: collision with root package name */
    public int f50949f;

    /* renamed from: g  reason: collision with root package name */
    public String f50950g;

    /* renamed from: h  reason: collision with root package name */
    public String f50951h;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f50947i;
    }

    public void h(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f50950g = liveAnswer.banner_url;
        this.f50948e = liveAnswer.banner_high.intValue();
        this.f50949f = liveAnswer.banner_width.intValue();
        this.f50951h = liveAnswer.jump_url;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f50949f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f50950g);
            jSONObject.put("img_height", this.f50948e);
            jSONObject.put("jump_url", this.f50951h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
