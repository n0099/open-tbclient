package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f13506a;
    private final b qbM;

    public e(InputStream inputStream, int i) {
        this.f13506a = inputStream;
        this.qbM = new b(i);
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public b eJT() throws IOException {
        this.qbM.f13505b = this.f13506a.read(this.qbM.f13504a);
        return this.qbM;
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void a(b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.j.c
    public void b() {
        com.ss.android.socialbase.downloader.m.d.a(this.f13506a);
    }
}
