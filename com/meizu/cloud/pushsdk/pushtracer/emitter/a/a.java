package com.meizu.cloud.pushsdk.pushtracer.emitter.a;

import com.meizu.cloud.pushsdk.networking.b.i;
import com.meizu.cloud.pushsdk.pushtracer.emitter.b;
import com.meizu.cloud.pushsdk.pushtracer.emitter.c;
import com.meizu.cloud.pushsdk.pushtracer.emitter.e;
import com.meizu.cloud.pushsdk.pushtracer.utils.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public class a extends com.meizu.cloud.pushsdk.pushtracer.emitter.b {
    private final String t;
    private com.meizu.cloud.pushsdk.pushtracer.c.a u;
    private int v;

    public a(b.a aVar) {
        super(aVar);
        this.t = a.class.getSimpleName();
        this.u = new com.meizu.cloud.pushsdk.pushtracer.c.a(this.d, this.o);
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.emitter.b
    public void a(com.meizu.cloud.pushsdk.pushtracer.a.a aVar) {
        this.u.a(aVar);
        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "isRunning " + this.s, new Object[0]);
        if (this.s.compareAndSet(false, true)) {
            c();
        }
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.emitter.b
    public void a() {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.pushtracer.emitter.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.s.compareAndSet(false, true)) {
                    a.this.c();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int size;
        int i;
        if (d.a(this.d)) {
            if (this.u.b() > 0) {
                this.v = 0;
                LinkedList<e> a = a(a(this.u.c()));
                com.meizu.cloud.pushsdk.pushtracer.utils.b.c(this.t, "Processing emitter results.", new Object[0]);
                LinkedList<Long> linkedList = new LinkedList<>();
                Iterator<e> it = a.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    e next = it.next();
                    if (next.a()) {
                        Iterator<Long> it2 = next.b().iterator();
                        while (it2.hasNext()) {
                            linkedList.add(it2.next());
                        }
                        i = i3 + next.b().size();
                        size = i2;
                    } else {
                        size = next.b().size() + i2;
                        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Request sending failed but we will retry later.", new Object[0]);
                        i = i3;
                    }
                    i2 = size;
                    i3 = i;
                }
                b(linkedList);
                com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "Success Count: %s", Integer.valueOf(i3));
                com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "Failure Count: %s", Integer.valueOf(i2));
                if (this.f != null) {
                    if (i2 != 0) {
                        this.f.a(i3, i2);
                    } else {
                        this.f.a(i3);
                    }
                }
                if (i2 > 0 && i3 == 0) {
                    if (d.a(this.d)) {
                        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Ensure collector path is valid: %s", b());
                    }
                    com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Emitter loop stopping: failures.", new Object[0]);
                    this.s.compareAndSet(true, false);
                    return;
                }
                c();
                return;
            } else if (this.v >= this.n) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Emitter loop stopping: empty limit reached.", new Object[0]);
                this.s.compareAndSet(true, false);
                return;
            } else {
                this.v++;
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Emitter database empty: " + this.v, new Object[0]);
                try {
                    this.r.sleep(this.m);
                } catch (InterruptedException e) {
                    com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Emitter thread sleep interrupted: " + e.toString(), new Object[0]);
                }
                c();
                return;
            }
        }
        com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Emitter loop stopping: emitter offline.", new Object[0]);
        this.s.compareAndSet(true, false);
    }

    private LinkedList<e> a(LinkedList<c> linkedList) {
        LinkedList<e> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<c> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(b(it.next().a())));
        }
        com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "Request Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            int i2 = -1;
            try {
                i2 = ((Integer) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).intValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Request Future was interrupted: %s", e.getMessage());
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Request Future failed: %s", e2.getMessage());
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Request Future had a timeout: %s", e3.getMessage());
            }
            if (linkedList.get(i).c()) {
                linkedList2.add(new e(true, linkedList.get(i).b()));
            } else {
                linkedList2.add(new e(a(i2), linkedList.get(i).b()));
            }
        }
        return linkedList2;
    }

    private LinkedList<Boolean> b(LinkedList<Long> linkedList) {
        boolean z;
        LinkedList<Boolean> linkedList2 = new LinkedList<>();
        LinkedList linkedList3 = new LinkedList();
        Iterator<Long> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(b.a(a(it.next())));
        }
        com.meizu.cloud.pushsdk.pushtracer.utils.b.b(this.t, "Removal Futures: %s", Integer.valueOf(linkedList3.size()));
        for (int i = 0; i < linkedList3.size(); i++) {
            try {
                z = ((Boolean) ((Future) linkedList3.get(i)).get(5L, TimeUnit.SECONDS)).booleanValue();
            } catch (InterruptedException e) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Removal Future was interrupted: %s", e.getMessage());
                z = false;
            } catch (ExecutionException e2) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Removal Future failed: %s", e2.getMessage());
                z = false;
            } catch (TimeoutException e3) {
                com.meizu.cloud.pushsdk.pushtracer.utils.b.a(this.t, "Removal Future had a timeout: %s", e3.getMessage());
                z = false;
            }
            linkedList2.add(Boolean.valueOf(z));
        }
        return linkedList2;
    }

    private Callable<Integer> b(final i iVar) {
        return new Callable<Integer>() { // from class: com.meizu.cloud.pushsdk.pushtracer.emitter.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() throws Exception {
                return Integer.valueOf(a.this.a(iVar));
            }
        };
    }

    private Callable<Boolean> a(final Long l) {
        return new Callable<Boolean>() { // from class: com.meizu.cloud.pushsdk.pushtracer.emitter.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.u.a(l.longValue()));
            }
        };
    }
}
