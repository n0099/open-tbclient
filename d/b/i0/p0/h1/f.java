package d.b.i0.p0.h1;

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
import d.b.b.e.p.l;
import d.b.i0.c3.i;
import d.b.i0.c3.m;
import d.b.i0.p0.m2.h;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57576a;

    /* renamed from: b  reason: collision with root package name */
    public View f57577b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f57578c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57579d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f57580e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.a f57581f;

    /* renamed from: g  reason: collision with root package name */
    public i f57582g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f57583h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.f57579d) {
                if (f.this.f57581f == null || !f.this.f57581f.isShowing()) {
                    return;
                }
                f.this.f57581f.dismiss();
            } else if (view != f.this.f57578c || f.this.f57582g == null || StringUtils.isNull(f.this.f57582g.k())) {
            } else {
                h.b(f.this.f57576a, f.this.f57582g.f(), f.this.f57582g.k());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.f57582g.b());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.f57581f.dismiss();
                StatisticItem statisticItem = new StatisticItem("common_click");
                statisticItem.param("page_type", "a006");
                statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                int i = 11;
                if (f.this.f57582g.j() != 1) {
                    if (f.this.f57582g.j() == 2) {
                        i = 12;
                    } else if (f.this.f57582g.j() == 3) {
                        i = 13;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
                statisticItem.param("obj_id", f.this.f57582g.b());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                statisticItem.param("obj_locate", 3);
                if (f.this.f57583h != null) {
                    statisticItem.param("fid", f.this.f57583h.getId());
                    statisticItem.param(TiebaStatic.Params.FIRST_DIR, f.this.f57583h.getFirst_class());
                    statisticItem.param(TiebaStatic.Params.SECOND_DIR, f.this.f57583h.getSecond_class());
                }
                if (f.this.f57582g.j() == 1) {
                    statisticItem.param("tid", f.this.f57582g.g());
                    statisticItem.param("thread_type", f.this.f57582g.h());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        this.f57576a = tbPageContext;
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f57576a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.f57577b = inflate;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
        this.f57580e = roundLinearLayout;
        roundLinearLayout.setRoundCount(8);
        TbImageView tbImageView = (TbImageView) this.f57577b.findViewById(R.id.frs_ad_img);
        this.f57578c = tbImageView;
        tbImageView.setOnClickListener(this.i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57578c.getLayoutParams();
        int k = l.k(this.f57576a.getPageActivity()) - (this.f57576a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (k * 1.3306452f);
        this.f57578c.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.f57577b.findViewById(R.id.frs_ad_close);
        this.f57579d = textView;
        textView.setOnClickListener(this.i);
        i iVar = this.f57582g;
        if (iVar != null) {
            this.f57578c.W(iVar.d(), 10, false);
        }
    }

    public boolean h(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.f57583h = mVar.getForum();
        this.f57582g = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long k = d.b.h0.r.d0.b.i().k(str, 0L);
        if (k < 0 || !TimeHelper.isSameDay(new Date(k), new Date(System.currentTimeMillis()))) {
            d.b.h0.r.d0.b.i().v(str, System.currentTimeMillis());
            i();
            return true;
        }
        return false;
    }

    public final void i() {
        g();
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57576a.getPageActivity());
        this.f57581f = aVar;
        aVar.setCancelable(true);
        this.f57581f.setCanceledOnTouchOutside(true);
        this.f57581f.create(this.f57576a).show();
        View decorView = this.f57581f.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.f57581f.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.f57581f.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.f57577b);
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 11;
        if (this.f57582g.j() != 1) {
            if (this.f57582g.j() == 2) {
                i = 12;
            } else if (this.f57582g.j() == 3) {
                i = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", this.f57582g.b());
        ForumData forumData = this.f57583h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f57583h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f57583h.getSecond_class());
        }
        if (this.f57582g.j() == 1) {
            statisticItem.param("tid", this.f57582g.g());
            statisticItem.param("thread_type", this.f57582g.h());
        }
        TiebaStatic.log(statisticItem);
    }
}
