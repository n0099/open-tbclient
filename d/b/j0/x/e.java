package d.b.j0.x;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class e extends b<d.b.j0.d0.b> {
    public LinearLayout m;
    public RelativeLayout n;
    public TbImageView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public ClickableHeaderImageView s;
    public TextView t;
    public TextView u;
    public View v;
    public d.b.j0.d0.b w;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        u(m());
    }

    public final void A(a2 a2Var) {
        TextView textView = this.t;
        if (textView == null || a2Var == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(a2Var.T().getName_show())) {
            return;
        }
        this.t.setText(w(a2Var.T().getName_show()));
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f64176e != i) {
            SkinManager.setBackgroundResource(m(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0101, 1);
            d.b.j0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(this.w.g().o0())) {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
        }
        this.f64176e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i() != null) {
            i().a(m(), this.w);
        }
    }

    public final void u(View view) {
        this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.n = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.o = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.p = (ImageView) view.findViewById(R.id.img_play);
        this.q = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.r = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.s = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.t = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.u = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.v = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.o.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.f64178g.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.n.setLayoutParams(layoutParams);
        this.s.setDefaultResource(17170445);
        this.s.setDefaultBgResource(R.color.CAM_X0205);
        this.s.setIsRound(true);
        this.s.setDrawBorder(true);
        this.s.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.s.setBorderWidth(this.f64178g.getResources().getDimensionPixelSize(R.dimen.tbds1));
        m().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: v */
    public void n(d.b.j0.d0.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return;
        }
        this.w = bVar;
        String str = null;
        if (bVar.g().z2()) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            if (bVar.g().u1() != null) {
                this.q.setText(StringHelper.stringForVideoTime(bVar.g().u1().video_duration.intValue() * 1000));
                str = bVar.g().u1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (bVar.g().K0() != null && bVar.g().K0().size() >= 1) {
                str = bVar.g().K0().get(0).origin_pic;
            }
        }
        this.o.W(str, 10, false);
        this.r.setText(bVar.g().x1());
        d.b.j0.d3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(bVar.g().o0())) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
        }
        this.s.setData(bVar.g(), false);
        this.u.setText(StringHelper.getFormatTimeShort(bVar.g().S()));
        if ("news".equals(bVar.g().k0())) {
            this.s.setVisibility(8);
            this.t.setText(this.f64177f.getPageActivity().getResources().getString(R.string.person_view_num, StringHelper.numberUniformFormat(bVar.g().G1())));
            return;
        }
        this.s.setVisibility(0);
        A(bVar.g());
    }

    public String w(String str) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void x(int i) {
        View view = this.v;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setPadding(i, i2, i3, i4);
        }
    }

    public void z(int i) {
        this.s.setVisibility(i);
    }
}
