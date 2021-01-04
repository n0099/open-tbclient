package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ae<E> {

    /* renamed from: a  reason: collision with root package name */
    public int f13764a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<E> f13765b = new LinkedList<>();

    public ae(int i) {
        this.f13764a = i;
    }

    public int a() {
        return this.f13765b.size();
    }

    public void a(E e) {
        if (this.f13765b.size() >= this.f13764a) {
            this.f13765b.poll();
        }
        this.f13765b.offer(e);
    }
}
