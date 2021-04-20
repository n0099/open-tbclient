package d.b.h0.r.q;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class h0 extends a2 {
    public static final BdUniqueId E3 = BdUniqueId.gen();

    @Override // d.b.h0.r.q.a2, com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return E3;
    }

    public void z4(RecommendBook recommendBook) {
        if (recommendBook == null) {
            return;
        }
        recommendBook.type.intValue();
        String str = recommendBook.book_id;
        String str2 = recommendBook.title;
        String str3 = recommendBook.image;
        List<String> list = recommendBook.desc;
        String str4 = recommendBook.link_url;
    }
}
