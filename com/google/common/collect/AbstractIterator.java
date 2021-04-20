package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c1;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f30673e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f30674f;

    /* loaded from: classes6.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30675a;

        static {
            int[] iArr = new int[State.values().length];
            f30675a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30675a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f30673e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f30673e = State.FAILED;
        this.f30674f = a();
        if (this.f30673e != State.DONE) {
            this.f30673e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f30673e != State.FAILED);
        int i = a.f30675a[this.f30673e.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return c();
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f30673e = State.NOT_READY;
            T t = this.f30674f;
            this.f30674f = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
