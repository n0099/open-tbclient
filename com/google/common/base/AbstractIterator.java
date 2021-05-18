package com.google.common.base;

import d.g.c.a.n;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f30856e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f30857f;

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
        public static final /* synthetic */ int[] f30858a;

        static {
            int[] iArr = new int[State.values().length];
            f30858a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30858a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f30856e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f30856e = State.FAILED;
        this.f30857f = a();
        if (this.f30856e != State.DONE) {
            this.f30856e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f30856e != State.FAILED);
        int i2 = a.f30858a[this.f30856e.ordinal()];
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
            this.f30856e = State.NOT_READY;
            T t = this.f30857f;
            this.f30857f = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
