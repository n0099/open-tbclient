package d.b.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.f0;
import d.b.i.n0;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public class b extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54476f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.q.a f54477g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f54478h;
    public n0 i;
    public a2 j;

    /* loaded from: classes3.dex */
    public class a extends d.b.i0.r.q.a {
        public a() {
        }

        @Override // d.b.i0.r.q.a
        public v0 g() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.b.i0.r.q.a
        public a2 n() {
            return b.this.j;
        }
    }

    /* renamed from: d.b.j0.d2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1235b implements View.OnClickListener {
        public View$OnClickListenerC1235b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC1070a interfaceC1070a = bVar.f54473c;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(bVar.f54477g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54476f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54471a.getPageActivity());
            this.f54476f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f54476f.setOrientation(1);
            this.f54476f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54476f.removeAllViews();
        if (this.f54478h == null) {
            f0 f0Var = new f0(this.f54471a);
            this.f54478h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54476f.addView(this.f54478h.g(), layoutParams);
        if (this.i == null) {
            this.i = new n0(this.f54471a.getPageActivity());
        }
        this.f54476f.addView(this.i.g());
        return this.f54476f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.f54476f, R.color.CAM_X0206);
            f0 f0Var = this.f54478h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            n0 n0Var = this.i;
            if (n0Var != null) {
                n0Var.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f54477g = aVar;
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.a(aVar);
        }
        f0 f0Var = this.f54478h;
        if (f0Var != null) {
            f0Var.a(this.f54477g);
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.u(interfaceC1070a);
        }
        f0 f0Var = this.f54478h;
        if (f0Var != null) {
            f0Var.w(interfaceC1070a);
        }
        LinearLayout linearLayout = this.f54476f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1235b());
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        n0 n0Var = this.i;
        if (n0Var != null) {
            n0Var.l(this.f54472b);
        }
    }
}
