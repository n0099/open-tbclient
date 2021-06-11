package d.a.n0.e2.k.e.d1;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
/* loaded from: classes5.dex */
public class e extends d.a.n0.e2.k.e.d1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56932f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f56933g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f56934h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f56935i;
    public d.a.m0.r.q.a j;

    /* loaded from: classes5.dex */
    public class a extends d.a.m0.r.q.a {
        public a() {
        }

        @Override // d.a.m0.r.q.a
        public v0 c() {
            return null;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
        public BdUniqueId getType() {
            return null;
        }

        @Override // d.a.m0.r.q.a
        public a2 i() {
            return e.this.f56935i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC0598a interfaceC0598a = eVar.f56916c;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f56932f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f56914a.getPageActivity());
            this.f56932f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f56932f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f56932f, R.color.CAM_X0206);
            this.f56932f.setOrientation(1);
            this.f56932f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f56932f.removeAllViews();
        if (this.f56933g == null) {
            g0 g0Var = new g0(this.f56914a);
            this.f56933g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f56932f.addView(this.f56933g.g(), layoutParams);
        if (this.f56934h == null) {
            this.f56934h = new ItemCardView(this.f56914a.getPageActivity());
        }
        this.f56934h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f56914a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f56932f.addView(this.f56934h, layoutParams2);
        return this.f56932f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f56918e != i2) {
            this.f56918e = i2;
            SkinManager.setBackgroundColor(this.f56932f, R.color.CAM_X0206);
            g0 g0Var = this.f56933g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f56934h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f56917d = originalThreadInfo;
        this.f56935i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f56934h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f56933g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0598a interfaceC0598a) {
        super.d(interfaceC0598a);
        g0 g0Var = this.f56933g;
        if (g0Var != null) {
            g0Var.w(interfaceC0598a);
        }
        LinearLayout linearLayout = this.f56932f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
