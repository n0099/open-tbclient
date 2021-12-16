package com.kwad.sdk.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2100a f58901b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f58902c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58903d;

    /* renamed from: com.kwad.sdk.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2100a {
        void a();
    }

    /* loaded from: classes3.dex */
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
        this.a = adTemplate;
        this.f58903d = false;
    }

    public void a() {
        InterfaceC2100a interfaceC2100a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58903d) {
            return;
        }
        this.f58903d = true;
        if (d.j(this.a).status == 1 || d.j(this.a).status == 2 || d.j(this.a).status == 3) {
            return;
        }
        b bVar = this.f58902c;
        if ((bVar == null || !bVar.a()) && (interfaceC2100a = this.f58901b) != null) {
            interfaceC2100a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2100a interfaceC2100a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2100a) == null) {
            this.f58901b = interfaceC2100a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f58902c = bVar;
        }
    }
}
