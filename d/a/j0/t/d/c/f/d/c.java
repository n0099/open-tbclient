package d.a.j0.t.d.c.f.d;

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
import d.a.i0.r.q.a2;
/* loaded from: classes4.dex */
public class c {
    public static final float t;
    public static final float[] u;
    public static final float[] v;
    public static final float[] w;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f60552b;

    /* renamed from: c  reason: collision with root package name */
    public View f60553c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f60554d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60555e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f60556f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60557g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f60558h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f60559i;
    public a2 k;
    public d.a.j0.t.d.a.c l;
    public i m;
    public String n;
    public AlphaAnimation p;
    public View.OnClickListener s;

    /* renamed from: a  reason: collision with root package name */
    public int f60551a = 3;
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
        public String f60561a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && c.this.o && !c.this.r) {
                if (StringUtils.isNull(this.f60561a) || !this.f60561a.equals(str)) {
                    c cVar = c.this;
                    cVar.f60554d.startAnimation(cVar.p);
                    this.f60561a = str;
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* renamed from: d.a.j0.t.d.c.f.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1561c implements View.OnClickListener {
        public View$OnClickListenerC1561c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.z()) {
                if (c.this.l == null || c.this.l.f60405h == null || c.this.m == null) {
                    return;
                }
                c.this.m.a(c.this.l);
                return;
            }
            l.J(c.this.f60552b.getPageActivity(), c.this.f60552b.getPageActivity().getString(R.string.no_network_guide));
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
        this.s = new View$OnClickListenerC1561c();
        this.f60552b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_live_item_view, (ViewGroup) null, false);
        this.f60553c = inflate;
        this.f60554d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f60555e = (TextView) this.f60553c.findViewById(R.id.tvLiveCount);
        this.f60556f = (RelativeLayout) this.f60553c.findViewById(R.id.rlSquareLivePanel);
        this.f60557g = (TextView) this.f60553c.findViewById(R.id.tvUserName);
        this.f60558h = (LinearLayout) this.f60553c.findViewById(R.id.tvUserNameWrapper);
        HeadImageView headImageView = (HeadImageView) this.f60553c.findViewById(R.id.ivUserAvatar);
        this.f60559i = headImageView;
        headImageView.setIsRound(true);
        this.f60559i.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f60553c.setOnClickListener(this.s);
        this.f60554d.setBorderSurroundContent(true);
        this.f60554d.setDrawBorder(true);
        this.f60554d.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60556f.getLayoutParams();
        int k = ((l.k(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = k;
        layoutParams.height = k;
        this.f60556f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.p = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.p.setAnimationListener(new a());
    }

    public View h() {
        return this.f60553c;
    }

    public void i(d.a.j0.t.d.a.c cVar) {
        j(cVar, -1);
    }

    public void j(d.a.j0.t.d.a.c cVar, int i2) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f60405h) != null && a2Var.q1() != null) {
            h().setVisibility(0);
            this.l = cVar;
            this.k = cVar.f60405h;
            int i3 = cVar.f60402e;
            if (TextUtils.isEmpty(cVar.f60404g)) {
                String str = cVar.f60403f;
            } else {
                String str2 = cVar.f60404g;
            }
            Object tag = this.f60554d.getTag();
            if (this.q) {
                this.o = true;
                this.q = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.k.q1().cover) && !((String) tag).equals(this.k.q1().cover)) {
                this.o = true;
            } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.q1().cover) && !this.n.equals(this.k.q1().cover)) {
                this.o = true;
            } else {
                this.o = false;
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
            String str3 = this.k.q1().cover;
            this.n = str3;
            this.f60554d.setTag(str3);
            if (cVar.k) {
                this.f60554d.setConrers(5);
                gradientDrawable.setCornerRadii(v);
                this.f60554d.setPlaceHolder(3);
            } else if (cVar.l) {
                this.f60554d.setConrers(10);
                gradientDrawable.setCornerRadii(w);
                this.f60554d.setPlaceHolder(3);
            } else if (cVar.m) {
                this.f60554d.setConrers(15);
                gradientDrawable.setCornerRadii(u);
                this.f60554d.setPlaceHolder(3);
            }
            this.f60554d.setRadius((int) t);
            this.f60554d.V(this.k.q1().cover, 10, false);
            this.f60558h.setBackgroundDrawable(gradientDrawable);
            this.f60554d.setEvent(new b());
            this.f60555e.setText(this.f60552b.getPageActivity().getResources().getString(R.string.live_tab_audience_label, StringHelper.numberUniformFormatExtraWithRound(this.k.q1().audience_count)));
            if (this.k.T() != null) {
                String name_show = this.k.T().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    this.f60557g.setText(name_show);
                }
                this.f60559i.V(this.k.T().getPortrait(), 12, false);
            }
            k(this.f60552b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        h().setVisibility(4);
    }

    public void k(TbPageContext<?> tbPageContext, int i2) {
        if (this.f60551a != i2) {
            SkinManager.setViewTextColor(this.f60555e, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f60557g, R.color.CAM_X0101);
            if (i2 == 1) {
                this.f60559i.setBorderColor(this.f60552b.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f60559i.setBorderColor(this.f60552b.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f60552b.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f60552b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f60552b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f60555e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f60555e.setCompoundDrawablePadding(this.f60552b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.f60551a = i2;
        }
    }

    public void l(i iVar) {
        this.m = iVar;
    }
}
