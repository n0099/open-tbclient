package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c1;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f31715e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f31716f;

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
        public static final /* synthetic */ int[] f31717a;

        static {
            int[] iArr = new int[State.values().length];
            f31717a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31717a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f31715e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f31715e = State.FAILED;
        this.f31716f = a();
        if (this.f31715e != State.DONE) {
            this.f31715e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f31715e != State.FAILED);
        int i2 = a.f31717a[this.f31715e.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return c();
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f31715e = State.NOT_READY;
            T t = this.f31716f;
            this.f31716f = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
