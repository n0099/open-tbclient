package d.a.n0.r0.q1.a;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.a.c.j.e.a<d.a.n0.r0.q1.c.c, ForumRuleDetailItemVH> {
    public Context m;
    public TbRichText n;
    public List<n> o;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59404e;

        public a(int i2) {
            this.f59404e = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (c.this.o != null) {
                n nVar = (n) c.this.o.get(this.f59404e);
                if (nVar instanceof d.a.n0.r0.q1.c.c) {
                    TbRichText U = TbRichTextView.U(c.this.m, ((d.a.n0.r0.q1.c.c) nVar).e(), false);
                    ClipboardManager clipboardManager = (ClipboardManager) c.this.m.getSystemService("clipboard");
                    clipboardManager.setText(U.toString());
                    if (clipboardManager.getText() != null) {
                        l.L(c.this.m, R.string.forum_rules_copy_clip);
                    }
                }
            }
            return false;
        }
    }

    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.q1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        h0(i2, view, viewGroup, cVar, forumRuleDetailItemVH);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ForumRuleDetailItemVH P(ViewGroup viewGroup) {
        ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.m, LayoutInflater.from(this.m).inflate(R.layout.forum_rules_item, viewGroup, false));
        this.k = forumRuleDetailItemVH;
        return forumRuleDetailItemVH;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, d.a.n0.r0.q1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        boolean z;
        if (cVar != null && this.m != null) {
            forumRuleDetailItemVH.d(cVar.c());
            if (!StringUtils.isNull(cVar.f())) {
                z = true;
                forumRuleDetailItemVH.f15357c.setVisibility(0);
                forumRuleDetailItemVH.f15357c.setText(cVar.f());
            } else {
                forumRuleDetailItemVH.f15357c.setVisibility(8);
                z = false;
            }
            if (cVar.e() != null && !StringUtils.isNull(cVar.e().toString())) {
                forumRuleDetailItemVH.f15358d.setVisibility(0);
                if (!z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.f15358d.getLayoutParams();
                    layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                    forumRuleDetailItemVH.f15358d.setLayoutParams(layoutParams);
                }
                TbRichText U = TbRichTextView.U(this.m, cVar.e(), false);
                this.n = U;
                forumRuleDetailItemVH.f15358d.setText(U);
            } else {
                forumRuleDetailItemVH.f15358d.setVisibility(8);
            }
            forumRuleDetailItemVH.f15358d.setOnLongClickListener(new a(i2));
        }
        return view;
    }

    public void i0(List<n> list) {
        this.o = list;
    }
}
