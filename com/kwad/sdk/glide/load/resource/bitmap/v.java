package com.kwad.sdk.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.kwad.sdk.glide.load.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public class v<T> implements com.kwad.sdk.glide.load.f<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Long> f10301a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new d.a<Long>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.1

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10303a = ByteBuffer.allocate(8);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f10303a) {
                this.f10303a.position(0);
                messageDigest.update(this.f10303a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f10302b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new d.a<Integer>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.2

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10304a = ByteBuffer.allocate(4);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f10304a) {
                this.f10304a.position(0);
                messageDigest.update(this.f10304a.putInt(num.intValue()).array());
            }
        }
    });
    private static final b c = new b();
    private final c<T> d;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.e e;
    private final b f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements c<AssetFileDescriptor> {
        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    static class b {
        b() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class d implements c<ParcelFileDescriptor> {
        d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar) {
        this(eVar, cVar, c);
    }

    @VisibleForTesting
    v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar, b bVar) {
        this.e = eVar;
        this.d = cVar;
        this.f = bVar;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f) {
            bitmap = b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        }
        return bitmap == null ? a(mediaMetadataRetriever, j, i) : bitmap;
    }

    public static com.kwad.sdk.glide.load.f<AssetFileDescriptor, Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new v(eVar, new a());
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        int i4;
        int i5;
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                i4 = parseInt;
                i5 = parseInt2;
            } else {
                i4 = parseInt2;
                i5 = parseInt;
            }
            float a2 = downsampleStrategy.a(i5, i4, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i5 * a2), Math.round(i4 * a2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            }
            return null;
        }
    }

    public static com.kwad.sdk.glide.load.f<ParcelFileDescriptor, Bitmap> b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new v(eVar, new d());
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull T t, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        long longValue = ((Long) eVar.a(f10301a)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) eVar.a(f10302b);
            Integer num2 = num == null ? 2 : num;
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.a(DownsampleStrategy.h);
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy == null ? DownsampleStrategy.g : downsampleStrategy;
            MediaMetadataRetriever a2 = this.f.a();
            try {
                try {
                    this.d.a(a2, t);
                    Bitmap a3 = a(a2, longValue, num2.intValue(), i, i2, downsampleStrategy2);
                    a2.release();
                    return com.kwad.sdk.glide.load.resource.bitmap.d.a(a3, this.e);
                } catch (RuntimeException e) {
                    throw new IOException(e);
                }
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        }
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull T t, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return true;
    }
}
