package com.kwad.sdk.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class ActionBarAppLandscape extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f39070a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f39071b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f39072c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f39073d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f39074e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f39075f;

    /* renamed from: g  reason: collision with root package name */
    public View f39076g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f39077h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f39078i;
    public a j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppLandscape(Context context) {
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
    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
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
    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
            this.f39070a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f39071b = (TextView) findViewById(R.id.ksad_app_title);
            this.f39072c = (TextView) findViewById(R.id.ksad_app_desc);
            this.f39073d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f39074e = (TextView) findViewById(R.id.ksad_app_download_count);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.f39075f = textProgressBar;
            textProgressBar.setTextDimen(ao.a(getContext(), 16.0f));
            this.f39075f.setTextColor(-1);
            this.f39076g = findViewById(R.id.ksad_download_bar_cover);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            float u = com.kwad.sdk.core.response.b.a.u(this.f39078i);
            boolean z = u >= 3.0f;
            if (z) {
                this.f39073d.setScore(u);
                this.f39073d.setVisibility(0);
            }
            String t = com.kwad.sdk.core.response.b.a.t(this.f39078i);
            boolean isEmpty = true ^ TextUtils.isEmpty(t);
            if (isEmpty) {
                this.f39074e.setText(t);
                this.f39074e.setVisibility(0);
            }
            if (isEmpty || z) {
                this.f39072c.setVisibility(8);
                return;
            }
            this.f39072c.setText(com.kwad.sdk.core.response.b.a.n(this.f39078i));
            this.f39073d.setVisibility(8);
            this.f39074e.setVisibility(8);
            this.f39072c.setVisibility(0);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.l == null) {
                this.l = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ActionBarAppLandscape f39079a;

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
                        this.f39079a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.c(i2), i2);
                            this.f39079a.f39076g.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.w(this.f39079a.f39078i), 0);
                            this.f39079a.f39076g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.a(this.f39079a.f39077h), 0);
                            this.f39079a.f39076g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.w(this.f39079a.f39078i), 0);
                            this.f39079a.f39076g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.b(), 0);
                            this.f39079a.f39076g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f39079a.f39075f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                            this.f39079a.f39076g.setVisibility(8);
                        }
                    }
                };
            }
            return this.l;
        }
        return (KsAppDownloadListener) invokeV.objValue;
    }

    public void a(@NonNull AdTemplate adTemplate, @Nullable b bVar, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, adTemplate, bVar, aVar) == null) {
            this.f39077h = adTemplate;
            AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f39078i = j;
            this.j = aVar;
            this.k = bVar;
            KSImageLoader.loadAppIcon(this.f39070a, com.kwad.sdk.core.response.b.a.o(j), adTemplate, 12);
            this.f39071b.setText(com.kwad.sdk.core.response.b.a.q(this.f39078i));
            b();
            this.f39075f.a(com.kwad.sdk.core.response.b.a.w(this.f39078i), 0);
            b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            setOnClickListener(this);
            this.f39075f.setOnClickListener(this);
        }
    }

    public b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (b) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            b.a(this.k, view == this.f39076g);
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f39077h, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActionBarAppLandscape f39080a;

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
                    this.f39080a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f39080a.j == null) {
                        return;
                    }
                    this.f39080a.j.a();
                }
            }, this.k);
        }
    }
}
