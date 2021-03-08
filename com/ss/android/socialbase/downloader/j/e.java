package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f7865a;
    private final b qiG;

    public e(InputStream inputStream, int i) {
        this.f7865a = inputStream;
        this.qiG = new b(i);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eIE() throws IOException {
        this.qiG.b = this.f7865a.read(this.qiG.f7864a);
        return this.qiG;
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        com.ss.android.socialbase.downloader.m.d.a(this.f7865a);
    }
}
