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
import androidx.constraintlayout.motion.widget.Key;
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
/* loaded from: classes7.dex */
public final class k extends a implements View.OnClickListener, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long pU = 300;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener;
    public ImageView nC;
    public ViewGroup pV;
    public TextView pW;
    public boolean pX;
    public float pY;
    public WeakReference<View> pZ;
    public n qa;
    public boolean qb;

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
        this.qb = false;
        this.mPlayEndPageListener = new com.kwad.components.ad.reward.d.e(this) { // from class: com.kwad.components.ad.reward.presenter.k.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k qc;

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
                this.qc = this;
            }

            @Override // com.kwad.components.ad.reward.d.e
            public final void bA() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.qc.hide();
                }
            }
        };
        this.qa = nVar;
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, layoutParams) == null) || layoutParams == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.pV.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (layoutParams.height == -1) {
                i = this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e6);
            } else {
                int dimensionPixelSize = this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e5);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                    WeakReference<View> weakReference = this.pZ;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    int i2 = marginLayoutParams2.height;
                    if (i2 <= 0 && view2 != null) {
                        i2 = view2.getHeight();
                    }
                    marginLayoutParams.bottomMargin = i2 + marginLayoutParams2.bottomMargin + dimensionPixelSize;
                    this.pV.setLayoutParams(marginLayoutParams);
                }
                i = layoutParams.height + dimensionPixelSize;
            }
            marginLayoutParams.bottomMargin = i;
            this.pV.setLayoutParams(marginLayoutParams);
        }
    }

    private synchronized void gY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this) {
                if (this.qb) {
                    return;
                }
                com.kwad.sdk.core.report.a.d(this.nM.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
                this.qb = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator gZ() {
        InterceptResult invokeV;
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.pV, Key.TRANSLATION_X, getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703e8));
            Drawable background = this.nC.getBackground();
            if (background instanceof ColorDrawable) {
                valueAnimator = com.kwad.sdk.widget.a.ofArgb(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060783), getContext().getResources().getColor(R.color.obfuscated_res_0x7f060784));
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (ColorDrawable) background) { // from class: com.kwad.components.ad.reward.presenter.k.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ k qc;
                    public final /* synthetic */ ColorDrawable qd;

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
                        this.qc = this;
                        this.qd = r7;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            this.qd.setColor(((Integer) valueAnimator2.getAnimatedValue()).intValue());
                        }
                    }
                });
            } else {
                valueAnimator = null;
            }
            animatorSet.playTogether(ofFloat, valueAnimator, ObjectAnimator.ofFloat(this.pW, Key.ALPHA, 0.0f, 1.0f));
            animatorSet.setDuration(pU);
            return animatorSet;
        }
        return (Animator) invokeV.objValue;
    }

    private void initView() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (viewGroup = this.pV) == null) {
            return;
        }
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091163);
        this.nC = imageView;
        imageView.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060783));
        this.pW = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091164);
        this.pV.setOnClickListener(this);
    }

    public final void M(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (viewGroup = this.pV) == null || viewGroup.getVisibility() == 0) {
            return;
        }
        gY();
        WeakReference<View> weakReference = this.pZ;
        if (weakReference != null && weakReference.get() != null) {
            a(this.pZ.get().getLayoutParams());
        }
        this.pV.setVisibility(0);
        if (z) {
            this.pV.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ k qc;

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
                    this.qc = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.qc.gZ().start();
                    }
                }
            }, 2000L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, showActionBarResult, view2) == null) {
            this.pZ = new WeakReference<>(view2);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            com.kwad.sdk.core.e.b.d("RewardPlayablePreTips", "onActionBarShown: type: " + showActionBarResult + ", params.height: " + layoutParams.height + ", params.width: " + layoutParams.width);
            a(layoutParams);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            if (this.pV == null) {
                ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091169);
                this.pV = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.obfuscated_res_0x7f091168));
                initView();
            }
            if (!this.nM.fy()) {
                this.nM.ml.a(this);
            } else if (com.kwad.sdk.core.response.a.b.e(getContext(), this.nM.mAdTemplate)) {
                a(new ViewGroup.LayoutParams(-1, -1));
            } else {
                a(new ViewGroup.LayoutParams(-1, this.pV.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf)));
            }
            this.nM.a(this.mPlayEndPageListener);
        }
    }

    public final void hide() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.pV) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            ViewGroup viewGroup = this.pV;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_CLICK_NOT_AUTO);
            com.kwad.sdk.core.report.a.a(this.nM.mAdTemplate, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCreate();
            this.pY = com.kwad.components.ad.reward.kwai.b.gb();
            this.pX = !com.kwad.components.ad.reward.kwai.b.gd() && com.kwad.components.ad.reward.kwai.b.gc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onUnbind();
            this.nM.b(this.mPlayEndPageListener);
            this.nM.ml.b(this);
        }
    }
}
