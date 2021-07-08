package d.a.n0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.n0.a.y0.g.f.a.f;
import d.a.n0.a.y0.g.f.a.g;
import d.a.n0.a.y0.g.f.a.h;
import d.a.n0.a.y0.g.f.a.i;
import d.a.n0.a.y0.g.h.a;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.y0.b<d.a.n0.a.y0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0980a implements a.InterfaceC0981a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0980a(a aVar) {
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
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.y0.g.h.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        e();
        this.f48399a.a(new d.a.n0.a.y0.g.f.a.d());
        this.f48399a.a(new d.a.n0.a.y0.g.f.a.e());
        this.f48399a.a(new f());
        this.f48399a.a(new g());
        this.f48399a.a(new h());
        this.f48399a.a(new d.a.n0.a.y0.g.f.a.a());
        this.f48399a.a(new i());
        this.f48399a.a(new d.a.n0.a.y0.g.f.a.b());
        this.f48399a.a(new d.a.n0.a.y0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((d.a.n0.a.y0.g.h.a) this.f48401c).o(new C0980a(this));
        }
    }

    @Override // d.a.n0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((d.a.n0.a.y0.g.h.a) this.f48401c).q()) {
                d.a.n0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            d.a.n0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((d.a.n0.a.y0.g.h.a) this.f48401c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
