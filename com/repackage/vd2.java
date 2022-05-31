package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.sf2;
/* loaded from: classes7.dex */
public class vd2 extends cd2<sf2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sf2.a h;

    /* loaded from: classes7.dex */
    public class a implements sf2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var};
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
    public vd2(@NonNull sf2 sf2Var) {
        super(sf2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ed2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        sf2Var.Z(aVar);
        this.a.a(new ie2());
        this.a.a(new je2());
        this.a.a(new ke2());
        this.a.a(new me2());
        this.a.a(new oe2());
        this.a.a(new pe2());
        this.a.a(new qe2());
        this.a.a(new re2());
        this.a.a(new se2());
        this.a.a(new te2());
        this.a.a(new le2());
        this.a.a(new ne2());
        this.a.a(new ve2());
        this.a.a(new we2());
        this.a.a(new xe2());
        this.a.a(new ze2());
        this.a.a(new ye2());
        this.a.a(new af2());
        this.a.a(new bf2());
        this.a.a(new cf2());
        this.a.a(new df2());
        this.a.a(new ef2());
        this.a.a(new ff2());
        this.a.a(new gf2());
        this.a.a(new hf2());
        this.a.a(new if2());
        this.a.a(new jf2());
        this.a.a(new kf2());
        this.a.a(new lf2());
        this.a.a(new mf2());
        this.a.a(new nf2());
        this.a.a(new pf2());
        this.a.a(new of2());
        this.a.a(new ue2());
    }

    @Override // com.repackage.cd2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((sf2) this.c).q()) {
                hw1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            hw1.i("InlineRtcRoomController", "authorize type：" + ((sf2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
