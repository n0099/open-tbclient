package d.a.k0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.g0;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
/* loaded from: classes5.dex */
public class e extends d.a.k0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52983f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f52984g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f52985h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f52986i;
    public d.a.j0.r.q.a j;

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
            return e.this.f52986i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC0547a interfaceC0547a = eVar.f52967c;
            if (interfaceC0547a != null) {
                interfaceC0547a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public View a() {
        if (this.f52983f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52965a.getPageActivity());
            this.f52983f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52983f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52983f, R.color.CAM_X0206);
            this.f52983f.setOrientation(1);
            this.f52983f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52983f.removeAllViews();
        if (this.f52984g == null) {
            g0 g0Var = new g0(this.f52965a);
            this.f52984g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52983f.addView(this.f52984g.g(), layoutParams);
        if (this.f52985h == null) {
            this.f52985h = new ItemCardView(this.f52965a.getPageActivity());
        }
        this.f52985h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f52965a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52983f.addView(this.f52985h, layoutParams2);
        return this.f52983f;
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52969e != i2) {
            this.f52969e = i2;
            SkinManager.setBackgroundColor(this.f52983f, R.color.CAM_X0206);
            g0 g0Var = this.f52984g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f52985h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52968d = originalThreadInfo;
        this.f52986i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f52985h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f52984g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.k0.d2.k.e.c1.a
    public void d(a.InterfaceC0547a interfaceC0547a) {
        super.d(interfaceC0547a);
        g0 g0Var = this.f52984g;
        if (g0Var != null) {
            g0Var.w(interfaceC0547a);
        }
        LinearLayout linearLayout = this.f52983f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
