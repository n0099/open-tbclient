package d.b.i0.q0.h1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.d3.i;
import d.b.i0.d3.m;
import d.b.i0.q0.n2.h;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59276a;

    /* renamed from: b  reason: collision with root package name */
    public View f59277b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f59278c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59279d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f59280e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.a f59281f;

    /* renamed from: g  reason: collision with root package name */
    public i f59282g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f59283h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.f59279d) {
                if (f.this.f59281f == null || !f.this.f59281f.isShowing()) {
                    return;
                }
                f.this.f59281f.dismiss();
            } else if (view != f.this.f59278c || f.this.f59282g == null || StringUtils.isNull(f.this.f59282g.l())) {
            } else {
                h.b(f.this.f59276a, f.this.f59282g.f(), f.this.f59282g.l());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.f59282g.b());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.f59281f.dismiss();
                StatisticItem statisticItem = new StatisticItem("common_click");
                statisticItem.param("page_type", "a006");
                statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                int i = 11;
                if (f.this.f59282g.k() != 1) {
                    if (f.this.f59282g.k() == 2) {
                        i = 12;
                    } else if (f.this.f59282g.k() == 3) {
                        i = 13;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
                statisticItem.param("obj_id", f.this.f59282g.b());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                statisticItem.param("obj_locate", 3);
                if (f.this.f59283h != null) {
                    statisticItem.param("fid", f.this.f59283h.getId());
                    statisticItem.param(TiebaStatic.Params.FIRST_DIR, f.this.f59283h.getFirst_class());
                    statisticItem.param(TiebaStatic.Params.SECOND_DIR, f.this.f59283h.getSecond_class());
                }
                if (f.this.f59282g.k() == 1) {
                    statisticItem.param("tid", f.this.f59282g.h());
                    statisticItem.param("thread_type", f.this.f59282g.i());
                }
                TiebaStatic.log(statisticItem);
                d.b.i0.q0.l2.a.a(f.this.f59282g.g());
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        this.f59276a = tbPageContext;
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f59276a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.f59277b = inflate;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
        this.f59280e = roundLinearLayout;
        roundLinearLayout.setRoundCount(8);
        TbImageView tbImageView = (TbImageView) this.f59277b.findViewById(R.id.frs_ad_img);
        this.f59278c = tbImageView;
        tbImageView.setOnClickListener(this.i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59278c.getLayoutParams();
        int k = l.k(this.f59276a.getPageActivity()) - (this.f59276a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (k * 1.3306452f);
        this.f59278c.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.f59277b.findViewById(R.id.frs_ad_close);
        this.f59279d = textView;
        textView.setOnClickListener(this.i);
        i iVar = this.f59282g;
        if (iVar != null) {
            this.f59278c.W(iVar.d(), 10, false);
        }
    }

    public boolean h(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.f59283h = mVar.getForum();
        this.f59282g = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long l = d.b.h0.r.d0.b.j().l(str, 0L);
        if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
            d.b.h0.r.d0.b.j().w(str, System.currentTimeMillis());
            i();
            return true;
        }
        return false;
    }

    public final void i() {
        g();
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f59276a.getPageActivity());
        this.f59281f = aVar;
        aVar.setCancelable(true);
        this.f59281f.setCanceledOnTouchOutside(true);
        this.f59281f.create(this.f59276a).show();
        View decorView = this.f59281f.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.f59281f.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.f59281f.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.f59277b);
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 11;
        if (this.f59282g.k() != 1) {
            if (this.f59282g.k() == 2) {
                i = 12;
            } else if (this.f59282g.k() == 3) {
                i = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", this.f59282g.b());
        ForumData forumData = this.f59283h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f59283h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f59283h.getSecond_class());
        }
        if (this.f59282g.k() == 1) {
            statisticItem.param("tid", this.f59282g.h());
            statisticItem.param("thread_type", this.f59282g.i());
        }
        TiebaStatic.log(statisticItem);
        d.b.i0.q0.l2.a.b(this.f59282g.g());
    }
}
