package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.i.h;
/* loaded from: classes3.dex */
public class c extends h<Long, com.ss.android.downloadlib.addownload.b.b> {

    /* loaded from: classes3.dex */
    public static class a {
        public static c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public c() {
        super(16, 16);
    }

    public void a(com.ss.android.downloadlib.addownload.b.b bVar) {
        if (bVar == null) {
            return;
        }
        put(Long.valueOf(bVar.a()), bVar);
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j2, long j3) {
        return get(get(Long.valueOf(j2)) != null ? Long.valueOf(j2) : Long.valueOf(j3));
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j2) {
        return get(Long.valueOf(j2));
    }
}
