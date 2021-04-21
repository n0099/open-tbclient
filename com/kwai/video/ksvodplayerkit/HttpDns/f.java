package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f37596a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37597b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37598c;

    /* renamed from: d  reason: collision with root package name */
    public String f37599d;

    /* renamed from: e  reason: collision with root package name */
    public long f37600e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f37596a = str;
        this.f37597b = str2;
        this.f37599d = resolverType.mValue;
        this.f37598c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f37600e - fVar.f37600e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f37597b.equals(((f) obj).f37597b);
    }

    public int hashCode() {
        return this.f37597b.hashCode();
    }

    public String toString() {
        return this.f37597b;
    }
}
