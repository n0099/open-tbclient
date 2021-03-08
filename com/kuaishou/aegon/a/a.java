package com.kuaishou.aegon.a;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1085a<T> {
        T get();
    }

    public static <T> T a(InterfaceC1085a<T> interfaceC1085a) {
        try {
            return interfaceC1085a.get();
        } catch (UnsatisfiedLinkError e) {
            try {
                return interfaceC1085a.get();
            } catch (UnsatisfiedLinkError e2) {
                return interfaceC1085a.get();
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
