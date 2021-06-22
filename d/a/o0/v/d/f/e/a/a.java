package d.a.o0.v.d.f.e.a;

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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.n0.r.q.a2;
import d.a.n0.z0.i0;
import d.a.o0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65583b;

    /* renamed from: c  reason: collision with root package name */
    public View f65584c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f65585d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65586e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f65587f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f65588g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65589h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f65590i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public a2 n;
    public f o;
    public String p;
    public AlphaAnimation r;
    public int u;
    public TbImageView v;
    public int w;
    public View.OnClickListener x;

    /* renamed from: a  reason: collision with root package name */
    public int f65582a = 3;
    public boolean q = false;
    public boolean s = true;
    public boolean t = false;

    /* renamed from: d.a.o0.v.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1716a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1716a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.t = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            a.this.t = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f65592a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && a.this.q && !a.this.t) {
                if (StringUtils.isNull(this.f65592a) || !this.f65592a.equals(str)) {
                    a aVar = a.this;
                    aVar.f65585d.startAnimation(aVar.r);
                    this.f65592a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbImageView.f {
        public c() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                a aVar = a.this;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(aVar.l(aVar.v.getLoadedHeight(), a.this.v.getLoadedWidth()), a.this.w);
                layoutParams.addRule(11);
                layoutParams.rightMargin = a.this.f65583b.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                a.this.v.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (a.this.n == null || a.this.n.s1() == null || a.this.o == null) {
                    return;
                }
                a.this.o.a(a.this.l, a.this.m, a.this.n);
                return;
            }
            l.J(a.this.f65583b.getPageActivity(), a.this.f65583b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        BdUniqueId.gen();
        this.u = 0;
        this.w = 0;
        this.x = new d();
        this.f65583b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f65584c = inflate;
        this.f65585d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f65586e = (TextView) this.f65584c.findViewById(R.id.tvLiveFrom);
        this.f65587f = (TextView) this.f65584c.findViewById(R.id.tvLiveCount);
        this.f65588g = (RelativeLayout) this.f65584c.findViewById(R.id.rlSquareLivePanel);
        this.f65589h = (TextView) this.f65584c.findViewById(R.id.tvUserName);
        this.f65590i = (TextView) this.f65584c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f65584c.findViewById(R.id.challenge_root);
        this.f65584c.setOnClickListener(this.x);
        this.f65585d.setBorderSurroundContent(true);
        this.f65585d.setDrawBorder(true);
        this.k = (ImageView) this.f65584c.findViewById(R.id.live_redpacket_label);
        this.v = (TbImageView) this.f65584c.findViewById(R.id.live_status_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1716a());
        this.w = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
    }

    public final int l(int i2, int i3) {
        return (int) (this.w * (i3 / i2));
    }

    public View m() {
        return this.f65584c;
    }

    public void n(d.a.o0.v.d.a.c cVar) {
        o(cVar, -1);
    }

    public void o(d.a.o0.v.d.a.c cVar, int i2) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65255h) != null && a2Var.s1() != null) {
            if (this.u != l.k(this.f65584c.getContext())) {
                this.u = l.k(this.f65584c.getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65588g.getLayoutParams();
                int dimensionPixelSize = (this.u - (this.f65584c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f65588g.setLayoutParams(layoutParams);
            }
            m().setVisibility(0);
            this.n = cVar.f65255h;
            this.l = cVar.f65252e;
            this.m = !TextUtils.isEmpty(cVar.f65254g) ? cVar.f65254g : cVar.f65253f;
            Object tag = this.f65585d.getTag();
            if (this.s) {
                this.q = true;
                this.s = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.n.s1().cover) && !((String) tag).equals(this.n.s1().cover)) {
                this.q = true;
            } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.s1().cover) && !this.p.equals(this.n.s1().cover)) {
                this.q = true;
            } else {
                this.q = false;
            }
            String str = this.n.s1().cover;
            this.p = str;
            this.f65585d.setTag(str);
            this.f65585d.U(this.n.s1().cover, 10, false);
            this.f65585d.setEvent(new b());
            if (!StringUtils.isNull(this.n.K2)) {
                this.v.setVisibility(0);
                this.v.U(this.n.K2, 10, false);
                this.v.setEvent(new c());
            } else {
                this.v.setVisibility(8);
            }
            this.f65587f.setText(this.f65583b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.s1().audience_count)));
            if (this.n.T() != null) {
                String name_show = this.n.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f65589h.setText(name_show);
            }
            if (!StringUtils.isNull(this.n.W0)) {
                this.f65590i.setVisibility(0);
                this.j.setVisibility(8);
                this.f65590i.setText(this.n.W0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                float dimensionPixelSize2 = this.f65583b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                gradientDrawable.setColor(-50901);
                this.f65590i.setBackgroundDrawable(gradientDrawable);
            } else if (this.n.s1().label != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float dimensionPixelSize3 = this.f65583b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                if (!StringUtils.isNull(this.n.s1().label.f53793b)) {
                    gradientDrawable2.setColor(Color.parseColor(this.n.s1().label.f53793b));
                }
                this.f65590i.setBackgroundDrawable(gradientDrawable2);
                this.f65590i.setText(this.n.s1().label.f53792a);
                this.f65590i.setVisibility(0);
                this.j.setVisibility(8);
            } else if (this.n.s1().mChallengeInfoData != null && this.n.s1().mChallengeInfoData.challenge_id > 0) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                float dimensionPixelSize4 = this.f65583b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                gradientDrawable3.setColor(-50901);
                this.j.setBackground(gradientDrawable3);
                this.j.setVisibility(0);
                this.f65590i.setVisibility(8);
            } else {
                this.f65590i.setVisibility(8);
                this.j.setVisibility(8);
            }
            if (this.n.s1().haveRedpkg) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.n != null) {
                if (i2 == 2) {
                    StatisticItem param = new StatisticItem("c12899").param("tid", this.n.z1());
                    TiebaStaticHelper.addYYParam(param);
                    TiebaStatic.log(param);
                } else if (i2 == 1) {
                    StatisticItem param2 = new StatisticItem("c12903").param("tid", this.n.z1());
                    TiebaStaticHelper.addYYParam(param2);
                    TiebaStatic.log(param2);
                }
            }
            p(this.f65583b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        m().setVisibility(4);
    }

    public void p(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65582a != i2) {
            SkinManager.setBackgroundResource(this.f65588g, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f65587f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65589h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65590i, R.color.CAM_X0111, 1, 0);
            SkinManager.getDrawable(this.f65583b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f65583b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f65583b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.f65587f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f65583b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f65582a = i2;
        }
    }

    public void q(f fVar) {
        this.o = fVar;
    }
}
