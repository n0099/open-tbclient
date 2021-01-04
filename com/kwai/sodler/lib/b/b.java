package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f11302a;

    /* renamed from: b  reason: collision with root package name */
    public String f11303b;
    public String c;
    public long d;
    public boolean e;
    public String f;
    public boolean g = false;
    public HashMap<String, String> h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f11303b.compareTo(bVar.f11303b);
    }
}
