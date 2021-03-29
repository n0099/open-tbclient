package d.b.i0.p0.h1;

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
import d.b.b.a.j;
import d.b.i0.c3.i;
import d.b.i0.p0.m2.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f57586a;

    /* renamed from: b  reason: collision with root package name */
    public i f57587b;

    /* renamed from: c  reason: collision with root package name */
    public ForumData f57588c;

    /* renamed from: d  reason: collision with root package name */
    public RoundAdapterLinearLayout f57589d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57590e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f57591f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57592g;

    /* renamed from: h  reason: collision with root package name */
    public FrsAdCommentScrollView f57593h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f57587b == null || StringUtils.isNull(g.this.f57587b.k())) {
                return;
            }
            h.b((TbPageContext) j.a(g.this.f57586a), g.this.f57587b.f(), g.this.f57587b.k());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
            httpMessage.addParam("id", g.this.f57587b.b());
            MessageManager.getInstance().sendMessage(httpMessage);
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i = 6;
            if (g.this.f57587b.j() != 1) {
                if (g.this.f57587b.j() == 2) {
                    i = 7;
                } else if (g.this.f57587b.j() == 3) {
                    i = 8;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i);
            statisticItem.param("obj_id", g.this.f57587b.b());
            statisticItem.param("obj_locate", 3);
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            if (g.this.f57588c != null) {
                statisticItem.param("fid", g.this.f57588c.getId());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, g.this.f57588c.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, g.this.f57588c.getSecond_class());
            }
            if (g.this.f57587b.j() == 1) {
                statisticItem.param("tid", g.this.f57587b.g());
                statisticItem.param("thread_type", g.this.f57587b.h());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public g(Context context) {
        this.f57586a = context;
        f();
    }

    public void d(ForumData forumData, i iVar) {
        if (iVar == null) {
            return;
        }
        this.f57588c = forumData;
        this.f57587b = iVar;
        this.f57590e.setText(iVar.i());
        if (iVar.j() == 3) {
            this.f57592g.setText(this.f57586a.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.f57587b.e())));
        } else if (iVar.j() == 1) {
            this.f57592g.setText(this.f57586a.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.f57587b.e())));
        } else if (iVar.j() == 2) {
            this.f57592g.setText(this.f57586a.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.f57587b.e())));
        }
        this.f57591f.W(this.f57587b.c(), 10, false);
        FrsAdCommentScrollView frsAdCommentScrollView = this.f57593h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.m(this.f57587b.a());
        }
    }

    public View e() {
        return this.f57589d;
    }

    public final void f() {
        RoundAdapterLinearLayout roundAdapterLinearLayout = (RoundAdapterLinearLayout) LayoutInflater.from(this.f57586a).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.f57589d = roundAdapterLinearLayout;
        roundAdapterLinearLayout.setRadius(this.f57586a.getResources().getDimension(R.dimen.tbds20));
        this.f57590e = (TextView) this.f57589d.findViewById(R.id.frs_top_ad_title);
        this.f57592g = (TextView) this.f57589d.findViewById(R.id.frs_top_person_num);
        TbImageView tbImageView = (TbImageView) this.f57589d.findViewById(R.id.frs_top_ad_img);
        this.f57591f = tbImageView;
        tbImageView.setDefaultBgResource(R.color.white_alpha100);
        this.f57593h = (FrsAdCommentScrollView) this.f57589d.findViewById(R.id.ad_comment_scroll_view);
        this.f57589d.setOnClickListener(new a());
    }

    public void g(int i) {
        this.f57591f.invalidate();
    }

    public void h() {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f57593h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.o();
        }
    }

    public void i(boolean z) {
        FrsAdCommentScrollView frsAdCommentScrollView = this.f57593h;
        if (frsAdCommentScrollView != null) {
            frsAdCommentScrollView.p(z);
        }
    }
}
