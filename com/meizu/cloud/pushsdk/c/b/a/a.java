package com.meizu.cloud.pushsdk.c.b.a;

import com.meizu.cloud.pushsdk.b.c.i;
import com.meizu.cloud.pushsdk.c.b.c;
import com.meizu.cloud.pushsdk.c.b.e;
import com.meizu.cloud.pushsdk.c.b.g;
import com.meizu.cloud.pushsdk.c.d.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class a extends c {
    private final String u;
    private d v;
    private int w;

    public a(c.a aVar) {
        super(aVar);
        this.u = a.class.getSimpleName();
        this.v = new com.meizu.cloud.pushsdk.c.d.a(this.d, this.o);
        if (this.v.a()) {
            return;
        }
        this.v = new com.meizu.cloud.pushsdk.c.d.c(this.o);
        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "init memory store", new Object[0]);
    }

    private LinkedList<g> a(LinkedList<e> linkedList) {
        LinkedList<g> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(b(it.next().a())));
        }
        com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            int i2 = -1;
            try {
                i2 = ((Integer) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request Future had a timeout: %s", e3.getMessage());
            }
            if (linkedList.get(i).c()) {
                linkedList2.add(new g(true, linkedList.get(i).b()));
            } else {
                linkedList2.add(new g(a(i2), linkedList.get(i).b()));
            }
        }
        return linkedList2;
    }

    private Callable<Boolean> a(final Long l) {
        return new Callable<Boolean>() { // from class: com.meizu.cloud.pushsdk.c.b.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.v.a(l.longValue()));
            }
        };
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(a(it.next())));
        }
        com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future failed: %s", e2.getMessage());
                z = false;
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable<Integer> b(final i iVar) {
        return new Callable<Integer>() { // from class: com.meizu.cloud.pushsdk.c.b.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() throws Exception {
                return Integer.valueOf(a.this.a(iVar));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int size;
        int i;
        if (!com.meizu.cloud.pushsdk.c.f.e.a(this.d)) {
            com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: emitter offline.", new Object[0]);
            this.t.compareAndSet(true, false);
        } else if (this.v.c() <= 0) {
            if (this.w >= this.n) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: empty limit reached.", new Object[0]);
                this.t.compareAndSet(true, false);
                if (this.f != null) {
                    this.f.a(true);
                    return;
                }
                return;
            }
            this.w++;
            com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter database empty: " + this.w, new Object[0]);
            try {
                this.r.sleep(this.m);
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
            }
            c();
        } else {
            this.w = 0;
            LinkedList<g> a2 = a(a(this.v.d()));
            com.meizu.cloud.pushsdk.c.f.c.c(this.u, "Processing emitter results.", new Object[0]);
            LinkedList<Long> linkedList = new LinkedList<>();
            Iterator<g> it = a2.iterator();
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                g next = it.next();
                if (next.a()) {
                    Iterator<Long> it2 = next.b().iterator();
                    while (it2.hasNext()) {
                        linkedList.add(it2.next());
                    }
                    i = i3 + next.b().size();
                    size = i2;
                } else {
                    size = next.b().size() + i2;
                    com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request sending failed but we will retry later.", new Object[0]);
                    i = i3;
                }
                i2 = size;
                i3 = i;
            }
            b(linkedList);
            com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Success Count: %s", Integer.valueOf(i3));
            com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Failure Count: %s", Integer.valueOf(i2));
            if (this.f != null) {
                if (i2 != 0) {
                    this.f.a(i3, i2);
                } else {
                    this.f.a(i3);
                }
            }
            if (i2 <= 0 || i3 != 0) {
                c();
                return;
            }
            if (com.meizu.cloud.pushsdk.c.f.e.a(this.d)) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Ensure collector path is valid: %s", b());
            }
            com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: failures.", new Object[0]);
            this.t.compareAndSet(true, false);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.b.c
    public void a() {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.c.b.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.t.compareAndSet(false, true)) {
                    a.this.c();
                }
            }
        });
    }

    @Override // com.meizu.cloud.pushsdk.c.b.c
    public void a(com.meizu.cloud.pushsdk.c.a.a aVar, boolean z) {
        this.v.a(aVar);
        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "isRunning " + this.t + " attemptEmit " + z, new Object[0]);
        if (!z) {
            try {
                this.r.sleep(1L);
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter add thread sleep interrupted: " + e.toString(), new Object[0]);
            }
        }
        if (this.t.compareAndSet(false, true)) {
            c();
        }
    }
}
