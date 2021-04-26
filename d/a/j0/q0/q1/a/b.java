package d.a.j0.q0.q1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailBottomVH;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.q0.q1.c.a, ForumRuleDetailBottomVH> {
    public Context m;
    public String n;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.j0.q0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        h0(i2, view, viewGroup, aVar, forumRuleDetailBottomVH);
        return view;
    }

    public final void e0(ForumRuleDetailBottomVH forumRuleDetailBottomVH, d.a.j0.q0.q1.c.a aVar) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.f16129b.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f16129b.V(aVar.c(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group);
        EMTextView eMTextView = forumRuleDetailBottomVH.f16131d;
        eMTextView.setText(aVar.e() + string);
        forumRuleDetailBottomVH.f16133f.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f16133f.V(aVar.h(), 12, false);
        forumRuleDetailBottomVH.f16134g.setText(aVar.f());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailBottomVH.b(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.f16135h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.i()));
            forumRuleDetailBottomVH.f16132e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.i()));
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ForumRuleDetailBottomVH P(ViewGroup viewGroup) {
        ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_bottom, viewGroup, false));
        f0(forumRuleDetailBottomVH);
        this.k = forumRuleDetailBottomVH;
        return forumRuleDetailBottomVH;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.j0.q0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (aVar != null) {
            e0(forumRuleDetailBottomVH, aVar);
        }
        return view;
    }

    public void setFrom(String str) {
        this.n = str;
    }
}
