package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.g;
import d.o.a.d.f.c;
/* loaded from: classes6.dex */
public class c extends g<Long, c.C1859c> {

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f38951a = new c();
    }

    public static c a() {
        return b.f38951a;
    }

    public c() {
        super(16, 16);
    }

    public void a(c.C1859c c1859c) {
        if (c1859c == null) {
            return;
        }
        put(Long.valueOf(c1859c.a()), c1859c);
    }

    public c.C1859c a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public c.C1859c a(long j) {
        return get(Long.valueOf(j));
    }
}
