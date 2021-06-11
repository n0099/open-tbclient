package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements Comparable<a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37964a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37965b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final f f37966c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f37967d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f37968e;

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar) {
        this(str, str2, fVar, (Map<String, String>) null);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar, Map<String, String> map) {
        this.f37964a = str;
        this.f37965b = str2;
        this.f37966c = fVar;
        this.f37967d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        this.f37964a = str;
        this.f37965b = str3;
        this.f37966c = fVar;
        this.f37968e = str2;
        this.f37967d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        f fVar;
        f fVar2 = this.f37966c;
        if (fVar2 == null || (fVar = aVar.f37966c) == null) {
            return 0;
        }
        return (int) (fVar2.f37985e - fVar.f37985e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            String str = this.f37965b;
            String str2 = ((a) obj).f37965b;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }
}
