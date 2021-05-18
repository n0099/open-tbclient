package d.b.c.a.b.a;
/* loaded from: classes6.dex */
public abstract class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final String f65210e;

    public d(String str, Object... objArr) {
        this.f65210e = e.j(str, objArr);
    }

    public abstract void i();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("tt_pangle_thread_" + this.f65210e);
        try {
            i();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
