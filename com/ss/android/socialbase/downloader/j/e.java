package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13505a;
    private final b qae;

    public e(InputStream inputStream, int i) {
        this.f13505a = inputStream;
        this.qae = new b(i);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eJp() throws IOException {
        this.qae.f13504b = this.f13505a.read(this.qae.f13503a);
        return this.qae;
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        com.ss.android.socialbase.downloader.m.d.a(this.f13505a);
    }
}
