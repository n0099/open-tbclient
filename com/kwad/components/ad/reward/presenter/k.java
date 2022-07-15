package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k extends a implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long b = 300;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup c;
    public ImageView d;
    public TextView e;
    public boolean f;
    public float g;
    public WeakReference<View> h;
    public n i;
    public boolean j;
    public com.kwad.components.ad.reward.c.f k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1298625054, "Lcom/kwad/components/ad/reward/presenter/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1298625054, "Lcom/kwad/components/ad/reward/presenter/k;");
        }
    }

    public k(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = new com.kwad.components.ad.reward.c.f(this) { // from class: com.kwad.components.ad.reward.presenter.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.d();
                }
            }
        };
        this.i = nVar;
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, layoutParams) == null) || layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                i = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e8);
            } else {
                int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e7);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.h;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    int i2 = marginLayoutParams2.height;
                    if (i2 <= 0 && view2 != null) {
                        i2 = view2.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i2 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                    this.c.setLayoutParams(marginLayoutParams);
                }
                i = layoutParams.height + dimensionPixelSize;
            }
            marginLayoutParams.bottomMargin = i;
            this.c.setLayoutParams(marginLayoutParams);
        }
    }

    private void e() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.c) == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910c0);
        this.d = imageView;
        imageView.setBackgroundColor(u().getResources().getColor(R.color.obfuscated_res_0x7f06075e));
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0910c1);
        this.c.setOnClickListener(this);
    }

    private synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            synchronized (this) {
                if (this.j) {
                    return;
                }
                com.kwad.sdk.core.report.a.c(((a) this).a.g, (JSONObject) null, new com.kwad.sdk.core.report.f().c(192).a(((a) this).a.j.i()));
                this.j = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator h() {
        InterceptResult invokeV;
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationX", u().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703ea));
            Drawable background = this.d.getBackground();
            if (background instanceof ColorDrawable) {
                valueAnimator = com.kwad.sdk.widget.a.a(u().getResources().getColor(R.color.obfuscated_res_0x7f06075e), u().getResources().getColor(R.color.obfuscated_res_0x7f06075f));
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (ColorDrawable) background) { // from class: com.kwad.components.ad.reward.presenter.k.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ColorDrawable a;
                    public final /* synthetic */ k b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r7};
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
                        this.a = r7;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            this.a.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                        }
                    }
                });
            } else {
                valueAnimator = null;
            }
            animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.e, "alpha", 0.0f, 1.0f));
            animatorSet.setDuration(b);
            return animatorSet;
        }
        return (Animator) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (this.c == null) {
                ViewStub viewStub = (ViewStub) b(R.id.obfuscated_res_0x7f0910c6);
                this.c = (ViewGroup) (viewStub != null ? viewStub.inflate() : b(R.id.obfuscated_res_0x7f0910c5));
                e();
            }
            if (!((a) this).a.i()) {
                ((a) this).a.m.a(this);
            } else if (com.kwad.sdk.core.response.a.b.a(u(), ((a) this).a.g)) {
                a(new ViewGroup.LayoutParams(-1, -1));
            } else {
                a(new ViewGroup.LayoutParams(-1, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703d1)));
            }
            ((a) this).a.a(this.k);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, showActionBarResult, view2) == null) {
            this.h = new WeakReference<>(view2);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            com.kwad.sdk.core.d.b.a("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
            a(layoutParams);
        }
    }

    public final void b(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (viewGroup = this.c) == null || viewGroup.getVisibility() == 0) {
            return;
        }
        g();
        WeakReference<View> weakReference = this.h;
        if (weakReference != null && weakReference.get() != null) {
            a(this.h.get().getLayoutParams());
        }
        this.c.setVisibility(0);
        if (z) {
            this.c.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k a;

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
                        this.a.h().start();
                    }
                }
            }, 2000L);
        }
    }

    public final void d() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.i_();
            this.g = com.kwad.components.ad.reward.kwai.b.h();
            this.f = !com.kwad.components.ad.reward.kwai.b.j() && com.kwad.components.ad.reward.kwai.b.i();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.k_();
            ((a) this).a.b(this.k);
            ((a) this).a.m.b(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            com.kwad.components.ad.reward.b.a().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
            com.kwad.sdk.core.report.a.a(((a) this).a.g, new com.kwad.sdk.core.report.f().c(192).a(((a) this).a.j.i()));
        }
    }
}
