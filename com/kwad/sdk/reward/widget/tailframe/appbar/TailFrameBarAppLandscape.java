package com.kwad.sdk.reward.widget.tailframe.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.av;
/* loaded from: classes6.dex */
public class TailFrameBarAppLandscape extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36508a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36509b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f36510c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36511d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36512e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f36513f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f36514g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_landscape, this);
            this.f36508a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f36509b = (TextView) findViewById(R.id.ksad_app_name);
            this.f36510c = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f36511d = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f36512e = (TextView) findViewById(R.id.ksad_app_introduce);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
            this.f36513f = textProgressBar;
            textProgressBar.setTextDimen(av.a(getContext(), 16.0f));
            this.f36513f.setTextColor(-1);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ValueAnimator valueAnimator = this.f36514g;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
                this.f36514g = ofFloat;
                ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
                this.f36514g.setRepeatCount(-1);
                this.f36514g.setRepeatMode(1);
                this.f36514g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppLandscape.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TailFrameBarAppLandscape f36515a;

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
                        this.f36515a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            this.f36515a.f36513f.setScaleY(floatValue);
                            this.f36515a.f36513f.setScaleX(floatValue);
                        }
                    }
                });
                this.f36514g.start();
            }
        }
    }

    public void a() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (valueAnimator = this.f36514g) != null && valueAnimator.isRunning()) {
            this.f36514g.cancel();
            this.f36514g.end();
        }
    }

    public void a(@NonNull AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            int i2 = adInfo.status;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                a();
            } else {
                c();
            }
        }
    }

    public TextProgressBar getTextProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36513f : (TextProgressBar) invokeV.objValue;
    }

    public void setModel(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
            AdInfo i2 = c.i(adTemplate);
            KSImageLoader.loadAppIcon(this.f36508a, a.n(i2), adTemplate, 16);
            this.f36509b.setText(a.o(i2));
            float s = a.s(i2);
            if (s >= 3.0f) {
                this.f36510c.setScore(s);
                this.f36510c.setVisibility(0);
            } else {
                this.f36510c.setVisibility(8);
            }
            String r = a.r(i2);
            if (TextUtils.isEmpty(r)) {
                this.f36511d.setVisibility(8);
            } else {
                this.f36511d.setText(r);
                this.f36511d.setVisibility(0);
            }
            this.f36512e.setText(a.m(i2));
            this.f36513f.a(a.u(i2), 0);
            a(c.i(adTemplate));
        }
    }
}
