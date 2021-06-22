package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f38084a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f38085b;

    public void a() {
        this.f38085b = (this.f38085b + 1) % this.f38084a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f38084a.addAll(list);
    }

    public int b() {
        return this.f38084a.size();
    }

    @NonNull
    public T c() {
        return this.f38084a.get(this.f38085b);
    }

    public int d() {
        return this.f38085b;
    }
}
