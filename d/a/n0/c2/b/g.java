package d.a.n0.c2.b;

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
/* loaded from: classes5.dex */
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

    @Override // d.a.n0.c2.b.b
    public void a(int i2) {
        super.a(i2);
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this.p);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0204);
        d.a.m0.r.u.c d3 = d.a.m0.r.u.c.d(this.r);
        d3.s(R.color.CAM_X0105);
        d3.w(R.dimen.T_X05);
        d3.x(R.string.F_X02);
        d.a.m0.r.u.c d4 = d.a.m0.r.u.c.d(this.s);
        d4.s(R.color.CAM_X0108);
        d4.w(R.dimen.T_X08);
        d4.x(R.string.F_X01);
    }

    @Override // d.a.n0.c2.b.b
    public void c(c cVar) {
        ShareStorage.StorageModel storageModel;
        if (cVar == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f56062d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.U(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.f56050a.getResources().getString(R.string.share_login_dialog_subtitle, storageModel.app));
    }
}
