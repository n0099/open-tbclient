package com.kwad.sdk.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public final class j implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f10278a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f10279b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes4.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10280a;

        a(ByteBuffer byteBuffer) {
            this.f10280a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            return ((c() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (c() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f10280a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f10280a.get(bArr, 0, min);
            return min;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public long a(long j) {
            int min = (int) Math.min(this.f10280a.remaining(), j);
            this.f10280a.position(this.f10280a.position() + min);
            return min;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            return (short) (c() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            if (this.f10280a.remaining() < 1) {
                return -1;
            }
            return this.f10280a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10281a;

        b(byte[] bArr, int i) {
            this.f10281a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean a(int i, int i2) {
            return this.f10281a.remaining() - i >= i2;
        }

        int a() {
            return this.f10281a.remaining();
        }

        int a(int i) {
            if (a(i, 4)) {
                return this.f10281a.getInt(i);
            }
            return -1;
        }

        void a(ByteOrder byteOrder) {
            this.f10281a.order(byteOrder);
        }

        short b(int i) {
            if (a(i, 2)) {
                return this.f10281a.getShort(i);
            }
            return (short) -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface c {
        int a();

        int a(byte[] bArr, int i);

        long a(long j);

        short b();

        int c();
    }

    /* loaded from: classes4.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f10282a;

        d(InputStream inputStream) {
            this.f10282a = inputStream;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a() {
            return ((this.f10282a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f10282a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int a(byte[] bArr, int i) {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f10282a.read(bArr, i - i2, i2);
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
                long skip = this.f10282a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f10282a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public short b() {
            return (short) (this.f10282a.read() & 255);
        }

        @Override // com.kwad.sdk.glide.load.resource.bitmap.j.c
        public int c() {
            return this.f10282a.read();
        }
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short b2 = bVar.b(length);
        switch (b2) {
            case 18761:
                byteOrder = ByteOrder.LITTLE_ENDIAN;
                break;
            case 19789:
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
            default:
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) b2));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
                break;
        }
        bVar.a(byteOrder);
        int a2 = length + bVar.a(length + 4);
        short b3 = bVar.b(a2);
        for (int i = 0; i < b3; i++) {
            int a3 = a(a2, i);
            short b4 = bVar.b(a3);
            if (b4 == 274) {
                short b5 = bVar.b(a3 + 2);
                if (b5 >= 1 && b5 <= 12) {
                    int a4 = bVar.a(a3 + 4);
                    if (a4 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) b4) + " formatCode=" + ((int) b5) + " componentCount=" + a4);
                        }
                        int i2 = a4 + f10279b[b5];
                        if (i2 <= 4) {
                            int i3 = a3 + 8;
                            if (i3 < 0 || i3 > bVar.a()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) b4));
                                }
                            } else if (i2 >= 0 && i3 + i2 <= bVar.a()) {
                                return bVar.b(i3);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) b4));
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) b5));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) b5));
                }
            }
        }
        return -1;
    }

    private int a(c cVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        int a2 = cVar.a();
        if (!a(a2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
                return -1;
            }
            return -1;
        }
        int b2 = b(cVar);
        if (b2 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                return -1;
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
        if (a2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
                return -1;
            }
            return -1;
        } else if (a(bArr, i)) {
            return a(new b(bArr, i));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            return -1;
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType a(c cVar) {
        int a2 = cVar.a();
        if (a2 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a3 = ((a2 << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK);
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
            if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a4 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & SupportMenu.USER_MASK);
            if ((a4 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            if ((a4 & 255) == 88) {
                cVar.a(4L);
                return (cVar.c() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if ((a4 & 255) == 76) {
                cVar.a(4L);
                return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > f10278a.length;
        if (z) {
            for (int i2 = 0; i2 < f10278a.length; i2++) {
                if (bArr[i2] != f10278a[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    private int b(c cVar) {
        short b2;
        short b3;
        int a2;
        long a3;
        do {
            if (cVar.b() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) b2));
                    return -1;
                }
                return -1;
            }
            b3 = cVar.b();
            if (b3 == 218) {
                return -1;
            }
            if (b3 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return -1;
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b3 == 225) {
                return a2;
            }
            a3 = cVar.a(a2);
        } while (a3 == a2);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) b3) + ", wanted to skip: " + a2 + ", but actually skipped: " + a3);
            return -1;
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
