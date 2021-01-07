package com.qq.e.comm.plugin.w.a;

import java.util.Stack;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Stack<a>> f12926a = new ThreadLocal<>();

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f12927a;

        public a(int i) {
            this.f12927a = i;
        }

        public String toString() {
            return "ErrInfo [code=" + this.f12927a + "]";
        }
    }

    public static Stack<a> a() {
        Stack<a> stack;
        synchronized (b.class) {
            try {
                stack = f12926a.get();
                f12926a.set(null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return stack;
    }

    public static void a(a aVar) {
        synchronized (b.class) {
            try {
                Stack<a> stack = f12926a.get();
                if (stack == null) {
                    stack = new Stack<>();
                    f12926a.set(stack);
                }
                stack.push(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
