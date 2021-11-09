package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public final b f64443a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f64444b;

    /* renamed from: c  reason: collision with root package name */
    public d f64445c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f64446d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f64447e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f64448f;

    /* renamed from: g  reason: collision with root package name */
    public final int f64449g;

    /* renamed from: h  reason: collision with root package name */
    public String f64450h;

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
        this.f64450h = str;
        this.f64449g = i2;
        this.f64443a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
            this.f64444b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        }
    }

    private d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            d dVar = new d();
            dVar.f64461c = this.f64444b;
            dVar.f64462d = this.f64447e;
            dVar.f64459a = this.f64449g;
            if (com.kwad.sdk.core.response.b.a.v(this.f64448f)) {
                dVar.f64463e = new com.kwad.sdk.core.download.b.b(this.f64447e);
            }
            dVar.f64460b = new e(this) { // from class: com.kwad.sdk.core.download.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f64451a;

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
                    this.f64451a = this;
                }

                @Override // com.kwad.sdk.core.download.a.e
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                        com.kwad.sdk.core.report.a.n(this.f64451a.f64447e);
                        if (this.f64451a.f64443a == null || !this.f64451a.f64443a.isShowing()) {
                            return;
                        }
                        this.f64451a.f64443a.a(z);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new f(this.f64450h));
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f64445c = d();
            Presenter e2 = e();
            this.f64446d = e2;
            e2.a((View) this.f64444b);
            this.f64446d.a(this.f64445c);
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f64447e = adTemplate;
            this.f64448f = com.kwad.sdk.core.response.b.c.i(adTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            d dVar = this.f64445c;
            if (dVar != null) {
                dVar.a();
            }
            Presenter presenter = this.f64446d;
            if (presenter != null) {
                presenter.h();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
