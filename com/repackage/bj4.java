package com.repackage;

import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.GetTokenHttpResponsedMessage;
import com.baidu.tbadk.BdToken.GetTokenRequestMessage;
import com.baidu.tbadk.BdToken.GetTokenSocketResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public b b;
    public wa c;

    /* loaded from: classes5.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bj4 bj4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj4Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.a = false;
                if (responsedMessage == null || responsedMessage.getError() != 0) {
                    this.a.d(false, null);
                } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                    this.a.d(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
                } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                    this.a.d(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, wj4 wj4Var);
    }

    public bj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = new a(this, CmdConfigHttp.CMD_GET_TOKEN, 309608);
        f();
        e();
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a) {
            return;
        }
        this.a = true;
        GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
        getTokenRequestMessage.setToken(Base64.encodeToString(str.getBytes(), 2));
        getTokenRequestMessage.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        MessageManager.getInstance().sendMessage(getTokenRequestMessage);
    }

    public final void d(boolean z, wj4 wj4Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, wj4Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.a(z, wj4Var);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hj8.h(309608, GetTokenSocketResponsedMessage.class, false, false);
            hj8.c(309608, CmdConfigHttp.CMD_GET_TOKEN, TbConfig.URL_GET_TOKEN, GetTokenHttpResponsedMessage.class, false, false, false, false);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.b = bVar;
        }
    }
}
