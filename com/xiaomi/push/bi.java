package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes7.dex */
public class bi {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<a> f40285a = new LinkedList<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f40286a = new bi();

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
        return a.f40286a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m158a() {
        if (this.f40285a.size() > 100) {
            this.f40285a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m159a() {
        return this.f40285a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m160a() {
        LinkedList<a> linkedList;
        linkedList = this.f40285a;
        this.f40285a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f40285a.add(new a(0, obj));
        m158a();
    }
}
