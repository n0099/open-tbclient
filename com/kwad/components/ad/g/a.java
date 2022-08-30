package com.kwad.components.ad.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.bd;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View BA;
    public Runnable BB;
    public boolean BC;
    @Nullable
    public Animator eY;
    public View un;
    public Button uo;
    public Button up;

    public a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.BC = false;
        this.BA = view2;
        initView();
    }

    public static Animator a(View view2, float f, float f2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Long.valueOf(j)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(f / f2, f2, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a1), view2) { // from class: com.kwad.components.ad.g.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float BH;
                public final /* synthetic */ float BI;
                public final /* synthetic */ float BJ;
                public final /* synthetic */ View dH;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(r6), Float.valueOf(f2), Float.valueOf(r8), view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.BH = r6;
                    this.BI = f2;
                    this.BJ = r8;
                    this.dH = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float f3 = this.BH * floatValue;
                        float f4 = this.BI;
                        if (f4 != 0.0f) {
                            float f5 = (floatValue / f4) * this.BJ;
                            View view3 = this.dH;
                            if (view3 instanceof TextView) {
                                ((TextView) view3).setTextSize(0, f5);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = this.dH.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = (int) floatValue;
                            layoutParams.width = (int) f3;
                            this.dH.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofFloat;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator a(View view2, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, view2, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            return ofFloat;
        }
        return (Animator) invokeLJ.objValue;
    }

    public static Animator a(View view2, View view3, int i, int i2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Animator a = a(view2, 200L);
            float f = i;
            float f2 = i2;
            Animator a2 = a(view3, f, f2, 200L);
            a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b(view2) { // from class: com.kwad.components.ad.g.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View BG;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.BG = view2;
                }

                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.BG.setAlpha(1.0f);
                        ViewGroup.LayoutParams layoutParams = this.BG.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            this.BG.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, Key.SCALE_X, 1.0f, 1.0f);
            ofFloat.setDuration(1600L);
            Animator a3 = a(view3, 200L);
            Animator a4 = a(view2, f, f2, 200L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(a, a2, ofFloat, a3, a4);
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.uo = (Button) this.BA.findViewById(R.id.obfuscated_res_0x7f09113c);
            this.up = (Button) this.BA.findViewById(R.id.obfuscated_res_0x7f09113e);
            this.un = this.BA.findViewById(R.id.obfuscated_res_0x7f09113d);
        }
    }

    public final void iO() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            kM();
        }
    }

    public final void kL() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "startAnimation");
            int height = this.un.getHeight();
            int width = this.un.getWidth();
            if (height == 0 || width == 0) {
                return;
            }
            if (this.eY == null) {
                Animator a = a(this.up, this.uo, width, height, 1600L, 200L);
                this.eY = a;
                a.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b(this) { // from class: com.kwad.components.ad.g.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a BD;

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
                        this.BD = this;
                    }

                    @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.BD.BC) {
                            return;
                        }
                        if (this.BD.BB == null) {
                            this.BD.BB = new Runnable(this, animator) { // from class: com.kwad.components.ad.g.a.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Animator BE;
                                public final /* synthetic */ AnonymousClass1 BF;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, animator};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.BF = this;
                                    this.BE = animator;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.BE.start();
                                    }
                                }
                            };
                        }
                        bd.a(this.BD.BB, null, 1600L);
                    }
                });
            }
            com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.eY.isStarted());
            if (!this.eY.isStarted()) {
                com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "mAnimator.start()");
                this.eY.start();
            }
            this.BC = false;
        }
    }

    public final void kM() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Animator animator = this.eY;
            if (animator != null) {
                animator.cancel();
                this.eY.removeAllListeners();
                this.BC = true;
            }
            Runnable runnable = this.BB;
            if (runnable != null) {
                bd.c(runnable);
                this.BB = null;
            }
        }
    }

    public final void kN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.BC = true;
        }
    }
}
