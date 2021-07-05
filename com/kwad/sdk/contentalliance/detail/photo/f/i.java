package com.kwad.sdk.contentalliance.detail.photo.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class i extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34807a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34808b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34809c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f34810d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, AttributeSet attributeSet) {
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
        this.f34807a = 1;
        this.f34808b = null;
        this.f34809c = null;
        c();
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            this.f34810d.d();
            boolean z = i2 == 2;
            this.f34810d.setSpeed(z ? 1.2f : 1.0f);
            this.f34810d.a(true);
            this.f34810d.setAnimation(z ? R.raw.ksad_detail_right_button_like_anim_2 : R.raw.ksad_detail_right_button_unlike_anim_2);
            this.f34810d.setVisibility(0);
            this.f34808b.setVisibility(8);
            this.f34810d.a(new AnimatorListenerAdapter(this, i2, z) { // from class: com.kwad.sdk.contentalliance.detail.photo.f.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f34811a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f34812b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i f34813c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34813c = this;
                    this.f34811a = i2;
                    this.f34812b = z;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.f34813c.setImageView(this.f34811a);
                        this.f34813c.f34808b.setVisibility(0);
                        this.f34813c.f34810d.setVisibility(8);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f34813c.setImageView(this.f34811a);
                        this.f34813c.f34808b.setVisibility(0);
                        this.f34813c.f34810d.setVisibility(8);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ImageView imageView;
                    int i3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f34812b) {
                            imageView = this.f34813c.f34808b;
                            i3 = 8;
                        } else {
                            this.f34813c.setImageView(this.f34811a);
                            imageView = this.f34813c.f34808b;
                            i3 = 0;
                        }
                        imageView.setVisibility(i3);
                    }
                }
            });
            this.f34810d.b();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
            this.f34808b = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
            this.f34809c = (TextView) findViewById(R.id.ksad_photo_like_count_text);
            this.f34810d = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            this.f34808b.setImageResource(i2 == 1 ? R.drawable.ksad_photo_like_button_2_normal : R.drawable.ksad_photo_like_button_2_selected);
        }
    }

    private void setImageViewWithAnimator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            setImageView(i2);
            a(i2);
        }
    }

    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f34807a = i2;
            setImageView(i2);
            setLikeCount(j);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34807a == 2 : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f34810d.c()) {
            this.f34810d.d();
        }
    }

    public int getLikeState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34807a : invokeV.intValue;
    }

    public void setLikeCount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f34809c.setText(ag.a(j, "赞"));
        }
    }

    public void setLikeState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f34807a = i2;
            setImageViewWithAnimator(i2);
        }
    }
}
