package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f41141a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f41142a = new bi();

        /* renamed from: a  reason: collision with other field name */
        public int f150a;

        /* renamed from: a  reason: collision with other field name */
        public Object f151a;

        /* renamed from: a  reason: collision with other field name */
        public String f152a;

        public a(int i2, Object obj) {
            this.f150a = i2;
            this.f151a = obj;
        }
    }

    public static bi a() {
        return a.f41142a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m163a() {
        if (this.f41141a.size() > 100) {
            this.f41141a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m164a() {
        return this.f41141a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m165a() {
        LinkedList<a> linkedList;
        linkedList = this.f41141a;
        this.f41141a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f41141a.add(new a(0, obj));
        m163a();
    }
}
