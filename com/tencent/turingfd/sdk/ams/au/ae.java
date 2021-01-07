package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ae<E> {

    /* renamed from: a  reason: collision with root package name */
    public int f13765a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<E> f13766b = new LinkedList<>();

    public ae(int i) {
        this.f13765a = i;
    }

    public int a() {
        return this.f13766b.size();
    }

    public void a(E e) {
        if (this.f13766b.size() >= this.f13765a) {
            this.f13766b.poll();
        }
        this.f13766b.offer(e);
    }
}
