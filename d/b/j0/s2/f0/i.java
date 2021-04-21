package d.b.j0.s2.f0;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i implements f {

    /* renamed from: b  reason: collision with root package name */
    public TbHttpMessageTask f62113b;

    /* renamed from: a  reason: collision with root package name */
    public HttpMessageListener f62112a = new a(CmdConfigHttp.CMD_AD_UPLOAD);

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c> f62114c = new ArrayList<>();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003062) {
                return;
            }
            if (httpResponsedMessage.getError() == 0) {
                return;
            }
            Message<?> orginalMessage = httpResponsedMessage.getOrginalMessage();
            if (orginalMessage instanceof AdUploadHttpRequest) {
                i.this.f(((AdUploadHttpRequest) orginalMessage).getDataArray());
            }
        }
    }

    public i() {
        g();
        MessageManager.getInstance().registerListener(this.f62112a);
    }

    @Override // d.b.j0.s2.f0.f
    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        d.b.i0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
        if (!(adAdSense == null || adAdSense.e())) {
            this.f62113b.setUrl("http://als.baidu.com/clog/clog");
        }
        e(cVar);
        h();
    }

    @Override // d.b.j0.s2.f0.f
    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        e(cVar);
    }

    @Override // d.b.j0.s2.f0.f
    public void c() {
        h();
    }

    public final void e(c cVar) {
        if (cVar == null) {
            return;
        }
        if (ListUtils.getCount(this.f62114c) >= 20) {
            this.f62114c.remove(0);
        }
        this.f62114c.add(cVar);
    }

    public final void f(List<c> list) {
        if (ListUtils.getCount(list) <= 0) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null) {
                e(cVar);
            }
        }
    }

    public final void g() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_UPLOAD, "https://als.baidu.com/clog/clog");
        this.f62113b = tbHttpMessageTask;
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        this.f62113b.setIsNeedAddCommenParam(true);
        this.f62113b.setResponsedClass(JsonHttpResponsedMessage.class);
    }

    public final void h() {
        if (ListUtils.getCount(this.f62114c) <= 0) {
            return;
        }
        MessageManager.getInstance().sendMessage(new AdUploadHttpRequest(this.f62114c), this.f62113b);
        this.f62114c.clear();
    }
}
