package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes12.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f4807a = new LinkedList<>();

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f4808a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f119a;

        /* renamed from: a  reason: collision with other field name */
        public Object f120a;

        /* renamed from: a  reason: collision with other field name */
        public String f121a;

        a(int i, Object obj) {
            this.f119a = i;
            this.f120a = obj;
        }
    }

    public static bb a() {
        return a.f4808a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m159a() {
        if (this.f4807a.size() > 100) {
            this.f4807a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m160a() {
        return this.f4807a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m161a() {
        LinkedList<a> linkedList;
        linkedList = this.f4807a;
        this.f4807a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f4807a.add(new a(0, obj));
        m159a();
    }
}
