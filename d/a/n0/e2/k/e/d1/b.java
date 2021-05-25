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
    public LinearLayout f53230f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.q.a f53231g;

    /* renamed from: h  reason: collision with root package name */
    public g0 f53232h;

    /* renamed from: i  reason: collision with root package name */
    public o0 f53233i;
    public a2 j;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 m() {
            return b.this.j;
        }
    }

    /* renamed from: d.a.n0.e2.k.e.d1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1265b implements View.OnClickListener {
        public View$OnClickListenerC1265b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC0542a interfaceC0542a = bVar.f53227c;
            if (interfaceC0542a != null) {
                interfaceC0542a.a(bVar.f53231g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53230f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f53225a.getPageActivity());
            this.f53230f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f53230f.setOrientation(1);
            this.f53230f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f53230f.removeAllViews();
        if (this.f53232h == null) {
            g0 g0Var = new g0(this.f53225a);
            this.f53232h = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f53230f.addView(this.f53232h.g(), layoutParams);
        if (this.f53233i == null) {
            this.f53233i = new o0(this.f53225a.getPageActivity());
        }
        this.f53230f.addView(this.f53233i.g());
        return this.f53230f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53230f, R.color.CAM_X0206);
            g0 g0Var = this.f53232h;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            o0 o0Var = this.f53233i;
            if (o0Var != null) {
                o0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53228d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f53231g = aVar;
        o0 o0Var = this.f53233i;
        if (o0Var != null) {
            o0Var.a(aVar);
        }
        g0 g0Var = this.f53232h;
        if (g0Var != null) {
            g0Var.a(this.f53231g);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
        o0 o0Var = this.f53233i;
        if (o0Var != null) {
            o0Var.u(interfaceC0542a);
        }
        g0 g0Var = this.f53232h;
        if (g0Var != null) {
            g0Var.w(interfaceC0542a);
        }
        LinearLayout linearLayout = this.f53230f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1265b());
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        o0 o0Var = this.f53233i;
        if (o0Var != null) {
            o0Var.l(this.f53226b);
        }
    }
}
