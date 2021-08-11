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
/* loaded from: classes2.dex */
public abstract class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.f f79590a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC2153b f79591b;

    /* renamed from: c  reason: collision with root package name */
    public b.a f79592c;

    /* renamed from: d  reason: collision with root package name */
    public b.g f79593d;

    /* renamed from: e  reason: collision with root package name */
    public b.i f79594e;

    /* renamed from: f  reason: collision with root package name */
    public b.c f79595f;

    /* renamed from: g  reason: collision with root package name */
    public b.d f79596g;

    /* renamed from: h  reason: collision with root package name */
    public b.h f79597h;

    /* renamed from: i  reason: collision with root package name */
    public b.e f79598i;

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
            this.f79590a = null;
            this.f79592c = null;
            this.f79591b = null;
            this.f79593d = null;
            this.f79594e = null;
            this.f79595f = null;
            this.f79596g = null;
            this.f79597h = null;
            this.f79598i = null;
        }
    }

    public final void a(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (aVar = this.f79592c) == null) {
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
        if (!(interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) || (iVar = this.f79594e) == null) {
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
            this.f79592c = aVar;
        }
    }

    public final void a(b.InterfaceC2153b interfaceC2153b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC2153b) == null) {
            this.f79591b = interfaceC2153b;
        }
    }

    public final void a(b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            this.f79595f = cVar;
        }
    }

    public final void a(b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f79596g = dVar;
        }
    }

    public final void a(b.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.f79598i = eVar;
        }
    }

    public final void a(b.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f79590a = fVar;
        }
    }

    public final void a(b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f79593d = gVar;
        }
    }

    public final void a(b.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            this.f79594e = iVar;
        }
    }

    public final void a(c cVar) {
        b.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || (hVar = this.f79597h) == null) {
            return;
        }
        hVar.a(this, cVar);
    }

    public final boolean a(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048590, this, i2, i3, obj)) == null) {
            b.c cVar = this.f79595f;
            return cVar != null && cVar.a(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void b() {
        b.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fVar = this.f79590a) == null) {
            return;
        }
        fVar.a(this);
    }

    public final boolean b(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048592, this, i2, i3, obj)) == null) {
            b.d dVar = this.f79596g;
            return dVar != null && dVar.b(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void c() {
        b.InterfaceC2153b interfaceC2153b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (interfaceC2153b = this.f79591b) == null) {
            return;
        }
        interfaceC2153b.b(this);
    }

    public final boolean c(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i2, i3, obj)) == null) {
            b.e eVar = this.f79598i;
            return eVar != null && eVar.c(this, i2, i3, obj);
        }
        return invokeIIL.booleanValue;
    }

    public final void d() {
        b.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gVar = this.f79593d) == null) {
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
