package d.b.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class p0 extends d.b.i.a<d.b.h0.r.q.a> {
    public static final int q = d.b.b.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public View j;
    public TextView k;
    public TextView l;
    public OriginalThreadCardView m;
    public d.b.h0.r.q.a n;
    public boolean o;
    public OriginalThreadCardView.b p;

    /* loaded from: classes.dex */
    public class a implements OriginalThreadCardView.b {
        public a() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            if (p0.this.n == null || p0.this.n.n() == null) {
                return;
            }
            if (p0.this.d() != null) {
                p0.this.d().a(p0.this.m, p0.this.n);
            }
            String o0 = p0.this.n.n().o0();
            d.b.i0.x.m.a(o0);
            p0.this.s(o0);
            p0.this.f51762e.o(new a.C1118a(1));
        }
    }

    public p0(Context context) {
        super(context);
        this.o = false;
        this.p = new a();
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        this.j = inflate;
        this.k = (TextView) inflate.findViewById(R.id.thread_card_title);
        this.l = (TextView) this.j.findViewById(R.id.thread_card_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.j.findViewById(R.id.original_thread_view);
        this.m = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.p);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        super.l(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.m.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: r */
    public void a(d.b.h0.r.q.a aVar) {
        if (aVar == null || aVar.n() == null) {
            return;
        }
        this.n = aVar;
        ThreadCardUtils.setTitle(this.k, aVar.n(), this.o);
        ThreadCardUtils.setAbstract(this.l, this.k, aVar.n(), q, this.o);
        this.m.f(aVar.n().r1);
    }

    public final void s(String str) {
        d.b.i0.x.m.l(this.k, str, R.color.CAM_X0105, R.color.CAM_X0109);
        d.b.i0.x.m.l(this.l, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.setReadState(d.b.i0.x.m.k(str));
    }

    public void t(boolean z) {
        this.o = z;
    }

    public void u(int i) {
        this.m.q = i;
    }
}
