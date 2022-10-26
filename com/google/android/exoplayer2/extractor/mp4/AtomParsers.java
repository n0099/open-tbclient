package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class AtomParsers {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AtomParsers";
    public static final int TYPE_cenc;
    public static final int TYPE_clcp;
    public static final int TYPE_meta;
    public static final int TYPE_sbtl;
    public static final int TYPE_soun;
    public static final int TYPE_subt;
    public static final int TYPE_text;
    public static final int TYPE_vide;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    /* loaded from: classes7.dex */
    public final class ChunkIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParsableByteArray chunkOffsets;
        public final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        public int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        public int remainingSamplesPerChunkChanges;
        public final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parsableByteArray, parsableByteArray2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            InterceptResult invokeV;
            long readUnsignedInt;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.index + 1;
                this.index = i2;
                if (i2 == this.length) {
                    return false;
                }
                if (this.chunkOffsetsAreLongs) {
                    readUnsignedInt = this.chunkOffsets.readUnsignedLongToLong();
                } else {
                    readUnsignedInt = this.chunkOffsets.readUnsignedInt();
                }
                this.offset = readUnsignedInt;
                if (this.index == this.nextSamplesPerChunkChangeIndex) {
                    this.numSamples = this.stsc.readUnsignedIntToInt();
                    this.stsc.skipBytes(4);
                    int i3 = this.remainingSamplesPerChunkChanges - 1;
                    this.remainingSamplesPerChunkChanges = i3;
                    if (i3 > 0) {
                        i = this.stsc.readUnsignedIntToInt() - 1;
                    } else {
                        i = -1;
                    }
                    this.nextSamplesPerChunkChangeIndex = i;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class StsdData {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STSD_HEADER_SIZE = 8;
        public transient /* synthetic */ FieldHolder $fh;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
            this.requiredSampleTransformation = 0;
        }
    }

    /* loaded from: classes7.dex */
    public final class StszSampleSizeBox implements SampleSizeBox {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParsableByteArray data;
        public final int fixedSampleSize;
        public final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leafAtom};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = this.data.readUnsignedIntToInt();
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.sampleCount;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.fixedSampleSize != 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.fixedSampleSize;
                if (i == 0) {
                    return this.data.readUnsignedIntToInt();
                }
                return i;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class Stz2SampleSizeBox implements SampleSizeBox {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentByte;
        public final ParsableByteArray data;
        public final int fieldSize;
        public final int sampleCount;
        public int sampleIndex;

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leafAtom};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = this.data.readUnsignedIntToInt() & 255;
            this.sampleCount = this.data.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.sampleCount;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.fieldSize;
                if (i == 8) {
                    return this.data.readUnsignedByte();
                }
                if (i == 16) {
                    return this.data.readUnsignedShort();
                }
                int i2 = this.sampleIndex;
                this.sampleIndex = i2 + 1;
                if (i2 % 2 == 0) {
                    int readUnsignedByte = this.data.readUnsignedByte();
                    this.currentByte = readUnsignedByte;
                    return (readUnsignedByte & 240) >> 4;
                }
                return this.currentByte & 15;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class TkhdData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long duration;
        public final int id;
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1674526623, "Lcom/google/android/exoplayer2/extractor/mp4/AtomParsers;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1674526623, "Lcom/google/android/exoplayer2/extractor/mp4/AtomParsers;");
                return;
            }
        }
        TYPE_vide = Util.getIntegerCodeForString("vide");
        TYPE_soun = Util.getIntegerCodeForString("soun");
        TYPE_text = Util.getIntegerCodeForString("text");
        TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
        TYPE_subt = Util.getIntegerCodeForString("subt");
        TYPE_clcp = Util.getIntegerCodeForString("clcp");
        TYPE_cenc = Util.getIntegerCodeForString("cenc");
        TYPE_meta = Util.getIntegerCodeForString("meta");
    }

    public AtomParsers() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, parsableByteArray, i, i2)) == null) {
            int position = parsableByteArray.getPosition();
            while (position - i < i2) {
                parsableByteArray.setPosition(position);
                int readInt = parsableByteArray.readInt();
                if (readInt > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z, "childAtomSize should be positive");
                if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                    return position;
                }
                position += readInt;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, parsableByteArray, i, i2)) == null) {
            int i3 = i + 8;
            while (i3 - i < i2) {
                parsableByteArray.setPosition(i3);
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                    return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
                }
                i3 += readInt;
            }
            return null;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static Pair parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Pair parseCommonEncryptionSinfFromParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, parsableByteArray, i, i2)) == null) {
            int position = parsableByteArray.getPosition();
            while (position - i < i2) {
                parsableByteArray.setPosition(position);
                int readInt = parsableByteArray.readInt();
                if (readInt > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z, "childAtomSize should be positive");
                if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                    return parseCommonEncryptionSinfFromParent;
                }
                position += readInt;
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int i6;
        int i7;
        int i8;
        String str2;
        int i9;
        boolean z2;
        int i10;
        int i11;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        int findEsdsPosition;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{parsableByteArray, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(z), drmInitData, stsdData, Integer.valueOf(i5)}) == null) {
            int i13 = i2;
            DrmInitData drmInitData3 = drmInitData;
            parsableByteArray.setPosition(i13 + 8 + 8);
            if (z) {
                i6 = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(6);
            } else {
                parsableByteArray.skipBytes(8);
                i6 = 0;
            }
            if (i6 != 0 && i6 != 1) {
                if (i6 == 2) {
                    parsableByteArray.skipBytes(16);
                    i7 = (int) Math.round(parsableByteArray.readDouble());
                    i8 = parsableByteArray.readUnsignedIntToInt();
                    parsableByteArray.skipBytes(20);
                } else {
                    return;
                }
            } else {
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(6);
                int readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
                if (i6 == 1) {
                    parsableByteArray.skipBytes(16);
                }
                i7 = readUnsignedFixedPoint1616;
                i8 = readUnsignedShort;
            }
            int position = parsableByteArray.getPosition();
            List list = null;
            int i14 = i;
            if (i14 == Atom.TYPE_enca) {
                Pair parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i13, i3);
                if (parseSampleEntryEncryptionData != null) {
                    i14 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                    if (drmInitData3 == null) {
                        drmInitData3 = null;
                    } else {
                        drmInitData3 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                    }
                    stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
                }
                parsableByteArray.setPosition(position);
            }
            DrmInitData drmInitData4 = drmInitData3;
            int i15 = Atom.TYPE_ac_3;
            String str5 = MimeTypes.AUDIO_RAW;
            if (i14 == i15) {
                str2 = MimeTypes.AUDIO_AC3;
            } else if (i14 == Atom.TYPE_ec_3) {
                str2 = MimeTypes.AUDIO_E_AC3;
            } else if (i14 == Atom.TYPE_dtsc) {
                str2 = MimeTypes.AUDIO_DTS;
            } else if (i14 != Atom.TYPE_dtsh && i14 != Atom.TYPE_dtsl) {
                if (i14 == Atom.TYPE_dtse) {
                    str2 = MimeTypes.AUDIO_DTS_EXPRESS;
                } else if (i14 == Atom.TYPE_samr) {
                    str2 = MimeTypes.AUDIO_AMR_NB;
                } else if (i14 == Atom.TYPE_sawb) {
                    str2 = MimeTypes.AUDIO_AMR_WB;
                } else if (i14 != Atom.TYPE_lpcm && i14 != Atom.TYPE_sowt) {
                    if (i14 == Atom.TYPE__mp3) {
                        str2 = MimeTypes.AUDIO_MPEG;
                    } else if (i14 == Atom.TYPE_alac) {
                        str2 = MimeTypes.AUDIO_ALAC;
                    } else {
                        str2 = null;
                    }
                } else {
                    str2 = MimeTypes.AUDIO_RAW;
                }
            } else {
                str2 = MimeTypes.AUDIO_DTS_HD;
            }
            String str6 = str2;
            int i16 = i8;
            int i17 = i7;
            int i18 = position;
            byte[] bArr = null;
            while (i18 - i13 < i3) {
                parsableByteArray.setPosition(i18);
                int readInt = parsableByteArray.readInt();
                if (readInt > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkArgument(z2, "childAtomSize should be positive");
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 != Atom.TYPE_esds && (!z || readInt2 != Atom.TYPE_wave)) {
                    if (readInt2 == Atom.TYPE_dac3) {
                        parsableByteArray.setPosition(i18 + 8);
                        stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData4);
                    } else if (readInt2 == Atom.TYPE_dec3) {
                        parsableByteArray.setPosition(i18 + 8);
                        stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData4);
                    } else {
                        if (readInt2 == Atom.TYPE_ddts) {
                            i12 = i18;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str6, null, -1, -1, i16, i17, null, drmInitData2, 0, str);
                            i10 = readInt;
                        } else {
                            i12 = i18;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            i10 = readInt;
                            if (readInt2 == Atom.TYPE_alac) {
                                byte[] bArr2 = new byte[i10];
                                i11 = i12;
                                parsableByteArray.setPosition(i11);
                                parsableByteArray.readBytes(bArr2, 0, i10);
                                bArr = bArr2;
                            }
                        }
                        i11 = i12;
                    }
                    i10 = readInt;
                    i11 = i18;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                } else {
                    i10 = readInt;
                    i11 = i18;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                    if (readInt2 == Atom.TYPE_esds) {
                        findEsdsPosition = i11;
                    } else {
                        findEsdsPosition = findEsdsPosition(parsableByteArray, i11, i10);
                    }
                    if (findEsdsPosition != -1) {
                        Pair parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, findEsdsPosition);
                        str6 = (String) parseEsdsFromParent.first;
                        bArr = (byte[]) parseEsdsFromParent.second;
                        if ("audio/mp4a-latm".equals(str6)) {
                            Pair parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                            i17 = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                            i16 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                        }
                        i18 = i11 + i10;
                        i13 = i2;
                        drmInitData4 = drmInitData2;
                        str5 = str4;
                    }
                }
                str6 = str3;
                i18 = i11 + i10;
                i13 = i2;
                drmInitData4 = drmInitData2;
                str5 = str4;
            }
            String str7 = str6;
            String str8 = str5;
            DrmInitData drmInitData5 = drmInitData4;
            if (stsdData.format == null && str7 != null) {
                if (str8.equals(str7)) {
                    i9 = 2;
                } else {
                    i9 = -1;
                }
                String num = Integer.toString(i4);
                if (bArr != null) {
                    list = Collections.singletonList(bArr);
                }
                stsdData.format = Format.createAudioSampleFormat(num, str7, null, -1, -1, i16, i17, i9, list, drmInitData5, 0, str);
            }
        }
    }

    public static Pair parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray, i, i2)) == null) {
            int i3 = i + 8;
            boolean z3 = false;
            String str = null;
            Integer num = null;
            int i4 = -1;
            int i5 = 0;
            while (i3 - i < i2) {
                parsableByteArray.setPosition(i3);
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == Atom.TYPE_frma) {
                    num = Integer.valueOf(parsableByteArray.readInt());
                } else if (readInt2 == Atom.TYPE_schm) {
                    parsableByteArray.skipBytes(4);
                    str = parsableByteArray.readString(4);
                } else if (readInt2 == Atom.TYPE_schi) {
                    i4 = i3;
                    i5 = readInt;
                }
                i3 += readInt;
            }
            if (!"cenc".equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
                return null;
            }
            if (num != null) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z, "frma atom is mandatory");
            if (i4 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.checkArgument(z2, "schi atom is mandatory");
            TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
            if (parseSchiFromParent != null) {
                z3 = true;
            }
            Assertions.checkArgument(z3, "tenc atom is mandatory");
            return Pair.create(num, parseSchiFromParent);
        }
        return (Pair) invokeLII.objValue;
    }

    public static Pair parseEdts(Atom.ContainerAtom containerAtom) {
        InterceptResult invokeL;
        Atom.LeafAtom leafAtomOfType;
        long readUnsignedInt;
        long readInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, containerAtom)) == null) {
            if (containerAtom != null && (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) != null) {
                ParsableByteArray parsableByteArray = leafAtomOfType.data;
                parsableByteArray.setPosition(8);
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                long[] jArr = new long[readUnsignedIntToInt];
                long[] jArr2 = new long[readUnsignedIntToInt];
                for (int i = 0; i < readUnsignedIntToInt; i++) {
                    if (parseFullAtomVersion == 1) {
                        readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
                    } else {
                        readUnsignedInt = parsableByteArray.readUnsignedInt();
                    }
                    jArr[i] = readUnsignedInt;
                    if (parseFullAtomVersion == 1) {
                        readInt = parsableByteArray.readLong();
                    } else {
                        readInt = parsableByteArray.readInt();
                    }
                    jArr2[i] = readInt;
                    if (parsableByteArray.readShort() == 1) {
                        parsableByteArray.skipBytes(2);
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(jArr, jArr2);
            }
            return Pair.create(null, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair parseMdhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, parsableByteArray)) == null) {
            int i2 = 8;
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            if (parseFullAtomVersion == 0) {
                i = 8;
            } else {
                i = 16;
            }
            parsableByteArray.skipBytes(i);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            if (parseFullAtomVersion == 0) {
                i2 = 4;
            }
            parsableByteArray.skipBytes(i2);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, parsableByteArray, i)) == null) {
            parsableByteArray.setPosition(i + 8 + 4);
            parsableByteArray.skipBytes(1);
            parseExpandableClassSize(parsableByteArray);
            parsableByteArray.skipBytes(2);
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if ((readUnsignedByte & 128) != 0) {
                parsableByteArray.skipBytes(2);
            }
            if ((readUnsignedByte & 64) != 0) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
            }
            if ((readUnsignedByte & 32) != 0) {
                parsableByteArray.skipBytes(2);
            }
            parsableByteArray.skipBytes(1);
            parseExpandableClassSize(parsableByteArray);
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            String str = null;
            if (readUnsignedByte2 != 32) {
                if (readUnsignedByte2 != 33) {
                    if (readUnsignedByte2 != 35) {
                        if (readUnsignedByte2 != 64) {
                            if (readUnsignedByte2 != 107) {
                                if (readUnsignedByte2 != 96 && readUnsignedByte2 != 97) {
                                    if (readUnsignedByte2 != 165) {
                                        if (readUnsignedByte2 != 166) {
                                            switch (readUnsignedByte2) {
                                                case 102:
                                                case 103:
                                                case 104:
                                                    break;
                                                default:
                                                    switch (readUnsignedByte2) {
                                                        case 169:
                                                        case 172:
                                                            return Pair.create(MimeTypes.AUDIO_DTS, null);
                                                        case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
                                                        case Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID /* 171 */:
                                                            return Pair.create(MimeTypes.AUDIO_DTS_HD, null);
                                                    }
                                            }
                                        } else {
                                            str = MimeTypes.AUDIO_E_AC3;
                                        }
                                    } else {
                                        str = MimeTypes.AUDIO_AC3;
                                    }
                                } else {
                                    str = MimeTypes.VIDEO_MPEG2;
                                }
                            } else {
                                return Pair.create(MimeTypes.AUDIO_MPEG, null);
                            }
                        }
                        str = "audio/mp4a-latm";
                    } else {
                        str = MimeTypes.VIDEO_H265;
                    }
                } else {
                    str = "video/avc";
                }
            } else {
                str = MimeTypes.VIDEO_MP4V;
            }
            parsableByteArray.skipBytes(12);
            parsableByteArray.skipBytes(1);
            int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
            byte[] bArr = new byte[parseExpandableClassSize];
            parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
            return Pair.create(str, bArr);
        }
        return (Pair) invokeLI.objValue;
    }

    public static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, parsableByteArray)) == null) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int i = readUnsignedByte & 127;
            while ((readUnsignedByte & 128) == 128) {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
                i = (i << 7) | (readUnsignedByte & 127);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static long parseMvhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, parsableByteArray)) == null) {
            int i = 8;
            parsableByteArray.setPosition(8);
            if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
                i = 16;
            }
            parsableByteArray.skipBytes(i);
            return parsableByteArray.readUnsignedInt();
        }
        return invokeL.longValue;
    }

    public static int parseHdlr(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(16);
            int readInt = parsableByteArray.readInt();
            if (readInt == TYPE_soun) {
                return 1;
            }
            if (readInt == TYPE_vide) {
                return 2;
            }
            if (readInt != TYPE_text && readInt != TYPE_sbtl && readInt != TYPE_subt && readInt != TYPE_clcp) {
                if (readInt == TYPE_meta) {
                    return 4;
                }
                return -1;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, parsableByteArray, i)) == null) {
            parsableByteArray.skipBytes(8);
            ArrayList arrayList = new ArrayList();
            while (parsableByteArray.getPosition() < i) {
                Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
                if (parseIlstElement != null) {
                    arrayList.add(parseIlstElement);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new Metadata(arrayList);
        }
        return (Metadata) invokeLI.objValue;
    }

    public static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, parsableByteArray, i)) == null) {
            parsableByteArray.skipBytes(12);
            while (parsableByteArray.getPosition() < i) {
                int position = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                    parsableByteArray.setPosition(position);
                    return parseIlst(parsableByteArray, position + readInt);
                }
                parsableByteArray.skipBytes(readInt - 8);
            }
            return null;
        }
        return (Metadata) invokeLI.objValue;
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65558, null, leafAtom, z)) == null) {
            if (z) {
                return null;
            }
            ParsableByteArray parsableByteArray = leafAtom.data;
            parsableByteArray.setPosition(8);
            while (parsableByteArray.bytesLeft() >= 8) {
                int position = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                    parsableByteArray.setPosition(position);
                    return parseMetaAtom(parsableByteArray, position + readInt);
                }
                parsableByteArray.skipBytes(readInt - 8);
            }
            return null;
        }
        return (Metadata) invokeLZ.objValue;
    }

    public static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, parsableByteArray, i)) == null) {
            parsableByteArray.setPosition(i + 8);
            return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
        }
        return invokeLI.floatValue;
    }

    public static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{parsableByteArray, Integer.valueOf(i), Integer.valueOf(i2), str})) == null) {
            int i5 = i + 8;
            while (true) {
                byte[] bArr = null;
                if (i5 - i >= i2) {
                    return null;
                }
                parsableByteArray.setPosition(i5);
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                    int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                    parsableByteArray.skipBytes(1);
                    if (parseFullAtomVersion == 0) {
                        parsableByteArray.skipBytes(1);
                        i4 = 0;
                        i3 = 0;
                    } else {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        i3 = readUnsignedByte & 15;
                        i4 = (readUnsignedByte & 240) >> 4;
                    }
                    if (parsableByteArray.readUnsignedByte() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    byte[] bArr2 = new byte[16];
                    parsableByteArray.readBytes(bArr2, 0, 16);
                    if (z && readUnsignedByte2 == 0) {
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                        bArr = new byte[readUnsignedByte3];
                        parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                    }
                    return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
                }
                i5 += readInt;
            }
        } else {
            return (TrackEncryptionBox) invokeCommon.objValue;
        }
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        InterceptResult invokeLLL;
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        ParsableByteArray parsableByteArray;
        ParsableByteArray parsableByteArray2;
        int i;
        int i2;
        boolean z2;
        Track track2;
        int i3;
        String str;
        int[] iArr;
        long[] jArr;
        long[] jArr2;
        int[] iArr2;
        int i4;
        long j;
        boolean z3;
        boolean z4;
        long[] jArr3;
        int[] iArr3;
        int i5;
        int[] iArr4;
        boolean z5;
        long[] jArr4;
        int i6;
        int[] iArr5;
        int[] iArr6;
        boolean z6;
        int[] iArr7;
        long[] jArr5;
        int[] iArr8;
        int i7;
        int[] iArr9;
        int i8;
        boolean z7;
        boolean z8;
        int i9;
        boolean z9;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, track, containerAtom, gaplessInfoHolder)) == null) {
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
            if (leafAtomOfType != null) {
                stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
            } else {
                Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
                if (leafAtomOfType2 != null) {
                    stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
                } else {
                    throw new ParserException("Track has no sample table size information");
                }
            }
            int sampleCount = stz2SampleSizeBox.getSampleCount();
            if (sampleCount == 0) {
                return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0]);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
            if (leafAtomOfType3 == null) {
                leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
                z = true;
            } else {
                z = false;
            }
            ParsableByteArray parsableByteArray3 = leafAtomOfType3.data;
            ParsableByteArray parsableByteArray4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
            ParsableByteArray parsableByteArray5 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
            ParsableByteArray parsableByteArray6 = null;
            if (leafAtomOfType4 != null) {
                parsableByteArray = leafAtomOfType4.data;
            } else {
                parsableByteArray = null;
            }
            Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
            if (leafAtomOfType5 != null) {
                parsableByteArray2 = leafAtomOfType5.data;
            } else {
                parsableByteArray2 = null;
            }
            ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray4, parsableByteArray3, z);
            parsableByteArray5.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray5.readUnsignedIntToInt() - 1;
            int readUnsignedIntToInt2 = parsableByteArray5.readUnsignedIntToInt();
            int readUnsignedIntToInt3 = parsableByteArray5.readUnsignedIntToInt();
            if (parsableByteArray2 != null) {
                parsableByteArray2.setPosition(12);
                i = parsableByteArray2.readUnsignedIntToInt();
            } else {
                i = 0;
            }
            int i11 = -1;
            if (parsableByteArray != null) {
                parsableByteArray.setPosition(12);
                i2 = parsableByteArray.readUnsignedIntToInt();
                if (i2 > 0) {
                    i11 = parsableByteArray.readUnsignedIntToInt() - 1;
                    parsableByteArray6 = parsableByteArray;
                }
            } else {
                parsableByteArray6 = parsableByteArray;
                i2 = 0;
            }
            if (stz2SampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i == 0 && i2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j2 = 0;
            if (!z2) {
                long[] jArr6 = new long[sampleCount];
                int[] iArr10 = new int[sampleCount];
                int i12 = i2;
                long[] jArr7 = new long[sampleCount];
                iArr = new int[sampleCount];
                int i13 = readUnsignedIntToInt3;
                long j3 = 0;
                j = 0;
                int i14 = readUnsignedIntToInt;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = i12;
                int i21 = i11;
                int i22 = i;
                int i23 = readUnsignedIntToInt2;
                while (i15 < sampleCount) {
                    while (i18 == 0) {
                        Assertions.checkState(chunkIterator.moveNext());
                        j3 = chunkIterator.offset;
                        i18 = chunkIterator.numSamples;
                        i14 = i14;
                        i23 = i23;
                    }
                    int i24 = i14;
                    int i25 = i23;
                    if (parsableByteArray2 != null) {
                        while (i17 == 0 && i22 > 0) {
                            i17 = parsableByteArray2.readUnsignedIntToInt();
                            i19 = parsableByteArray2.readInt();
                            i22--;
                        }
                        i17--;
                    }
                    int i26 = i19;
                    jArr6[i15] = j3;
                    iArr10[i15] = stz2SampleSizeBox.readNextSampleSize();
                    if (iArr10[i15] > i16) {
                        i16 = iArr10[i15];
                    }
                    int i27 = sampleCount;
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    jArr7[i15] = j + i26;
                    if (parsableByteArray6 == null) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    iArr[i15] = i10;
                    if (i15 == i21) {
                        iArr[i15] = 1;
                        i20--;
                        if (i20 > 0) {
                            i21 = parsableByteArray6.readUnsignedIntToInt() - 1;
                        }
                    }
                    j += i13;
                    int i28 = i25 - 1;
                    if (i28 == 0 && i24 > 0) {
                        i24--;
                        i28 = parsableByteArray5.readUnsignedIntToInt();
                        i13 = parsableByteArray5.readInt();
                    }
                    int i29 = i28;
                    j3 += iArr10[i15];
                    i18--;
                    i15++;
                    stz2SampleSizeBox = sampleSizeBox;
                    sampleCount = i27;
                    i13 = i13;
                    i23 = i29;
                    i19 = i26;
                    i14 = i24;
                }
                i3 = sampleCount;
                int i30 = i14;
                int i31 = i23;
                if (i17 == 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Assertions.checkArgument(z8);
                while (i22 > 0) {
                    if (parsableByteArray2.readUnsignedIntToInt() == 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    Assertions.checkArgument(z9);
                    parsableByteArray2.readInt();
                    i22--;
                }
                if (i20 == 0 && i31 == 0) {
                    i9 = i18;
                    if (i9 == 0 && i30 == 0) {
                        track2 = track;
                        str = TAG;
                        jArr = jArr6;
                        jArr2 = jArr7;
                        iArr2 = iArr10;
                        i4 = i16;
                    }
                } else {
                    i9 = i18;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                track2 = track;
                sb.append(track2.id);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i20);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i31);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i9);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i30);
                String sb2 = sb.toString();
                str = TAG;
                Log.w(str, sb2);
                jArr = jArr6;
                jArr2 = jArr7;
                iArr2 = iArr10;
                i4 = i16;
            } else {
                track2 = track;
                i3 = sampleCount;
                SampleSizeBox sampleSizeBox2 = stz2SampleSizeBox;
                str = TAG;
                int i32 = chunkIterator.length;
                long[] jArr8 = new long[i32];
                int[] iArr11 = new int[i32];
                while (chunkIterator.moveNext()) {
                    int i33 = chunkIterator.index;
                    jArr8[i33] = chunkIterator.offset;
                    iArr11[i33] = chunkIterator.numSamples;
                }
                FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(sampleSizeBox2.readNextSampleSize(), jArr8, iArr11, readUnsignedIntToInt3);
                long[] jArr9 = rechunk.offsets;
                int[] iArr12 = rechunk.sizes;
                int i34 = rechunk.maximumSize;
                long[] jArr10 = rechunk.timestamps;
                iArr = rechunk.flags;
                jArr = jArr9;
                jArr2 = jArr10;
                iArr2 = iArr12;
                i4 = i34;
                j = 0;
            }
            if (track2.editListDurations != null && !gaplessInfoHolder.hasGaplessInfo()) {
                long[] jArr11 = track2.editListDurations;
                if (jArr11.length == 1 && track2.type == 1 && jArr2.length >= 2) {
                    long j4 = track2.editListMediaTimes[0];
                    long scaleLargeTimestamp = Util.scaleLargeTimestamp(jArr11[0], track2.timescale, track2.movieTimescale) + j4;
                    if (jArr2[0] <= j4 && j4 < jArr2[1] && jArr2[jArr2.length - 1] < scaleLargeTimestamp && scaleLargeTimestamp <= j) {
                        long j5 = j - scaleLargeTimestamp;
                        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j4 - jArr2[0], track2.format.sampleRate, track2.timescale);
                        long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j5, track2.format.sampleRate, track2.timescale);
                        if ((scaleLargeTimestamp2 != 0 || scaleLargeTimestamp3 != 0) && scaleLargeTimestamp2 <= 2147483647L && scaleLargeTimestamp3 <= 2147483647L) {
                            gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp2;
                            gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp3;
                            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                            return new TrackSampleTable(jArr, iArr2, i4, jArr2, iArr);
                        }
                    }
                }
                long[] jArr12 = track2.editListDurations;
                if (jArr12.length == 1) {
                    char c = 0;
                    if (jArr12[0] == 0) {
                        int i35 = 0;
                        while (i35 < jArr2.length) {
                            jArr2[i35] = Util.scaleLargeTimestamp(jArr2[i35] - track2.editListMediaTimes[c], 1000000L, track2.timescale);
                            i35++;
                            c = 0;
                        }
                        return new TrackSampleTable(jArr, iArr2, i4, jArr2, iArr);
                    }
                }
                if (track2.type == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z10 = false;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                while (true) {
                    long[] jArr13 = track2.editListDurations;
                    if (i38 >= jArr13.length) {
                        break;
                    }
                    int[] iArr13 = iArr;
                    long j6 = track2.editListMediaTimes[i38];
                    if (j6 != -1) {
                        iArr9 = iArr2;
                        i8 = i4;
                        long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(jArr13[i38], track2.timescale, track2.movieTimescale);
                        int binarySearchCeil = Util.binarySearchCeil(jArr2, j6, true, true);
                        int binarySearchCeil2 = Util.binarySearchCeil(jArr2, j6 + scaleLargeTimestamp4, z3, false);
                        i36 += binarySearchCeil2 - binarySearchCeil;
                        if (i37 != binarySearchCeil) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z10 |= z7;
                        i37 = binarySearchCeil2;
                    } else {
                        iArr9 = iArr2;
                        i8 = i4;
                    }
                    i38++;
                    iArr = iArr13;
                    iArr2 = iArr9;
                    i4 = i8;
                }
                int[] iArr14 = iArr;
                int[] iArr15 = iArr2;
                int i39 = i4;
                if (i36 != i3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z11 = z10 | z4;
                if (z11) {
                    jArr3 = new long[i36];
                } else {
                    jArr3 = jArr;
                }
                if (z11) {
                    iArr3 = new int[i36];
                } else {
                    iArr3 = iArr15;
                }
                if (z11) {
                    i5 = 0;
                } else {
                    i5 = i39;
                }
                if (z11) {
                    iArr4 = new int[i36];
                } else {
                    iArr4 = iArr14;
                }
                long[] jArr14 = new long[i36];
                int i40 = i5;
                int i41 = 0;
                int i42 = 0;
                while (true) {
                    long[] jArr15 = track2.editListDurations;
                    if (i41 >= jArr15.length) {
                        break;
                    }
                    int[] iArr16 = iArr3;
                    int[] iArr17 = iArr15;
                    long j7 = track2.editListMediaTimes[i41];
                    long j8 = jArr15[i41];
                    if (j7 != -1) {
                        i6 = i41;
                        int[] iArr18 = iArr4;
                        int binarySearchCeil3 = Util.binarySearchCeil(jArr2, j7, true, true);
                        int binarySearchCeil4 = Util.binarySearchCeil(jArr2, Util.scaleLargeTimestamp(j8, track2.timescale, track2.movieTimescale) + j7, z3, false);
                        if (z11) {
                            int i43 = binarySearchCeil4 - binarySearchCeil3;
                            System.arraycopy(jArr, binarySearchCeil3, jArr3, i42, i43);
                            iArr5 = iArr17;
                            z6 = z3;
                            iArr7 = iArr16;
                            System.arraycopy(iArr5, binarySearchCeil3, iArr7, i42, i43);
                            jArr4 = jArr3;
                            iArr6 = iArr14;
                            jArr5 = jArr;
                            iArr8 = iArr18;
                            System.arraycopy(iArr6, binarySearchCeil3, iArr8, i42, i43);
                        } else {
                            jArr4 = jArr3;
                            iArr5 = iArr17;
                            iArr6 = iArr14;
                            z6 = z3;
                            jArr5 = jArr;
                            iArr8 = iArr18;
                            iArr7 = iArr16;
                        }
                        int i44 = i40;
                        while (binarySearchCeil3 < binarySearchCeil4) {
                            int i45 = binarySearchCeil4;
                            int i46 = i44;
                            long j9 = j7;
                            jArr14[i42] = Util.scaleLargeTimestamp(j2, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr2[binarySearchCeil3] - j7, 1000000L, track2.timescale);
                            if (z11) {
                                i7 = i46;
                                if (iArr7[i42] > i7) {
                                    i44 = iArr5[binarySearchCeil3];
                                    i42++;
                                    binarySearchCeil3++;
                                    binarySearchCeil4 = i45;
                                    j7 = j9;
                                }
                            } else {
                                i7 = i46;
                            }
                            i44 = i7;
                            i42++;
                            binarySearchCeil3++;
                            binarySearchCeil4 = i45;
                            j7 = j9;
                        }
                        i40 = i44;
                    } else {
                        jArr4 = jArr3;
                        i6 = i41;
                        iArr5 = iArr17;
                        iArr6 = iArr14;
                        z6 = z3;
                        iArr7 = iArr16;
                        jArr5 = jArr;
                        iArr8 = iArr4;
                    }
                    j2 += j8;
                    i41 = i6 + 1;
                    iArr3 = iArr7;
                    iArr15 = iArr5;
                    iArr4 = iArr8;
                    z3 = z6;
                    jArr = jArr5;
                    iArr14 = iArr6;
                    jArr3 = jArr4;
                }
                long[] jArr16 = jArr3;
                int[] iArr19 = iArr3;
                int[] iArr20 = iArr15;
                int[] iArr21 = iArr14;
                long[] jArr17 = jArr;
                int[] iArr22 = iArr4;
                boolean z12 = false;
                for (int i47 = 0; i47 < iArr22.length && !z12; i47++) {
                    if ((iArr22[i47] & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    z12 |= z5;
                }
                if (!z12) {
                    Log.w(str, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(jArr17, iArr20, i39, jArr2, iArr21);
                }
                return new TrackSampleTable(jArr16, iArr19, i40, jArr14, iArr22);
            }
            long[] jArr18 = jArr;
            int[] iArr23 = iArr2;
            int i48 = i4;
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(jArr18, iArr23, i48, jArr2, iArr);
        }
        return (TrackSampleTable) invokeLLL.objValue;
    }

    public static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{parsableByteArray, Integer.valueOf(i), Integer.valueOf(i2), str, drmInitData, Boolean.valueOf(z)})) == null) {
            parsableByteArray.setPosition(12);
            int readInt = parsableByteArray.readInt();
            StsdData stsdData = new StsdData(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                int position = parsableByteArray.getPosition();
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.checkArgument(z2, "childAtomSize should be positive");
                int readInt3 = parsableByteArray.readInt();
                if (readInt3 != Atom.TYPE_avc1 && readInt3 != Atom.TYPE_avc3 && readInt3 != Atom.TYPE_encv && readInt3 != Atom.TYPE_mp4v && readInt3 != Atom.TYPE_hvc1 && readInt3 != Atom.TYPE_hev1 && readInt3 != Atom.TYPE_s263 && readInt3 != Atom.TYPE_vp08 && readInt3 != Atom.TYPE_vp09) {
                    if (readInt3 != Atom.TYPE_mp4a && readInt3 != Atom.TYPE_enca && readInt3 != Atom.TYPE_ac_3 && readInt3 != Atom.TYPE_ec_3 && readInt3 != Atom.TYPE_dtsc && readInt3 != Atom.TYPE_dtse && readInt3 != Atom.TYPE_dtsh && readInt3 != Atom.TYPE_dtsl && readInt3 != Atom.TYPE_samr && readInt3 != Atom.TYPE_sawb && readInt3 != Atom.TYPE_lpcm && readInt3 != Atom.TYPE_sowt && readInt3 != Atom.TYPE__mp3 && readInt3 != Atom.TYPE_alac) {
                        if (readInt3 != Atom.TYPE_TTML && readInt3 != Atom.TYPE_tx3g && readInt3 != Atom.TYPE_wvtt && readInt3 != Atom.TYPE_stpp && readInt3 != Atom.TYPE_c608) {
                            if (readInt3 == Atom.TYPE_camm) {
                                stsdData.format = Format.createSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_CAMERA_MOTION, null, -1, null);
                            }
                        } else {
                            parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
                        }
                    } else {
                        parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
                    }
                } else {
                    parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
                }
                parsableByteArray.setPosition(position + readInt2);
            }
            return stsdData;
        }
        return (StsdData) invokeCommon.objValue;
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        InterceptResult invokeCommon;
        Atom.LeafAtom leafAtom2;
        long j2;
        long[] jArr;
        long[] jArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{containerAtom, leafAtom, Long.valueOf(j), drmInitData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
            int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
            if (parseHdlr == -1) {
                return null;
            }
            TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
            long j3 = C.TIME_UNSET;
            if (j == C.TIME_UNSET) {
                leafAtom2 = leafAtom;
                j2 = parseTkhd.duration;
            } else {
                leafAtom2 = leafAtom;
                j2 = j;
            }
            long parseMvhd = parseMvhd(leafAtom2.data);
            if (j2 != C.TIME_UNSET) {
                j3 = Util.scaleLargeTimestamp(j2, 1000000L, parseMvhd);
            }
            long j4 = j3;
            Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
            Pair parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
            StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
            if (!z) {
                Pair parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
                jArr2 = (long[]) parseEdts.second;
                jArr = (long[]) parseEdts.first;
            } else {
                jArr = null;
                jArr2 = null;
            }
            if (parseStsd.format == null) {
                return null;
            }
            return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
        }
        return (Track) invokeCommon.objValue;
    }

    public static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{parsableByteArray, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, stsdData}) == null) {
            parsableByteArray.setPosition(i2 + 8 + 8);
            int i5 = Atom.TYPE_TTML;
            String str2 = MimeTypes.APPLICATION_TTML;
            List list = null;
            long j = Long.MAX_VALUE;
            if (i != i5) {
                if (i == Atom.TYPE_tx3g) {
                    int i6 = (i3 - 8) - 8;
                    byte[] bArr = new byte[i6];
                    parsableByteArray.readBytes(bArr, 0, i6);
                    list = Collections.singletonList(bArr);
                    str2 = MimeTypes.APPLICATION_TX3G;
                } else if (i == Atom.TYPE_wvtt) {
                    str2 = MimeTypes.APPLICATION_MP4VTT;
                } else if (i == Atom.TYPE_stpp) {
                    j = 0;
                } else if (i == Atom.TYPE_c608) {
                    stsdData.requiredSampleTransformation = 1;
                    str2 = MimeTypes.APPLICATION_MP4CEA608;
                } else {
                    throw new IllegalStateException();
                }
            }
            stsdData.format = Format.createTextSampleFormat(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, list);
        }
    }

    public static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        int i;
        boolean z;
        long readUnsignedLongToLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, parsableByteArray)) == null) {
            int i2 = 8;
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            if (parseFullAtomVersion == 0) {
                i = 8;
            } else {
                i = 16;
            }
            parsableByteArray.skipBytes(i);
            int readInt = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            int position = parsableByteArray.getPosition();
            if (parseFullAtomVersion == 0) {
                i2 = 4;
            }
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 < i2) {
                    if (parsableByteArray.data[position + i4] != -1) {
                        z = false;
                        break;
                    }
                    i4++;
                } else {
                    z = true;
                    break;
                }
            }
            long j = C.TIME_UNSET;
            if (z) {
                parsableByteArray.skipBytes(i2);
            } else {
                if (parseFullAtomVersion == 0) {
                    readUnsignedLongToLong = parsableByteArray.readUnsignedInt();
                } else {
                    readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
                }
                if (readUnsignedLongToLong != 0) {
                    j = readUnsignedLongToLong;
                }
            }
            parsableByteArray.skipBytes(16);
            int readInt2 = parsableByteArray.readInt();
            int readInt3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            int readInt4 = parsableByteArray.readInt();
            int readInt5 = parsableByteArray.readInt();
            if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
                i3 = 90;
            } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
                i3 = 270;
            } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
                i3 = 180;
            }
            return new TkhdData(readInt, j, i3);
        }
        return (TkhdData) invokeL.objValue;
    }

    public static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{parsableByteArray, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), drmInitData, stsdData, Integer.valueOf(i6)}) == null) {
            DrmInitData drmInitData2 = drmInitData;
            parsableByteArray.setPosition(i2 + 8 + 8);
            parsableByteArray.skipBytes(16);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(50);
            int position = parsableByteArray.getPosition();
            String str2 = null;
            int i7 = i;
            if (i7 == Atom.TYPE_encv) {
                Pair parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i3);
                if (parseSampleEntryEncryptionData != null) {
                    i7 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                    if (drmInitData2 == null) {
                        drmInitData2 = null;
                    } else {
                        drmInitData2 = drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                    }
                    stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
                }
                parsableByteArray.setPosition(position);
            }
            DrmInitData drmInitData3 = drmInitData2;
            List list = null;
            byte[] bArr = null;
            boolean z7 = false;
            float f = 1.0f;
            int i8 = -1;
            while (position - i2 < i3) {
                parsableByteArray.setPosition(position);
                int position2 = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                if (readInt == 0 && parsableByteArray.getPosition() - i2 == i3) {
                    break;
                }
                if (readInt > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkArgument(z, "childAtomSize should be positive");
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == Atom.TYPE_avcC) {
                    if (str2 == null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    Assertions.checkState(z6);
                    parsableByteArray.setPosition(position2 + 8);
                    AvcConfig parse = AvcConfig.parse(parsableByteArray);
                    list = parse.initializationData;
                    stsdData.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                    if (!z7) {
                        f = parse.pixelWidthAspectRatio;
                    }
                    str2 = "video/avc";
                } else if (readInt2 == Atom.TYPE_hvcC) {
                    if (str2 == null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Assertions.checkState(z5);
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                    list = parse2.initializationData;
                    stsdData.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str2 = MimeTypes.VIDEO_H265;
                } else if (readInt2 == Atom.TYPE_vpcC) {
                    if (str2 == null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.checkState(z4);
                    if (i7 == Atom.TYPE_vp08) {
                        str = "video/x-vnd.on2.vp8";
                    } else {
                        str = "video/x-vnd.on2.vp9";
                    }
                    str2 = str;
                } else if (readInt2 == Atom.TYPE_d263) {
                    if (str2 == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Assertions.checkState(z3);
                    str2 = MimeTypes.VIDEO_H263;
                } else if (readInt2 == Atom.TYPE_esds) {
                    if (str2 == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Assertions.checkState(z2);
                    Pair parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                    str2 = (String) parseEsdsFromParent.first;
                    list = Collections.singletonList(parseEsdsFromParent.second);
                } else if (readInt2 == Atom.TYPE_pasp) {
                    f = parsePaspFromParent(parsableByteArray, position2);
                    z7 = true;
                } else if (readInt2 == Atom.TYPE_sv3d) {
                    bArr = parseProjFromParent(parsableByteArray, position2, readInt);
                } else if (readInt2 == Atom.TYPE_st3d) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(3);
                    if (readUnsignedByte == 0) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        if (readUnsignedByte2 != 0) {
                            if (readUnsignedByte2 != 1) {
                                if (readUnsignedByte2 != 2) {
                                    if (readUnsignedByte2 == 3) {
                                        i8 = 3;
                                    }
                                } else {
                                    i8 = 2;
                                }
                            } else {
                                i8 = 1;
                            }
                        } else {
                            i8 = 0;
                        }
                    }
                }
                position += readInt;
            }
            if (str2 == null) {
                return;
            }
            stsdData.format = Format.createVideoSampleFormat(Integer.toString(i4), str2, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i5, f, bArr, i8, null, drmInitData3);
        }
    }
}
