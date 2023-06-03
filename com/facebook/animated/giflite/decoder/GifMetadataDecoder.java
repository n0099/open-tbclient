package com.facebook.animated.giflite.decoder;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class GifMetadataDecoder {
    public static final int CONTROL_INDEX_DELAY = 1;
    public static final int CONTROL_INDEX_DISPOSE = 0;
    public static final int DEFAULT_FRAME_DURATION_MS = 100;
    public static final int MAX_BLOCK_SIZE = 256;
    public static final char[] NETSCAPE = {'N', 'E', 'T', 'S', 'C', 'A', 'P', 'E', '2', IStringUtil.EXTENSION_SEPARATOR, TransactionIdCreater.FILL_BYTE};
    public final InputStream mInputStream;
    @Nullable
    public final OutputStream mOutputStream;
    public boolean shouldFixStream;
    public final byte[] block = new byte[256];
    public final List<int[]> mFrameControls = new ArrayList();
    public int mLoopCount = 1;
    public boolean mDecoded = false;
    public int mCurrentOffset = 0;

    private void initFixedOutputStream() throws IOException {
        if (!this.shouldFixStream && this.mOutputStream != null) {
            this.shouldFixStream = true;
            this.mInputStream.reset();
            copyFromIsToOs(this.mInputStream, this.mOutputStream, this.mCurrentOffset - 2);
            this.mInputStream.skip(2L);
        }
    }

    private boolean isNetscape() {
        int length = this.block.length;
        char[] cArr = NETSCAPE;
        if (length < cArr.length) {
            return false;
        }
        int length2 = cArr.length;
        for (int i = 0; i < length2; i++) {
            if (NETSCAPE[i] != ((char) this.block[i])) {
                return false;
            }
        }
        return true;
    }

    private int readAndWriteNextByte() throws IOException {
        int readNextByte = readNextByte();
        writeNextByte(readNextByte);
        return readNextByte;
    }

    private int readBlock() throws IOException {
        int readAndWriteNextByte = readAndWriteNextByte();
        int i = 0;
        if (readAndWriteNextByte > 0) {
            while (i < readAndWriteNextByte) {
                i += readIntoBlock(i, readAndWriteNextByte - i);
            }
        }
        return i;
    }

    private void readNetscapeExtension() throws IOException {
        int readBlock;
        do {
            readBlock = readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.mLoopCount = (bArr[1] & 255) | ((bArr[2] & 255) << 8);
                continue;
            }
        } while (readBlock > 0);
    }

    private int readNextByte() throws IOException {
        int read = this.mInputStream.read();
        this.mCurrentOffset++;
        if (read != -1) {
            return read;
        }
        throw new EOFException("Unexpected end of gif file");
    }

    private int readTwoByteInt() throws IOException {
        return readNextByte() | (readNextByte() << 8);
    }

    private void skipExtension() throws IOException {
        do {
        } while (readBlock() > 0);
    }

    private void skipImage() throws IOException {
        boolean z;
        skipAndWriteBytes(8);
        int readAndWriteNextByte = readAndWriteNextByte();
        if ((readAndWriteNextByte & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ignoreColorTable(2 << (readAndWriteNextByte & 7));
        }
        skipAndWriteBytes(1);
        skipExtension();
    }

    public void decode() throws IOException {
        if (!this.mDecoded) {
            this.mDecoded = true;
            readGifInfo();
            return;
        }
        throw new IllegalStateException("decode called multiple times");
    }

    public int getFrameCount() {
        if (this.mDecoded) {
            return this.mFrameControls.size();
        }
        throw new IllegalStateException("getFrameCount called before decode");
    }

    public int getLoopCount() {
        if (this.mDecoded) {
            return this.mLoopCount;
        }
        throw new IllegalStateException("getLoopCount called before decode");
    }

    public GifMetadataDecoder(InputStream inputStream, @Nullable OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    public static GifMetadataDecoder create(InputStream inputStream, @Nullable OutputStream outputStream) throws IOException {
        GifMetadataDecoder gifMetadataDecoder = new GifMetadataDecoder(inputStream, outputStream);
        gifMetadataDecoder.decode();
        return gifMetadataDecoder;
    }

    private int readIntoBlock(int i, int i2) throws IOException {
        int read = this.mInputStream.read(this.block, i, i2);
        this.mCurrentOffset += i2;
        if (this.shouldFixStream) {
            this.mOutputStream.write(this.block, i, i2);
        }
        if (read != -1) {
            return read;
        }
        throw new EOFException("Unexpected end of gif file");
    }

    private void addFrame(int[] iArr) {
        this.mFrameControls.add(Arrays.copyOf(iArr, iArr.length));
    }

    private void ignoreColorTable(int i) throws IOException {
        skipAndWriteBytes(i * 3);
    }

    private void readGraphicsControlExtension(int[] iArr) throws IOException {
        skipAndWriteBytes(1);
        iArr[0] = (readAndWriteNextByte() & 28) >> 2;
        iArr[1] = readTwoByteInt() * 10;
        if (iArr[1] == 0) {
            iArr[1] = 100;
            initFixedOutputStream();
        }
        writeTwoByteInt(iArr[1] / 10);
        skipAndWriteBytes(2);
    }

    private void skipAndWriteBytes(int i) throws IOException {
        if (this.shouldFixStream) {
            copyFromIsToOs(this.mInputStream, this.mOutputStream, i);
        } else {
            this.mInputStream.skip(i);
        }
        this.mCurrentOffset += i;
    }

    private void writeNextByte(int i) throws IOException {
        if (this.shouldFixStream) {
            this.mOutputStream.write(i);
        }
    }

    private void writeTwoByteInt(int i) throws IOException {
        writeNextByte(i);
        writeNextByte(i >> 8);
    }

    public int getFrameDisposal(int i) {
        if (this.mDecoded) {
            return this.mFrameControls.get(i)[0];
        }
        throw new IllegalStateException("getFrameDisposal called before decode");
    }

    public int getFrameDurationMs(int i) {
        if (this.mDecoded) {
            if (i >= getFrameCount()) {
                return 1;
            }
            return this.mFrameControls.get(i)[1];
        }
        throw new IllegalStateException("getFrameDurationMs called before decode");
    }

    private void copyFromIsToOs(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        while (i > 0) {
            int read = inputStream.read(this.block, 0, Math.min(256, i));
            i -= 256;
            outputStream.write(this.block, 0, read);
        }
    }

    private void readGifInfo() throws IOException {
        validateAndIgnoreHeader();
        int[] iArr = {0, 0};
        boolean z = false;
        while (!z) {
            int readAndWriteNextByte = readAndWriteNextByte();
            if (readAndWriteNextByte != 33) {
                if (readAndWriteNextByte != 44) {
                    if (readAndWriteNextByte == 59) {
                        z = true;
                    } else {
                        throw new IOException("Unknown block header [" + Integer.toHexString(readAndWriteNextByte) + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else {
                    addFrame(iArr);
                    skipImage();
                }
            } else {
                int readAndWriteNextByte2 = readAndWriteNextByte();
                if (readAndWriteNextByte2 != 1) {
                    if (readAndWriteNextByte2 != 249) {
                        if (readAndWriteNextByte2 != 255) {
                            skipExtension();
                        } else {
                            readBlock();
                            if (isNetscape()) {
                                readNetscapeExtension();
                            } else {
                                skipExtension();
                            }
                        }
                    } else {
                        readGraphicsControlExtension(iArr);
                    }
                } else {
                    addFrame(iArr);
                    skipExtension();
                }
            }
        }
    }

    private void validateAndIgnoreHeader() throws IOException {
        boolean z;
        boolean z2 = false;
        readIntoBlock(0, 6);
        byte[] bArr = this.block;
        if ('G' == ((char) bArr[0]) && 'I' == ((char) bArr[1]) && 'F' == ((char) bArr[2]) && '8' == ((char) bArr[3]) && (('7' == ((char) bArr[4]) || '9' == ((char) bArr[4])) && 'a' == ((char) this.block[5]))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            skipAndWriteBytes(4);
            int readAndWriteNextByte = readAndWriteNextByte();
            if ((readAndWriteNextByte & 128) != 0) {
                z2 = true;
            }
            int i = 2 << (readAndWriteNextByte & 7);
            skipAndWriteBytes(2);
            if (z2) {
                ignoreColorTable(i);
                return;
            }
            return;
        }
        throw new IOException("Illegal header for gif");
    }
}
