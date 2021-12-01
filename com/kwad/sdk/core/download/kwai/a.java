package com.kwad.sdk.core.download.kwai;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes2.dex */
public class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f57405b;

    /* renamed from: c  reason: collision with root package name */
    public d f57406c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f57407d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57408e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f57409f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57410g;

    /* renamed from: h  reason: collision with root package name */
    public String f57411h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, adTemplate, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57411h = str;
        this.f57410g = i2;
        this.a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
            this.f57405b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        }
    }

    private d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            d dVar = new d();
            dVar.f57417c = this.f57405b;
            dVar.f57418d = this.f57408e;
            dVar.a = this.f57410g;
            if (com.kwad.sdk.core.response.a.a.B(this.f57409f)) {
                dVar.f57419e = new com.kwad.sdk.core.download.a.b(this.f57408e);
            }
            dVar.f57416b = new e(this) { // from class: com.kwad.sdk.core.download.kwai.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.download.kwai.e
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                        if (z) {
                            com.kwad.sdk.core.report.a.n(this.a.f57408e);
                        }
                        if (this.a.a == null || !this.a.a.isShowing()) {
                            return;
                        }
                        this.a.a.a(z);
                    }
                }
            };
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    private Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new f(this.f57411h));
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f57406c = d();
            Presenter e2 = e();
            this.f57407d = e2;
            e2.c(this.f57405b);
            this.f57407d.a(this.f57406c);
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f57408e = adTemplate;
            this.f57409f = com.kwad.sdk.core.response.a.d.j(adTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            d dVar = this.f57406c;
            if (dVar != null) {
                dVar.a();
            }
            Presenter presenter = this.f57407d;
            if (presenter != null) {
                presenter.k();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
