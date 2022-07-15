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
    public View a;
    public ImageView b;
    public TextView c;
    public AppScoreView d;
    public TextView e;
    public TextView f;
    public TextProgressBar g;
    public KsAppTagsView h;
    public View i;
    public Button j;
    public Button k;
    public ValueAnimator l;
    public com.kwad.components.ad.g.a m;

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
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a = LinearLayout.inflate(getContext(), getLayoutId(), this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff7);
            this.d = (AppScoreView) findViewById(R.id.obfuscated_res_0x7f090ff8);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff4);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff6);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09102b);
            this.g = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
            this.g.setTextColor(-1);
            this.h = (KsAppTagsView) findViewById(R.id.obfuscated_res_0x7f0910f3);
            this.j = (Button) findViewById(R.id.obfuscated_res_0x7f0910ed);
            this.k = (Button) findViewById(R.id.obfuscated_res_0x7f0910ef);
            this.i = findViewById(R.id.obfuscated_res_0x7f0910ee);
            this.m = new com.kwad.components.ad.g.a(this.a);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
                this.l = ofFloat;
                ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
                this.l.setRepeatCount(-1);
                this.l.setRepeatMode(1);
                this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            this.a.g.setScaleY(floatValue);
                            this.a.g.setScaleX(floatValue);
                        }
                    }
                });
                this.l.start();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueAnimator valueAnimator = this.l;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.l.cancel();
                this.l.end();
            }
            this.m.b();
        }
    }

    public final void a(@NonNull AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            int i = adInfo.status;
            if (i == 1 || i == 2 || i == 3) {
                a();
            } else {
                c();
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0095: INVOKE  (r5v1 int A[REMOVE]) =  type: STATIC call: com.kwad.sdk.core.config.d.R():int)] */
    public void a(@NonNull AdTemplate adTemplate) {
        ImageView imageView;
        String aE;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            AdInfo i = d.i(adTemplate);
            if (d.q(adTemplate)) {
                imageView = this.b;
                aE = com.kwad.sdk.core.response.a.a.aZ(i);
            } else {
                imageView = this.b;
                aE = com.kwad.sdk.core.response.a.a.aE(i);
            }
            KSImageLoader.loadAppIcon(imageView, aE, adTemplate, 12);
            this.c.setText(com.kwad.sdk.core.response.a.a.aC(i));
            if (!d.q(adTemplate)) {
                float E = com.kwad.sdk.core.response.a.a.E(i);
                if (E >= 3.0f) {
                    this.d.setScore(E);
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
                String D = com.kwad.sdk.core.response.a.a.D(i);
                if (TextUtils.isEmpty(D)) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setText(D);
                    this.e.setVisibility(0);
                }
            }
            this.f.setText(com.kwad.sdk.core.response.a.a.z(i));
            if (d.q(adTemplate)) {
                this.g.setVisibility(8);
                this.i.setVisibility(0);
                this.k.setText("查看详情");
                Button button = this.j;
                StringBuilder sb = new StringBuilder();
                sb.append(com.kwad.sdk.core.config.d.R());
                button.setText(String.format("浏览详情页%s秒，领取奖励", sb.toString()));
                if (!adTemplate.mRewardVerifyCalled) {
                    this.i.postDelayed(new Runnable(this) { // from class: com.kwad.components.ad.widget.tailframe.appbar.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
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
                                this.a.m.a();
                            }
                        }
                    }, 1600L);
                }
            } else {
                this.g.setVisibility(0);
                this.i.setVisibility(8);
                a(d.i(adTemplate));
            }
            if (d.q(adTemplate)) {
                List<String> f = c.f(adTemplate);
                if (f.size() > 0) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
                this.h.setAppTags(f);
            }
        }
    }

    public View getBtnInstallContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @LayoutRes
    public abstract int getLayoutId();

    public TextProgressBar getTextProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : (TextProgressBar) invokeV.objValue;
    }
}
