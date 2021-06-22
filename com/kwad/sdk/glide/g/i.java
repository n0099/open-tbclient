package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f36007a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f36008b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f36009c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f36007a = cls;
        this.f36008b = cls2;
        this.f36009c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f36007a.equals(iVar.f36007a) && this.f36008b.equals(iVar.f36008b) && k.a(this.f36009c, iVar.f36009c);
    }

    public int hashCode() {
        int hashCode = ((this.f36007a.hashCode() * 31) + this.f36008b.hashCode()) * 31;
        Class<?> cls = this.f36009c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f36007a + ", second=" + this.f36008b + '}';
    }
}
