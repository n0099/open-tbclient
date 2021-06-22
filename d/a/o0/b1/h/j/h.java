package d.a.o0.b1.h.j;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Personalized.LiveAnswer;
/* loaded from: classes4.dex */
public class h extends BaseCardInfo {

    /* renamed from: i  reason: collision with root package name */
    public static final BdUniqueId f55621i = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public int f55622e;

    /* renamed from: f  reason: collision with root package name */
    public int f55623f;

    /* renamed from: g  reason: collision with root package name */
    public String f55624g;

    /* renamed from: h  reason: collision with root package name */
    public String f55625h;

    public void c(LiveAnswer liveAnswer) {
        if (liveAnswer == null) {
            return;
        }
        this.f55624g = liveAnswer.banner_url;
        this.f55622e = liveAnswer.banner_high.intValue();
        this.f55623f = liveAnswer.banner_width.intValue();
        this.f55625h = liveAnswer.jump_url;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f55621i;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("img_width", this.f55623f);
            jSONObject.put(BigdayActivityConfig.IMG_URL, this.f55624g);
            jSONObject.put("img_height", this.f55622e);
            jSONObject.put("jump_url", this.f55625h);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
