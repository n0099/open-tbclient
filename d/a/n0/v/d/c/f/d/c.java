package d.a.n0.v.d.c.f.d;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class c {
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65277b;

    /* renamed from: c  reason: collision with root package name */
    public View f65278c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f65279d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65280e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f65281f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f65282g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f65283h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f65284i;
    public a2 k;
    public d.a.n0.v.d.a.c l;
    public i m;
    public String n;
    public AlphaAnimation p;
    public View.OnClickListener s;

    /* renamed from: a  reason: collision with root package name */
    public int f65276a = 3;
    public int[] j = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    public boolean o = false;
    public boolean q = true;
    public boolean r = false;

    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c.this.r = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            c.this.r = true;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TbImageView.f {

        /* renamed from: a  reason: collision with root package name */
        public String f65286a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && c.this.o && !c.this.r) {
                if (StringUtils.isNull(this.f65286a) || !this.f65286a.equals(str)) {
                    c cVar = c.this;
                    cVar.f65279d.startAnimation(cVar.p);
                    this.f65286a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* renamed from: d.a.n0.v.d.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1703c implements View.OnClickListener {
        public View$OnClickListenerC1703c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (c.this.l == null || c.this.l.f65130h == null || c.this.m == null) {
                    return;
                }
                c.this.m.a(c.this.l);
                return;
            }
            l.J(c.this.f65277b.getPageActivity(), c.this.f65277b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    static {
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        t = dimension;
        u = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public c(TbPageContext<?> tbPageContext) {
        BdUniqueId.gen();
        this.s = new View$OnClickListenerC1703c();
        this.f65277b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f65278c = inflate;
        this.f65279d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f65280e = (TextView) this.f65278c.findViewById(R.id.tvLiveCount);
        this.f65281f = (RelativeLayout) this.f65278c.findViewById(R.id.rlSquareLivePanel);
        this.f65282g = (TextView) this.f65278c.findViewById(R.id.tvUserName);
        this.f65283h = (LinearLayout) this.f65278c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f65278c.findViewById(R.id.ivUserAvatar);
        this.f65284i = headImageView;
        headImageView.setIsRound(true);
        this.f65284i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f65278c.setOnClickListener(this.s);
        this.f65279d.setBorderSurroundContent(true);
        this.f65279d.setDrawBorder(true);
        this.f65279d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65281f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f65281f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a());
    }

    public View h() {
        return this.f65278c;
    }

    public void i(d.a.n0.v.d.a.c cVar) {
        j(cVar, -1);
    }

    public void j(d.a.n0.v.d.a.c cVar, int i2) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f65130h) != null && a2Var.s1() != null) {
            h().setVisibility(0);
            this.l = cVar;
            this.k = cVar.f65130h;
            int i3 = cVar.f65127e;
            if (TextUtils.isEmpty(cVar.f65129g)) {
                String str = cVar.f65128f;
            } else {
                String str2 = cVar.f65129g;
            }
            Object tag = this.f65279d.getTag();
            if (this.q) {
                this.o = true;
                this.q = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.k.s1().cover) && !((String) tag).equals(this.k.s1().cover)) {
                this.o = true;
            } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.s1().cover) && !this.n.equals(this.k.s1().cover)) {
                this.o = true;
            } else {
                this.o = false;
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
            String str3 = this.k.s1().cover;
            this.n = str3;
            this.f65279d.setTag(str3);
            if (cVar.k) {
                this.f65279d.setConrers(5);
                gradientDrawable.setCornerRadii(v);
                this.f65279d.setPlaceHolder(3);
            } else if (cVar.l) {
                this.f65279d.setConrers(10);
                gradientDrawable.setCornerRadii(w);
                this.f65279d.setPlaceHolder(3);
            } else if (cVar.m) {
                this.f65279d.setConrers(15);
                gradientDrawable.setCornerRadii(u);
                this.f65279d.setPlaceHolder(3);
            }
            this.f65279d.setRadius((int) t);
            this.f65279d.U(this.k.s1().cover, 10, false);
            this.f65283h.setBackgroundDrawable(gradientDrawable);
            this.f65279d.setEvent(new b());
            this.f65280e.setText(this.f65277b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.s1().audience_count)));
            if (this.k.T() != null) {
                String name_show = this.k.T().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    this.f65282g.setText(name_show);
                }
                this.f65284i.U(this.k.T().getPortrait(), 12, false);
            }
            k(this.f65277b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        h().setVisibility(4);
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        if (this.f65276a != i2) {
            SkinManager.setViewTextColor(this.f65280e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f65282g, R.color.CAM_X0101);
            if (i2 == 1) {
                this.f65284i.setBorderColor(this.f65277b.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f65284i.setBorderColor(this.f65277b.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f65277b.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f65277b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f65277b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f65280e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f65280e.setCompoundDrawablePadding(this.f65277b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f65276a = i2;
        }
    }

    public void l(i iVar) {
        this.m = iVar;
    }
}
