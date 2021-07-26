package tv.danmaku.ijk.media.player;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tv.danmaku.ijk.media.player.b;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes9.dex */
public abstract class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.f f74273a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC2099b f74274b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f74275c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f74276d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f74277e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f74278f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f74279g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f74280h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f74281i;

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
            this.f74273a = null;
            this.f74275c = null;
            this.f74274b = null;
            this.f74276d = null;
            this.f74277e = null;
            this.f74278f = null;
            this.f74279g = null;
            this.f74280h = null;
            this.f74281i = null;
        }
    }

    public final void a(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (aVar = this.f74275c) == null) {
            return;
        }
        aVar.a(this, i2);
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        b.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (iVar = this.f74277e) == null) {
            return;
        }
        iVar.a(this, i2, i3, i4, i5);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public final void a(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f74275c = aVar;
        }
    }

    public final void a(b.InterfaceC2099b interfaceC2099b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC2099b) == null) {
            this.f74274b = interfaceC2099b;
        }
    }

    public final void a(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f74278f = cVar;
        }
    }

    public final void a(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f74279g = dVar;
        }
    }

    public final void a(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.f74281i = eVar;
        }
    }

    public final void a(b.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f74273a = fVar;
        }
    }

    public final void a(b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f74276d = gVar;
        }
    }

    public final void a(b.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            this.f74277e = iVar;
        }
    }

    public final void a(c cVar) {
        b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || (hVar = this.f74280h) == null) {
            return;
        }
        hVar.a(this, cVar);
    }

    public final boolean a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i2, i3, obj)) == null) {
            b.c cVar = this.f74278f;
            return cVar != null && cVar.a(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void b() {
        b.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fVar = this.f74273a) == null) {
            return;
        }
        fVar.a(this);
    }

    public final boolean b(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048592, this, i2, i3, obj)) == null) {
            b.d dVar = this.f74279g;
            return dVar != null && dVar.b(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void c() {
        b.InterfaceC2099b interfaceC2099b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC2099b = this.f74274b) == null) {
            return;
        }
        interfaceC2099b.b(this);
    }

    public final boolean c(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i2, i3, obj)) == null) {
            b.e eVar = this.f74281i;
            return eVar != null && eVar.c(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void d() {
        b.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.f74276d) == null) {
            return;
        }
        gVar.c(this);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iMediaDataSource) == null) {
            throw new UnsupportedOperationException();
        }
    }
}
