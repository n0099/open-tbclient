package d.a.j0.q0.n1.g;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.bumptech.glide.load.engine.GlideException;
import d.a.i0.r.q.a2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class d extends c {
    public RelativeLayout O;
    public TextView P;
    public TextView Q;
    public TextView R;

    /* loaded from: classes4.dex */
    public class a implements d.a.i0.b1.j.d {
        public a() {
        }

        @Override // d.a.i0.b1.j.d
        public void a(View view, int i2, boolean z) {
            d dVar = d.this;
            if (dVar.z == null || !dVar.R()) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            d dVar2 = d.this;
            urlManager.dealOneLink(dVar2.f62437f, new String[]{dVar2.z.H()});
        }
    }

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View l = l();
        this.O = (RelativeLayout) l.findViewById(R.id.lottery_info_layout);
        this.P = (TextView) l.findViewById(R.id.lottery_time_tv);
        this.Q = (TextView) l.findViewById(R.id.lottery_join_count_tv);
        this.R = (TextView) l.findViewById(R.id.lottery_btn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: A */
    public void m(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        if (ListUtils.getCount(a2Var.K0()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(a2Var.K0().get(0));
            a2Var.V3(arrayList);
        }
        super.A(a2Var);
        this.D.setImageClickListener(new a());
        d.a.i0.r.q.b bVar = (d.a.i0.r.q.b) ListUtils.getItem(a2Var.E(), 0);
        if (bVar != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.P.setText(StringUtils.string(b().getResources().getString(R.string.lottery_time), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.c())))));
            this.Q.setText(String.format(b().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.f())));
            this.R.setText(R.string.lottery_btn_text);
            this.o.setCommentNumEnable(false);
        }
    }

    public boolean R() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(this.f62437f.getPageActivity());
        return false;
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_frs_lottery_new_frame;
    }

    @Override // d.a.j0.q0.n1.g.c, d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.y != i2) {
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.Q, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.R, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.R, R.drawable.bg_card_frs_lottery_btn);
        }
        super.n(tbPageContext, i2);
    }

    @Override // d.a.j0.q0.n1.g.c
    public void z(boolean z) {
        if (this.z == null || !R()) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f62437f, new String[]{this.z.H()});
    }
}
