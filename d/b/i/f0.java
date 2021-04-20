package d.b.i;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.card.view.RichTextLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.i.a;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class f0 extends h {
    public RichTextLayout l;
    public d.b.h0.r.q.a m;
    public int n;
    public String o;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f0 f0Var = f0.this;
            a.InterfaceC1129a interfaceC1129a = f0Var.i;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(f0Var.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1131a c1131a) {
            if (f0.this.m != null && f0.this.m.n() != null && !f0.this.f().booleanValue()) {
                a2 n = f0.this.m.n();
                d.b.i0.x.m.a(n.o0());
                d.b.i0.x.m.l(f0.this.l.f4546f, n.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                d.b.i0.x.m.l(f0.this.l.f4547g, n.o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            }
            return false;
        }
    }

    public f0(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.n = 3;
        this.l = new RichTextLayout(tbPageContext.getPageActivity());
        this.l.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, new b());
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.n != i && f().booleanValue()) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        }
        this.n = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: u */
    public void a(d.b.h0.r.q.a aVar) {
        this.m = aVar;
        this.l.setTransmit(f().booleanValue());
        this.l.a(aVar);
        this.l.setJumpToPbListener(new a());
        this.l.setFrom(this.o);
    }

    public void v(String str) {
        this.o = str;
    }

    public void w(a.InterfaceC1129a interfaceC1129a) {
        this.i = interfaceC1129a;
    }

    public void x(boolean z) {
        this.l.setNeedFrsTabName(z);
    }

    public void y(int i, int i2, int i3, int i4) {
        this.l.setPadding(i, i2, i3, i4);
    }
}
