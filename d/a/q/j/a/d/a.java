package d.a.q.j.a.d;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
/* loaded from: classes2.dex */
public abstract class a {
    public static int a(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getShort(i2) & UShort.MAX_VALUE;
    }

    public static long b(ByteBuffer byteBuffer) {
        k(byteBuffer);
        return i(byteBuffer, byteBuffer.position() + 16);
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> d2 = d(randomAccessFile, 0);
        return d2 != null ? d2 : d(randomAccessFile, 65535);
    }

    public static Pair<ByteBuffer, Long> d(RandomAccessFile randomAccessFile, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i2);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - allocate.capacity();
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int j = j(allocate);
        if (j == -1) {
            return null;
        }
        allocate.position(j);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + j));
    }

    public static void e(ByteBuffer byteBuffer, int i2, long j) {
        if (j >= 0 && j <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i2, (int) j);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j);
    }

    public static void f(ByteBuffer byteBuffer, long j) {
        k(byteBuffer);
        e(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static final boolean g(RandomAccessFile randomAccessFile, long j) {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long h(ByteBuffer byteBuffer) {
        k(byteBuffer);
        return i(byteBuffer, byteBuffer.position() + 12);
    }

    public static long i(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }

    public static int j(ByteBuffer byteBuffer) {
        k(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i2 = capacity - 22;
        int min = Math.min(i2, 65535);
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && a(byteBuffer, i4 + 20) == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static void k(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
