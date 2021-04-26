package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f38185a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f38186a = new bi();

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
        return a.f38186a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m165a() {
        if (this.f38185a.size() > 100) {
            this.f38185a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m166a() {
        return this.f38185a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m167a() {
        LinkedList<a> linkedList;
        linkedList = this.f38185a;
        this.f38185a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f38185a.add(new a(0, obj));
        m165a();
    }
}
