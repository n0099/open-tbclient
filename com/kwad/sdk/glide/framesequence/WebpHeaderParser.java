package com.kwad.sdk.glide.framesequence;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import com.facebook.common.webp.WebpSupportStatus;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public class WebpHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35555a = a();

    /* loaded from: classes6.dex */
    public enum WebpImageType {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);
        
        public final boolean hasAlpha;
        public final boolean hasAnimation;

        WebpImageType(boolean z, boolean z2) {
            this.hasAlpha = z;
            this.hasAnimation = z2;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean hasAnimation() {
            return this.hasAnimation;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f35556a;

        public a(ByteBuffer byteBuffer) {
            this.f35556a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int a() {
            return ((b() << 8) & 65280) | (b() & 255);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public long a(long j) {
            int min = (int) Math.min(this.f35556a.remaining(), j);
            ByteBuffer byteBuffer = this.f35556a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int b() {
            if (this.f35556a.remaining() < 1) {
                return -1;
            }
            return this.f35556a.get();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        int a();

        long a(long j);

        int b();
    }

    /* loaded from: classes6.dex */
    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f35557a;

        public c(InputStream inputStream) {
            this.f35557a = inputStream;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int a() {
            return ((this.f35557a.read() << 8) & 65280) | (this.f35557a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f35557a.skip(j2);
                if (skip <= 0) {
                    if (this.f35557a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int b() {
            return this.f35557a.read();
        }
    }

    public static WebpImageType a(b bVar) {
        if ((((bVar.a() << 16) & (-65536)) | (bVar.a() & 65535)) != 1380533830) {
            return WebpImageType.NONE_WEBP;
        }
        bVar.a(4L);
        if ((((bVar.a() << 16) & (-65536)) | (bVar.a() & 65535)) != 1464156752) {
            return WebpImageType.NONE_WEBP;
        }
        int a2 = ((bVar.a() << 16) & (-65536)) | (bVar.a() & 65535);
        if (a2 == 1448097824) {
            return WebpImageType.WEBP_SIMPLE;
        }
        if (a2 == 1448097868) {
            bVar.a(4L);
            return (bVar.b() & 8) != 0 ? WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpImageType.WEBP_LOSSLESS;
        } else if (a2 == 1448097880) {
            bVar.a(4L);
            int b2 = bVar.b();
            return (b2 & 2) != 0 ? WebpImageType.WEBP_EXTENDED_ANIMATED : (b2 & 16) != 0 ? WebpImageType.WEBP_EXTENDED_WITH_ALPHA : WebpImageType.WEBP_EXTENDED;
        } else {
            return WebpImageType.NONE_WEBP;
        }
    }

    public static WebpImageType a(InputStream inputStream, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        if (inputStream == null) {
            return WebpImageType.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(21);
        try {
            return a(new c((InputStream) j.a(inputStream)));
        } finally {
            inputStream.reset();
        }
    }

    public static WebpImageType a(ByteBuffer byteBuffer) {
        return byteBuffer == null ? WebpImageType.NONE_WEBP : a(new a((ByteBuffer) j.a(byteBuffer)));
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i < 17) {
            return false;
        }
        if (i == 17) {
            byte[] decode = Base64.decode(WebpSupportStatus.VP8X_WEBP_BASE64, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }
}
