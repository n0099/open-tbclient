package d.b.i0.d2.k.e.c1;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.i.a;
import d.b.i.f0;
/* loaded from: classes3.dex */
public class e extends d.b.i0.d2.k.e.c1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54067f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f54068g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f54069h;
    public a2 i;
    public d.b.h0.r.q.a j;

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
            a.InterfaceC1129a interfaceC1129a = eVar.f54052c;
            if (interfaceC1129a != null) {
                interfaceC1129a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public View a() {
        if (this.f54067f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f54050a.getPageActivity());
            this.f54067f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f54067f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f54067f, R.color.CAM_X0206);
            this.f54067f.setOrientation(1);
            this.f54067f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f54067f.removeAllViews();
        if (this.f54068g == null) {
            f0 f0Var = new f0(this.f54050a);
            this.f54068g = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f54067f.addView(this.f54068g.g(), layoutParams);
        if (this.f54069h == null) {
            this.f54069h = new ItemCardView(this.f54050a.getPageActivity());
        }
        this.f54069h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f54050a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f54067f.addView(this.f54069h, layoutParams2);
        return this.f54067f;
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f54054e != i) {
            this.f54054e = i;
            SkinManager.setBackgroundColor(this.f54067f, R.color.CAM_X0206);
            f0 f0Var = this.f54068g;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f54069h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f54053d = originalThreadInfo;
        this.i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f54069h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        f0 f0Var = this.f54068g;
        if (f0Var != null) {
            f0Var.a(this.j);
        }
    }

    @Override // d.b.i0.d2.k.e.c1.a
    public void d(a.InterfaceC1129a interfaceC1129a) {
        super.d(interfaceC1129a);
        f0 f0Var = this.f54068g;
        if (f0Var != null) {
            f0Var.w(interfaceC1129a);
        }
        LinearLayout linearLayout = this.f54067f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
