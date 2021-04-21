package com.ss.android.socialbase.downloader.i;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class g<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: a  reason: collision with root package name */
    public int f39300a;

    public g() {
        this(4, 4);
    }

    public void a(int i) {
        this.f39300a = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f39300a;
    }

    public g(int i, int i2) {
        this(i, i2, true);
    }

    public g(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        a(i2);
    }
}
