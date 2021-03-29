package d.b.i0.t.d.f.e.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.i0.t.d.g.d.f;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60558a;

    /* renamed from: b  reason: collision with root package name */
    public View f60559b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f60560c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f60561d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f60562e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f60563f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60564g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60565h;
    public TextView i;
    public String k;
    public d.b.i0.t.d.a.a l;
    public f m;
    public int j = 3;
    public int[] o = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    public View.OnClickListener p = new View$OnClickListenerC1553a();
    public String n = TbadkCoreApplication.getInst().getResources().getString(R.string.special_game_tab_title);

    /* renamed from: d.b.i0.t.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1553a implements View.OnClickListener {
        public View$OnClickListenerC1553a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (a.this.l == null || a.this.m == null) {
                    return;
                }
                a.this.m.a(a.this.l);
                return;
            }
            l.L(a.this.f60558a.getPageActivity(), a.this.f60558a.getPageActivity().getString(R.string.neterror));
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f60558a = tbPageContext;
        View inflate = LayoutInflater.from(this.f60558a.getPageActivity()).inflate(R.layout.ala_special_game_live_item_view, (ViewGroup) null, false);
        this.f60559b = inflate;
        this.f60562e = (RelativeLayout) inflate.findViewById(R.id.gameUserNameWrapper);
        TbImageView tbImageView = (TbImageView) this.f60559b.findViewById(R.id.gameTopImg);
        this.f60560c = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.f60561d = (RelativeLayout) this.f60559b.findViewById(R.id.gameTopImgLayout);
        this.f60559b.setOnClickListener(this.p);
        this.f60563f = (TbImageView) this.f60559b.findViewById(R.id.gameTopLabel);
        this.f60564g = (TextView) this.f60559b.findViewById(R.id.gameTopAuthorName);
        this.f60565h = (TextView) this.f60559b.findViewById(R.id.gameTopAudienceCount);
        this.i = (TextView) this.f60559b.findViewById(R.id.gameLiveItemTitle);
        this.f60562e.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.o));
        int k = l.k(this.f60559b.getContext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60561d.getLayoutParams();
        int dimensionPixelSize = (k - (this.f60558a.getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (int) (dimensionPixelSize * 0.558f);
        this.f60561d.setLayoutParams(layoutParams);
    }

    public View d() {
        return this.f60559b;
    }

    public void e(d.b.i0.t.d.a.a aVar) {
        f(aVar, this.n);
    }

    public void f(d.b.i0.t.d.a.a aVar, String str) {
        if (aVar != null && aVar.f60235e != null) {
            this.l = aVar;
            d().setVisibility(0);
            this.f60560c.W(aVar.f60235e.liveInfo.cover, 10, false);
            this.f60565h.setText(this.f60558a.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(aVar.f60235e.liveInfo.audienceCount)));
            this.f60564g.setText(aVar.f60235e.liveAuthor.name);
            this.i.setText(aVar.f60235e.title);
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.k = aVar.f60235e.recom_extra_img_dark;
            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.k = aVar.f60235e.recom_extra_img_night;
            } else {
                this.k = aVar.f60235e.recom_extra_img;
            }
            g(this.f60558a, TbadkCoreApplication.getInst().getSkinType());
            TiebaStatic.log(new StatisticItem("c12903").param(TiebaStatic.Params.ENTRY_NAME, str));
            return;
        }
        d().setVisibility(4);
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        if (this.j != i) {
            SkinManager.setViewTextColor(this.f60565h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60564g, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
            if (!StringUtils.isNull(this.k)) {
                this.f60563f.setVisibility(0);
                this.f60563f.W(this.k, 10, false);
            } else {
                this.f60563f.setVisibility(8);
            }
            Drawable drawable = SkinManager.getDrawable(this.f60558a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f60558a.getResources().getDimensionPixelOffset(R.dimen.tbds15), this.f60558a.getResources().getDimensionPixelOffset(R.dimen.tbds15));
            this.f60565h.setCompoundDrawablePadding(this.f60558a.getResources().getDimensionPixelSize(R.dimen.tbds14));
            this.f60565h.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.j = i;
        }
    }

    public void h(f fVar) {
        this.m = fVar;
    }
}
