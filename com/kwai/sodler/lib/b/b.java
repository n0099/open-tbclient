package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f37528a;

    /* renamed from: b  reason: collision with root package name */
    public String f37529b;

    /* renamed from: c  reason: collision with root package name */
    public String f37530c;

    /* renamed from: d  reason: collision with root package name */
    public long f37531d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37532e;

    /* renamed from: f  reason: collision with root package name */
    public String f37533f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37534g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f37535h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f37529b.compareTo(bVar.f37529b);
    }
}
