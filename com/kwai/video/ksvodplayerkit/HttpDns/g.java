package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f11034a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f11035b;

    public void a() {
        this.f11035b = (this.f11035b + 1) % this.f11034a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f11034a.addAll(list);
    }

    public int b() {
        return this.f11034a.size();
    }

    @NonNull
    public T c() {
        return this.f11034a.get(this.f11035b);
    }

    public int d() {
        return this.f11035b;
    }
}
