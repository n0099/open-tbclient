package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes10.dex */
public class bk {
    public LinkedList<a> a = new LinkedList<>();

    /* loaded from: classes10.dex */
    public static class a {
        public static final bk a = new bk();

        /* renamed from: a  reason: collision with other field name */
        public int f141a;

        /* renamed from: a  reason: collision with other field name */
        public Object f142a;

        /* renamed from: a  reason: collision with other field name */
        public String f143a;

        public a(int i, Object obj) {
            this.f141a = i;
            this.f142a = obj;
        }
    }

    public static bk a() {
        return a.a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m303a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m304a() {
        return this.a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m305a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m303a();
    }
}
