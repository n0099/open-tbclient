package io.reactivex.schedulers;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class Timed<T> {
    public final long time;
    public final TimeUnit unit;
    public final T value;

    public Timed(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        this.value = t;
        this.time = j;
        this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (obj instanceof Timed) {
            Timed timed = (Timed) obj;
            return ObjectHelper.equals(this.value, timed.value) && this.time == timed.time && ObjectHelper.equals(this.unit, timed.unit);
        }
        return false;
    }

    public int hashCode() {
        T t = this.value;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.time;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.unit.hashCode();
    }

    public long time() {
        return this.time;
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + PreferencesUtil.RIGHT_MOUNT;
    }

    @NonNull
    public TimeUnit unit() {
        return this.unit;
    }

    @NonNull
    public T value() {
        return this.value;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }
}
