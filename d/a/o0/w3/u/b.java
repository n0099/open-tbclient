package d.a.o0.w3.u;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66835a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.d0.e f66836b;

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
        this.f66835a = tbPageContext;
    }

    public void a() {
        d.a.o0.d0.e eVar = this.f66836b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void b(View view) {
        TbPageContext tbPageContext = this.f66835a;
        if (tbPageContext == null || view == null) {
            return;
        }
        if (this.f66836b == null) {
            d.a.o0.d0.e eVar = new d.a.o0.d0.e(tbPageContext, view);
            this.f66836b = eVar;
            eVar.g0(R.drawable.pic_sign_tip_down);
            this.f66836b.S(1);
            this.f66836b.O(32);
            this.f66836b.L(2);
            this.f66836b.V(false);
            this.f66836b.M(new a());
            int dimensionPixelSize = this.f66835a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f66835a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f66835a.getResources().getDimensionPixelSize(R.dimen.tbds44);
            int dimensionPixelSize4 = this.f66835a.getResources().getDimensionPixelSize(R.dimen.tbds50);
            int dimensionPixelSize5 = this.f66835a.getResources().getDimensionPixelSize(R.dimen.tbds6);
            this.f66836b.Z(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            this.f66836b.j0(-dimensionPixelSize4);
            this.f66836b.k0(-dimensionPixelSize5);
            this.f66836b.N(3000);
        }
        String string = this.f66835a.getResources().getString(R.string.write_activity_tip_content);
        this.f66836b.Y(R.drawable.icon_pure_guide_haowu16);
        this.f66836b.R(true);
        this.f66836b.m0(string, "commodity_tip_show_controller");
    }
}
