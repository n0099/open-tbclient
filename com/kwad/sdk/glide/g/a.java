package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<byte[]> f35200a = new AtomicReference<>();

    /* renamed from: com.kwad.sdk.glide.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0409a extends InputStream {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f35201a;

        /* renamed from: b  reason: collision with root package name */
        public int f35202b = -1;

        public C0409a(@NonNull ByteBuffer byteBuffer) {
            this.f35201a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f35201a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f35202b = this.f35201a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f35201a.hasRemaining()) {
                return this.f35201a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) {
            if (this.f35201a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f35201a.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            if (this.f35202b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f35201a.position(this.f35202b);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (this.f35201a.hasRemaining()) {
                long min = Math.min(j, available());
                ByteBuffer byteBuffer = this.f35201a;
                byteBuffer.position((int) (byteBuffer.position() + min));
                return min;
            }
            return -1L;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f35207a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35208b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f35209c;

        public b(@NonNull byte[] bArr, int i, int i2) {
            this.f35209c = bArr;
            this.f35207a = i;
            this.f35208b = i2;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length <= 2147483647L) {
                if (length != 0) {
                    randomAccessFile = new RandomAccessFile(file, r.f7664a);
                    try {
                        fileChannel = randomAccessFile.getChannel();
                        MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused2) {
                        }
                        return load;
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
                throw new IOException("File unsuitable for memory mapping");
            }
            throw new IOException("File too large to map into memory");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                fileChannel.write(byteBuffer);
                fileChannel.force(false);
                fileChannel.close();
                randomAccessFile.close();
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static byte[] a(@NonNull ByteBuffer byteBuffer) {
        b c2 = c(byteBuffer);
        if (c2 != null && c2.f35207a == 0 && c2.f35208b == c2.f35209c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    public static InputStream b(@NonNull ByteBuffer byteBuffer) {
        return new C0409a(byteBuffer);
    }

    @Nullable
    public static b c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
