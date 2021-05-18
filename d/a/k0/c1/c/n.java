package d.a.k0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes4.dex */
public class n extends d.a.k0.x.e0.a {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f52423g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.n> f52424e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52425f;

    public int getCount() {
        List<d.a.c.j.e.n> list = this.f52424e;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f52424e.size();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return f52423g;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
        this.f52424e = new ArrayList();
        for (RelateForum relateForum : list) {
            if (!StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.f52424e.add(relateForumItemData);
            }
        }
    }
}
