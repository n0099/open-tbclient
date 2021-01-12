package com.qq.e.comm.plugin.w.a;

import java.util.Stack;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Stack<a>> f12626a = new ThreadLocal<>();

    /* loaded from: classes3.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f12627a;

        public a(int i) {
            this.f12627a = i;
        }

        public String toString() {
            return "ErrInfo [code=" + this.f12627a + "]";
        }
    }

    public static Stack<a> a() {
        Stack<a> stack;
        synchronized (b.class) {
            try {
                stack = f12626a.get();
                f12626a.set(null);
            } catch (Throwable th) {
                throw th;
            }
        }
        return stack;
    }

    public static void a(a aVar) {
        synchronized (b.class) {
            try {
                Stack<a> stack = f12626a.get();
                if (stack == null) {
                    stack = new Stack<>();
                    f12626a.set(stack);
                }
                stack.push(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
