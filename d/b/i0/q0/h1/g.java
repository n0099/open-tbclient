package d.b.i0.q0.h1;

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
import d.b.c.a.j;
import d.b.i0.d3.i;
import d.b.i0.q0.n2.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f59285a;

    /* renamed from: b  reason: collision with root package name */
    public i f59286b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f59287c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f59288d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59289e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f59290f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59291g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f59292h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f59286b == null || StringUtils.isNull(g.this.f59286b.l())) {
                return;
            }
            h.b((TbPageContext) j.a(g.this.f59285a), g.this.f59286b.f(), g.this.f59286b.l());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", g.this.f59286b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i = 6;
            if (g.this.f59286b.k() != 1) {
                if (g.this.f59286b.k() == 2) {
                    i = 7;
                } else if (g.this.f59286b.k() == 3) {
                    i = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", g.this.f59286b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (g.this.f59287c != null) {
                statisticItem.param("fid", g.this.f59287c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, g.this.f59287c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, g.this.f59287c.getSecond_class());
            }
            if (g.this.f59286b.k() == 1) {
                statisticItem.param("tid", g.this.f59286b.h());
                statisticItem.param("thread_type", g.this.f59286b.i());
            }
            TiebaStatic.log(statisticItem);
            d.b.i0.q0.l2.a.a(g.this.f59286b.g());
        }
    }

    public g(Context context) {
        this.f59285a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        if (iVar == null) {
            return;
        }
        this.f59287c = forumData;
        this.f59286b = iVar;
        this.f59289e.setText(iVar.j());
        if (iVar.k() == 3) {
            this.f59291g.setText(this.f59285a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f59286b.e())));
        } else if (iVar.k() == 1) {
            this.f59291g.setText(this.f59285a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f59286b.e())));
        } else if (iVar.k() == 2) {
            this.f59291g.setText(this.f59285a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f59286b.e())));
        }
        this.f59290f.W(this.f59286b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f59292h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f59286b.a());
        }
        d.b.i0.q0.l2.a.b(this.f59286b.g());
    }

    public View e() {
        return this.f59288d;
    }

    public final void f() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f59285a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.f59288d = roundAdapterLinearLayout;
        roundAdapterLinearLayout.setRadius(this.f59285a.getResources().getDimension(R.dimen.tbds20));
        this.f59289e = (TextView) this.f59288d.findViewById(R.id.frs_top_ad_title);
        this.f59291g = (TextView) this.f59288d.findViewById(R.id.frs_top_person_num);
        TbImageView tbImageView = (TbImageView) this.f59288d.findViewById(R.id.frs_top_ad_img);
        this.f59290f = tbImageView;
        tbImageView.setDefaultBgResource(R.color.white_alpha100);
        this.f59292h = (FrsAdCommentScrollView) this.f59288d.findViewById(R.id.ad_comment_scroll_view);
        this.f59288d.setOnClickListener(new a());
    }

    public void g(int i) {
        this.f59290f.invalidate();
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f59292h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.o();
        }
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f59292h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.p(z);
        }
    }
}
