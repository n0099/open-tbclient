package com.kwad.sdk.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.draw.view.DrawDownloadProgressBar;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes10.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f72479a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f72480b;

    /* renamed from: c  reason: collision with root package name */
    public b f72481c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f72482d;

    /* renamed from: e  reason: collision with root package name */
    public a f72483e;

    /* renamed from: f  reason: collision with root package name */
    public int f72484f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f72485g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f72486h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f72487i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f72488j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }

    private void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3) == null) {
            d();
            ValueAnimator a2 = at.a(this, i2, i3);
            this.p = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.p.setDuration(300L);
            this.p.start();
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_draw_card_app, this);
            this.f72485g = (ImageView) findViewById(R.id.ksad_card_app_close);
            this.f72486h = (ImageView) findViewById(R.id.ksad_card_app_icon);
            this.f72487i = (TextView) findViewById(R.id.ksad_card_app_name);
            this.f72488j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
            this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
            this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
            this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
            this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
            this.o = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
            this.f72484f = av.a(context, 156.0f);
        }
    }

    private void d() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (valueAnimator = this.p) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.p.cancel();
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.f72482d == null) {
                this.f72482d = new c(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f72489b;

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
                        this.f72489b = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            super.a(i2);
                            this.f72489b.o.a(com.kwad.sdk.core.response.b.a.a(), i2);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f72489b.o.a(com.kwad.sdk.core.response.b.a.u(this.f72489b.f72480b), this.f72489b.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f72489b.o.a(com.kwad.sdk.core.response.b.a.a(this.f72489b.f72479a), this.f72489b.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f72489b.o.a(com.kwad.sdk.core.response.b.a.u(this.f72489b.f72480b), this.f72489b.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f72489b.o.a(com.kwad.sdk.core.response.b.a.j(this.f72489b.f72480b), this.f72489b.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            DrawDownloadProgressBar drawDownloadProgressBar = this.f72489b.o;
                            drawDownloadProgressBar.a(i2 + "%", i2);
                        }
                    }
                };
            }
            return this.f72482d;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            this.f72481c = null;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            this.f72479a = adTemplate;
            this.f72480b = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f72483e = aVar;
            this.f72481c = new b(this.f72479a, getAppDownloadListener());
            KSImageLoader.loadAppIcon(this.f72486h, com.kwad.sdk.core.response.b.a.n(this.f72480b), adTemplate, 11);
            this.f72487i.setText(com.kwad.sdk.core.response.b.a.o(this.f72480b));
            String r = com.kwad.sdk.core.response.b.a.r(this.f72480b);
            float s = com.kwad.sdk.core.response.b.a.s(this.f72480b);
            boolean z = s >= 3.0f;
            if (z) {
                this.k.setScore(s);
                this.k.setVisibility(0);
            }
            boolean z2 = !TextUtils.isEmpty(r);
            if (z2) {
                this.l.setText(r);
                this.l.setVisibility(0);
            }
            if (z || z2) {
                this.f72488j.setVisibility(0);
            } else {
                this.f72488j.setVisibility(8);
            }
            this.n.a(this.f72479a);
            this.m.setText(com.kwad.sdk.core.response.b.a.m(this.f72480b));
            this.f72485g.setOnClickListener(this);
            this.o.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.f72484f);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(this.f72484f, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view != this.f72485g) {
                com.kwad.sdk.core.download.b.a.a(getContext(), this.f72479a, new a.InterfaceC1982a(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f72490a;

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
                        this.f72490a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC1982a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72490a.f72483e == null) {
                            return;
                        }
                        this.f72490a.f72483e.b();
                    }
                }, this.f72481c, view == this.o);
                return;
            }
            c();
            a aVar = this.f72483e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
