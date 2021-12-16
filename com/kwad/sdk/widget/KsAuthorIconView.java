package com.kwad.sdk.widget;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes3.dex */
public class KsAuthorIconView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public KSCornerImageView f60315b;

    /* renamed from: c  reason: collision with root package name */
    public KSCornerImageView f60316c;

    /* renamed from: d  reason: collision with root package name */
    public KSCornerImageView f60317d;

    /* renamed from: e  reason: collision with root package name */
    public KSCornerImageView f60318e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60319f;

    /* renamed from: g  reason: collision with root package name */
    public View f60320g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60321h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAuthorIconView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context, (AttributeSet) null, 0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context, attributeSet, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 21)
    public KsAuthorIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context, attributeSet, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view)) == null) {
            float width = view.getWidth();
            if (width <= 0.0f) {
                return null;
            }
            float f2 = 1.2f * width;
            com.kwad.sdk.core.d.a.a("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f2);
            ofFloat.addUpdateListener(b(view));
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(create);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f2, width);
            ofFloat2.addUpdateListener(b(view));
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
    public Animator a(View view, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, this, view, j2)) == null) {
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_width));
            ofFloat.addUpdateListener(b(view));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
            Interpolator create = PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(j2);
            animatorSet.setInterpolator(create);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeLJ.objValue;
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, this, context, attributeSet, i2) == null) {
            FrameLayout.inflate(context, R.layout.ksad_author_icon, this);
            this.a = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
            this.f60316c = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
            this.f60315b = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
            this.f60317d = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
            this.f60318e = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
            this.f60319f = (TextView) findViewById(R.id.ksad_fans_count);
            this.f60320g = findViewById(R.id.ksad_author_btn_follow);
            this.f60321h = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        }
    }

    private void a(c cVar, Drawable drawable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, this, cVar, drawable) == null) && (drawable instanceof GradientDrawable)) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), cVar.a());
        }
    }

    public static ValueAnimator.AnimatorUpdateListener b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view)) == null) ? new ValueAnimator.AnimatorUpdateListener(view) { // from class: com.kwad.sdk.widget.KsAuthorIconView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                    if (layoutParams != null) {
                        int i2 = (int) floatValue;
                        layoutParams.width = i2;
                        layoutParams.height = i2;
                        this.a.setLayoutParams(layoutParams);
                    }
                }
            }
        } : (ValueAnimator.AnimatorUpdateListener) invokeL.objValue;
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            String aE = com.kwad.sdk.core.response.a.a.aE(j2);
            if (!TextUtils.isEmpty(aE)) {
                KSImageLoader.loadImage(this.f60316c, aE, adTemplate);
            }
            this.f60319f.setText(com.kwad.sdk.core.response.a.a.aB(j2));
            this.f60317d.post(new Runnable(this) { // from class: com.kwad.sdk.widget.KsAuthorIconView.1
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
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        KsAuthorIconView ksAuthorIconView = this.a;
                        Animator a = ksAuthorIconView.a(ksAuthorIconView.f60317d, 900L);
                        KsAuthorIconView ksAuthorIconView2 = this.a;
                        Animator a2 = ksAuthorIconView2.a(ksAuthorIconView2.f60318e, 1000L);
                        KsAuthorIconView ksAuthorIconView3 = this.a;
                        Animator a3 = ksAuthorIconView3.a(ksAuthorIconView3.f60316c);
                        if (a == null || a2 == null || a3 == null) {
                            return;
                        }
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a3, a, a2);
                        animatorSet.start();
                        a3.addListener(new AnimatorListenerAdapter(this, a, a2, a3) { // from class: com.kwad.sdk.widget.KsAuthorIconView.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Animator a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Animator f60322b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ Animator f60323c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f60324d;

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
                                this.f60324d = this;
                                this.a = a;
                                this.f60322b = a2;
                                this.f60323c = a3;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                    super.onAnimationEnd(animator);
                                    this.a.start();
                                    this.f60322b.start();
                                    this.f60323c.start();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void a(boolean z, c cVar) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, cVar) == null) {
            w.a(cVar, this);
            if (z) {
                imageView = this.f60321h;
                i2 = R.drawable.ksad_reward_follow_arrow_down;
            } else {
                imageView = this.f60321h;
                i2 = R.drawable.ksad_reward_follow_arrow_down_orange;
            }
            imageView.setImageResource(i2);
            a(cVar, this.f60317d.getBackground());
            a(cVar, this.f60315b.getBackground());
            a(cVar, this.f60318e.getBackground());
            a(cVar, this.a.getBackground());
        }
    }
}
