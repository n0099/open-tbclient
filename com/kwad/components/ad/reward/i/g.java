package com.kwad.components.ad.reward.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class g extends x implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public com.kwad.components.ad.reward.l b;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public g(com.kwad.components.ad.reward.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = lVar;
    }

    public static Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            int dimensionPixelSize = view2.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070379);
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "translationY", -dimensionPixelSize).setDuration(500L);
            duration.setInterpolator(create);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 1.0f).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "translationY", 0.0f).setDuration(500L);
            duration3.setInterpolator(create);
            animatorSet.playSequentially(duration, duration2, duration3);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    @Override // com.kwad.components.ad.reward.i.x, com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (ViewGroup) invokeV.objValue;
    }

    public final void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            super.a(viewGroup, R.id.obfuscated_res_0x7f091016, R.id.obfuscated_res_0x7f091014);
            if (this.a == null) {
                this.a = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f091015);
            }
            this.m.setOnClickListener(this);
        }
    }

    public final void a(a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, aVar, j) == null) {
            Animator a2 = a((View) this.m);
            if (a2 == null) {
                aVar.a();
                return;
            }
            a2.addListener(new AnimatorListenerAdapter(this, aVar) { // from class: com.kwad.components.ad.reward.i.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;
                public final /* synthetic */ g b;

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
                    this.b = this;
                    this.a = aVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        a aVar2 = this.a;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        a aVar2 = this.a;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    }
                }
            });
            this.m.postDelayed(new Runnable(this, a2) { // from class: com.kwad.components.ad.reward.i.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animator a;
                public final /* synthetic */ g b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, a2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = a2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.start();
                    }
                }
            }, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        String str;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wVar) == null) {
            super.a(wVar);
            AdTemplate a2 = wVar.a();
            if (a2 == null || (str = com.kwad.sdk.core.response.a.b.C(a2).title) == null || (textView = this.a) == null) {
                return;
            }
            textView.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2.equals(this.m)) {
            com.kwad.components.ad.reward.l lVar = this.b;
            lVar.a(lVar.M, 1, 1);
        }
    }
}
