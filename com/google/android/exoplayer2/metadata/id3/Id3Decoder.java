package com.google.android.exoplayer2.metadata.id3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public final class Id3Decoder implements MetadataDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    public static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    public static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    public static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    public static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    public static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    public static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    public static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG;
    public static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    public static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    public static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    public static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final String TAG = "Id3Decoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final FramePredicate framePredicate;

    /* loaded from: classes7.dex */
    public interface FramePredicate {
        boolean evaluate(int i2, int i3, int i4, int i5, int i6);
    }

    /* loaded from: classes7.dex */
    public static final class Id3Header {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int framesSize;
        public final boolean isUnsynchronized;
        public final int majorVersion;

        public Id3Header(int i2, boolean z, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.majorVersion = i2;
            this.isUnsynchronized = z;
            this.framesSize = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1100907542, "Lcom/google/android/exoplayer2/metadata/id3/Id3Decoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1100907542, "Lcom/google/android/exoplayer2/metadata/id3/Id3Decoder;");
                return;
            }
        }
        ID3_TAG = Util.getIntegerCodeForString("ID3");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Id3Decoder() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((FramePredicate) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static byte[] copyOfRangeIfValid(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) ? i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3) : (byte[]) invokeLII.objValue;
    }

    public static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i2, int i3) throws UnsupportedEncodingException {
        InterceptResult invokeLII;
        int indexOfZeroByte;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray, i2, i3)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            int i4 = i2 - 1;
            byte[] bArr = new byte[i4];
            parsableByteArray.readBytes(bArr, 0, i4);
            if (i3 == 2) {
                str = FileUtils.IMAGE_FILE_START + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
                if (str.equals("image/jpg")) {
                    str = "image/jpeg";
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
            int i5 = indexOfZeroByte + 2;
            int indexOfEos = indexOfEos(bArr, i5, readUnsignedByte);
            return new ApicFrame(str, new String(bArr, i5, indexOfEos - i5, charsetName), bArr[indexOfZeroByte + 1] & 255, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i4));
        }
        return (ApicFrame) invokeLII.objValue;
    }

    public static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, parsableByteArray, i2, str)) == null) {
            byte[] bArr = new byte[i2];
            parsableByteArray.readBytes(bArr, 0, i2);
            return new BinaryFrame(str, bArr);
        }
        return (BinaryFrame) invokeLIL.objValue;
    }

    public static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, FramePredicate framePredicate) throws UnsupportedEncodingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), framePredicate})) == null) {
            int position = parsableByteArray.getPosition();
            int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
            String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte + 1);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            long j2 = readUnsignedInt == 4294967295L ? -1L : readUnsignedInt;
            long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
            long j3 = readUnsignedInt2 == 4294967295L ? -1L : readUnsignedInt2;
            ArrayList arrayList = new ArrayList();
            int i5 = position + i2;
            while (parsableByteArray.getPosition() < i5) {
                Id3Frame decodeFrame = decodeFrame(i3, parsableByteArray, z, i4, framePredicate);
                if (decodeFrame != null) {
                    arrayList.add(decodeFrame);
                }
            }
            Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
            arrayList.toArray(id3FrameArr);
            return new ChapterFrame(str, readInt, readInt2, j2, j3, id3FrameArr);
        }
        return (ChapterFrame) invokeCommon.objValue;
    }

    public static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, FramePredicate framePredicate) throws UnsupportedEncodingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), framePredicate})) == null) {
            int position = parsableByteArray.getPosition();
            int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
            String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte + 1);
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            boolean z2 = (readUnsignedByte & 2) != 0;
            boolean z3 = (readUnsignedByte & 1) != 0;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            String[] strArr = new String[readUnsignedByte2];
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                int position2 = parsableByteArray.getPosition();
                int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
                strArr[i5] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
                parsableByteArray.setPosition(indexOfZeroByte2 + 1);
            }
            ArrayList arrayList = new ArrayList();
            int i6 = position + i2;
            while (parsableByteArray.getPosition() < i6) {
                Id3Frame decodeFrame = decodeFrame(i3, parsableByteArray, z, i4, framePredicate);
                if (decodeFrame != null) {
                    arrayList.add(decodeFrame);
                }
            }
            Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
            arrayList.toArray(id3FrameArr);
            return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
        }
        return (ChapterTocFrame) invokeCommon.objValue;
    }

    public static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, parsableByteArray, i2)) == null) {
            if (i2 < 4) {
                return null;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            byte[] bArr = new byte[3];
            parsableByteArray.readBytes(bArr, 0, 3);
            String str = new String(bArr, 0, 3);
            int i3 = i2 - 4;
            byte[] bArr2 = new byte[i3];
            parsableByteArray.readBytes(bArr2, 0, i3);
            int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
            String str2 = new String(bArr2, 0, indexOfEos, charsetName);
            int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
            return new CommentFrame(str, str2, delimiterLength < i3 ? new String(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte) - delimiterLength, charsetName) : "");
        }
        return (CommentFrame) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x018a, code lost:
        if (r13 == 67) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame decodeFrame(int i2, ParsableByteArray parsableByteArray, boolean z, int i3, FramePredicate framePredicate) {
        InterceptResult invokeCommon;
        int readUnsignedInt24;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame decodeBinaryFrame;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), parsableByteArray, Boolean.valueOf(z), Integer.valueOf(i3), framePredicate})) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
            int readUnsignedByte4 = i2 >= 3 ? parsableByteArray.readUnsignedByte() : 0;
            if (i2 == 4) {
                readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
                if (!z) {
                    readUnsignedInt24 = (((readUnsignedInt24 >> 24) & 255) << 21) | (readUnsignedInt24 & 255) | (((readUnsignedInt24 >> 8) & 255) << 7) | (((readUnsignedInt24 >> 16) & 255) << 14);
                }
            } else if (i2 == 3) {
                readUnsignedInt24 = parsableByteArray.readUnsignedIntToInt();
            } else {
                readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
            }
            int i6 = readUnsignedInt24;
            int readUnsignedShort = i2 >= 3 ? parsableByteArray.readUnsignedShort() : 0;
            if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && i6 == 0 && readUnsignedShort == 0) {
                parsableByteArray.setPosition(parsableByteArray.limit());
                return null;
            }
            int position = parsableByteArray.getPosition() + i6;
            if (position > parsableByteArray.limit()) {
                parsableByteArray.setPosition(parsableByteArray.limit());
                return null;
            }
            if (framePredicate != null) {
                i4 = position;
                i5 = readUnsignedShort;
                if (!framePredicate.evaluate(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
                    parsableByteArray.setPosition(i4);
                    return null;
                }
            } else {
                i4 = position;
                i5 = readUnsignedShort;
            }
            if (i2 == 3) {
                boolean z7 = (i5 & 128) != 0;
                z3 = (i5 & 64) != 0;
                z6 = z7;
                z5 = false;
                z2 = (i5 & 32) != 0;
                z4 = z6;
            } else if (i2 == 4) {
                z2 = (i5 & 64) != 0;
                boolean z8 = (i5 & 8) != 0;
                boolean z9 = (i5 & 4) != 0;
                z5 = (i5 & 2) != 0;
                z6 = z8;
                z3 = z9;
                z4 = (i5 & 1) != 0;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
            if (!z6 && !z3) {
                if (z2) {
                    i6--;
                    parsableByteArray.skipBytes(1);
                }
                if (z4) {
                    i6 -= 4;
                    parsableByteArray.skipBytes(4);
                }
                if (z5) {
                    i6 = removeUnsynchronization(parsableByteArray, i6);
                }
                try {
                    if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i2 == 2 || readUnsignedByte4 == 88)) {
                        decodeBinaryFrame = decodeTxxxFrame(parsableByteArray, i6);
                    } else if (readUnsignedByte == 84) {
                        decodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, i6, getFrameId(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                    } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i2 == 2 || readUnsignedByte4 == 88)) {
                        decodeBinaryFrame = decodeWxxxFrame(parsableByteArray, i6);
                    } else if (readUnsignedByte == 87) {
                        decodeBinaryFrame = decodeUrlLinkFrame(parsableByteArray, i6, getFrameId(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                    } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                        decodeBinaryFrame = decodePrivFrame(parsableByteArray, i6);
                    } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i2 == 2)) {
                        decodeBinaryFrame = decodeGeobFrame(parsableByteArray, i6);
                    } else if (i2 == 2) {
                        if (readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) {
                            decodeBinaryFrame = decodeApicFrame(parsableByteArray, i6, i2);
                        }
                        if (readUnsignedByte != 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i2 == 2)) {
                            decodeBinaryFrame = decodeCommentFrame(parsableByteArray, i6);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                            decodeBinaryFrame = decodeChapterFrame(parsableByteArray, i6, i2, z, i3, framePredicate);
                        } else if (readUnsignedByte != 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                            decodeBinaryFrame = decodeChapterTOCFrame(parsableByteArray, i6, i2, z, i3, framePredicate);
                        } else {
                            decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i6, getFrameId(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
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
                        decodeBinaryFrame = decodeBinaryFrame(parsableByteArray, i6, getFrameId(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4));
                    }
                    if (decodeBinaryFrame == null) {
                        String str = "Failed to decode frame: id=" + getFrameId(i2, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4) + ", frameSize=" + i6;
                    }
                    parsableByteArray.setPosition(i4);
                    return decodeBinaryFrame;
                } catch (UnsupportedEncodingException unused) {
                    parsableByteArray.setPosition(i4);
                    return null;
                } catch (Throwable th) {
                    parsableByteArray.setPosition(i4);
                    throw th;
                }
            }
            parsableByteArray.setPosition(i4);
            return null;
        }
        return (Id3Frame) invokeCommon.objValue;
    }

    public static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, parsableByteArray, i2)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            parsableByteArray.readBytes(bArr, 0, i3);
            int indexOfZeroByte = indexOfZeroByte(bArr, 0);
            String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
            int i4 = indexOfZeroByte + 1;
            int indexOfEos = indexOfEos(bArr, i4, readUnsignedByte);
            String str2 = new String(bArr, i4, indexOfEos - i4, charsetName);
            int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
            int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
            return new GeobFrame(str, str2, new String(bArr, delimiterLength, indexOfEos2 - delimiterLength, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i3));
        }
        return (GeobFrame) invokeLI.objValue;
    }

    public static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, parsableByteArray)) == null) {
            if (parsableByteArray.bytesLeft() < 10) {
                return null;
            }
            int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
            if (readUnsignedInt24 != ID3_TAG) {
                String str = "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24;
                return null;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            boolean z = true;
            parsableByteArray.skipBytes(1);
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
            if (readUnsignedByte == 2) {
                if ((readUnsignedByte2 & 64) != 0) {
                    return null;
                }
            } else if (readUnsignedByte == 3) {
                if ((readUnsignedByte2 & 64) != 0) {
                    int readInt = parsableByteArray.readInt();
                    parsableByteArray.skipBytes(readInt);
                    readSynchSafeInt -= readInt + 4;
                }
            } else if (readUnsignedByte != 4) {
                String str2 = "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte;
                return null;
            } else {
                if ((readUnsignedByte2 & 64) != 0) {
                    int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                    parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                    readSynchSafeInt -= readSynchSafeInt2;
                }
                if ((readUnsignedByte2 & 16) != 0) {
                    readSynchSafeInt -= 10;
                }
            }
            return new Id3Header(readUnsignedByte, (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) ? false : false, readSynchSafeInt);
        }
        return (Id3Header) invokeL.objValue;
    }

    public static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, parsableByteArray, i2)) == null) {
            byte[] bArr = new byte[i2];
            parsableByteArray.readBytes(bArr, 0, i2);
            int indexOfZeroByte = indexOfZeroByte(bArr, 0);
            return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i2));
        }
        return (PrivFrame) invokeLI.objValue;
    }

    public static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i2, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, null, parsableByteArray, i2, str)) == null) {
            if (i2 < 1) {
                return null;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            parsableByteArray.readBytes(bArr, 0, i3);
            return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
        }
        return (TextInformationFrame) invokeLIL.objValue;
    }

    public static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, parsableByteArray, i2)) == null) {
            if (i2 < 1) {
                return null;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            parsableByteArray.readBytes(bArr, 0, i3);
            int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
            String str = new String(bArr, 0, indexOfEos, charsetName);
            int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
            return new TextInformationFrame("TXXX", str, delimiterLength < i3 ? new String(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte) - delimiterLength, charsetName) : "");
        }
        return (TextInformationFrame) invokeLI.objValue;
    }

    public static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i2, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65551, null, parsableByteArray, i2, str)) == null) {
            byte[] bArr = new byte[i2];
            parsableByteArray.readBytes(bArr, 0, i2);
            return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
        }
        return (UrlLinkFrame) invokeLIL.objValue;
    }

    public static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i2) throws UnsupportedEncodingException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, parsableByteArray, i2)) == null) {
            if (i2 < 1) {
                return null;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            String charsetName = getCharsetName(readUnsignedByte);
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            parsableByteArray.readBytes(bArr, 0, i3);
            int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
            String str = new String(bArr, 0, indexOfEos, charsetName);
            int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
            return new UrlLinkFrame("WXXX", str, delimiterLength < i3 ? new String(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength) - delimiterLength, "ISO-8859-1") : "");
        }
        return (UrlLinkFrame) invokeLI.objValue;
    }

    public static int delimiterLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? (i2 == 0 || i2 == 3) ? 1 : 2 : invokeI.intValue;
    }

    public static String getCharsetName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16" : (String) invokeI.objValue;
    }

    public static String getFrameId(int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)) : (String) invokeCommon.objValue;
    }

    public static int indexOfEos(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, bArr, i2, i3)) == null) {
            int indexOfZeroByte = indexOfZeroByte(bArr, i2);
            if (i3 == 0 || i3 == 3) {
                return indexOfZeroByte;
            }
            while (indexOfZeroByte < bArr.length - 1) {
                if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                    return indexOfZeroByte;
                }
                indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
            }
            return bArr.length;
        }
        return invokeLII.intValue;
    }

    public static int indexOfZeroByte(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, bArr, i2)) == null) {
            while (i2 < bArr.length) {
                if (bArr[i2] == 0) {
                    return i2;
                }
                i2++;
            }
            return bArr.length;
        }
        return invokeLI.intValue;
    }

    public static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65558, null, parsableByteArray, i2)) != null) {
            return invokeLI.intValue;
        }
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i3 = position + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[position] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, position + 2, bArr, i3, (i2 - position) - 2);
                i2--;
            }
            position = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        if ((r10 & 1) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
        if ((r10 & 128) != 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean validateFrames(ParsableByteArray parsableByteArray, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i4;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                if (parsableByteArray.bytesLeft() < i3) {
                    return true;
                }
                if (i2 >= 3) {
                    readUnsignedInt24 = parsableByteArray.readInt();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                    i4 = parsableByteArray.readUnsignedShort();
                } else {
                    readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                    i4 = 0;
                }
                if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i4 == 0) {
                    return true;
                }
                if (i2 == 4 && !z) {
                    if ((8421504 & readUnsignedInt242) != 0) {
                        return false;
                    }
                    readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                }
                if (i2 == 4) {
                    z2 = (i4 & 64) != 0;
                } else {
                    if (i2 == 3) {
                        z2 = (i4 & 32) != 0;
                    } else {
                        z2 = false;
                    }
                    z3 = false;
                }
                int i5 = z2 ? 1 : 0;
                if (z3) {
                    i5 += 4;
                }
                if (readUnsignedInt242 < i5) {
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

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, metadataInputBuffer)) == null) {
            ByteBuffer byteBuffer = metadataInputBuffer.data;
            return decode(byteBuffer.array(), byteBuffer.limit());
        }
        return (Metadata) invokeL.objValue;
    }

    public Id3Decoder(FramePredicate framePredicate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {framePredicate};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.framePredicate = framePredicate;
    }

    public Metadata decode(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i2);
            Id3Header decodeHeader = decodeHeader(parsableByteArray);
            if (decodeHeader == null) {
                return null;
            }
            int position = parsableByteArray.getPosition();
            int i3 = decodeHeader.majorVersion == 2 ? 6 : 10;
            int i4 = decodeHeader.framesSize;
            if (decodeHeader.isUnsynchronized) {
                i4 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
            }
            parsableByteArray.setLimit(position + i4);
            boolean z = false;
            if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i3, false)) {
                if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i3, true)) {
                    String str = "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion;
                    return null;
                }
                z = true;
            }
            while (parsableByteArray.bytesLeft() >= i3) {
                Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i3, this.framePredicate);
                if (decodeFrame != null) {
                    arrayList.add(decodeFrame);
                }
            }
            return new Metadata(arrayList);
        }
        return (Metadata) invokeLI.objValue;
    }
}
