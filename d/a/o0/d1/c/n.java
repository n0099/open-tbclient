package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes4.dex */
public class n extends d.a.o0.z.e0.a {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f56417g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.n> f56418e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56419f;

    public int getCount() {
        List<d.a.c.k.e.n> list = this.f56418e;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f56418e.size();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return f56417g;
    }

    public void parserProtobuf(List<RelateForum> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.recommend_relative_forum);
        this.f56418e = new ArrayList();
        for (RelateForum relateForum : list) {
            if (!StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.f56418e.add(relateForumItemData);
            }
        }
    }
}
