package com.google.common.base;

import d.g.c.a.n;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f31611e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f31612f;

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
        public static final /* synthetic */ int[] f31613a;

        static {
            int[] iArr = new int[State.values().length];
            f31613a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31613a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f31611e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f31611e = State.FAILED;
        this.f31612f = a();
        if (this.f31611e != State.DONE) {
            this.f31611e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f31611e != State.FAILED);
        int i2 = a.f31613a[this.f31611e.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return c();
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f31611e = State.NOT_READY;
            T t = this.f31612f;
            this.f31612f = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
