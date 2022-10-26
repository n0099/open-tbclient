package com.meizu.cloud.pushsdk.c.b.a;

import com.meizu.cloud.pushsdk.b.c.i;
import com.meizu.cloud.pushsdk.c.b.c;
import com.meizu.cloud.pushsdk.c.b.e;
import com.meizu.cloud.pushsdk.c.b.f;
import com.meizu.cloud.pushsdk.c.b.g;
import com.meizu.cloud.pushsdk.c.d.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes8.dex */
public class a extends c {
    public final String u;
    public d v;
    public int w;

    public a(c.a aVar) {
        super(aVar);
        this.u = a.class.getSimpleName();
        com.meizu.cloud.pushsdk.c.d.a aVar2 = new com.meizu.cloud.pushsdk.c.d.a(this.d, this.o);
        this.v = aVar2;
        if (aVar2.a()) {
            return;
        }
        this.v = new com.meizu.cloud.pushsdk.c.d.c(this.o);
        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "init memory store", new Object[0]);
    }

    private LinkedList a(LinkedList linkedList) {
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(b(((e) it.next()).a())));
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
            if (((e) linkedList.get(i)).c()) {
                linkedList2.add(new g(true, ((e) linkedList.get(i)).b()));
            } else {
                linkedList2.add(new g(a(i2), ((e) linkedList.get(i)).b()));
            }
        }
        return linkedList2;
    }

    private Callable a(final Long l) {
        return new Callable() { // from class: com.meizu.cloud.pushsdk.c.b.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.v.a(l.longValue()));
            }
        };
    }

    private LinkedList b(LinkedList linkedList) {
        boolean z;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(a((Long) it.next())));
        }
        com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future failed: %s", e2.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
                linkedList2.add(Boolean.valueOf(z));
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable b(final i iVar) {
        return new Callable() { // from class: com.meizu.cloud.pushsdk.c.b.a.a.2
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
        if (com.meizu.cloud.pushsdk.c.f.e.a(this.d)) {
            if (this.v.c() > 0) {
                this.w = 0;
                LinkedList a = a(a(this.v.d()));
                com.meizu.cloud.pushsdk.c.f.c.c(this.u, "Processing emitter results.", new Object[0]);
                LinkedList linkedList = new LinkedList();
                Iterator it = a.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (gVar.a()) {
                        Iterator it2 = gVar.b().iterator();
                        while (it2.hasNext()) {
                            linkedList.add((Long) it2.next());
                        }
                        i += gVar.b().size();
                    } else {
                        i2 += gVar.b().size();
                        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Request sending failed but we will retry later.", new Object[0]);
                    }
                }
                b(linkedList);
                com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Success Count: %s", Integer.valueOf(i));
                com.meizu.cloud.pushsdk.c.f.c.b(this.u, "Failure Count: %s", Integer.valueOf(i2));
                f fVar = this.f;
                if (fVar != null) {
                    if (i2 != 0) {
                        fVar.a(i, i2);
                    } else {
                        fVar.a(i);
                    }
                }
                if (i2 > 0 && i == 0) {
                    if (com.meizu.cloud.pushsdk.c.f.e.a(this.d)) {
                        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Ensure collector path is valid: %s", b());
                    }
                    com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: failures.", new Object[0]);
                }
            } else {
                int i3 = this.w;
                if (i3 >= this.n) {
                    com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: empty limit reached.", new Object[0]);
                    this.t.compareAndSet(true, false);
                    f fVar2 = this.f;
                    if (fVar2 != null) {
                        fVar2.a(true);
                        return;
                    }
                    return;
                }
                this.w = i3 + 1;
                String str = this.u;
                com.meizu.cloud.pushsdk.c.f.c.a(str, "Emitter database empty: " + this.w, new Object[0]);
                try {
                    this.r.sleep(this.m);
                } catch (InterruptedException e) {
                    String str2 = this.u;
                    com.meizu.cloud.pushsdk.c.f.c.a(str2, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
                }
            }
            c();
            return;
        }
        com.meizu.cloud.pushsdk.c.f.c.a(this.u, "Emitter loop stopping: emitter offline.", new Object[0]);
        this.t.compareAndSet(true, false);
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
        String str = this.u;
        com.meizu.cloud.pushsdk.c.f.c.a(str, "isRunning " + this.t + " attemptEmit " + z, new Object[0]);
        if (!z) {
            try {
                this.r.sleep(1L);
            } catch (InterruptedException e) {
                String str2 = this.u;
                com.meizu.cloud.pushsdk.c.f.c.a(str2, "Emitter add thread sleep interrupted: " + e.toString(), new Object[0]);
            }
        }
        if (this.t.compareAndSet(false, true)) {
            c();
        }
    }
}
