package f.a.x.i;
/* loaded from: classes7.dex */
public final class c {
    public static void a() {
        if (f.a.a0.a.d()) {
            if ((Thread.currentThread() instanceof f.a.x.g.b) || f.a.a0.a.e()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
