package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes7.dex */
public class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.a<DataType> f36207a;

    /* renamed from: b  reason: collision with root package name */
    public final DataType f36208b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f36209c;

    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f36207a = aVar;
        this.f36208b = datatype;
        this.f36209c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f36207a.a(this.f36208b, file, this.f36209c);
    }
}
