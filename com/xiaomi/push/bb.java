package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes6.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f14177a = new LinkedList<>();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f14178a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f201a;

        /* renamed from: a  reason: collision with other field name */
        public Object f202a;

        /* renamed from: a  reason: collision with other field name */
        public String f203a;

        a(int i, Object obj) {
            this.f201a = i;
            this.f202a = obj;
        }
    }

    public static bb a() {
        return a.f14178a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m189a() {
        if (this.f14177a.size() > 100) {
            this.f14177a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m190a() {
        return this.f14177a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m191a() {
        LinkedList<a> linkedList;
        linkedList = this.f14177a;
        this.f14177a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f14177a.add(new a(0, obj));
        m189a();
    }
}
