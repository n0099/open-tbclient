package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes4.dex */
class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.a<DataType> f10210a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f10211b;
    private final com.kwad.sdk.glide.load.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f10210a = aVar;
        this.f10211b = datatype;
        this.c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f10210a.a(this.f10211b, file, this.c);
    }
}
