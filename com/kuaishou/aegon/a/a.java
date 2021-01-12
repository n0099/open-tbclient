package com.kuaishou.aegon.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1062a<T> {
        T get();
    }

    public static <T> T a(InterfaceC1062a<T> interfaceC1062a) {
        try {
            return interfaceC1062a.get();
        } catch (UnsatisfiedLinkError e) {
            try {
                return interfaceC1062a.get();
            } catch (UnsatisfiedLinkError e2) {
                return interfaceC1062a.get();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError e) {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError e2) {
                runnable.run();
            }
        }
    }

    public static void b(Runnable runnable) {
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError e) {
        }
    }
}
