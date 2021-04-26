package d.a.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.f0;
import d.a.i.n0;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public class b extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52271f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.q.a f52272g;

    /* renamed from: h  reason: collision with root package name */
    public f0 f52273h;

    /* renamed from: i  reason: collision with root package name */
    public n0 f52274i;
    public a2 j;

    /* loaded from: classes3.dex */
    public class a extends d.a.i0.r.q.a {
        public a() {
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public v0 h() {
            return null;
        }

        @Override // d.a.i0.r.q.a
        public a2 m() {
            return b.this.j;
        }
    }

    /* renamed from: d.a.j0.d2.k.e.c1.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1174b implements View.OnClickListener {
        public View$OnClickListenerC1174b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            a.InterfaceC1009a interfaceC1009a = bVar.f52268c;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(bVar.f52272g);
            }
        }
    }

    public b(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52271f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52266a.getPageActivity());
            this.f52271f = linearLayout;
            SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
            this.f52271f.setOrientation(1);
            this.f52271f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52271f.removeAllViews();
        if (this.f52273h == null) {
            f0 f0Var = new f0(this.f52266a);
            this.f52273h = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52271f.addView(this.f52273h.g(), layoutParams);
        if (this.f52274i == null) {
            this.f52274i = new n0(this.f52266a.getPageActivity());
        }
        this.f52271f.addView(this.f52274i.g());
        return this.f52271f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52271f, R.color.CAM_X0206);
            f0 f0Var = this.f52273h;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i2);
            }
            n0 n0Var = this.f52274i;
            if (n0Var != null) {
                n0Var.onChangeSkinType(tbPageContext, i2);
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        this.j = originalThreadInfo == null ? null : originalThreadInfo.a();
        a aVar = new a();
        this.f52272g = aVar;
        n0 n0Var = this.f52274i;
        if (n0Var != null) {
            n0Var.a(aVar);
        }
        f0 f0Var = this.f52273h;
        if (f0Var != null) {
            f0Var.a(this.f52272g);
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
        n0 n0Var = this.f52274i;
        if (n0Var != null) {
            n0Var.u(interfaceC1009a);
        }
        f0 f0Var = this.f52273h;
        if (f0Var != null) {
            f0Var.w(interfaceC1009a);
        }
        LinearLayout linearLayout = this.f52271f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View$OnClickListenerC1174b());
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void e(b0 b0Var) {
        super.e(b0Var);
        n0 n0Var = this.f52274i;
        if (n0Var != null) {
            n0Var.l(this.f52267b);
        }
    }
}
