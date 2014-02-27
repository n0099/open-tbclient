package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class ReversedLinesFileReader implements Closeable {
    private final int avoidNewlineSplitBufferSize;
    private final int blockSize;
    private final int byteDecrement;
    private FilePart currentFilePart;
    private final Charset encoding;
    private final byte[][] newLineSequences;
    private final RandomAccessFile randomAccessFile;
    private final long totalBlockCount;
    private final long totalByteLength;
    private boolean trailingNewlineOfFileSkipped;

    public ReversedLinesFileReader(File file) {
        this(file, 4096, Charset.defaultCharset().toString());
    }

    public ReversedLinesFileReader(File file, int i, Charset charset) {
        this.trailingNewlineOfFileSkipped = false;
        this.blockSize = i;
        this.encoding = charset;
        this.randomAccessFile = new RandomAccessFile(file, "r");
        this.totalByteLength = this.randomAccessFile.length();
        int i2 = (int) (this.totalByteLength % i);
        if (i2 > 0) {
            this.totalBlockCount = (this.totalByteLength / i) + 1;
        } else {
            this.totalBlockCount = this.totalByteLength / i;
            if (this.totalByteLength > 0) {
                i2 = i;
            }
        }
        this.currentFilePart = new FilePart(this.totalBlockCount, i2, null);
        Charset charset2 = Charsets.toCharset(charset);
        if (charset2.newEncoder().maxBytesPerChar() == 1.0f) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("UTF-8")) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("Shift_JIS")) {
            this.byteDecrement = 1;
        } else if (charset2 == Charset.forName("UTF-16BE") || charset2 == Charset.forName("UTF-16LE")) {
            this.byteDecrement = 2;
        } else if (charset2 == Charset.forName("UTF-16")) {
            throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
        } else {
            throw new UnsupportedEncodingException("Encoding " + charset + " is not supported yet (feel free to submit a patch)");
        }
        this.newLineSequences = new byte[][]{IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(charset), IOUtils.LINE_SEPARATOR_UNIX.getBytes(charset), "\r".getBytes(charset)};
        this.avoidNewlineSplitBufferSize = this.newLineSequences[0].length;
    }

    public ReversedLinesFileReader(File file, int i, String str) {
        this(file, i, Charsets.toCharset(str));
    }

    public String readLine() {
        String readLine = this.currentFilePart.readLine();
        while (readLine == null) {
            this.currentFilePart = this.currentFilePart.rollOver();
            if (this.currentFilePart == null) {
                break;
            }
            readLine = this.currentFilePart.readLine();
        }
        if ("".equals(readLine) && !this.trailingNewlineOfFileSkipped) {
            this.trailingNewlineOfFileSkipped = true;
            return readLine();
        }
        return readLine;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.randomAccessFile.close();
    }

    /* loaded from: classes.dex */
    class FilePart {
        private int currentLastBytePos;
        private final byte[] data;
        private byte[] leftOver;
        private final long no;

        private FilePart(long j, int i, byte[] bArr) {
            this.no = j;
            this.data = new byte[(bArr != null ? bArr.length : 0) + i];
            long j2 = (j - 1) * ReversedLinesFileReader.this.blockSize;
            if (j > 0) {
                ReversedLinesFileReader.this.randomAccessFile.seek(j2);
                if (ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, i) != i) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, this.data, i, bArr.length);
            }
            this.currentLastBytePos = this.data.length - 1;
            this.leftOver = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FilePart rollOver() {
            if (this.currentLastBytePos >= 0) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
            }
            if (this.no > 1) {
                return new FilePart(this.no - 1, ReversedLinesFileReader.this.blockSize, this.leftOver);
            }
            if (this.leftOver != null) {
                throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String readLine() {
            String str;
            boolean z = this.no == 1;
            int i = this.currentLastBytePos;
            while (true) {
                if (i >= 0) {
                    if (!z && i < ReversedLinesFileReader.this.avoidNewlineSplitBufferSize) {
                        createLeftOver();
                        str = null;
                        break;
                    }
                    int newLineMatchByteCount = getNewLineMatchByteCount(this.data, i);
                    if (newLineMatchByteCount <= 0) {
                        i -= ReversedLinesFileReader.this.byteDecrement;
                        if (i < 0) {
                            createLeftOver();
                            break;
                        }
                    } else {
                        int i2 = i + 1;
                        int i3 = (this.currentLastBytePos - i2) + 1;
                        if (i3 < 0) {
                            throw new IllegalStateException("Unexpected negative line length=" + i3);
                        }
                        byte[] bArr = new byte[i3];
                        System.arraycopy(this.data, i2, bArr, 0, i3);
                        str = new String(bArr, ReversedLinesFileReader.this.encoding);
                        this.currentLastBytePos = i - newLineMatchByteCount;
                    }
                } else {
                    break;
                }
            }
            str = null;
            if (!z || this.leftOver == null) {
                return str;
            }
            String str2 = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
            this.leftOver = null;
            return str2;
        }

        private void createLeftOver() {
            int i = this.currentLastBytePos + 1;
            if (i > 0) {
                this.leftOver = new byte[i];
                System.arraycopy(this.data, 0, this.leftOver, 0, i);
            } else {
                this.leftOver = null;
            }
            this.currentLastBytePos = -1;
        }

        private int getNewLineMatchByteCount(byte[] bArr, int i) {
            byte[][] bArr2;
            for (byte[] bArr3 : ReversedLinesFileReader.this.newLineSequences) {
                boolean z = true;
                for (int length = bArr3.length - 1; length >= 0; length--) {
                    int length2 = (i + length) - (bArr3.length - 1);
                    z &= length2 >= 0 && bArr[length2] == bArr3[length];
                }
                if (z) {
                    return bArr3.length;
                }
            }
            return 0;
        }
    }
}
