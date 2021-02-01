package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;
/* loaded from: classes15.dex */
public class ae<E> {

    /* renamed from: a  reason: collision with root package name */
    public int f13467a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<E> f13468b = new LinkedList<>();

    public ae(int i) {
        this.f13467a = i;
    }

    public int a() {
        return this.f13468b.size();
    }

    public void a(E e) {
        if (this.f13468b.size() >= this.f13467a) {
            this.f13468b.poll();
        }
        this.f13468b.offer(e);
    }
}
