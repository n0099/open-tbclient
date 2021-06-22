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
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.kwad.sdk.glide.load.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class v<T> implements com.kwad.sdk.glide.load.f<T, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Long> f36490a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new d.a<Long>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.1

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f36496a = ByteBuffer.allocate(8);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f36496a) {
                this.f36496a.position(0);
                messageDigest.update(this.f36496a.putLong(l.longValue()).array());
            }
        }
    });

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f36491b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new d.a<Integer>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.2

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f36497a = ByteBuffer.allocate(4);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.d.a
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f36497a) {
                this.f36497a.position(0);
                messageDigest.update(this.f36497a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: c  reason: collision with root package name */
    public static final b f36492c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final c<T> f36493d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f36494e;

    /* renamed from: f  reason: collision with root package name */
    public final b f36495f;

    /* loaded from: classes7.dex */
    public static final class a implements c<AssetFileDescriptor> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* loaded from: classes7.dex */
    public static final class d implements c<ParcelFileDescriptor> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar) {
        this(eVar, cVar, f36492c);
    }

    @VisibleForTesting
    public v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar, b bVar) {
        this.f36494e = eVar;
        this.f36493d = cVar;
        this.f36495f = bVar;
    }

    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j, i2);
    }

    @Nullable
    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f36432f) ? null : b(mediaMetadataRetriever, j, i2, i3, i4, downsampleStrategy);
        return b2 == null ? a(mediaMetadataRetriever, j, i2) : b2;
    }

    public static com.kwad.sdk.glide.load.f<AssetFileDescriptor, Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new v(eVar, new a());
    }

    @TargetApi(27)
    public static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float a2 = downsampleStrategy.a(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i2, Math.round(parseInt * a2), Math.round(a2 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable(VideoDecoder.TAG, 3)) {
                Log.d(VideoDecoder.TAG, "Exception trying to decode frame on oreo+", th);
                return null;
            }
            return null;
        }
    }

    public static com.kwad.sdk.glide.load.f<ParcelFileDescriptor, Bitmap> b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        return new v(eVar, new d());
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        long longValue = ((Long) eVar.a(f36490a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) eVar.a(f36491b);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.a(DownsampleStrategy.f36434h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f36433g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a2 = this.f36495f.a();
        try {
            try {
                this.f36493d.a(a2, t);
                Bitmap a3 = a(a2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                a2.release();
                return com.kwad.sdk.glide.load.resource.bitmap.d.a(a3, this.f36494e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull T t, @NonNull com.kwad.sdk.glide.load.e eVar) {
        return true;
    }
}
