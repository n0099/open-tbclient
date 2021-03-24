package d.b.i0.c2.k.e.a1;

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
/* loaded from: classes4.dex */
public class e extends d.b.i0.c2.k.e.a1.a {

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52581f;

    /* renamed from: g  reason: collision with root package name */
    public f0 f52582g;

    /* renamed from: h  reason: collision with root package name */
    public ItemCardView f52583h;
    public a2 i;
    public d.b.h0.r.q.a j;

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
            return e.this.i;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar = e.this;
            a.InterfaceC1115a interfaceC1115a = eVar.f52566c;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(eVar.j);
            }
        }
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public View a() {
        if (this.f52581f == null) {
            LinearLayout linearLayout = new LinearLayout(this.f52564a.getPageActivity());
            this.f52581f = linearLayout;
            linearLayout.setClipChildren(false);
            this.f52581f.setClipToPadding(false);
            SkinManager.setBackgroundColor(this.f52581f, R.color.CAM_X0206);
            this.f52581f.setOrientation(1);
            this.f52581f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        this.f52581f.removeAllViews();
        if (this.f52582g == null) {
            f0 f0Var = new f0(this.f52564a);
            this.f52582g = f0Var;
            f0Var.n(Boolean.TRUE);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        layoutParams.leftMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f52581f.addView(this.f52582g.g(), layoutParams);
        if (this.f52583h == null) {
            this.f52583h = new ItemCardView(this.f52564a.getPageActivity());
        }
        this.f52583h.setBackGroundColor(R.color.CAM_X0205);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        layoutParams2.leftMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.rightMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams2.bottomMargin = this.f52564a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
        this.f52581f.addView(this.f52583h, layoutParams2);
        return this.f52581f;
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void b(TbPageContext tbPageContext, int i) {
        if (this.f52568e != i) {
            this.f52568e = i;
            SkinManager.setBackgroundColor(this.f52581f, R.color.CAM_X0206);
            f0 f0Var = this.f52582g;
            if (f0Var != null) {
                f0Var.onChangeSkinType(tbPageContext, i);
            }
            ItemCardView itemCardView = this.f52583h;
            if (itemCardView != null) {
                itemCardView.b();
            }
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        this.f52567d = originalThreadInfo;
        this.i = originalThreadInfo == null ? null : originalThreadInfo.a();
        this.j = new a();
        ItemCardView itemCardView = this.f52583h;
        if (itemCardView != null && originalThreadInfo != null) {
            itemCardView.setData(originalThreadInfo.z, 17);
        }
        f0 f0Var = this.f52582g;
        if (f0Var != null) {
            f0Var.a(this.j);
        }
    }

    @Override // d.b.i0.c2.k.e.a1.a
    public void d(a.InterfaceC1115a interfaceC1115a) {
        super.d(interfaceC1115a);
        f0 f0Var = this.f52582g;
        if (f0Var != null) {
            f0Var.w(interfaceC1115a);
        }
        LinearLayout linearLayout = this.f52581f;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new b());
        }
    }
}
