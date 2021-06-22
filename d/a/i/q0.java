package d.a.i;

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
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class q0 extends d.a.i.a<d.a.n0.r.q.a> {
    public static final int q = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - ((d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public View j;
    public TextView k;
    public TextView l;
    public OriginalThreadCardView m;
    public d.a.n0.r.q.a n;
    public boolean o;
    public OriginalThreadCardView.b p;

    /* loaded from: classes.dex */
    public class a implements OriginalThreadCardView.b {
        public a() {
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            if (q0.this.n == null || q0.this.n.i() == null) {
                return;
            }
            if (q0.this.d() != null) {
                q0.this.d().a(q0.this.m, q0.this.n);
            }
            String o0 = q0.this.n.i().o0();
            d.a.o0.z.m.a(o0);
            q0.this.s(o0);
            q0.this.f43781e.o(new a.C0602a(1));
        }
    }

    public q0(Context context) {
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

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.a
    public void l(d.a.o0.z.b0<d.a.n0.r.q.a> b0Var) {
        super.l(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.m.n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: r */
    public void a(d.a.n0.r.q.a aVar) {
        if (aVar == null || aVar.i() == null) {
            return;
        }
        this.n = aVar;
        ThreadCardUtils.setTitle(this.k, aVar.i(), this.o);
        ThreadCardUtils.setAbstract(this.l, this.k, aVar.i(), q, this.o);
        this.m.f(aVar.i().t1);
    }

    public final void s(String str) {
        d.a.o0.z.m.l(this.k, str, R.color.CAM_X0105, R.color.CAM_X0109);
        d.a.o0.z.m.l(this.l, str, R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.setReadState(d.a.o0.z.m.k(str));
    }

    public void t(boolean z) {
        this.o = z;
    }

    public void u(int i2) {
        this.m.q = i2;
    }
}
