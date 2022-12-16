package com.kwad.components.core.webview.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.b.a.q;
import com.kwad.components.core.webview.b.e;
import com.kwad.components.core.webview.b.kwai.i;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.sdk.components.h;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
public abstract class a extends Presenter implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b Ob;
    public com.kwad.components.core.webview.b.d hN;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) {
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
        }
    }

    public void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, hVar, bVar) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.aq();
            b bVar = (b) xR();
            this.Ob = bVar;
            a(bVar);
            if (this.hN == null) {
                this.hN = ip();
            }
            com.kwad.components.core.webview.b.d dVar = this.hN;
            b bVar2 = this.Ob;
            dVar.a(bVar2.mActivity, bVar2.mAdTemplate, this);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(com.kwad.components.core.webview.b.a.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.widget.e dD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.Ob.Oc : (com.kwad.sdk.widget.e) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dE() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (dVar = this.Ob.Ne) == null) {
            return;
        }
        dVar.dismiss();
    }

    @Override // com.kwad.components.core.webview.b.e
    public void dI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (com.kwad.sdk.core.webview.a.kwai.a) invokeV.objValue;
    }

    public com.kwad.components.core.webview.b.d ip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new com.kwad.components.core.webview.b.d(this.Ob.tS, getContext()) : (com.kwad.components.core.webview.b.d) invokeV.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onUnbind();
            this.hN.pF();
            this.hN = null;
        }
    }
}
