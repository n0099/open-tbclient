package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.c;
/* loaded from: classes7.dex */
public class c extends g<Long, c.C1929c> {

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f39587a = new c();
    }

    public static c a() {
        return b.f39587a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1929c c1929c) {
        if (c1929c == null) {
            return;
        }
        put(Long.valueOf(c1929c.a()), c1929c);
    }

    public c.C1929c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1929c a(long j) {
        return get(Long.valueOf(j));
    }
}
