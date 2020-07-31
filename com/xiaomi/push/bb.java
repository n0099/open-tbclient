package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes9.dex */
public class bb {
    private LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes9.dex */
    public static class a {
        private static final bb a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f123a;

        /* renamed from: a  reason: collision with other field name */
        public Object f124a;

        /* renamed from: a  reason: collision with other field name */
        public String f125a;

        a(int i, Object obj) {
            this.f123a = i;
            this.f124a = obj;
        }
    }

    public static bb a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m154a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m155a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m156a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m154a();
    }
}
