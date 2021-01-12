package com.tencent.turingfd.sdk.ams.au;

import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ae<E> {

    /* renamed from: a  reason: collision with root package name */
    public int f13465a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList<E> f13466b = new LinkedList<>();

    public ae(int i) {
        this.f13465a = i;
    }

    public int a() {
        return this.f13466b.size();
    }

    public void a(E e) {
        if (this.f13466b.size() >= this.f13465a) {
            this.f13466b.poll();
        }
        this.f13466b.offer(e);
    }
}
