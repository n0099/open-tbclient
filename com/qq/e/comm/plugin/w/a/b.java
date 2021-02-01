package com.qq.e.comm.plugin.w.a;

import java.util.Stack;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Stack<a>> f12628a = new ThreadLocal<>();

    /* loaded from: classes15.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f12629a;

        public a(int i) {
            this.f12629a = i;
        }

        public String toString() {
            return "ErrInfo [code=" + this.f12629a + "]";
        }
    }

    public static Stack<a> a() {
        Stack<a> stack;
        synchronized (b.class) {
            try {
                stack = f12628a.get();
                f12628a.set(null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return stack;
    }

    public static void a(a aVar) {
        synchronized (b.class) {
            try {
                Stack<a> stack = f12628a.get();
                if (stack == null) {
                    stack = new Stack<>();
                    f12628a.set(stack);
                }
                stack.push(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
