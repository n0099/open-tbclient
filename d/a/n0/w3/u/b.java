package d.a.n0.w3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62995a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.d0.e f62996b;

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
        this.f62995a = tbPageContext;
    }

    public void a() {
        d.a.n0.d0.e eVar = this.f62996b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f62995a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f62996b == null) {
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(tbPageContext, view);
            this.f62996b = eVar;
            eVar.g0(R.drawable.pic_sign_tip_down);
            this.f62996b.S(1);
            this.f62996b.O(32);
            this.f62996b.L(2);
            this.f62996b.V(false);
            this.f62996b.M(new a());
            int dimensionPixelSize = this.f62995a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f62995a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f62995a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f62995a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f62995a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f62996b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f62996b.j0(-dimensionPixelSize4);
            this.f62996b.k0(-dimensionPixelSize5);
            this.f62996b.N(3000);
        }
        String string = this.f62995a.getResources().getString(R.string.write_activity_tip_content);
        this.f62996b.Y(R.drawable.icon_pure_guide_haowu16);
        this.f62996b.R(true);
        this.f62996b.m0(string, "commodity_tip_show_controller");
    }
}
