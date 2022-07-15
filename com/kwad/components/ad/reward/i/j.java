package com.kwad.components.ad.reward.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public final class j extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.l a;
    public ViewGroup b;
    @Nullable
    public ViewGroup c;
    @Nullable
    public KSCornerImageView d;
    @Nullable
    public TextView e;
    @Nullable
    public TextView f;
    @Nullable
    public KsPriceView g;
    @Nullable
    public TextView h;
    @Nullable
    public KsStyledTextButton i;
    @Nullable
    public TextView j;
    @Nullable
    public TextView k;
    @Nullable
    public View l;
    @Nullable
    public ImageView m;
    @Nullable
    public KsLogoView n;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        @Nullable
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            CouponInfo firstCouponList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(i);
                a aVar = new a();
                String name = bd.getName();
                aVar.b = name;
                if (TextUtils.isEmpty(name)) {
                    aVar.b = com.kwad.sdk.core.response.a.a.B(i);
                }
                aVar.g = com.kwad.sdk.core.response.a.a.H(i);
                aVar.a = bd.getIcon();
                aVar.c = com.kwad.sdk.core.response.a.a.z(i);
                aVar.d = bd.getPrice();
                aVar.e = bd.getOriginPrice();
                aVar.h = bd.getVolume();
                aVar.i = bd.getRating();
                if (!bd.isCouponListEmpty() && (firstCouponList = bd.getFirstCouponList()) != null) {
                    aVar.f = CouponInfo.jinniuFormatCoupon(firstCouponList);
                    aVar.a(firstCouponList.getFormattedJinniuPrefix());
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        private void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                this.j = str;
            }
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (String) invokeV.objValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
        }

        public final String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (String) invokeV.objValue;
        }

        public final String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (String) invokeV.objValue;
        }

        public final String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.h : (String) invokeV.objValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public final String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (String) invokeV.objValue;
        }
    }

    public j(com.kwad.components.ad.reward.l lVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, viewGroup, ksLogoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lVar;
        this.n = ksLogoView;
        this.b = viewGroup;
        c();
    }

    @Nullable
    public static Animator a(View view2, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, view2, f)) == null) {
            if (view2 == null || view2.getWidth() <= 0) {
                return null;
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "translationX", view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f070378) + f).setDuration(1000L);
            duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 1.0f).setDuration(1000L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(duration, duration2);
            return animatorSet;
        }
        return (Animator) invokeLF.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(View view2, View view3, View view4) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, view2, view3, view4)) == null) {
            int height = view2.getHeight();
            if (height <= 0 || view2.getLayoutParams() == null) {
                return null;
            }
            Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
            ValueAnimator duration = ValueAnimator.ofInt(height, view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c4)).setDuration(500L);
            duration.setInterpolator(create);
            if (ae.e(view2.getContext()) && view4 != null && (view4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, height, marginLayoutParams, marginLayoutParams.bottomMargin, view4, view2) { // from class: com.kwad.components.ad.reward.i.j.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;
                    public final /* synthetic */ ViewGroup.MarginLayoutParams b;
                    public final /* synthetic */ int c;
                    public final /* synthetic */ View d;
                    public final /* synthetic */ View e;
                    public final /* synthetic */ j f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(height), marginLayoutParams, Integer.valueOf(r9), view4, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f = this;
                        this.a = height;
                        this.b = marginLayoutParams;
                        this.c = r9;
                        this.d = view4;
                        this.e = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = this.b;
                            marginLayoutParams2.bottomMargin = this.c + (intValue - this.a);
                            this.d.setLayoutParams(marginLayoutParams2);
                            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = intValue;
                                this.e.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view3, "alpha", 0.0f, 0.0f).setDuration(200L);
            Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view3, "alpha", 0.0f, 1.0f).setDuration(300L);
            duration3.setInterpolator(create2);
            animatorSet.playSequentially(duration2, duration3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(duration, animatorSet);
            return animatorSet2;
        }
        return (Animator) invokeLLL.objValue;
    }

    private void a(AdTemplate adTemplate, a aVar) {
        TextView textView;
        String i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, adTemplate, aVar) == null) || aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.d, aVar.a(), adTemplate, 4);
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(aVar.b());
        }
        TextView textView3 = this.f;
        if (textView3 != null) {
            textView3.setText(aVar.c());
        }
        KsPriceView ksPriceView = this.g;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf);
            this.g.getConfig().a(dimensionPixelSize).c(dimensionPixelSize).b(this.g.getResources().getColor(R.color.obfuscated_res_0x7f060755));
            this.g.a(aVar.d(), aVar.e(), true);
        }
        if (this.h != null) {
            if (!TextUtils.isEmpty(aVar.h())) {
                textView = this.h;
                i = aVar.h();
            } else if (TextUtils.isEmpty(aVar.i())) {
                this.h.setVisibility(8);
            } else {
                textView = this.h;
                i = aVar.i();
            }
            textView.setText(i);
        }
        if (this.j != null && !TextUtils.isEmpty(aVar.f())) {
            this.j.setText(aVar.f());
        }
        if (this.i != null && !TextUtils.isEmpty(aVar.g())) {
            this.i.setText(aVar.g());
        }
        int i2 = TextUtils.isEmpty(aVar.f()) ? 8 : 0;
        View view2 = this.l;
        if (view2 != null) {
            view2.setVisibility(i2);
        }
        if (this.k == null || TextUtils.isEmpty(aVar.j())) {
            return;
        }
        this.k.setText(aVar.j());
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.c = (ViewGroup) this.b.findViewById(R.id.obfuscated_res_0x7f091131);
            this.d = (KSCornerImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09112c);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091133);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09111b);
            this.g = (KsPriceView) this.b.findViewById(R.id.obfuscated_res_0x7f09112e);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091130);
            this.i = (KsStyledTextButton) this.b.findViewById(R.id.obfuscated_res_0x7f091116);
            this.m = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09112d);
            this.l = this.b.findViewById(R.id.obfuscated_res_0x7f091119);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091118);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09111a);
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(this);
            }
            KsStyledTextButton ksStyledTextButton = this.i;
            if (ksStyledTextButton != null) {
                ksStyledTextButton.setOnClickListener(this);
            }
            Context context = this.c.getContext();
            if (ae.e(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b7);
                this.c.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) {
            super.a(wVar);
            if (wVar == null) {
                return;
            }
            a(wVar.a(), a.a(wVar.a()));
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                viewGroup.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.j.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ j a;

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
                            j jVar = this.a;
                            Animator a2 = jVar.a(jVar.c, this.a.i, this.a.n);
                            if (a2 != null) {
                                a2.start();
                            }
                        }
                    }
                }, 3000L);
                this.c.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.j.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ j a;

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
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.i == null || this.a.i.getWidth() == 0) {
                            return;
                        }
                        Animator a2 = j.a(this.a.m, this.a.i.getWidth());
                        if (a2 != null) {
                            a2.addListener(new AnimatorListenerAdapter(this, a2) { // from class: com.kwad.components.ad.reward.i.j.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Animator a;
                                public final /* synthetic */ AnonymousClass2 b;
                                public int c;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, a2};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.b = this;
                                    this.a = a2;
                                    this.c = 1;
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                        super.onAnimationEnd(animator);
                                        if (this.c >= 3) {
                                            return;
                                        }
                                        this.a.start();
                                        this.c++;
                                    }
                                }
                            });
                            a2.start();
                        }
                    }
                }, 5000L);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.c)) {
                this.a.a(view2.getContext(), 118, 2);
            } else if (view2.equals(this.i)) {
                this.a.a(view2.getContext(), 1, 1);
            }
        }
    }
}
