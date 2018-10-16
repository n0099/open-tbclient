package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;
/* loaded from: classes2.dex */
final class FileOperator {
    private final FileChannel fileChannel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void write(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0 || j2 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j2;
        long j4 = j;
        while (j3 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j4, j3);
            j4 += transferFrom;
            j3 -= transferFrom;
        }
    }

    public void read(long j, Buffer buffer, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j2;
        long j4 = j;
        while (j3 > 0) {
            long transferTo = this.fileChannel.transferTo(j4, j3, buffer);
            j4 += transferTo;
            j3 -= transferTo;
        }
    }
}
