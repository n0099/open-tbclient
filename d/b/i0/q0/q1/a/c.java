package d.b.i0.q0.q1.a;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.b.c.j.e.a<d.b.i0.q0.q1.c.c, ForumRuleDetailItemVH> {
    public Context m;
    public TbRichText n;
    public List<n> o;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f60007e;

        public a(int i) {
            this.f60007e = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (c.this.o != null) {
                n nVar = (n) c.this.o.get(this.f60007e);
                if (nVar instanceof d.b.i0.q0.q1.c.c) {
                    TbRichText U = TbRichTextView.U(c.this.m, ((d.b.i0.q0.q1.c.c) nVar).e(), false);
                    ClipboardManager clipboardManager = (ClipboardManager) c.this.m.getSystemService("clipboard");
                    clipboardManager.setText(U.toString());
                    if (clipboardManager.getText() != null) {
                        l.K(c.this.m, R.string.forum_rules_copy_clip);
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
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, d.b.i0.q0.q1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        l0(i, view, viewGroup, cVar, forumRuleDetailItemVH);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public ForumRuleDetailItemVH R(ViewGroup viewGroup) {
        ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.m, LayoutInflater.from(this.m).inflate(R.layout.forum_rules_item, viewGroup, false));
        this.k = forumRuleDetailItemVH;
        return forumRuleDetailItemVH;
    }

    public View l0(int i, View view, ViewGroup viewGroup, d.b.i0.q0.q1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        boolean z;
        if (cVar != null && this.m != null) {
            forumRuleDetailItemVH.d(cVar.a());
            if (!StringUtils.isNull(cVar.f())) {
                z = true;
                forumRuleDetailItemVH.f15938c.setVisibility(0);
                forumRuleDetailItemVH.f15938c.setText(cVar.f());
            } else {
                forumRuleDetailItemVH.f15938c.setVisibility(8);
                z = false;
            }
            if (cVar.e() != null && !StringUtils.isNull(cVar.e().toString())) {
                forumRuleDetailItemVH.f15939d.setVisibility(0);
                if (!z) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.f15939d.getLayoutParams();
                    layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                    forumRuleDetailItemVH.f15939d.setLayoutParams(layoutParams);
                }
                TbRichText U = TbRichTextView.U(this.m, cVar.e(), false);
                this.n = U;
                forumRuleDetailItemVH.f15939d.setText(U);
            } else {
                forumRuleDetailItemVH.f15939d.setVisibility(8);
            }
            forumRuleDetailItemVH.f15939d.setOnLongClickListener(new a(i));
        }
        return view;
    }

    public void m0(List<n> list) {
        this.o = list;
    }
}
