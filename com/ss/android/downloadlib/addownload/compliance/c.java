package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.c;
/* loaded from: classes6.dex */
public class c extends g<Long, c.C1823c> {

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f38661a = new c();
    }

    public static c a() {
        return b.f38661a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1823c c1823c) {
        if (c1823c == null) {
            return;
        }
        put(Long.valueOf(c1823c.a()), c1823c);
    }

    public c.C1823c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1823c a(long j) {
        return get(Long.valueOf(j));
    }
}
