package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes3.dex */
public class f2 extends PostData {
    public static final BdUniqueId y0 = BdUniqueId.gen();
    public String w0;
    public String x0;

    public String A0() {
        return this.w0;
    }

    public String B0() {
        return this.x0;
    }

    public void C0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.w0 = jSONObject.optString("news_link");
            this.x0 = jSONObject.optString("summary");
            jSONObject.optInt("position", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void D0(TopNews topNews) {
        if (topNews == null) {
            return;
        }
        this.w0 = topNews.news_link;
        this.x0 = topNews.summary;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.b.b.j.e.n
    public BdUniqueId getType() {
        return y0;
    }
}
