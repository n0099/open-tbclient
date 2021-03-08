package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class c implements com.kwad.sdk.glide.load.g<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f6785a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.kwad.sdk.glide.load.d<Bitmap.CompressFormat> b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    @Nullable
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b c;

    @Deprecated
    public c() {
        this.c = null;
    }

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.c = bVar;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.kwad.sdk.glide.load.e eVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.a(b);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059 A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #7 {all -> 0x00de, blocks: (B:3:0x0020, B:12:0x004c, B:13:0x004f, B:15:0x0059, B:31:0x00da, B:32:0x00dd, B:24:0x00cc), top: B:54:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.kwad.sdk.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        OutputStream outputStream;
        boolean z;
        Bitmap e = sVar.e();
        Bitmap.CompressFormat a2 = a(e, eVar);
        com.kwad.sdk.glide.g.a.b.a("encode: [%dx%d] %s", Integer.valueOf(e.getWidth()), Integer.valueOf(e.getHeight()), a2);
        try {
            long a3 = com.kwad.sdk.glide.g.f.a();
            int intValue = ((Integer) eVar.a(f6785a)).intValue();
            try {
                outputStream = new FileOutputStream(file);
                try {
                    try {
                        if (this.c != null) {
                            outputStream = new com.kwad.sdk.glide.load.a.c(outputStream, this.c);
                        }
                        e.compress(a2, intValue, outputStream);
                        outputStream.close();
                        z = true;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                                z = false;
                            } catch (IOException e4) {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (Log.isLoggable("BitmapEncoder", 2)) {
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                if (outputStream != null) {
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + a2 + " of size " + com.kwad.sdk.glide.g.k.a(e) + " in " + com.kwad.sdk.glide.g.f.a(a3) + ", options format: " + eVar.a(b) + ", hasAlpha: " + e.hasAlpha());
            }
            return z;
        } finally {
            com.kwad.sdk.glide.g.a.b.a();
        }
    }
}
