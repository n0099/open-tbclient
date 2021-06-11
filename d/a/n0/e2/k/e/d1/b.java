package d.a.n0.e2.k.e.d1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.g0;
import d.a.i.o0;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class b extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56919f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.q.a f56920g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f56921h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f56922i;
    public a2 j;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // d.a.m0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 i() {
            return b.this.j;
        }
    }

    /* renamed from: d.a.n0.e2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1321b implements View.OnClickListener {
        public View$OnClickListenerC1321b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC0598a interfaceC0598a = bVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(bVar.f56920g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56919f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56914a.getPageActivity());
            this.f56919f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f56919f.setOrientation(1);
            this.f56919f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f56919f.removeAllViews();
        if (this.f56921h == null) {
            g0 g0Var = new g0(this.f56914a);
            this.f56921h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f56919f.addView(this.f56921h.g(), layoutParams);
        if (this.f56922i == null) {
            this.f56922i = new o0(this.f56914a.getPageActivity());
        }
        this.f56919f.addView(this.f56922i.g());
        return this.f56919f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56919f, R.color.CAM_X0206);
            g0 g0Var = this.f56921h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            o0 o0Var = this.f56922i;
            if (o0Var != null) {
                o0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f56920g = aVar;
        o0 o0Var = this.f56922i;
        if (o0Var != null) {
            o0Var.a(aVar);
        }
        g0 g0Var = this.f56921h;
        if (g0Var != null) {
            g0Var.a(this.f56920g);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        o0 o0Var = this.f56922i;
        if (o0Var != null) {
            o0Var.u(interfaceC0598a);
        }
        g0 g0Var = this.f56921h;
        if (g0Var != null) {
            g0Var.w(interfaceC0598a);
        }
        LinearLayout linearLayout = this.f56919f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1321b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o0 o0Var = this.f56922i;
        if (o0Var != null) {
            o0Var.l(this.f56915b);
        }
    }
}
