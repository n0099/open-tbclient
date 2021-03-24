package d.b.i0.u3.v.m.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
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
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f61838a = 1;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f61839b;

    /* renamed from: c  reason: collision with root package name */
    public final String f61840c;

    /* renamed from: d  reason: collision with root package name */
    public b f61841d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f61842e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f61843f;

    /* renamed from: d.b.i0.u3.v.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1623a extends HttpMessageListener {
        public C1623a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || a.this.f61841d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.f61839b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(a.this.f61842e, responseData.getData().getTab_option())) {
                        a.this.f61842e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(a.this.f61842e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        a.this.f61841d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        a.this.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (a.this.f61838a == 1) {
                            a.this.f61841d.a();
                            return;
                        } else {
                            a.this.f61841d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        a.this.f61841d.b(responseData);
                        if (a.this.f61838a == 1 && responseData.getData().getItem_list().size() < 20) {
                            a.this.f61841d.d();
                        }
                        a.f(a.this);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                a.this.f61841d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                a.this.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b(RelevanceItemSearchData relevanceItemSearchData);

        void d();

        void onError(int i, String str);
    }

    public a(BdUniqueId bdUniqueId, String str) {
        C1623a c1623a = new C1623a(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f61843f = c1623a;
        this.f61839b = bdUniqueId;
        this.f61840c = str;
        c1623a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f61843f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i = aVar.f61838a;
        aVar.f61838a = i + 1;
        return i;
    }

    public void g(String str) {
        l();
        i(str);
    }

    public void h() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f61840c);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f61838a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f61839b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void i(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f61840c);
        httpMessage.addParam("keyword", str);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f61838a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f61839b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void j() {
        MessageManager.getInstance().removeMessage(this.f61839b);
        MessageManager.getInstance().unRegisterListener(this.f61839b);
    }

    public final void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void l() {
        this.f61838a = 1;
    }

    public void m(b bVar) {
        this.f61841d = bVar;
    }
}
