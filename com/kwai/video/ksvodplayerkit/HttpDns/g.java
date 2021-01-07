package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g<T> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<T> f11334a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f11335b;

    public void a() {
        this.f11335b = (this.f11335b + 1) % this.f11334a.size();
    }

    public void a(@NonNull List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("elements can not be empty");
        }
        this.f11334a.addAll(list);
    }

    public int b() {
        return this.f11334a.size();
    }

    @NonNull
    public T c() {
        return this.f11334a.get(this.f11335b);
    }

    public int d() {
        return this.f11335b;
    }
}
