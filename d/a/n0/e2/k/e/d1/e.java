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
    public LinearLayout f53243f;

    /* renamed from: g  reason: collision with root package name */
    public g0 f53244g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f53245h;

    /* renamed from: i  reason: collision with root package name */
    public a2 f53246i;
    public d.a.m0.r.q.a j;

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
            return e.this.f53246i;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC0542a interfaceC0542a = eVar.f53227c;
            if (interfaceC0542a != null) {
                interfaceC0542a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public View a() {
        if (this.f53243f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f53225a.getPageActivity());
            this.f53243f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f53243f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f53243f, R.color.CAM_X0206);
            this.f53243f.setOrientation(1);
            this.f53243f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f53243f.removeAllViews();
        if (this.f53244g == null) {
            g0 g0Var = new g0(this.f53225a);
            this.f53244g = g0Var;
            g0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f53243f.addView(this.f53244g.g(), layoutParams);
        if (this.f53245h == null) {
            this.f53245h = new ItemCardView(this.f53225a.getPageActivity());
        }
        this.f53245h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f53225a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f53243f.addView(this.f53245h, layoutParams2);
        return this.f53243f;
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        if (this.f53229e != i2) {
            this.f53229e = i2;
            SkinManager.setBackgroundColor(this.f53243f, R.color.CAM_X0206);
            g0 g0Var = this.f53244g;
            if (g0Var != null) {
                g0Var.onChangeSkinType(tbPageContext, i2);
            }
            ItemCardView itemCardView = this.f53245h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f53228d = originalThreadInfo;
        this.f53246i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f53245h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        g0 g0Var = this.f53244g;
        if (g0Var != null) {
            g0Var.a(this.j);
        }
    }

    @Override // d.a.n0.e2.k.e.d1.a
    public void d(a.InterfaceC0542a interfaceC0542a) {
        super.d(interfaceC0542a);
        g0 g0Var = this.f53244g;
        if (g0Var != null) {
            g0Var.w(interfaceC0542a);
        }
        LinearLayout linearLayout = this.f53243f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
