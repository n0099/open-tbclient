package com.ss.android.socialbase.downloader.i;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class g<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: a  reason: collision with root package name */
    public int f36064a;

    public g() {
        this(4, 4);
    }

    public void a(int i2) {
        this.f36064a = i2;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f36064a;
    }

    public g(int i2, int i3) {
        this(i2, i3, true);
    }

    public g(int i2, int i3, boolean z) {
        super(i2, 0.75f, z);
        a(i3);
    }
}
