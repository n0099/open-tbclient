package d.a.k0.d2.k.e.c1;

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
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public class b extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52970f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.q.a f52971g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f52972h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f52973i;
    public a2 j;

    /* loaded from: classes5.dex */
    public class a extends d.a.j0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.j0.r.q.a
        public a2 m() {
            return b.this.j;
        }
    }

    /* renamed from: d.a.k0.d2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1246b implements View.OnClickListener {
        public View$OnClickListenerC1246b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC0547a interfaceC0547a = bVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(bVar.f52971g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f52970f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52965a.getPageActivity());
            this.f52970f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52970f.setOrientation(1);
            this.f52970f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52970f.removeAllViews();
        if (this.f52972h == null) {
            g0 g0Var = new g0(this.f52965a);
            this.f52972h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52970f.addView(this.f52972h.g(), layoutParams);
        if (this.f52973i == null) {
            this.f52973i = new o0(this.f52965a.getPageActivity());
        }
        this.f52970f.addView(this.f52973i.g());
        return this.f52970f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f52970f, R.color.CAM_X0206);
            g0 g0Var = this.f52972h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            o0 o0Var = this.f52973i;
            if (o0Var != null) {
                o0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52971g = aVar;
        o0 o0Var = this.f52973i;
        if (o0Var != null) {
            o0Var.a(aVar);
        }
        g0 g0Var = this.f52972h;
        if (g0Var != null) {
            g0Var.a(this.f52971g);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        o0 o0Var = this.f52973i;
        if (o0Var != null) {
            o0Var.u(interfaceC0547a);
        }
        g0 g0Var = this.f52972h;
        if (g0Var != null) {
            g0Var.w(interfaceC0547a);
        }
        LinearLayout linearLayout = this.f52970f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1246b());
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o0 o0Var = this.f52973i;
        if (o0Var != null) {
            o0Var.l(this.f52966b);
        }
    }
}
