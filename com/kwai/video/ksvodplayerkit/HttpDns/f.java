package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f38079a;

    /* renamed from: b  reason: collision with root package name */
    public final String f38080b;

    /* renamed from: c  reason: collision with root package name */
    public final long f38081c;

    /* renamed from: d  reason: collision with root package name */
    public String f38082d;

    /* renamed from: e  reason: collision with root package name */
    public long f38083e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f38079a = str;
        this.f38080b = str2;
        this.f38082d = resolverType.mValue;
        this.f38081c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f38083e - fVar.f38083e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f38080b.equals(((f) obj).f38080b);
    }

    public int hashCode() {
        return this.f38080b.hashCode();
    }

    public String toString() {
        return this.f38080b;
    }
}
