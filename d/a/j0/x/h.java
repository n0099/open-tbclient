package d.a.j0.x;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends b<d.a.j0.d0.g> {
    public TbImageView m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public ImageView w;
    public TextView x;
    public d.a.j0.d0.g y;
    public View z;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        s(l());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_frs_game_score_view_item;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setBackgroundResource(l(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0107, 1);
            u(this.y);
        }
        this.f62436e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (h() != null) {
            h().a(l(), this.y);
        }
    }

    public final void s(View view) {
        this.m = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.n = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.o = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.p = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.q = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.r = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.s = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.t = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.u = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.v = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.w = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.x = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.m.setDefaultResource(17170445);
        this.m.setDefaultBgResource(R.color.CAM_X0205);
        this.m.setDrawBorder(true);
        this.m.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.m.setBorderWidth(this.f62438g.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.m.setRadius(b().getResources().getDimensionPixelSize(R.dimen.tbds26));
        l().setOnClickListener(this);
        this.z = view.findViewById(R.id.divider_line);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: t */
    public void m(d.a.j0.d0.g gVar) {
        if (gVar == null || gVar.h() == null) {
            return;
        }
        this.y = gVar;
        this.m.V(gVar.h().avatar, 10, false);
        this.o.setText(gVar.h().game_name);
        this.p.setText(gVar.h().title_small);
        this.q.setText(String.valueOf(gVar.h().game_score));
        u(gVar);
        this.x.setText(this.f62438g.getResources().getString(R.string.frs_game_score_user_score_num, StringHelper.numberUniform(gVar.h().game_score_num)));
    }

    public final void u(d.a.j0.d0.g gVar) {
        if (gVar == null) {
            return;
        }
        SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_empty_bg);
        if (gVar.h().game_score > 0.0d) {
            if (gVar.h().game_score < 2.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.h().game_score == 2.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.h().game_score < 4.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.h().game_score == 4.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.h().game_score < 6.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.h().game_score == 6.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.h().game_score < 8.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.h().game_score == 8.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (gVar.h().game_score < 10.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (gVar.h().game_score == 10.0d) {
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.t, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.u, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.v, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.w, R.drawable.game_comment_score_btn_small_full_bg);
            }
        }
    }
}
