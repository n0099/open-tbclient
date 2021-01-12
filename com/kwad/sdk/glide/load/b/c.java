package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class c implements com.kwad.sdk.glide.load.a<ByteBuffer> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        try {
            com.kwad.sdk.glide.g.a.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e);
                return false;
            }
            return false;
        }
    }
}
