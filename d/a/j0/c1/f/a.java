package d.a.j0.c1.f;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelateTopicForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.RelateForumHorizonalListView;
import d.a.j0.c1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.j0.x.c<n> {
    public RelateForumHorizonalListView x;
    public List<d.a.c.j.e.n> y;
    public TbPageContext<?> z;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.z = tbPageContext;
        this.x = new RelateForumHorizonalListView(b());
        this.y = new ArrayList();
        this.x.setTag(i());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        w(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        v(false);
    }

    @Override // d.a.j0.x.c, d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        super.n(tbPageContext, i2);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.l(i2);
        }
    }

    @Override // d.a.j0.x.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView == null || relateForumHorizonalListView.getLastItemView() != view || this.y == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        this.z.sendMessage(new CustomMessage(2002001, new RelateTopicForumActivityConfig(this.z.getPageActivity(), this.y, ((HotTopicActivity) this.z.getOrignalPage()).getHotTopicId())));
    }

    @Override // d.a.j0.x.b
    public void p(BdUniqueId bdUniqueId) {
        super.p(bdUniqueId);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.setTag(i());
        }
    }

    @Override // d.a.j0.x.b
    public void setFrom(String str) {
        super.setFrom(str);
        this.x.setFrom(str);
    }

    public final List<d.a.i0.b1.g.a> x(List<d.a.c.j.e.n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.j.e.n nVar : list) {
            if (nVar instanceof RelateForumItemData) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                long j = relateForumItemData.forumId;
                String str = relateForumItemData.forumName;
                String str2 = relateForumItemData.forumAvatar;
                boolean z = relateForumItemData.isLiked;
                if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    d.a.i0.b1.g.a aVar = new d.a.i0.b1.g.a();
                    aVar.f48170b = str2;
                    aVar.f48172d = j;
                    aVar.f48171c = str;
                    aVar.f48173e = z;
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: y */
    public void m(n nVar) {
        super.u(nVar);
        if (nVar == null) {
            l().setVisibility(8);
            return;
        }
        this.y.clear();
        List<d.a.c.j.e.n> list = nVar.f51725e;
        if (list != null) {
            this.y.addAll(list);
        }
        List<d.a.i0.b1.g.a> x = x(this.y);
        int count = ListUtils.getCount(x);
        if (count <= 0) {
            l().setVisibility(8);
            return;
        }
        l().setVisibility(0);
        if (count > 10) {
            this.x.setData(x.subList(0, 10), k(), true);
        } else {
            this.x.setData(x, k(), false);
        }
        n(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
