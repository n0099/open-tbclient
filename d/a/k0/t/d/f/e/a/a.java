package d.a.k0.t.d.f.e.a;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import d.a.j0.z0.i0;
import d.a.k0.t.d.g.d.f;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61456b;

    /* renamed from: c  reason: collision with root package name */
    public View f61457c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f61458d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61459e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61460f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f61461g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61462h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61463i;
    public LinearLayout j;
    public ImageView k;
    public int l;
    public String m;
    public a2 n;
    public f o;
    public String p;
    public AlphaAnimation r;
    public int u;
    public View.OnClickListener v;

    /* renamed from: a  reason: collision with root package name */
    public int f61455a = 3;
    public boolean q = false;
    public boolean s = true;
    public boolean t = false;

    /* renamed from: d.a.k0.t.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1635a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1635a() {
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
        public String f61465a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && a.this.q && !a.this.t) {
                if (StringUtils.isNull(this.f61465a) || !this.f61465a.equals(str)) {
                    a aVar = a.this;
                    aVar.f61458d.startAnimation(aVar.r);
                    this.f61465a = str;
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
                if (a.this.n == null || a.this.n.q1() == null || a.this.o == null) {
                    return;
                }
                a.this.o.a(a.this.l, a.this.m, a.this.n);
                return;
            }
            l.J(a.this.f61456b.getPageActivity(), a.this.f61456b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        BdUniqueId.gen();
        this.u = 0;
        this.v = new c();
        this.f61456b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f61457c = inflate;
        this.f61458d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f61459e = (TextView) this.f61457c.findViewById(R.id.tvLiveFrom);
        this.f61460f = (TextView) this.f61457c.findViewById(R.id.tvLiveCount);
        this.f61461g = (RelativeLayout) this.f61457c.findViewById(R.id.rlSquareLivePanel);
        this.f61462h = (TextView) this.f61457c.findViewById(R.id.tvUserName);
        this.f61463i = (TextView) this.f61457c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f61457c.findViewById(R.id.challenge_root);
        this.f61457c.setOnClickListener(this.v);
        this.f61458d.setBorderSurroundContent(true);
        this.f61458d.setDrawBorder(true);
        this.k = (ImageView) this.f61457c.findViewById(R.id.live_redpacket_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1635a());
    }

    public View j() {
        return this.f61457c;
    }

    public void k(d.a.k0.t.d.a.c cVar) {
        l(cVar, -1);
    }

    public void l(d.a.k0.t.d.a.c cVar, int i2) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61129h) != null && a2Var.q1() != null) {
            if (this.u != l.k(this.f61457c.getContext())) {
                this.u = l.k(this.f61457c.getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61461g.getLayoutParams();
                int dimensionPixelSize = (this.u - (this.f61457c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f61461g.setLayoutParams(layoutParams);
            }
            j().setVisibility(0);
            this.n = cVar.f61129h;
            this.l = cVar.f61126e;
            this.m = !TextUtils.isEmpty(cVar.f61128g) ? cVar.f61128g : cVar.f61127f;
            Object tag = this.f61458d.getTag();
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
            this.f61458d.setTag(str);
            this.f61458d.V(this.n.q1().cover, 10, false);
            this.f61458d.setEvent(new b());
            this.f61460f.setText(this.f61456b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.q1().audience_count)));
            if (this.n.T() != null) {
                String name_show = this.n.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f61462h.setText(name_show);
            }
            if (!StringUtils.isNull(this.n.U0)) {
                this.f61463i.setVisibility(0);
                this.j.setVisibility(8);
                this.f61463i.setText(this.n.U0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                float dimensionPixelSize2 = this.f61456b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                gradientDrawable.setColor(-50901);
                this.f61463i.setBackgroundDrawable(gradientDrawable);
            } else if (this.n.q1().label != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float dimensionPixelSize3 = this.f61456b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                if (!StringUtils.isNull(this.n.q1().label.f49966b)) {
                    gradientDrawable2.setColor(Color.parseColor(this.n.q1().label.f49966b));
                }
                this.f61463i.setBackgroundDrawable(gradientDrawable2);
                this.f61463i.setText(this.n.q1().label.f49965a);
                this.f61463i.setVisibility(0);
                this.j.setVisibility(8);
            } else if (this.n.q1().mChallengeInfoData != null && this.n.q1().mChallengeInfoData.challenge_id > 0) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                float dimensionPixelSize4 = this.f61456b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                gradientDrawable3.setColor(-50901);
                this.j.setBackground(gradientDrawable3);
                this.j.setVisibility(0);
                this.f61463i.setVisibility(8);
            } else {
                this.f61463i.setVisibility(8);
                this.j.setVisibility(8);
            }
            if (this.n.q1().haveRedpkg) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.n != null) {
                if (i2 == 2) {
                    TiebaStatic.log(new StatisticItem("c12899").param("tid", this.n.x1()));
                } else if (i2 == 1) {
                    TiebaStatic.log(new StatisticItem("c12903").param("tid", this.n.x1()));
                }
            }
            m(this.f61456b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        j().setVisibility(4);
    }

    public void m(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61455a != i2) {
            SkinManager.setBackgroundResource(this.f61461g, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61460f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61462h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61463i, R.color.CAM_X0111, 1, 0);
            SkinManager.getDrawable(this.f61456b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f61456b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f61456b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.f61460f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f61456b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f61455a = i2;
        }
    }

    public void n(f fVar) {
        this.o = fVar;
    }
}
