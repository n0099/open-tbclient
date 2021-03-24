package d.b.i0.p0.n1.g;

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
import d.b.h0.r.q.a2;
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
    public class a implements d.b.h0.b1.j.d {
        public a() {
        }

        @Override // d.b.h0.b1.j.d
        public void a(View view, int i, boolean z) {
            d dVar = d.this;
            if (dVar.z == null || !dVar.U()) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            d dVar2 = d.this;
            urlManager.dealOneLink(dVar2.f62180f, new String[]{dVar2.z.H()});
        }
    }

    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        View m = m();
        this.O = (RelativeLayout) m.findViewById(R.id.lottery_info_layout);
        this.P = (TextView) m.findViewById(R.id.lottery_time_tv);
        this.Q = (TextView) m.findViewById(R.id.lottery_join_count_tv);
        this.R = (TextView) m.findViewById(R.id.lottery_btn);
    }

    @Override // d.b.i0.p0.n1.g.c
    public void B(boolean z) {
        if (this.z == null || !U()) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.f62180f, new String[]{this.z.H()});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: E */
    public void n(a2 a2Var) {
        if (a2Var == null) {
            return;
        }
        if (ListUtils.getCount(a2Var.K0()) > 1) {
            ArrayList<MediaData> arrayList = new ArrayList<>();
            arrayList.add(a2Var.K0().get(0));
            a2Var.U3(arrayList);
        }
        super.E(a2Var);
        this.D.setImageClickListener(new a());
        d.b.h0.r.q.b bVar = (d.b.h0.r.q.b) ListUtils.getItem(a2Var.E(), 0);
        if (bVar != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            this.P.setText(StringUtils.string(b().getResources().getString(R.string.lottery_time), GlideException.IndentedAppendable.INDENT, simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.b()))), "-", simpleDateFormat.format(new Date(TimeUnit.SECONDS.toMillis(bVar.c())))));
            this.Q.setText(String.format(b().getResources().getString(R.string.lottery_join_num), String.valueOf(bVar.f())));
            this.R.setText(R.string.lottery_btn_text);
            this.o.setCommentNumEnable(false);
        }
    }

    public boolean U() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(this.f62180f.getPageActivity());
        return false;
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_frs_lottery_new_frame;
    }

    @Override // d.b.i0.p0.n1.g.c, d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.y != i) {
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.P, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.Q, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.R, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.R, R.drawable.bg_card_frs_lottery_btn);
        }
        super.o(tbPageContext, i);
    }
}
