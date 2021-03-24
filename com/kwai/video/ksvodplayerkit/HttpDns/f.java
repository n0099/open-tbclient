package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f37211a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37212b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37213c;

    /* renamed from: d  reason: collision with root package name */
    public String f37214d;

    /* renamed from: e  reason: collision with root package name */
    public long f37215e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f37211a = str;
        this.f37212b = str2;
        this.f37214d = resolverType.mValue;
        this.f37213c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f37215e - fVar.f37215e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f37212b.equals(((f) obj).f37212b);
    }

    public int hashCode() {
        return this.f37212b.hashCode();
    }

    public String toString() {
        return this.f37212b;
    }
}
