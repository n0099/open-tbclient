package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements Comparable<a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f7263a;
    @NonNull
    public final String b;
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
        this.f7263a = str;
        this.b = str2;
        this.c = fVar;
        this.d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        this.f7263a = str;
        this.b = str3;
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
            return this.b != null ? this.b.equals(aVar.b) : aVar.b == null;
        }
        return false;
    }
}
