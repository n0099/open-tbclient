package d.a.q0.a.y0.g;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import d.a.q0.a.y0.g.f.a.f;
import d.a.q0.a.y0.g.f.a.g;
import d.a.q0.a.y0.g.f.a.h;
import d.a.q0.a.y0.g.f.a.i;
import d.a.q0.a.y0.g.h.a;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.y0.b<d.a.q0.a.y0.g.h.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.y0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1031a implements a.InterfaceC1032a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1031a(a aVar) {
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
    public a(@NonNull d.a.q0.a.y0.g.h.a aVar) {
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
                super((d.a.q0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
        this.f51701a.a(new d.a.q0.a.y0.g.f.a.d());
        this.f51701a.a(new d.a.q0.a.y0.g.f.a.e());
        this.f51701a.a(new f());
        this.f51701a.a(new g());
        this.f51701a.a(new h());
        this.f51701a.a(new d.a.q0.a.y0.g.f.a.a());
        this.f51701a.a(new i());
        this.f51701a.a(new d.a.q0.a.y0.g.f.a.b());
        this.f51701a.a(new d.a.q0.a.y0.g.f.a.c());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((d.a.q0.a.y0.g.h.a) this.f51703c).o(new C1031a(this));
        }
    }

    @Override // d.a.q0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((d.a.q0.a.y0.g.h.a) this.f51703c).q()) {
                d.a.q0.a.e0.d.g("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            d.a.q0.a.e0.d.g("InlineRtcItemController", "authorize type：" + ((d.a.q0.a.y0.g.h.a) this.f51703c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
