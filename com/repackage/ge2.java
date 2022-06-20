package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.dg2;
/* loaded from: classes6.dex */
public class ge2 extends nd2<dg2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dg2.a h;

    /* loaded from: classes6.dex */
    public class a implements dg2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ge2 ge2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge2Var};
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
    public ge2(@NonNull dg2 dg2Var) {
        super(dg2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((pd2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        dg2Var.Z(aVar);
        this.a.a(new te2());
        this.a.a(new ue2());
        this.a.a(new ve2());
        this.a.a(new xe2());
        this.a.a(new ze2());
        this.a.a(new af2());
        this.a.a(new bf2());
        this.a.a(new cf2());
        this.a.a(new df2());
        this.a.a(new ef2());
        this.a.a(new we2());
        this.a.a(new ye2());
        this.a.a(new gf2());
        this.a.a(new hf2());
        this.a.a(new if2());
        this.a.a(new kf2());
        this.a.a(new jf2());
        this.a.a(new lf2());
        this.a.a(new mf2());
        this.a.a(new nf2());
        this.a.a(new of2());
        this.a.a(new pf2());
        this.a.a(new qf2());
        this.a.a(new rf2());
        this.a.a(new sf2());
        this.a.a(new tf2());
        this.a.a(new uf2());
        this.a.a(new vf2());
        this.a.a(new wf2());
        this.a.a(new xf2());
        this.a.a(new yf2());
        this.a.a(new ag2());
        this.a.a(new zf2());
        this.a.a(new ff2());
    }

    @Override // com.repackage.nd2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((dg2) this.c).q()) {
                sw1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            sw1.i("InlineRtcRoomController", "authorize type：" + ((dg2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
