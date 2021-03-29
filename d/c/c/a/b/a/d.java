package d.c.c.a.b.a;
/* loaded from: classes5.dex */
public abstract class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final String f65217e;

    public d(String str, Object... objArr) {
        this.f65217e = e.j(str, objArr);
    }

    public abstract void i();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("tt_pangle_thread_" + this.f65217e);
        try {
            i();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
