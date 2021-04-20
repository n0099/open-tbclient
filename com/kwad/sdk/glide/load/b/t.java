package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.StreamEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class t implements com.kwad.sdk.glide.load.a<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f35654a;

    public t(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f35654a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        byte[] bArr = (byte[]) this.f35654a.a(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable(StreamEncoder.TAG, 3)) {
                                Log.d(StreamEncoder.TAG, "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f35654a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f35654a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e3) {
                e = e3;
            }
            this.f35654a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
