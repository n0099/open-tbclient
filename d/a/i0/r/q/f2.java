package d.a.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes3.dex */
public class f2 extends PostData {
    public static final BdUniqueId z0 = BdUniqueId.gen();
    public String x0;
    public String y0;

    public String C0() {
        return this.x0;
    }

    public String D0() {
        return this.y0;
    }

    public void E0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.x0 = jSONObject.optString("news_link");
            this.y0 = jSONObject.optString("summary");
            jSONObject.optInt("position", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void F0(TopNews topNews) {
        if (topNews == null) {
            return;
        }
        this.x0 = topNews.news_link;
        this.y0 = topNews.summary;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.j.e.n
    public BdUniqueId getType() {
        return z0;
    }
}
