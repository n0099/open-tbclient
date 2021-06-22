package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f38008a;

    /* renamed from: b  reason: collision with root package name */
    public String f38009b;

    /* renamed from: c  reason: collision with root package name */
    public String f38010c;

    /* renamed from: d  reason: collision with root package name */
    public long f38011d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38012e;

    /* renamed from: f  reason: collision with root package name */
    public String f38013f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f38014g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f38015h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f38009b.compareTo(bVar.f38009b);
    }
}
