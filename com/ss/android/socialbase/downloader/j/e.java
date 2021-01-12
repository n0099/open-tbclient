package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13206a;
    private final b pXl;

    public e(InputStream inputStream, int i) {
        this.f13206a = inputStream;
        this.pXl = new b(i);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eGd() throws IOException {
        this.pXl.f13205b = this.f13206a.read(this.pXl.f13204a);
        return this.pXl;
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        com.ss.android.socialbase.downloader.m.d.a(this.f13206a);
    }
}
