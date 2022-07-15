package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class d extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public ImageView c;
    public int d;
    public Animator e;
    public Animator f;
    public Animation g;
    public Animation h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = 0;
        a(context);
    }

    private Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", 0.0f, -10.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationX", 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(250L);
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    private Animation a(View view2, float f, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{view2, Float.valueOf(f), Integer.valueOf(i)})) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
            float a = i / com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f);
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, a, 1.0f, a, 1, 0.5f, 1, 0.5f);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(200L);
            animationSet.setAnimationListener(new Animation.AnimationListener(this, view2) { // from class: com.kwad.components.ad.feed.a.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;
                public final /* synthetic */ d b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = view2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.a.setVisibility(4);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                        this.a.setVisibility(0);
                    }
                }
            });
            return animationSet;
        }
        return (Animation) invokeCommon.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0443, this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091053);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09109e);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091050);
        }
    }

    private Animator b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", -10.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationX", -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "translationY", -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(250L);
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.e = a(this.c);
            this.f = b(this.c);
            this.g = a(this.a, 0.45f, com.kwad.sdk.b.kwai.a.a(getContext(), 34.0f));
            this.h = a(this.b, 0.5f, com.kwad.sdk.b.kwai.a.a(getContext(), 50.0f));
            this.e.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.feed.a.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.a.a.startAnimation(this.a.g);
                        this.a.b.startAnimation(this.a.h);
                        this.a.f.start();
                    }
                }
            });
            this.f.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.feed.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ d a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        d.f(this.a);
                        if (this.a.d >= 5) {
                            return;
                        }
                        this.a.e.start();
                    }
                }
            });
        }
    }

    public static /* synthetic */ int f(d dVar) {
        int i = dVar.d;
        dVar.d = i + 1;
        return i;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
            this.e.start();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Animator animator = this.e;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.f;
            if (animator2 != null) {
                animator2.cancel();
            }
            Animation animation = this.g;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = this.h;
            if (animation2 != null) {
                animation2.cancel();
            }
        }
    }
}
