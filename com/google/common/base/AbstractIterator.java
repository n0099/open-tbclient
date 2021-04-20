package com.google.common.base;

import d.g.c.a.n;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f30579e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f30580f;

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
        public static final /* synthetic */ int[] f30581a;

        static {
            int[] iArr = new int[State.values().length];
            f30581a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30581a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f30579e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f30579e = State.FAILED;
        this.f30580f = a();
        if (this.f30579e != State.DONE) {
            this.f30579e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f30579e != State.FAILED);
        int i = a.f30581a[this.f30579e.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return c();
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f30579e = State.NOT_READY;
            T t = this.f30580f;
            this.f30580f = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
