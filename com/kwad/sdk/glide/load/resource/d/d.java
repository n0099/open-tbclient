package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.s;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.glide.load.g<c> {
    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        return EncodeStrategy.SOURCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull s<c> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        try {
            com.kwad.sdk.glide.g.a.a(sVar.e().c(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
