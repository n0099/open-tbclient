package com.ss.android.socialbase.downloader.e;

import com.ss.android.socialbase.downloader.i.f;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class c implements b {
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.f.a f58559b;

    public c(InputStream inputStream, int i2) {
        this.a = inputStream;
        this.f58559b = new com.ss.android.socialbase.downloader.f.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws IOException {
        com.ss.android.socialbase.downloader.f.a aVar = this.f58559b;
        aVar.f58564c = this.a.read(aVar.a);
        return this.f58559b;
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        f.a(this.a);
    }
}
