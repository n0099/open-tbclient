package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.c.c1;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class AbstractIterator<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public State f30768e = State.NOT_READY;

    /* renamed from: f  reason: collision with root package name */
    public T f30769f;

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
        public static final /* synthetic */ int[] f30770a;

        static {
            int[] iArr = new int[State.values().length];
            f30770a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30770a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f30768e = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f30768e = State.FAILED;
        this.f30769f = a();
        if (this.f30768e != State.DONE) {
            this.f30768e = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        n.w(this.f30768e != State.FAILED);
        int i = a.f30770a[this.f30768e.ordinal()];
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
            this.f30768e = State.NOT_READY;
            T t = this.f30769f;
            this.f30769f = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
