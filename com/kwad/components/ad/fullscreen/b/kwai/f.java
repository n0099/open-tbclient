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
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.m.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, com.kwad.sdk.core.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public ViewGroup eP;
    public TextView eQ;
    public TextView eR;
    public ImageView eS;
    public FrameLayout eT;
    public ImageView eU;
    public FrameLayout eV;
    public TextView eW;
    public boolean eX;
    @Nullable
    public Animator eY;
    public AdInfo mAdInfo;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener;

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
        this.eX = false;
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f eZ;

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
                this.eZ = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    f.a(this.eZ, true);
                    if (this.eZ.eP != null) {
                        this.eZ.eP.setVisibility(8);
                    }
                    if (this.eZ.eV != null) {
                        this.eZ.eV.setVisibility(8);
                    }
                    if (this.eZ.eN != null) {
                        this.eZ.eN.bA(this.eZ.getContext());
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
            if (this.eP == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Resources resources = this.eP.getResources();
            Animator a = n.a(this.eS, null, 100L, 16.0f);
            a.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.eZ.eS.setPivotX(this.eZ.eS.getWidth());
                        this.eZ.eS.setPivotY(this.eZ.eS.getHeight());
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eP, Key.TRANSLATION_X, f - (this.eP.getLeft() + (this.eP.getWidth() / 2.0f)));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eP, Key.TRANSLATION_Y, f2 - (this.eP.getTop() + (this.eP.getHeight() / 2.0f)));
            float dimension = resources.getDimension(R.dimen.obfuscated_res_0x7f070364);
            float dimension2 = resources.getDimension(R.dimen.obfuscated_res_0x7f070368);
            float width = this.eT.getWidth();
            float width2 = this.eS.getWidth();
            if (width == 0.0f || width2 == 0.0f) {
                return null;
            }
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
            ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.eU) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
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
            ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.eS) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
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
            int color = resources.getColor(R.color.obfuscated_res_0x7f060788);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f060784);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070369);
            ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
            ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, color2, dimensionPixelSize) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;
                public final /* synthetic */ int fj;
                public final /* synthetic */ int fk;

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
                    this.eZ = this;
                    this.fj = color2;
                    this.fk = dimensionPixelSize;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        GradientDrawable gradientDrawable = (GradientDrawable) this.eZ.eU.getBackground();
                        gradientDrawable.mutate();
                        gradientDrawable.setColor(intValue);
                        if (intValue == this.fj) {
                            gradientDrawable.setStroke(this.fk, -1);
                        }
                        this.eZ.eU.setBackground(gradientDrawable);
                    }
                }
            });
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat5.setDuration(200L);
            ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.eZ.eQ.setAlpha(floatValue);
                        this.eZ.eR.setAlpha(floatValue);
                    }
                }
            });
            ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.eQ.getHeight(), 0.0f);
            ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.eQ) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
                }

                @Override // com.kwad.components.ad.widget.a
                public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, layoutParams, obj) == null) {
                        layoutParams.height = (int) ((Float) obj).floatValue();
                    }
                }
            });
            ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.eR.getHeight(), 0.0f);
            ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this, this.eR) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
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
            animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
            AnimatorSet animatorSet3 = new AnimatorSet();
            Animator clone = a.clone();
            clone.addListener(new AnimatorListenerAdapter(this, dimension2, clone) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;
                public boolean fa;
                public final /* synthetic */ float fb;
                public final /* synthetic */ Animator fc;

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
                    this.eZ = this;
                    this.fb = dimension2;
                    this.fc = clone;
                    this.fa = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.fa = true;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.fa) {
                            return;
                        }
                        this.fc.start();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.eZ.eS.setPivotX(this.fb);
                        this.eZ.eS.setPivotY(this.fb);
                    }
                }
            });
            ViewGroup.LayoutParams layoutParams = this.eV.getLayoutParams();
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.obfuscated_res_0x7f07036b)).setDuration(500L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, duration, layoutParams) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;
                public final /* synthetic */ ValueAnimator fe;
                public final /* synthetic */ ViewGroup.LayoutParams ff;

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
                    this.eZ = this;
                    this.fe = duration;
                    this.ff = layoutParams;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        try {
                            if (this.eZ.eV == null) {
                                this.fe.cancel();
                            } else if (this.eZ.eX) {
                                this.eZ.eV.setVisibility(8);
                                this.fe.cancel();
                            } else {
                                this.eZ.eV.setVisibility(0);
                                this.ff.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                this.eZ.eV.setLayoutParams(this.ff);
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            com.kwad.components.core.b.a.b(e);
                        }
                    }
                }
            });
            animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.eW, Key.ALPHA, 0.0f, 1.0f).setDuration(500L));
            animatorSet.playSequentially(a, a.clone(), a.clone(), ofFloat5, animatorSet2, animatorSet3);
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static String a(k kVar, AdInfo adInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, kVar, adInfo)) == null) {
            String cj = com.kwad.sdk.core.response.a.b.cj(adInfo);
            com.kwad.components.core.c.a.c cVar = kVar.mApkDownloadHelper;
            if (!com.kwad.sdk.core.response.a.a.am(adInfo) || cVar == null) {
                return cj;
            }
            int mI = cVar.mI();
            AdMatrixInfo.DownloadTexts ck = com.kwad.sdk.core.response.a.b.ck(adInfo);
            return mI != 8 ? mI != 12 ? ck.adActionDescription : ck.openAppLabel : ck.installAppLabel;
        }
        return (String) invokeLL.objValue;
    }

    private void a(AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, adInfo) == null) {
            String ci = com.kwad.sdk.core.response.a.b.ci(adInfo);
            TextView textView = this.eQ;
            if (textView != null) {
                textView.setText(ci);
            }
            TextView textView2 = this.eW;
            if (textView2 != null) {
                textView2.setText(ci);
            }
            String a = a(this.nM, adInfo);
            TextView textView3 = this.eR;
            if (textView3 != null) {
                textView3.setText("或点击" + a);
            }
        }
    }

    public static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.eX = true;
        return true;
    }

    private void bW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0912b6);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d047f, (ViewGroup) adBaseFrameLayout, false);
            this.eP = viewGroup;
            viewGroup.setVisibility(0);
            Resources resources = this.eP.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070366);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070365);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036a);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070364);
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0480, (ViewGroup) adBaseFrameLayout, false);
            this.eV = frameLayout;
            this.eW = (TextView) frameLayout.findViewById(R.id.obfuscated_res_0x7f0912c6);
            this.eV.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.bottomMargin = dimensionPixelSize3;
            layoutParams.gravity = 83;
            adBaseFrameLayout.addView(this.eV, layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            adBaseFrameLayout.addView(this.eP, layoutParams2);
            com.kwad.sdk.core.report.a.c(this.nM.mAdTemplate, (int) Constants.METHOD_IM_SEND_MCAST_MSG, (JSONObject) null);
            this.eP.post(new Runnable(this, adBaseFrameLayout, dimensionPixelSize, dimensionPixelSize2) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;
                public final /* synthetic */ AdBaseFrameLayout fg;
                public final /* synthetic */ int fh;
                public final /* synthetic */ int fi;

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
                    this.eZ = this;
                    this.fg = adBaseFrameLayout;
                    this.fh = dimensionPixelSize;
                    this.fi = dimensionPixelSize2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int height = this.fg.getHeight();
                        f fVar = this.eZ;
                        fVar.eY = fVar.a(this.fh, height - this.fi);
                        if (this.eZ.eY != null) {
                            this.eZ.eY.start();
                        }
                    }
                }
            });
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            this.eQ = (TextView) this.eP.findViewById(R.id.obfuscated_res_0x7f0912c3);
            this.eR = (TextView) this.eP.findViewById(R.id.obfuscated_res_0x7f0912c2);
            this.eS = (ImageView) this.eP.findViewById(R.id.obfuscated_res_0x7f0912c0);
            this.eT = (FrameLayout) this.eP.findViewById(R.id.obfuscated_res_0x7f0912be);
            this.eU = (ImageView) this.eP.findViewById(R.id.obfuscated_res_0x7f0912bf);
            this.eQ.setOnClickListener(this);
            this.eR.setOnClickListener(this);
            this.eT.setOnClickListener(this);
            this.eW.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
            com.kwad.sdk.core.c.b.tp();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            Activity activity = getActivity();
            boolean z = activity != null && activity.equals(currentActivity);
            if (com.kwad.components.core.c.kwai.b.mq() || !z) {
                bd.a(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ f eZ;

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
                        this.eZ = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.eZ.eN.vb();
                        }
                    }
                }, null, 500L);
                return;
            }
            if (this.nM != null) {
                com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                fVar.e(d);
                this.nM.a(getContext(), Cea708Decoder.COMMAND_DF5, 1, 0L, false, fVar);
            }
            bd.a(new Runnable(this) { // from class: com.kwad.components.ad.fullscreen.b.kwai.f.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f eZ;

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
                    this.eZ = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.e.b.d("ShakePresenter", "onShakeEvent openGate2");
                        this.eZ.eN.vb();
                    }
                }
            }, null, 500L);
            bd.a(getContext(), this.eO);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.aq();
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate);
            if (com.kwad.components.ad.fullscreen.a.a.a(getContext(), this.nM.mAdTemplate)) {
                this.nM.a(this.mPlayEndPageListener);
                bW();
                initView();
                a(this.mAdInfo);
                float ch = com.kwad.sdk.core.response.a.b.ch(this.mAdInfo);
                com.kwad.sdk.core.g.d dVar = this.eN;
                if (dVar == null) {
                    com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(ch);
                    this.eN = dVar2;
                    dVar2.a(this);
                } else {
                    dVar.d(ch);
                }
                this.eN.bz(getContext());
                Context context = getContext();
                if (context != null) {
                    this.eO = (Vibrator) context.getSystemService("vibrator");
                }
                com.kwad.components.ad.fullscreen.a.a.G(getContext());
            }
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void bX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.nM.a(getContext(), Cea708Decoder.COMMAND_DF6, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCreate();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            this.eX = false;
            ViewGroup viewGroup = this.eP;
            if (viewGroup != null) {
                if (viewGroup.getParent() != null) {
                    ((ViewGroup) this.eP.getParent()).removeView(this.eP);
                }
                this.eP = null;
            }
            bd.b(getContext(), this.eO);
            this.eO = null;
            Animator animator = this.eY;
            if (animator != null) {
                animator.cancel();
                this.eY = null;
            }
            this.nM.b(this.mPlayEndPageListener);
        }
    }
}
