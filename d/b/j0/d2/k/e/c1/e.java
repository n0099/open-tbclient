package d.b.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.b.i.a;
import d.b.i.f0;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v0;
/* loaded from: classes3.dex */
public class e extends d.b.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54488f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f54489g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f54490h;
    public a2 i;
    public d.b.i0.r.q.a j;

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
            return e.this.i;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC1070a interfaceC1070a = eVar.f54473c;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public View a() {
        if (this.f54488f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54471a.getPageActivity());
            this.f54488f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f54488f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f54488f, R.color.CAM_X0206);
            this.f54488f.setOrientation(1);
            this.f54488f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54488f.removeAllViews();
        if (this.f54489g == null) {
            f0 f0Var = new f0(this.f54471a);
            this.f54489g = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54488f.addView(this.f54489g.g(), layoutParams);
        if (this.f54490h == null) {
            this.f54490h = new ItemCardView(this.f54471a.getPageActivity());
        }
        this.f54490h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f54471a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54488f.addView(this.f54490h, layoutParams2);
        return this.f54488f;
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54475e != i) {
            this.f54475e = i;
            SkinManager.setBackgroundColor(this.f54488f, R.color.CAM_X0206);
            f0 f0Var = this.f54489g;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f54490h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54474d = originalThreadInfo;
        this.i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f54490h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        f0 f0Var = this.f54489g;
        if (f0Var != null) {
            f0Var.a(this.j);
        }
    }

    @Override // d.b.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1070a interfaceC1070a) {
        super.d(interfaceC1070a);
        f0 f0Var = this.f54489g;
        if (f0Var != null) {
            f0Var.w(interfaceC1070a);
        }
        LinearLayout linearLayout = this.f54488f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
