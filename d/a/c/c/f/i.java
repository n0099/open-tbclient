package d.a.c.c.f;

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
import d.a.c.e.p.l;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<d> f42031a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<k> f42032b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b> f42033c = new LinkedList<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<c> f42034d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<j> f42035e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<a> f42036f = new LinkedList<>();

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<e> f42037g = new LinkedList<>();

    public void a(e eVar) {
        this.f42037g.add(eVar);
    }

    public void b(f<?, ?> fVar) {
        if (fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            FrameHelper.f(this.f42031a, (d) fVar);
        } else if (fVar instanceof k) {
            FrameHelper.f(this.f42032b, (k) fVar);
        } else if (fVar instanceof b) {
            FrameHelper.f(this.f42033c, (b) fVar);
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
            FrameHelper.f(this.f42034d, (c) gVar);
        } else if (gVar instanceof j) {
            FrameHelper.f(this.f42035e, (j) gVar);
        } else if (gVar instanceof a) {
            FrameHelper.f(this.f42036f, (a) gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(e eVar) {
        this.f42037g.remove(eVar);
    }

    public void e(f<?, ?> fVar) {
        if (fVar == null) {
            return;
        }
        l.d();
        if (fVar instanceof d) {
            this.f42031a.remove(fVar);
        } else if (fVar instanceof k) {
            this.f42032b.remove(fVar);
        } else if (fVar instanceof b) {
            this.f42033c.remove(fVar);
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
            this.f42034d.remove(gVar);
        } else if (gVar instanceof j) {
            this.f42035e.remove(gVar);
        } else if (gVar instanceof a) {
            this.f42036f.remove(gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> g(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        return (CustomMessage) k(this.f42033c, customMessage, customMessageTask);
    }

    public CustomResponsedMessage<?> h(CustomResponsedMessage<?> customResponsedMessage) {
        return (CustomResponsedMessage) l(this.f42036f, customResponsedMessage);
    }

    public HttpMessage i(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        return (HttpMessage) k(this.f42031a, httpMessage, httpMessageTask);
    }

    public HttpResponsedMessage j(HttpResponsedMessage httpResponsedMessage) {
        return (HttpResponsedMessage) l(this.f42034d, httpResponsedMessage);
    }

    public final <M extends Message<?>, T extends MessageTask> M k(LinkedList<? extends f<M, T>> linkedList, M m, T t) {
        if (linkedList == null) {
            return null;
        }
        int size = linkedList.size();
        for (int i2 = 0; i2 < size && m != null; i2++) {
            try {
                m = linkedList.get(i2).rule(m, t);
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
        for (int i2 = 0; i2 < size && m != null; i2++) {
            try {
                m = linkedList.get(i2).b(m);
            } catch (Exception e2) {
                BdLog.e("rule error = " + e2.getMessage());
            }
        }
        return m;
    }

    public SocketMessage m(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        return (SocketMessage) k(this.f42032b, socketMessage, socketMessageTask);
    }

    public SocketResponsedMessage n(SocketResponsedMessage socketResponsedMessage) {
        return (SocketResponsedMessage) l(this.f42035e, socketResponsedMessage);
    }

    public void o(int i2, BdUniqueId bdUniqueId) {
        int size = this.f42037g.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f42037g.get(i3).a(i2, bdUniqueId);
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        int size = this.f42037g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f42037g.get(i2).b(bdUniqueId);
        }
    }
}
