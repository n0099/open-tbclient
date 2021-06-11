package d.a.n0.w3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66710a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.d0.e f66711b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a();
        }
    }

    public b(TbPageContext tbPageContext) {
        this.f66710a = tbPageContext;
    }

    public void a() {
        d.a.n0.d0.e eVar = this.f66711b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f66710a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f66711b == null) {
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(tbPageContext, view);
            this.f66711b = eVar;
            eVar.g0(R.drawable.pic_sign_tip_down);
            this.f66711b.S(1);
            this.f66711b.O(32);
            this.f66711b.L(2);
            this.f66711b.V(false);
            this.f66711b.M(new a());
            int dimensionPixelSize = this.f66710a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f66710a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f66710a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f66710a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f66710a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f66711b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f66711b.j0(-dimensionPixelSize4);
            this.f66711b.k0(-dimensionPixelSize5);
            this.f66711b.N(3000);
        }
        String string = this.f66710a.getResources().getString(R.string.write_activity_tip_content);
        this.f66711b.Y(R.drawable.icon_pure_guide_haowu16);
        this.f66711b.R(true);
        this.f66711b.m0(string, "commodity_tip_show_controller");
    }
}
