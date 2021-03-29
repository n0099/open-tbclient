package d.b.g0.a.n1.c.f;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.b.g0.a.n1.c.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class d implements a.c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Deque<Message>> f45395a = new HashMap();

    @Override // d.b.g0.a.n1.c.a.c
    public void a() {
        for (String str : this.f45395a.keySet()) {
            c(str);
        }
    }

    @Override // d.b.g0.a.n1.c.a.c
    public void b(@NonNull d.b.g0.a.n1.c.c cVar) {
        Message h2 = cVar.h();
        if (cVar.m()) {
            h(h2);
        }
        Set<SwanAppProcessInfo> l = cVar.l();
        Set<String> k = cVar.k();
        if (cVar.n()) {
            Iterator<c> it = e.j().p().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean g2 = g(next, k);
                if (l.contains(next.f45391f) || g2) {
                    next.P(h2);
                    if (g2) {
                        k.remove(next.getAppId());
                    }
                }
            }
            f(k, h2);
            return;
        }
        Iterator<c> it2 = e.j().p().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.D() && (l.contains(next2.f45391f) || g(next2, k))) {
                next2.P(h2);
            }
        }
    }

    @Override // d.b.g0.a.n1.c.a.c
    public void c(String str) {
        Deque<Message> deque = this.f45395a.get(str);
        d.b.g0.a.n1.c.a.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque == null || deque.isEmpty()) {
            return;
        }
        List<c> i = e.j().i(str);
        d.b.g0.a.n1.c.a.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + i.size());
        if (i.isEmpty()) {
            return;
        }
        for (c cVar : i) {
            cVar.R(deque);
        }
        deque.clear();
    }

    @Override // d.b.g0.a.n1.c.a.c
    public void d(String str) {
        this.f45395a.remove(str);
    }

    public final void e(String str, @NonNull Message message) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Deque<Message> deque = this.f45395a.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.f45395a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            e(str, message);
        }
    }

    public boolean g(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.x() && set.contains(cVar.getAppId());
    }

    public final void h(Message message) {
        try {
            e.j().f45400c.send(message);
        } catch (RemoteException e2) {
            d.b.g0.a.n1.c.a.f(Log.getStackTraceString(e2));
        }
    }
}
