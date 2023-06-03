package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.h;
/* loaded from: classes10.dex */
public class c extends h<Long, com.ss.android.downloadlib.addownload.b.b> {

    /* loaded from: classes10.dex */
    public static class a {
        public static c a = new c();
    }

    public c() {
        super(16, 16);
    }

    public static c a() {
        return a.a;
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j) {
        return get(Long.valueOf(j));
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j, long j2) {
        Long valueOf;
        if (get(Long.valueOf(j)) != null) {
            valueOf = Long.valueOf(j);
        } else {
            valueOf = Long.valueOf(j2);
        }
        return get(valueOf);
    }

    public void a(com.ss.android.downloadlib.addownload.b.b bVar) {
        if (bVar == null) {
            return;
        }
        put(Long.valueOf(bVar.a()), bVar);
    }
}
