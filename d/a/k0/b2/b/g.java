package d.a.k0.b2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.gson.Gson;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class g extends b {
    public ViewStub o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;

    public g(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_name);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view.findViewById(R.id.user_info_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.user_avatar);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view.findViewById(R.id.user_name);
        this.s = (TextView) view.findViewById(R.id.user_subtitle);
    }

    @Override // d.a.k0.b2.b.b
    public void a(int i2) {
        super.a(i2);
        d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this.p);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0204);
        d.a.j0.r.u.c d3 = d.a.j0.r.u.c.d(this.r);
        d3.q(R.color.CAM_X0105);
        d3.u(R.dimen.T_X05);
        d3.v(R.string.F_X02);
        d.a.j0.r.u.c d4 = d.a.j0.r.u.c.d(this.s);
        d4.q(R.color.CAM_X0108);
        d4.u(R.dimen.T_X08);
        d4.v(R.string.F_X01);
    }

    @Override // d.a.k0.b2.b.b
    public void c(c cVar) {
        ShareStorage.StorageModel storageModel;
        if (cVar == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f52215d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.V(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.f52203a.getResources().getString(R.string.share_login_dialog_subtitle, storageModel.app));
    }
}
