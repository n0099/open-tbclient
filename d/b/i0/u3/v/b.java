package d.b.i0.u3.v;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61759a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.b0.e f61760b;

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
        this.f61759a = tbPageContext;
    }

    public void a() {
        d.b.i0.b0.e eVar = this.f61760b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f61759a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f61760b == null) {
            d.b.i0.b0.e eVar = new d.b.i0.b0.e(tbPageContext, view);
            this.f61760b = eVar;
            eVar.c0(R.drawable.pic_sign_tip_down);
            this.f61760b.R(1);
            this.f61760b.N(32);
            this.f61760b.K(2);
            this.f61760b.U(false);
            this.f61760b.L(new a());
            int dimensionPixelSize = this.f61759a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f61759a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f61759a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f61759a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f61759a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f61760b.Y(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f61760b.f0(-dimensionPixelSize4);
            this.f61760b.g0(-dimensionPixelSize5);
            this.f61760b.M(3000);
        }
        String string = this.f61759a.getResources().getString(R.string.write_activity_tip_content);
        this.f61760b.X(R.drawable.icon_pure_guide_haowu16);
        this.f61760b.Q(true);
        this.f61760b.i0(string, "commodity_tip_show_controller");
    }
}
