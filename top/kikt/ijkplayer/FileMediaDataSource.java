package top.kikt.ijkplayer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes6.dex */
public class FileMediaDataSource implements IMediaDataSource {
    private RandomAccessFile mFile;
    private long mFileSize;

    public FileMediaDataSource(File file) throws IOException {
        this.mFile = new RandomAccessFile(file, "r");
        this.mFileSize = this.mFile.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        try {
            if (this.mFile.getFilePointer() != j) {
                this.mFile.seek(j);
            }
            if (i2 == 0) {
                return 0;
            }
            return this.mFile.read(bArr, 0, i2);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() {
        return this.mFileSize;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() {
        try {
            this.mFileSize = 0L;
            this.mFile.close();
            this.mFile = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
