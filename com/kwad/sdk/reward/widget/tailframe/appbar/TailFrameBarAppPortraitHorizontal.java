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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class TailFrameBarAppPortraitHorizontal extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39172a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39173b;

    /* renamed from: c  reason: collision with root package name */
    public AppScoreView f39174c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f39175d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f39176e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f39177f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f39178g;

    /* renamed from: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39180a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-984383576, "Lcom/kwad/sdk/reward/widget/tailframe/appbar/TailFrameBarAppPortraitHorizontal$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-984383576, "Lcom/kwad/sdk/reward/widget/tailframe/appbar/TailFrameBarAppPortraitHorizontal$2;");
                    return;
                }
            }
            int[] iArr = new int[DOWNLOADSTAUS.values().length];
            f39180a = iArr;
            try {
                iArr[DOWNLOADSTAUS.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39180a[DOWNLOADSTAUS.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39180a[DOWNLOADSTAUS.PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailFrameBarAppPortraitHorizontal(Context context) {
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
    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet) {
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
    public TailFrameBarAppPortraitHorizontal(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_tf_bar_app_portrait_horizontal, this);
            this.f39172a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f39173b = (TextView) findViewById(R.id.ksad_app_name);
            this.f39174c = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f39175d = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f39176e = (TextView) findViewById(R.id.ksad_app_introduce);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_download_bar);
            this.f39177f = textProgressBar;
            textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
            this.f39177f.setTextColor(-1);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            ValueAnimator valueAnimator = this.f39178g;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
                this.f39178g = ofFloat;
                ofFloat.setDuration(IMLikeRequest.TIME_INTERVAL);
                this.f39178g.setRepeatCount(-1);
                this.f39178g.setRepeatMode(1);
                this.f39178g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.widget.tailframe.appbar.TailFrameBarAppPortraitHorizontal.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TailFrameBarAppPortraitHorizontal f39179a;

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
                        this.f39179a = this;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator2) == null) {
                            float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                            this.f39179a.f39177f.setScaleY(floatValue);
                            this.f39179a.f39177f.setScaleX(floatValue);
                        }
                    }
                });
                this.f39178g.start();
            }
        }
    }

    public void a() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (valueAnimator = this.f39178g) != null && valueAnimator.isRunning()) {
            this.f39178g.cancel();
            this.f39178g.end();
        }
    }

    public void a(@NonNull AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo) == null) {
            int i2 = AnonymousClass2.f39180a[adInfo.status.ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                a();
            } else {
                c();
            }
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            AdInfo j = c.j(adTemplate);
            KSImageLoader.loadAppIcon(this.f39172a, a.o(j), adTemplate, 20);
            this.f39173b.setText(a.q(j));
            float u = a.u(j);
            if (u >= 3.0f) {
                this.f39174c.setScore(u);
                this.f39174c.setVisibility(0);
            } else {
                this.f39174c.setVisibility(8);
            }
            String t = a.t(j);
            if (TextUtils.isEmpty(t)) {
                this.f39175d.setVisibility(8);
            } else {
                this.f39175d.setText(t);
                this.f39175d.setVisibility(0);
            }
            this.f39176e.setText(a.n(j));
            this.f39177f.a(a.w(j), 0);
            a(j);
        }
    }

    public TextProgressBar getTextProgressBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39177f : (TextProgressBar) invokeV.objValue;
    }
}
