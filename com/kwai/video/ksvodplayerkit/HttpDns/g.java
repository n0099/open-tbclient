package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f11333a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f11334b;

    public void a() {
        this.f11334b = (this.f11334b + 1) % this.f11333a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f11333a.addAll(list);
    }

    public int b() {
        return this.f11333a.size();
    }

    @NonNull
    public T c() {
        return this.f11333a.get(this.f11334b);
    }

    public int d() {
        return this.f11334b;
    }
}
