package com.kwad.components.ad.reward.k;

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
import androidx.constraintlayout.motion.widget.Key;
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
import com.kwad.sdk.utils.ag;
/* loaded from: classes8.dex */
public final class h extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsLogoView bq;
    @Nullable
    public TextView eQ;
    @Nullable
    public KSCornerImageView it;
    @Nullable
    public TextView iu;
    @Nullable
    public KsPriceView nI;
    public com.kwad.components.ad.reward.k nM;
    @Nullable
    public ViewGroup pV;
    public ViewGroup uL;
    @Nullable
    public TextView uM;
    @Nullable
    public KsStyledTextButton uN;
    @Nullable
    public TextView uO;
    @Nullable
    public TextView uP;
    @Nullable
    public View uQ;
    @Nullable
    public ImageView uR;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String hL;
        public String kY;
        public String np;
        public String oY;
        public String rating;
        public String title;
        public String vb;
        @Nullable
        public String vc;
        public String vd;
        public String ve;

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

        public static a C(AdTemplate adTemplate) {
            InterceptResult invokeL;
            CouponInfo firstCouponList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(bQ);
                a aVar = new a();
                String name = bN.getName();
                aVar.title = name;
                if (TextUtils.isEmpty(name)) {
                    aVar.title = com.kwad.sdk.core.response.a.a.af(bQ);
                }
                aVar.vd = com.kwad.sdk.core.response.a.a.al(bQ);
                aVar.kY = bN.getIcon();
                aVar.np = com.kwad.sdk.core.response.a.a.ad(bQ);
                aVar.vb = bN.getPrice();
                aVar.hL = bN.getOriginPrice();
                aVar.ve = bN.getVolume();
                aVar.rating = bN.getRating();
                if (!bN.isCouponListEmpty() && (firstCouponList = bN.getFirstCouponList()) != null) {
                    aVar.vc = CouponInfo.jinniuFormatCoupon(firstCouponList);
                    aVar.S(firstCouponList.getFormattedJinniuPrefix());
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        private void S(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
                this.oY = str;
            }
        }

        public final String dB() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hL : (String) invokeV.objValue;
        }

        public final String eL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.kY : (String) invokeV.objValue;
        }

        public final String fO() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.np : (String) invokeV.objValue;
        }

        public final String getRating() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rating : (String) invokeV.objValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.title : (String) invokeV.objValue;
        }

        public final String gz() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.oY : (String) invokeV.objValue;
        }

        public final String iS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.vb : (String) invokeV.objValue;
        }

        public final String iT() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.vc : (String) invokeV.objValue;
        }

        public final String iU() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.vd : (String) invokeV.objValue;
        }

        public final String iV() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.ve : (String) invokeV.objValue;
        }
    }

    public h(com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, viewGroup, ksLogoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nM = kVar;
        this.bq = ksLogoView;
        this.uL = viewGroup;
        initView();
    }

    @Nullable
    public static Animator a(View view2, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, view2, f)) == null) {
            if (view2 == null || view2.getWidth() <= 0) {
                return null;
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f070376) + f).setDuration(1000L);
            duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(1000L);
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
            ValueAnimator duration = ValueAnimator.ofInt(height, view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c2)).setDuration(500L);
            duration.setInterpolator(create);
            if (ag.cB(view2.getContext()) && view4 != null && (view4.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view4.getLayoutParams();
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, height, marginLayoutParams, marginLayoutParams.bottomMargin, view4, view2) { // from class: com.kwad.components.ad.reward.k.h.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ h uS;
                    public final /* synthetic */ int uW;
                    public final /* synthetic */ ViewGroup.MarginLayoutParams uX;
                    public final /* synthetic */ int uY;
                    public final /* synthetic */ View uZ;
                    public final /* synthetic */ View va;

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
                        this.uS = this;
                        this.uW = height;
                        this.uX = marginLayoutParams;
                        this.uY = r9;
                        this.uZ = view4;
                        this.va = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = this.uX;
                            marginLayoutParams2.bottomMargin = this.uY + (intValue - this.uW);
                            this.uZ.setLayoutParams(marginLayoutParams2);
                            ViewGroup.LayoutParams layoutParams = this.va.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.height = intValue;
                                this.va.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
            }
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.0f, 0.0f).setDuration(200L);
            Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view3, Key.ALPHA, 0.0f, 1.0f).setDuration(300L);
            duration3.setInterpolator(create2);
            animatorSet.playSequentially(duration2, duration3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(duration, animatorSet);
            return animatorSet2;
        }
        return (Animator) invokeLLL.objValue;
    }

    public static /* synthetic */ Animator a(h hVar, View view2, float f) {
        return a(view2, f);
    }

    private void a(AdTemplate adTemplate, a aVar) {
        TextView textView;
        String rating;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, this, adTemplate, aVar) == null) || aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.it, aVar.eL(), adTemplate, 4);
        TextView textView2 = this.eQ;
        if (textView2 != null) {
            textView2.setText(aVar.getTitle());
        }
        TextView textView3 = this.iu;
        if (textView3 != null) {
            textView3.setText(aVar.fO());
        }
        KsPriceView ksPriceView = this.nI;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cd);
            this.nI.getConfig().ab(dimensionPixelSize).ad(dimensionPixelSize).ac(this.nI.getResources().getColor(R.color.obfuscated_res_0x7f06077a));
            this.nI.d(aVar.iS(), aVar.dB(), true);
        }
        if (this.uM != null) {
            if (!TextUtils.isEmpty(aVar.iV())) {
                textView = this.uM;
                rating = aVar.iV();
            } else if (TextUtils.isEmpty(aVar.getRating())) {
                this.uM.setVisibility(8);
            } else {
                textView = this.uM;
                rating = aVar.getRating();
            }
            textView.setText(rating);
        }
        if (this.uO != null && !TextUtils.isEmpty(aVar.iT())) {
            this.uO.setText(aVar.iT());
        }
        if (this.uN != null && !TextUtils.isEmpty(aVar.iU())) {
            this.uN.setText(aVar.iU());
        }
        int i = TextUtils.isEmpty(aVar.iT()) ? 8 : 0;
        View view2 = this.uQ;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        if (this.uP == null || TextUtils.isEmpty(aVar.gz())) {
            return;
        }
        this.uP.setText(aVar.gz());
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.pV = (ViewGroup) this.uL.findViewById(R.id.obfuscated_res_0x7f091222);
            this.it = (KSCornerImageView) this.uL.findViewById(R.id.obfuscated_res_0x7f09121d);
            this.eQ = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091224);
            this.iu = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f09120c);
            this.nI = (KsPriceView) this.uL.findViewById(R.id.obfuscated_res_0x7f09121f);
            this.uM = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091221);
            this.uN = (KsStyledTextButton) this.uL.findViewById(R.id.obfuscated_res_0x7f091207);
            this.uR = (ImageView) this.uL.findViewById(R.id.obfuscated_res_0x7f09121e);
            this.uQ = this.uL.findViewById(R.id.obfuscated_res_0x7f09120a);
            this.uO = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f091209);
            this.uP = (TextView) this.uL.findViewById(R.id.obfuscated_res_0x7f09120b);
            ViewGroup viewGroup = this.pV;
            if (viewGroup != null) {
                viewGroup.setOnClickListener(this);
            }
            KsStyledTextButton ksStyledTextButton = this.uN;
            if (ksStyledTextButton != null) {
                ksStyledTextButton.setOnClickListener(this);
            }
            Context context = this.pV.getContext();
            if (ag.cB(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.pV.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b5);
                this.pV.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
            super.a(uVar);
            if (uVar == null) {
                return;
            }
            a(uVar.getAdTemplate(), a.C(uVar.getAdTemplate()));
            ViewGroup viewGroup = this.pV;
            if (viewGroup != null) {
                viewGroup.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.h.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ h uS;

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
                        this.uS = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            h hVar = this.uS;
                            Animator a2 = hVar.a(hVar.pV, this.uS.uN, this.uS.bq);
                            if (a2 != null) {
                                a2.start();
                            }
                        }
                    }
                }, 3000L);
                this.pV.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.h.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ h uS;

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
                        this.uS = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.uS.uN == null || this.uS.uN.getWidth() == 0) {
                            return;
                        }
                        h hVar = this.uS;
                        Animator a2 = h.a(hVar, hVar.uR, this.uS.uN.getWidth());
                        if (a2 != null) {
                            a2.addListener(new AnimatorListenerAdapter(this, a2) { // from class: com.kwad.components.ad.reward.k.h.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public int uT;
                                public final /* synthetic */ Animator uU;
                                public final /* synthetic */ AnonymousClass2 uV;

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
                                    this.uV = this;
                                    this.uU = a2;
                                    this.uT = 1;
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                        super.onAnimationEnd(animator);
                                        if (this.uT >= 3) {
                                            return;
                                        }
                                        this.uU.start();
                                        this.uT++;
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

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pV : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.pV)) {
                this.nM.a(view2.getContext(), 118, 2);
            } else if (view2.equals(this.uN)) {
                this.nM.a(view2.getContext(), 1, 1);
            }
        }
    }
}
