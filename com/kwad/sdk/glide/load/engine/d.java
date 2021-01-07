package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes5.dex */
class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.a<DataType> f10510a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f10511b;
    private final com.kwad.sdk.glide.load.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f10510a = aVar;
        this.f10511b = datatype;
        this.c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f10510a.a(this.f10511b, file, this.c);
    }
}
