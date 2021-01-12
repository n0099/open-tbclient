package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f11032a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11033b;
    public final long c;
    public String d;
    public long e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f11032a = str;
        this.f11033b = str2;
        this.d = resolverType.mValue;
        this.c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.e - fVar.e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f11033b.equals(((f) obj).f11033b);
    }

    public int hashCode() {
        return this.f11033b.hashCode();
    }

    public String toString() {
        return this.f11033b;
    }
}
