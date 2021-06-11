package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c1;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f30980e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f30981f;

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
        public static final /* synthetic */ int[] f30982a;

        static {
            int[] iArr = new int[State.values().length];
            f30982a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30982a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f30980e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f30980e = State.FAILED;
        this.f30981f = a();
        if (this.f30980e != State.DONE) {
            this.f30980e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f30980e != State.FAILED);
        int i2 = a.f30982a[this.f30980e.ordinal()];
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
            this.f30980e = State.NOT_READY;
            T t = this.f30981f;
            this.f30981f = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
