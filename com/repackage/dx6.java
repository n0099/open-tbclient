package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.personalize.data.RealTimeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RealTimeRequest;
import com.baidu.tieba.homepage.personalize.data.RealTimeSocketResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    public dx6() {
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
        this.a = null;
    }

    public void a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
            b();
            c();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REPORT_HOME_PIC_CLICK, ig8.a(TbConfig.HOME_REALTIME_ADDRESS, 309277));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RealTimeHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w85 w85Var = new w85(309277);
            w85Var.setResponsedClass(RealTimeSocketResponse.class);
            w85Var.g(true);
            MessageManager.getInstance().registerTask(w85Var);
        }
    }

    public final void d(NetMessage netMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, netMessage) == null) || netMessage == null) {
            return;
        }
        if (netMessage.getTag() == null) {
            netMessage.setTag(this.a);
        }
        MessageManager.getInstance().sendMessage(netMessage);
    }

    public void e(long j, String str, String str2, int i, String str3, int i2, String str4, BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2), str4, baijiahaoData}) == null) || StringUtils.isNull(str) || StringUtils.isNull(str2) || StringUtils.isNull(str3)) {
            return;
        }
        RealTimeRequest realTimeRequest = new RealTimeRequest();
        realTimeRequest.setTid(j);
        realTimeRequest.setWeight(str);
        realTimeRequest.setSource(str2);
        realTimeRequest.setLocation(i);
        realTimeRequest.setAbtest_tag(str3);
        realTimeRequest.setType(i2);
        realTimeRequest.setPage(str4);
        if (baijiahaoData != null && i2 != jg.e("2", 0)) {
            realTimeRequest.setOriUgcNid(baijiahaoData.oriUgcNid);
            realTimeRequest.setOriUgcTid(baijiahaoData.oriUgcTid);
            realTimeRequest.setOriUgcType(Integer.toString(baijiahaoData.oriUgcType));
            realTimeRequest.setOriUgcVid(baijiahaoData.oriUgcVid);
        }
        d(realTimeRequest);
    }
}
