package d.a.n0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.n0.a.y0.g.f.b.a0;
import d.a.n0.a.y0.g.f.b.b0;
import d.a.n0.a.y0.g.f.b.c0;
import d.a.n0.a.y0.g.f.b.d0;
import d.a.n0.a.y0.g.f.b.e0;
import d.a.n0.a.y0.g.f.b.f;
import d.a.n0.a.y0.g.f.b.f0;
import d.a.n0.a.y0.g.f.b.g;
import d.a.n0.a.y0.g.f.b.g0;
import d.a.n0.a.y0.g.f.b.h;
import d.a.n0.a.y0.g.f.b.h0;
import d.a.n0.a.y0.g.f.b.i;
import d.a.n0.a.y0.g.f.b.j;
import d.a.n0.a.y0.g.f.b.k;
import d.a.n0.a.y0.g.f.b.l;
import d.a.n0.a.y0.g.f.b.m;
import d.a.n0.a.y0.g.f.b.n;
import d.a.n0.a.y0.g.f.b.o;
import d.a.n0.a.y0.g.f.b.p;
import d.a.n0.a.y0.g.f.b.q;
import d.a.n0.a.y0.g.f.b.r;
import d.a.n0.a.y0.g.f.b.s;
import d.a.n0.a.y0.g.f.b.t;
import d.a.n0.a.y0.g.f.b.u;
import d.a.n0.a.y0.g.f.b.v;
import d.a.n0.a.y0.g.f.b.w;
import d.a.n0.a.y0.g.f.b.x;
import d.a.n0.a.y0.g.f.b.y;
import d.a.n0.a.y0.g.f.b.z;
import d.a.n0.a.y0.g.h.b;
/* loaded from: classes7.dex */
public class b extends d.a.n0.a.y0.b<d.a.n0.a.y0.g.h.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a f48447h;

    /* loaded from: classes7.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.n0.a.y0.g.h.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f48447h = aVar;
        bVar.Z(aVar);
        this.f48399a.a(new d.a.n0.a.y0.g.f.b.a());
        this.f48399a.a(new d.a.n0.a.y0.g.f.b.b());
        this.f48399a.a(new d.a.n0.a.y0.g.f.b.c());
        this.f48399a.a(new d.a.n0.a.y0.g.f.b.e());
        this.f48399a.a(new g());
        this.f48399a.a(new h());
        this.f48399a.a(new i());
        this.f48399a.a(new j());
        this.f48399a.a(new k());
        this.f48399a.a(new l());
        this.f48399a.a(new d.a.n0.a.y0.g.f.b.d());
        this.f48399a.a(new f());
        this.f48399a.a(new n());
        this.f48399a.a(new o());
        this.f48399a.a(new p());
        this.f48399a.a(new r());
        this.f48399a.a(new q());
        this.f48399a.a(new s());
        this.f48399a.a(new t());
        this.f48399a.a(new u());
        this.f48399a.a(new v());
        this.f48399a.a(new w());
        this.f48399a.a(new x());
        this.f48399a.a(new y());
        this.f48399a.a(new z());
        this.f48399a.a(new a0());
        this.f48399a.a(new b0());
        this.f48399a.a(new c0());
        this.f48399a.a(new d0());
        this.f48399a.a(new e0());
        this.f48399a.a(new f0());
        this.f48399a.a(new h0());
        this.f48399a.a(new g0());
        this.f48399a.a(new m());
    }

    @Override // d.a.n0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((d.a.n0.a.y0.g.h.b) this.f48401c).q()) {
                d.a.n0.a.e0.d.g("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            d.a.n0.a.e0.d.g("InlineRtcRoomController", "authorize type：" + ((d.a.n0.a.y0.g.h.b) this.f48401c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
