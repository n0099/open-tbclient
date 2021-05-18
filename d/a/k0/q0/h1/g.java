package d.a.k0.q0.h1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsAdCommentScrollView;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import d.a.c.a.j;
import d.a.k0.d3.i;
import d.a.k0.q0.n2.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f58514a;

    /* renamed from: b  reason: collision with root package name */
    public i f58515b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f58516c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f58517d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58518e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f58519f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58520g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f58521h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f58515b == null || StringUtils.isNull(g.this.f58515b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(g.this.f58514a), g.this.f58515b.f(), g.this.f58515b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", g.this.f58515b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (g.this.f58515b.k() != 1) {
                if (g.this.f58515b.k() == 2) {
                    i2 = 7;
                } else if (g.this.f58515b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", g.this.f58515b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (g.this.f58516c != null) {
                statisticItem.param("fid", g.this.f58516c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, g.this.f58516c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, g.this.f58516c.getSecond_class());
            }
            if (g.this.f58515b.k() == 1) {
                statisticItem.param("tid", g.this.f58515b.h());
                statisticItem.param("thread_type", g.this.f58515b.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.k0.q0.l2.a.a(g.this.f58515b.g());
        }
    }

    public g(Context context) {
        this.f58514a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        if (iVar == null) {
            return;
        }
        this.f58516c = forumData;
        this.f58515b = iVar;
        this.f58518e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f58520g.setText(this.f58514a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f58515b.e())));
        } else if (iVar.k() == 1) {
            this.f58520g.setText(this.f58514a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f58515b.e())));
        } else if (iVar.k() == 2) {
            this.f58520g.setText(this.f58514a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f58515b.e())));
        }
        this.f58519f.V(this.f58515b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f58521h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f58515b.a());
        }
        d.a.k0.q0.l2.a.b(this.f58515b.g());
    }

    public View e() {
        return this.f58517d;
    }

    public final void f() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f58514a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.f58517d = roundAdapterLinearLayout;
        roundAdapterLinearLayout.setRadius(this.f58514a.getResources().getDimension(R.dimen.tbds20));
        this.f58518e = (TextView) this.f58517d.findViewById(R.id.frs_top_ad_title);
        this.f58520g = (TextView) this.f58517d.findViewById(R.id.frs_top_person_num);
        TbImageView tbImageView = (TbImageView) this.f58517d.findViewById(R.id.frs_top_ad_img);
        this.f58519f = tbImageView;
        tbImageView.setDefaultBgResource(R.color.white_alpha100);
        this.f58521h = (FrsAdCommentScrollView) this.f58517d.findViewById(R.id.ad_comment_scroll_view);
        this.f58517d.setOnClickListener(new a());
    }

    public void g(int i2) {
        this.f58519f.invalidate();
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f58521h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.o();
        }
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f58521h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.p(z);
        }
    }
}
