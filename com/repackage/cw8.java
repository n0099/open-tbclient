package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.share.CheckRequest;
import com.baidu.tieba.write.share.CheckResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public bw8 b;
    public HttpMessageListener c;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cw8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cw8 cw8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cw8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cw8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof CheckResponse)) {
                dw8 checkResponseData = ((CheckResponse) httpResponsedMessage).getCheckResponseData();
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    httpResponsedMessage.setErrorString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1166));
                }
                if (this.a.b != null) {
                    this.a.b.a(checkResponseData, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    public cw8(BdUniqueId bdUniqueId) {
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
        this.c = new a(this, CmdConfigHttp.CMD_CHECK_SHARE_SDK);
        this.a = bdUniqueId;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerTask(c());
            this.c.setTag(this.a);
            messageManager.registerListener(this.c);
        }
    }

    public final HttpMessageTask c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_SHARE_SDK, TbConfig.CHECK_SHARE_SDK_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setRetry(3);
            tbHttpMessageTask.setResponsedClass(CheckResponse.class);
            return tbHttpMessageTask;
        }
        return (HttpMessageTask) invokeV.objValue;
    }

    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (StringUtils.isNull(str)) {
                bw8 bw8Var = this.b;
                if (bw8Var != null) {
                    bw8Var.a(null, -2112, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f03b8));
                    return;
                }
                return;
            }
            MessageManager.getInstance().removeHttpMessage(this.a);
            CheckRequest checkRequest = new CheckRequest();
            checkRequest.setTag(this.a);
            checkRequest.setAppkey(str);
            checkRequest.setAppletsKey(str2);
            MessageManager.getInstance().sendMessage(checkRequest);
        }
    }

    public void e(bw8 bw8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bw8Var) == null) {
            this.b = bw8Var;
        }
    }
}
