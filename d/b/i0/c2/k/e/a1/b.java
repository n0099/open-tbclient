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
/* loaded from: classes4.dex */
public class b extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52569f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.q.a f52570g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52571h;
    public n0 i;
    public a2 j;

    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1148b implements View.OnClickListener {
        public View$OnClickListenerC1148b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC1115a interfaceC1115a = bVar.f52566c;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(bVar.f52570g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52569f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52564a.getPageActivity());
            this.f52569f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52569f.setOrientation(1);
            this.f52569f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52569f.removeAllViews();
        if (this.f52571h == null) {
            f0 f0Var = new f0(this.f52564a);
            this.f52571h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52569f.addView(this.f52571h.g(), layoutParams);
        if (this.i == null) {
            this.i = new n0(this.f52564a.getPageActivity());
        }
        this.f52569f.addView(this.i.g());
        return this.f52569f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.f52569f, R.color.CAM_X0206);
            f0 f0Var = this.f52571h;
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
        this.f52567d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52570g = aVar;
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.a(aVar);
        }
        f0 f0Var = this.f52571h;
        if (f0Var != null) {
            f0Var.a(this.f52570g);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.u(interfaceC1115a);
        }
        f0 f0Var = this.f52571h;
        if (f0Var != null) {
            f0Var.w(interfaceC1115a);
        }
        LinearLayout linearLayout = this.f52569f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1148b());
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.l(this.f52565b);
        }
    }
}
