package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class g extends v implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView eQ;
    public com.kwad.components.ad.reward.k nM;

    /* loaded from: classes7.dex */
    public interface a {
        void gX();
    }

    public g(com.kwad.components.ad.reward.k kVar) {
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
        this.nM = kVar;
    }

    public static Animator n(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            int dimensionPixelSize = view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070377);
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, -dimensionPixelSize).setDuration(500L);
            duration.setInterpolator(create);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f).setDuration(500L);
            duration3.setInterpolator(create);
            animatorSet.playSequentially(duration, duration2, duration3);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    public final void a(a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, aVar, j) == null) {
            Animator n = n(this.pV);
            if (n == null) {
                aVar.gX();
                return;
            }
            n.addListener(new AnimatorListenerAdapter(this, aVar) { // from class: com.kwad.components.ad.reward.k.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a uI;
                public final /* synthetic */ g uJ;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.uJ = this;
                    this.uI = aVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        a aVar2 = this.uI;
                        if (aVar2 != null) {
                            aVar2.gX();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        a aVar2 = this.uI;
                        if (aVar2 != null) {
                            aVar2.gX();
                        }
                    }
                }
            });
            this.pV.postDelayed(new Runnable(this, n) { // from class: com.kwad.components.ad.reward.k.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g uJ;
                public final /* synthetic */ Animator uK;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, n};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.uJ = this;
                    this.uK = n;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.uK.start();
                    }
                }
            }, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        String str;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) {
            super.a(uVar);
            AdTemplate adTemplate = uVar.getAdTemplate();
            if (adTemplate == null || (str = com.kwad.sdk.core.response.a.b.bA(adTemplate).title) == null || (textView = this.eQ) == null) {
                return;
            }
            textView.setText(str);
        }
    }

    public final void e(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            super.a(viewGroup, R.id.obfuscated_res_0x7f091083, R.id.obfuscated_res_0x7f091081);
            if (this.eQ == null) {
                this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091082);
            }
            this.pV.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.reward.k.v, com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pV : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.equals(this.pV)) {
            com.kwad.components.ad.reward.k kVar = this.nM;
            kVar.a(kVar.mContext, 1, 1);
        }
    }
}
