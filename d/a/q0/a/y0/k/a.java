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
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
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
import d.a.q0.a.y0.k.e.t;
import d.a.q0.a.y0.k.e.u;
import d.a.q0.a.y0.k.e.v;
import d.a.q0.a.y0.k.g.a;
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.y0.b<d.a.q0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51803i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC1039a f51804h;

    /* renamed from: d.a.q0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1037a implements a.InterfaceC1039a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51805a;

        public C1037a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51805a = aVar;
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onInfo", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f51805a.f51702b != null) {
                    this.f51805a.f51702b.onCallback(this.f51805a, "onPaused", null);
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onNetStatus", str);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f51805a.f51702b != null) {
                    this.f51805a.f51702b.onCallback(this.f51805a, "onPlayed", null);
                }
                k.e().k(str, true);
            }
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onVideoSizeChanged", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onEnded", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onError", Integer.valueOf(i2));
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f51805a.f51702b == null) {
                return;
            }
            this.f51805a.f51702b.onCallback(this.f51805a, "onPrepared", null);
        }

        @Override // d.a.q0.a.y0.k.g.a.InterfaceC1039a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                k.e().p(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1386770243, "Ld/a/q0/a/y0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1386770243, "Ld/a/q0/a/y0/k/a;");
                return;
            }
        }
        f51803i = d.a.q0.a.k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.y0.k.g.a aVar) {
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
        C1037a c1037a = new C1037a(this);
        this.f51804h = c1037a;
        aVar.h0(c1037a);
        k.e().b(aVar);
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
        this.f51701a.a(new u());
        this.f51701a.a(new v());
        this.f51701a.a(new p());
        this.f51701a.a(new d.a.q0.a.y0.k.e.k());
        this.f51701a.a(new t());
    }

    @Override // d.a.q0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (f51803i) {
                    Log.d("LiveInlineController", "reject command => " + command.what);
                    return;
                }
                return;
            }
            super.sendCommand(command);
        }
    }

    public final boolean w(ZeusPlugin.Command command) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command)) == null) {
            if (command != null && TextUtils.equals(command.what, m.f51811b)) {
                if (f51803i) {
                    Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                }
                return false;
            }
            int a2 = ((d.a.q0.a.y0.k.g.a) this.f51703c).a();
            if (f51803i && a2 != 1) {
                String str = command == null ? "" : command.what;
                Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((d.a.q0.a.y0.k.g.a) this.f51703c).a() + " command=> " + str);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
