package d.a.i;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.v0.a;
import d.a.j0.r.q.a2;
/* loaded from: classes.dex */
public class g0 extends h {
    public RichTextLayout l;
    public d.a.j0.r.q.a m;
    public int n;
    public String o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g0 g0Var = g0.this;
            a.InterfaceC0547a interfaceC0547a = g0Var.f40319i;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(g0Var.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0549a c0549a) {
            if (g0.this.m != null && g0.this.m.m() != null && !g0.this.f().booleanValue()) {
                a2 m = g0.this.m.m();
                d.a.k0.x.m.a(m.o0());
                d.a.k0.x.m.l(g0.this.l.f4498f, m.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.a.k0.x.m.l(g0.this.l.f4499g, m.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public g0(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.n = 3;
        this.l = new RichTextLayout(tbPageContext.getPageActivity());
        this.l.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new b());
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.n != i2 && f().booleanValue()) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        }
        this.n = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: u */
    public void a(d.a.j0.r.q.a aVar) {
        this.m = aVar;
        this.l.setTransmit(f().booleanValue());
        this.l.a(aVar);
        this.l.setJumpToPbListener(new a());
        this.l.setFrom(this.o);
    }

    public void v(String str) {
        this.o = str;
    }

    public void w(a.InterfaceC0547a interfaceC0547a) {
        this.f40319i = interfaceC0547a;
    }

    public void x(boolean z) {
        this.l.setNeedFrsTabName(z);
    }

    public void y(int i2, int i3, int i4, int i5) {
        this.l.setPadding(i2, i3, i4, i5);
    }
}
