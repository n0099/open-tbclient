package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f7269a = new ArrayList();
    private int b;

    public void a() {
        this.b = (this.b + 1) % this.f7269a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f7269a.addAll(list);
    }

    public int b() {
        return this.f7269a.size();
    }

    @NonNull
    public T c() {
        return this.f7269a.get(this.b);
    }

    public int d() {
        return this.b;
    }
}
