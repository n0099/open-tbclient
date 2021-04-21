package com.kuaishou.aegon.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kuaishou.aegon.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0370a<T> {
        T get();
    }

    public static <T> T a(InterfaceC0370a<T> interfaceC0370a) {
        try {
            try {
                return interfaceC0370a.get();
            } catch (UnsatisfiedLinkError unused) {
                return interfaceC0370a.get();
            }
        } catch (UnsatisfiedLinkError unused2) {
            return interfaceC0370a.get();
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
