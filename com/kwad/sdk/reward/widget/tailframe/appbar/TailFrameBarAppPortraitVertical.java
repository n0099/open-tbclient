package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ax;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes2.dex */
public class TailFrameBarAppPortraitVertical extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59428b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f59429c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59430d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59431e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f59432f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f59433g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f59434h;

    /* renamed from: i  reason: collision with root package name */
    public View f59435i;

    /* renamed from: j  reason: collision with root package name */
    public Button f59436j;

    /* renamed from: k  reason: collision with root package name */
    public Button f59437k;
    @Nullable
    public Animator l;
    public View m;

    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppPortraitVertical(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppPortraitVertical(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        c();
    }

    public static Animator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            return ofFloat;
        }
        return (Animator) invokeL.objValue;
    }

    public static Animator a(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(f2 / f3, f3, view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size), view) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ float f59439b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ float f59440c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ View f59441d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(r6), Float.valueOf(f3), Float.valueOf(r8), view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                    this.f59439b = f3;
                    this.f59440c = r8;
                    this.f59441d = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float f4 = this.a * floatValue;
                        float f5 = this.f59439b;
                        if (f5 != 0.0f) {
                            float f6 = (floatValue / f5) * this.f59440c;
                            View view2 = this.f59441d;
                            if (view2 instanceof TextView) {
                                ((TextView) view2).setTextSize(0, f6);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = this.f59441d.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = (int) floatValue;
                            layoutParams.width = (int) f4;
                            this.f59441d.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofFloat;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator a(View view, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, view, view2, i2, i3)) == null) {
            Animator a2 = a(view);
            float f2 = i2;
            float f3 = i3;
            Animator a3 = a(view2, f2, f3);
            a3.addListener(new a(view) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.3
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
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = view;
                }

                @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.a, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setAlpha(1.0f);
                        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            this.a.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 1.0f, 1.0f);
            ofFloat.setDuration(1600L);
            Animator a4 = a(view2);
            Animator a5 = a(view, f2, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(a2, a3, ofFloat, a4, a5);
            return animatorSet;
        }
        return (Animator) invokeLLII.objValue;
    }

    private void a(LinearLayout linearLayout, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, linearLayout, str) == null) {
            TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.ksad_reward_apk_info_card_tag_item, (ViewGroup) linearLayout, false);
            textView.setText(str);
            this.f59434h.addView(textView);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.m = LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_portrait_vertical, this);
            this.a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f59429c = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f59430d = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f59428b = (TextView) findViewById(R.id.ksad_app_name);
            this.f59431e = (TextView) findViewById(R.id.ksad_app_introduce);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
            this.f59432f = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
            this.f59432f.setTextColor(-1);
            this.f59434h = (LinearLayout) findViewById(R.id.ksad_reward_apk_info_tags);
            this.f59436j = (Button) findViewById(R.id.ksad_reward_apk_info_install_action);
            this.f59437k = (Button) findViewById(R.id.ksad_reward_apk_info_install_start);
            this.f59435i = findViewById(R.id.ksad_reward_apk_info_install_container);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ValueAnimator valueAnimator = this.f59433g;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
                this.f59433g = ofFloat;
                ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
                this.f59433g.setRepeatCount(-1);
                this.f59433g.setRepeatMode(1);
                this.f59433g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TailFrameBarAppPortraitVertical a;

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

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            this.a.f59432f.setScaleY(floatValue);
                            this.a.f59432f.setScaleX(floatValue);
                        }
                    }
                });
                this.f59433g.start();
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int height = this.f59435i.getHeight();
            int width = this.f59435i.getWidth();
            if (height == 0 || width == 0) {
                return;
            }
            if (this.l == null) {
                Animator a2 = a(this.f59437k, this.f59436j, width, height);
                this.l = a2;
                a2.addListener(new a(this) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TailFrameBarAppPortraitVertical a;

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

                    @Override // com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.a, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            ax.a(new Runnable(this, animator) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Animator a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass2 f59438b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, animator};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f59438b = this;
                                    this.a = animator;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.a.start();
                                    }
                                }
                            }, null, 1600L);
                        }
                    }
                });
            }
            if (this.l.isStarted()) {
                return;
            }
            this.l.start();
        }
    }

    public void a(@NonNull AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            int i2 = adInfo.status;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                b();
            } else {
                d();
            }
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String au;
        TextView textView;
        String at;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            if (d.v(adTemplate)) {
                this.m.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
                this.f59428b.setTextColor(Color.parseColor("#FFFFFF"));
                this.f59431e.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                this.m.setBackgroundColor(Color.parseColor("#E6FFFFFF"));
            }
            AdInfo j2 = d.j(adTemplate);
            if (d.v(adTemplate)) {
                imageView = this.a;
                au = com.kwad.sdk.core.response.a.a.aE(j2);
            } else {
                imageView = this.a;
                au = com.kwad.sdk.core.response.a.a.au(j2);
            }
            KSImageLoader.loadAppIcon(imageView, au, adTemplate, 12);
            if (d.v(adTemplate)) {
                textView = this.f59428b;
                at = com.kwad.sdk.core.response.a.a.u(j2);
            } else {
                textView = this.f59428b;
                at = com.kwad.sdk.core.response.a.a.at(j2);
            }
            textView.setText(at);
            int i2 = 0;
            if (!d.v(adTemplate)) {
                float x = com.kwad.sdk.core.response.a.a.x(j2);
                if (x >= 3.0f) {
                    this.f59429c.setScore(x);
                    this.f59429c.setVisibility(0);
                } else {
                    this.f59429c.setVisibility(8);
                }
                String w = com.kwad.sdk.core.response.a.a.w(j2);
                if (TextUtils.isEmpty(w)) {
                    this.f59430d.setVisibility(8);
                } else {
                    this.f59430d.setText(w);
                    this.f59430d.setVisibility(0);
                }
            }
            this.f59431e.setText(com.kwad.sdk.core.response.a.a.s(j2));
            if (d.v(adTemplate)) {
                this.f59432f.setVisibility(8);
                this.f59435i.setVisibility(0);
                this.f59437k.setText("查看详情");
                Button button = this.f59436j;
                button.setText(String.format("浏览详情页%s秒，领取奖励", b.aA() + ""));
                this.f59435i.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitVertical.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TailFrameBarAppPortraitVertical a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
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
                            this.a.a();
                        }
                    }
                }, 1600L);
            } else {
                this.f59432f.setVisibility(0);
                this.f59435i.setVisibility(8);
                a(d.j(adTemplate));
            }
            if (d.v(adTemplate)) {
                List<String> i3 = c.i(adTemplate);
                if (i3 == null || i3.size() <= 0) {
                    this.f59434h.setVisibility(8);
                } else {
                    this.f59434h.setVisibility(0);
                }
                for (String str : i3) {
                    i2++;
                    if (i2 > 3) {
                        return;
                    }
                    a(this.f59434h, str);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ValueAnimator valueAnimator = this.f59433g;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f59433g.cancel();
                this.f59433g.end();
            }
            Animator animator = this.l;
            if (animator == null || !animator.isRunning()) {
                return;
            }
            this.l.cancel();
            this.l.end();
        }
    }

    public TextProgressBar getTextProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59432f : (TextProgressBar) invokeV.objValue;
    }
}
