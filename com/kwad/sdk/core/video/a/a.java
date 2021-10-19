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
/* loaded from: classes10.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.e f72607a;

    /* renamed from: b  reason: collision with root package name */
    public c.b f72608b;

    /* renamed from: c  reason: collision with root package name */
    public c.a f72609c;

    /* renamed from: d  reason: collision with root package name */
    public c.f f72610d;

    /* renamed from: e  reason: collision with root package name */
    public c.h f72611e;

    /* renamed from: f  reason: collision with root package name */
    public c.InterfaceC2001c f72612f;

    /* renamed from: g  reason: collision with root package name */
    public c.d f72613g;

    /* renamed from: h  reason: collision with root package name */
    public c.g f72614h;

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
            this.f72607a = null;
            this.f72609c = null;
            this.f72608b = null;
            this.f72610d = null;
            this.f72611e = null;
            this.f72612f = null;
            this.f72613g = null;
            this.f72614h = null;
        }
    }

    public final void a(int i2) {
        c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (aVar = this.f72609c) == null) {
            return;
        }
        aVar.a(this, i2);
    }

    public final void a(int i2, int i3) {
        c.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (hVar = this.f72611e) == null) {
            return;
        }
        hVar.a(this, i2, i3);
    }

    public final void a(TimedText timedText) {
        c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, timedText) == null) || (gVar = this.f72614h) == null) {
            return;
        }
        gVar.a(this, timedText);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f72609c = aVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f72608b = bVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.InterfaceC2001c interfaceC2001c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC2001c) == null) {
            this.f72612f = interfaceC2001c;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f72613g = dVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f72607a = eVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f72610d = fVar;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public void a(c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            this.f72611e = hVar;
        }
    }

    public final void b() {
        c.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.f72607a) == null) {
            return;
        }
        eVar.a(this);
    }

    public final boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            c.InterfaceC2001c interfaceC2001c = this.f72612f;
            return interfaceC2001c != null && interfaceC2001c.a(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void c() {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bVar = this.f72608b) == null) {
            return;
        }
        bVar.a(this);
    }

    public final boolean c(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            c.d dVar = this.f72613g;
            return dVar != null && dVar.a(this, i2, i3);
        }
        return invokeII.booleanValue;
    }

    public final void d() {
        c.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fVar = this.f72610d) == null) {
            return;
        }
        fVar.a(this);
    }
}
