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
public abstract class MStorageEvent {
    private int bP = 0;
    private final Hashtable bQ = new Hashtable();
    private final CopyOnWriteArraySet bR = new CopyOnWriteArraySet();

    private void e() {
        HashSet hashSet = new HashSet(this.bQ.keySet());
        if (hashSet.size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (final Object obj : hashSet) {
            Object obj2 = this.bQ.get(obj);
            Iterator it = this.bR.iterator();
            while (it.hasNext()) {
                final Object next = it.next();
                if (next != null) {
                    if (obj2 == null) {
                        Log.f("MicroMsg.SDK.MStorageEvent", "handle listener fatal unknown bug");
                    } else if (obj2 instanceof Looper) {
                        Looper looper = (Looper) obj2;
                        Handler handler = (Handler) hashMap.get(looper);
                        if (handler == null) {
                            handler = new Handler(looper);
                            hashMap.put(looper, handler);
                        }
                        handler.post(new Runnable() { // from class: com.tencent.mm.sdk.storage.MStorageEvent.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MStorageEvent.this.processEvent(obj, next);
                            }
                        });
                    } else {
                        processEvent(obj, next);
                    }
                }
            }
        }
        this.bR.clear();
    }

    public void add(Object obj, Looper looper) {
        if (this.bQ.containsKey(obj)) {
            return;
        }
        if (looper != null) {
            this.bQ.put(obj, looper);
        } else {
            this.bQ.put(obj, new Object());
        }
    }

    public void doNotify() {
        if (isLocked()) {
            return;
        }
        e();
    }

    public boolean event(Object obj) {
        return this.bR.add(obj);
    }

    public boolean isLocked() {
        return this.bP > 0;
    }

    public void lock() {
        this.bP++;
    }

    protected abstract void processEvent(Object obj, Object obj2);

    public void remove(Object obj) {
        this.bQ.remove(obj);
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
