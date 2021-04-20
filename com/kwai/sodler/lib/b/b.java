package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f37433a;

    /* renamed from: b  reason: collision with root package name */
    public String f37434b;

    /* renamed from: c  reason: collision with root package name */
    public String f37435c;

    /* renamed from: d  reason: collision with root package name */
    public long f37436d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37437e;

    /* renamed from: f  reason: collision with root package name */
    public String f37438f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37439g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f37440h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f37434b.compareTo(bVar.f37434b);
    }
}
