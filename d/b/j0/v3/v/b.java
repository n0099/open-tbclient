package d.b.j0.v3.v;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63919a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.b0.e f63920b;

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
        this.f63919a = tbPageContext;
    }

    public void a() {
        d.b.j0.b0.e eVar = this.f63920b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f63919a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f63920b == null) {
            d.b.j0.b0.e eVar = new d.b.j0.b0.e(tbPageContext, view);
            this.f63920b = eVar;
            eVar.c0(R.drawable.pic_sign_tip_down);
            this.f63920b.R(1);
            this.f63920b.N(32);
            this.f63920b.K(2);
            this.f63920b.U(false);
            this.f63920b.L(new a());
            int dimensionPixelSize = this.f63919a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f63919a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f63919a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f63919a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f63919a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f63920b.Y(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f63920b.f0(-dimensionPixelSize4);
            this.f63920b.g0(-dimensionPixelSize5);
            this.f63920b.M(3000);
        }
        String string = this.f63919a.getResources().getString(R.string.write_activity_tip_content);
        this.f63920b.X(R.drawable.icon_pure_guide_haowu16);
        this.f63920b.Q(true);
        this.f63920b.i0(string, "commodity_tip_show_controller");
    }
}
