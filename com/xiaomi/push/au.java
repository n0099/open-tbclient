package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes8.dex */
public class au {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes8.dex */
    public static class a {
        private static final au a = new au();

        /* renamed from: a  reason: collision with other field name */
        public int f130a;

        /* renamed from: a  reason: collision with other field name */
        public Object f131a;

        /* renamed from: a  reason: collision with other field name */
        public String f132a;

        a(int i, Object obj) {
            this.f130a = i;
            this.f131a = obj;
        }
    }

    public static au a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m137a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m138a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m139a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m137a();
    }
}
