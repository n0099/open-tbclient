package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes5.dex */
class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.a<DataType> f10509a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f10510b;
    private final com.kwad.sdk.glide.load.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f10509a = aVar;
        this.f10510b = datatype;
        this.c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f10509a.a(this.f10510b, file, this.c);
    }
}
