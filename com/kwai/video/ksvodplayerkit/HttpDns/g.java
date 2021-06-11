package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f37986a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f37987b;

    public void a() {
        this.f37987b = (this.f37987b + 1) % this.f37986a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f37986a.addAll(list);
    }

    public int b() {
        return this.f37986a.size();
    }

    @NonNull
    public T c() {
        return this.f37986a.get(this.f37987b);
    }

    public int d() {
        return this.f37987b;
    }
}
