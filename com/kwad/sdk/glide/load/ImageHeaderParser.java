package com.kwad.sdk.glide.load;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public interface ImageHeaderParser {

    /* loaded from: classes5.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar);

    @NonNull
    ImageType a(@NonNull InputStream inputStream);

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer);
}
