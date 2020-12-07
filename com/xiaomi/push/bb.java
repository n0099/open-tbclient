package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes18.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f4579a = new LinkedList<>();

    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f4580a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f122a;

        /* renamed from: a  reason: collision with other field name */
        public Object f123a;

        /* renamed from: a  reason: collision with other field name */
        public String f124a;

        a(int i, Object obj) {
            this.f122a = i;
            this.f123a = obj;
        }
    }

    public static bb a() {
        return a.f4580a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m152a() {
        if (this.f4579a.size() > 100) {
            this.f4579a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m153a() {
        return this.f4579a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m154a() {
        LinkedList<a> linkedList;
        linkedList = this.f4579a;
        this.f4579a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f4579a.add(new a(0, obj));
        m152a();
    }
}
