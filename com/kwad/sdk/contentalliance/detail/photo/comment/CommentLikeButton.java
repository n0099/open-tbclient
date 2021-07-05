package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class CommentLikeButton extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34646a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f34647b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34648c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f34649d;

    /* renamed from: e  reason: collision with root package name */
    public long f34650e;

    /* renamed from: f  reason: collision with root package name */
    public a f34651f;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentLikeButton(Context context) {
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
        this.f34646a = 1;
        this.f34647b = null;
        this.f34648c = null;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentLikeButton(Context context, AttributeSet attributeSet) {
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
        this.f34646a = 1;
        this.f34647b = null;
        this.f34648c = null;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentLikeButton(Context context, AttributeSet attributeSet, int i2) {
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
        this.f34646a = 1;
        this.f34647b = null;
        this.f34648c = null;
        c();
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65540, this, i2) == null) {
            this.f34649d.d();
            boolean z = i2 == 2;
            this.f34649d.a(true);
            this.f34649d.setAnimation(z ? R.raw.ksad_detail_comment_like_anim_2 : R.raw.ksad_detail_comment_unlike_anim_2);
            this.f34649d.setVisibility(0);
            this.f34649d.a(new AnimatorListenerAdapter(this, i2) { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f34652a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CommentLikeButton f34653b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34653b = this;
                    this.f34652a = i2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.f34653b.setImageView(this.f34652a);
                        this.f34653b.f34647b.setVisibility(0);
                        this.f34653b.f34649d.setVisibility(8);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f34653b.setImageView(this.f34652a);
                        this.f34653b.f34647b.setVisibility(0);
                        this.f34653b.f34649d.setVisibility(8);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationStart(animator);
                        this.f34653b.f34647b.setVisibility(8);
                    }
                }
            });
            this.f34649d.b();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_comment_like_button_2, (ViewGroup) this, true);
            this.f34647b = (ImageView) findViewById(R.id.ksad_photo_comment_like_button_image);
            this.f34648c = (TextView) findViewById(R.id.ksad_photo_comment_like_count_text);
            this.f34649d = (LottieAnimationView) findViewById(R.id.ksad_photo_comment_like_animation_view);
            setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            this.f34647b.setImageResource(i2 == 1 ? R.drawable.ksad_photo_comment_like_button_2_normal : R.drawable.ksad_photo_comment_like_button_2_selected);
        }
    }

    private void setImageViewWithAnimator(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            setImageView(i2);
            a(i2);
        }
    }

    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f34646a = i2;
            setImageView(i2);
            this.f34649d.setVisibility(8);
            this.f34650e = j;
            setLikeCount(j);
            setLikeCountColor(i2);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34646a == 2 : invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f34649d.c()) {
            this.f34649d.d();
        }
    }

    public int getLikeState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34646a : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (a()) {
                setLikeState(1);
                a aVar = this.f34651f;
                if (aVar != null) {
                    aVar.a(1);
                }
                j = this.f34650e - 1;
            } else {
                setLikeState(2);
                a aVar2 = this.f34651f;
                if (aVar2 != null) {
                    aVar2.a(2);
                }
                j = this.f34650e + 1;
            }
            this.f34650e = j;
            setLikeCount(j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            b();
        }
    }

    public void setLikeCount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.f34648c.setText(ag.a(j, ""));
        }
    }

    public void setLikeCountColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f34648c.setTextColor(i2 == 2 ? -61862 : -7828591);
        }
    }

    public void setLikeState(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f34646a = i2;
            setImageViewWithAnimator(i2);
            setLikeCountColor(i2);
        }
    }

    public void setLikeStateListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.f34651f = aVar;
        }
    }
}
