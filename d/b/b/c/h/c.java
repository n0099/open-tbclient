package d.b.b.c.h;

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
import d.b.b.c.f.f;
import d.b.b.e.p.l;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements d.b.b.c.b<M, T> {

    /* renamed from: h  reason: collision with root package name */
    public static d.b.b.c.g.b<Message<?>> f41552h;

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f41553a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<T> f41554b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<N> f41555c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<LinkedList<MessageListener<N>>> f41556d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.c.j.d f41557e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41558f = false;

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f41559g = new SparseIntArray();

    public c(MessageManager messageManager) {
        this.f41553a = null;
        this.f41553a = messageManager;
    }

    public static void p(d.b.b.c.g.b<Message<?>> bVar) {
        f41552h = bVar;
    }

    public void a() {
        this.f41558f = true;
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
            if (this.f41557e != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.f41557e.b());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.f41557e.a());
                }
            }
            if (l != null) {
                f(l, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        d.b.b.c.g.b<Message<?>> bVar = f41552h;
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
        if (this.f41555c.indexOfKey(cmd) >= 0) {
            this.f41555c.put(cmd, n);
        }
        LinkedList<MessageListener<N>> linkedList = this.f41556d.get(cmd);
        if (linkedList == null) {
            return;
        }
        this.f41558f = false;
        k(cmd);
        try {
            try {
                Iterator<MessageListener<N>> it = linkedList.iterator();
                while (it.hasNext() && !this.f41558f) {
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
        return this.f41554b.get(i);
    }

    public synchronized ArrayList<T> i() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.f41554b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(this.f41554b.valueAt(i));
        }
        return arrayList;
    }

    public final synchronized boolean j(int i) {
        return this.f41559g.get(i, 0) != 0;
    }

    public final synchronized void k(int i) {
        this.f41559g.put(i, this.f41559g.get(i, 0) + 1);
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
        LinkedList<MessageListener<N>> linkedList = this.f41556d.get(i);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f41556d.put(i, linkedList);
        }
        FrameHelper.f(linkedList, messageListener);
        N n = this.f41555c.get(i);
        if (n != null) {
            messageListener.onMessage(n);
        }
    }

    public void n(int i) {
        if (this.f41555c.indexOfKey(i) < 0) {
            this.f41555c.put(i, null);
        }
    }

    public synchronized void o(T t) {
        if (t == null) {
            return;
        }
        int cmd = t.getCmd();
        FrameHelper.g(cmd);
        this.f41554b.put(cmd, t);
    }

    public final synchronized void q(int i) {
        int i2 = this.f41559g.get(i, 0);
        if (i2 <= 1) {
            this.f41559g.delete(i);
        } else {
            this.f41559g.put(i, i2 - 1);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        int size = this.f41556d.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.f41556d.keyAt(i);
            Iterator<MessageListener<N>> it = this.f41556d.valueAt(i).iterator();
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
            int size = this.f41556d.size();
            for (int i = 0; i < size; i++) {
                LinkedList<MessageListener<N>> valueAt = this.f41556d.valueAt(i);
                int keyAt = this.f41556d.keyAt(i);
                if (valueAt.contains(messageListener)) {
                    b(keyAt);
                    valueAt.remove(messageListener);
                }
            }
            return;
        }
        b(cmd);
        LinkedList<MessageListener<N>> linkedList = this.f41556d.get(cmd);
        if (linkedList != null) {
            linkedList.remove(messageListener);
        }
    }

    public void t(int i) {
        this.f41555c.remove(i);
    }

    public synchronized void u(int i) {
        this.f41554b.remove(i);
    }
}
