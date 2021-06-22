package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.data.PostData;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes3.dex */
public class f2 extends PostData {
    public static final BdUniqueId E0 = BdUniqueId.gen();
    public String C0;
    public String D0;

    public String C0() {
        return this.C0;
    }

    public String D0() {
        return this.D0;
    }

    public void E0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.C0 = jSONObject.optString("news_link");
            this.D0 = jSONObject.optString("summary");
            jSONObject.optInt("position", 0);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void F0(TopNews topNews) {
        if (topNews == null) {
            return;
        }
        this.C0 = topNews.news_link;
        this.D0 = topNews.summary;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return E0;
    }
}
