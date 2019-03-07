package com.xiaomi.channel.commonutils.stats;

import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a {
    private LinkedList<C0363a> a = new LinkedList<>();

    /* renamed from: com.xiaomi.channel.commonutils.stats.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0363a {
        private static final a d = new a();
        public int a;
        public String b;
        public Object c;

        C0363a(int i, Object obj) {
            this.a = i;
            this.c = obj;
        }
    }

    public static a a() {
        return C0363a.d;
    }

    private void d() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    public synchronized void a(Object obj) {
        this.a.add(new C0363a(0, obj));
        d();
    }

    public synchronized int b() {
        return this.a.size();
    }

    public synchronized LinkedList<C0363a> c() {
        LinkedList<C0363a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
