package d.a.k0.q0.h1;

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
import d.a.c.e.p.l;
import d.a.k0.d3.i;
import d.a.k0.d3.m;
import d.a.k0.q0.n2.h;
import java.util.Date;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58504a;

    /* renamed from: b  reason: collision with root package name */
    public View f58505b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f58506c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58507d;

    /* renamed from: e  reason: collision with root package name */
    public RoundLinearLayout f58508e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.r.s.a f58509f;

    /* renamed from: g  reason: collision with root package name */
    public i f58510g;

    /* renamed from: h  reason: collision with root package name */
    public ForumData f58511h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f58512i = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.f58507d) {
                if (f.this.f58509f == null || !f.this.f58509f.isShowing()) {
                    return;
                }
                f.this.f58509f.dismiss();
            } else if (view != f.this.f58506c || f.this.f58510g == null || StringUtils.isNull(f.this.f58510g.l())) {
            } else {
                h.b(f.this.f58504a, f.this.f58510g.f(), f.this.f58510g.l());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                httpMessage.addParam("id", f.this.f58510g.b());
                MessageManager.getInstance().sendMessage(httpMessage);
                f.this.f58509f.dismiss();
                StatisticItem statisticItem = new StatisticItem("common_click");
                statisticItem.param("page_type", "a006");
                statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
                int i2 = 11;
                if (f.this.f58510g.k() != 1) {
                    if (f.this.f58510g.k() == 2) {
                        i2 = 12;
                    } else if (f.this.f58510g.k() == 3) {
                        i2 = 13;
                    }
                }
                statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
                statisticItem.param("obj_id", f.this.f58510g.b());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
                statisticItem.param("obj_locate", 3);
                if (f.this.f58511h != null) {
                    statisticItem.param("fid", f.this.f58511h.getId());
                    statisticItem.param(TiebaStatic.Params.FIRST_DIR, f.this.f58511h.getFirst_class());
                    statisticItem.param(TiebaStatic.Params.SECOND_DIR, f.this.f58511h.getSecond_class());
                }
                if (f.this.f58510g.k() == 1) {
                    statisticItem.param("tid", f.this.f58510g.h());
                    statisticItem.param("thread_type", f.this.f58510g.i());
                }
                TiebaStatic.log(statisticItem);
                d.a.k0.q0.l2.a.a(f.this.f58510g.g());
            }
        }
    }

    public f(TbPageContext tbPageContext) {
        this.f58504a = tbPageContext;
    }

    public final void g() {
        View inflate = LayoutInflater.from(this.f58504a.getPageActivity()).inflate(R.layout.frs_dialog_ad_layout, (ViewGroup) null);
        this.f58505b = inflate;
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) inflate.findViewById(R.id.round_layout);
        this.f58508e = roundLinearLayout;
        roundLinearLayout.setRoundCount(8);
        TbImageView tbImageView = (TbImageView) this.f58505b.findViewById(R.id.frs_ad_img);
        this.f58506c = tbImageView;
        tbImageView.setOnClickListener(this.f58512i);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f58506c.getLayoutParams();
        int k = l.k(this.f58504a.getPageActivity()) - (this.f58504a.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (k * 1.3306452f);
        this.f58506c.setLayoutParams(layoutParams);
        TextView textView = (TextView) this.f58505b.findViewById(R.id.frs_ad_close);
        this.f58507d = textView;
        textView.setOnClickListener(this.f58512i);
        i iVar = this.f58510g;
        if (iVar != null) {
            this.f58506c.V(iVar.d(), 10, false);
        }
    }

    public boolean h(m mVar) {
        if (mVar == null || mVar.getForum() == null || mVar.getBusinessPromot() == null) {
            return false;
        }
        this.f58511h = mVar.getForum();
        this.f58510g = mVar.getBusinessPromot();
        String str = "key_frs_dialog_ad_last_show_time" + mVar.getForum().getId();
        long l = d.a.j0.r.d0.b.j().l(str, 0L);
        if (l < 0 || !TimeHelper.isSameDay(new Date(l), new Date(System.currentTimeMillis()))) {
            d.a.j0.r.d0.b.j().w(str, System.currentTimeMillis());
            i();
            return true;
        }
        return false;
    }

    public final void i() {
        g();
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f58504a.getPageActivity());
        this.f58509f = aVar;
        aVar.setCancelable(true);
        this.f58509f.setCanceledOnTouchOutside(true);
        this.f58509f.create(this.f58504a).show();
        View decorView = this.f58509f.getWindow().getDecorView();
        WindowManager.LayoutParams attributes = this.f58509f.getWindow().getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 17;
            this.f58509f.getWindow().setAttributes(attributes);
        }
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            viewGroup.removeAllViews();
            viewGroup.addView(this.f58505b);
        }
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 11;
        if (this.f58510g.k() != 1) {
            if (this.f58510g.k() == 2) {
                i2 = 12;
            } else if (this.f58510g.k() == 3) {
                i2 = 13;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", this.f58510g.b());
        ForumData forumData = this.f58511h;
        if (forumData != null) {
            statisticItem.param("fid", forumData.getId());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, this.f58511h.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, this.f58511h.getSecond_class());
        }
        if (this.f58510g.k() == 1) {
            statisticItem.param("tid", this.f58510g.h());
            statisticItem.param("thread_type", this.f58510g.i());
        }
        TiebaStatic.log(statisticItem);
        d.a.k0.q0.l2.a.b(this.f58510g.g());
    }
}
