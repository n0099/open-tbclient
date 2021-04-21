package d.b.c.c.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.e.p.l;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<d> f42280a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<k> f42281b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b> f42282c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<c> f42283d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<j> f42284e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<a> f42285f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<e> f42286g = new LinkedList<>();

    public void a(e eVar) {
        this.f42286g.add(eVar);
    }

    public void b(f<?, ?> fVar) {
        if (fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            FrameHelper.f(this.f42280a, (d) fVar);
        } else if (fVar instanceof k) {
            FrameHelper.f(this.f42281b, (k) fVar);
        } else if (fVar instanceof b) {
            FrameHelper.f(this.f42282c, (b) fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(g<?> gVar) {
        if (gVar == null) {
            return;
        }
        l.d();
        if (gVar instanceof c) {
            FrameHelper.f(this.f42283d, (c) gVar);
        } else if (gVar instanceof j) {
            FrameHelper.f(this.f42284e, (j) gVar);
        } else if (gVar instanceof a) {
            FrameHelper.f(this.f42285f, (a) gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(e eVar) {
        this.f42286g.remove(eVar);
    }

    public void e(f<?, ?> fVar) {
        if (fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            this.f42280a.remove(fVar);
        } else if (fVar instanceof k) {
            this.f42281b.remove(fVar);
        } else if (fVar instanceof b) {
            this.f42282c.remove(fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void f(g<?> gVar) {
        if (gVar == null) {
            return;
        }
        l.d();
        if (gVar instanceof c) {
            this.f42283d.remove(gVar);
        } else if (gVar instanceof j) {
            this.f42284e.remove(gVar);
        } else if (gVar instanceof a) {
            this.f42285f.remove(gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> g(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) k(this.f42282c, customMessage, customMessageTask);
    }

    public CustomResponsedMessage<?> h(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) l(this.f42285f, customResponsedMessage);
    }

    public HttpMessage i(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) k(this.f42280a, httpMessage, httpMessageTask);
    }

    public HttpResponsedMessage j(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) l(this.f42283d, httpResponsedMessage);
    }

    public final <M extends Message<?>, T extends MessageTask> M k(LinkedList<? extends f<M, T>> linkedList, M m, T t) {
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        for (int i = 0; i < size && m != null; i++) {
            try {
                m = linkedList.get(i).rule(m, t);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return m;
    }

    public final <M extends ResponsedMessage<?>> M l(LinkedList<? extends g<M>> linkedList, M m) {
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        for (int i = 0; i < size && m != null; i++) {
            try {
                m = linkedList.get(i).b(m);
            } catch (Exception e2) {
                BdLog.e("rule error = " + e2.getMessage());
            }
        }
        return m;
    }

    public SocketMessage m(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) k(this.f42281b, socketMessage, socketMessageTask);
    }

    public SocketResponsedMessage n(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) l(this.f42284e, socketResponsedMessage);
    }

    public void o(int i, BdUniqueId bdUniqueId) {
        int size = this.f42286g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f42286g.get(i2).a(i, bdUniqueId);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        int size = this.f42286g.size();
        for (int i = 0; i < size; i++) {
            this.f42286g.get(i).b(bdUniqueId);
        }
    }
}
