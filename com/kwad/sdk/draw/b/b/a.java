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
    public AdTemplate f72805a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC2007a f72806b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public b f72807c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72808d;

    /* renamed from: com.kwad.sdk.draw.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2007a {
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
        this.f72805a = adTemplate;
        this.f72808d = false;
    }

    public void a() {
        InterfaceC2007a interfaceC2007a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72808d) {
            return;
        }
        this.f72808d = true;
        if (com.kwad.sdk.core.response.b.c.i(this.f72805a).status == 1 || com.kwad.sdk.core.response.b.c.i(this.f72805a).status == 2 || com.kwad.sdk.core.response.b.c.i(this.f72805a).status == 3) {
            return;
        }
        b bVar = this.f72807c;
        if ((bVar == null || !bVar.a()) && (interfaceC2007a = this.f72806b) != null) {
            interfaceC2007a.a();
        }
    }

    @MainThread
    public void a(InterfaceC2007a interfaceC2007a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC2007a) == null) {
            this.f72806b = interfaceC2007a;
        }
    }

    @MainThread
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f72807c = bVar;
        }
    }
}
