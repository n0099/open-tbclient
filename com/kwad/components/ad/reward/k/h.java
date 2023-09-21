package com.kwad.components.ad.reward.k;

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
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class h extends d implements View.OnClickListener {
    @Nullable
    public KsLogoView bq;
    @Nullable
    public TextView eQ;
    @Nullable
    public KSCornerImageView it;
    @Nullable
    public TextView iu;
    @Nullable
    public KsPriceView nI;
    public com.kwad.components.ad.reward.k nM;
    @Nullable
    public ViewGroup pV;
    public ViewGroup uL;
    @Nullable
    public TextView uM;
    @Nullable
    public KsStyledTextButton uN;
    @Nullable
    public TextView uO;
    @Nullable
    public TextView uP;
    @Nullable
    public View uQ;
    @Nullable
    public ImageView uR;

    /* loaded from: classes10.dex */
    public static class a {
        public String hL;
        public String kY;
        public String np;
        public String oY;
        public String rating;
        public String title;
        public String vb;
        @Nullable
        public String vc;
        public String vd;
        public String ve;

        public static a C(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
            a aVar = new a();
            String name = bN.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
            }
            aVar.vd = com.kwad.sdk.core.response.a.a.al(bQ);
            aVar.kY = bN.getIcon();
            aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
            aVar.vb = bN.getPrice();
            aVar.hL = bN.getOriginPrice();
            aVar.ve = bN.getVolume();
            aVar.rating = bN.getRating();
            if (!bN.isCouponListEmpty() && (firstCouponList = bN.getFirstCouponList()) != null) {
                aVar.vc = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.S(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        private void S(String str) {
            this.oY = str;
        }

        public final String dB() {
            return this.hL;
        }

        public final String eL() {
            return this.kY;
        }

        public final String fO() {
            return this.np;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gz() {
            return this.oY;
        }

        public final String iS() {
            return this.vb;
        }

        public final String iT() {
            return this.vc;
        }

        public final String iU() {
            return this.vd;
        }

        public final String iV() {
            return this.ve;
        }
    }

    public h(com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.nM = kVar;
        this.bq = ksLogoView;
        this.uL = viewGroup;
        initView();
    }

    @Nullable
    public static Animator a(View view2, float f) {
        if (view2 == null || view2.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704cb) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view2, View view3, final View view4) {
        final int height = view2.getHeight();
        if (height <= 0 || view2.getLayoutParams() == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07051d)).setDuration(500L);
        duration.setInterpolator(create);
        if (ag.cB(view2.getContext()) && view4 != null && (view4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.k.h.3
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

    public static /* synthetic */ Animator a(h hVar, View view2, float f) {
        return a(view2, f);
    }

    private void a(AdTemplate adTemplate, a aVar) {
        TextView textView;
        String rating;
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.it, aVar.eL(), adTemplate, 4);
        TextView textView2 = this.eQ;
        if (textView2 != null) {
            textView2.setText(aVar.getTitle());
        }
        TextView textView3 = this.iu;
        if (textView3 != null) {
            textView3.setText(aVar.fO());
        }
        KsPriceView ksPriceView = this.nI;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07052a);
            this.nI.getConfig().ab(dimensionPixelSize).ad(dimensionPixelSize).ac(this.nI.getResources().getColor(R.color.obfuscated_res_0x7f06079c));
            this.nI.d(aVar.iS(), aVar.dB(), true);
        }
        if (this.uM != null) {
            if (!TextUtils.isEmpty(aVar.iV())) {
                textView = this.uM;
                rating = aVar.iV();
            } else if (TextUtils.isEmpty(aVar.getRating())) {
                this.uM.setVisibility(8);
            } else {
                textView = this.uM;
                rating = aVar.getRating();
            }
            textView.setText(rating);
        }
        if (this.uO != null && !TextUtils.isEmpty(aVar.iT())) {
            this.uO.setText(aVar.iT());
        }
        if (this.uN != null && !TextUtils.isEmpty(aVar.iU())) {
            this.uN.setText(aVar.iU());
        }
        int i = TextUtils.isEmpty(aVar.iT()) ? 8 : 0;
        View view2 = this.uQ;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        if (this.uP == null || TextUtils.isEmpty(aVar.gz())) {
            return;
        }
        this.uP.setText(aVar.gz());
    }

    private void initView() {
        this.pV = (ViewGroup) this.uL.findViewById(R.id.obfuscated_res_0x7f091399);
        this.it = (KSCornerImageView) this.uL.findViewById(R.id.obfuscated_res_0x7f091394);
        this.eQ = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f09139b);
        this.iu = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091383);
        this.nI = (KsPriceView) this.uL.findViewById(R.id.obfuscated_res_0x7f091396);
        this.uM = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091398);
        this.uN = (KsStyledTextButton) this.uL.findViewById(R.id.obfuscated_res_0x7f09137e);
        this.uR = (ImageView) this.uL.findViewById(R.id.obfuscated_res_0x7f091395);
        this.uQ = this.uL.findViewById(R.id.obfuscated_res_0x7f091381);
        this.uO = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091380);
        this.uP = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091382);
        ViewGroup viewGroup = this.pV;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        KsStyledTextButton ksStyledTextButton = this.uN;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.pV.getContext();
        if (ag.cB(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.pV.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070510);
            this.pV.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        if (uVar == null) {
            return;
        }
        a(uVar.getAdTemplate(), a.C(uVar.getAdTemplate()));
        ViewGroup viewGroup = this.pV;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = h.this;
                    Animator a2 = hVar.a(hVar.pV, h.this.uN, h.this.bq);
                    if (a2 != null) {
                        a2.start();
                    }
                }
            }, 3000L);
            this.pV.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.h.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.uN == null || h.this.uN.getWidth() == 0) {
                        return;
                    }
                    h hVar = h.this;
                    final Animator a2 = h.a(hVar, hVar.uR, h.this.uN.getWidth());
                    if (a2 != null) {
                        a2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.h.2.1
                            public int uT = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.uT >= 3) {
                                    return;
                                }
                                a2.start();
                                this.uT++;
                            }
                        });
                        a2.start();
                    }
                }
            }, 5000L);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.pV;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.pV)) {
            this.nM.a(view2.getContext(), 118, 2);
        } else if (view2.equals(this.uN)) {
            this.nM.a(view2.getContext(), 1, 1);
        }
    }
}
