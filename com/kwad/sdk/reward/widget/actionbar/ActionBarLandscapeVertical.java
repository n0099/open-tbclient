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
/* loaded from: classes2.dex */
public class ActionBarLandscapeVertical extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f66381a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f66382b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f66383c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f66384d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66385e;

    /* renamed from: f  reason: collision with root package name */
    public View f66386f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f66387g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66388h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66389i;
    public TextView j;
    public TextProgressBar k;
    public View l;
    public KsLogoView m;
    public AdTemplate n;
    public AdInfo o;
    public a p;
    public b q;
    public KsAppDownloadListener r;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarLandscapeVertical(@NonNull Context context) {
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
    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public ActionBarLandscapeVertical(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            FrameLayout.inflate(context, R.layout.ksad_video_actionbar_landscape_vertical, this);
            this.f66381a = (ViewGroup) findViewById(R.id.ksad_top_container);
            this.f66382b = (ViewGroup) findViewById(R.id.ksad_top_outer);
            this.f66383c = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f66384d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f66385e = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f66386f = findViewById(R.id.ksad_video_place_holder);
            this.f66387g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
            this.f66388h = (TextView) findViewById(R.id.ksad_app_name);
            this.f66389i = (TextView) findViewById(R.id.ksad_product_name);
            this.j = (TextView) findViewById(R.id.ksad_app_desc);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.k = textProgressBar;
            textProgressBar.setTextDimen(av.a(getContext(), 16.0f));
            this.k.setTextColor(-1);
            this.l = findViewById(R.id.ksad_app_download_btn_cover);
            this.k.setOnClickListener(this);
            this.m = (KsLogoView) findViewById(R.id.ksad_actionbar_logo);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.r == null) {
                this.r = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ActionBarLandscapeVertical f66390b;

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
                        this.f66390b = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                            this.f66390b.l.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.u(this.f66390b.o), 0);
                            this.f66390b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.a(this.f66390b.n), 0);
                            this.f66390b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.u(this.f66390b.o), 0);
                            this.f66390b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.j(this.f66390b.o), 0);
                            this.f66390b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f66390b.k.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                            this.f66390b.l.setVisibility(8);
                        }
                    }
                };
            }
            return this.r;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        TextView textView;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, adTemplate, bVar, aVar, i2) == null) {
            this.n = adTemplate;
            this.o = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.m.a(adTemplate);
            if (com.kwad.sdk.core.response.b.a.v(this.o)) {
                this.f66389i.setVisibility(8);
                this.f66381a.setVisibility(0);
                this.f66381a.setOnClickListener(this);
                textView = this.f66388h;
                str = com.kwad.sdk.core.response.b.a.o(this.o);
            } else {
                this.f66389i.setVisibility(0);
                this.f66381a.setVisibility(8);
                this.f66382b.setOnClickListener(this);
                textView = this.f66389i;
                str = this.o.adBaseInfo.productName;
            }
            textView.setText(str);
            this.p = aVar;
            this.q = bVar;
            KSImageLoader.loadAppIcon(this.f66383c, com.kwad.sdk.core.response.b.a.n(this.o), adTemplate, 16);
            float s = com.kwad.sdk.core.response.b.a.s(this.o);
            if (s >= 3.0f) {
                this.f66384d.setScore(s);
                this.f66384d.setVisibility(0);
            } else {
                this.f66384d.setVisibility(8);
            }
            String r = com.kwad.sdk.core.response.b.a.r(this.o);
            if (!TextUtils.isEmpty(r)) {
                this.f66385e.setText(r);
                this.f66385e.setVisibility(0);
            } else {
                this.f66385e.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.f66386f.getLayoutParams();
            layoutParams.width = i2;
            this.f66386f.setLayoutParams(layoutParams);
            this.j.setText(com.kwad.sdk.core.response.b.a.m(this.o));
            this.k.a(com.kwad.sdk.core.response.b.a.u(this.o), this.k.getMax());
            this.l.setVisibility(8);
            b bVar2 = this.q;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            this.f66387g.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.n, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarLandscapeVertical.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActionBarLandscapeVertical f66391a;

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
                    this.f66391a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66391a.p == null) {
                        return;
                    }
                    this.f66391a.p.a();
                }
            }, this.q, view == this.k);
        }
    }
}
