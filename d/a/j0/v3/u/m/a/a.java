package d.a.j0.v3.u.m.a;

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
    public int f62245a = 1;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f62246b;

    /* renamed from: c  reason: collision with root package name */
    public final String f62247c;

    /* renamed from: d  reason: collision with root package name */
    public b f62248d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f62249e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f62250f;

    /* renamed from: d.a.j0.v3.u.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1644a extends HttpMessageListener {
        public C1644a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || a.this.f62248d == null) {
                return;
            }
            if (httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == a.this.f62246b) {
                RelevanceItemSearchData responseData = httpResponsedMessage instanceof RelevanceItemSearchResponse ? ((RelevanceItemSearchResponse) httpResponsedMessage).getResponseData() : null;
                if (responseData != null && responseData.getData() != null) {
                    if (!ListUtils.equalList(a.this.f62249e, responseData.getData().getTab_option())) {
                        a.this.f62249e = responseData.getData().getTab_option();
                        MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(a.this.f62249e));
                    }
                    if (httpResponsedMessage.getError() != 0) {
                        a.this.f62248d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        a.this.l();
                        return;
                    } else if (ListUtils.isEmpty(responseData.getData().getItem_list())) {
                        if (a.this.f62245a == 1) {
                            a.this.f62248d.a();
                            return;
                        } else {
                            a.this.f62248d.d();
                            return;
                        }
                    } else if (responseData != null) {
                        a.this.f62248d.c(responseData);
                        if (a.this.f62245a == 1 && responseData.getData().getItem_list().size() < 20) {
                            a.this.f62248d.d();
                        }
                        a.f(a.this);
                        return;
                    } else {
                        return;
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new EvaluateRelevanceItemUpdatedMessage(null));
                a.this.f62248d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                a.this.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void c(RelevanceItemSearchData relevanceItemSearchData);

        void d();

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId, String str) {
        C1644a c1644a = new C1644a(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        this.f62250f = c1644a;
        this.f62246b = bdUniqueId;
        this.f62247c = str;
        c1644a.setTag(bdUniqueId);
        k();
        MessageManager.getInstance().registerListener(this.f62250f);
    }

    public static /* synthetic */ int f(a aVar) {
        int i2 = aVar.f62245a;
        aVar.f62245a = i2 + 1;
        return i2;
    }

    public void g(String str) {
        l();
        i(str);
    }

    public void h() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f62247c);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f62245a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f62246b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void i(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH);
        httpMessage.addParam("tab_name", this.f62247c);
        httpMessage.addParam("keyword", str);
        httpMessage.addParam(Config.PACKAGE_NAME, this.f62245a);
        httpMessage.addParam("rn", 20);
        httpMessage.setTag(this.f62246b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void j() {
        MessageManager.getInstance().removeMessage(this.f62246b);
        MessageManager.getInstance().unRegisterListener(this.f62246b);
    }

    public final void k() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RELEVANCE_ITEM_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.RELEVANCE_ITEM_SEARCH_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(RelevanceItemSearchResponse.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void l() {
        this.f62245a = 1;
    }

    public void m(b bVar) {
        this.f62248d = bVar;
    }
}
