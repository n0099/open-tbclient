package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes7.dex */
public class KsRotateView extends b {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Al = 50;
    public static int Am = -12;
    public static int An = -25;
    public static int Ao = 12;
    public static int Ap = 25;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView Ak;
    @DrawableRes
    public int Aq;
    public ImageView nC;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-962575765, "Lcom/kwad/components/ad/splashscreen/widget/KsRotateView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-962575765, "Lcom/kwad/components/ad/splashscreen/widget/KsRotateView;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRotateView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRotateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, context, attributeSet, i) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i, 0);
            this.Aq = obtainStyledAttributes.getResourceId(5, com.baidu.tieba.R.drawable.obfuscated_res_0x7f080c1c);
            obtainStyledAttributes.recycle();
            ImageView imageView = new ImageView(getContext());
            this.Ak = imageView;
            imageView.setImageResource(com.baidu.tieba.R.drawable.obfuscated_res_0x7f080c1b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            addView(this.Ak, layoutParams);
            this.nC = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.topMargin = com.kwad.sdk.b.kwai.a.a(context, 22.0f);
            layoutParams2.gravity = 1;
            addView(this.nC, layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public int getAnimationDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 500;
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public View getInteractionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.nC : (View) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final Animator kD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View interactionView = getInteractionView();
            if (interactionView == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            interactionView.setPivotX(interactionView.getWidth() / 2.0f);
            interactionView.setPivotY(interactionView.getHeight() / 2.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, An).setDuration(500L);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
            ofFloat.setDuration(340L);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, An, 0.0f).setDuration(Al);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Ao).setDuration(Al);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Ao, 0.0f).setDuration(Al);
            ObjectAnimator duration5 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Am).setDuration(Al);
            ObjectAnimator duration6 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Am, 0.0f).setDuration(Al);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
            ofFloat2.setDuration(500L);
            ObjectAnimator duration7 = ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Ap).setDuration(500L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(interactionView, Key.ALPHA, 1.0f, 1.0f);
            ofFloat.setDuration(340L);
            animatorSet.playSequentially(duration, ofFloat, duration2, duration3, duration4, duration5, duration6, ofFloat2, duration7, ofFloat3, ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Ap, 0.0f).setDuration(Al), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Am).setDuration(Al), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Am, 0.0f).setDuration(Al), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, 0.0f, Ao).setDuration(Al), ObjectAnimator.ofFloat(interactionView, Key.ROTATION, Ao, 0.0f).setDuration(Al));
            return animatorSet;
        }
        return (Animator) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void kE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getInteractionView().setRotation(0.0f);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void kp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.nC.setImageResource(this.Aq);
        }
    }
}
