package com.kwad.sdk.reward.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.reward.d.d;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f59553b;

    /* renamed from: c  reason: collision with root package name */
    public View f59554c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59555d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59556e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59557f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59558g;

    /* renamed from: h  reason: collision with root package name */
    public Button f59559h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public b f59560i;

    /* renamed from: com.kwad.sdk.reward.kwai.a$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f59561b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f59562c;

        public AnonymousClass1(a aVar, AdTemplate adTemplate, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, adTemplate, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59562c = aVar;
            this.a = adTemplate;
            this.f59561b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f59562c;
                Animator a = aVar.a(aVar.f59554c);
                a.addListener(new AnimatorListenerAdapter(this, a) { // from class: com.kwad.sdk.reward.kwai.a.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Animator a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f59563b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59563b = this;
                        this.a = a;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            this.a.removeListener(this);
                            com.kwad.sdk.core.report.a.c(this.f59563b.a, 169, null);
                            a aVar2 = this.f59563b.f59562c;
                            aVar2.a(aVar2.f59555d, this.f59563b.f59561b).start();
                            ax.a(new Runnable(this) { // from class: com.kwad.sdk.reward.kwai.a.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ C21131 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.a.f59563b.f59562c.b();
                                    }
                                }
                            }, null, this.f59563b.f59561b);
                        }
                    }
                });
                a.start();
            }
        }
    }

    /* renamed from: com.kwad.sdk.reward.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2115a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f59565b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f59566c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f59567d;

        public C2115a(@NonNull CouponInfo couponInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = couponInfo.displayTitle;
            this.f59565b = couponInfo.displayValue;
            this.f59566c = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.f59567d = couponInfo.displayActionWords;
        }

        @Nullable
        public static C2115a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            List<CouponInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.j(adTemplate));
                if (aK == null || (list = aK.couponList) == null || list.size() <= 0) {
                    return null;
                }
                return a(aK.couponList.get(0));
            }
            return (C2115a) invokeL.objValue;
        }

        @Nullable
        public static C2115a a(CouponInfo couponInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, couponInfo)) == null) {
                if (couponInfo == null) {
                    return null;
                }
                return new C2115a(couponInfo);
            }
            return (C2115a) invokeL.objValue;
        }

        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (CharSequence) invokeV.objValue;
        }

        public CharSequence a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
                SpannableString spannableString = new SpannableString("¥" + ((Object) this.f59565b));
                spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
                return spannableString;
            }
            return (CharSequence) invokeL.objValue;
        }

        public CharSequence b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59566c : (CharSequence) invokeV.objValue;
        }

        public CharSequence c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59567d : (CharSequence) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59553b = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.a = viewGroup2;
        a(context, viewGroup2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_Y, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(ImageView imageView, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, this, imageView, j2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, AnimationProperty.OPACITY, imageView.getAlpha(), 0.0f);
            ofFloat.setDuration(j2);
            return ofFloat;
        }
        return (Animator) invokeLJ.objValue;
    }

    private void a(Context context, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, viewGroup) == null) {
            this.f59554c = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
            this.f59555d = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
            this.f59556e = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
            this.f59557f = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
            this.f59558g = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
            Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
            this.f59559h = button;
            button.setOnClickListener(this);
        }
    }

    private void a(C2115a c2115a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, c2115a) == null) || c2115a == null) {
            return;
        }
        TextView textView = this.f59556e;
        if (textView != null) {
            textView.setText(c2115a.a());
        }
        TextView textView2 = this.f59557f;
        if (textView2 != null) {
            textView2.setText(c2115a.a(this.a.getContext()));
        }
        TextView textView3 = this.f59558g;
        if (textView3 != null) {
            textView3.setText(c2115a.b());
        }
        Button button = this.f59559h;
        if (button != null) {
            button.setText(c2115a.c());
        }
    }

    private Animator b(View view) {
        InterceptResult invokeL;
        ObjectAnimator objectAnimator;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, view)) == null) {
            Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_Y, 1.0f, 0.0f);
            ofFloat.setInterpolator(create);
            ofFloat2.setInterpolator(create);
            int[] iArr = this.f59553b;
            ObjectAnimator objectAnimator2 = null;
            if (iArr == null || iArr.length < 2 || (c2 = bb.c(view)) == null) {
                objectAnimator = null;
            } else {
                Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
                objectAnimator2 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, this.f59553b[0] - c2[0]);
                objectAnimator = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, this.f59553b[1] - c2[1]);
                objectAnimator2.setInterpolator(create2);
                objectAnimator.setInterpolator(create2);
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 1.0f);
            ofFloat3.setDuration(200L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
            ofFloat4.setDuration(200L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat3, ofFloat4);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(500L);
            if (objectAnimator2 != null) {
                animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator2, objectAnimator);
            } else {
                animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
            }
            return animatorSet2;
        }
        return (Animator) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Animator b2 = b(this.f59554c);
            b2.addListener(new AnimatorListenerAdapter(this, b2) { // from class: com.kwad.sdk.reward.kwai.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animator a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59564b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, b2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59564b = this;
                    this.a = b2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.removeListener(this);
                        if (this.f59564b.f59560i != null) {
                            this.f59564b.f59560i.b();
                        }
                    }
                }
            });
            b2.start();
        }
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a(adTemplate);
            a(C2115a.a(adTemplate));
            this.a.post(new AnonymousClass1(this, adTemplate, com.kwad.sdk.core.config.b.aN()));
        }
    }

    public void a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f59560i = bVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.equals(this.f59559h) && (bVar = this.f59560i) != null) {
            bVar.a();
        }
    }
}
