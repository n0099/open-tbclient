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
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.widget.AppScoreView;
import com.kwad.sdk.utils.av;
/* loaded from: classes10.dex */
public class ActionBarAppPortrait extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f73614a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f73615b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73616c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f73617d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73618e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f73619f;

    /* renamed from: g  reason: collision with root package name */
    public View f73620g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f73621h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f73622i;

    /* renamed from: j  reason: collision with root package name */
    public a f73623j;
    public b k;
    public KsAppDownloadListener l;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarAppPortrait(Context context) {
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
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
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
    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
            this.f73614a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f73615b = (TextView) findViewById(R.id.ksad_app_title);
            this.f73616c = (TextView) findViewById(R.id.ksad_app_desc);
            this.f73617d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f73618e = (TextView) findViewById(R.id.ksad_app_download_count);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.f73619f = textProgressBar;
            textProgressBar.setTextDimen(av.a(getContext(), 16.0f));
            this.f73619f.setTextColor(-1);
            this.f73620g = findViewById(R.id.ksad_download_bar_cover);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            String r = com.kwad.sdk.core.response.b.a.r(this.f73622i);
            boolean z = !TextUtils.isEmpty(r);
            float s = com.kwad.sdk.core.response.b.a.s(this.f73622i);
            boolean z2 = s >= 3.0f;
            if (z && z2) {
                ((LinearLayout.LayoutParams) this.f73615b.getLayoutParams()).bottomMargin = av.a(getContext(), 1.0f);
                ((LinearLayout.LayoutParams) this.f73617d.getLayoutParams()).bottomMargin = av.a(getContext(), 1.0f);
                this.f73618e.setText(r);
                this.f73618e.setVisibility(0);
                this.f73617d.setVisibility(0);
                this.f73617d.setScore(s);
            } else if (z) {
                this.f73618e.setText(r);
                this.f73618e.setVisibility(0);
                this.f73617d.setVisibility(8);
            } else if (!z2) {
                this.f73616c.setText(com.kwad.sdk.core.response.b.a.m(this.f73622i));
                this.f73618e.setVisibility(8);
                this.f73617d.setVisibility(8);
                this.f73616c.setVisibility(0);
                return;
            } else {
                this.f73618e.setVisibility(8);
                this.f73617d.setScore(s);
                this.f73617d.setVisibility(0);
            }
            this.f73616c.setVisibility(8);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (this.l == null) {
                this.l = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ActionBarAppPortrait f73624b;

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
                        this.f73624b = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.b(i2), i2);
                            this.f73624b.f73620g.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.u(this.f73624b.f73622i), 0);
                            this.f73624b.f73620g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.a(this.f73624b.f73621h), 0);
                            this.f73624b.f73620g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.u(this.f73624b.f73622i), 0);
                            this.f73624b.f73620g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.j(this.f73624b.f73622i), 0);
                            this.f73624b.f73620g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f73624b.f73619f.a(com.kwad.sdk.core.response.b.a.a(i2), i2);
                            this.f73624b.f73620g.setVisibility(8);
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
            this.f73621h = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f73622i = i2;
            this.f73623j = aVar;
            this.k = bVar;
            KSImageLoader.loadAppIcon(this.f73614a, com.kwad.sdk.core.response.b.a.n(i2), adTemplate, 12);
            this.f73615b.setText(com.kwad.sdk.core.response.b.a.o(this.f73622i));
            b();
            this.f73619f.a(com.kwad.sdk.core.response.b.a.u(this.f73622i), 0);
            b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            setOnClickListener(this);
            this.f73619f.setOnClickListener(this);
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
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f73621h, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ActionBarAppPortrait f73625a;

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
                    this.f73625a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f73625a.f73623j == null) {
                        return;
                    }
                    this.f73625a.f73623j.a();
                }
            }, this.k, view == this.f73619f);
        }
    }
}
