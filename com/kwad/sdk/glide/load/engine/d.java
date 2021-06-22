package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes7.dex */
public class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.a<DataType> f36305a;

    /* renamed from: b  reason: collision with root package name */
    public final DataType f36306b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36307c;

    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f36305a = aVar;
        this.f36306b = datatype;
        this.f36307c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f36305a.a(this.f36306b, file, this.f36307c);
    }
}
