package d.a.i0.a.v1.c.f;

import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.i0.a.v1.c.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements a.c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Deque<Message>> f45160a = new HashMap();

    @Override // d.a.i0.a.v1.c.a.c
    public void a() {
        for (String str : this.f45160a.keySet()) {
            c(str);
        }
    }

    @Override // d.a.i0.a.v1.c.a.c
    public void b(@NonNull d.a.i0.a.v1.c.c cVar) {
        Message h2 = cVar.h();
        if (cVar.m()) {
            h(h2);
        }
        Set<SwanAppProcessInfo> l = cVar.l();
        Set<String> k = cVar.k();
        if (cVar.n()) {
            Iterator<c> it = e.k().q().iterator();
            while (it.hasNext()) {
                c next = it.next();
                boolean g2 = g(next, k);
                if (l.contains(next.f45155f) || g2) {
                    next.U(h2);
                    if (g2) {
                        k.remove(next.getAppId());
                    }
                }
            }
            f(k, h2);
            return;
        }
        Iterator<c> it2 = e.k().q().iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (next2 != null && next2.H() && (l.contains(next2.f45155f) || g(next2, k))) {
                next2.U(h2);
            }
        }
    }

    @Override // d.a.i0.a.v1.c.a.c
    public void c(String str) {
        Deque<Message> deque = this.f45160a.get(str);
        d.a.i0.a.v1.c.a.f("flushMsg:: appid=" + str + " msgQueue=" + deque);
        if (deque == null || deque.isEmpty()) {
            return;
        }
        List<c> j = e.k().j(str);
        d.a.i0.a.v1.c.a.f("flushMsg:: msgQueue.size=" + deque.size() + " clients.size=" + j.size());
        if (j.isEmpty()) {
            return;
        }
        for (c cVar : j) {
            cVar.W(deque);
        }
        deque.clear();
    }

    @Override // d.a.i0.a.v1.c.a.c
    public void d(String str) {
        this.f45160a.remove(str);
    }

    public final void e(String str, @NonNull Message message) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Deque<Message> deque = this.f45160a.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.f45160a.put(str, deque);
        }
        deque.offer(message);
    }

    public final void f(Set<String> set, @NonNull Message message) {
        for (String str : set) {
            e(str, message);
        }
    }

    public boolean g(@NonNull c cVar, @NonNull Set<String> set) {
        return cVar.C() && set.contains(cVar.getAppId());
    }

    public final void h(Message message) {
        try {
            e.k().f45167e.send(message);
        } catch (RemoteException e2) {
            d.a.i0.a.v1.c.a.f(Log.getStackTraceString(e2));
        }
    }
}
