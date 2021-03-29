package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public final String f37212a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37213b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37214c;

    /* renamed from: d  reason: collision with root package name */
    public String f37215d;

    /* renamed from: e  reason: collision with root package name */
    public long f37216e;

    public f(String str, String str2, ResolverType resolverType, long j) {
        this.f37212a = str;
        this.f37213b = str2;
        this.f37215d = resolverType.mValue;
        this.f37214c = System.currentTimeMillis() + j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull f fVar) {
        return (int) (this.f37216e - fVar.f37216e);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.f37213b.equals(((f) obj).f37213b);
    }

    public int hashCode() {
        return this.f37213b.hashCode();
    }

    public String toString() {
        return this.f37213b;
    }
}
