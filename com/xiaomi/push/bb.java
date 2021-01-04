package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes6.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f14176a = new LinkedList<>();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f14177a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f200a;

        /* renamed from: a  reason: collision with other field name */
        public Object f201a;

        /* renamed from: a  reason: collision with other field name */
        public String f202a;

        a(int i, Object obj) {
            this.f200a = i;
            this.f201a = obj;
        }
    }

    public static bb a() {
        return a.f14177a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m178a() {
        if (this.f14176a.size() > 100) {
            this.f14176a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m179a() {
        return this.f14176a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m180a() {
        LinkedList<a> linkedList;
        linkedList = this.f14176a;
        this.f14176a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f14176a.add(new a(0, obj));
        m178a();
    }
}
