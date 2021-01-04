package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements Comparable<a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f11324a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f11325b;
    @Nullable
    public final f c;
    @Nullable
    public final Map<String, String> d;
    @NonNull
    public String e;

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar) {
        this(str, str2, fVar, (Map<String, String>) null);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar, Map<String, String> map) {
        this.f11324a = str;
        this.f11325b = str2;
        this.c = fVar;
        this.d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        this.f11324a = str;
        this.f11325b = str3;
        this.c = fVar;
        this.e = str2;
        this.d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (this.c == null || aVar.c == null) {
            return 0;
        }
        return (int) (this.c.e - aVar.c.e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f11325b != null ? this.f11325b.equals(aVar.f11325b) : aVar.f11325b == null;
        }
        return false;
    }
}
