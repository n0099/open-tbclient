package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public final class k extends v implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView iu;
    public ImageView nC;
    public com.kwad.components.ad.reward.k nM;
    public ImageView vo;
    public TextView vp;
    public View vq;
    public TextView vr;
    public View vs;
    public Set<ImageView> vt;
    public TextView vu;
    public Animator vv;

    public k(com.kwad.components.ad.reward.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vt = new HashSet();
        this.nM = kVar;
    }

    public static Animator a(View view2, long j, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view2, Long.valueOf(j), Float.valueOf(f)})) == null) {
            if (view2 == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view2.setPivotX(0.0f);
            view2.setPivotY(view2.getHeight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f);
            ofFloat.setDuration(100L);
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.ROTATION, 0.0f, f).setDuration(j);
            float f2 = -f;
            long j2 = j * 2;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ROTATION, f, f2).setDuration(j2);
            duration2.setInterpolator(create);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, Key.ROTATION, f2, f).setDuration(j2);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(view2, Key.ROTATION, f, f2).setDuration(j2);
            duration4.setInterpolator(create);
            animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view2, Key.ROTATION, f2, 0.0f).setDuration(j));
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, aVar) == null) {
            this.vp.setText(aVar.getTitle());
            this.iu.setText(aVar.gJ());
            String eL = aVar.eL();
            Drawable drawable = this.nC.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bf8);
            KSImageLoader.loadCircleIcon(this.nC, eL, drawable);
            String aj = com.kwad.components.ad.c.b.aj();
            if (!ax.dT(aj)) {
                KSImageLoader.loadImage(this.vo, aj, aVar.gA());
            }
            if (!aVar.gH()) {
                this.vs.setVisibility(8);
                return;
            }
            this.vs.setVisibility(0);
            String gE = aVar.gE();
            if (!TextUtils.isEmpty(gE)) {
                this.vu.setText(String.format("%s已预约直播", gE));
            }
            if (aVar.gI() != null) {
                List<String> gI = aVar.gI();
                int i = 0;
                for (ImageView imageView : this.vt) {
                    if (i < gI.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, gI.get(i), drawable);
                    }
                    i++;
                }
            }
        }
    }

    private void iX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.vr.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k vw;

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
                    this.vw = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k kVar = this.vw;
                        kVar.vv = k.a(kVar.vr, 100L, 8.0f);
                        this.vw.vv.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.k.k.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 vx;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.vx = this;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                    super.onAnimationEnd(animator);
                                    if (this.vx.vw.vv != null) {
                                        this.vx.vw.vv.start();
                                    }
                                }
                            }
                        });
                        this.vw.vv.start();
                    }
                }
            }, 500L);
        }
    }

    private void iY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            bd.runOnUiThreadDelay(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k vw;

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
                    this.vw = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k.o(this.vw.vs).start();
                    }
                }
            }, 2000L);
        }
    }

    private void initView() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (viewGroup = this.pV) == null) {
            return;
        }
        this.vr = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09116d);
        this.vo = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091176);
        this.nC = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091175);
        this.vp = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091177);
        this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091170);
        this.vq = this.pV.findViewById(R.id.obfuscated_res_0x7f09116e);
        this.vs = this.pV.findViewById(R.id.obfuscated_res_0x7f091171);
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091172));
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091173));
        this.vt.add((ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091174));
        this.vu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09116f);
        this.pV.setOnClickListener(this);
        this.vq.setOnClickListener(this);
    }

    public static Animator o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view2)) == null) {
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f07037c)).setDuration(250L);
            duration.setInterpolator(create);
            return duration;
        }
        return (Animator) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
            super.a(uVar);
            AdTemplate adTemplate = uVar.getAdTemplate();
            if (adTemplate != null) {
                a(com.kwad.components.ad.reward.model.a.x(adTemplate));
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.aa(z);
            Context context = this.pV.getContext();
            if (ag.cB(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.pV.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070382);
            this.pV.setLayoutParams(layoutParams);
        }
    }

    public final void f(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            super.a(viewGroup, R.id.obfuscated_res_0x7f09117a, R.id.obfuscated_res_0x7f091179);
            initView();
        }
    }

    public final void iW() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            iX();
            iY();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.equals(this.vq)) {
                this.nM.a(view2.getContext(), 29, 1);
            } else if (view2.equals(this.pV)) {
                this.nM.a(view2.getContext(), 53, 2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onUnbind();
            Animator animator = this.vv;
            if (animator != null) {
                animator.cancel();
                this.vv = null;
            }
        }
    }
}
