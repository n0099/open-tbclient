package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f37144a;

    /* renamed from: b  reason: collision with root package name */
    public String f37145b;

    /* renamed from: c  reason: collision with root package name */
    public String f37146c;

    /* renamed from: d  reason: collision with root package name */
    public long f37147d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37148e;

    /* renamed from: f  reason: collision with root package name */
    public String f37149f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37150g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f37151h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f37145b.compareTo(bVar.f37145b);
    }
}
