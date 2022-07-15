package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.sg2;
/* loaded from: classes7.dex */
public class ve2 extends ce2<sg2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sg2.a h;

    /* loaded from: classes7.dex */
    public class a implements sg2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ve2 ve2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve2Var};
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
    public ve2(@NonNull sg2 sg2Var) {
        super(sg2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ee2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        sg2Var.Z(aVar);
        this.a.a(new if2());
        this.a.a(new jf2());
        this.a.a(new kf2());
        this.a.a(new mf2());
        this.a.a(new of2());
        this.a.a(new pf2());
        this.a.a(new qf2());
        this.a.a(new rf2());
        this.a.a(new sf2());
        this.a.a(new tf2());
        this.a.a(new lf2());
        this.a.a(new nf2());
        this.a.a(new vf2());
        this.a.a(new wf2());
        this.a.a(new xf2());
        this.a.a(new zf2());
        this.a.a(new yf2());
        this.a.a(new ag2());
        this.a.a(new bg2());
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
        this.a.a(new pg2());
        this.a.a(new og2());
        this.a.a(new uf2());
    }

    @Override // com.repackage.ce2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((sg2) this.c).q()) {
                hx1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            hx1.i("InlineRtcRoomController", "authorize type：" + ((sg2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
