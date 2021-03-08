package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f7268a;
    public final String b;
    public final long c;
    public String d;
    public long e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f7268a = str;
        this.b = str2;
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
        return (obj instanceof f) && this.b.equals(((f) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }
}
