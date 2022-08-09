package com.kwad.components.ad.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View BA;
    public TextView CI;
    public TextView cz;
    public ImageView hF;
    public TextView hG;
    public ValueAnimator ju;
    public View un;
    public Button uo;
    public Button up;
    public KsAppTagsView uu;
    public com.kwad.components.ad.g.a ux;
    public Runnable uy;
    public AppScoreView wH;
    public TextProgressBar wZ;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.BA = LinearLayout.inflate(getContext(), getLayoutId(), this);
            this.hF = (ImageView) findViewById(R.id.obfuscated_res_0x7f091042);
            this.hG = (TextView) findViewById(R.id.obfuscated_res_0x7f091044);
            this.wH = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f091045);
            this.cz = (TextView) findViewById(R.id.obfuscated_res_0x7f091041);
            this.CI = (TextView) findViewById(R.id.obfuscated_res_0x7f091043);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f091078);
            this.wZ = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
            this.wZ.setTextColor(-1);
            this.uu = (KsAppTagsView) findViewById(R.id.obfuscated_res_0x7f091140);
            this.uo = (Button) findViewById(R.id.obfuscated_res_0x7f09113a);
            this.up = (Button) findViewById(R.id.obfuscated_res_0x7f09113c);
            this.un = findViewById(R.id.obfuscated_res_0x7f09113b);
            this.ux = new com.kwad.components.ad.g.a(this.BA);
        }
    }

    private void ld() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ValueAnimator valueAnimator = this.ju;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
                this.ju = ofFloat;
                ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
                this.ju.setRepeatCount(-1);
                this.ju.setRepeatMode(1);
                this.ju.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a CJ;

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
                        this.CJ = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            this.CJ.wZ.setScaleY(floatValue);
                            this.CJ.wZ.setScaleX(floatValue);
                        }
                    }
                });
                this.ju.start();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0095: INVOKE  (r5v1 int A[REMOVE]) =  type: STATIC call: com.kwad.sdk.core.config.d.sf():int)] */
    public void c(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String bn;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            if (d.p(adTemplate)) {
                imageView = this.hF;
                bn = com.kwad.sdk.core.response.a.a.bI(bQ);
            } else {
                imageView = this.hF;
                bn = com.kwad.sdk.core.response.a.a.bn(bQ);
            }
            KSImageLoader.loadAppIcon(imageView, bn, adTemplate, 12);
            this.hG.setText(com.kwad.sdk.core.response.a.a.bl(bQ));
            if (!d.p(adTemplate)) {
                float ai = com.kwad.sdk.core.response.a.a.ai(bQ);
                if (ai >= 3.0f) {
                    this.wH.setScore(ai);
                    this.wH.setVisibility(0);
                } else {
                    this.wH.setVisibility(8);
                }
                String ah = com.kwad.sdk.core.response.a.a.ah(bQ);
                if (TextUtils.isEmpty(ah)) {
                    this.cz.setVisibility(8);
                } else {
                    this.cz.setText(ah);
                    this.cz.setVisibility(0);
                }
            }
            this.CI.setText(com.kwad.sdk.core.response.a.a.ad(bQ));
            if (d.p(adTemplate)) {
                this.wZ.setVisibility(8);
                this.un.setVisibility(0);
                this.up.setText("查看详情");
                Button button = this.uo;
                StringBuilder sb = new StringBuilder();
                sb.append(com.kwad.sdk.core.config.d.sf());
                button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
                if (!adTemplate.mRewardVerifyCalled) {
                    if (this.uy == null) {
                        this.uy = new Runnable(this) { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ a CJ;

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
                                this.CJ = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.CJ.ux.kL();
                                }
                            }
                        };
                    }
                    this.un.postDelayed(this.uy, 1600L);
                }
            } else {
                this.wZ.setVisibility(0);
                this.un.setVisibility(8);
                Runnable runnable = this.uy;
                if (runnable != null) {
                    this.un.removeCallbacks(runnable);
                    this.uy = null;
                }
                u(d.bQ(adTemplate));
            }
            if (d.p(adTemplate)) {
                List<String> bH = c.bH(adTemplate);
                if (bH.size() > 0) {
                    this.uu.setVisibility(0);
                } else {
                    this.uu.setVisibility(8);
                }
                this.uu.setAppTags(bH);
            }
        }
    }

    public View getBtnInstallContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.un : (View) invokeV.objValue;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.wZ : (TextProgressBar) invokeV.objValue;
    }

    public final void jl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ValueAnimator valueAnimator = this.ju;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.ju.cancel();
                this.ju.end();
            }
            Runnable runnable = this.uy;
            if (runnable != null) {
                this.un.removeCallbacks(runnable);
                this.uy = null;
            }
            this.ux.kM();
        }
    }

    public final void u(@NonNull AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInfo) == null) {
            int i = adInfo.status;
            if (i == 1 || i == 2 || i == 3) {
                jl();
            } else {
                ld();
            }
        }
    }
}
