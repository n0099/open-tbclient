package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f37501a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37502b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37503c;

    /* renamed from: d  reason: collision with root package name */
    public String f37504d;

    /* renamed from: e  reason: collision with root package name */
    public long f37505e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f37501a = str;
        this.f37502b = str2;
        this.f37504d = resolverType.mValue;
        this.f37503c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f37505e - fVar.f37505e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f37502b.equals(((f) obj).f37502b);
    }

    public int hashCode() {
        return this.f37502b.hashCode();
    }

    public String toString() {
        return this.f37502b;
    }
}
