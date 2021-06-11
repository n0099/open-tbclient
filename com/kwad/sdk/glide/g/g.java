package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<T, Y> f35904a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public final long f35905b;

    /* renamed from: c  reason: collision with root package name */
    public long f35906c;

    /* renamed from: d  reason: collision with root package name */
    public long f35907d;

    public g(long j) {
        this.f35905b = j;
        this.f35906c = j;
    }

    private void c() {
        a(this.f35906c);
    }

    public int a(@Nullable Y y) {
        return 1;
    }

    public void a() {
        a(0L);
    }

    public synchronized void a(long j) {
        while (this.f35907d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f35904a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f35907d -= a((g<T, Y>) value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    public void a(@NonNull T t, @Nullable Y y) {
    }

    public synchronized long b() {
        return this.f35906c;
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        return this.f35904a.get(t);
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        long a2 = a((g<T, Y>) y);
        if (a2 >= this.f35906c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f35907d += a2;
        }
        Y put = this.f35904a.put(t, y);
        if (put != null) {
            this.f35907d -= a((g<T, Y>) put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        c();
        return put;
    }

    @Nullable
    public synchronized Y c(@NonNull T t) {
        Y remove;
        remove = this.f35904a.remove(t);
        if (remove != null) {
            this.f35907d -= a((g<T, Y>) remove);
        }
        return remove;
    }
}
