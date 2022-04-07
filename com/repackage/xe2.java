package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.ug2;
/* loaded from: classes7.dex */
public class xe2 extends ee2<ug2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ug2.a h;

    /* loaded from: classes7.dex */
    public class a implements ug2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(xe2 xe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe2Var};
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
    public xe2(@NonNull ug2 ug2Var) {
        super(ug2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ug2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ge2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        ug2Var.Z(aVar);
        this.a.a(new kf2());
        this.a.a(new lf2());
        this.a.a(new mf2());
        this.a.a(new of2());
        this.a.a(new qf2());
        this.a.a(new rf2());
        this.a.a(new sf2());
        this.a.a(new tf2());
        this.a.a(new uf2());
        this.a.a(new vf2());
        this.a.a(new nf2());
        this.a.a(new pf2());
        this.a.a(new xf2());
        this.a.a(new yf2());
        this.a.a(new zf2());
        this.a.a(new bg2());
        this.a.a(new ag2());
        this.a.a(new cg2());
        this.a.a(new dg2());
        this.a.a(new eg2());
        this.a.a(new fg2());
        this.a.a(new gg2());
        this.a.a(new hg2());
        this.a.a(new ig2());
        this.a.a(new jg2());
        this.a.a(new kg2());
        this.a.a(new lg2());
        this.a.a(new mg2());
        this.a.a(new ng2());
        this.a.a(new og2());
        this.a.a(new pg2());
        this.a.a(new rg2());
        this.a.a(new qg2());
        this.a.a(new wf2());
    }

    @Override // com.repackage.ee2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((ug2) this.c).q()) {
                jx1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            jx1.i("InlineRtcRoomController", "authorize type：" + ((ug2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
