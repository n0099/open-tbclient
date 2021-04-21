package d.b.c.c.h;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import d.b.c.c.f.f;
import d.b.c.e.p.l;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements d.b.c.c.b<M, T> {

    /* renamed from: h  reason: collision with root package name */
    public static d.b.c.c.g.b<Message<?>> f42289h;

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f42290a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<T> f42291b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<N> f42292c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<LinkedList<MessageListener<N>>> f42293d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.c.j.d f42294e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42295f = false;

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f42296g = new SparseIntArray();

    public c(MessageManager messageManager) {
        this.f42290a = null;
        this.f42290a = messageManager;
    }

    public static void p(d.b.c.c.g.b<Message<?>> bVar) {
        f42289h = bVar;
    }

    public void a() {
        this.f42295f = true;
    }

    public final void b(int i) {
        if (j(i)) {
            throw new IllegalStateException("MessageListener locked");
        }
    }

    public boolean c(M m, T t) {
        l.d();
        if (m == null) {
            return false;
        }
        int cmd = m.getCmd();
        if (t == null) {
            t = g(cmd);
        }
        if (t != null) {
            M l = l(m, t);
            if (this.f42294e != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.f42294e.b());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.f42294e.a());
                }
            }
            if (l != null) {
                f(l, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        d.b.c.c.g.b<Message<?>> bVar = f42289h;
        if (bVar != null) {
            bVar.a(m);
        }
        BdLog.e("task not register:" + cmd);
        return false;
    }

    public void d(N n) {
        l.d();
        if (n == null) {
            return;
        }
        n.setProcessTime(System.currentTimeMillis());
        int cmd = n.getCmd();
        Message<?> orginalMessage = n.getOrginalMessage();
        BdUniqueId tag = orginalMessage != null ? orginalMessage.getTag() : null;
        if (this.f42292c.indexOfKey(cmd) >= 0) {
            this.f42292c.put(cmd, n);
        }
        LinkedList<MessageListener<N>> linkedList = this.f42293d.get(cmd);
        if (linkedList == null) {
            return;
        }
        this.f42295f = false;
        k(cmd);
        try {
            try {
                Iterator<MessageListener<N>> it = linkedList.iterator();
                while (it.hasNext() && !this.f42295f) {
                    MessageListener<N> next = it.next();
                    if (next != null && (!next.isSelfListener() || next.getTag() == tag)) {
                        try {
                            next.onMessage(n);
                        } catch (Exception e2) {
                            BdLog.detailException(n.getClass().getName(), e2);
                        }
                    }
                }
            } catch (Exception e3) {
                BdLog.detailException(n.getClass().getName(), e3);
            }
        } finally {
            q(cmd);
        }
    }

    public synchronized T g(int i) {
        return this.f42291b.get(i);
    }

    public synchronized ArrayList<T> i() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.f42291b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.f42291b.valueAt(i));
        }
        return arrayList;
    }

    public final synchronized boolean j(int i) {
        return this.f42296g.get(i, 0) != 0;
    }

    public final synchronized void k(int i) {
        this.f42296g.put(i, this.f42296g.get(i, 0) + 1);
    }

    public abstract M l(M m, T t);

    public void m(int i, MessageListener<N> messageListener) {
        l.d();
        if (messageListener == null) {
            return;
        }
        if ((i == 0 && messageListener.getCmd() == 0) || (i != 0 && messageListener.getCmd() != 0)) {
            throw new InvalidParameterException("registerListener cmd error");
        }
        if (i == 0) {
            i = messageListener.getCmd();
        }
        FrameHelper.g(i);
        b(i);
        LinkedList<MessageListener<N>> linkedList = this.f42293d.get(i);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f42293d.put(i, linkedList);
        }
        FrameHelper.f(linkedList, messageListener);
        N n = this.f42292c.get(i);
        if (n != null) {
            messageListener.onMessage(n);
        }
    }

    public void n(int i) {
        if (this.f42292c.indexOfKey(i) < 0) {
            this.f42292c.put(i, null);
        }
    }

    public synchronized void o(T t) {
        if (t == null) {
            return;
        }
        int cmd = t.getCmd();
        FrameHelper.g(cmd);
        this.f42291b.put(cmd, t);
    }

    public final synchronized void q(int i) {
        int i2 = this.f42296g.get(i, 0);
        if (i2 <= 1) {
            this.f42296g.delete(i);
        } else {
            this.f42296g.put(i, i2 - 1);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        int size = this.f42293d.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f42293d.keyAt(i);
            Iterator<MessageListener<N>> it = this.f42293d.valueAt(i).iterator();
            while (it.hasNext()) {
                MessageListener<N> next = it.next();
                if (next != null && next.getTag() == bdUniqueId) {
                    b(keyAt);
                    it.remove();
                }
            }
        }
    }

    public void s(MessageListener<?> messageListener) {
        l.d();
        if (messageListener == null) {
            return;
        }
        int cmd = messageListener.getCmd();
        if (cmd == 0) {
            int size = this.f42293d.size();
            for (int i = 0; i < size; i++) {
                LinkedList<MessageListener<N>> valueAt = this.f42293d.valueAt(i);
                int keyAt = this.f42293d.keyAt(i);
                if (valueAt.contains(messageListener)) {
                    b(keyAt);
                    valueAt.remove(messageListener);
                }
            }
            return;
        }
        b(cmd);
        LinkedList<MessageListener<N>> linkedList = this.f42293d.get(cmd);
        if (linkedList != null) {
            linkedList.remove(messageListener);
        }
    }

    public void t(int i) {
        this.f42292c.remove(i);
    }

    public synchronized void u(int i) {
        this.f42291b.remove(i);
    }
}
