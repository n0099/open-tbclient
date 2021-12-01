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
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.f;
/* loaded from: classes2.dex */
public class ActionBarAppLandscape extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59300b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59301c;

    /* renamed from: d  reason: collision with root package name */
    public AppScoreView f59302d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f59303e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f59304f;

    /* renamed from: g  reason: collision with root package name */
    public View f59305g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f59306h;

    /* renamed from: i  reason: collision with root package name */
    public AdInfo f59307i;

    /* renamed from: j  reason: collision with root package name */
    public a f59308j;

    /* renamed from: k  reason: collision with root package name */
    public b f59309k;
    public KsAppDownloadListener l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z);
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LinearLayout.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
            this.a = (ImageView) findViewById(R.id.ksad_app_icon);
            this.f59300b = (TextView) findViewById(R.id.ksad_app_title);
            this.f59301c = (TextView) findViewById(R.id.ksad_app_desc);
            this.f59302d = (AppScoreView) findViewById(R.id.ksad_app_score);
            this.f59303e = (TextView) findViewById(R.id.ksad_app_download_count);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.f59304f = textProgressBar;
            textProgressBar.setTextDimen(com.kwad.sdk.a.kwai.a.a(getContext(), 16.0f));
            this.f59304f.setTextColor(-1);
            this.f59305g = findViewById(R.id.ksad_download_bar_cover);
        }
    }

    private void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, view, z) == null) {
            com.kwad.sdk.core.download.a.a.a(new a.C2015a(view.getContext()).a(this.f59306h).a(this.f59309k).a(view == this.f59304f).a(view == this.f59305g ? 1 : 2).a(new a.b(this, z) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ActionBarAppLandscape f59311b;

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
                    this.f59311b = this;
                    this.a = z;
                }

                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f59311b.f59308j == null) {
                        return;
                    }
                    this.f59311b.f59308j.a(this.a);
                }
            }));
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            float x = com.kwad.sdk.core.response.a.a.x(this.f59307i);
            boolean z = x >= 3.0f;
            if (z) {
                this.f59302d.setScore(x);
                this.f59302d.setVisibility(0);
            }
            String w = com.kwad.sdk.core.response.a.a.w(this.f59307i);
            boolean isEmpty = true ^ TextUtils.isEmpty(w);
            if (isEmpty) {
                this.f59303e.setText(w);
                this.f59303e.setVisibility(0);
            }
            if (isEmpty || z) {
                this.f59301c.setVisibility(8);
                return;
            }
            this.f59301c.setText(com.kwad.sdk.core.response.a.a.s(this.f59307i));
            this.f59302d.setVisibility(8);
            this.f59303e.setVisibility(8);
            this.f59301c.setVisibility(0);
        }
    }

    private KsAppDownloadListener getAppDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            if (this.l == null) {
                this.l = new c(this) { // from class: com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ ActionBarAppLandscape f59310b;

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
                        this.f59310b = this;
                    }

                    @Override // com.kwad.sdk.core.download.a.c
                    public void a(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.b(i2), i2);
                            this.f59310b.f59305g.setVisibility(8);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.A(this.f59310b.f59307i), 0);
                            this.f59310b.f59305g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onDownloadFinished() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.a(this.f59310b.f59306h), 0);
                            this.f59310b.f59305g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onIdle() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.A(this.f59310b.f59307i), 0);
                            this.f59310b.f59305g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onInstalled() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.m(this.f59310b.f59307i), 0);
                            this.f59310b.f59305g.setVisibility(0);
                        }
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public void onProgressUpdate(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                            this.f59310b.f59304f.a(com.kwad.sdk.core.response.a.a.a(i2), i2);
                            this.f59310b.f59305g.setVisibility(8);
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
            this.f59306h = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59307i = j2;
            this.f59308j = aVar;
            this.f59309k = bVar;
            KSImageLoader.loadAppIcon(this.a, com.kwad.sdk.core.response.a.a.au(j2), adTemplate, 12);
            this.f59300b.setText(com.kwad.sdk.core.response.a.a.t(this.f59307i));
            b();
            this.f59304f.a(com.kwad.sdk.core.response.a.a.A(this.f59307i), 0);
            b bVar2 = this.f59309k;
            if (bVar2 != null) {
                bVar2.a(getAppDownloadListener());
            }
            setClickable(true);
            new f(this, this);
            new f(this.f59305g, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.f59306h)) {
            a(view, false);
        }
    }

    public b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59309k : (b) invokeV.objValue;
    }
}
