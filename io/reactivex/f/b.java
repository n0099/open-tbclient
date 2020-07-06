package io.reactivex.f;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class b<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public b(T t, long j, TimeUnit timeUnit) {
        this.value = t;
        this.time = j;
        this.unit = (TimeUnit) io.reactivex.internal.functions.a.k(timeUnit, "unit is null");
    }

    public T dQf() {
        return this.value;
    }

    public long amH() {
        return this.time;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return io.reactivex.internal.functions.a.equals(this.value, bVar.value) && this.time == bVar.time && io.reactivex.internal.functions.a.equals(this.unit, bVar.unit);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.value != null ? this.value.hashCode() : 0) * 31) + ((int) ((this.time >>> 31) ^ this.time))) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + "]";
    }
}
