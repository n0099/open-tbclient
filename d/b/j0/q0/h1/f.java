package d.b.j0.q0.h1;

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
import d.b.j0.d3.i;
import d.b.j0.d3.m;
import d.b.j0.q0.n2.h;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59697a;

    /* renamed from: b  reason: collision with root package name */
    public View f59698b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f59699c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59700d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f59701e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.r.s.a f59702f;

    /* renamed from: g  reason: collision with root package name */
    public i f59703g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f59704h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.f59700d) {
                if (f.this.f59702f == null || !f.this.f59702f.isShowing()) {
                    return;
                }
                f.this.f59702f.dismiss();
            } else if (view != f.this.f59699c || f.this.f59703g == null || StringUtils.isNull(f.this.f59703g.l())) {
            } else {
                h.b(f.this.f59697a, f.this.f59703g.f(), f.this.f59703g.l());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.f59703g.b());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.f59702f.dismiss();
                StatisticItem statisticItem = new StatisticItem("common_click");
                statisticItem.param("page_type", "a006");
                statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                int i = 11;
                if (f.this.f59703g.k() != 1) {
                    if (f.this.f59703g.k() == 2) {
                        i = 12;
                    } else if (f.this.f59703g.k() == 3) {
                        i = 13;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
                statisticItem.param("obj_id", f.this.f59703g.b());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                statisticItem.param("obj_locate", 3);
                if (f.this.f59704h != null) {
                    statisticItem.param("fid", f.this.f59704h.getId());
                    statisticItem.param(TiebaStatic.Params.FIRST_DIR, f.this.f59704h.getFirst_class());
                    statisticItem.param(TiebaStatic.Params.SECOND_DIR, f.this.f59704h.getSecond_class());
                }
                if (f.this.f59703g.k() == 1) {
                    statisticItem.param("tid", f.this.f59703g.h());
                    statisticItem.param("thread_type", f.this.f59703g.i());
                }
                TiebaStatic.log(statisticItem);
                d.b.j0.q0.l2.a.a(f.this.f59703g.g());
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        this.f59697a = tbPageContext;
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f59697a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.f59698b = inflate;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
        this.f59701e = roundLinearLayout;
        roundLinearLayout.setRoundCount(8);
        TbImageView tbImageView = (TbImageView) this.f59698b.findViewById(R.id.frs_ad_img);
        this.f59699c = tbImageView;
        tbImageView.setOnClickListener(this.i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59699c.getLayoutParams();
        int k = l.k(this.f59697a.getPageActivity()) - (this.f59697a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (k * 1.3306452f);
        this.f59699c.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.f59698b.findViewById(R.id.frs_ad_close);
        this.f59700d = textView;
        textView.setOnClickListener(this.i);
        i iVar = this.f59703g;
        if (iVar != null) {
            this.f59699c.W(iVar.d(), 10, false);
        }
    }

    public boolean h(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.f59704h = mVar.getForum();
        this.f59703g = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long l = d.b.i0.r.d0.b.j().l(str, 0L);
        if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
            d.b.i0.r.d0.b.j().w(str, System.currentTimeMillis());
            i();
            return true;
        }
        return false;
    }

    public final void i() {
        g();
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f59697a.getPageActivity());
        this.f59702f = aVar;
        aVar.setCancelable(true);
        this.f59702f.setCanceledOnTouchOutside(true);
        this.f59702f.create(this.f59697a).show();
        View decorView = this.f59702f.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.f59702f.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.f59702f.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.f59698b);
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 11;
        if (this.f59703g.k() != 1) {
            if (this.f59703g.k() == 2) {
                i = 12;
            } else if (this.f59703g.k() == 3) {
                i = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", this.f59703g.b());
        ForumData forumData = this.f59704h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f59704h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f59704h.getSecond_class());
        }
        if (this.f59703g.k() == 1) {
            statisticItem.param("tid", this.f59703g.h());
            statisticItem.param("thread_type", this.f59703g.i());
        }
        TiebaStatic.log(statisticItem);
        d.b.j0.q0.l2.a.b(this.f59703g.g());
    }
}
