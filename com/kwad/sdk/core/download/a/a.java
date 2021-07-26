package com.kwad.sdk.core.download.a;

import android.app.Dialog;
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
/* loaded from: classes6.dex */
public class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f34501a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34502b;

    /* renamed from: c  reason: collision with root package name */
    public d f34503c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f34504d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34505e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f34506f;

    /* renamed from: g  reason: collision with root package name */
    public final int f34507g;

    /* renamed from: h  reason: collision with root package name */
    public String f34508h;

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
        this.f34508h = str;
        this.f34507g = i2;
        this.f34501a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
            this.f34502b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        }
    }

    private d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            d dVar = new d();
            dVar.f34518c = this.f34502b;
            dVar.f34519d = this.f34505e;
            dVar.f34516a = this.f34507g;
            if (com.kwad.sdk.core.response.b.a.v(this.f34506f)) {
                dVar.f34520e = new com.kwad.sdk.core.download.b.b(this.f34505e);
            }
            dVar.f34517b = new e(this) { // from class: com.kwad.sdk.core.download.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34509a;

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
                    this.f34509a = this;
                }

                @Override // com.kwad.sdk.core.download.a.e
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                        com.kwad.sdk.core.report.a.n(this.f34509a.f34505e);
                        if (this.f34509a.f34501a == null || !this.f34509a.f34501a.isShowing()) {
                            return;
                        }
                        this.f34509a.f34501a.dismiss();
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
            presenter.a((Presenter) new f(this.f34508h));
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f34503c = d();
            Presenter e2 = e();
            this.f34504d = e2;
            e2.a((View) this.f34502b);
            this.f34504d.a(this.f34503c);
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f34505e = adTemplate;
            this.f34506f = com.kwad.sdk.core.response.b.c.i(adTemplate);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            d dVar = this.f34503c;
            if (dVar != null) {
                dVar.a();
            }
            Presenter presenter = this.f34504d;
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
