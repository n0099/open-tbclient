package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f41038a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f41039a = new bi();

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
        return a.f41039a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m163a() {
        if (this.f41038a.size() > 100) {
            this.f41038a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m164a() {
        return this.f41038a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m165a() {
        LinkedList<a> linkedList;
        linkedList = this.f41038a;
        this.f41038a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f41038a.add(new a(0, obj));
        m163a();
    }
}
