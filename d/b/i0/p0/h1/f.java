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
    public TbPageContext f57577a;

    /* renamed from: b  reason: collision with root package name */
    public View f57578b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f57579c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57580d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f57581e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.r.s.a f57582f;

    /* renamed from: g  reason: collision with root package name */
    public i f57583g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f57584h;
    public View.OnClickListener i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.f57580d) {
                if (f.this.f57582f == null || !f.this.f57582f.isShowing()) {
                    return;
                }
                f.this.f57582f.dismiss();
            } else if (view != f.this.f57579c || f.this.f57583g == null || StringUtils.isNull(f.this.f57583g.k())) {
            } else {
                h.b(f.this.f57577a, f.this.f57583g.f(), f.this.f57583g.k());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.f57583g.b());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.f57582f.dismiss();
                StatisticItem statisticItem = new StatisticItem("common_click");
                statisticItem.param("page_type", "a006");
                statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                int i = 11;
                if (f.this.f57583g.j() != 1) {
                    if (f.this.f57583g.j() == 2) {
                        i = 12;
                    } else if (f.this.f57583g.j() == 3) {
                        i = 13;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
                statisticItem.param("obj_id", f.this.f57583g.b());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                statisticItem.param("obj_locate", 3);
                if (f.this.f57584h != null) {
                    statisticItem.param("fid", f.this.f57584h.getId());
                    statisticItem.param(TiebaStatic.Params.FIRST_DIR, f.this.f57584h.getFirst_class());
                    statisticItem.param(TiebaStatic.Params.SECOND_DIR, f.this.f57584h.getSecond_class());
                }
                if (f.this.f57583g.j() == 1) {
                    statisticItem.param("tid", f.this.f57583g.g());
                    statisticItem.param("thread_type", f.this.f57583g.h());
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        this.f57577a = tbPageContext;
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f57577a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.f57578b = inflate;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
        this.f57581e = roundLinearLayout;
        roundLinearLayout.setRoundCount(8);
        TbImageView tbImageView = (TbImageView) this.f57578b.findViewById(R.id.frs_ad_img);
        this.f57579c = tbImageView;
        tbImageView.setOnClickListener(this.i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f57579c.getLayoutParams();
        int k = l.k(this.f57577a.getPageActivity()) - (this.f57577a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (k * 1.3306452f);
        this.f57579c.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.f57578b.findViewById(R.id.frs_ad_close);
        this.f57580d = textView;
        textView.setOnClickListener(this.i);
        i iVar = this.f57583g;
        if (iVar != null) {
            this.f57579c.W(iVar.d(), 10, false);
        }
    }

    public boolean h(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.f57584h = mVar.getForum();
        this.f57583g = mVar.getBusinessPromot();
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57577a.getPageActivity());
        this.f57582f = aVar;
        aVar.setCancelable(true);
        this.f57582f.setCanceledOnTouchOutside(true);
        this.f57582f.create(this.f57577a).show();
        View decorView = this.f57582f.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.f57582f.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.f57582f.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.f57578b);
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i = 11;
        if (this.f57583g.j() != 1) {
            if (this.f57583g.j() == 2) {
                i = 12;
            } else if (this.f57583g.j() == 3) {
                i = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
        statisticItem.param("obj_id", this.f57583g.b());
        ForumData forumData = this.f57584h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f57584h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f57584h.getSecond_class());
        }
        if (this.f57583g.j() == 1) {
            statisticItem.param("tid", this.f57583g.g());
            statisticItem.param("thread_type", this.f57583g.h());
        }
        TiebaStatic.log(statisticItem);
    }
}
