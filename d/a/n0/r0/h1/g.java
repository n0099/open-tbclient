package d.a.n0.r0.h1;

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
import d.a.n0.e3.i;
import d.a.n0.r0.n2.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f62346a;

    /* renamed from: b  reason: collision with root package name */
    public i f62347b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f62348c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f62349d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62350e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f62351f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62352g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f62353h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f62347b == null || StringUtils.isNull(g.this.f62347b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(g.this.f62346a), g.this.f62347b.f(), g.this.f62347b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", g.this.f62347b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (g.this.f62347b.k() != 1) {
                if (g.this.f62347b.k() == 2) {
                    i2 = 7;
                } else if (g.this.f62347b.k() == 3) {
                    i2 = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", g.this.f62347b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (g.this.f62348c != null) {
                statisticItem.param("fid", g.this.f62348c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, g.this.f62348c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, g.this.f62348c.getSecond_class());
            }
            if (g.this.f62347b.k() == 1) {
                statisticItem.param("tid", g.this.f62347b.h());
                statisticItem.param("thread_type", g.this.f62347b.i());
            }
            TiebaStatic.log(statisticItem);
            d.a.n0.r0.l2.a.a(g.this.f62347b.g());
        }
    }

    public g(Context context) {
        this.f62346a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        if (iVar == null) {
            return;
        }
        this.f62348c = forumData;
        this.f62347b = iVar;
        this.f62350e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f62352g.setText(this.f62346a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f62347b.e())));
        } else if (iVar.k() == 1) {
            this.f62352g.setText(this.f62346a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f62347b.e())));
        } else if (iVar.k() == 2) {
            this.f62352g.setText(this.f62346a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f62347b.e())));
        }
        this.f62351f.U(this.f62347b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f62353h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f62347b.a());
        }
        d.a.n0.r0.l2.a.b(this.f62347b.g());
    }

    public View e() {
        return this.f62349d;
    }

    public final void f() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f62346a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.f62349d = roundAdapterLinearLayout;
        roundAdapterLinearLayout.setRadius(this.f62346a.getResources().getDimension(R.dimen.tbds20));
        this.f62350e = (TextView) this.f62349d.findViewById(R.id.frs_top_ad_title);
        this.f62352g = (TextView) this.f62349d.findViewById(R.id.frs_top_person_num);
        TbImageView tbImageView = (TbImageView) this.f62349d.findViewById(R.id.frs_top_ad_img);
        this.f62351f = tbImageView;
        tbImageView.setDefaultBgResource(R.color.white_alpha100);
        this.f62353h = (FrsAdCommentScrollView) this.f62349d.findViewById(R.id.ad_comment_scroll_view);
        this.f62349d.setOnClickListener(new a());
    }

    public void g(int i2) {
        this.f62351f.invalidate();
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f62353h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.o();
        }
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f62353h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.p(z);
        }
    }
}
