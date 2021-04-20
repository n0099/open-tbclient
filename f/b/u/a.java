package f.b.u;
/* loaded from: classes7.dex */
public final class a {
    public static void a(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }
}
