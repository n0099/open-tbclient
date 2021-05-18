package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f37430a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f37431a = new bi();

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
        return a.f37431a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m164a() {
        if (this.f37430a.size() > 100) {
            this.f37430a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m165a() {
        return this.f37430a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m166a() {
        LinkedList<a> linkedList;
        linkedList = this.f37430a;
        this.f37430a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f37430a.add(new a(0, obj));
        m164a();
    }
}
