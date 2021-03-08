package com.ss.android.socialbase.downloader.m;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class f<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: a  reason: collision with root package name */
    private int f7892a;

    public f() {
        this(4, 4);
    }

    public f(int i, int i2) {
        super(i, 0.75f, true);
        a(i2);
    }

    public void a(int i) {
        this.f7892a = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f7892a;
    }
}
