package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f35225a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35226b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35227c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f35225a = cls;
        this.f35226b = cls2;
        this.f35227c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f35225a.equals(iVar.f35225a) && this.f35226b.equals(iVar.f35226b) && k.a(this.f35227c, iVar.f35227c);
    }

    public int hashCode() {
        int hashCode = ((this.f35225a.hashCode() * 31) + this.f35226b.hashCode()) * 31;
        Class<?> cls = this.f35227c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f35225a + ", second=" + this.f35226b + '}';
    }
}
