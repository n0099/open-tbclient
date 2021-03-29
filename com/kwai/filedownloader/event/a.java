package com.kwai.filedownloader.event;

import com.kwai.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f37000a = com.kwai.filedownloader.f.b.a(10, "EventPool");

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, LinkedList<c>> f37001b = new HashMap<>();

    private void a(LinkedList<c> linkedList, b bVar) {
        Object[] array;
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((c) obj).a(bVar)) {
                break;
            }
        }
        Runnable runnable = bVar.f37004a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean a(b bVar) {
        if (d.f37012a) {
            d.e(this, "publish %s", bVar.b());
        }
        if (bVar != null) {
            String b2 = bVar.b();
            LinkedList<c> linkedList = this.f37001b.get(b2);
            if (linkedList == null) {
                synchronized (b2.intern()) {
                    linkedList = this.f37001b.get(b2);
                    if (linkedList == null) {
                        if (d.f37012a) {
                            d.c(this, "No listener for this event %s", b2);
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

    public boolean a(String str, c cVar) {
        boolean add;
        if (d.f37012a) {
            d.e(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList<c> linkedList = this.f37001b.get(str);
            if (linkedList == null) {
                synchronized (str.intern()) {
                    linkedList = this.f37001b.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.f37001b;
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

    public void b(final b bVar) {
        if (d.f37012a) {
            d.e(this, "asyncPublishInNewThread %s", bVar.b());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        this.f37000a.execute(new Runnable() { // from class: com.kwai.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.a(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }
}
