package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes10.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f73643a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f73644b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f73645c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f73646d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73647e;

    /* renamed from: f  reason: collision with root package name */
    public View f73648f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f73649g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f73650h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f73651i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f73652j;
    public TextProgressBar k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarPortraitHorizontal(@NonNull Context context) {
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
    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public ActionBarPortraitHorizontal(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_video_actionbar_portrait_horizontal, this);
            this.f73643a = (ViewGroup) findViewById(R.id.ksad_top_container);
            this.f73644b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
            this.f73645c = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f73646d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f73647e = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f73648f = findViewById(R.id.ksad_video_place_holder);
            this.f73649g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
            this.f73650h = (TextView) findViewById(R.id.ksad_app_name);
            this.f73651i = (TextView) findViewById(R.id.ksad_product_name);
            this.f73652j = (TextView) findViewById(R.id.ksad_app_desc);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.k = textProgressBar;
            textProgressBar.setTextDimen(av.a(getContext(), 16.0f));
            this.k.setTextColor(-1);
            this.l = findViewById(R.id.ksad_app_download_btn_cover);
            this.k.setOnClickListener(this);
            this.r = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.q == null) {
                this.q = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ActionBarPortraitHorizontal f73653b;

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
                        this.f73653b = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                            this.f73653b.l.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.u(this.f73653b.n), 0);
                            this.f73653b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.a(this.f73653b.m), 0);
                            this.f73653b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.u(this.f73653b.n), 0);
                            this.f73653b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.j(this.f73653b.n), 0);
                            this.f73653b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f73653b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                            this.f73653b.l.setVisibility(8);
                        }
                    }
                };
            }
            return this.q;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, adTemplate, bVar, aVar, i2) == null) {
            this.m = adTemplate;
            this.r.a(adTemplate);
            AdInfo i3 = com.kwad.sdk.core.response.b.c.i(this.m);
            this.n = i3;
            if (com.kwad.sdk.core.response.b.a.v(i3)) {
                this.f73644b.setVisibility(8);
                this.f73643a.setVisibility(0);
                this.f73643a.setOnClickListener(this);
                this.f73650h.setText(com.kwad.sdk.core.response.b.a.o(this.n));
            } else {
                this.f73644b.setVisibility(0);
                this.f73643a.setVisibility(8);
                this.f73651i.setText(this.n.adBaseInfo.productName);
                this.f73644b.setOnClickListener(this);
            }
            this.k.setOnClickListener(this);
            this.o = aVar;
            this.p = bVar;
            KSImageLoader.loadAppIcon(this.f73645c, com.kwad.sdk.core.response.b.a.n(this.n), adTemplate, 16);
            float s = com.kwad.sdk.core.response.b.a.s(this.n);
            if (s >= 3.0f) {
                this.f73646d.setScore(s);
                this.f73646d.setVisibility(0);
            } else {
                this.f73646d.setVisibility(8);
            }
            String r = com.kwad.sdk.core.response.b.a.r(this.n);
            if (!TextUtils.isEmpty(r)) {
                this.f73647e.setText(r);
                this.f73647e.setVisibility(0);
            } else {
                this.f73647e.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.f73648f.getLayoutParams();
            layoutParams.height = i2;
            this.f73648f.setLayoutParams(layoutParams);
            this.f73652j.setText(com.kwad.sdk.core.response.b.a.m(this.n));
            this.k.a(com.kwad.sdk.core.response.b.a.u(this.n), this.k.getMax());
            this.l.setVisibility(8);
            b bVar2 = this.p;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            this.f73649g.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.m, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActionBarPortraitHorizontal f73654a;

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
                    this.f73654a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f73654a.o == null) {
                        return;
                    }
                    this.f73654a.o.a();
                }
            }, this.p, view == this.k);
        }
    }
}
