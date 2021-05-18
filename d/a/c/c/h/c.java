package d.a.c.c.h;

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
import d.a.c.c.f.f;
import d.a.c.e.p.l;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public abstract class c<M extends Message<?>, T extends MessageTask, R extends f<?, ?>, N extends ResponsedMessage<?>> implements d.a.c.c.b<M, T> {

    /* renamed from: h  reason: collision with root package name */
    public static d.a.c.c.g.b<Message<?>> f38725h;

    /* renamed from: a  reason: collision with root package name */
    public MessageManager f38726a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<T> f38727b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    public final SparseArray<N> f38728c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<LinkedList<MessageListener<N>>> f38729d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.j.d f38730e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38731f = false;

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f38732g = new SparseIntArray();

    public c(MessageManager messageManager) {
        this.f38726a = null;
        this.f38726a = messageManager;
    }

    public static void p(d.a.c.c.g.b<Message<?>> bVar) {
        f38725h = bVar;
    }

    public void a() {
        this.f38731f = true;
    }

    public final void b(int i2) {
        if (j(i2)) {
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
            if (this.f38730e != null) {
                if (t.getTimeOut() == null) {
                    t.setTimeOut(this.f38730e.b());
                }
                if (t.getRetry() == 0) {
                    t.setRetry(this.f38730e.a());
                }
            }
            if (l != null) {
                f(l, t);
                return true;
            }
            BdLog.d("message is trapped:" + cmd);
            return false;
        }
        d.a.c.c.g.b<Message<?>> bVar = f38725h;
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
        if (this.f38728c.indexOfKey(cmd) >= 0) {
            this.f38728c.put(cmd, n);
        }
        LinkedList<MessageListener<N>> linkedList = this.f38729d.get(cmd);
        if (linkedList == null) {
            return;
        }
        this.f38731f = false;
        k(cmd);
        try {
            try {
                Iterator<MessageListener<N>> it = linkedList.iterator();
                while (it.hasNext() && !this.f38731f) {
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

    public synchronized T g(int i2) {
        return this.f38727b.get(i2);
    }

    public synchronized ArrayList<T> i() {
        ArrayList<T> arrayList;
        arrayList = new ArrayList<>();
        int size = this.f38727b.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(this.f38727b.valueAt(i2));
        }
        return arrayList;
    }

    public final synchronized boolean j(int i2) {
        return this.f38732g.get(i2, 0) != 0;
    }

    public final synchronized void k(int i2) {
        this.f38732g.put(i2, this.f38732g.get(i2, 0) + 1);
    }

    public abstract M l(M m, T t);

    public void m(int i2, MessageListener<N> messageListener) {
        l.d();
        if (messageListener == null) {
            return;
        }
        if ((i2 == 0 && messageListener.getCmd() == 0) || (i2 != 0 && messageListener.getCmd() != 0)) {
            throw new InvalidParameterException("registerListener cmd error");
        }
        if (i2 == 0) {
            i2 = messageListener.getCmd();
        }
        FrameHelper.g(i2);
        b(i2);
        LinkedList<MessageListener<N>> linkedList = this.f38729d.get(i2);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f38729d.put(i2, linkedList);
        }
        FrameHelper.f(linkedList, messageListener);
        N n = this.f38728c.get(i2);
        if (n != null) {
            messageListener.onMessage(n);
        }
    }

    public void n(int i2) {
        if (this.f38728c.indexOfKey(i2) < 0) {
            this.f38728c.put(i2, null);
        }
    }

    public synchronized void o(T t) {
        if (t == null) {
            return;
        }
        int cmd = t.getCmd();
        FrameHelper.g(cmd);
        this.f38727b.put(cmd, t);
    }

    public final synchronized void q(int i2) {
        int i3 = this.f38732g.get(i2, 0);
        if (i3 <= 1) {
            this.f38732g.delete(i2);
        } else {
            this.f38732g.put(i2, i3 - 1);
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        l.d();
        if (bdUniqueId == null) {
            return;
        }
        int size = this.f38729d.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.f38729d.keyAt(i2);
            Iterator<MessageListener<N>> it = this.f38729d.valueAt(i2).iterator();
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
            int size = this.f38729d.size();
            for (int i2 = 0; i2 < size; i2++) {
                LinkedList<MessageListener<N>> valueAt = this.f38729d.valueAt(i2);
                int keyAt = this.f38729d.keyAt(i2);
                if (valueAt.contains(messageListener)) {
                    b(keyAt);
                    valueAt.remove(messageListener);
                }
            }
            return;
        }
        b(cmd);
        LinkedList<MessageListener<N>> linkedList = this.f38729d.get(cmd);
        if (linkedList != null) {
            linkedList.remove(messageListener);
        }
    }

    public void t(int i2) {
        this.f38728c.remove(i2);
    }

    public synchronized void u(int i2) {
        this.f38727b.remove(i2);
    }
}
