package com.xiaomi.push;

import java.util.LinkedList;
/* loaded from: classes6.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<a> f13879a = new LinkedList<>();

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final bb f13880a = new bb();

        /* renamed from: a  reason: collision with other field name */
        public int f200a;

        /* renamed from: a  reason: collision with other field name */
        public Object f201a;

        /* renamed from: a  reason: collision with other field name */
        public String f202a;

        a(int i, Object obj) {
            this.f200a = i;
            this.f201a = obj;
        }
    }

    public static bb a() {
        return a.f13880a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m185a() {
        if (this.f13879a.size() > 100) {
            this.f13879a.removeFirst();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized int m186a() {
        return this.f13879a.size();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized LinkedList<a> m187a() {
        LinkedList<a> linkedList;
        linkedList = this.f13879a;
        this.f13879a = new LinkedList<>();
        return linkedList;
    }

    public synchronized void a(Object obj) {
        this.f13879a.add(new a(0, obj));
        m185a();
    }
}
