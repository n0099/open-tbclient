package com.kwad.sdk.glide.load.engine;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes6.dex */
public class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.a<DataType> f35809a;

    /* renamed from: b  reason: collision with root package name */
    public final DataType f35810b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.e f35811c;

    public d(com.kwad.sdk.glide.load.a<DataType> aVar, DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        this.f35809a = aVar;
        this.f35810b = datatype;
        this.f35811c = eVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.b
    public boolean a(@NonNull File file) {
        return this.f35809a.a(this.f35810b, file, this.f35811c);
    }
}
