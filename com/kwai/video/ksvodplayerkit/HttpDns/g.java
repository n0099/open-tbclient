package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f11036a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f11037b;

    public void a() {
        this.f11037b = (this.f11037b + 1) % this.f11036a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f11036a.addAll(list);
    }

    public int b() {
        return this.f11036a.size();
    }

    @NonNull
    public T c() {
        return this.f11036a.get(this.f11037b);
    }

    public int d() {
        return this.f11037b;
    }
}
