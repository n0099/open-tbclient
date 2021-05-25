package d.a.n0.v.d.f.e.a;

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
import d.a.m0.r.q.a2;
import d.a.m0.z0.i0;
import d.a.n0.v.d.g.d.f;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61744b;

    /* renamed from: c  reason: collision with root package name */
    public View f61745c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f61746d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61747e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61748f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f61749g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61750h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61751i;
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
    public int f61743a = 3;
    public boolean q = false;
    public boolean s = true;
    public boolean t = false;

    /* renamed from: d.a.n0.v.d.f.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1655a implements Animation.AnimationListener {
        public animation.Animation$AnimationListenerC1655a() {
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
        public String f61753a;

        public b() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z && a.this.q && !a.this.t) {
                if (StringUtils.isNull(this.f61753a) || !this.f61753a.equals(str)) {
                    a aVar = a.this;
                    aVar.f61746d.startAnimation(aVar.r);
                    this.f61753a = str;
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
                if (a.this.n == null || a.this.n.r1() == null || a.this.o == null) {
                    return;
                }
                a.this.o.a(a.this.l, a.this.m, a.this.n);
                return;
            }
            l.J(a.this.f61744b.getPageActivity(), a.this.f61744b.getPageActivity().getString(R.string.no_network_guide));
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        BdUniqueId.gen();
        this.u = 0;
        this.v = new c();
        this.f61744b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.f61745c = inflate;
        this.f61746d = (TbImageView) inflate.findViewById(R.id.imgSquareView);
        this.f61747e = (TextView) this.f61745c.findViewById(R.id.tvLiveFrom);
        this.f61748f = (TextView) this.f61745c.findViewById(R.id.tvLiveCount);
        this.f61749g = (RelativeLayout) this.f61745c.findViewById(R.id.rlSquareLivePanel);
        this.f61750h = (TextView) this.f61745c.findViewById(R.id.tvUserName);
        this.f61751i = (TextView) this.f61745c.findViewById(R.id.tv_extra);
        this.j = (LinearLayout) this.f61745c.findViewById(R.id.challenge_root);
        this.f61745c.setOnClickListener(this.v);
        this.f61746d.setBorderSurroundContent(true);
        this.f61746d.setDrawBorder(true);
        this.k = (ImageView) this.f61745c.findViewById(R.id.live_redpacket_label);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.r = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.r.setAnimationListener(new animation.Animation$AnimationListenerC1655a());
    }

    public View j() {
        return this.f61745c;
    }

    public void k(d.a.n0.v.d.a.c cVar) {
        l(cVar, -1);
    }

    public void l(d.a.n0.v.d.a.c cVar, int i2) {
        a2 a2Var;
        if (cVar != null && (a2Var = cVar.f61417h) != null && a2Var.r1() != null) {
            if (this.u != l.k(this.f61745c.getContext())) {
                this.u = l.k(this.f61745c.getContext());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61749g.getLayoutParams();
                int dimensionPixelSize = (this.u - (this.f61745c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f61749g.setLayoutParams(layoutParams);
            }
            j().setVisibility(0);
            this.n = cVar.f61417h;
            this.l = cVar.f61414e;
            this.m = !TextUtils.isEmpty(cVar.f61416g) ? cVar.f61416g : cVar.f61415f;
            Object tag = this.f61746d.getTag();
            if (this.s) {
                this.q = true;
                this.s = false;
            } else if ((tag instanceof String) && !StringUtils.isNull(this.n.r1().cover) && !((String) tag).equals(this.n.r1().cover)) {
                this.q = true;
            } else if (!StringUtils.isNull(this.p) && !StringUtils.isNull(this.n.r1().cover) && !this.p.equals(this.n.r1().cover)) {
                this.q = true;
            } else {
                this.q = false;
            }
            String str = this.n.r1().cover;
            this.p = str;
            this.f61746d.setTag(str);
            this.f61746d.V(this.n.r1().cover, 10, false);
            this.f61746d.setEvent(new b());
            this.f61748f.setText(this.f61744b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.n.r1().audience_count)));
            if (this.n.T() != null) {
                String name_show = this.n.T().getName_show();
                if (i0.d(name_show) > 10) {
                    name_show = i0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f61750h.setText(name_show);
            }
            if (!StringUtils.isNull(this.n.V0)) {
                this.f61751i.setVisibility(0);
                this.j.setVisibility(8);
                this.f61751i.setText(this.n.V0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                float dimensionPixelSize2 = this.f61744b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
                gradientDrawable.setColor(-50901);
                this.f61751i.setBackgroundDrawable(gradientDrawable);
            } else if (this.n.r1().label != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                float dimensionPixelSize3 = this.f61744b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
                if (!StringUtils.isNull(this.n.r1().label.f50010b)) {
                    gradientDrawable2.setColor(Color.parseColor(this.n.r1().label.f50010b));
                }
                this.f61751i.setBackgroundDrawable(gradientDrawable2);
                this.f61751i.setText(this.n.r1().label.f50009a);
                this.f61751i.setVisibility(0);
                this.j.setVisibility(8);
            } else if (this.n.r1().mChallengeInfoData != null && this.n.r1().mChallengeInfoData.challenge_id > 0) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                float dimensionPixelSize4 = this.f61744b.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
                gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize4, dimensionPixelSize4, 0.0f, 0.0f});
                gradientDrawable3.setColor(-50901);
                this.j.setBackground(gradientDrawable3);
                this.j.setVisibility(0);
                this.f61751i.setVisibility(8);
            } else {
                this.f61751i.setVisibility(8);
                this.j.setVisibility(8);
            }
            if (this.n.r1().haveRedpkg) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            if (this.n != null) {
                if (i2 == 2) {
                    TiebaStatic.log(new StatisticItem("c12899").param("tid", this.n.y1()));
                } else if (i2 == 1) {
                    TiebaStatic.log(new StatisticItem("c12903").param("tid", this.n.y1()));
                }
            }
            m(this.f61744b, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        j().setVisibility(4);
    }

    public void m(TbPageContext<?> tbPageContext, int i2) {
        if (this.f61743a != i2) {
            SkinManager.setBackgroundResource(this.f61749g, R.drawable.addresslist_item_bg);
            SkinManager.setViewTextColor(this.f61748f, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61750h, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f61751i, R.color.CAM_X0111, 1, 0);
            SkinManager.getDrawable(this.f61744b.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.f61744b.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.f61744b.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.f61748f.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(this.f61744b.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f61743a = i2;
        }
    }

    public void n(f fVar) {
        this.o = fVar;
    }
}
