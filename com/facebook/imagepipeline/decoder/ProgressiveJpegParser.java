package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ProgressiveJpegParser {
    public static final int BUFFER_SIZE = 16384;
    public static final int NOT_A_JPEG = 6;
    public static final int READ_FIRST_JPEG_BYTE = 0;
    public static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    public static final int READ_MARKER_SECOND_BYTE = 3;
    public static final int READ_SECOND_JPEG_BYTE = 1;
    public static final int READ_SIZE_FIRST_BYTE = 4;
    public static final int READ_SIZE_SECOND_BYTE = 5;
    public final ByteArrayPool mByteArrayPool;
    public boolean mEndMarkerRead;
    public int mBytesParsed = 0;
    public int mLastByteRead = 0;
    public int mNextFullScanNumber = 0;
    public int mBestScanEndOffset = 0;
    public int mBestScanNumber = 0;
    public int mParserState = 0;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
    }

    private boolean doParseMoreData(InputStream inputStream) {
        int read;
        int i2 = this.mBestScanNumber;
        while (this.mParserState != 6 && (read = inputStream.read()) != -1) {
            try {
                int i3 = this.mBytesParsed + 1;
                this.mBytesParsed = i3;
                if (this.mEndMarkerRead) {
                    this.mParserState = 6;
                    this.mEndMarkerRead = false;
                    return false;
                }
                int i4 = this.mParserState;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.mParserState = 5;
                                } else if (i4 != 5) {
                                    Preconditions.checkState(false);
                                } else {
                                    int i5 = ((this.mLastByteRead << 8) + read) - 2;
                                    StreamUtil.skip(inputStream, i5);
                                    this.mBytesParsed += i5;
                                    this.mParserState = 2;
                                }
                            } else if (read == 255) {
                                this.mParserState = 3;
                            } else if (read == 0) {
                                this.mParserState = 2;
                            } else if (read == 217) {
                                this.mEndMarkerRead = true;
                                newScanOrImageEndFound(i3 - 2);
                                this.mParserState = 2;
                            } else {
                                if (read == 218) {
                                    newScanOrImageEndFound(i3 - 2);
                                }
                                if (doesMarkerStartSegment(read)) {
                                    this.mParserState = 4;
                                } else {
                                    this.mParserState = 2;
                                }
                            }
                        } else if (read == 255) {
                            this.mParserState = 3;
                        }
                    } else if (read == 216) {
                        this.mParserState = 2;
                    } else {
                        this.mParserState = 6;
                    }
                } else if (read == 255) {
                    this.mParserState = 1;
                } else {
                    this.mParserState = 6;
                }
                this.mLastByteRead = read;
            } catch (IOException e2) {
                Throwables.propagate(e2);
            }
        }
        return (this.mParserState == 6 || this.mBestScanNumber == i2) ? false : true;
    }

    public static boolean doesMarkerStartSegment(int i2) {
        if (i2 == 1) {
            return false;
        }
        return ((i2 >= 208 && i2 <= 215) || i2 == 217 || i2 == 216) ? false : true;
    }

    private void newScanOrImageEndFound(int i2) {
        if (this.mNextFullScanNumber > 0) {
            this.mBestScanEndOffset = i2;
        }
        int i3 = this.mNextFullScanNumber;
        this.mNextFullScanNumber = i3 + 1;
        this.mBestScanNumber = i3;
    }

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public boolean isEndMarkerRead() {
        return this.mEndMarkerRead;
    }

    public boolean isJpeg() {
        return this.mBytesParsed > 1 && this.mParserState != 6;
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.mParserState != 6 && encodedImage.getSize() > this.mBytesParsed) {
            PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), this.mByteArrayPool.get(16384), this.mByteArrayPool);
            try {
                StreamUtil.skip(pooledByteArrayBufferedInputStream, this.mBytesParsed);
                return doParseMoreData(pooledByteArrayBufferedInputStream);
            } catch (IOException e2) {
                Throwables.propagate(e2);
                return false;
            } finally {
                Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
            }
        }
        return false;
    }
}
