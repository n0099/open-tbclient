package com.google.android.exoplayer2.metadata.id3;

import android.util.Log;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class Id3Decoder implements MetadataDecoder {
    public static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    public static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    public static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    public static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    public static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    public static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    public static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    public static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    public static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    public static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    public static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    public static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final String TAG = "Id3Decoder";
    public final FramePredicate framePredicate;

    /* loaded from: classes9.dex */
    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    public static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static String getCharsetName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    /* loaded from: classes9.dex */
    public static final class Id3Header {
        public final int framesSize;
        public final boolean isUnsynchronized;
        public final int majorVersion;

        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public static byte[] copyOfRangeIfValid(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    public static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    public static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    public static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 != 0 && i2 != 3) {
            while (indexOfZeroByte < bArr.length - 1) {
                if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                    return indexOfZeroByte;
                }
                indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
            }
            return bArr.length;
        }
        return indexOfZeroByte;
    }

    public static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int indexOfZeroByte;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            str = FileUtils.IMAGE_FILE_START + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals("image/jpg")) {
                str = WordCommandManager.IMAGE_JPEG;
            }
            indexOfZeroByte = 2;
        } else {
            indexOfZeroByte = indexOfZeroByte(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                str = FileUtils.IMAGE_FILE_START + lowerInvariant;
            } else {
                str = lowerInvariant;
            }
        }
        int i4 = indexOfZeroByte + 2;
        int indexOfEos = indexOfEos(bArr, i4, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i4, indexOfEos - i4, charsetName), bArr[indexOfZeroByte + 1] & 255, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i3));
    }

    public static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        long j;
        long j2;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            j = -1;
        } else {
            j = readUnsignedInt;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt2 == 4294967295L) {
            j2 = -1;
        } else {
            j2 = readUnsignedInt2;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, j, j2, id3FrameArr);
    }

    public static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        boolean z2;
        boolean z3;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((readUnsignedByte & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i4] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    public static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str2 = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str3 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < i2) {
            str = new String(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte) - delimiterLength, charsetName);
        } else {
            str = "";
        }
        return new CommentFrame(str2, str3, str);
    }

    public static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < i2) {
            str = new String(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte) - delimiterLength, charsetName);
        } else {
            str = "";
        }
        return new TextInformationFrame("TXXX", str2, str);
    }

    public static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        String str;
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str2 = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        if (delimiterLength < i2) {
            str = new String(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength) - delimiterLength, "ISO-8859-1");
        } else {
            str = "";
        }
        return new UrlLinkFrame("WXXX", str2, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0190, code lost:
        if (r13 == 67) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame decodeFrame(int i, ParsableByteArray parsableByteArray, boolean z, int i2, FramePredicate framePredicate) {
        int i3;
        int readUnsignedInt24;
        int i4;
        String str;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        Id3Frame decodeBinaryFrame;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        if (i >= 3) {
            i3 = parsableByteArray.readUnsignedByte();
        } else {
            i3 = 0;
        }
        if (i == 4) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
            if (!z) {
                readUnsignedInt24 = (((readUnsignedInt24 >> 24) & 255) << 21) | (readUnsignedInt24 & 255) | (((readUnsignedInt24 >> 8) & 255) << 7) | (((readUnsignedInt24 >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
        } else {
            readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        }
        int i7 = readUnsignedInt24;
        if (i >= 3) {
            i4 = parsableByteArray.readUnsignedShort();
        } else {
            i4 = 0;
        }
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && i3 == 0 && i7 == 0 && i4 == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i7;
        if (position > parsableByteArray.limit()) {
            Log.w(TAG, "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            str = TAG;
            i5 = position;
            i6 = i4;
            if (!framePredicate.evaluate(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3)) {
                parsableByteArray.setPosition(i5);
                return null;
            }
        } else {
            str = TAG;
            i5 = position;
            i6 = i4;
        }
        if (i == 3) {
            int i8 = i6;
            if ((i8 & 128) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i8 & 64) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((i8 & 32) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            z6 = z3;
            z5 = false;
        } else {
            int i9 = i6;
            if (i == 4) {
                if ((i9 & 64) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((i9 & 8) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if ((i9 & 4) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if ((i9 & 2) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if ((i9 & 1) != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z2 = z7;
                z3 = z10;
                z6 = z8;
                z4 = z9;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (!z6 && !z4) {
            if (z2) {
                i7--;
                parsableByteArray.skipBytes(1);
            }
            if (z3) {
                i7 -= 4;
                parsableByteArray.skipBytes(4);
            }
            if (z5) {
                i7 = removeUnsynchronization(parsableByteArray, i7);
            }
            try {
                try {
                    if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || i3 == 88)) {
                        decodeBinaryFrame = decodeTxxxFrame(parsableByteArray, i7);
                    } else if (readUnsignedByte == 84) {
                        decodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, i7, getFrameId(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                    } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || i3 == 88)) {
                        decodeBinaryFrame = decodeWxxxFrame(parsableByteArray, i7);
                    } else if (readUnsignedByte == 87) {
                        decodeBinaryFrame = decodeUrlLinkFrame(parsableByteArray, i7, getFrameId(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                    } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && i3 == 86) {
                        decodeBinaryFrame = decodePrivFrame(parsableByteArray, i7);
                    } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (i3 == 66 || i == 2)) {
                        decodeBinaryFrame = decodeGeobFrame(parsableByteArray, i7);
                    } else if (i == 2) {
                        if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                            decodeBinaryFrame = decodeApicFrame(parsableByteArray, i7, i);
                        }
                        if (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (i3 == 77 || i == 2)) {
                            decodeBinaryFrame = decodeCommentFrame(parsableByteArray, i7);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && i3 == 80) {
                            decodeBinaryFrame = decodeChapterFrame(parsableByteArray, i7, i, z, i2, framePredicate);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && i3 == 67) {
                            decodeBinaryFrame = decodeChapterTOCFrame(parsableByteArray, i7, i, z, i2, framePredicate);
                        } else {
                            decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i7, getFrameId(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                        }
                    } else {
                        if (readUnsignedByte == 65) {
                            if (readUnsignedByte2 == 80) {
                                if (readUnsignedByte3 == 73) {
                                }
                            }
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        if (readUnsignedByte != 67) {
                        }
                        decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i7, getFrameId(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3));
                    }
                    if (decodeBinaryFrame == null) {
                        Log.w(str, "Failed to decode frame: id=" + getFrameId(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, i3) + ", frameSize=" + i7);
                    }
                    parsableByteArray.setPosition(i5);
                    return decodeBinaryFrame;
                } catch (UnsupportedEncodingException unused) {
                    Log.w(str, "Unsupported character encoding");
                    parsableByteArray.setPosition(i5);
                    return null;
                }
            } catch (Throwable th) {
                parsableByteArray.setPosition(i5);
                throw th;
            }
        }
        Log.w(str, "Skipping unsupported compressed or encrypted frame");
        parsableByteArray.setPosition(i5);
        return null;
    }

    public static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i3 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i3, readUnsignedByte);
        String str2 = new String(bArr, i3, indexOfEos - i3, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, str2, new String(bArr, delimiterLength, indexOfEos2 - delimiterLength, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i2));
    }

    public static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z5 = true;
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        return new Id3Header(readUnsignedByte, (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) ? false : false, readSynchSafeInt);
    }

    public static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i));
    }

    public static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i2 = position + 1;
            if (i2 < i) {
                if ((bArr[position] & 255) == 255 && bArr[i2] == 0) {
                    System.arraycopy(bArr, position + 2, bArr, i2, (i - position) - 2);
                    i--;
                }
                position = i2;
            } else {
                return i;
            }
        }
    }

    public static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if ((r10 & 1) != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
        if ((r10 & 128) != 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean validateFrames(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i3;
        boolean z2;
        boolean z3;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                int i4 = 1;
                if (parsableByteArray.bytesLeft() < i2) {
                    return true;
                }
                if (i >= 3) {
                    readUnsignedInt24 = parsableByteArray.readInt();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                    i3 = parsableByteArray.readUnsignedShort();
                } else {
                    readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                    i3 = 0;
                }
                if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i3 == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & readUnsignedInt242) != 0) {
                        return false;
                    }
                    readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    if ((i3 & 64) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    if (i == 3) {
                        if ((i3 & 32) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    z3 = false;
                }
                if (!z2) {
                    i4 = 0;
                }
                if (z3) {
                    i4 += 4;
                }
                if (readUnsignedInt242 < i4) {
                    return false;
                }
                if (parsableByteArray.bytesLeft() < readUnsignedInt242) {
                    return false;
                }
                parsableByteArray.skipBytes((int) readUnsignedInt242);
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
    }

    public Metadata decode(byte[] bArr, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        if (decodeHeader.majorVersion == 2) {
            i2 = 6;
        } else {
            i2 = 10;
        }
        int i3 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            i3 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + i3);
        boolean z = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i2, false)) {
            if (decodeHeader.majorVersion == 4 && validateFrames(parsableByteArray, 4, i2, true)) {
                z = true;
            } else {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i2, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata(arrayList);
    }
}
