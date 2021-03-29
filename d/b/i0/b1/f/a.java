package d.b.i0.b1.f;

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
import d.b.i0.b1.c.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d.b.i0.x.c<n> {
    public RelateForumHorizonalListView x;
    public List<d.b.b.j.e.n> y;
    public TbPageContext<?> z;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.z = tbPageContext;
        this.x = new RelateForumHorizonalListView(b());
        this.y = new ArrayList();
        this.x.setTag(k());
        this.x.setLoadMoreClickListener(this);
        this.u.addView(this.x);
        this.m.setOnClickListener(this);
        y(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
        x(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: A */
    public void n(n nVar) {
        super.w(nVar);
        if (nVar == null) {
            m().setVisibility(8);
            return;
        }
        this.y.clear();
        List<d.b.b.j.e.n> list = nVar.f52139e;
        if (list != null) {
            this.y.addAll(list);
        }
        List<d.b.h0.b1.g.a> z = z(this.y);
        int count = ListUtils.getCount(z);
        if (count <= 0) {
            m().setVisibility(8);
            return;
        }
        m().setVisibility(0);
        if (count > 10) {
            this.x.setData(z.subList(0, 10), l(), true);
        } else {
            this.x.setData(z, l(), false);
        }
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.c, d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        super.o(tbPageContext, i);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.l(i);
        }
    }

    @Override // d.b.i0.x.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView == null || relateForumHorizonalListView.getLastItemView() != view || this.y == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
        this.z.sendMessage(new CustomMessage(2002001, new RelateTopicForumActivityConfig(this.z.getPageActivity(), this.y, ((HotTopicActivity) this.z.getOrignalPage()).getHotTopicId())));
    }

    @Override // d.b.i0.x.b
    public void r(BdUniqueId bdUniqueId) {
        super.r(bdUniqueId);
        RelateForumHorizonalListView relateForumHorizonalListView = this.x;
        if (relateForumHorizonalListView != null) {
            relateForumHorizonalListView.setTag(k());
        }
    }

    @Override // d.b.i0.x.b
    public void setFrom(String str) {
        super.setFrom(str);
        this.x.setFrom(str);
    }

    public final List<d.b.h0.b1.g.a> z(List<d.b.b.j.e.n> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.b.j.e.n nVar : list) {
            if (nVar instanceof RelateForumItemData) {
                RelateForumItemData relateForumItemData = (RelateForumItemData) nVar;
                long j = relateForumItemData.forumId;
                String str = relateForumItemData.forumName;
                String str2 = relateForumItemData.forumAvatar;
                boolean z = relateForumItemData.isLiked;
                if (j >= 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    d.b.h0.b1.g.a aVar = new d.b.h0.b1.g.a();
                    aVar.f49880b = str2;
                    aVar.f49882d = j;
                    aVar.f49881c = str;
                    aVar.f49883e = z;
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }
}
