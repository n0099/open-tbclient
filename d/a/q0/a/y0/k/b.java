package d.a.q0.a.y0.k;

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
import d.a.q0.a.u.e.o.k;
import d.a.q0.a.y0.k.e.e;
import d.a.q0.a.y0.k.e.f;
import d.a.q0.a.y0.k.e.g;
import d.a.q0.a.y0.k.e.h;
import d.a.q0.a.y0.k.e.i;
import d.a.q0.a.y0.k.e.j;
import d.a.q0.a.y0.k.e.l;
import d.a.q0.a.y0.k.e.m;
import d.a.q0.a.y0.k.e.n;
import d.a.q0.a.y0.k.e.o;
import d.a.q0.a.y0.k.e.p;
import d.a.q0.a.y0.k.e.q;
import d.a.q0.a.y0.k.e.r;
import d.a.q0.a.y0.k.e.s;
import d.a.q0.a.y0.k.e.t;
import d.a.q0.a.y0.k.e.u;
import d.a.q0.a.y0.k.e.v;
import d.a.q0.a.y0.k.g.a;
/* loaded from: classes8.dex */
public final class b extends d.a.q0.a.y0.b<d.a.q0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51806i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC1039a f51807h;

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC1039a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f51808a;

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
            this.f51808a = bVar;
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onInfo", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f51808a.f51702b != null) {
                    this.f51808a.f51702b.onCallback(this.f51808a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                k.e().k(str, false);
            }
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onNetStatus", str);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f51808a.f51702b != null) {
                    this.f51808a.f51702b.onCallback(this.f51808a, "onPlayed", null);
                }
                k.e().k(str, true);
                k.e().j(str);
            }
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onVideoSizeChanged", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onEnded", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onError", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f51808a.f51702b == null) {
                return;
            }
            this.f51808a.f51702b.onCallback(this.f51808a, "onPrepared", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (b.f51806i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                k.e().p(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386770212, "Ld/a/q0/a/y0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386770212, "Ld/a/q0/a/y0/k/b;");
                return;
            }
        }
        f51806i = d.a.q0.a.k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.q0.a.y0.k.g.a aVar) {
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
                super((d.a.q0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar2 = new a(this);
        this.f51807h = aVar2;
        aVar.h0(aVar2);
        this.f51701a.a(new d.a.q0.a.y0.k.e.a());
        this.f51701a.a(new d.a.q0.a.y0.k.e.b());
        this.f51701a.a(new d.a.q0.a.y0.k.e.c());
        this.f51701a.a(new f());
        this.f51701a.a(new e());
        this.f51701a.a(new d.a.q0.a.y0.k.e.d());
        this.f51701a.a(new g());
        this.f51701a.a(new h());
        this.f51701a.a(new i());
        this.f51701a.a(new j());
        this.f51701a.a(new l());
        this.f51701a.a(new m());
        this.f51701a.a(new n());
        this.f51701a.a(new o());
        this.f51701a.a(new q());
        this.f51701a.a(new r());
        this.f51701a.a(new s());
        this.f51701a.a(new u());
        this.f51701a.a(new v());
        this.f51701a.a(new p());
        this.f51701a.a(new d.a.q0.a.y0.k.e.k());
        this.f51701a.a(new t());
    }
}
