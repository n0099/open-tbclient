package d.b.h0.l.l.h.e;

import android.util.Log;
import d.b.h0.l.l.h.f.f;
/* loaded from: classes3.dex */
public class c extends a<f> implements d.b.h0.l.l.h.f.b {

    /* renamed from: b  reason: collision with root package name */
    public volatile f f49668b;

    @Override // d.b.h0.l.l.h.f.b
    public <T> void a(f<T> fVar) {
        this.f49668b = fVar;
    }

    @Override // d.b.h0.l.l.h.f.b
    public <T> void b(f<T> fVar) {
        if (this.f49668b == fVar) {
            this.f49668b = null;
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "notifyTaskEnd mCurrentTask == null:" + fVar);
            }
        }
        k(fVar);
    }

    public synchronized f g() {
        f fVar;
        fVar = (f) super.c();
        if (d.b.h0.l.f.f49610a) {
            Log.d("PMSPriorityQueue", "deQueue first task:" + fVar);
        }
        return fVar;
    }

    public synchronized void h(f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f49668b != null && this.f49668b.d(fVar)) {
            fVar.e().n(fVar.f());
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "enQueue: 要入队的任务和当前正在运行的任务相同->" + fVar);
            }
            return;
        }
        f e2 = e(fVar);
        if (e2 != null) {
            fVar.e().n(fVar.f());
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "enQueue: 队列中已经有相同的任务在排队等待处理->" + fVar);
            }
            if (fVar.g() <= e2.g()) {
                return;
            }
        }
        int g2 = fVar.g();
        if (d.b.h0.l.f.f49610a) {
            Log.d("PMSPriorityQueue", "[enQueue] priorityOption:" + g2);
        }
        if (g2 == 200) {
            if (e2 != null) {
                this.f49657a.remove(e2);
                this.f49657a.add(0, e2);
                if (d.b.h0.l.f.f49610a) {
                    Log.d("PMSPriorityQueue", "enQueue: 有更高优先级的重复任务入队，任务提队头处理");
                }
            } else {
                this.f49657a.add(0, fVar);
            }
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "[enQueue] a new task added to queue head. size:" + this.f49657a.size());
                Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
            }
        } else if (g2 == 300) {
            j(fVar);
            if (e2 != null) {
                this.f49657a.remove(e2);
                this.f49657a.add(0, e2);
                if (d.b.h0.l.f.f49610a) {
                    Log.d("PMSPriorityQueue", "enQueue-stop running: 有更高优先级的重复任务入队，任务提队头处理");
                }
            } else {
                this.f49657a.add(0, fVar);
            }
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "[enQueue] a new task added to queue head. size:" + this.f49657a.size());
                Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
            }
        } else if (e2 == null) {
            this.f49657a.add(fVar);
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "[enQueue] append new task to queue tail. size:" + this.f49657a.size());
                Log.d("PMSPriorityQueue", "[enQueue] task info:" + fVar);
            }
        }
        notifyAll();
    }

    public synchronized f i() {
        f fVar;
        fVar = (f) super.d();
        if (d.b.h0.l.f.f49610a) {
            Log.d("PMSPriorityQueue", "get first task:" + fVar);
        }
        return fVar;
    }

    public final void j(f fVar) {
        f fVar2;
        if (fVar.g() == 300 && (fVar2 = this.f49668b) != null) {
            if (fVar2.g() == 300) {
                if (d.b.h0.l.f.f49610a) {
                    Log.d("PMSPriorityQueue", "Hi-priority task is working, can't stop:" + fVar2);
                    return;
                }
                return;
            }
            fVar2.n();
            for (int i = 0; i < 500 && this.f49668b != null; i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void k(f fVar) {
        if (fVar.j()) {
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "processPendingTask:" + fVar);
            }
            fVar.q(true);
            this.f49657a.add(0, fVar);
            if (d.b.h0.l.f.f49610a) {
                Log.d("PMSPriorityQueue", "PendingTask added-to-Queue-head:" + fVar);
            }
        }
    }
}
