package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f37216a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f37217b;

    public void a() {
        this.f37217b = (this.f37217b + 1) % this.f37216a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f37216a.addAll(list);
    }

    public int b() {
        return this.f37216a.size();
    }

    @NonNull
    public T c() {
        return this.f37216a.get(this.f37217b);
    }

    public int d() {
        return this.f37217b;
    }
}
