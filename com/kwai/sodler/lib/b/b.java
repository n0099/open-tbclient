package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f34426a;

    /* renamed from: b  reason: collision with root package name */
    public String f34427b;

    /* renamed from: c  reason: collision with root package name */
    public String f34428c;

    /* renamed from: d  reason: collision with root package name */
    public long f34429d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34430e;

    /* renamed from: f  reason: collision with root package name */
    public String f34431f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34432g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f34433h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f34427b.compareTo(bVar.f34427b);
    }
}
