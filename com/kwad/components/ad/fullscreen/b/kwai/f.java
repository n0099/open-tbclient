package com.kwad.components.ad.fullscreen.b.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.l.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.az;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.sdk.core.f.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdInfo b;
    public com.kwad.sdk.core.f.d c;
    public Vibrator d;
    public ViewGroup e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public FrameLayout i;
    public ImageView j;
    public FrameLayout k;
    public TextView l;
    public boolean m;
    @Nullable
    public Animator n;
    public com.kwad.components.ad.reward.c.f o;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.o = new com.kwad.components.ad.reward.c.f(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.m = true;
                    if (this.a.e != null) {
                        this.a.e.setVisibility(8);
                    }
                    if (this.a.k != null) {
                        this.a.k.setVisibility(8);
                    }
                    if (this.a.c != null) {
                        this.a.c.b(this.a.u());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.e == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Resources resources = this.e.getResources();
            Animator a = n.a(this.h, null, 100L, 16.0f);
            a.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.a.h.setPivotX(this.a.h.getWidth());
                        this.a.h.setPivotY(this.a.h.getHeight());
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "translationX", f - (this.e.getLeft() + (this.e.getWidth() / 2.0f)));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.e, "translationY", f2 - (this.e.getTop() + (this.e.getHeight() / 2.0f)));
            float dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f070364);
            float dimension2 = resources.getDimension(R.dimen.obfuscated_res_0x7f070368);
            float width = this.i.getWidth();
            float width2 = this.h.getWidth();
            if (width == 0.0f || width2 == 0.0f) {
                return null;
            }
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
            ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.j) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.widget.a
                public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, layoutParams, obj) == null) {
                        float floatValue = ((Float) obj).floatValue();
                        if (layoutParams != null) {
                            int i = (int) floatValue;
                            layoutParams.height = i;
                            layoutParams.width = i;
                        }
                    }
                }
            });
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
            ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.h) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.widget.a
                public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, layoutParams, obj) == null) {
                        float floatValue = ((Float) obj).floatValue();
                        if (layoutParams != null) {
                            int i = (int) floatValue;
                            layoutParams.height = i;
                            layoutParams.width = i;
                        }
                    }
                }
            });
            int color = resources.getColor(R.color.obfuscated_res_0x7f060763);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f06075f);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070369);
            ValueAnimator a2 = com.kwad.sdk.widget.a.a(color, color2);
            a2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, color2, dimensionPixelSize) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ int b;
                public final /* synthetic */ f c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(color2), Integer.valueOf(dimensionPixelSize)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = color2;
                    this.b = dimensionPixelSize;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        GradientDrawable gradientDrawable = (GradientDrawable) this.c.j.getBackground();
                        gradientDrawable.mutate();
                        gradientDrawable.setColor(intValue);
                        if (intValue == this.a) {
                            gradientDrawable.setStroke(this.b, -1);
                        }
                        this.c.j.setBackground(gradientDrawable);
                    }
                }
            });
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat5.setDuration(200L);
            ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.a.f.setAlpha(floatValue);
                        this.a.g.setAlpha(floatValue);
                    }
                }
            });
            ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.f.getHeight(), 0.0f);
            ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.f) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.widget.a
                public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, layoutParams, obj) == null) {
                        layoutParams.height = (int) ((Float) obj).floatValue();
                    }
                }
            });
            ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.g.getHeight(), 0.0f);
            ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.g) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((View) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.widget.a
                public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, layoutParams, obj) == null) {
                        layoutParams.height = (int) ((Float) obj).floatValue();
                    }
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(500L);
            animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, a2, ofFloat6, ofFloat7);
            AnimatorSet animatorSet3 = new AnimatorSet();
            Animator clone = a.clone();
            clone.addListener(new AnimatorListenerAdapter(this, dimension2, clone) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float a;
                public final /* synthetic */ Animator b;
                public final /* synthetic */ f c;
                public boolean d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(dimension2), clone};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = dimension2;
                    this.b = clone;
                    this.d = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.d = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.d) {
                            return;
                        }
                        this.b.start();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.c.h.setPivotX(this.a);
                        this.c.h.setPivotY(this.a);
                    }
                }
            });
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.obfuscated_res_0x7f07036b)).setDuration(500L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, duration, layoutParams) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ValueAnimator a;
                public final /* synthetic */ ViewGroup.LayoutParams b;
                public final /* synthetic */ f c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, duration, layoutParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = duration;
                    this.b = layoutParams;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        try {
                            if (this.c.k == null) {
                                this.a.cancel();
                            } else if (this.c.m) {
                                this.c.k.setVisibility(8);
                                this.a.cancel();
                            } else {
                                this.c.k.setVisibility(0);
                                this.b.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                this.c.k.setLayoutParams(this.b);
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.b.b(e);
                            com.kwad.components.core.b.a.a(e);
                        }
                    }
                }
            });
            animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.l, "alpha", 0.0f, 1.0f).setDuration(500L));
            animatorSet.playSequentially(a, a.clone(), a.clone(), ofFloat5, animatorSet2, animatorSet3);
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static String a(l lVar, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, lVar, adInfo)) == null) {
            String q = com.kwad.sdk.core.response.a.b.q(adInfo);
            com.kwad.components.core.c.a.b bVar = lVar.k;
            if (!com.kwad.sdk.core.response.a.a.I(adInfo) || bVar == null) {
                return q;
            }
            int a = bVar.a();
            AdMatrixInfo.DownloadTexts r = com.kwad.sdk.core.response.a.b.r(adInfo);
            return a != 8 ? a != 12 ? r.adActionDescription : r.openAppLabel : r.installAppLabel;
        }
        return (String) invokeLL.objValue;
    }

    private void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, adInfo) == null) {
            String p = com.kwad.sdk.core.response.a.b.p(adInfo);
            TextView textView = this.f;
            if (textView != null) {
                textView.setText(p);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setText(p);
            }
            String a = a(((com.kwad.components.ad.reward.presenter.a) this).a, adInfo);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText("或点击" + a);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f091182);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(u()).inflate(R.layout.obfuscated_res_0x7f0d0464, (ViewGroup) adBaseFrameLayout, false);
            this.e = viewGroup;
            viewGroup.setVisibility(0);
            Resources resources = this.e.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070366);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070365);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036a);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364);
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(u()).inflate(R.layout.obfuscated_res_0x7f0d0465, (ViewGroup) adBaseFrameLayout, false);
            this.k = frameLayout;
            this.l = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f091192);
            this.k.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize3;
            layoutParams.gravity = 83;
            adBaseFrameLayout.addView(this.k, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            adBaseFrameLayout.addView(this.e, layoutParams2);
            com.kwad.sdk.core.report.a.c(((com.kwad.components.ad.reward.presenter.a) this).a.g, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
            this.e.post(new Runnable(this, adBaseFrameLayout, dimensionPixelSize, dimensionPixelSize2) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdBaseFrameLayout a;
                public final /* synthetic */ int b;
                public final /* synthetic */ int c;
                public final /* synthetic */ f d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adBaseFrameLayout, Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.d = this;
                    this.a = adBaseFrameLayout;
                    this.b = dimensionPixelSize;
                    this.c = dimensionPixelSize2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int height = this.a.getHeight();
                        f fVar = this.d;
                        fVar.n = fVar.a(this.b, height - this.c);
                        if (this.d.n != null) {
                            this.d.n.start();
                        }
                    }
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.f = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09118f);
            this.g = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09118e);
            this.h = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09118c);
            this.i = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f09118a);
            this.j = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09118b);
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.l.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.b = com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g);
            if (com.kwad.components.ad.fullscreen.a.a.a(u(), ((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(this.o);
                e();
                g();
                a(this.b);
                float o = com.kwad.sdk.core.response.a.b.o(this.b);
                com.kwad.sdk.core.f.d dVar = this.c;
                if (dVar == null) {
                    com.kwad.sdk.core.f.d dVar2 = new com.kwad.sdk.core.f.d(o);
                    this.c = dVar2;
                    dVar2.a(this);
                } else {
                    dVar.a(o);
                }
                this.c.a(u());
                Context u = u();
                if (u != null) {
                    this.d = (Vibrator) u.getSystemService("vibrator");
                }
                com.kwad.components.ad.fullscreen.a.a.a(u());
            }
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d)}) == null) {
            com.kwad.sdk.core.lifecycle.a.c();
            Activity e = com.kwad.sdk.core.lifecycle.a.e();
            Activity s = s();
            boolean z = s != null && s.equals(e);
            if (com.kwad.components.core.c.kwai.b.a() || !z) {
                az.a(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f a;

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

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.c.a();
                        }
                    }
                }, null, 500L);
                return;
            }
            if (((com.kwad.components.ad.reward.presenter.a) this).a != null) {
                com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                fVar.a(d);
                ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), Cea708Decoder.COMMAND_DF5, 1, 0L, false, fVar);
            }
            az.a(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.b.a("ShakePresenter", "onShakeEvent openGate2");
                        this.a.c.a();
                    }
                }
            }, null, 500L);
            az.a(u(), this.d);
        }
    }

    @Override // com.kwad.sdk.core.f.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            this.m = false;
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                if (viewGroup.getParent() != null) {
                    ((ViewGroup) this.e.getParent()).removeView(this.e);
                }
                this.e = null;
            }
            az.b(u(), this.d);
            this.d = null;
            Animator animator = this.n;
            if (animator != null) {
                animator.cancel();
                this.n = null;
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.o);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }
}
