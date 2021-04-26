package d.a.j0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.f0;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
/* loaded from: classes3.dex */
public class e extends d.a.j0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52284f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f52285g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f52286h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f52287i;
    public d.a.i0.r.q.a j;

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
            return e.this.f52287i;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC1009a interfaceC1009a = eVar.f52268c;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public View a() {
        if (this.f52284f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52266a.getPageActivity());
            this.f52284f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52284f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52284f, R.color.CAM_X0206);
            this.f52284f.setOrientation(1);
            this.f52284f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52284f.removeAllViews();
        if (this.f52285g == null) {
            f0 f0Var = new f0(this.f52266a);
            this.f52285g = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52284f.addView(this.f52285g.g(), layoutParams);
        if (this.f52286h == null) {
            this.f52286h = new ItemCardView(this.f52266a.getPageActivity());
        }
        this.f52286h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f52266a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52284f.addView(this.f52286h, layoutParams2);
        return this.f52284f;
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f52270e != i2) {
            this.f52270e = i2;
            SkinManager.setBackgroundColor(this.f52284f, R.color.CAM_X0206);
            f0 f0Var = this.f52285g;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f52286h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52269d = originalThreadInfo;
        this.f52287i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f52286h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        f0 f0Var = this.f52285g;
        if (f0Var != null) {
            f0Var.a(this.j);
        }
    }

    @Override // d.a.j0.d2.k.e.c1.a
    public void d(a.InterfaceC1009a interfaceC1009a) {
        super.d(interfaceC1009a);
        f0 f0Var = this.f52285g;
        if (f0Var != null) {
            f0Var.w(interfaceC1009a);
        }
        LinearLayout linearLayout = this.f52284f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
