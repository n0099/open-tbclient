package d.a.q0.a4.p;

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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f54818a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.a4.p.a f54819b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f54820c;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f54821a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54821a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof CheckResponse)) {
                c checkResponseData = ((CheckResponse) httpResponsedMessage).getCheckResponseData();
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    httpResponsedMessage.setErrorString(TbadkCoreApplication.getInst().getString(R.string.share_sdk_check_no_resp));
                }
                if (this.f54821a.f54819b != null) {
                    this.f54821a.f54819b.a(checkResponseData, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    public b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54820c = new a(this, CmdConfigHttp.CMD_CHECK_SHARE_SDK);
        this.f54818a = bdUniqueId;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.registerTask(c());
            this.f54820c.setTag(this.f54818a);
            messageManager.registerListener(this.f54820c);
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
                d.a.q0.a4.p.a aVar = this.f54819b;
                if (aVar != null) {
                    aVar.a(null, -2112, TbadkCoreApplication.getInst().getString(R.string.check_share_sdk_appkey_null));
                    return;
                }
                return;
            }
            MessageManager.getInstance().removeHttpMessage(this.f54818a);
            CheckRequest checkRequest = new CheckRequest();
            checkRequest.setTag(this.f54818a);
            checkRequest.setAppkey(str);
            checkRequest.setAppletsKey(str2);
            MessageManager.getInstance().sendMessage(checkRequest);
        }
    }

    public void e(d.a.q0.a4.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f54819b = aVar;
        }
    }
}
