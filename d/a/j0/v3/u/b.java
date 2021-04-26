package d.a.j0.v3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62162a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.b0.e f62163b;

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
        this.f62162a = tbPageContext;
    }

    public void a() {
        d.a.j0.b0.e eVar = this.f62163b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f62162a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f62163b == null) {
            d.a.j0.b0.e eVar = new d.a.j0.b0.e(tbPageContext, view);
            this.f62163b = eVar;
            eVar.c0(R.drawable.pic_sign_tip_down);
            this.f62163b.R(1);
            this.f62163b.N(32);
            this.f62163b.K(2);
            this.f62163b.U(false);
            this.f62163b.L(new a());
            int dimensionPixelSize = this.f62162a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f62162a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f62162a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f62162a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f62162a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f62163b.Y(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f62163b.f0(-dimensionPixelSize4);
            this.f62163b.g0(-dimensionPixelSize5);
            this.f62163b.M(3000);
        }
        String string = this.f62162a.getResources().getString(R.string.write_activity_tip_content);
        this.f62163b.X(R.drawable.icon_pure_guide_haowu16);
        this.f62163b.Q(true);
        this.f62163b.i0(string, "commodity_tip_show_controller");
    }
}
