package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes3.dex */
class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.a<DataType> f6752a;
    private final DataType b;
    private final com.kwad.sdk.glide.load.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f6752a = aVar;
        this.b = datatype;
        this.c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f6752a.a(this.b, file, this.c);
    }
}
