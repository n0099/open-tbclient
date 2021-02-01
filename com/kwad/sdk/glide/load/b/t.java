package com.kwad.sdk.glide.load.b;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class t implements com.kwad.sdk.glide.load.a<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f10122a;

    public t(com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f10122a = bVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0062 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Class<byte[]>, java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream] */
    @Override // com.kwad.sdk.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        FileOutputStream fileOutputStream;
        ?? r3 = byte[].class;
        byte[] bArr = (byte[]) this.f10122a.a(65536, (Class<Object>) r3);
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.f10122a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                        return false;
                    }
                }
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                this.f10122a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                return true;
            } catch (Throwable th) {
                th = th;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e4) {
                    }
                }
                this.f10122a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
            if (r3 != 0) {
            }
            this.f10122a.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
            throw th;
        }
    }
}
