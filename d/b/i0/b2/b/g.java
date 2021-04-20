package d.b.i0.b2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.google.gson.Gson;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class g extends b {
    public ViewStub n;
    public View o;
    public TbImageView p;
    public TextView q;
    public TextView r;

    public g(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_name);
        this.n = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 2;
        this.n.setLayoutParams(layoutParams);
        this.o = view.findViewById(R.id.user_info_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.user_avatar);
        this.p = tbImageView;
        tbImageView.setIsRound(true);
        this.p.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.q = (TextView) view.findViewById(R.id.user_name);
        this.r = (TextView) view.findViewById(R.id.user_subtitle);
    }

    @Override // d.b.i0.b2.b.b
    public void a(int i) {
        super.a(i);
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.o);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0204);
        d.b.h0.r.u.c d3 = d.b.h0.r.u.c.d(this.q);
        d3.q(R.color.CAM_X0105);
        d3.u(R.dimen.T_X05);
        d3.v(R.string.F_X02);
        d.b.h0.r.u.c d4 = d.b.h0.r.u.c.d(this.r);
        d4.q(R.color.CAM_X0108);
        d4.u(R.dimen.T_X08);
        d4.v(R.string.F_X01);
    }

    @Override // d.b.i0.b2.b.b
    public void c(c cVar) {
        ShareStorage.StorageModel storageModel;
        if (cVar == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f53345d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.p.W(storageModel.url, 10, false);
        this.q.setText(storageModel.displayname);
        this.r.setText(this.f53334a.getResources().getString(R.string.share_login_dialog_subtitle, storageModel.app));
    }
}
