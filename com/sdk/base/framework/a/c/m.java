package com.sdk.base.framework.a.c;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes4.dex */
final class m implements Iterator<E> {

    /* renamed from: a  reason: collision with root package name */
    private a<E> f12794a;

    /* renamed from: b  reason: collision with root package name */
    private a<E> f12795b;
    private E c;
    private /* synthetic */ l d;

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E> */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v5, types: [E, java.lang.Object] */
    public m(l lVar) {
        this.d = lVar;
        lVar.a();
        try {
            this.f12794a = lVar.f12792a.f12776a;
            if (this.f12794a != null) {
                this.c = this.f12794a.b();
            }
        } finally {
            lVar.b();
        }
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.sdk.base.framework.a.c.a<E> */
    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a<E> a(a<E> aVar) {
        a aVar2;
        while (true) {
            a aVar3 = aVar2.f12776a;
            if (aVar3 == aVar2) {
                return this.d.f12792a.f12776a;
            }
            if (aVar3 == null || aVar3.b() != null) {
                return aVar3;
            }
            aVar2 = aVar3;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12794a != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: E */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: E */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final E next() {
        this.d.a();
        try {
            if (this.f12794a == null) {
                throw new NoSuchElementException();
            }
            E e = this.c;
            this.f12795b = this.f12794a;
            this.f12794a = a(this.f12794a);
            this.c = this.f12794a == null ? 0 : this.f12794a.b();
            return e;
        } finally {
            this.d.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        r4.d.a(r0, r2);
     */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void remove() {
        if (this.f12795b == null) {
            throw new IllegalStateException();
        }
        this.d.a();
        try {
            a aVar = this.f12795b;
            this.f12795b = null;
            a aVar2 = this.d.f12792a;
            a aVar3 = aVar2.f12776a;
            a aVar4 = aVar2;
            while (true) {
                if (aVar3 == null) {
                    break;
                } else if (aVar3 == aVar) {
                    break;
                } else {
                    aVar4 = aVar3;
                    aVar3 = aVar3.f12776a;
                }
            }
        } finally {
            this.d.b();
        }
    }
}
