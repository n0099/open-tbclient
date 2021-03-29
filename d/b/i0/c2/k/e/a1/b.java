package d.b.i0.c2.k.e.a1;

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
/* loaded from: classes5.dex */
public class b extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52570f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52571g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52572h;
    public n0 i;
    public a2 j;

    /* loaded from: classes5.dex */
    public class a extends d.b.h0.r.q.a {
        public a() {
        }

        @Override // d.b.h0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.h0.r.q.a
        public a2 n() {
            return b.this.j;
        }
    }

    /* renamed from: d.b.i0.c2.k.e.a1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1149b implements View.OnClickListener {
        public View$OnClickListenerC1149b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC1116a interfaceC1116a = bVar.f52567c;
            if (interfaceC1116a != null) {
                interfaceC1116a.a(bVar.f52571g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52570f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52565a.getPageActivity());
            this.f52570f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52570f.setOrientation(1);
            this.f52570f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52570f.removeAllViews();
        if (this.f52572h == null) {
            f0 f0Var = new f0(this.f52565a);
            this.f52572h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52565a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52570f.addView(this.f52572h.g(), layoutParams);
        if (this.i == null) {
            this.i = new n0(this.f52565a.getPageActivity());
        }
        this.f52570f.addView(this.i.g());
        return this.f52570f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52569e != i) {
            this.f52569e = i;
            SkinManager.setBackgroundColor(this.f52570f, R.color.CAM_X0206);
            f0 f0Var = this.f52572h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            n0 n0Var = this.i;
            if (n0Var != null) {
                n0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52568d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52571g = aVar;
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.a(aVar);
        }
        f0 f0Var = this.f52572h;
        if (f0Var != null) {
            f0Var.a(this.f52571g);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1116a interfaceC1116a) {
        super.d(interfaceC1116a);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.u(interfaceC1116a);
        }
        f0 f0Var = this.f52572h;
        if (f0Var != null) {
            f0Var.w(interfaceC1116a);
        }
        LinearLayout linearLayout = this.f52570f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1149b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.l(this.f52566b);
        }
    }
}
