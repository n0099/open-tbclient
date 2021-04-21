package d.b.j0.i2.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.z0.l0;
import d.b.j0.i2.e.q;
import d.b.j0.s1.c;
import tbclient.BaijiahaoInfo;
/* loaded from: classes3.dex */
public class a {
    public static final int b0 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    public HeadPendantView A;
    public RelativeLayout B;
    public GodRecommendLayout C;
    public ImageView D;
    public TBLottieAnimationView E;
    public AnimatorSet F;
    public View G;
    public View.OnClickListener H;
    public ViewGroup I;
    public View J;
    public TextView K;
    public ImageView L;
    public View M;
    public TextView N;
    public ImageView O;
    public d.b.j0.s1.c P;
    public boolean Q;
    public AnimatorSet R;
    public ValueAnimator S;
    public ObjectAnimator T;
    public ObjectAnimator U;
    public d.b.j0.i2.d.a V;
    public boolean W;
    public boolean X;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57600a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57601b;

    /* renamed from: c  reason: collision with root package name */
    public View f57602c;

    /* renamed from: d  reason: collision with root package name */
    public UserData f57603d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.w0.b f57604e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57605f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57606g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57607h;
    public ImageView i;
    public UserIconBox j;
    public FrameLayout k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public FollowUserSpinnerBtn w;
    public TBSpecificationBtn x;
    public TbImageView y;
    public ImageView z;
    public FollowUserSpinnerBtn.b Y = new C1368a();
    public c.b Z = new b();
    public View.OnClickListener a0 = new c();

    /* renamed from: d.b.j0.i2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1368a implements FollowUserSpinnerBtn.b {
        public C1368a() {
        }

        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.b
        public void a(boolean z, boolean z2) {
            if (ViewHelper.checkUpIsLogin(a.this.f57600a.getPageActivity())) {
                a.this.W = z2;
                a.this.X = false;
                if (z) {
                    a.this.C.setCouldStatistic(true);
                    if (a.this.f57603d != null) {
                        a.this.P.i(a.this.f57603d.getPortrait(), 0);
                    }
                } else {
                    a.this.C.setCouldStatistic(false);
                    a.this.Q = false;
                    a.this.J();
                    if (a.this.R != null) {
                        a.this.R.start();
                    }
                }
                if (!z || z2) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13900"));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.b {
        public b() {
        }

        @Override // d.b.j0.s1.c.b
        public void a(q qVar, int i) {
            if (qVar == null || i != 0) {
                if (i == 1) {
                    BdToast.c(a.this.f57600a.getPageActivity(), a.this.f57600a.getPageActivity().getText(R.string.god_get_error)).q();
                    return;
                } else if (i == 3) {
                    BdToast.c(a.this.f57600a.getPageActivity(), a.this.f57600a.getPageActivity().getText(R.string.god_get_refresh_error)).q();
                    return;
                } else {
                    BdToast.c(a.this.f57600a.getPageActivity(), a.this.f57600a.getPageActivity().getText(R.string.god_get_limit_error)).q();
                    return;
                }
            }
            a.this.C.setData(qVar.a());
            if (!a.this.X) {
                a.this.Q = true;
                a.this.J();
                if (a.this.R != null) {
                    a.this.R.start();
                }
            }
            TiebaStatic.log(new StatisticItem("c13901").param("obj_type", a.this.W ? 1 : 2));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.P != null && a.this.f57603d != null) {
                a.this.X = true;
                a.this.P.h(a.this.f57603d.getPortrait());
            }
            TiebaStatic.log(new StatisticItem("c13904"));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * a.b0;
            ViewGroup.LayoutParams layoutParams = a.this.C.getLayoutParams();
            if (a.this.Q) {
                layoutParams.height = (int) floatValue;
            } else {
                layoutParams.height = (int) (a.b0 - floatValue);
            }
            if (a.this.V != null) {
                d.b.j0.i2.d.a aVar = a.this.V;
                if (!a.this.Q) {
                    floatValue = -floatValue;
                }
                aVar.a((int) floatValue);
            }
            a.this.C.setLayoutParams(layoutParams);
            a.this.C.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ViewGroup.LayoutParams layoutParams = a.this.C.getLayoutParams();
            if (a.this.Q) {
                layoutParams.height = a.b0;
            } else {
                layoutParams.height = 0;
            }
            a.this.C.setLayoutParams(layoutParams);
            if (a.this.V != null) {
                a.this.V.b(a.this.Q);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaijiahaoInfo f57613e;

        public f(BaijiahaoInfo baijiahaoInfo) {
            this.f57613e = baijiahaoInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout = a.this.f57606g.getLayout();
            if (layout != null) {
                int lineCount = layout.getLineCount();
                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                    if (!a.this.f57601b) {
                        a.this.f57606g.setEnabled(false);
                    } else {
                        BaijiahaoInfo baijiahaoInfo = this.f57613e;
                        if (baijiahaoInfo != null && !k.isEmpty(baijiahaoInfo.auth_desc)) {
                            a.this.f57606g.setEnabled(false);
                        }
                    }
                    a.this.f57607h.setVisibility(8);
                    return;
                }
                a.this.f57607h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.E.playAnimation();
        }
    }

    public a(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.f57600a = tbPageContext;
        this.f57601b = z;
        this.H = onClickListener;
        G();
        F();
    }

    public View A() {
        return this.M;
    }

    public View B() {
        return this.J;
    }

    public UserIconBox C() {
        return this.j;
    }

    public TextView D() {
        return this.f57605f;
    }

    public View E() {
        return this.f57602c;
    }

    public final void F() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.S = ofFloat;
        ofFloat.addUpdateListener(new d());
        this.S.setDuration(260L);
        this.S.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.C, "alpha", 0.0f);
        this.T = ofFloat2;
        ofFloat2.setDuration(240L);
        this.T.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w.getArrow(), "rotation", 0.0f);
        this.U = ofFloat3;
        ofFloat3.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.R = animatorSet;
        animatorSet.addListener(new e());
        this.R.play(this.S).with(this.T).with(this.U);
    }

    public final void G() {
        View inflate = LayoutInflater.from(this.f57600a.getPageActivity()).inflate(R.layout.person_header_layout, (ViewGroup) null);
        this.f57602c = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.person_user_name);
        this.f57605f = textView;
        textView.setOnClickListener(this.H);
        TextView textView2 = (TextView) this.f57602c.findViewById(R.id.person_introduction);
        this.f57606g = textView2;
        textView2.setAlpha(0.85f);
        this.f57606g.setOnClickListener(this.H);
        ImageView imageView = (ImageView) this.f57602c.findViewById(R.id.person_header_intro_more_icon);
        this.f57607h = imageView;
        imageView.setOnClickListener(this.H);
        UserIconBox userIconBox = (UserIconBox) this.f57602c.findViewById(R.id.person_header_label_box);
        this.j = userIconBox;
        userIconBox.setOnClickListener(this.H);
        this.j.setAutoChangedStyle(false);
        this.l = (TextView) this.f57602c.findViewById(R.id.person_header_fans_num);
        FrameLayout frameLayout = (FrameLayout) this.f57602c.findViewById(R.id.person_header_fans_layout);
        this.k = frameLayout;
        frameLayout.setOnClickListener(this.H);
        TextView textView3 = (TextView) this.f57602c.findViewById(R.id.person_header_fans_suffix);
        this.m = textView3;
        textView3.setAlpha(0.8f);
        this.u = (ImageView) this.f57602c.findViewById(R.id.person_header_fans_icon);
        this.i = (ImageView) this.f57602c.findViewById(R.id.person_header_fans_red_tip);
        this.o = (TextView) this.f57602c.findViewById(R.id.person_header_attention_num);
        FrameLayout frameLayout2 = (FrameLayout) this.f57602c.findViewById(R.id.person_header_attention_layout);
        this.n = frameLayout2;
        frameLayout2.setOnClickListener(this.H);
        TextView textView4 = (TextView) this.f57602c.findViewById(R.id.person_header_attention_suffix);
        this.p = textView4;
        textView4.setAlpha(0.8f);
        this.v = (ImageView) this.f57602c.findViewById(R.id.person_header_attention_icon);
        this.r = (TextView) this.f57602c.findViewById(R.id.person_header_forum_num);
        FrameLayout frameLayout3 = (FrameLayout) this.f57602c.findViewById(R.id.person_header_forum_layout);
        this.q = frameLayout3;
        frameLayout3.setOnClickListener(this.H);
        TextView textView5 = (TextView) this.f57602c.findViewById(R.id.person_header_forum_suffix);
        this.s = textView5;
        textView5.setAlpha(0.8f);
        this.t = (ImageView) this.f57602c.findViewById(R.id.person_header_forum_icon);
        FollowUserSpinnerBtn followUserSpinnerBtn = (FollowUserSpinnerBtn) this.f57602c.findViewById(R.id.person_attention_btn);
        this.w = followUserSpinnerBtn;
        followUserSpinnerBtn.c(this.H);
        this.w.setOpenListener(this.Y);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f57602c.findViewById(R.id.person_gift_icon_btn);
        this.x = tBSpecificationBtn;
        tBSpecificationBtn.setOnClickListener(this.H);
        d.b.i0.r.f0.m.d dVar = new d.b.i0.r.f0.m.d();
        dVar.o(R.color.CAM_X0101);
        dVar.g(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
        dVar.s(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
        this.x.setConfig(dVar);
        TbImageView tbImageView = (TbImageView) this.f57602c.findViewById(R.id.person_user_vip_icon);
        this.y = tbImageView;
        tbImageView.setOnClickListener(this.H);
        this.z = (ImageView) this.f57602c.findViewById(R.id.person_user_sex_icon);
        HeadPendantView headPendantView = (HeadPendantView) this.f57602c.findViewById(R.id.person_header_header_view);
        this.A = headPendantView;
        headPendantView.setHasPendantStyle();
        this.A.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.A.getHeadView().setIsRound(true);
        this.A.getHeadView().setDrawBorder(false);
        this.A.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.A.setOnClickListener(this.H);
        this.A.setBigVDimenSize(R.dimen.tbds57);
        this.A.setAuthIconType(3);
        this.A.setShowSimpleIcon(false);
        this.A.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
        View findViewById = this.f57602c.findViewById(R.id.person_header_ring);
        this.G = findViewById;
        findViewById.setAlpha(0.33f);
        GodRecommendLayout godRecommendLayout = (GodRecommendLayout) this.f57602c.findViewById(R.id.recommend_god);
        this.C = godRecommendLayout;
        godRecommendLayout.setPageContext(this.f57600a);
        this.C.setPageUniqueId(this.f57600a.getUniqueId());
        this.C.setRefreshListener(this.a0);
        d.b.j0.s1.c cVar = new d.b.j0.s1.c(this.f57600a.getUniqueId());
        this.P = cVar;
        cVar.j(this.Z);
        this.I = (ViewGroup) this.f57602c.findViewById(R.id.person_center_my_extra_layout);
        this.J = this.f57602c.findViewById(R.id.person_center_my_store_layout);
        this.K = (TextView) this.f57602c.findViewById(R.id.btn_person_center_my_store_text);
        this.L = (ImageView) this.f57602c.findViewById(R.id.btn_person_center_my_store_img);
        this.J.setOnClickListener(this.H);
        this.M = this.f57602c.findViewById(R.id.person_center_my_friends_room_layout);
        this.N = (TextView) this.f57602c.findViewById(R.id.btn_person_center_my_friends_room_text);
        this.O = (ImageView) this.f57602c.findViewById(R.id.btn_person_center_my_friends_room_img);
        this.M.setOnClickListener(this.H);
        this.D = (ImageView) this.f57602c.findViewById(R.id.person_header_ala_live);
        this.E = (TBLottieAnimationView) this.f57602c.findViewById(R.id.living_bg_lottie);
        this.B = (RelativeLayout) this.f57602c.findViewById(R.id.userheaderview_container);
        H(TbadkCoreApplication.getInst().getSkinType());
    }

    public void H(int i) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.x.k();
        this.w.h(i);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57607h, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        this.D.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine).getDrawable());
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.L, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.ic_icon_mask_wo_yujin_16, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f57605f, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.f57606g, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.K, R.color.CAM_X0101, 1, i);
        SkinManager.setViewTextColor(this.N, R.color.CAM_X0101, 1, i);
        SkinManager.setImageResource(this.i, R.drawable.icon_news_down_bar_one);
        SkinManager.setBackgroundResource(this.G, R.drawable.person_header_bg, i);
        this.C.h();
        UserData userData = this.f57603d;
        if (userData != null) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, userData.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (i == 4) {
            TBLottieAnimationView tBLottieAnimationView = this.E;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.setAnimation("live/personcenter_live_bg_black.json");
            }
            ImageView imageView = this.D;
            if (imageView != null) {
                imageView.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine_2).getDrawable());
            }
        } else if (i == 1) {
            TBLottieAnimationView tBLottieAnimationView2 = this.E;
            if (tBLottieAnimationView2 != null) {
                tBLottieAnimationView2.setAnimation("live/personcenter_live_bg_night.json");
            }
            ImageView imageView2 = this.D;
            if (imageView2 != null) {
                imageView2.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine_1).getDrawable());
            }
        } else {
            TBLottieAnimationView tBLottieAnimationView3 = this.E;
            if (tBLottieAnimationView3 != null) {
                tBLottieAnimationView3.setAnimation("live/personcenter_live_bg.json");
            }
            ImageView imageView3 = this.D;
            if (imageView3 != null) {
                imageView3.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine).getDrawable());
            }
        }
    }

    public void I() {
        AnimatorSet animatorSet = this.F;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        TBLottieAnimationView tBLottieAnimationView = this.E;
        if (tBLottieAnimationView != null) {
            tBLottieAnimationView.cancelAnimation();
        }
        AnimatorSet animatorSet2 = this.R;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        d.b.j0.s1.c cVar = this.P;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void J() {
        ObjectAnimator objectAnimator = this.T;
        if (objectAnimator != null) {
            if (this.Q) {
                objectAnimator.setFloatValues(0.0f, 1.0f);
            } else {
                objectAnimator.setFloatValues(1.0f, 0.0f);
            }
        }
        ObjectAnimator objectAnimator2 = this.U;
        if (objectAnimator2 != null) {
            if (this.Q) {
                objectAnimator2.setFloatValues(0.0f, 180.0f);
            } else {
                objectAnimator2.setFloatValues(180.0f, 360.0f);
            }
        }
    }

    public void K(d.b.j0.i2.d.a aVar) {
        this.V = aVar;
    }

    public void L(boolean z) {
        this.Q = z;
    }

    public void M(boolean z) {
        if (z) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void N() {
        AnimatorSet animatorSet = this.R;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public final void O(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f);
        long j = 500;
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f);
        ofFloat2.setDuration(j);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.F = animatorSet;
        animatorSet.play(ofFloat).with(ofFloat2);
        this.F.start();
    }

    public void P(boolean z) {
        this.w.i(z);
    }

    public void Q(String str) {
        this.A.l(str);
    }

    public void q(UserData userData, d.b.j0.w0.b bVar) {
        String intro;
        if (userData == null) {
            return;
        }
        this.f57603d = userData;
        this.f57604e = bVar;
        if (!k.isEmpty(userData.getName_show())) {
            this.f57605f.setText(this.f57603d.getName_show());
        }
        this.f57606g.setVisibility(0);
        BaijiahaoInfo baijiahaoInfo = this.f57603d.getBaijiahaoInfo();
        if (this.f57603d.isNewGod() && !k.isEmpty(this.f57603d.getNewGodData().getFieldName())) {
            Resources resources = this.f57600a.getResources();
            int i = R.string.person_auth_perfix;
            intro = resources.getString(i, this.f57603d.getNewGodData().getFieldName() + l0.c(this.f57603d.getNewGodData().isVideoGod()));
        } else if (this.f57603d.showBazhuGrade()) {
            intro = this.f57600a.getResources().getString(R.string.person_auth_perfix, StringHelper.cutChineseAndEnglishWithSuffix(this.f57603d.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
        } else if (baijiahaoInfo != null && !k.isEmpty(baijiahaoInfo.auth_desc)) {
            intro = this.f57600a.getResources().getString(R.string.person_auth_perfix, baijiahaoInfo.auth_desc);
        } else {
            intro = this.f57603d.getIntro();
            if (!k.isEmpty(intro)) {
                intro = this.f57600a.getResources().getString(R.string.person_sign_prefix, intro);
            } else if (this.f57601b) {
                intro = this.f57600a.getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o");
            }
        }
        if (!k.isEmpty(intro)) {
            this.f57606g.setVisibility(0);
            this.f57606g.setText(intro);
            this.f57606g.setEnabled(true);
            d.b.c.e.m.e.a().post(new f(baijiahaoInfo));
        } else {
            this.f57606g.setVisibility(8);
        }
        this.j.h(this.f57603d.getIconInfo(), 9, this.f57600a.getResources().getDimensionPixelSize(R.dimen.tbds42), this.f57600a.getResources().getDimensionPixelSize(R.dimen.tbds42), this.f57600a.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        this.l.setText(StringHelper.numFormatOverWanNa(this.f57603d.getFansNum()));
        this.r.setText(StringHelper.numFormatOverWanNa(this.f57603d.getLike_bars()));
        this.o.setText(StringHelper.numFormatOverWanNa(this.f57603d.getConcernNum()));
        if (this.f57601b) {
            this.w.setVisibility(8);
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.w.setVisibility(0);
            this.w.setShowPullBtn(userData.isNewGod());
            this.w.setFirstUpdate(true);
            P(this.f57603d.getHave_attention() == 1);
        }
        UserVipInfoData userVipInfo = this.f57603d.getUserVipInfo();
        if (this.f57603d.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.y.W(userVipInfo.getVipIconUrl(), 10, false);
            this.y.setVisibility(0);
        } else if (this.f57601b) {
            this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
        int i2 = R.drawable.icon_mask_boy16_svg;
        UserData userData2 = this.f57603d;
        if (userData2 != null) {
            i2 = userData2.getSex() == 2 ? R.drawable.icon_mask_girl16_svg : R.drawable.icon_mask_boy16_svg;
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, i2, SvgManager.SvgResourceStateType.NORMAL);
        if (this.f57603d.getSex() == 0) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        AlaUserInfoData alaUserData = this.f57603d.getAlaUserData();
        if (alaUserData != null && alaUserData.live_status == 1) {
            this.E.setVisibility(0);
            this.E.loop(true);
            this.E.post(new g());
            this.G.setVisibility(8);
            O(this.B);
            this.D.setVisibility(0);
            this.A.setIsclearmode(true);
            this.A.k(this.f57603d.getAvater());
        } else {
            this.A.m(this.f57603d);
            this.D.setVisibility(8);
            this.A.setIsclearmode(false);
            this.G.setVisibility(0);
        }
        d.b.j0.w0.b bVar2 = this.f57604e;
        if (bVar2 != null && bVar2.a() && !TextUtils.isEmpty(this.f57604e.f64062b)) {
            this.J.setVisibility(0);
            if (this.f57601b) {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "0"));
            } else {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "1"));
            }
        } else {
            this.J.setVisibility(8);
        }
        UserData userData3 = this.f57603d;
        if (userData3 != null && userData3.getLiveRoomInfo() != null && this.f57603d.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.f57603d.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.f57603d.getLiveRoomInfo().btn_title)) {
            this.N.setText(this.f57603d.getLiveRoomInfo().btn_title);
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        if (this.J.getVisibility() != 0 && this.M.getVisibility() != 0) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
        }
    }

    public FollowUserSpinnerBtn r() {
        return this.w;
    }

    public FrameLayout s() {
        return this.n;
    }

    public FrameLayout t() {
        return this.k;
    }

    public FrameLayout u() {
        return this.q;
    }

    public View v() {
        return this.x;
    }

    public HeadPendantView w() {
        return this.A;
    }

    public ImageView x() {
        return this.f57607h;
    }

    public TextView y() {
        return this.f57606g;
    }

    public TbImageView z() {
        return this.y;
    }
}
