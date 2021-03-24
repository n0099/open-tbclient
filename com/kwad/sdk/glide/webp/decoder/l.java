package com.kwad.sdk.glide.webp.decoder;

import android.util.Log;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.s;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class l implements com.kwad.sdk.glide.load.g<k> {
    @Override // com.kwad.sdk.glide.load.g
    public EncodeStrategy a(com.kwad.sdk.glide.load.e eVar) {
        return EncodeStrategy.SOURCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(s<k> sVar, File file, com.kwad.sdk.glide.load.e eVar) {
        try {
            com.kwad.sdk.glide.g.a.a(sVar.e().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("WebpEncoder", 5)) {
                Log.w("WebpEncoder", "Failed to encode WebP drawable data", e2);
            }
            return false;
        }
    }
}
