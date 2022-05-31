package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.repackage.rf2;
/* loaded from: classes7.dex */
public class ud2 extends cd2<rf2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements rf2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ud2 ud2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ud2Var};
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
    public ud2(@NonNull rf2 rf2Var) {
        super(rf2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rf2Var};
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
        e();
        this.a.a(new ce2());
        this.a.a(new de2());
        this.a.a(new ee2());
        this.a.a(new fe2());
        this.a.a(new ge2());
        this.a.a(new zd2());
        this.a.a(new he2());
        this.a.a(new ae2());
        this.a.a(new be2());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ((rf2) this.c).o(new a(this));
        }
    }

    @Override // com.repackage.cd2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((rf2) this.c).q()) {
                hw1.i("InlineRtcItemController", "isReleased command：" + str);
                return;
            }
            hw1.i("InlineRtcItemController", "authorize type：" + ((rf2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
