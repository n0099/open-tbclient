package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ed8 implements cd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpMessageListener a;
    public TbHttpMessageTask b;
    public ArrayList<zc8> c;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ed8 ed8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed8Var, Integer.valueOf(i)};
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
            this.a = ed8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003062) {
                if (httpResponsedMessage.getError() == 0) {
                    return;
                }
                Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
                if (orginalMessage instanceof AdUploadHttpRequest) {
                    this.a.f(((AdUploadHttpRequest) orginalMessage).getDataArray());
                }
            }
        }
    }

    public ed8() {
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
        this.a = new a(this, CmdConfigHttp.CMD_AD_UPLOAD);
        this.c = new ArrayList<>();
        g();
        MessageManager.getInstance().registerListener(this.a);
    }

    @Override // com.repackage.cd8
    public void a(zc8 zc8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, zc8Var) == null) || zc8Var == null) {
            return;
        }
        hw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (!(adAdSense == null || adAdSense.d())) {
            this.b.setUrl("http://als.baidu.com/clog/clog");
        }
        e(zc8Var);
        h();
    }

    @Override // com.repackage.cd8
    public void b(zc8 zc8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zc8Var) == null) || zc8Var == null) {
            return;
        }
        e(zc8Var);
    }

    @Override // com.repackage.cd8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public final void e(zc8 zc8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, zc8Var) == null) || zc8Var == null) {
            return;
        }
        if (ListUtils.getCount(this.c) >= 20) {
            this.c.remove(0);
        }
        this.c.add(zc8Var);
    }

    public final void f(List<zc8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.getCount(list) <= 0) {
            return;
        }
        for (zc8 zc8Var : list) {
            if (zc8Var != null) {
                e(zc8Var);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
            this.b = tbHttpMessageTask;
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            this.b.setIsNeedAddCommenParam(true);
            this.b.setResponsedClass(JsonHttpResponsedMessage.class);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || ListUtils.getCount(this.c) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.c), this.b);
        this.c.clear();
    }
}
