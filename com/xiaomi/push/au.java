package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public class au {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes5.dex */
    public static class a {
        private static final au a = new au();

        /* renamed from: a  reason: collision with other field name */
        public int f135a;

        /* renamed from: a  reason: collision with other field name */
        public Object f136a;

        /* renamed from: a  reason: collision with other field name */
        public String f137a;

        a(int i, Object obj) {
            this.f135a = i;
            this.f136a = obj;
        }
    }

    public static au a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m123a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m124a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m125a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m123a();
    }
}
