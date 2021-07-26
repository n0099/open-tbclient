package d.a.o0.a.y0.k;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.u.e.o.k;
import d.a.o0.a.y0.k.e.e;
import d.a.o0.a.y0.k.e.f;
import d.a.o0.a.y0.k.e.g;
import d.a.o0.a.y0.k.e.h;
import d.a.o0.a.y0.k.e.i;
import d.a.o0.a.y0.k.e.j;
import d.a.o0.a.y0.k.e.l;
import d.a.o0.a.y0.k.e.m;
import d.a.o0.a.y0.k.e.n;
import d.a.o0.a.y0.k.e.o;
import d.a.o0.a.y0.k.e.p;
import d.a.o0.a.y0.k.e.q;
import d.a.o0.a.y0.k.e.r;
import d.a.o0.a.y0.k.e.s;
import d.a.o0.a.y0.k.e.t;
import d.a.o0.a.y0.k.e.u;
import d.a.o0.a.y0.k.e.v;
import d.a.o0.a.y0.k.g.a;
/* loaded from: classes7.dex */
public final class b extends d.a.o0.a.y0.b<d.a.o0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49008i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0997a f49009h;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0997a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f49010a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49010a = bVar;
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onInfo", Integer.valueOf(i2));
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f49010a.f48904b != null) {
                    this.f49010a.f48904b.onCallback(this.f49010a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                k.e().k(str, false);
            }
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onNetStatus", str);
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f49010a.f48904b != null) {
                    this.f49010a.f48904b.onCallback(this.f49010a, "onPlayed", null);
                }
                k.e().k(str, true);
                k.e().j(str);
            }
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onVideoSizeChanged", null);
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onEnded", null);
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onError", Integer.valueOf(i2));
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f49010a.f48904b == null) {
                return;
            }
            this.f49010a.f48904b.onCallback(this.f49010a, "onPrepared", null);
        }

        @Override // d.a.o0.a.y0.k.g.a.InterfaceC0997a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (b.f49008i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                k.e().p(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1644935650, "Ld/a/o0/a/y0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1644935650, "Ld/a/o0/a/y0/k/b;");
                return;
            }
        }
        f49008i = d.a.o0.a.k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.o0.a.y0.k.g.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar2 = new a(this);
        this.f49009h = aVar2;
        aVar.h0(aVar2);
        this.f48903a.a(new d.a.o0.a.y0.k.e.a());
        this.f48903a.a(new d.a.o0.a.y0.k.e.b());
        this.f48903a.a(new d.a.o0.a.y0.k.e.c());
        this.f48903a.a(new f());
        this.f48903a.a(new e());
        this.f48903a.a(new d.a.o0.a.y0.k.e.d());
        this.f48903a.a(new g());
        this.f48903a.a(new h());
        this.f48903a.a(new i());
        this.f48903a.a(new j());
        this.f48903a.a(new l());
        this.f48903a.a(new m());
        this.f48903a.a(new n());
        this.f48903a.a(new o());
        this.f48903a.a(new q());
        this.f48903a.a(new r());
        this.f48903a.a(new s());
        this.f48903a.a(new u());
        this.f48903a.a(new v());
        this.f48903a.a(new p());
        this.f48903a.a(new d.a.o0.a.y0.k.e.k());
        this.f48903a.a(new t());
    }
}
