package com.kwad.sdk.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f37069a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0444a f37070b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f37071c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37072d;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0444a {
        void a();
    }

    /* loaded from: classes7.dex */
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
        this.f37069a = adTemplate;
        this.f37072d = false;
    }

    public void a() {
        InterfaceC0444a interfaceC0444a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f37072d) {
            return;
        }
        this.f37072d = true;
        if (com.kwad.sdk.core.response.b.c.j(this.f37069a).status == DOWNLOADSTAUS.START || com.kwad.sdk.core.response.b.c.j(this.f37069a).status == DOWNLOADSTAUS.DOWNLOADING || com.kwad.sdk.core.response.b.c.j(this.f37069a).status == DOWNLOADSTAUS.PROGRESS) {
            return;
        }
        b bVar = this.f37071c;
        if ((bVar == null || !bVar.a()) && (interfaceC0444a = this.f37070b) != null) {
            interfaceC0444a.a();
        }
    }

    @MainThread
    public void a(InterfaceC0444a interfaceC0444a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0444a) == null) {
            this.f37070b = interfaceC0444a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f37071c = bVar;
        }
    }
}
