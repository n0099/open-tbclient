package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f37981a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37982b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37983c;

    /* renamed from: d  reason: collision with root package name */
    public String f37984d;

    /* renamed from: e  reason: collision with root package name */
    public long f37985e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f37981a = str;
        this.f37982b = str2;
        this.f37984d = resolverType.mValue;
        this.f37983c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f37985e - fVar.f37985e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f37982b.equals(((f) obj).f37982b);
    }

    public int hashCode() {
        return this.f37982b.hashCode();
    }

    public String toString() {
        return this.f37982b;
    }
}
