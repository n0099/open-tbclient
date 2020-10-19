package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes12.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f4809a = new LinkedList<>();

    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f4810a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f122a;

        /* renamed from: a  reason: collision with other field name */
        public Object f123a;

        /* renamed from: a  reason: collision with other field name */
        public String f124a;

        a(int i, Object obj) {
            this.f122a = i;
            this.f123a = obj;
        }
    }

    public static bb a() {
        return a.f4810a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m160a() {
        if (this.f4809a.size() > 100) {
            this.f4809a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m161a() {
        return this.f4809a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m162a() {
        LinkedList<a> linkedList;
        linkedList = this.f4809a;
        this.f4809a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f4809a.add(new a(0, obj));
        m160a();
    }
}
