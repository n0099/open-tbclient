package d.b.i0.p0.q1.a;

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
public class b extends d.b.b.j.e.a<d.b.i0.p0.q1.c.a, ForumRuleDetailBottomVH> {
    public Context m;
    public String n;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.p0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        l0(i, view, viewGroup, aVar, forumRuleDetailBottomVH);
        return view;
    }

    public final void h0(ForumRuleDetailBottomVH forumRuleDetailBottomVH, d.b.i0.p0.q1.c.a aVar) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.f16267b.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f16267b.W(aVar.a(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group);
        EMTextView eMTextView = forumRuleDetailBottomVH.f16269d;
        eMTextView.setText(aVar.e() + string);
        forumRuleDetailBottomVH.f16271f.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f16271f.W(aVar.g(), 12, false);
        forumRuleDetailBottomVH.f16272g.setText(aVar.f());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailBottomVH.b(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.f16273h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.j()));
            forumRuleDetailBottomVH.f16270e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.j()));
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public ForumRuleDetailBottomVH R(ViewGroup viewGroup) {
        ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_bottom, viewGroup, false));
        i0(forumRuleDetailBottomVH);
        this.k = forumRuleDetailBottomVH;
        return forumRuleDetailBottomVH;
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.p0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (aVar != null) {
            h0(forumRuleDetailBottomVH, aVar);
        }
        return view;
    }

    public void setFrom(String str) {
        this.n = str;
    }
}
