package com.kwad.components.ad.reward.i;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            if (view2 == null || view2.getHeight() == 0) {
                return null;
            }
            return ObjectAnimator.ofFloat(view2, "translationY", view2.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070390));
        }
        return (Animator) invokeL.objValue;
    }

    @Nullable
    public static Animator a(AdTemplate adTemplate, View view2, DetailVideoView detailVideoView) {
        InterceptResult invokeLLL;
        ValueAnimator a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, adTemplate, view2, detailVideoView)) == null) {
            if (detailVideoView == null || (a = detailVideoView.a(adTemplate, (int) (detailVideoView.getHeight() - detailVideoView.getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070391)), (ValueAnimator.AnimatorUpdateListener) null)) == null) {
                return null;
            }
            Animator a2 = a(view2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(a.getDuration());
            animatorSet.setInterpolator(a.getInterpolator());
            animatorSet.playTogether(a, a2);
            return animatorSet;
        }
        return (Animator) invokeLLL.objValue;
    }

    @Nullable
    public static Animator a(@NonNull AdTemplate adTemplate, DetailVideoView detailVideoView, View view2) {
        InterceptResult invokeLLL;
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, adTemplate, detailVideoView, view2)) == null) {
            if (view2 == null || view2.getLayoutParams() == null || (width = view2.getWidth()) == 0) {
                return null;
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "translationX", -width).setDuration(300L);
            duration.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            if (com.kwad.sdk.core.response.a.a.R(com.kwad.sdk.core.response.a.d.i(adTemplate)) || detailVideoView == null) {
                return duration;
            }
            ValueAnimator b = detailVideoView.b(width);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(duration, b);
            return animatorSet;
        }
        return (Animator) invokeLLL.objValue;
    }
}
