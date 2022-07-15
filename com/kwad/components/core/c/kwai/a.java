package com.kwad.components.core.c.kwai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
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
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class a extends KSFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final b a;
    public final b.C0509b b;
    public final AdTemplate c;
    public final AdBaseFrameLayout d;
    public d e;
    public Presenter f;
    public InterfaceC0508a g;

    /* renamed from: com.kwad.components.core.c.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0508a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@Nullable b bVar, b.C0509b c0509b) {
        super(c0509b.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, c0509b};
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
        this.a = bVar;
        this.b = c0509b;
        this.c = c0509b.b;
        FrameLayout.inflate(c0509b.a, R.layout.obfuscated_res_0x7f0d040f, this);
        this.d = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091182);
    }

    private d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            d dVar = new d();
            dVar.a = this.a;
            dVar.b = this.b;
            AdTemplate adTemplate = this.c;
            dVar.c = adTemplate;
            dVar.d = this.d;
            if (com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.i(adTemplate))) {
                dVar.e = new com.kwad.components.core.c.a.b(this.c);
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public static Presenter d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new e());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void a_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a_();
            d dVar = this.e;
            if (dVar != null) {
                dVar.a();
            }
            Presenter presenter = this.f;
            if (presenter != null) {
                presenter.p();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.e = c();
            Presenter d = d();
            this.f = d;
            d.c(this.d);
            this.f.a(this.e);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            InterfaceC0508a interfaceC0508a = this.g;
            if (interfaceC0508a != null) {
                interfaceC0508a.a();
            }
        }
    }

    public final void setChangeListener(InterfaceC0508a interfaceC0508a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0508a) == null) {
            this.g = interfaceC0508a;
        }
    }
}
