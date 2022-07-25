package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigHTTPResMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigReqMsg;
import com.baidu.tbadk.BdToken.activeConfig.ActiveConfigSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kj4<lj4> a;
    public boolean b;
    public BdUniqueId c;
    public za d;

    /* loaded from: classes6.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mj4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mj4 mj4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj4Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = mj4Var;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.b = false;
                if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.d() != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (this.a.a != null) {
                        this.a.a.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                lj4 lj4Var = null;
                if (responsedMessage instanceof ActiveConfigSocketResMsg) {
                    lj4Var = ((ActiveConfigSocketResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof ActiveConfigHTTPResMsg) {
                    lj4Var = ((ActiveConfigHTTPResMsg) responsedMessage).getData();
                }
                if ((responsedMessage.getOrginalMessage().getExtra() instanceof ActiveConfigReqMsg) && ((ActiveConfigReqMsg) responsedMessage.getOrginalMessage().getExtra()).launtchType == 0) {
                    yt4.k().x("pref_key_active_config_info", System.currentTimeMillis());
                }
                if (lj4Var != null && lj4Var.g != null && this.a.a != null) {
                    this.a.a.a(lj4Var);
                }
                if (lj4Var != null && this.a.c()) {
                    yt4.k().x("pref_key_last_register_mission", System.currentTimeMillis());
                    xi4.b().i(lj4Var);
                    if (this.a.a != null) {
                        this.a.a.onSuccess(lj4Var);
                    }
                }
                wt4.e().j(lj4Var);
            }
        }
    }

    public mj4(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.d = new a(this, CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637);
        this.c = bdUniqueId;
        e();
        this.d.setTag(d());
        MessageManager.getInstance().registerListener(this.d);
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !UtilHelper.isSameDay(yt4.k().m("pref_key_last_register_mission", 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public BdUniqueId d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (BdUniqueId) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            wh8.h(309637, ActiveConfigSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, wh8.a(TbConfig.URL_ACTIVE_CONFIG, 309637));
            tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void f(boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || this.b) {
            return;
        }
        if (!z) {
            this.b = true;
        }
        yt4.k().x("pref_key_last_active_config", System.currentTimeMillis());
        ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
        activeConfigReqMsg.setFirstUp(z);
        activeConfigReqMsg.setSchemaUp(z2);
        activeConfigReqMsg.launtchType = i;
        activeConfigReqMsg.setTag(d());
        MessageManager.getInstance().sendMessage(activeConfigReqMsg);
    }

    public void g(kj4<lj4> kj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kj4Var) == null) {
            this.a = kj4Var;
        }
    }
}
