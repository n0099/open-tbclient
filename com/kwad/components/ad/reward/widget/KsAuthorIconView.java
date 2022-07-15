package com.kwad.components.ad.reward.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.l.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class KsAuthorIconView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public KSCornerImageView b;
    public KSCornerImageView c;
    public KSCornerImageView d;
    public KSCornerImageView e;
    public TextView f;
    public View g;
    public ImageView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAuthorIconView(@NonNull Context context) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
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
        a(context);
    }

    public static Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            float width = view2.getWidth();
            if (width <= 0.0f) {
                return null;
            }
            float f = 1.2f * width;
            b.a("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
            ofFloat.addUpdateListener(b(view2));
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(create);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
            ofFloat2.addUpdateListener(b(view2));
            Interpolator create2 = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ofFloat2.setDuration(500L);
            ofFloat2.setInterpolator(create2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view2, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, this, view2, j)) == null) {
            if (view2 == null || view2.getWidth() == 0 || view2.getHeight() == 0) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view2.getWidth(), getResources().getDimension(R.dimen.obfuscated_res_0x7f0703b3));
            ofFloat.addUpdateListener(b(view2));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f);
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j);
            animatorSet.setInterpolator(create);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeLJ.objValue;
    }

    private void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0407, this);
            this.a = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090fff);
            this.c = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f090ffe);
            this.b = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f091000);
            this.d = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f090ffa);
            this.e = (KSCornerImageView) findViewById(R.id.obfuscated_res_0x7f090ffb);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091045);
            this.g = findViewById(R.id.obfuscated_res_0x7f090ffd);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ffc);
        }
    }

    private void a(f fVar, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, fVar, drawable) == null) && (drawable instanceof GradientDrawable)) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b1), fVar.a());
        }
    }

    public static ValueAnimator.AnimatorUpdateListener b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) ? new ValueAnimator.AnimatorUpdateListener(view2) { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    if (layoutParams != null) {
                        int i = (int) floatValue;
                        layoutParams.width = i;
                        layoutParams.height = i;
                        this.a.setLayoutParams(layoutParams);
                    }
                }
            }
        } : (ValueAnimator.AnimatorUpdateListener) invokeL.objValue;
    }

    public final void a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            j.a(fVar, this);
            this.h.setImageResource(R.drawable.obfuscated_res_0x7f080c1d);
            a(fVar, this.d.getBackground());
            a(fVar, this.b.getBackground());
            a(fVar, this.e.getBackground());
            a(fVar, this.a.getBackground());
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            AdInfo i = d.i(adTemplate);
            String aZ = a.aZ(i);
            if (!TextUtils.isEmpty(aZ)) {
                KSImageLoader.loadImage(this.c, aZ, adTemplate);
            }
            this.f.setText(a.aW(i));
            this.d.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsAuthorIconView a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                        KsAuthorIconView ksAuthorIconView = this.a;
                        Animator a = ksAuthorIconView.a(ksAuthorIconView.d, 900L);
                        KsAuthorIconView ksAuthorIconView2 = this.a;
                        Animator a2 = ksAuthorIconView2.a(ksAuthorIconView2.e, 1000L);
                        Animator a3 = KsAuthorIconView.a(this.a.c);
                        if (a == null || a2 == null || a3 == null) {
                            return;
                        }
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a3, a, a2);
                        animatorSet.start();
                        a3.addListener(new AnimatorListenerAdapter(this, a, a2, a3) { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Animator a;
                            public final /* synthetic */ Animator b;
                            public final /* synthetic */ Animator c;
                            public final /* synthetic */ AnonymousClass1 d;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, a, a2, a3};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.d = this;
                                this.a = a;
                                this.b = a2;
                                this.c = a3;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                    super.onAnimationEnd(animator);
                                    this.a.start();
                                    this.b.start();
                                    this.c.start();
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
