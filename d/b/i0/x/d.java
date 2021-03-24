package d.b.i0.x;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class d extends b<d.b.i0.d0.a> {
    public String A;
    public LinearLayout m;
    public TextView n;
    public RelativeLayout o;
    public TbImageView p;
    public ImageView q;
    public TextView r;
    public RelativeLayout s;
    public ClickableHeaderImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public d.b.i0.d0.a y;
    public String z;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.z = str;
        this.A = str2;
        u(m());
    }

    public final void A(a2 a2Var) {
        if (this.u == null || a2Var == null || StringUtils.isNull(a2Var.T().getName_show())) {
            return;
        }
        this.u.setText(w(a2Var.T().getName_show()));
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62179e != i) {
            SkinManager.setBackgroundResource(m(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
            d.b.i0.c3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(this.y.g().o0())) {
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
            }
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1);
        }
        this.f62179e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.w) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 4).param("fid", this.z));
            FrsGameStrategyActivity.startActivity(this.f62180f.getPageActivity(), this.z, this.A);
        } else if (i() != null) {
            i().a(m(), this.y);
        }
    }

    public final void u(View view) {
        this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.n = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.o = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.p = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.q = (ImageView) view.findViewById(R.id.img_play);
        this.r = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.s = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.t = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.u = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.v = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.w = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.x = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.p.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = d.b.b.e.p.l.p(this.f62181g)[0] - (this.f62181g.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.o.setLayoutParams(layoutParams);
        this.w.setOnClickListener(this);
        this.t.setDefaultResource(17170445);
        this.t.setDefaultBgResource(R.color.CAM_X0205);
        this.t.setIsRound(true);
        this.t.setDrawBorder(true);
        this.t.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.t.setBorderWidth(this.f62181g.getResources().getDimensionPixelSize(R.dimen.tbds1));
        m().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.d0.a aVar) {
        if (aVar == null || aVar.g() == null) {
            return;
        }
        this.y = aVar;
        String str = null;
        if (aVar.g().y2()) {
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            if (aVar.g().u1() != null) {
                this.r.setText(StringHelper.stringForVideoTime(aVar.g().u1().video_duration.intValue() * 1000));
                str = aVar.g().u1().thumbnail_url;
            }
        } else {
            this.q.setVisibility(8);
            this.r.setVisibility(4);
            if (aVar.g().K0() != null && aVar.g().K0().size() >= 1) {
                str = aVar.g().K0().get(0).origin_pic;
            }
        }
        this.p.W(str, 10, false);
        this.n.setText(aVar.g().x1());
        d.b.i0.c3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(aVar.g().o0())) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        }
        this.t.setData(aVar.g(), false);
        A(aVar.g());
        this.v.setText(StringHelper.getFormatTimeShort(aVar.g().S()));
        if (AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE.equals(aVar.g().k0())) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
    }

    public String w(String str) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void x(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }

    public void y(int i) {
        RelativeLayout relativeLayout = this.s;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void z(int i) {
        View view = this.x;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
