package com.kwai.filedownloader.event;

import com.kwai.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f7206a = com.kwai.filedownloader.f.b.a(10, "EventPool");
    private final HashMap<String, LinkedList<c>> b = new HashMap<>();

    private void a(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((c) obj).a(bVar)) {
                break;
            }
        }
        if (bVar.f7208a != null) {
            bVar.f7208a.run();
        }
    }

    public boolean a(b bVar) {
        if (d.f7212a) {
            d.e(this, "publish %s", bVar.b());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String b = bVar.b();
        LinkedList<c> linkedList = this.b.get(b);
        if (linkedList == null) {
            synchronized (b.intern()) {
                linkedList = this.b.get(b);
                if (linkedList == null) {
                    if (d.f7212a) {
                        d.c(this, "No listener for this event %s", b);
                    }
                    return false;
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public boolean a(String str, c cVar) {
        boolean add;
        if (d.f7212a) {
            d.e(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.b.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.b.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<c>> hashMap = this.b;
                    linkedList = new LinkedList<>();
                    hashMap.put(str, linkedList);
                }
            }
        }
        synchronized (str.intern()) {
            add = linkedList.add(cVar);
        }
        return add;
    }

    public void b(final b bVar) {
        if (d.f7212a) {
            d.e(this, "asyncPublishInNewThread %s", bVar.b());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        this.f7206a.execute(new Runnable() { // from class: com.kwai.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a(bVar);
                } catch (Exception e) {
                }
            }
        });
    }
}
