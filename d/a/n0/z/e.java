package d.a.n0.z;

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
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class e extends b<d.a.n0.e0.b> {
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
    public d.a.n0.e0.b w;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        s(l());
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f63440e != i2) {
            SkinManager.setBackgroundResource(l(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0101, 1);
            d.a.n0.e3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.d(this.w.h().o0())) {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
        }
        this.f63440e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (h() != null) {
            h().a(l(), this.w);
        }
    }

    public final void s(View view) {
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
        int dimensionPixelSize = this.f63442g.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.n.setLayoutParams(layoutParams);
        this.s.setDefaultResource(17170445);
        this.s.setDefaultBgResource(R.color.CAM_X0205);
        this.s.setIsRound(true);
        this.s.setDrawBorder(true);
        this.s.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
        this.s.setBorderWidth(this.f63442g.getResources().getDimensionPixelSize(R.dimen.tbds1));
        l().setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void m(d.a.n0.e0.b bVar) {
        if (bVar == null || bVar.h() == null) {
            return;
        }
        this.w = bVar;
        String str = null;
        if (bVar.h().C2()) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            if (bVar.h().w1() != null) {
                this.q.setText(StringHelper.stringForVideoTime(bVar.h().w1().video_duration.intValue() * 1000));
                str = bVar.h().w1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (bVar.h().L0() != null && bVar.h().L0().size() >= 1) {
                str = bVar.h().L0().get(0).origin_pic;
            }
        }
        this.o.V(str, 10, false);
        this.r.setText(bVar.h().z1());
        d.a.n0.e3.n0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(bVar.h().o0())) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
        }
        this.s.setData(bVar.h(), false);
        this.u.setText(StringHelper.getFormatTimeShort(bVar.h().S()));
        if ("news".equals(bVar.h().k0())) {
            this.s.setVisibility(8);
            this.t.setText(this.f63441f.getPageActivity().getResources().getString(R.string.person_view_num, StringHelper.numberUniformFormat(bVar.h().I1())));
            return;
        }
        this.s.setVisibility(0);
        y(bVar.h());
    }

    public String u(String str) {
        return StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void v(int i2) {
        View view = this.v;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void w(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout = this.m;
        if (linearLayout != null) {
            linearLayout.setPadding(i2, i3, i4, i5);
        }
    }

    public void x(int i2) {
        this.s.setVisibility(i2);
    }

    public final void y(a2 a2Var) {
        TextView textView = this.t;
        if (textView == null || a2Var == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(a2Var.T().getName_show())) {
            return;
        }
        this.t.setText(u(a2Var.T().getName_show()));
    }
}
