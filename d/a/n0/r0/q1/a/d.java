package d.a.n0.r0.q1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailSelfVH;
import com.baidu.tieba.view.BdTopToast;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes4.dex */
public class d extends d.a.c.j.e.a<d.a.n0.r0.q1.c.b, ForumRuleDetailSelfVH> {
    public ForumRulesShowActivity m;
    public String n;
    public boolean o;
    public int p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r0.q1.c.b f59406e;

        public a(d.a.n0.r0.q1.c.b bVar) {
            this.f59406e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o) {
                d.this.n0();
            } else {
                d.this.p0(this.f59406e);
            }
        }
    }

    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        this.o = false;
        this.p = 0;
        this.m = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.q1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        m0(i2, view, viewGroup, bVar, forumRuleDetailSelfVH);
        return view;
    }

    public final void h0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, d.a.n0.r0.q1.c.b bVar) {
        if (bVar.f() != null) {
            forumRuleDetailSelfVH.f15361b.setDefaultResource(R.drawable.img_default_100);
            forumRuleDetailSelfVH.f15361b.V(bVar.f().portrait, 12, false);
            forumRuleDetailSelfVH.f15362c.setText(bVar.f().name_show);
            forumRuleDetailSelfVH.c(bVar.f().user_level.intValue());
            forumRuleDetailSelfVH.f15364e.setVisibility(0);
        }
        forumRuleDetailSelfVH.f15363d.setText(R.string.bawu_member_bazhu_tip);
        forumRuleDetailSelfVH.f15363d.setVisibility(0);
        forumRuleDetailSelfVH.h("manager");
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailSelfVH.g(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailSelfVH.f15366g.setText(bVar.m());
        }
        i0(forumRuleDetailSelfVH, bVar);
        forumRuleDetailSelfVH.d(bVar.l());
    }

    public final void i0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, d.a.n0.r0.q1.c.b bVar) {
        if (bVar.k()) {
            forumRuleDetailSelfVH.f15367h.setOnClickListener(new a(bVar));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.f15367h.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.m()) && bVar.e() == 0) {
                long a2 = d.a.n0.r0.q1.e.a.a(bVar.m());
                int b2 = d.a.n0.r0.q1.e.a.b(Long.valueOf(StringUtils.isNull(bVar.h()) ? "0" : bVar.h()).longValue() - a2);
                if (b2 < 0) {
                    b2 = d.a.n0.r0.q1.e.a.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.f15367h.setVisibility(0);
                if (b2 >= 7) {
                    this.o = false;
                    return;
                }
                forumRuleDetailSelfVH.f15367h.setUseDisableState(true);
                this.o = true;
                this.p = 7 - b2;
            } else {
                forumRuleDetailSelfVH.f(bVar.e());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: j0 */
    public ForumRuleDetailSelfVH P(ViewGroup viewGroup) {
        ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_user_area, viewGroup, false));
        this.k = forumRuleDetailSelfVH;
        return forumRuleDetailSelfVH;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.q1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        if (bVar == null) {
            return view;
        }
        h0(forumRuleDetailSelfVH, bVar);
        return view;
    }

    public final void n0() {
        ForumRulesShowActivity forumRulesShowActivity = this.m;
        if (forumRulesShowActivity == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.forum_rules_later_days_edit);
        String format = String.format(string, this.p + "");
        if (this.m.getView() != null) {
            BdTopToast bdTopToast = new BdTopToast(this.m);
            bdTopToast.i(false);
            bdTopToast.h(format);
            bdTopToast.j(this.m.getView().l());
        }
    }

    public final void p0(d.a.n0.r0.q1.c.b bVar) {
        if (this.m == null || bVar == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(bVar.p());
        forumRuleBaseData.setPreface(bVar.l());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bVar.o().size(); i2++) {
            ForumRule forumRule = bVar.o().get(i2);
            ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
            forumRuleItemPbData.status = forumRule.status + "";
            forumRuleItemPbData.title = forumRule.title + "";
            forumRuleItemPbData.mContent = new ArrayList();
            List<PbContent> list = forumRule.content;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < forumRule.content.size(); i3++) {
                    PbContent pbContent = forumRule.content.get(i3);
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                    forumRuleItemPbContentData.href = pbContent.link;
                    if (pbContent.type.intValue() == 0) {
                        forumRuleItemPbContentData.tag = "plainText";
                    } else if (pbContent.type.intValue() == 1) {
                        forumRuleItemPbContentData.tag = "a";
                    } else if (pbContent.type.intValue() == 2) {
                        forumRuleItemPbContentData.tag = "br";
                    }
                    forumRuleItemPbContentData.value = pbContent.text;
                    forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                }
            }
            arrayList.add(forumRuleItemPbData);
        }
        forumRuleBaseData.setPbDataList(arrayList);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.m, bVar.i().forum_id + "", bVar.i().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.i().avatar, bVar.f().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        this.n = str;
    }
}
