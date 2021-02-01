package com.kwad.sdk.glide.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f10008a = new AtomicReference<>();

    /* renamed from: com.kwad.sdk.glide.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C1122a extends InputStream {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10009a;

        /* renamed from: b  reason: collision with root package name */
        private int f10010b = -1;

        C1122a(@NonNull ByteBuffer byteBuffer) {
            this.f10009a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f10009a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f10010b = this.f10009a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f10009a.hasRemaining()) {
                return this.f10009a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i, int i2) {
            if (this.f10009a.hasRemaining()) {
                int min = Math.min(i2, available());
                this.f10009a.get(bArr, i, min);
                return min;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            if (this.f10010b == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f10009a.position(this.f10010b);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (this.f10009a.hasRemaining()) {
                long min = Math.min(j, available());
                this.f10009a.position((int) (this.f10009a.position() + min));
                return min;
            }
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f10014a;

        /* renamed from: b  reason: collision with root package name */
        final int f10015b;
        final byte[] c;

        b(@NonNull byte[] bArr, int i, int i2) {
            this.c = bArr;
            this.f10014a = i;
            this.f10015b = i2;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) {
        Throwable th;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile2.getChannel();
                try {
                    MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e2) {
                        }
                    }
                    return load;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    randomAccessFile = randomAccessFile2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                randomAccessFile = randomAccessFile2;
            }
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            randomAccessFile = null;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        try {
            randomAccessFile = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth);
            try {
                fileChannel = randomAccessFile.getChannel();
                try {
                    fileChannel.write(byteBuffer);
                    fileChannel.force(false);
                    fileChannel.close();
                    randomAccessFile.close();
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
        }
    }

    @NonNull
    public static byte[] a(@NonNull ByteBuffer byteBuffer) {
        b c = c(byteBuffer);
        if (c != null && c.f10014a == 0 && c.f10015b == c.c.length) {
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
        return new C1122a(byteBuffer);
    }

    @Nullable
    private static b c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
