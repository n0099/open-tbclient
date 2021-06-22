package d.a.n0.r.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes3.dex */
public class d1 extends PostData {
    public static final BdUniqueId L0 = BdUniqueId.gen();
    public String C0;
    public String D0;
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public List<String> I0;
    public String J0;
    public String K0;

    public boolean C0() {
        return !StringUtils.isNull(this.F0);
    }

    public void D0(RecommendBook recommendBook) {
        if (recommendBook == null) {
            return;
        }
        this.C0 = recommendBook.recommend_text;
        this.D0 = recommendBook.suggest_text;
        this.E0 = recommendBook.suggest_url;
        this.F0 = recommendBook.book_id;
        recommendBook.book_type.intValue();
        this.G0 = recommendBook.book_cover;
        this.H0 = recommendBook.book_title;
        this.I0 = recommendBook.book_tips;
        this.J0 = recommendBook.botton_text;
        this.K0 = recommendBook.subscript_icon;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, d.a.c.k.e.n
    public BdUniqueId getType() {
        return L0;
    }
}
