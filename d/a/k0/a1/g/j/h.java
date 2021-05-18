package d.a.k0.a1.g.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f51646i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f51647e;

    /* renamed from: f  reason: collision with root package name */
    public int f51648f;

    /* renamed from: g  reason: collision with root package name */
    public String f51649g;

    /* renamed from: h  reason: collision with root package name */
    public String f51650h;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51646i;
    }

    public void h(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f51649g = liveAnswer.banner_url;
        this.f51647e = liveAnswer.banner_high.intValue();
        this.f51648f = liveAnswer.banner_width.intValue();
        this.f51650h = liveAnswer.jump_url;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f51648f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f51649g);
            jSONObject.put("img_height", this.f51647e);
            jSONObject.put("jump_url", this.f51650h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
