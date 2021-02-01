package com.kwad.sdk.glide.webp;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.Registry;
/* loaded from: classes3.dex */
public final class a extends com.kwad.sdk.glide.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f10363a = new f();

    public a() {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.kwad.sdk.glide.samples.webp.WebpModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.framesequence.FsGlideLibraryModule");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.kwad.sdk.glide.webp.WebpGlideLibraryModule");
        }
    }

    @Override // com.kwad.sdk.glide.d.b
    public void a(@NonNull Context context, @NonNull com.kwad.sdk.glide.c cVar, @NonNull Registry registry) {
        new com.kwad.sdk.glide.framesequence.f().a(context, cVar, registry);
        new d().a(context, cVar, registry);
        this.f10363a.a(context, cVar, registry);
    }

    @Override // com.kwad.sdk.glide.d.a
    public void a(@NonNull Context context, @NonNull com.kwad.sdk.glide.d dVar) {
        this.f10363a.a(context, dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.a
    @NonNull
    /* renamed from: b */
    public b a() {
        return new b();
    }
}
