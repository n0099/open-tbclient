package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.video.a.c;
/* loaded from: classes7.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.e f36588a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f36589b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f36590c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f36591d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f36592e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC0438c f36593f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f36594g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f36595h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36588a = null;
            this.f36590c = null;
            this.f36589b = null;
            this.f36591d = null;
            this.f36592e = null;
            this.f36593f = null;
            this.f36594g = null;
            this.f36595h = null;
        }
    }

    public final void a(int i2) {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (aVar = this.f36590c) == null) {
            return;
        }
        aVar.a(this, i2);
    }

    public final void a(int i2, int i3) {
        c.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (hVar = this.f36592e) == null) {
            return;
        }
        hVar.a(this, i2, i3);
    }

    public final void a(TimedText timedText) {
        c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, timedText) == null) || (gVar = this.f36595h) == null) {
            return;
        }
        gVar.a(this, timedText);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f36590c = aVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f36589b = bVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC0438c interfaceC0438c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0438c) == null) {
            this.f36593f = interfaceC0438c;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f36594g = dVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f36588a = eVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f36591d = fVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            this.f36592e = hVar;
        }
    }

    public final void b() {
        c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.f36588a) == null) {
            return;
        }
        eVar.a(this);
    }

    public final boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            c.InterfaceC0438c interfaceC0438c = this.f36593f;
            return interfaceC0438c != null && interfaceC0438c.a(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void c() {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f36589b) == null) {
            return;
        }
        bVar.a(this);
    }

    public final boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            c.d dVar = this.f36594g;
            return dVar != null && dVar.a(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void d() {
        c.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fVar = this.f36591d) == null) {
            return;
        }
        fVar.a(this);
    }
}
