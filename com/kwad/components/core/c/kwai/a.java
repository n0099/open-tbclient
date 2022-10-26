package com.kwad.components.core.c.kwai;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.c.kwai.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b DG;
    public final b.C0568b DH;
    public d DI;
    public InterfaceC0567a DJ;
    public final AdTemplate mAdTemplate;
    public Presenter mPresenter;
    public final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.c.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0567a {
        void mp();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, b.C0568b c0568b) {
        super(c0568b.context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, c0568b};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DG = bVar;
        this.DH = c0568b;
        this.mAdTemplate = c0568b.adTemplate;
        FrameLayout.inflate(c0568b.context, R.layout.obfuscated_res_0x7f0d0414, this);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f0911ca);
    }

    public static Presenter ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Presenter presenter = new Presenter();
            presenter.a(new e());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    private d mo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            d dVar = new d();
            dVar.DG = this.DG;
            dVar.DH = this.DH;
            AdTemplate adTemplate = this.mAdTemplate;
            dVar.mAdTemplate = adTemplate;
            dVar.mRootContainer = this.mRootContainer;
            if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
                dVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.am();
            this.DI = mo();
            Presenter ap = ap();
            this.mPresenter = ap;
            ap.B(this.mRootContainer);
            this.mPresenter.e(this.DI);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.an();
            d dVar = this.DI;
            if (dVar != null) {
                dVar.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            InterfaceC0567a interfaceC0567a = this.DJ;
            if (interfaceC0567a != null) {
                interfaceC0567a.mp();
            }
        }
    }

    public final void setChangeListener(InterfaceC0567a interfaceC0567a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0567a) == null) {
            this.DJ = interfaceC0567a;
        }
    }
}
