package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import java.io.IOException;
/* loaded from: classes3.dex */
public class h implements e {
    public final e a;

    /* renamed from: b  reason: collision with root package name */
    public final e f60022b;

    public h(e eVar, e eVar2) {
        this.a = eVar;
        this.f60022b = eVar2;
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) throws IOException {
        aVar.f60001b = this.f60022b;
        this.a.b(aVar);
    }
}
