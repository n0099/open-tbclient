package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.kh2;
/* loaded from: classes6.dex */
public class nf2 extends ue2<kh2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kh2.a h;

    /* loaded from: classes6.dex */
    public class a implements kh2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nf2 nf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf2(@NonNull kh2 kh2Var) {
        super(kh2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kh2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((we2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        kh2Var.Z(aVar);
        this.a.a(new ag2());
        this.a.a(new bg2());
        this.a.a(new cg2());
        this.a.a(new eg2());
        this.a.a(new gg2());
        this.a.a(new hg2());
        this.a.a(new ig2());
        this.a.a(new jg2());
        this.a.a(new kg2());
        this.a.a(new lg2());
        this.a.a(new dg2());
        this.a.a(new fg2());
        this.a.a(new ng2());
        this.a.a(new og2());
        this.a.a(new pg2());
        this.a.a(new rg2());
        this.a.a(new qg2());
        this.a.a(new sg2());
        this.a.a(new tg2());
        this.a.a(new ug2());
        this.a.a(new vg2());
        this.a.a(new wg2());
        this.a.a(new xg2());
        this.a.a(new yg2());
        this.a.a(new zg2());
        this.a.a(new ah2());
        this.a.a(new bh2());
        this.a.a(new ch2());
        this.a.a(new dh2());
        this.a.a(new eh2());
        this.a.a(new fh2());
        this.a.a(new hh2());
        this.a.a(new gh2());
        this.a.a(new mg2());
    }

    @Override // com.repackage.ue2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((kh2) this.c).q()) {
                zx1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            zx1.i("InlineRtcRoomController", "authorize type：" + ((kh2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
