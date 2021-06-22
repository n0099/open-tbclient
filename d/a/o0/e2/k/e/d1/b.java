package d.a.o0.e2.k.e.d1;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.q.v0;
import d.a.o0.z.b0;
/* loaded from: classes5.dex */
public class b extends d.a.o0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f57044f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.q.a f57045g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f57046h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f57047i;
    public a2 j;

    /* loaded from: classes5.dex */
    public class a extends d.a.n0.r.q.a {
        public a() {
        }

        @Override // d.a.n0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.n0.r.q.a
        public a2 i() {
            return b.this.j;
        }
    }

    /* renamed from: d.a.o0.e2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1325b implements View.OnClickListener {
        public View$OnClickListenerC1325b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC0600a interfaceC0600a = bVar.f57041c;
            if (interfaceC0600a != null) {
                interfaceC0600a.a(bVar.f57045g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public View a() {
        if (this.f57044f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f57039a.getPageActivity());
            this.f57044f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f57044f.setOrientation(1);
            this.f57044f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f57044f.removeAllViews();
        if (this.f57046h == null) {
            g0 g0Var = new g0(this.f57039a);
            this.f57046h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f57039a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f57044f.addView(this.f57046h.g(), layoutParams);
        if (this.f57047i == null) {
            this.f57047i = new o0(this.f57039a.getPageActivity());
        }
        this.f57044f.addView(this.f57047i.g());
        return this.f57044f;
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f57043e != i2) {
            this.f57043e = i2;
            SkinManager.setBackgroundColor(this.f57044f, R.color.CAM_X0206);
            g0 g0Var = this.f57046h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            o0 o0Var = this.f57047i;
            if (o0Var != null) {
                o0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f57042d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f57045g = aVar;
        o0 o0Var = this.f57047i;
        if (o0Var != null) {
            o0Var.a(aVar);
        }
        g0 g0Var = this.f57046h;
        if (g0Var != null) {
            g0Var.a(this.f57045g);
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void d(a.InterfaceC0600a interfaceC0600a) {
        super.d(interfaceC0600a);
        o0 o0Var = this.f57047i;
        if (o0Var != null) {
            o0Var.u(interfaceC0600a);
        }
        g0 g0Var = this.f57046h;
        if (g0Var != null) {
            g0Var.w(interfaceC0600a);
        }
        LinearLayout linearLayout = this.f57044f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1325b());
        }
    }

    @Override // d.a.o0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o0 o0Var = this.f57047i;
        if (o0Var != null) {
            o0Var.l(this.f57040b);
        }
    }
}
