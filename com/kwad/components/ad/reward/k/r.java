package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class r {
    @Nullable
    public static Animator a(AdTemplate adTemplate, View view2, DetailVideoView detailVideoView) {
        ValueAnimator a;
        if (detailVideoView == null || (a = detailVideoView.a(adTemplate, (int) (detailVideoView.getHeight() - detailVideoView.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704e8)), (ValueAnimator.AnimatorUpdateListener) null)) == null) {
            return null;
        }
        Animator q = q(view2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(a.getDuration());
        animatorSet.setInterpolator(a.getInterpolator());
        animatorSet.playTogether(a, q);
        return animatorSet;
    }

    @Nullable
    public static Animator a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView, View view2) {
        int width;
        if (view2 == null || view2.getLayoutParams() == null || (width = view2.getWidth()) == 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, -width).setDuration(300L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        if (com.kwad.sdk.core.response.a.a.av(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) || detailVideoView == null) {
            return duration;
        }
        ValueAnimator ar = detailVideoView.ar(width);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, ar);
        return animatorSet;
    }

    @Nullable
    public static Animator q(View view2) {
        if (view2 == null || view2.getHeight() == 0) {
            return null;
        }
        return ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704e7));
    }
}
