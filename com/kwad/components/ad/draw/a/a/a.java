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
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public b bA;
    public boolean bB;
    public InterfaceC0521a bz;
    public AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0521a {
        void ax();
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean ay();
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
        this.mAdTemplate = adTemplate;
        this.bB = false;
    }

    @MainThread
    public final void a(InterfaceC0521a interfaceC0521a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0521a) == null) {
            this.bz = interfaceC0521a;
        }
    }

    @MainThread
    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.bA = bVar;
        }
    }

    public final void aw() {
        InterfaceC0521a interfaceC0521a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.bB) {
            return;
        }
        this.bB = true;
        if (d.bQ(this.mAdTemplate).status == 1 || d.bQ(this.mAdTemplate).status == 2 || d.bQ(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.bA;
        if ((bVar == null || !bVar.ay()) && (interfaceC0521a = this.bz) != null) {
            interfaceC0521a.ax();
        }
    }
}
