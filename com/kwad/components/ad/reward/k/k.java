package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public final class k extends v implements View.OnClickListener {
    public TextView iu;
    public ImageView nC;
    public com.kwad.components.ad.reward.k nM;
    public ImageView vo;
    public TextView vp;
    public View vq;
    public TextView vr;
    public View vs;
    public Set<ImageView> vt = new HashSet();
    public TextView vu;
    public Animator vv;

    public k(com.kwad.components.ad.reward.k kVar) {
        this.nM = kVar;
    }

    public static Animator a(View view2, long j, float f) {
        if (view2 == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        view2.setPivotX(0.0f);
        view2.setPivotY(view2.getHeight());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f);
        ofFloat.setDuration(100L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "rotation", 0.0f, f).setDuration(j);
        float f2 = -f;
        long j2 = j * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "rotation", f, f2).setDuration(j2);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "rotation", f2, f).setDuration(j2);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view2, "rotation", f, f2).setDuration(j2);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view2, "rotation", f2, 0.0f).setDuration(j));
        return animatorSet;
    }

    public static /* synthetic */ Animator a(k kVar, View view2) {
        return o(view2);
    }

    public static /* synthetic */ Animator a(k kVar, View view2, long j, float f) {
        return a(view2, 100L, 8.0f);
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.vp.setText(aVar.getTitle());
        this.iu.setText(aVar.gJ());
        String eL = aVar.eL();
        Drawable drawable = this.nC.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e2e);
        KSImageLoader.loadCircleIcon(this.nC, eL, drawable);
        String aj = com.kwad.components.ad.c.b.aj();
        if (!ax.dT(aj)) {
            KSImageLoader.loadImage(this.vo, aj, aVar.gA());
        }
        if (!aVar.gH()) {
            this.vs.setVisibility(8);
            return;
        }
        this.vs.setVisibility(0);
        String gE = aVar.gE();
        if (!TextUtils.isEmpty(gE)) {
            this.vu.setText(String.format("%s已预约直播", gE));
        }
        if (aVar.gI() != null) {
            List<String> gI = aVar.gI();
            int i = 0;
            for (ImageView imageView : this.vt) {
                if (i < gI.size()) {
                    imageView.setVisibility(0);
                    KSImageLoader.loadCircleIcon(imageView, gI.get(i), drawable);
                }
                i++;
            }
        }
    }

    private void iX() {
        this.vr.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.1
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                kVar.vv = k.a(kVar, kVar.vr, 100L, 8.0f);
                k.this.vv.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.k.k.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (k.this.vv != null) {
                            k.this.vv.start();
                        }
                    }
                });
                k.this.vv.start();
            }
        }, 500L);
    }

    private void iY() {
        bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.k.k.2
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = k.this;
                k.a(kVar, kVar.vs).start();
            }
        }, 2000L);
    }

    private void initView() {
        ViewGroup viewGroup = this.pV;
        if (viewGroup == null) {
            return;
        }
        this.vr = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091382);
        this.vo = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f09138b);
        this.nC = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f09138a);
        this.vp = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09138c);
        this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091385);
        this.vq = this.pV.findViewById(R.id.obfuscated_res_0x7f091383);
        this.vs = this.pV.findViewById(R.id.obfuscated_res_0x7f091386);
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091387));
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091388));
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091389));
        this.vu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091384);
        this.pV.setOnClickListener(this);
        this.vq.setOnClickListener(this);
    }

    public static Animator o(View view2) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704cc)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        AdTemplate adTemplate = uVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.x(adTemplate));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        super.aa(z);
        Context context = this.pV.getContext();
        if (ag.cB(context)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.pV.getLayoutParams();
        layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704d3);
        this.pV.setLayoutParams(layoutParams);
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.obfuscated_res_0x7f09138f, R.id.obfuscated_res_0x7f09138e);
        initView();
    }

    public final void iW() {
        iX();
        iY();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.vq)) {
            this.nM.a(view2.getContext(), 29, 1);
        } else if (view2.equals(this.pV)) {
            this.nM.a(view2.getContext(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.vv;
        if (animator != null) {
            animator.cancel();
            this.vv = null;
        }
    }
}
