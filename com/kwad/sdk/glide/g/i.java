package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f10029a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f10030b;
    private Class<?> c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f10029a = cls;
        this.f10030b = cls2;
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
        return this.f10029a.equals(iVar.f10029a) && this.f10030b.equals(iVar.f10030b) && k.a(this.c, iVar.c);
    }

    public int hashCode() {
        return (this.c != null ? this.c.hashCode() : 0) + (((this.f10029a.hashCode() * 31) + this.f10030b.hashCode()) * 31);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f10029a + ", second=" + this.f10030b + '}';
    }
}
