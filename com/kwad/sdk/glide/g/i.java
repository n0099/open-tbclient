package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f35909a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35910b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35911c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f35909a = cls;
        this.f35910b = cls2;
        this.f35911c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f35909a.equals(iVar.f35909a) && this.f35910b.equals(iVar.f35910b) && k.a(this.f35911c, iVar.f35911c);
    }

    public int hashCode() {
        int hashCode = ((this.f35909a.hashCode() * 31) + this.f35910b.hashCode()) * 31;
        Class<?> cls = this.f35911c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f35909a + ", second=" + this.f35910b + '}';
    }
}
