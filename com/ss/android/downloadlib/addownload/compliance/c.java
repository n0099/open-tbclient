package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.c;
/* loaded from: classes6.dex */
public class c extends g<Long, c.C1798c> {

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f36631a = new c();
    }

    public static c a() {
        return b.f36631a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1798c c1798c) {
        if (c1798c == null) {
            return;
        }
        put(Long.valueOf(c1798c.a()), c1798c);
    }

    public c.C1798c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1798c a(long j) {
        return get(Long.valueOf(j));
    }
}
