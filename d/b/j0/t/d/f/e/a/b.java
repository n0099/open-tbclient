package d.b.j0.t.d.f.e.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import d.b.i0.z0.i0;
import d.b.j0.t.d.g.d.g;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f62553b;

    /* renamed from: c  reason: collision with root package name */
    public View f62554c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f62555d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62556e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62557f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f62558g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62559h;
    public TextView i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public a2 n;
    public g o;
    public String p;
    public AlphaAnimation r;
    public int u;
    public View.OnClickListener v;

    /* renamed from: a  reason: collision with root package name */
    public int f62552a = 3;
    public boolean q = false;
    public boolean s = true;
    public boolean t = false;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.t = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.t = true;
        }
    }

    /* renamed from: d.b.j0.t.d.f.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1630b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f62561a;

        public C1630b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && b.this.q && !b.this.t) {
                if (StringUtils.isNull(this.f62561a) || !this.f62561a.equals(str)) {
                    b bVar = b.this;
                    bVar.f62555d.startAnimation(bVar.r);
                    this.f62561a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (b.this.n == null || b.this.n.q1() == null || b.this.o == null) {
                    return;
                }
                b.this.o.a(b.this.l, b.this.m, b.this.n);
                return;
            }
            l.I(b.this.f62553b.getPageActivity(), b.this.f62553b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        BdUniqueId.gen();
        this.u = 0;
        this.v = new c();
        this.f62553b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f62554c = inflate;
        this.f62555d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f62556e = (TextView) this.f62554c.findViewById(R.id.tvLiveFrom);
        this.f62557f = (TextView) this.f62554c.findViewById(R.id.tvLiveCount);
        this.f62558g = (RelativeLayout) this.f62554c.findViewById(R.id.rlSquareLivePanel);
        this.f62559h = (TextView) this.f62554c.findViewById(R.id.tvUserName);
        this.i = (TextView) this.f62554c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f62554c.findViewById(R.id.challenge_root);
        this.f62554c.setOnClickListener(this.v);
        this.f62555d.setBorderSurroundContent(true);
        this.f62555d.setDrawBorder(true);
        this.k = (ImageView) this.f62554c.findViewById(R.id.live_redpacket_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new a());
    }

    public View j() {
        return this.f62554c;
    }

    public void k(d.b.j0.t.d.a.c cVar) {
        l(cVar, -1);
    }

    public void l(d.b.j0.t.d.a.c cVar, int i) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f62227h) != null && a2Var.q1() != null) {
            if (this.u != l.k(this.f62554c.getContext())) {
                this.u = l.k(this.f62554c.getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62558g.getLayoutParams();
                int dimensionPixelSize = (this.u - (this.f62554c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f62558g.setLayoutParams(layoutParams);
            }
            j().setVisibility(0);
            this.n = cVar.f62227h;
            this.l = cVar.f62224e;
            this.m = !TextUtils.isEmpty(cVar.f62226g) ? cVar.f62226g : cVar.f62225f;
            Object tag = this.f62555d.getTag();
            if (this.s) {
                this.q = true;
                this.s = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.n.q1().cover) && !((String) tag).equals(this.n.q1().cover)) {
                this.q = true;
            } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.q1().cover) && !this.p.equals(this.n.q1().cover)) {
                this.q = true;
            } else {
                this.q = false;
            }
            String str = this.n.q1().cover;
            this.p = str;
            this.f62555d.setTag(str);
            this.f62555d.W(this.n.q1().cover, 10, false);
            this.f62555d.setEvent(new C1630b());
            this.f62557f.setText(this.f62553b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.q1().audience_count)));
            if (this.n.T() != null) {
                String name_show = this.n.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f62559h.setText(name_show);
            }
            if (!StringUtils.isNull(this.n.U0)) {
                this.i.setVisibility(0);
                this.j.setVisibility(8);
                this.i.setText(this.n.U0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                float dimensionPixelSize2 = this.f62553b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                gradientDrawable.setColor(-50901);
                this.i.setBackgroundDrawable(gradientDrawable);
            } else if (this.n.q1().label != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float dimensionPixelSize3 = this.f62553b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                if (!StringUtils.isNull(this.n.q1().label.f51521b)) {
                    gradientDrawable2.setColor(Color.parseColor(this.n.q1().label.f51521b));
                }
                this.i.setBackgroundDrawable(gradientDrawable2);
                this.i.setText(this.n.q1().label.f51520a);
                this.i.setVisibility(0);
                this.j.setVisibility(8);
            } else if (this.n.q1().mChallengeInfoData != null && this.n.q1().mChallengeInfoData.challenge_id > 0) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                float dimensionPixelSize4 = this.f62553b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                gradientDrawable3.setColor(-50901);
                this.j.setBackground(gradientDrawable3);
                this.j.setVisibility(0);
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(8);
                this.j.setVisibility(8);
            }
            if (this.n.q1().haveRedpkg) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.n != null) {
                if (i == 2) {
                    TiebaStatic.log(new StatisticItem("c12899").param("tid", this.n.w1()));
                } else if (i == 1) {
                    TiebaStatic.log(new StatisticItem("c12903").param("tid", this.n.w1()));
                }
            }
            m(this.f62553b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        j().setVisibility(4);
    }

    public void m(TbPageContext<?> tbPageContext, int i) {
        if (this.f62552a != i) {
            SkinManager.setBackgroundResource(this.f62558g, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f62557f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f62559h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0111, 1, 0);
            SkinManager.getDrawable(this.f62553b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f62553b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f62553b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.f62557f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f62553b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f62552a = i;
        }
    }

    public void n(g gVar) {
        this.o = gVar;
    }
}
