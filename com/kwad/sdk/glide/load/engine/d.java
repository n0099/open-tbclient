package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes6.dex */
public class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.a<DataType> f35520a;

    /* renamed from: b  reason: collision with root package name */
    public final DataType f35521b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f35522c;

    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f35520a = aVar;
        this.f35521b = datatype;
        this.f35522c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f35520a.a(this.f35521b, file, this.f35522c);
    }
}
