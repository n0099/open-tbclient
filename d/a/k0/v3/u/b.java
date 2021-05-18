package d.a.k0.v3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62886a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.b0.e f62887b;

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
        this.f62886a = tbPageContext;
    }

    public void a() {
        d.a.k0.b0.e eVar = this.f62887b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f62886a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f62887b == null) {
            d.a.k0.b0.e eVar = new d.a.k0.b0.e(tbPageContext, view);
            this.f62887b = eVar;
            eVar.g0(R.drawable.pic_sign_tip_down);
            this.f62887b.S(1);
            this.f62887b.O(32);
            this.f62887b.L(2);
            this.f62887b.V(false);
            this.f62887b.M(new a());
            int dimensionPixelSize = this.f62886a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f62886a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f62886a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f62886a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f62886a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f62887b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f62887b.j0(-dimensionPixelSize4);
            this.f62887b.k0(-dimensionPixelSize5);
            this.f62887b.N(3000);
        }
        String string = this.f62886a.getResources().getString(R.string.write_activity_tip_content);
        this.f62887b.Y(R.drawable.icon_pure_guide_haowu16);
        this.f62887b.R(true);
        this.f62887b.m0(string, "commodity_tip_show_controller");
    }
}
