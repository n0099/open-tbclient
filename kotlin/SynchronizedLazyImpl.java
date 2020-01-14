package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SynchronizedLazyImpl<T> implements Serializable, d<T> {
    private volatile Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.a.a<? extends T> aVar, Object obj) {
        q.j(aVar, "initializer");
        this.initializer = aVar;
        this._value = j.nAX;
        this.lock = obj == null ? this : obj;
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.a.a aVar, Object obj, int i, o oVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }

    @Override // kotlin.d
    public T getValue() {
        T t = (T) this._value;
        if (t == j.nAX) {
            synchronized (this.lock) {
                t = this._value;
                if (t == j.nAX) {
                    kotlin.jvm.a.a<? extends T> aVar = this.initializer;
                    if (aVar == null) {
                        q.dJm();
                    }
                    T invoke = aVar.invoke();
                    this._value = invoke;
                    this.initializer = null;
                    t = invoke;
                }
            }
        }
        return t;
    }

    public boolean isInitialized() {
        return this._value != j.nAX;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }
}
