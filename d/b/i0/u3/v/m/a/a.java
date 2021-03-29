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
    public int f61839a = 1;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f61840b;

    /* renamed from: c  reason: collision with root package name */
    public final String f61841c;

    /* renamed from: d  reason: collision with root package name */
    public b f61842d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f61843e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f61844f;

    /* renamed from: d.b.i0.u3.v.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1624a extends HttpMessageListener {
        public C1624a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || a.this.f61842d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.f61840b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(a.this.f61843e, responseData.getData().getTab_option())) {
                        a.this.f61843e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(a.this.f61843e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        a.this.f61842d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        a.this.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (a.this.f61839a == 1) {
                            a.this.f61842d.a();
                            return;
                        } else {
                            a.this.f61842d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        a.this.f61842d.b(responseData);
                        if (a.this.f61839a == 1 && responseData.getData().getItem_list().size() < 20) {
                            a.this.f61842d.d();
                        }
                        a.f(a.this);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                a.this.f61842d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
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
        C1624a c1624a = new C1624a(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f61844f = c1624a;
        this.f61840b = bdUniqueId;
        this.f61841c = str;
        c1624a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f61844f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i = aVar.f61839a;
        aVar.f61839a = i + 1;
        return i;
    }

    public void g(String str) {
        l();
        i(str);
    }

    public void h() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f61841c);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f61839a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f61840b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void i(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f61841c);
        httpMessage.addParam("keyword", str);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f61839a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f61840b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void j() {
        MessageManager.getInstance().removeMessage(this.f61840b);
        MessageManager.getInstance().unRegisterListener(this.f61840b);
    }

    public final void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void l() {
        this.f61839a = 1;
    }

    public void m(b bVar) {
        this.f61842d = bVar;
    }
}
