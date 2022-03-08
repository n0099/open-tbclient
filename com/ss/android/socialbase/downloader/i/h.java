package com.ss.android.socialbase.downloader.i;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class h<K, T> extends LinkedHashMap<K, T> {
    public int a;

    public h() {
        this(4, 4);
    }

    public void a(int i2) {
        this.a = i2;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.a;
    }

    public h(int i2, int i3) {
        this(i2, i3, true);
    }

    public h(int i2, int i3, boolean z) {
        super(i2, 0.75f, z);
        a(i3);
    }
}
