package org.msgpack.util.android;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3147a;

    static {
        try {
            f3147a = System.getProperty("java.vm.name").equals("Dalvik");
        } catch (Throwable th) {
            f3147a = false;
            throw th;
        }
    }

    public static boolean a() {
        return f3147a;
    }
}
