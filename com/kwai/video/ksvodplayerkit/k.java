package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.util.Map;
/* loaded from: classes7.dex */
public class k implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f40006a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40007b;

    /* renamed from: c  reason: collision with root package name */
    public Surface f40008c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f40009d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40010e;

    /* renamed from: f  reason: collision with root package name */
    public float f40011f;

    /* renamed from: g  reason: collision with root package name */
    public float f40012g;

    /* renamed from: h  reason: collision with root package name */
    public l f40013h;

    /* renamed from: i  reason: collision with root package name */
    public d.InterfaceC0499d f40014i;
    public d.b j;
    public d.c k;
    public b l;
    public d.e m;
    public d.a n;
    public KwaiPlayerDebugInfoView o;
    public float p;

    public k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40010e = true;
        this.f40011f = -1.0f;
        this.f40012g = -1.0f;
        this.p = -1.0f;
        this.f40007b = context;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                return gVar.a();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.p = f2;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(f2);
            }
        }
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f40011f = f2;
            this.f40012g = f3;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(f2, f3);
            }
        }
    }

    public void a(long j) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || (gVar = this.f40006a) == null) {
            return;
        }
        gVar.a(j);
    }

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surface) == null) {
            this.f40008c = surface;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(surface);
            }
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.l = bVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(bVar);
            }
        }
    }

    public void a(d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.n = aVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(aVar);
            }
        }
    }

    public void a(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.j = bVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(bVar);
            }
        }
    }

    public void a(d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.k = cVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(cVar);
            }
        }
    }

    public void a(d.InterfaceC0499d interfaceC0499d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, interfaceC0499d) == null) {
            this.f40014i = interfaceC0499d;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(interfaceC0499d);
            }
        }
    }

    public void a(d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.m = eVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(eVar);
            }
        }
    }

    public void a(d.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(fVar);
            }
            this.f40006a = null;
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, lVar) == null) {
            this.f40013h = lVar;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(lVar);
            }
        }
    }

    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, map) == null) {
            KSVodPlayerBuilder kSVodPlayerBuilder = new KSVodPlayerBuilder(this.f40007b);
            kSVodPlayerBuilder.a(map);
            kSVodPlayerBuilder.a(false);
            kSVodPlayerBuilder.a(str);
            g b2 = kSVodPlayerBuilder.b();
            this.f40006a = b2;
            b2.b(true);
            Surface surface = this.f40008c;
            if (surface != null) {
                this.f40006a.a(surface);
            }
            SurfaceHolder surfaceHolder = this.f40009d;
            if (surfaceHolder != null) {
                this.f40006a.a(surfaceHolder);
            }
            float f2 = this.f40011f;
            if (f2 != -1.0f) {
                float f3 = this.f40012g;
                if (f3 != -1.0f) {
                    this.f40006a.a(f2, f3);
                }
            }
            this.f40006a.a(this.f40010e);
            l lVar = this.f40013h;
            if (lVar != null) {
                this.f40006a.a(lVar);
            }
            float f4 = this.p;
            if (f4 != -1.0f) {
                this.f40006a.a(f4);
            }
            this.f40006a.a(this.f40014i);
            this.f40006a.a(this.k);
            this.f40006a.a(this.j);
            this.f40006a.a(this.m);
            this.f40006a.a(this.l);
            this.f40006a.a(this.n);
            KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView = this.o;
            if (kwaiPlayerDebugInfoView != null) {
                this.f40006a.a(kwaiPlayerDebugInfoView);
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f40010e = z;
            g gVar = this.f40006a;
            if (gVar != null) {
                gVar.a(z);
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                return gVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                return gVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                return gVar.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public void e() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (gVar = this.f40006a) == null) {
            return;
        }
        gVar.e();
    }

    public IKwaiMediaPlayer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            g gVar = this.f40006a;
            if (gVar != null) {
                return gVar.h();
            }
            return null;
        }
        return (IKwaiMediaPlayer) invokeV.objValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gVar = this.f40006a) == null) {
            return;
        }
        gVar.f();
    }
}
