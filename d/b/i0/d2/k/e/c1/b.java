package d.b.i0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.n0;
import d.b.i0.x.b0;
/* loaded from: classes3.dex */
public class b extends d.b.i0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54055f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f54056g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f54057h;
    public n0 i;
    public a2 j;

    /* loaded from: classes3.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return b.this.j;
        }
    }

    /* renamed from: d.b.i0.d2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1212b implements View.OnClickListener {
        public View$OnClickListenerC1212b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC1129a interfaceC1129a = bVar.f54052c;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(bVar.f54056g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public View a() {
        if (this.f54055f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54050a.getPageActivity());
            this.f54055f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f54055f.setOrientation(1);
            this.f54055f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54055f.removeAllViews();
        if (this.f54057h == null) {
            f0 f0Var = new f0(this.f54050a);
            this.f54057h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54055f.addView(this.f54057h.g(), layoutParams);
        if (this.i == null) {
            this.i = new n0(this.f54050a.getPageActivity());
        }
        this.f54055f.addView(this.i.g());
        return this.f54055f;
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54054e != i) {
            this.f54054e = i;
            SkinManager.setBackgroundColor(this.f54055f, R.color.CAM_X0206);
            f0 f0Var = this.f54057h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            n0 n0Var = this.i;
            if (n0Var != null) {
                n0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54053d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f54056g = aVar;
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.a(aVar);
        }
        f0 f0Var = this.f54057h;
        if (f0Var != null) {
            f0Var.a(this.f54056g);
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void d(a.InterfaceC1129a interfaceC1129a) {
        super.d(interfaceC1129a);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.u(interfaceC1129a);
        }
        f0 f0Var = this.f54057h;
        if (f0Var != null) {
            f0Var.w(interfaceC1129a);
        }
        LinearLayout linearLayout = this.f54055f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1212b());
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.l(this.f54051b);
        }
    }
}
