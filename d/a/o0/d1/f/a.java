package d.a.o0.d1.f;

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
import d.a.o0.d1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends d.a.o0.z.c<n> {
    public RelateForumHorizonalListView x;
    public List<d.a.c.k.e.n> y;
    public TbPageContext<?> z;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.z = tbPageContext;
        this.x = new RelateForumHorizonalListView(b());
        this.y = new ArrayList();
        this.x.setTag(j());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        x(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        w(false);
    }

    @Override // d.a.o0.z.c, d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        super.o(tbPageContext, i2);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.l(i2);
        }
    }

    @Override // d.a.o0.z.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView == null || relateForumHorizonalListView.getLastItemView() != view || this.y == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        this.z.sendMessage(new CustomMessage(2002001, new RelateTopicForumActivityConfig(this.z.getPageActivity(), this.y, ((HotTopicActivity) this.z.getOrignalPage()).getHotTopicId())));
    }

    @Override // d.a.o0.z.b
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.setTag(j());
        }
    }

    @Override // d.a.o0.z.b
    public void setFrom(String str) {
        super.setFrom(str);
        this.x.setFrom(str);
    }

    public final List<d.a.n0.b1.g.a> y(List<d.a.c.k.e.n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.k.e.n nVar : list) {
            if (nVar instanceof RelateForumItemData) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                long j = relateForumItemData.forumId;
                String str = relateForumItemData.forumName;
                String str2 = relateForumItemData.forumAvatar;
                boolean z = relateForumItemData.isLiked;
                if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    d.a.n0.b1.g.a aVar = new d.a.n0.b1.g.a();
                    aVar.f52804b = str2;
                    aVar.f52806d = j;
                    aVar.f52805c = str;
                    aVar.f52807e = z;
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: z */
    public void n(n nVar) {
        super.v(nVar);
        if (nVar == null) {
            m().setVisibility(8);
            return;
        }
        this.y.clear();
        List<d.a.c.k.e.n> list = nVar.f56418e;
        if (list != null) {
            this.y.addAll(list);
        }
        List<d.a.n0.b1.g.a> y = y(this.y);
        int count = ListUtils.getCount(y);
        if (count <= 0) {
            m().setVisibility(8);
            return;
        }
        m().setVisibility(0);
        if (count > 10) {
            this.x.setData(y.subList(0, 10), k(), true);
        } else {
            this.x.setData(y, k(), false);
        }
        o(k(), TbadkCoreApplication.getInst().getSkinType());
    }
}
