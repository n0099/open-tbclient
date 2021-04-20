package d.b.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes.dex */
public class r extends s0 {
    public static final int F = d.b.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public InterviewLiveLayout C;
    public int D;
    public TextView E;

    public r(Context context) {
        super(context);
        this.D = 3;
        A();
    }

    public final void A() {
        View inflate = LayoutInflater.from(this.f52187f).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.j = inflate;
        this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
        this.E = (TextView) this.j.findViewById(R.id.video_seg_abstract);
        this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
        this.C = (InterviewLiveLayout) this.j.findViewById(R.id.frame_interview_no_video);
        d.b.i0.j2.q.a q = q();
        this.n = q;
        q.C().setBackgroundResource(R.color.transparent);
    }

    public void B(boolean z) {
        this.C.setFromCDN(z);
    }

    @Override // d.b.i.s0, d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        this.C.setSubClickListener(b0Var);
    }

    @Override // d.b.i.s0, d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.D != i) {
            SkinManager.setBackgroundResource(this.C, R.drawable.addresslist_item_bg);
            this.C.l(this.D);
        }
        this.D = i;
    }

    @Override // d.b.i.s0
    public d.b.i0.j2.q.a q() {
        d.b.i0.j2.q.b bVar = new d.b.i0.j2.q.b(this.f52187f, this.m);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.s0, d.b.i.p
    /* renamed from: r */
    public void a(d.b.h0.r.q.a aVar) {
        this.l = aVar;
        if (aVar == null || aVar.n() == null) {
            return;
        }
        a2 n = aVar.n();
        if (n.u1() != null) {
            this.C.setVisibility(8);
            this.m.setVisibility(0);
            this.E.setVisibility(8);
            super.a(aVar);
            return;
        }
        this.m.setVisibility(8);
        this.C.setVisibility(0);
        this.E.setVisibility(0);
        this.C.a(aVar);
        ThreadCardUtils.setTitle(this.k, n);
        ThreadCardUtils.setAbstract(this.E, this.k, n, F);
    }
}
