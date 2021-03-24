package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes4.dex */
public class n extends d.b.i0.x.e0.a {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52137g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.n> f52138e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52139f;

    public int getCount() {
        List<d.b.b.j.e.n> list = this.f52138e;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f52138e.size();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return f52137g;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
        this.f52138e = new ArrayList();
        for (RelateForum relateForum : list) {
            if (!StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.f52138e.add(relateForumItemData);
            }
        }
    }
}
