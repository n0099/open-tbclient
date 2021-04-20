package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public Class<?> f35515a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35516b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f35517c;

    public i() {
    }

    public i(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f35515a = cls;
        this.f35516b = cls2;
        this.f35517c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f35515a.equals(iVar.f35515a) && this.f35516b.equals(iVar.f35516b) && k.a(this.f35517c, iVar.f35517c);
    }

    public int hashCode() {
        int hashCode = ((this.f35515a.hashCode() * 31) + this.f35516b.hashCode()) * 31;
        Class<?> cls = this.f35517c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f35515a + ", second=" + this.f35516b + '}';
    }
}
