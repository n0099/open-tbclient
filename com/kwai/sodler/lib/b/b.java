package com.kwai.sodler.lib.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f37910a;

    /* renamed from: b  reason: collision with root package name */
    public String f37911b;

    /* renamed from: c  reason: collision with root package name */
    public String f37912c;

    /* renamed from: d  reason: collision with root package name */
    public long f37913d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37914e;

    /* renamed from: f  reason: collision with root package name */
    public String f37915f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37916g = false;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, String> f37917h = new HashMap<>(10);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull b bVar) {
        return -this.f37911b.compareTo(bVar.f37911b);
    }
}
