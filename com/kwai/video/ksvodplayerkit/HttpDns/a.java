package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes7.dex */
public class a implements Comparable<a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f38062a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f38063b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final f f38064c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f38065d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f38066e;

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar) {
        this(str, str2, fVar, (Map<String, String>) null);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar, Map<String, String> map) {
        this.f38062a = str;
        this.f38063b = str2;
        this.f38064c = fVar;
        this.f38065d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        this.f38062a = str;
        this.f38063b = str3;
        this.f38064c = fVar;
        this.f38066e = str2;
        this.f38065d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        f fVar;
        f fVar2 = this.f38064c;
        if (fVar2 == null || (fVar = aVar.f38064c) == null) {
            return 0;
        }
        return (int) (fVar2.f38083e - fVar.f38083e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            String str = this.f38063b;
            String str2 = ((a) obj).f38063b;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }
}
