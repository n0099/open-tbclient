package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class g<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f6634a = new LinkedHashMap(100, 0.75f, true);
    private final long b;
    private long c;
    private long d;

    public g(long j) {
        this.b = j;
        this.c = j;
    }

    private void c() {
        a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(@Nullable Y y) {
        return 1;
    }

    public void a() {
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(long j) {
        while (this.d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f6634a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.d -= a((g<T, Y>) value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    protected void a(@NonNull T t, @Nullable Y y) {
    }

    public synchronized long b() {
        return this.c;
    }

    @Nullable
    public synchronized Y b(@NonNull T t) {
        return this.f6634a.get(t);
    }

    @Nullable
    public synchronized Y b(@NonNull T t, @Nullable Y y) {
        Y put;
        int a2 = a((g<T, Y>) y);
        if (a2 >= this.c) {
            a(t, y);
            put = null;
        } else {
            if (y != null) {
                this.d = a2 + this.d;
            }
            put = this.f6634a.put(t, y);
            if (put != null) {
                this.d -= a((g<T, Y>) put);
                if (!put.equals(y)) {
                    a(t, put);
                }
            }
            c();
        }
        return put;
    }

    @Nullable
    public synchronized Y c(@NonNull T t) {
        Y remove;
        remove = this.f6634a.remove(t);
        if (remove != null) {
            this.d -= a((g<T, Y>) remove);
        }
        return remove;
    }
}
