package com.kwad.components.ad.reflux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reflux.KsRefluxContentView;
import com.kwad.components.ad.reward.c.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.e.b;
/* loaded from: classes7.dex */
public class KsRefluxView extends FrameLayout implements View.OnClickListener, KsRefluxContentView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsAdWebView bF;
    public KsRefluxNativeView kM;
    public View kN;
    public ImageView kO;
    public View kP;
    public a kQ;
    public volatile boolean kR;

    /* loaded from: classes7.dex */
    public interface a {
        void dh();

        void eI();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.kR = false;
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.kR = false;
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
        this.kR = false;
        L(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsRefluxView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.kR = false;
        L(context);
    }

    private void L(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0449, this);
            this.kN = findViewById(R.id.obfuscated_res_0x7f091146);
            this.kO = (ImageView) findViewById(R.id.obfuscated_res_0x7f091139);
            this.bF = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091147);
            this.kM = (KsRefluxNativeView) findViewById(R.id.obfuscated_res_0x7f091142);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091140);
            this.kP = findViewById;
            findViewById.setOnClickListener(this);
            this.kO.setOnClickListener(this);
            ((KsRefluxContentView) findViewById(R.id.obfuscated_res_0x7f091141)).setContentViewListener(this);
        }
    }

    private Animator a(View view2, View view3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, view2, view3)) == null) {
            if (view2 == null || view3 == null || view2.getMeasuredHeight() <= 0) {
                return null;
            }
            Drawable background = view3.getBackground();
            if (background instanceof GradientDrawable) {
                ValueAnimator ofInt = ValueAnimator.ofInt(view2.getMeasuredHeight(), 0);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view2) { // from class: com.kwad.components.ad.reflux.KsRefluxView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsRefluxView kS;
                    public final /* synthetic */ View kT;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.kS = this;
                        this.kT = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            ViewGroup.LayoutParams layoutParams = this.kT.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = intValue;
                                this.kT.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
                ValueAnimator ofFloat = ValueAnimator.ofFloat(getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a0), 0.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (GradientDrawable) background, view3) { // from class: com.kwad.components.ad.reflux.KsRefluxView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ KsRefluxView kS;
                    public final /* synthetic */ GradientDrawable kU;
                    public final /* synthetic */ View kV;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7, view3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.kS = this;
                        this.kU = r7;
                        this.kV = view3;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b.d("KsRefluxView", "actionBar radii value: " + floatValue);
                            this.kU.setCornerRadii(new float[]{floatValue, floatValue, floatValue, floatValue, 0.0f, 0.0f, 0.0f, 0.0f});
                            this.kV.setBackground(this.kU);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300L);
                animatorSet.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
                animatorSet.playTogether(ofInt, ofFloat);
                return animatorSet;
            }
            return null;
        }
        return (Animator) invokeLL.objValue;
    }

    private void eG() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || eH() || this.kR) {
            return;
        }
        Animator a2 = a(this.kO, this.kN);
        a2.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reflux.KsRefluxView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ KsRefluxView kS;

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
                this.kS = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.kS.kR = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    super.onAnimationStart(animator);
                    this.kS.kR = true;
                }
            }
        });
        a2.start();
    }

    private boolean eH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            ImageView imageView = this.kO;
            return imageView != null && imageView.getMeasuredHeight() == 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, view2)) == null) {
            int measuredHeight = view2.getMeasuredHeight();
            if (measuredHeight == 0) {
                return null;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(measuredHeight, getContext().getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07039a));
            ofInt.setDuration(300L);
            ofInt.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, view2) { // from class: com.kwad.components.ad.reflux.KsRefluxView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View dH;
                public final /* synthetic */ KsRefluxView kS;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.kS = this;
                    this.dH = view2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams = this.dH.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = intValue;
                            this.dH.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofInt;
        }
        return (Animator) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean eC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? eH() : invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxContentView.a
    public final boolean eD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (eH()) {
                return false;
            }
            eG();
            return true;
        }
        return invokeV.booleanValue;
    }

    public KsRefluxNativeView getNativeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.kM : (KsRefluxNativeView) invokeV.objValue;
    }

    public KsAdWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bF : (KsAdWebView) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || this.kQ == null) {
            return;
        }
        if (view2.equals(this.kP)) {
            this.kQ.dh();
        } else if (view2.equals(this.kO)) {
            eG();
        }
    }

    public void setInnerAdInteractionListener(c cVar) {
        KsRefluxNativeView ksRefluxNativeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (ksRefluxNativeView = this.kM) == null) {
            return;
        }
        ksRefluxNativeView.setInnerAdInteractionListener(cVar);
    }

    public void setViewListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.kQ = aVar;
        }
    }

    public final void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(0);
            this.kO.post(new Runnable(this) { // from class: com.kwad.components.ad.reflux.KsRefluxView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsRefluxView kS;

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
                    this.kS = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsRefluxView ksRefluxView = this.kS;
                        Animator j = ksRefluxView.j(ksRefluxView.kO);
                        if (j != null) {
                            j.start();
                        }
                        if (this.kS.kQ != null) {
                            this.kS.kQ.eI();
                        }
                    }
                }
            });
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.bF.setVisibility(z ? 0 : 4);
            this.kM.setVisibility(z ? 8 : 0);
        }
    }
}
