package com.kwad.components.ad.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;
    public InterfaceC0457a b;
    @Nullable
    public b c;
    public boolean d;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0457a {
        void a();
    }

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adTemplate;
        this.d = false;
    }

    public final void a() {
        InterfaceC0457a interfaceC0457a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.d) {
            return;
        }
        this.d = true;
        if (d.i(this.a).status == 1 || d.i(this.a).status == 2 || d.i(this.a).status == 3) {
            return;
        }
        b bVar = this.c;
        if ((bVar == null || !bVar.a()) && (interfaceC0457a = this.b) != null) {
            interfaceC0457a.a();
        }
    }

    @MainThread
    public final void a(InterfaceC0457a interfaceC0457a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0457a) == null) {
            this.b = interfaceC0457a;
        }
    }

    @MainThread
    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.c = bVar;
        }
    }
}
