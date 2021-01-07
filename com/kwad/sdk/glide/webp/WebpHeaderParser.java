package com.kwad.sdk.glide.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
public class WebpHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10656a = a();

    /* loaded from: classes5.dex */
    public enum WebpImageType {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);
        
        private final boolean hasAlpha;
        private final boolean hasAnimation;

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

    /* loaded from: classes5.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f10657a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10658b;
        private final int c;
        private int d;

        a(byte[] bArr, int i, int i2) {
            this.f10657a = bArr;
            this.f10658b = i;
            this.c = i2;
            this.d = i;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            return ((b() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b() & 255);
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            int min = (int) Math.min((this.f10658b + this.c) - this.d, j);
            this.d += min;
            return min;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            if (this.d >= this.f10658b + this.c) {
                return -1;
            }
            byte[] bArr = this.f10657a;
            int i = this.d;
            this.d = i + 1;
            return bArr[i];
        }
    }

    /* loaded from: classes5.dex */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10659a;

        b(ByteBuffer byteBuffer) {
            this.f10659a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            return ((b() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b() & 255);
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            int min = (int) Math.min(this.f10659a.remaining(), j);
            this.f10659a.position(this.f10659a.position() + min);
            return min;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            if (this.f10659a.remaining() < 1) {
                return -1;
            }
            return this.f10659a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface c {
        int a();

        long a(long j);

        int b();
    }

    /* loaded from: classes5.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10660a;

        d(InputStream inputStream) {
            this.f10660a = inputStream;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int a() {
            return ((this.f10660a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f10660a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f10660a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f10660a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        @Override // com.kwad.sdk.glide.webp.WebpHeaderParser.c
        public int b() {
            return this.f10660a.read();
        }
    }

    private static WebpImageType a(c cVar) {
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK)) != 1380533830) {
            return WebpImageType.NONE_WEBP;
        }
        cVar.a(4L);
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK)) != 1464156752) {
            return WebpImageType.NONE_WEBP;
        }
        int a2 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK);
        if (a2 == 1448097824) {
            return WebpImageType.WEBP_SIMPLE;
        }
        if (a2 == 1448097868) {
            cVar.a(4L);
            return (cVar.b() & 8) != 0 ? WebpImageType.WEBP_LOSSLESS_WITH_ALPHA : WebpImageType.WEBP_LOSSLESS;
        } else if (a2 == 1448097880) {
            cVar.a(4L);
            int b2 = cVar.b();
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
            return a(new d((InputStream) j.a(inputStream)));
        } finally {
            inputStream.reset();
        }
    }

    public static WebpImageType a(ByteBuffer byteBuffer) {
        return byteBuffer == null ? WebpImageType.NONE_WEBP : a(new b((ByteBuffer) j.a(byteBuffer)));
    }

    public static WebpImageType a(byte[] bArr, int i, int i2) {
        return a(new a(bArr, i, i2));
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (Build.VERSION.SDK_INT == 17) {
            byte[] decode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
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
        return webpImageType == WebpImageType.WEBP_SIMPLE || webpImageType == WebpImageType.WEBP_LOSSLESS || webpImageType == WebpImageType.WEBP_LOSSLESS_WITH_ALPHA || webpImageType == WebpImageType.WEBP_EXTENDED || webpImageType == WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
    }

    public static boolean b(WebpImageType webpImageType) {
        return (webpImageType == WebpImageType.NONE_WEBP || webpImageType == WebpImageType.WEBP_SIMPLE) ? false : true;
    }

    public static boolean c(WebpImageType webpImageType) {
        return webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }
}
