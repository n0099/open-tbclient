package d.a.j0.i0.l.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.c.j.e.w;
import d.a.i.d;
import d.a.i.k0;
import d.a.i.u0.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.i0.r.q.z1;
import d.a.j0.x.b0;
import d.a.j0.x.t;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class k extends d.a.c.j.e.a<z1, ThreadCardViewHolder<a2>> {
    public BdUniqueId m;
    public String n;
    public TbPageContext<?> o;
    public s p;
    public b0<a2> q;
    public NEGFeedBackView.b r;

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            t.b().d(true);
            d.a.j0.i0.a.a(view, a2Var, k.this.n);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public b(k kVar) {
        }

        @Override // d.a.i.d.b
        public void a(d.a.i0.r.q.a aVar, View view) {
            if (aVar != null) {
                if (view.getId() == R.id.user_name) {
                    aVar.objType = 3;
                } else if (view.getId() == R.id.user_avatar) {
                    aVar.objType = 4;
                } else {
                    aVar.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if ((nVar instanceof z1) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = ((z1) nVar).w;
                a2Var.objType = 1;
                if (k.this.q != null) {
                    k.this.q.a(threadCardViewHolder.a(), a2Var);
                }
                ThreadCardUtils.jumpToPB((d.a.i0.r.q.a) a2Var, view.getContext(), 2, false, d.a.i.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.b().o(new a.C1011a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NEGFeedBackView.b {
        public d() {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(v0 v0Var, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(v0 v0Var) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadNEGFeedbackStatisticLog(v0Var, k.this.n));
        }
    }

    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.q = new a();
        this.r = new d();
        this.o = tbPageContext;
        this.m = bdUniqueId2;
        this.n = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public ThreadCardViewHolder P(ViewGroup viewGroup) {
        k0.b bVar = new k0.b(this.o.getPageActivity());
        d.a.i.d dVar = new d.a.i.d(this.o.getPageActivity());
        dVar.t(this.m);
        dVar.c(1024);
        dVar.s(new b(this));
        dVar.v(this.o);
        bVar.o(dVar);
        k0 k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.p);
        k.r(2);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
        threadCardViewHolder.j(this.m);
        Z(new c());
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        a2 a2Var;
        if (z1Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null || (a2Var = z1Var.w) == null) {
            return null;
        }
        a2Var.M1 = B(i2) + 1;
        threadCardViewHolder.b().q(i2);
        threadCardViewHolder.p(true, Align.ALIGN_RIGHT_TOP, this.r);
        threadCardViewHolder.f(z1Var.w);
        threadCardViewHolder.b().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.b().p(this.q);
        return threadCardViewHolder.a();
    }

    public void i0(s sVar) {
        this.p = sVar;
    }
}
