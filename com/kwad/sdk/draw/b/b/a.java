package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f73159a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2013a f73160b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f73161c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73162d;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2013a {
        void a();
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73159a = adTemplate;
        this.f73162d = false;
    }

    public void a() {
        InterfaceC2013a interfaceC2013a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73162d) {
            return;
        }
        this.f73162d = true;
        if (com.kwad.sdk.core.response.b.c.i(this.f73159a).status == 1 || com.kwad.sdk.core.response.b.c.i(this.f73159a).status == 2 || com.kwad.sdk.core.response.b.c.i(this.f73159a).status == 3) {
            return;
        }
        b bVar = this.f73161c;
        if ((bVar == null || !bVar.a()) && (interfaceC2013a = this.f73160b) != null) {
            interfaceC2013a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2013a interfaceC2013a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2013a) == null) {
            this.f73160b = interfaceC2013a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f73161c = bVar;
        }
    }
}
