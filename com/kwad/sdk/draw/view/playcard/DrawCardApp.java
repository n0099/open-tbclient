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
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f37121a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f37122b;

    /* renamed from: c  reason: collision with root package name */
    public b f37123c;

    /* renamed from: d  reason: collision with root package name */
    public KsAppDownloadListener f37124d;

    /* renamed from: e  reason: collision with root package name */
    public a f37125e;

    /* renamed from: f  reason: collision with root package name */
    public int f37126f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f37127g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f37128h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37129i;
    public ViewGroup j;
    public AppScoreView k;
    public TextView l;
    public TextView m;
    public KsLogoView n;
    public DrawDownloadProgressBar o;
    public ValueAnimator p;

    /* loaded from: classes7.dex */
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
        if (interceptable == null || interceptable.invokeII(65540, this, i2, i3) == null) {
            d();
            ValueAnimator a2 = am.a(this, i2, i3);
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
            this.f37127g = (ImageView) findViewById(R.id.ksad_card_app_close);
            this.f37128h = (ImageView) findViewById(R.id.ksad_card_app_icon);
            this.f37129i = (TextView) findViewById(R.id.ksad_card_app_name);
            this.j = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
            this.k = (AppScoreView) findViewById(R.id.ksad_card_app_score);
            this.l = (TextView) findViewById(R.id.ksad_card_app_download_count);
            this.m = (TextView) findViewById(R.id.ksad_card_app_desc);
            this.n = (KsLogoView) findViewById(R.id.ksad_card_logo);
            DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
            this.o = drawDownloadProgressBar;
            drawDownloadProgressBar.setTextSize(16);
            this.f37126f = ao.a(context, 156.0f);
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
            if (this.f37124d == null) {
                this.f37124d = new c(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f37130a;

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
                        this.f37130a = this;
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f37130a.o.a(com.kwad.sdk.core.response.b.a.w(this.f37130a.f37122b), this.f37130a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f37130a.o.a(com.kwad.sdk.core.response.b.a.a(this.f37130a.f37121a), this.f37130a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f37130a.o.a(com.kwad.sdk.core.response.b.a.w(this.f37130a.f37122b), this.f37130a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f37130a.o.a(com.kwad.sdk.core.response.b.a.b(), this.f37130a.o.getMax());
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048580, this, i2) == null) {
                            DrawDownloadProgressBar drawDownloadProgressBar = this.f37130a.o;
                            drawDownloadProgressBar.a(i2 + "%", i2);
                        }
                    }
                };
            }
            return this.f37124d;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d();
            this.f37123c = null;
        }
    }

    public void a(@NonNull AdTemplate adTemplate, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, aVar) == null) {
            this.f37121a = adTemplate;
            this.f37122b = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f37125e = aVar;
            this.f37123c = new b(this.f37121a, getAppDownloadListener());
            KSImageLoader.loadAppIcon(this.f37128h, com.kwad.sdk.core.response.b.a.o(this.f37122b), adTemplate, 11);
            this.f37129i.setText(com.kwad.sdk.core.response.b.a.q(this.f37122b));
            String t = com.kwad.sdk.core.response.b.a.t(this.f37122b);
            float u = com.kwad.sdk.core.response.b.a.u(this.f37122b);
            boolean z = u >= 3.0f;
            if (z) {
                this.k.setScore(u);
                this.k.setVisibility(0);
            }
            boolean z2 = !TextUtils.isEmpty(t);
            if (z2) {
                this.l.setText(t);
                this.l.setVisibility(0);
            }
            if (z || z2) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.n.a(this.f37121a);
            this.m.setText(com.kwad.sdk.core.response.b.a.n(this.f37122b));
            this.f37127g.setOnClickListener(this);
            this.o.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(0, this.f37126f);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(this.f37126f, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            if (view != this.f37127g) {
                com.kwad.sdk.core.download.b.a.a(getContext(), this.f37121a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.draw.view.playcard.DrawCardApp.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DrawCardApp f37131a;

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
                        this.f37131a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f37131a.f37125e == null) {
                            return;
                        }
                        this.f37131a.f37125e.b();
                    }
                }, this.f37123c);
                return;
            }
            c();
            a aVar = this.f37125e;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
