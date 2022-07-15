package com.kwad.components.ad.reward.i;

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
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.az;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public final class m extends x implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.l a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public View f;
    public TextView g;
    public View h;
    public Set<ImageView> i;
    public TextView j;
    public Animator k;

    public m(com.kwad.components.ad.reward.l lVar) {
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
        this.i = new HashSet();
        this.a = lVar;
    }

    public static Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "translationY", view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f07037e)).setDuration(250L);
            duration.setInterpolator(create);
            return duration;
        }
        return (Animator) invokeL.objValue;
    }

    public static Animator a(View view2, long j, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{view2, Long.valueOf(j), Float.valueOf(f)})) == null) {
            if (view2 == null) {
                return null;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view2.setPivotX(0.0f);
            view2.setPivotY(view2.getHeight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 1.0f);
            ofFloat.setDuration(100L);
            ObjectAnimator duration = ObjectAnimator.ofFloat(view2, "rotation", 0.0f, f).setDuration(j);
            float f2 = -f;
            long j2 = j * 2;
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "rotation", f, f2).setDuration(j2);
            duration2.setInterpolator(create);
            ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "rotation", f2, f).setDuration(j2);
            ObjectAnimator duration4 = ObjectAnimator.ofFloat(view2, "rotation", f, f2).setDuration(j2);
            duration4.setInterpolator(create);
            animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view2, "rotation", f2, 0.0f).setDuration(j));
            return animatorSet;
        }
        return (Animator) invokeCommon.objValue;
    }

    private void a(com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, aVar) == null) {
            this.d.setText(aVar.b());
            this.e.setText(aVar.t());
            String a = aVar.a();
            Drawable drawable = this.c.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bd1);
            KSImageLoader.loadCircleIcon(this.c, a, drawable);
            String c = com.kwad.components.ad.c.b.c();
            if (!at.a(c)) {
                KSImageLoader.loadImage(this.b, c, aVar.j());
            }
            if (!aVar.r()) {
                this.h.setVisibility(8);
                return;
            }
            this.h.setVisibility(0);
            String o = aVar.o();
            if (!TextUtils.isEmpty(o)) {
                this.j.setText(String.format("%s已预约直播", o));
            }
            if (aVar.s() != null) {
                List<String> s = aVar.s();
                int i = 0;
                for (ImageView imageView : this.i) {
                    if (i < s.size()) {
                        imageView.setVisibility(0);
                        KSImageLoader.loadCircleIcon(imageView, s.get(i), drawable);
                    }
                    i++;
                }
            }
        }
    }

    private void d() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || (viewGroup = this.m) == null) {
            return;
        }
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091139);
        this.b = (ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f091142);
        this.c = (ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f091141);
        this.d = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f091143);
        this.e = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09113c);
        this.f = this.m.findViewById(R.id.obfuscated_res_0x7f09113a);
        this.h = this.m.findViewById(R.id.obfuscated_res_0x7f09113d);
        this.i.add((ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f09113e));
        this.i.add((ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f09113f));
        this.i.add((ImageView) this.m.findViewById(R.id.obfuscated_res_0x7f091140));
        this.j = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09113b);
        this.m.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.g.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.m.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

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
                        m mVar = this.a;
                        mVar.k = m.a(mVar.g, 100L, 8.0f);
                        this.a.k.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.components.ad.reward.i.m.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

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
                                this.a = this;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, animator) == null) {
                                    super.onAnimationEnd(animator);
                                    if (this.a.a.k != null) {
                                        this.a.a.k.start();
                                    }
                                }
                            }
                        });
                        this.a.k.start();
                    }
                }
            }, 500L);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.m.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ m a;

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
                        m.a(this.a.h).start();
                    }
                }
            }, 2000L);
        }
    }

    public final void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            super.a(viewGroup, R.id.obfuscated_res_0x7f091146, R.id.obfuscated_res_0x7f091145);
            d();
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) {
            super.a(wVar);
            AdTemplate a = wVar.a();
            if (a != null) {
                a(com.kwad.components.ad.reward.model.a.d(a));
            }
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.a(z);
            Context context = this.m.getContext();
            if (ae.e(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070384);
            this.m.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b();
            Animator animator = this.k;
            if (animator != null) {
                animator.cancel();
                this.k = null;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e();
            f();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2.equals(this.f)) {
                this.a.a(view2.getContext(), 29, 1);
            } else if (view2.equals(this.m)) {
                this.a.a(view2.getContext(), 53, 2);
            }
        }
    }
}
