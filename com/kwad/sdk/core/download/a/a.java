package com.kwad.sdk.core.download.a;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.view.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Dialog f36021a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f36022b;

    /* renamed from: c  reason: collision with root package name */
    public d f36023c;

    /* renamed from: d  reason: collision with root package name */
    public Presenter f36024d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f36025e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f36026f;

    /* renamed from: g  reason: collision with root package name */
    public final int f36027g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, @NonNull b bVar, @NonNull AdTemplate adTemplate, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, adTemplate, Integer.valueOf(i2)};
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
        this.f36027g = i2;
        this.f36021a = bVar;
        a(context);
        a(adTemplate);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            FrameLayout.inflate(context, R.layout.ksad_download_dialog_layout, this);
            this.f36022b = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        }
    }

    private d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            d dVar = new d();
            dVar.f36037d = this.f36022b;
            dVar.f36038e = this.f36025e;
            dVar.f36034a = this.f36027g;
            if (com.kwad.sdk.core.response.b.a.y(this.f36026f)) {
                dVar.f36039f = new com.kwad.sdk.core.download.b.b(this.f36025e);
            }
            dVar.f36035b = new e(this) { // from class: com.kwad.sdk.core.download.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f36028a;

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
                    this.f36028a = this;
                }

                @Override // com.kwad.sdk.core.download.a.e
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.d.a.a("DownloadDialogView", "onClose()");
                        com.kwad.sdk.core.report.b.o(this.f36028a.f36025e);
                        if (this.f36028a.f36021a == null || !this.f36028a.f36021a.isShowing()) {
                            return;
                        }
                        this.f36028a.f36021a.dismiss();
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
            presenter.a((Presenter) new f());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36023c = d();
            Presenter e2 = e();
            this.f36024d = e2;
            e2.a((View) this.f36022b);
            this.f36024d.a(this.f36023c);
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f36025e = adTemplate;
            this.f36026f = com.kwad.sdk.core.response.b.c.j(adTemplate);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d dVar = this.f36023c;
            if (dVar != null) {
                dVar.a();
            }
            Presenter presenter = this.f36024d;
            if (presenter != null) {
                presenter.j();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }
}
