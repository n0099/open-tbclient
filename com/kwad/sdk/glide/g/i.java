package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f35226a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35227b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35228c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f35226a = cls;
        this.f35227b = cls2;
        this.f35228c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f35226a.equals(iVar.f35226a) && this.f35227b.equals(iVar.f35227b) && k.a(this.f35228c, iVar.f35228c);
    }

    public int hashCode() {
        int hashCode = ((this.f35226a.hashCode() * 31) + this.f35227b.hashCode()) * 31;
        Class<?> cls = this.f35228c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f35226a + ", second=" + this.f35227b + '}';
    }
}
