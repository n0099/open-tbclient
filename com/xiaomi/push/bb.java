package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes5.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f8272a = new LinkedList<>();

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f8273a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f121a;

        /* renamed from: a  reason: collision with other field name */
        public Object f122a;

        /* renamed from: a  reason: collision with other field name */
        public String f123a;

        a(int i, Object obj) {
            this.f121a = i;
            this.f122a = obj;
        }
    }

    public static bb a() {
        return a.f8273a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m163a() {
        if (this.f8272a.size() > 100) {
            this.f8272a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m164a() {
        return this.f8272a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m165a() {
        LinkedList<a> linkedList;
        linkedList = this.f8272a;
        this.f8272a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f8272a.add(new a(0, obj));
        m163a();
    }
}
