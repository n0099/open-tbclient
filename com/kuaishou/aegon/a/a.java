package com.kuaishou.aegon.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0353a<T> {
        T get();
    }

    public static <T> T a(InterfaceC0353a<T> interfaceC0353a) {
        try {
            try {
                return interfaceC0353a.get();
            } catch (UnsatisfiedLinkError unused) {
                return interfaceC0353a.get();
            }
        } catch (UnsatisfiedLinkError unused2) {
            return interfaceC0353a.get();
        }
    }

    public static void a(Runnable runnable) {
        try {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError unused) {
                runnable.run();
            }
        } catch (UnsatisfiedLinkError unused2) {
            runnable.run();
        }
    }

    public static void b(Runnable runnable) {
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
