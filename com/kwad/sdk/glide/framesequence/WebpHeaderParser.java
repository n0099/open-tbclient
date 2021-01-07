package com.kwad.sdk.glide.framesequence;

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
    public static final boolean f10286a = a();

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
    private static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10287a;

        a(ByteBuffer byteBuffer) {
            this.f10287a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int a() {
            return ((b() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b() & 255);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public long a(long j) {
            int min = (int) Math.min(this.f10287a.remaining(), j);
            this.f10287a.position(this.f10287a.position() + min);
            return min;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int b() {
            if (this.f10287a.remaining() < 1) {
                return -1;
            }
            return this.f10287a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface b {
        int a();

        long a(long j);

        int b();
    }

    /* loaded from: classes5.dex */
    private static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10288a;

        c(InputStream inputStream) {
            this.f10288a = inputStream;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int a() {
            return ((this.f10288a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f10288a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f10288a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f10288a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        @Override // com.kwad.sdk.glide.framesequence.WebpHeaderParser.b
        public int b() {
            return this.f10288a.read();
        }
    }

    private static WebpImageType a(b bVar) {
        if ((((bVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.a() & SupportMenu.USER_MASK)) != 1380533830) {
            return WebpImageType.NONE_WEBP;
        }
        bVar.a(4L);
        if ((((bVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.a() & SupportMenu.USER_MASK)) != 1464156752) {
            return WebpImageType.NONE_WEBP;
        }
        int a2 = ((bVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (bVar.a() & SupportMenu.USER_MASK);
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
        return webpImageType == WebpImageType.WEBP_EXTENDED_ANIMATED;
    }
}
