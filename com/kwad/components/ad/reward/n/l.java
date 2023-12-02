package com.kwad.components.ad.reward.n;

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
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bn;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public final class l extends s implements View.OnClickListener {
    public ImageView fq;
    public TextView lv;
    public com.kwad.components.ad.reward.g qn;
    public ImageView zi;
    public TextView zj;
    public TextView zk;
    public TextView zl;
    public View zm;
    public Set<ImageView> zn = new HashSet();
    public TextView zo;
    public Animator zp;

    public l(com.kwad.components.ad.reward.g gVar) {
        this.qn = gVar;
    }

    public static Animator r(View view2) {
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704df)).setDuration(250L);
        duration.setInterpolator(create);
        return duration;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ab(boolean z) {
        super.ab(z);
        Context context = this.sy.getContext();
        if (!ai.Kx()) {
            ViewGroup.LayoutParams layoutParams = this.sy.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704e6);
            this.sy.setLayoutParams(layoutParams);
        }
    }

    public final void h(ViewGroup viewGroup) {
        super.a(viewGroup, R.id.obfuscated_res_0x7f091458, R.id.obfuscated_res_0x7f091457);
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2.equals(this.zk)) {
            this.qn.a(1, view2.getContext(), 29, 1);
        } else if (view2.equals(this.sy)) {
            this.qn.a(1, view2.getContext(), 53, 2);
        }
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

    public static /* synthetic */ Animator a(l lVar, View view2) {
        return r(view2);
    }

    public static /* synthetic */ Animator a(l lVar, View view2, long j, float f) {
        return a(view2, 100L, 8.0f);
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        this.zj.setText(aVar.getTitle());
        this.lv.setText(aVar.hf());
        this.zk.setText(aVar.hc());
        String gd = aVar.gd();
        Drawable drawable = this.fq.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e7e);
        KSImageLoader.loadCircleIcon(this.fq, gd, drawable);
        String Z = com.kwad.components.ad.d.b.Z();
        if (!bg.isNullString(Z)) {
            KSImageLoader.loadImage(this.zi, Z, aVar.gW());
        }
        if (aVar.hd()) {
            this.zm.setVisibility(0);
            String hb = aVar.hb();
            if (!TextUtils.isEmpty(hb)) {
                this.zo.setText(String.format("%s已预约直播", hb));
            }
            if (aVar.he() != null) {
                List<String> he = aVar.he();
                int i = 0;
                for (ImageView imageView : this.zn) {
                    if (i < he.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, he.get(i), drawable);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        this.zm.setVisibility(8);
    }

    private void initView() {
        ViewGroup viewGroup = this.sy;
        if (viewGroup == null) {
            return;
        }
        this.zl = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09144b);
        this.zi = (ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091454);
        this.fq = (ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091453);
        this.zj = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f091455);
        this.lv = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f09144e);
        this.zk = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f09144c);
        this.zm = this.sy.findViewById(R.id.obfuscated_res_0x7f09144f);
        this.zn.add((ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091450));
        this.zn.add((ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091451));
        this.zn.add((ImageView) this.sy.findViewById(R.id.obfuscated_res_0x7f091452));
        this.zo = (TextView) this.sy.findViewById(R.id.obfuscated_res_0x7f09144d);
        this.sy.setOnClickListener(this);
        this.zk.setOnClickListener(this);
    }

    private void jY() {
        this.zl.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.l.1
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = l.this;
                lVar.zp = l.a(lVar, lVar.zl, 100L, 8.0f);
                l.this.zp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.l.1.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (l.this.zp != null) {
                            l.this.zp.start();
                        }
                    }
                });
                l.this.zp.start();
            }
        }, 500L);
    }

    private void jZ() {
        bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.n.l.2
            @Override // java.lang.Runnable
            public final void run() {
                l lVar = l.this;
                l.a(lVar, lVar.zm).start();
            }
        }, 2000L);
    }

    public final void jX() {
        jY();
        jZ();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void onUnbind() {
        super.onUnbind();
        Animator animator = this.zp;
        if (animator != null) {
            animator.cancel();
            this.zp = null;
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        AdTemplate adTemplate = rVar.getAdTemplate();
        if (adTemplate != null) {
            a(com.kwad.components.ad.reward.model.a.J(adTemplate));
        }
    }
}
