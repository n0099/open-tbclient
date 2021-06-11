package com.sdk.base.framework.a.c;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes7.dex */
public final class m implements Iterator<E> {

    /* renamed from: a  reason: collision with root package name */
    public a<E> f39272a;

    /* renamed from: b  reason: collision with root package name */
    public a<E> f39273b;

    /* renamed from: c  reason: collision with root package name */
    public E f39274c;

    /* renamed from: d  reason: collision with root package name */
    public /* synthetic */ l f39275d;

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.lang.Object] */
    public m(l lVar) {
        this.f39275d = lVar;
        lVar.a();
        try {
            a aVar = lVar.f39264a.f39235a;
            this.f39272a = aVar;
            if (aVar != null) {
                this.f39274c = aVar.b();
            }
        } finally {
            lVar.b();
        }
    }

    /* JADX DEBUG: Type inference failed for r2v4. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r2 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a<E> a(a<E> aVar) {
        a aVar2;
        a aVar3;
        while (true) {
            aVar3 = aVar2.f39235a;
            if (aVar3 == aVar2) {
                return this.f39275d.f39264a.f39235a;
            }
            if (aVar3 == null || aVar3.b() != null) {
                break;
            }
            aVar2 = aVar3;
        }
        return aVar3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f39272a != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final E next() {
        this.f39275d.a();
        try {
            if (this.f39272a != null) {
                E e2 = this.f39274c;
                this.f39273b = this.f39272a;
                a<E> a2 = a(this.f39272a);
                this.f39272a = a2;
                this.f39274c = a2 == 0 ? 0 : a2.b();
                return e2;
            }
            throw new NoSuchElementException();
        } finally {
            this.f39275d.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        r4.f39275d.a(r1, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        if (this.f39273b == null) {
            throw new IllegalStateException();
        }
        this.f39275d.a();
        try {
            a aVar = this.f39273b;
            this.f39273b = null;
            a aVar2 = this.f39275d.f39264a;
            while (true) {
                a aVar3 = aVar2;
                aVar2 = aVar2.f39235a;
                if (aVar2 == null) {
                    break;
                } else if (aVar2 == aVar) {
                    break;
                }
            }
        } finally {
            this.f39275d.b();
        }
    }
}
