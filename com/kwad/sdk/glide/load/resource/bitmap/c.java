package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.kwad.sdk.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.glide.load.g<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f36445a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Bitmap.CompressFormat> f36446b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36447c;

    @Deprecated
    public c() {
        this.f36447c = null;
    }

    public c(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this.f36447c = bVar;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.kwad.sdk.glide.load.e eVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) eVar.a(f36446b);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r6 != null) goto L14;
     */
    @Override // com.kwad.sdk.glide.load.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        FileOutputStream fileOutputStream;
        Bitmap e2 = sVar.e();
        Bitmap.CompressFormat a2 = a(e2, eVar);
        com.kwad.sdk.glide.g.a.b.a("encode: [%dx%d] %s", Integer.valueOf(e2.getWidth()), Integer.valueOf(e2.getHeight()), a2);
        try {
            long a3 = com.kwad.sdk.glide.g.f.a();
            int intValue = ((Integer) eVar.a(f36445a)).intValue();
            boolean z = false;
            com.kwad.sdk.glide.load.a.c cVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                cVar = this.f36447c != null ? new com.kwad.sdk.glide.load.a.c(fileOutputStream, this.f36447c) : fileOutputStream;
                e2.compress(a2, intValue, cVar);
                cVar.close();
                z = true;
            } catch (IOException e4) {
                e = e4;
                cVar = fileOutputStream;
                if (Log.isLoggable(BitmapEncoder.TAG, 3)) {
                    Log.d(BitmapEncoder.TAG, "Failed to encode Bitmap", e);
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                cVar.close();
            } catch (IOException unused2) {
                if (Log.isLoggable(BitmapEncoder.TAG, 2)) {
                    Log.v(BitmapEncoder.TAG, "Compressed with type: " + a2 + " of size " + com.kwad.sdk.glide.g.k.a(e2) + " in " + com.kwad.sdk.glide.g.f.a(a3) + ", options format: " + eVar.a(f36446b) + ", hasAlpha: " + e2.hasAlpha());
                }
                return z;
            }
        } finally {
            com.kwad.sdk.glide.g.a.b.a();
        }
    }
}
