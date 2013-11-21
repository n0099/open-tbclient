package org.msgpack.util.android;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2966a;

    static {
        try {
            f2966a = System.getProperty("java.vm.name").equals("Dalvik");
        } catch (Throwable th) {
            f2966a = false;
            throw th;
        }
    }

    public static boolean a() {
        return f2966a;
    }
}
