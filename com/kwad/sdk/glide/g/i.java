package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f10326a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f10327b;
    private Class<?> c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f10326a = cls;
        this.f10327b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f10326a.equals(iVar.f10326a) && this.f10327b.equals(iVar.f10327b) && k.a(this.c, iVar.c);
    }

    public int hashCode() {
        return (this.c != null ? this.c.hashCode() : 0) + (((this.f10326a.hashCode() * 31) + this.f10327b.hashCode()) * 31);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f10326a + ", second=" + this.f10327b + '}';
    }
}
