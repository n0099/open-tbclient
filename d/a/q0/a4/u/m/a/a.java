package d.a.q0.a4.u.m.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemUpdatedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchData;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55005a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55006b;

    /* renamed from: c  reason: collision with root package name */
    public final String f55007c;

    /* renamed from: d  reason: collision with root package name */
    public b f55008d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f55009e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f55010f;

    /* renamed from: d.a.q0.a4.u.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1286a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55011a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1286a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f55011a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || this.f55011a.f55008d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == this.f55011a.f55006b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(this.f55011a.f55009e, responseData.getData().getTab_option())) {
                        this.f55011a.f55009e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(this.f55011a.f55009e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        this.f55011a.f55008d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        this.f55011a.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (this.f55011a.f55005a == 1) {
                            this.f55011a.f55008d.a();
                            return;
                        } else {
                            this.f55011a.f55008d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        this.f55011a.f55008d.c(responseData);
                        if (this.f55011a.f55005a == 1 && responseData.getData().getItem_list().size() < 20) {
                            this.f55011a.f55008d.d();
                        }
                        a.f(this.f55011a);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                this.f55011a.f55008d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                this.f55011a.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void c(RelevanceItemSearchData relevanceItemSearchData);

        void d();

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55005a = 1;
        C1286a c1286a = new C1286a(this, CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f55010f = c1286a;
        this.f55006b = bdUniqueId;
        this.f55007c = str;
        c1286a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f55010f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f55005a;
        aVar.f55005a = i2 + 1;
        return i2;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            l();
            i(str);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.f55007c);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f55005a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f55006b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
            httpMessage.addParam("tab_name", this.f55007c);
            httpMessage.addParam("keyword", str);
            httpMessage.addParam(Config.PACKAGE_NAME, this.f55005a);
            httpMessage.addParam("rn", 20);
            httpMessage.setTag(this.f55006b);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().removeMessage(this.f55006b);
            MessageManager.getInstance().unRegisterListener(this.f55006b);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f55005a = 1;
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f55008d = bVar;
        }
    }
}
