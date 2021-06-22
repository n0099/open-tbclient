package d.a.o0.r0.q1.a;

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
public class b extends d.a.c.k.e.a<d.a.o0.r0.q1.c.a, ForumRuleDetailBottomVH> {
    public Context m;
    public String n;

    public b(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.o0.r0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        i0(i2, view, viewGroup, aVar, forumRuleDetailBottomVH);
        return view;
    }

    public final void e0(ForumRuleDetailBottomVH forumRuleDetailBottomVH, d.a.o0.r0.q1.c.a aVar) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.f15491b.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f15491b.U(aVar.b(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(R.string.forum_rules_bar_management_group);
        EMTextView eMTextView = forumRuleDetailBottomVH.f15493d;
        eMTextView.setText(aVar.c() + string);
        forumRuleDetailBottomVH.f15495f.setDefaultBgResource(R.drawable.img_default_100);
        forumRuleDetailBottomVH.f15495f.U(aVar.g(), 12, false);
        forumRuleDetailBottomVH.f15496g.setText(aVar.e());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailBottomVH.b(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.f15497h.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.h()));
            forumRuleDetailBottomVH.f15494e.setText(String.format(TbadkApplication.getInst().getString(R.string.forum_rules_revise_time), aVar.h()));
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void g0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.c(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public ForumRuleDetailBottomVH Q(ViewGroup viewGroup) {
        ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_bottom, viewGroup, false));
        g0(forumRuleDetailBottomVH);
        this.k = forumRuleDetailBottomVH;
        return forumRuleDetailBottomVH;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.o0.r0.q1.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        if (aVar != null) {
            e0(forumRuleDetailBottomVH, aVar);
        }
        return view;
    }

    public void setFrom(String str) {
        this.n = str;
    }
}
