package com.kwad.sdk.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class j implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f35662a = DefaultImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f35663b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes6.dex */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f35664a;

        public a(ByteBuffer byteBuffer) {
            this.f35664a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            return ((c() << 8) & 65280) | (c() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f35664a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f35664a.get(bArr, 0, min);
            return min;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public long a(long j) {
            int min = (int) Math.min(this.f35664a.remaining(), j);
            ByteBuffer byteBuffer = this.f35664a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            return (short) (c() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            if (this.f35664a.remaining() < 1) {
                return -1;
            }
            return this.f35664a.get();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f35665a;

        public b(byte[] bArr, int i) {
            this.f35665a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean a(int i, int i2) {
            return this.f35665a.remaining() - i >= i2;
        }

        public int a() {
            return this.f35665a.remaining();
        }

        public int a(int i) {
            if (a(i, 4)) {
                return this.f35665a.getInt(i);
            }
            return -1;
        }

        public void a(ByteOrder byteOrder) {
            this.f35665a.order(byteOrder);
        }

        public short b(int i) {
            if (a(i, 2)) {
                return this.f35665a.getShort(i);
            }
            return (short) -1;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        int a();

        int a(byte[] bArr, int i);

        long a(long j);

        short b();

        int c();
    }

    /* loaded from: classes6.dex */
    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f35666a;

        public d(InputStream inputStream) {
            this.f35666a = inputStream;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            return ((this.f35666a.read() << 8) & 65280) | (this.f35666a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f35666a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f35666a.skip(j2);
                if (skip <= 0) {
                    if (this.f35666a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            return (short) (this.f35666a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            return this.f35666a.read();
        }
    }

    public static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public static int a(b bVar) {
        ByteOrder byteOrder;
        StringBuilder sb;
        String str;
        String sb2;
        short b2 = bVar.b(6);
        if (b2 != 18761) {
            if (b2 != 19789 && Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Unknown endianness = " + ((int) b2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i = 0; i < b3; i++) {
            int a3 = a(a2, i);
            short b4 = bVar.b(a3);
            if (b4 == 274) {
                short b5 = bVar.b(a3 + 2);
                if (b5 >= 1 && b5 <= 12) {
                    int a4 = bVar.a(a3 + 4);
                    if (a4 >= 0) {
                        if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                            Log.d(DefaultImageHeaderParser.TAG, "Got tagIndex=" + i + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                        }
                        int i2 = a4 + f35663b[b5];
                        if (i2 <= 4) {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > bVar.a()) {
                                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                    sb2 = "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) b4);
                                    Log.d(DefaultImageHeaderParser.TAG, sb2);
                                }
                            } else if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                return bVar.b(i3);
                            } else {
                                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                                    sb = new StringBuilder();
                                    sb.append("Illegal number of bytes for TI tag data tagType=");
                                    sb.append((int) b4);
                                }
                            }
                        } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                            sb = new StringBuilder();
                            str = "Got byte count > 4, not orientation, continuing, formatCode=";
                            sb.append(str);
                            sb.append((int) b5);
                        }
                    } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                        sb2 = "Negative tiff component count";
                        Log.d(DefaultImageHeaderParser.TAG, sb2);
                    }
                } else if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    sb = new StringBuilder();
                    str = "Got invalid format code = ";
                    sb.append(str);
                    sb.append((int) b5);
                }
                sb2 = sb.toString();
                Log.d(DefaultImageHeaderParser.TAG, sb2);
            }
        }
        return -1;
    }

    private int a(c cVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        int a2 = cVar.a();
        if (!a(a2)) {
            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Parser doesn't handle magic number: " + a2);
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.a(b2, byte[].class);
        try {
            return a(cVar, bArr, b2);
        } finally {
            bVar.a((com.kwad.sdk.glide.load.engine.bitmap_recycle.b) bArr);
        }
    }

    private int a(c cVar, byte[] bArr, int i) {
        int a2 = cVar.a(bArr, i);
        if (a2 == i) {
            if (a(bArr, i)) {
                return a(new b(bArr, i));
            }
            if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                Log.d(DefaultImageHeaderParser.TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
            Log.d(DefaultImageHeaderParser.TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
        }
        return -1;
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & (-65536)) | (cVar.a() & 65535);
        if (a3 == -1991225785) {
            cVar.a(21L);
            return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((a3 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (a3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.a(4L);
            if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535);
            if ((a4 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = a4 & 255;
            if (i == 88) {
                cVar.a(4L);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i == 76) {
                cVar.a(4L);
                return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    public static boolean a(int i) {
        return (i & DefaultImageHeaderParser.EXIF_MAGIC_NUMBER) == 65496 || i == 19789 || i == 18761;
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f35662a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f35662a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    return false;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    private int b(c cVar) {
        short b2;
        short b3;
        int a2;
        long j;
        long a3;
        do {
            if (cVar.b() != 255) {
                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Unknown segmentId=" + ((int) b2));
                }
                return -1;
            }
            b3 = cVar.b();
            if (b3 == 218) {
                return -1;
            }
            if (b3 == 217) {
                if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
                    Log.d(DefaultImageHeaderParser.TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b3 == 225) {
                return a2;
            }
            j = a2;
            a3 = cVar.a(j);
        } while (a3 == j);
        if (Log.isLoggable(DefaultImageHeaderParser.TAG, 3)) {
            Log.d(DefaultImageHeaderParser.TAG, "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        return a(new d((InputStream) com.kwad.sdk.glide.g.j.a(inputStream)), (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) com.kwad.sdk.glide.g.j.a(bVar));
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull InputStream inputStream) {
        return a(new d((InputStream) com.kwad.sdk.glide.g.j.a(inputStream)));
    }

    @Override // com.kwad.sdk.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        return a(new a((ByteBuffer) com.kwad.sdk.glide.g.j.a(byteBuffer)));
    }
}
