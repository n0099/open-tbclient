package d.a.c.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, d.a.c.c.f.d, HttpResponsedMessage> {

    /* renamed from: i  reason: collision with root package name */
    public HttpClient f38388i;

    public b(MessageManager messageManager) {
        super(messageManager);
        this.f38388i = null;
        this.f38388i = new HttpClient(messageManager);
        this.f38394e = d.a.c.c.j.b.d();
    }

    @Override // d.a.c.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        return this.f38388i.e(i2, bdUniqueId);
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        this.f38388i.h(i2, bdUniqueId);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // d.a.c.c.h.c
    public /* bridge */ /* synthetic */ HttpMessage l(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        w(httpMessage2, httpMessageTask);
        return httpMessage2;
    }

    public LinkedList<HttpMessage> v(BdUniqueId bdUniqueId) {
        return this.f38388i.i(bdUniqueId);
    }

    public HttpMessage w(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return httpMessage;
    }

    public void x(BdUniqueId bdUniqueId) {
        this.f38388i.k(bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: y */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        if (httpMessageTask.getConnectTimeOut() == null) {
            httpMessageTask.setConnectTimeOut(((d.a.c.c.j.b) this.f38394e).c());
        }
        this.f38388i.f(httpMessage, httpMessageTask);
    }
}
