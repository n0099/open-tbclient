package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f40669a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f40670a = new bi();

        /* renamed from: a  reason: collision with other field name */
        public int f150a;

        /* renamed from: a  reason: collision with other field name */
        public Object f151a;

        /* renamed from: a  reason: collision with other field name */
        public String f152a;

        public a(int i, Object obj) {
            this.f150a = i;
            this.f151a = obj;
        }
    }

    public static bi a() {
        return a.f40670a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m162a() {
        if (this.f40669a.size() > 100) {
            this.f40669a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m163a() {
        return this.f40669a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m164a() {
        LinkedList<a> linkedList;
        linkedList = this.f40669a;
        this.f40669a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f40669a.add(new a(0, obj));
        m162a();
    }
}
