package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.backUser.BackUserHTTPResMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserReqMsg;
import com.baidu.tbadk.BdToken.backUser.BackUserSocketResMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public wa b;

    /* loaded from: classes5.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bk4 bk4Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk4Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = bk4Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.getOrginalMessage() == null || this.a.b() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError() || responsedMessage.getError() != 0) {
                return;
            }
            ak4 ak4Var = null;
            if (responsedMessage instanceof BackUserHTTPResMsg) {
                ak4Var = ((BackUserHTTPResMsg) responsedMessage).getData();
            } else if (responsedMessage instanceof BackUserSocketResMsg) {
                ak4Var = ((BackUserSocketResMsg) responsedMessage).getData();
            }
            if (ak4Var == null || !ak4Var.a) {
                return;
            }
            iu4.k().x(iu4.o("pref_key_last_request_mission"), System.currentTimeMillis());
            gu4.e().i();
        }
    }

    public bk4(BdUniqueId bdUniqueId) {
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
        this.b = new a(this, CmdConfigHttp.CMD_BACK_USER, 309689);
        this.a = bdUniqueId;
        c();
        this.b.setTag(this.a);
        MessageManager.getInstance().registerListener(this.b);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !UtilHelper.isSameDay(iu4.k().m(iu4.o("pref_key_last_request_mission"), 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public BdUniqueId b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (BdUniqueId) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hj8.h(309689, BackUserSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, hj8.a(TbConfig.URL_BACK_USER, 309689));
            tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && a()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.a);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }
}
