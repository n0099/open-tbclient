package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes8.dex */
public class bb {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes8.dex */
    public static class a {
        private static final bb a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f126a;

        /* renamed from: a  reason: collision with other field name */
        public Object f127a;

        /* renamed from: a  reason: collision with other field name */
        public String f128a;

        a(int i, Object obj) {
            this.f126a = i;
            this.f127a = obj;
        }
    }

    public static bb a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m153a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m154a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m155a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m153a();
    }
}
