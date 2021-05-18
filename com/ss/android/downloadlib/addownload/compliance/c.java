package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.c;
/* loaded from: classes7.dex */
public class c extends g<Long, c.C1862c> {

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f35876a = new c();
    }

    public static c a() {
        return b.f35876a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1862c c1862c) {
        if (c1862c == null) {
            return;
        }
        put(Long.valueOf(c1862c.a()), c1862c);
    }

    public c.C1862c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1862c a(long j) {
        return get(Long.valueOf(j));
    }
}
