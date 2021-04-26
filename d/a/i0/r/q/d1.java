package d.a.i0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes3.dex */
public class d1 extends PostData {
    public static final BdUniqueId L0 = BdUniqueId.gen();
    public String A0;
    public String B0;
    public String C0;
    public List<String> D0;
    public String E0;
    public String K0;
    public String x0;
    public String y0;
    public String z0;

    public boolean C0() {
        return !StringUtils.isNull(this.A0);
    }

    public void D0(RecommendBook recommendBook) {
        if (recommendBook == null) {
            return;
        }
        this.x0 = recommendBook.recommend_text;
        this.y0 = recommendBook.suggest_text;
        this.z0 = recommendBook.suggest_url;
        this.A0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.B0 = recommendBook.book_cover;
        this.C0 = recommendBook.book_title;
        this.D0 = recommendBook.book_tips;
        this.E0 = recommendBook.botton_text;
        this.K0 = recommendBook.subscript_icon;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.j.e.n
    public BdUniqueId getType() {
        return L0;
    }
}
