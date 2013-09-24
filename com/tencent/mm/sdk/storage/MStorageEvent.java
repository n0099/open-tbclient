package com.tencent.mm.sdk.storage;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public abstract class MStorageEvent<T, E> {
    private int bP = 0;
    private final Hashtable<T, Object> bQ = new Hashtable<>();
    private final CopyOnWriteArraySet<E> bR = new CopyOnWriteArraySet<>();

    private void e() {
        HashSet hashSet = new HashSet(this.bQ.keySet());
        if (hashSet.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (final E e : hashSet) {
            Object obj = this.bQ.get(e);
            Iterator<E> it = this.bR.iterator();
            while (it.hasNext()) {
                final E next = it.next();
                if (next != null) {
                    if (obj == null) {
                        Log.f("MicroMsg.SDK.MStorageEvent", "handle listener fatal unknown bug");
                    } else if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        Handler handler = (Handler) hashMap.get(looper);
                        if (handler == null) {
                            handler = new Handler(looper);
                            hashMap.put(looper, handler);
                        }
                        handler.post(new Runnable() { // from class: com.tencent.mm.sdk.storage.MStorageEvent.1
                            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.tencent.mm.sdk.storage.MStorageEvent */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public void run() {
                                MStorageEvent.this.processEvent(e, next);
                            }
                        });
                    } else {
                        processEvent(e, next);
                    }
                }
            }
        }
        this.bR.clear();
    }

    public void add(T t, Looper looper) {
        if (this.bQ.containsKey(t)) {
            return;
        }
        if (looper != null) {
            this.bQ.put(t, looper);
        } else {
            this.bQ.put(t, new Object());
        }
    }

    public void doNotify() {
        if (isLocked()) {
            return;
        }
        e();
    }

    public boolean event(E e) {
        return this.bR.add(e);
    }

    public boolean isLocked() {
        return this.bP > 0;
    }

    public void lock() {
        this.bP++;
    }

    protected abstract void processEvent(T t, E e);

    public void remove(T t) {
        this.bQ.remove(t);
    }

    public void removeAll() {
        this.bQ.clear();
    }

    public void unlock() {
        this.bP--;
        if (this.bP <= 0) {
            this.bP = 0;
            e();
        }
    }
}
