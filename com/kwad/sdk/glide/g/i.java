package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f35610a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35611b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35612c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f35610a = cls;
        this.f35611b = cls2;
        this.f35612c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f35610a.equals(iVar.f35610a) && this.f35611b.equals(iVar.f35611b) && k.a(this.f35612c, iVar.f35612c);
    }

    public int hashCode() {
        int hashCode = ((this.f35610a.hashCode() * 31) + this.f35611b.hashCode()) * 31;
        Class<?> cls = this.f35612c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f35610a + ", second=" + this.f35611b + '}';
    }
}
