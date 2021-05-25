package d.a.i;

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
import d.a.m0.r.q.a2;
/* loaded from: classes.dex */
public class r extends t0 {
    public static final int F = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public InterviewLiveLayout C;
    public int D;
    public TextView E;

    public r(Context context) {
        super(context);
        this.D = 3;
        A();
    }

    public final void A() {
        View inflate = LayoutInflater.from(this.f40008f).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
        this.j = inflate;
        this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
        this.E = (TextView) this.j.findViewById(R.id.video_seg_abstract);
        this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
        this.C = (InterviewLiveLayout) this.j.findViewById(R.id.frame_interview_no_video);
        d.a.n0.k2.q.a q = q();
        this.n = q;
        q.E().setBackgroundResource(R.color.transparent);
    }

    public void B(boolean z) {
        this.C.setFromCDN(z);
    }

    @Override // d.a.i.t0, d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void l(d.a.n0.z.b0<d.a.m0.r.q.a> b0Var) {
        this.C.setSubClickListener(b0Var);
    }

    @Override // d.a.i.t0, d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.D != i2) {
            SkinManager.setBackgroundResource(this.C, R.drawable.addresslist_item_bg);
            this.C.l(this.D);
        }
        this.D = i2;
    }

    @Override // d.a.i.t0
    public d.a.n0.k2.q.a q() {
        d.a.n0.k2.q.b bVar = new d.a.n0.k2.q.b(this.f40008f, this.m);
        bVar.setStageType("2003");
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.t0, d.a.i.p
    /* renamed from: r */
    public void a(d.a.m0.r.q.a aVar) {
        this.l = aVar;
        if (aVar == null || aVar.m() == null) {
            return;
        }
        a2 m = aVar.m();
        if (m.w1() != null) {
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
        ThreadCardUtils.setTitle(this.k, m);
        ThreadCardUtils.setAbstract(this.E, this.k, m, F);
    }
}
