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
    public AdTemplate f72425a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2003a f72426b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f72427c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72428d;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2003a {
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
        this.f72425a = adTemplate;
        this.f72428d = false;
    }

    public void a() {
        InterfaceC2003a interfaceC2003a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72428d) {
            return;
        }
        this.f72428d = true;
        if (com.kwad.sdk.core.response.b.c.i(this.f72425a).status == 1 || com.kwad.sdk.core.response.b.c.i(this.f72425a).status == 2 || com.kwad.sdk.core.response.b.c.i(this.f72425a).status == 3) {
            return;
        }
        b bVar = this.f72427c;
        if ((bVar == null || !bVar.a()) && (interfaceC2003a = this.f72426b) != null) {
            interfaceC2003a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2003a interfaceC2003a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2003a) == null) {
            this.f72426b = interfaceC2003a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f72427c = bVar;
        }
    }
}
