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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.download.a.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes2.dex */
public class ActionBarPortraitHorizontal extends FrameLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59340b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59341c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f59342d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59343e;

    /* renamed from: f  reason: collision with root package name */
    public View f59344f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f59345g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59346h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59347i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f59348j;

    /* renamed from: k  reason: collision with root package name */
    public TextProgressBar f59349k;
    public View l;
    public AdTemplate m;
    public AdInfo n;
    public a o;
    public b p;
    public KsAppDownloadListener q;
    public KsLogoView r;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
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
            this.a = (ViewGroup) findViewById(R.id.ksad_top_container);
            this.f59340b = (ViewGroup) findViewById(R.id.ksad_top_container_product);
            this.f59341c = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f59342d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f59343e = (TextView) findViewById(R.id.ksad_app_download_count);
            this.f59344f = findViewById(R.id.ksad_video_place_holder);
            this.f59345g = (ViewGroup) findViewById(R.id.ksad_bottom_container);
            this.f59346h = (TextView) findViewById(R.id.ksad_app_name);
            this.f59347i = (TextView) findViewById(R.id.ksad_product_name);
            this.f59348j = (TextView) findViewById(R.id.ksad_app_desc);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.f59349k = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
            this.f59349k.setTextColor(-1);
            View findViewById = findViewById(R.id.ksad_app_download_btn_cover);
            this.l = findViewById;
            new f(findViewById, this);
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
                    public final /* synthetic */ ActionBarPortraitHorizontal f59350b;

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
                        this.f59350b = this;
                    }

                    @Override // com.kwad.sdk.core.download.a.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                            this.f59350b.l.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.A(this.f59350b.n), 0);
                            this.f59350b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.a(this.f59350b.m), 0);
                            this.f59350b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.A(this.f59350b.n), 0);
                            this.f59350b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.m(this.f59350b.n), 0);
                            this.f59350b.l.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f59350b.f59349k.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                            this.f59350b.l.setVisibility(8);
                        }
                    }
                };
            }
            return this.q;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
            com.kwad.sdk.core.download.a.a.a(new a.C2015a(view.getContext()).a(this.m).a(new a.b(this, z) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarPortraitHorizontal.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ActionBarPortraitHorizontal f59351b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59351b = this;
                    this.a = z;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f59351b.o == null) {
                        return;
                    }
                    this.f59351b.o.a(this.a);
                }
            }).a(this.p).a(view == this.f59349k).a(view == this.l ? 1 : 2));
        }
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, @NonNull a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, bVar, aVar, i2) == null) {
            this.m = adTemplate;
            this.r.a(adTemplate);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.m);
            this.n = j2;
            if (com.kwad.sdk.core.response.a.a.B(j2)) {
                this.f59340b.setVisibility(8);
                this.a.setVisibility(0);
                new f(this.a, this);
                this.f59346h.setText(com.kwad.sdk.core.response.a.a.t(this.n));
            } else {
                this.f59340b.setVisibility(0);
                this.a.setVisibility(8);
                this.f59347i.setText(this.n.adBaseInfo.productName);
                new f(this.f59340b, this);
            }
            new f(this.f59349k, this);
            this.o = aVar;
            this.p = bVar;
            KSImageLoader.loadAppIcon(this.f59341c, com.kwad.sdk.core.response.a.a.au(this.n), adTemplate, 16);
            float x = com.kwad.sdk.core.response.a.a.x(this.n);
            if (x >= 3.0f) {
                this.f59342d.setScore(x);
                this.f59342d.setVisibility(0);
            } else {
                this.f59342d.setVisibility(8);
            }
            String w = com.kwad.sdk.core.response.a.a.w(this.n);
            if (!TextUtils.isEmpty(w)) {
                this.f59343e.setText(w);
                this.f59343e.setVisibility(0);
            } else {
                this.f59343e.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = this.f59344f.getLayoutParams();
            layoutParams.height = i2;
            this.f59344f.setLayoutParams(layoutParams);
            this.f59348j.setText(com.kwad.sdk.core.response.a.a.s(this.n));
            this.f59349k.a(com.kwad.sdk.core.response.a.a.A(this.n), this.f59349k.getMax());
            this.l.setVisibility(8);
            b bVar2 = this.p;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            new f(this.f59345g, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.m)) {
            a(view, false);
        }
    }
}
