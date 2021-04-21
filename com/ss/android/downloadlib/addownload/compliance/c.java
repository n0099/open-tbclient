package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.p.a.d.f.c;
/* loaded from: classes6.dex */
public class c extends g<Long, c.C1863c> {

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f39046a = new c();
    }

    public static c a() {
        return b.f39046a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1863c c1863c) {
        if (c1863c == null) {
            return;
        }
        put(Long.valueOf(c1863c.a()), c1863c);
    }

    public c.C1863c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1863c a(long j) {
        return get(Long.valueOf(j));
    }
}
