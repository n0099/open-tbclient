package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class a {
    public final Executor agM = com.kwad.framework.filedownloader.f.b.o(10, "EventPool");
    public final HashMap<String, LinkedList<c>> agN = new HashMap<>();

    public static void a(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.agS;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.ahW) {
            d.e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList<c> linkedList = this.agN.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.agN.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.agN;
                        LinkedList<c> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public final boolean b(b bVar) {
        if (d.ahW) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar != null) {
            String id = bVar.getId();
            LinkedList<c> linkedList = this.agN.get(id);
            if (linkedList == null) {
                synchronized (id.intern()) {
                    linkedList = this.agN.get(id);
                    if (linkedList == null) {
                        if (d.ahW) {
                            d.c(this, "No listener for this event %s", id);
                        }
                        return false;
                    }
                }
            }
            a(linkedList, bVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public final void c(final b bVar) {
        if (d.ahW) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.agM.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }
}
