package com.kwad.components.ad.reward.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class i extends d implements View.OnClickListener {
    @Nullable
    public TextView hz;
    @Nullable
    public KSCornerImageView lu;
    @Nullable
    public TextView lv;
    @Nullable
    public KsLogoView mLogoView;
    public com.kwad.components.ad.reward.g qn;
    public ViewGroup sy;
    public ViewGroup yF;
    @Nullable
    public KsPriceView yG;
    @Nullable
    public TextView yH;
    @Nullable
    public KsStyledTextButton yI;
    @Nullable
    public TextView yJ;
    @Nullable
    public TextView yK;
    @Nullable
    public View yL;
    @Nullable
    public ImageView yM;

    /* loaded from: classes10.dex */
    public static class a {
        public String kY;
        public String pZ;
        public String qa;
        public String rQ;
        public String rating;
        public String title;
        public String yW;
        @Nullable
        public String yX;
        public String yY;
        public String yZ;

        public final String dz() {
            return this.kY;
        }

        public final String gV() {
            return this.rQ;
        }

        public final String gd() {
            return this.pZ;
        }

        public final String ge() {
            return this.qa;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String jT() {
            return this.yW;
        }

        public final String jU() {
            return this.yX;
        }

        public final String jV() {
            return this.yY;
        }

        public final String jW() {
            return this.yZ;
        }

        private void L(String str) {
            this.rQ = str;
        }

        public static a Q(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(dP);
            a aVar = new a();
            String name = cM.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.ax(dP);
            }
            aVar.yY = com.kwad.sdk.core.response.b.a.aE(dP);
            aVar.pZ = cM.getIcon();
            aVar.qa = com.kwad.sdk.core.response.b.a.au(dP);
            aVar.yW = cM.getPrice();
            aVar.kY = cM.getOriginPrice();
            aVar.yZ = cM.getVolume();
            aVar.rating = cM.getRating();
            if (!cM.isCouponListEmpty() && (firstCouponList = cM.getFirstCouponList()) != null) {
                aVar.yX = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.L(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.qn = gVar;
        this.mLogoView = ksLogoView;
        this.yF = viewGroup;
        initView();
    }

    public static /* synthetic */ Animator a(i iVar, View view2, float f) {
        return a(view2, f);
    }

    @Nullable
    public static Animator a(View view2, float f) {
        if (view2 != null && view2.getWidth() > 0) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704d4) + f).setDuration(1000L);
            duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(1000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(duration, duration2);
            return animatorSet;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view2, View view3, final View view4) {
        final int height = view2.getHeight();
        if (height > 0 && view2.getLayoutParams() != null) {
            Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
            ValueAnimator duration = ValueAnimator.ofInt(height, view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070519)).setDuration(500L);
            duration.setInterpolator(create);
            view2.getContext();
            if (ai.Kx() && view4 != null && (view4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                final int i = marginLayoutParams.bottomMargin;
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                        marginLayoutParams2.bottomMargin = i + (intValue - height);
                        view4.setLayoutParams(marginLayoutParams2);
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = intValue;
                            view2.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.0f, 0.0f).setDuration(200L);
            Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.0f, 1.0f).setDuration(300L);
            duration3.setInterpolator(create2);
            animatorSet.playSequentially(duration2, duration3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(duration, animatorSet);
            return animatorSet2;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.sy)) {
            this.qn.a(1, view2.getContext(), 118, 2);
        } else if (view2.equals(this.yI)) {
            this.qn.a(1, view2.getContext(), 1, 1);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.lu, aVar.gd(), adTemplate, 4);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.lv;
        if (textView2 != null) {
            textView2.setText(aVar.ge());
        }
        KsPriceView ksPriceView = this.yG;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070526);
            this.yG.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.yG.getResources().getColor(R.color.obfuscated_res_0x7f0607a0));
            this.yG.d(aVar.jT(), aVar.dz(), true);
        }
        int i = 8;
        if (this.yH != null) {
            if (!TextUtils.isEmpty(aVar.jW())) {
                this.yH.setText(aVar.jW());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.yH.setText(aVar.getRating());
            } else {
                this.yH.setVisibility(8);
            }
        }
        if (this.yJ != null && !TextUtils.isEmpty(aVar.jU())) {
            this.yJ.setText(aVar.jU());
        }
        if (this.yI != null && !TextUtils.isEmpty(aVar.jV())) {
            this.yI.setText(aVar.jV());
        }
        if (!TextUtils.isEmpty(aVar.jU())) {
            i = 0;
        }
        View view2 = this.yL;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        if (this.yK != null && !TextUtils.isEmpty(aVar.gV())) {
            this.yK.setText(aVar.gV());
        }
    }

    private void initView() {
        this.sy = (ViewGroup) this.yF.findViewById(R.id.obfuscated_res_0x7f091442);
        this.lu = (KSCornerImageView) this.yF.findViewById(R.id.obfuscated_res_0x7f09143d);
        this.hz = (TextView) this.yF.findViewById(R.id.obfuscated_res_0x7f091444);
        this.lv = (TextView) this.yF.findViewById(R.id.obfuscated_res_0x7f09142c);
        this.yG = (KsPriceView) this.yF.findViewById(R.id.obfuscated_res_0x7f09143f);
        this.yH = (TextView) this.yF.findViewById(R.id.obfuscated_res_0x7f091441);
        this.yI = (KsStyledTextButton) this.yF.findViewById(R.id.obfuscated_res_0x7f091427);
        this.yM = (ImageView) this.yF.findViewById(R.id.obfuscated_res_0x7f09143e);
        this.yL = this.yF.findViewById(R.id.obfuscated_res_0x7f09142a);
        this.yJ = (TextView) this.yF.findViewById(R.id.obfuscated_res_0x7f091429);
        this.yK = (TextView) this.yF.findViewById(R.id.obfuscated_res_0x7f09142b);
        this.sy.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.yI;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.sy.getContext();
        if (!ai.Kx()) {
            ViewGroup.LayoutParams layoutParams = this.sy.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050c);
                this.sy.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.Q(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.sy;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator a2 = iVar.a(iVar.sy, i.this.yI, i.this.mLogoView);
                    if (a2 != null) {
                        a2.start();
                    }
                }
            }, 3000L);
            this.sy.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.yI != null && i.this.yI.getWidth() != 0) {
                        i iVar = i.this;
                        final Animator a2 = i.a(iVar, iVar.yM, i.this.yI.getWidth());
                        if (a2 != null) {
                            a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                                public int yO = 1;

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    if (this.yO >= 3) {
                                        return;
                                    }
                                    a2.start();
                                    this.yO++;
                                }
                            });
                            a2.start();
                        }
                    }
                }
            }, 5000L);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.sy;
    }
}
