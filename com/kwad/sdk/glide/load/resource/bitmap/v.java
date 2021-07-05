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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.kwad.sdk.glide.load.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class v<T> implements com.kwad.sdk.glide.load.f<T, Bitmap> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Long> f38253a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Integer> f38254b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f38255c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final c<T> f38256d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38257e;

    /* renamed from: f  reason: collision with root package name */
    public final b f38258f;

    /* loaded from: classes7.dex */
    public static final class a implements c<AssetFileDescriptor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mediaMetadataRetriever, assetFileDescriptor) == null) {
                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public MediaMetadataRetriever a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MediaMetadataRetriever() : (MediaMetadataRetriever) invokeV.objValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public interface c<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* loaded from: classes7.dex */
    public static final class d implements c<ParcelFileDescriptor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.resource.bitmap.v.c
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, mediaMetadataRetriever, parcelFileDescriptor) == null) {
                mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32648952, "Lcom/kwad/sdk/glide/load/resource/bitmap/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32648952, "Lcom/kwad/sdk/glide/load/resource/bitmap/v;");
                return;
            }
        }
        f38253a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new d.a<Long>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final ByteBuffer f38259a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38259a = ByteBuffer.allocate(8);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.load.d.a
            public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, bArr, l, messageDigest) == null) {
                    messageDigest.update(bArr);
                    synchronized (this.f38259a) {
                        this.f38259a.position(0);
                        messageDigest.update(this.f38259a.putLong(l.longValue()).array());
                    }
                }
            }
        });
        f38254b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new d.a<Integer>() { // from class: com.kwad.sdk.glide.load.resource.bitmap.v.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final ByteBuffer f38260a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38260a = ByteBuffer.allocate(4);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.glide.load.d.a
            public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLLL(1048576, this, bArr, num, messageDigest) == null) || num == null) {
                    return;
                }
                messageDigest.update(bArr);
                synchronized (this.f38260a) {
                    this.f38260a.position(0);
                    messageDigest.update(this.f38260a.putInt(num.intValue()).array());
                }
            }
        });
        f38255c = new b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar) {
        this(eVar, cVar, f38255c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((com.kwad.sdk.glide.load.engine.bitmap_recycle.e) objArr2[0], (c) objArr2[1], (b) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public v(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, c<T> cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, cVar, bVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38257e = eVar;
        this.f38256d = cVar;
        this.f38258f = bVar;
    }

    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{mediaMetadataRetriever, Long.valueOf(j), Integer.valueOf(i2)})) == null) ? mediaMetadataRetriever.getFrameAtTime(j, i2) : (Bitmap) invokeCommon.objValue;
    }

    @Nullable
    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{mediaMetadataRetriever, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), downsampleStrategy})) == null) {
            Bitmap b2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f38195f) ? null : b(mediaMetadataRetriever, j, i2, i3, i4, downsampleStrategy);
            return b2 == null ? a(mediaMetadataRetriever, j, i2) : b2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static com.kwad.sdk.glide.load.f<AssetFileDescriptor, Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, eVar)) == null) ? new v(eVar, new a()) : (com.kwad.sdk.glide.load.f) invokeL.objValue;
    }

    @TargetApi(27)
    public static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{mediaMetadataRetriever, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), downsampleStrategy})) == null) {
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
        return (Bitmap) invokeCommon.objValue;
    }

    public static com.kwad.sdk.glide.load.f<ParcelFileDescriptor, Bitmap> b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eVar)) == null) ? new v(eVar, new d()) : (com.kwad.sdk.glide.load.f) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.f
    public com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{t, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            long longValue = ((Long) eVar.a(f38253a)).longValue();
            if (longValue < 0 && longValue != -1) {
                throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
            }
            Integer num = (Integer) eVar.a(f38254b);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.a(DownsampleStrategy.f38197h);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.f38196g;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever a2 = this.f38258f.a();
            try {
                try {
                    this.f38256d.a(a2, t);
                    Bitmap a3 = a(a2, longValue, num.intValue(), i2, i3, downsampleStrategy2);
                    a2.release();
                    return com.kwad.sdk.glide.load.resource.bitmap.d.a(a3, this.f38257e);
                } catch (RuntimeException e2) {
                    throw new IOException(e2);
                }
            } catch (Throwable th) {
                a2.release();
                throw th;
            }
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeCommon.objValue;
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull T t, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, eVar)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }
}
