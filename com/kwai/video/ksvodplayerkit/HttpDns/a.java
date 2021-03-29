package com.kwai.video.ksvodplayerkit.HttpDns;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements Comparable<a> {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37196a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37197b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final f f37198c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f37199d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f37200e;

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar) {
        this(str, str2, fVar, (Map<String, String>) null);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable f fVar, Map<String, String> map) {
        this.f37196a = str;
        this.f37197b = str2;
        this.f37198c = fVar;
        this.f37199d = map;
    }

    public a(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable f fVar) {
        this.f37196a = str;
        this.f37197b = str3;
        this.f37198c = fVar;
        this.f37200e = str2;
        this.f37199d = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        f fVar;
        f fVar2 = this.f37198c;
        if (fVar2 == null || (fVar = aVar.f37198c) == null) {
            return 0;
        }
        return (int) (fVar2.f37216e - fVar.f37216e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            String str = this.f37197b;
            String str2 = ((a) obj).f37197b;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }
}
