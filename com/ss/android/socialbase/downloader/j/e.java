package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13208a;
    private final b qhQ;

    public e(InputStream inputStream, int i) {
        this.f13208a = inputStream;
        this.qhQ = new b(i);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eIC() throws IOException {
        this.qhQ.f13207b = this.f13208a.read(this.qhQ.f13206a);
        return this.qhQ;
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        com.ss.android.socialbase.downloader.m.d.a(this.f13208a);
    }
}
