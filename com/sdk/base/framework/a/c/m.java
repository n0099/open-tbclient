package com.sdk.base.framework.a.c;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public final class m implements Iterator<E> {

    /* renamed from: a  reason: collision with root package name */
    public a<E> f38743a;

    /* renamed from: b  reason: collision with root package name */
    public a<E> f38744b;

    /* renamed from: c  reason: collision with root package name */
    public E f38745c;

    /* renamed from: d  reason: collision with root package name */
    public /* synthetic */ l f38746d;

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.lang.Object] */
    public m(l lVar) {
        this.f38746d = lVar;
        lVar.a();
        try {
            a aVar = lVar.f38735a.f38706a;
            this.f38743a = aVar;
            if (aVar != null) {
                this.f38745c = aVar.b();
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
            aVar3 = aVar2.f38706a;
            if (aVar3 == aVar2) {
                return this.f38746d.f38735a.f38706a;
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
        return this.f38743a != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final E next() {
        this.f38746d.a();
        try {
            if (this.f38743a != null) {
                E e2 = this.f38745c;
                this.f38744b = this.f38743a;
                a<E> a2 = a(this.f38743a);
                this.f38743a = a2;
                this.f38745c = a2 == 0 ? 0 : a2.b();
                return e2;
            }
            throw new NoSuchElementException();
        } finally {
            this.f38746d.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        r4.f38746d.a(r1, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        if (this.f38744b == null) {
            throw new IllegalStateException();
        }
        this.f38746d.a();
        try {
            a aVar = this.f38744b;
            this.f38744b = null;
            a aVar2 = this.f38746d.f38735a;
            while (true) {
                a aVar3 = aVar2;
                aVar2 = aVar2.f38706a;
                if (aVar2 == null) {
                    break;
                } else if (aVar2 == aVar) {
                    break;
                }
            }
        } finally {
            this.f38746d.b();
        }
    }
}
