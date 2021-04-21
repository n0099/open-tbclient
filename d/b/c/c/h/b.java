package d.b.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, d.b.c.c.f.d, HttpResponsedMessage> {
    public HttpClient i;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.i = null;
        this.i = new HttpClient(messageManager);
        this.f42294e = d.b.c.c.j.b.d();
    }

    @Override // d.b.c.c.b
    public LinkedList<HttpMessage> e(int i, BdUniqueId bdUniqueId) {
        return this.i.e(i, bdUniqueId);
    }

    @Override // d.b.c.c.b
    public void h(int i, BdUniqueId bdUniqueId) {
        this.i.h(i, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.b.c.c.h.c
    public /* bridge */ /* synthetic */ HttpMessage l(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        w(httpMessage2, httpMessageTask);
        return httpMessage2;
    }

    public LinkedList<HttpMessage> v(BdUniqueId bdUniqueId) {
        return this.i.i(bdUniqueId);
    }

    public HttpMessage w(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return httpMessage;
    }

    public void x(BdUniqueId bdUniqueId) {
        this.i.k(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.c.b
    /* renamed from: y */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((d.b.c.c.j.b) this.f42294e).c());
        }
        this.i.f(httpMessage, httpMessageTask);
    }
}
