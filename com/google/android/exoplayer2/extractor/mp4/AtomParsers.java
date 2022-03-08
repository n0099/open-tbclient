package com.google.android.exoplayer2.extractor.mp4;

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
    public static final class ChunkIterator {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.index + 1;
                this.index = i2;
                if (i2 == this.length) {
                    return false;
                }
                this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
                if (this.index == this.nextSamplesPerChunkChangeIndex) {
                    this.numSamples = this.stsc.readUnsignedIntToInt();
                    this.stsc.skipBytes(4);
                    int i3 = this.remainingSamplesPerChunkChanges - 1;
                    this.remainingSamplesPerChunkChanges = i3;
                    this.nextSamplesPerChunkChangeIndex = i3 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    /* loaded from: classes7.dex */
    public static final class StsdData {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STSD_HEADER_SIZE = 8;
        public transient /* synthetic */ FieldHolder $fh;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.trackEncryptionBoxes = new TrackEncryptionBox[i2];
            this.requiredSampleTransformation = 0;
        }
    }

    /* loaded from: classes7.dex */
    public static final class StszSampleSizeBox implements SampleSizeBox {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sampleCount : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fixedSampleSize != 0 : invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.fixedSampleSize;
                return i2 == 0 ? this.data.readUnsignedIntToInt() : i2;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentByte;
        public final ParsableByteArray data;
        public final int fieldSize;
        public final int sampleCount;
        public int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leafAtom};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sampleCount : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.fieldSize;
                if (i2 == 8) {
                    return this.data.readUnsignedByte();
                }
                if (i2 == 16) {
                    return this.data.readUnsignedShort();
                }
                int i3 = this.sampleIndex;
                this.sampleIndex = i3 + 1;
                if (i3 % 2 == 0) {
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
    public static final class TkhdData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long duration;
        public final int id;
        public final int rotationDegrees;

        public TkhdData(int i2, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.id = i2;
            this.duration = j2;
            this.rotationDegrees = i3;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int findEsdsPosition(ParsableByteArray parsableByteArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, parsableByteArray, i2, i3)) == null) {
            int position = parsableByteArray.getPosition();
            while (position - i2 < i3) {
                parsableByteArray.setPosition(position);
                int readInt = parsableByteArray.readInt();
                Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
                if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                    return position;
                }
                position += readInt;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        int i7;
        int i8;
        int i9;
        String str2;
        int i10;
        int i11;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z), drmInitData, stsdData, Integer.valueOf(i6)}) == null) {
            int i13 = i3;
            DrmInitData drmInitData3 = drmInitData;
            parsableByteArray.setPosition(i13 + 8 + 8);
            if (z) {
                i7 = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(6);
            } else {
                parsableByteArray.skipBytes(8);
                i7 = 0;
            }
            if (i7 == 0 || i7 == 1) {
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(6);
                int readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
                if (i7 == 1) {
                    parsableByteArray.skipBytes(16);
                }
                i8 = readUnsignedFixedPoint1616;
                i9 = readUnsignedShort;
            } else if (i7 != 2) {
                return;
            } else {
                parsableByteArray.skipBytes(16);
                i8 = (int) Math.round(parsableByteArray.readDouble());
                i9 = parsableByteArray.readUnsignedIntToInt();
                parsableByteArray.skipBytes(20);
            }
            int position = parsableByteArray.getPosition();
            int i14 = i2;
            if (i14 == Atom.TYPE_enca) {
                Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i13, i4);
                if (parseSampleEntryEncryptionData != null) {
                    i14 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                    drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                    stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
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
            } else if (i14 == Atom.TYPE_dtsh || i14 == Atom.TYPE_dtsl) {
                str2 = MimeTypes.AUDIO_DTS_HD;
            } else if (i14 == Atom.TYPE_dtse) {
                str2 = MimeTypes.AUDIO_DTS_EXPRESS;
            } else if (i14 == Atom.TYPE_samr) {
                str2 = MimeTypes.AUDIO_AMR_NB;
            } else if (i14 == Atom.TYPE_sawb) {
                str2 = MimeTypes.AUDIO_AMR_WB;
            } else if (i14 == Atom.TYPE_lpcm || i14 == Atom.TYPE_sowt) {
                str2 = MimeTypes.AUDIO_RAW;
            } else if (i14 == Atom.TYPE__mp3) {
                str2 = MimeTypes.AUDIO_MPEG;
            } else {
                str2 = i14 == Atom.TYPE_alac ? MimeTypes.AUDIO_ALAC : null;
            }
            String str6 = str2;
            int i16 = i9;
            int i17 = i8;
            int i18 = position;
            byte[] bArr = null;
            while (i18 - i13 < i4) {
                parsableByteArray.setPosition(i18);
                int readInt = parsableByteArray.readInt();
                Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 != Atom.TYPE_esds && (!z || readInt2 != Atom.TYPE_wave)) {
                    if (readInt2 == Atom.TYPE_dac3) {
                        parsableByteArray.setPosition(i18 + 8);
                        stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i5), str, drmInitData4);
                    } else if (readInt2 == Atom.TYPE_dec3) {
                        parsableByteArray.setPosition(i18 + 8);
                        stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i5), str, drmInitData4);
                    } else {
                        if (readInt2 == Atom.TYPE_ddts) {
                            i12 = i18;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            stsdData.format = Format.createAudioSampleFormat(Integer.toString(i5), str6, null, -1, -1, i16, i17, null, drmInitData2, 0, str);
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
                    int findEsdsPosition = readInt2 == Atom.TYPE_esds ? i11 : findEsdsPosition(parsableByteArray, i11, i10);
                    if (findEsdsPosition != -1) {
                        Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, findEsdsPosition);
                        str6 = (String) parseEsdsFromParent.first;
                        bArr = (byte[]) parseEsdsFromParent.second;
                        if ("audio/mp4a-latm".equals(str6)) {
                            Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                            i17 = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                            i16 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                        }
                        i18 = i11 + i10;
                        i13 = i3;
                        drmInitData4 = drmInitData2;
                        str5 = str4;
                    }
                }
                str6 = str3;
                i18 = i11 + i10;
                i13 = i3;
                drmInitData4 = drmInitData2;
                str5 = str4;
            }
            String str7 = str6;
            String str8 = str5;
            DrmInitData drmInitData5 = drmInitData4;
            if (stsdData.format != null || str7 == null) {
                return;
            }
            stsdData.format = Format.createAudioSampleFormat(Integer.toString(i5), str7, null, -1, -1, i16, i17, str8.equals(str7) ? 2 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData5, 0, str);
        }
    }

    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray, i2, i3)) == null) {
            int i4 = i2 + 8;
            String str = null;
            Integer num = null;
            int i5 = -1;
            int i6 = 0;
            while (i4 - i2 < i3) {
                parsableByteArray.setPosition(i4);
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == Atom.TYPE_frma) {
                    num = Integer.valueOf(parsableByteArray.readInt());
                } else if (readInt2 == Atom.TYPE_schm) {
                    parsableByteArray.skipBytes(4);
                    str = parsableByteArray.readString(4);
                } else if (readInt2 == Atom.TYPE_schi) {
                    i5 = i4;
                    i6 = readInt;
                }
                i4 += readInt;
            }
            if ("cenc".equals(str) || C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str) || C.CENC_TYPE_cbcs.equals(str)) {
                Assertions.checkArgument(num != null, "frma atom is mandatory");
                Assertions.checkArgument(i5 != -1, "schi atom is mandatory");
                TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i5, i6, str);
                Assertions.checkArgument(parseSchiFromParent != null, "tenc atom is mandatory");
                return Pair.create(num, parseSchiFromParent);
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        InterceptResult invokeL;
        Atom.LeafAtom leafAtomOfType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, containerAtom)) == null) {
            if (containerAtom != null && (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) != null) {
                ParsableByteArray parsableByteArray = leafAtomOfType.data;
                parsableByteArray.setPosition(8);
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                long[] jArr = new long[readUnsignedIntToInt];
                long[] jArr2 = new long[readUnsignedIntToInt];
                for (int i2 = 0; i2 < readUnsignedIntToInt; i2++) {
                    jArr[i2] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
                    jArr2[i2] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
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

    public static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, parsableByteArray, i2)) == null) {
            parsableByteArray.setPosition(i2 + 8 + 4);
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
            if (readUnsignedByte2 == 32) {
                str = MimeTypes.VIDEO_MP4V;
            } else if (readUnsignedByte2 == 33) {
                str = "video/avc";
            } else if (readUnsignedByte2 != 35) {
                if (readUnsignedByte2 != 64) {
                    if (readUnsignedByte2 == 107) {
                        return Pair.create(MimeTypes.AUDIO_MPEG, null);
                    }
                    if (readUnsignedByte2 == 96 || readUnsignedByte2 == 97) {
                        str = MimeTypes.VIDEO_MPEG2;
                    } else if (readUnsignedByte2 == 165) {
                        str = MimeTypes.AUDIO_AC3;
                    } else if (readUnsignedByte2 != 166) {
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
                }
                str = "audio/mp4a-latm";
            } else {
                str = MimeTypes.VIDEO_H265;
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
            int i2 = readUnsignedByte & 127;
            while ((readUnsignedByte & 128) == 128) {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
                i2 = (i2 << 7) | (readUnsignedByte & 127);
            }
            return i2;
        }
        return invokeL.intValue;
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
            if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
                return 3;
            }
            return readInt == TYPE_meta ? 4 : -1;
        }
        return invokeL.intValue;
    }

    public static Metadata parseIlst(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, parsableByteArray, i2)) == null) {
            parsableByteArray.skipBytes(8);
            ArrayList arrayList = new ArrayList();
            while (parsableByteArray.getPosition() < i2) {
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

    public static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
        }
        return (Pair) invokeL.objValue;
    }

    public static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, parsableByteArray, i2)) == null) {
            parsableByteArray.skipBytes(12);
            while (parsableByteArray.getPosition() < i2) {
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

    public static long parseMvhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
            return parsableByteArray.readUnsignedInt();
        }
        return invokeL.longValue;
    }

    public static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, parsableByteArray, i2)) == null) {
            parsableByteArray.setPosition(i2 + 8);
            return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
        }
        return invokeLI.floatValue;
    }

    public static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, parsableByteArray, i2, i3)) == null) {
            int i4 = i2 + 8;
            while (i4 - i2 < i3) {
                parsableByteArray.setPosition(i4);
                int readInt = parsableByteArray.readInt();
                if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                    return Arrays.copyOfRange(parsableByteArray.data, i4, readInt + i4);
                }
                i4 += readInt;
            }
            return null;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i2, int i3) {
        InterceptResult invokeLII;
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, parsableByteArray, i2, i3)) == null) {
            int position = parsableByteArray.getPosition();
            while (position - i2 < i3) {
                parsableByteArray.setPosition(position);
                int readInt = parsableByteArray.readInt();
                Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
                if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                    return parseCommonEncryptionSinfFromParent;
                }
                position += readInt;
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), str})) != null) {
            return (TrackEncryptionBox) invokeCommon.objValue;
        }
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            parsableByteArray.setPosition(i6);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i4 = readUnsignedByte & 15;
                    i5 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i5, i4, bArr);
            }
            i6 += readInt;
        }
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        InterceptResult invokeLLL;
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int i2;
        int i3;
        Track track2;
        int i4;
        long[] jArr;
        int[] iArr;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        boolean z2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        long[] jArr3;
        int i6;
        int[] iArr6;
        int i7;
        int i8;
        int i9;
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
            ParsableByteArray parsableByteArray = leafAtomOfType3.data;
            ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
            ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
            ParsableByteArray parsableByteArray4 = null;
            ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
            Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
            ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
            ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
            parsableByteArray3.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
            int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
            int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
            if (parsableByteArray6 != null) {
                parsableByteArray6.setPosition(12);
                i2 = parsableByteArray6.readUnsignedIntToInt();
            } else {
                i2 = 0;
            }
            int i10 = -1;
            if (parsableByteArray5 != null) {
                parsableByteArray5.setPosition(12);
                i3 = parsableByteArray5.readUnsignedIntToInt();
                if (i3 > 0) {
                    i10 = parsableByteArray5.readUnsignedIntToInt() - 1;
                    parsableByteArray4 = parsableByteArray5;
                }
            } else {
                parsableByteArray4 = parsableByteArray5;
                i3 = 0;
            }
            long j4 = 0;
            if (!(stz2SampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i2 == 0 && i3 == 0)) {
                long[] jArr4 = new long[sampleCount];
                iArr = new int[sampleCount];
                jArr2 = new long[sampleCount];
                int i11 = i3;
                iArr2 = new int[sampleCount];
                int i12 = i10;
                long j5 = 0;
                j2 = 0;
                int i13 = 0;
                i5 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = i2;
                int i18 = readUnsignedIntToInt3;
                int i19 = readUnsignedIntToInt2;
                int i20 = readUnsignedIntToInt;
                int i21 = i11;
                while (i13 < sampleCount) {
                    while (i15 == 0) {
                        Assertions.checkState(chunkIterator.moveNext());
                        j5 = chunkIterator.offset;
                        i15 = chunkIterator.numSamples;
                        i18 = i18;
                        i19 = i19;
                    }
                    int i22 = i19;
                    int i23 = i18;
                    if (parsableByteArray6 != null) {
                        while (i14 == 0 && i17 > 0) {
                            i14 = parsableByteArray6.readUnsignedIntToInt();
                            i16 = parsableByteArray6.readInt();
                            i17--;
                        }
                        i14--;
                    }
                    int i24 = i16;
                    jArr4[i13] = j5;
                    iArr[i13] = stz2SampleSizeBox.readNextSampleSize();
                    if (iArr[i13] > i5) {
                        i5 = iArr[i13];
                    }
                    int i25 = sampleCount;
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    jArr2[i13] = j2 + i24;
                    iArr2[i13] = parsableByteArray4 == null ? 1 : 0;
                    if (i13 == i12) {
                        iArr2[i13] = 1;
                        i21--;
                        if (i21 > 0) {
                            i12 = parsableByteArray4.readUnsignedIntToInt() - 1;
                        }
                    }
                    long[] jArr5 = jArr4;
                    j2 += i23;
                    int i26 = i22 - 1;
                    if (i26 != 0 || i20 <= 0) {
                        i8 = i23;
                        i9 = i26;
                    } else {
                        i9 = parsableByteArray3.readUnsignedIntToInt();
                        i8 = parsableByteArray3.readInt();
                        i20--;
                    }
                    int i27 = i9;
                    j5 += iArr[i13];
                    i15--;
                    i13++;
                    sampleCount = i25;
                    jArr4 = jArr5;
                    i12 = i12;
                    i16 = i24;
                    i19 = i27;
                    i18 = i8;
                    stz2SampleSizeBox = sampleSizeBox;
                }
                i4 = sampleCount;
                long[] jArr6 = jArr4;
                int i28 = i19;
                Assertions.checkArgument(i14 == 0);
                while (i17 > 0) {
                    Assertions.checkArgument(parsableByteArray6.readUnsignedIntToInt() == 0);
                    parsableByteArray6.readInt();
                    i17--;
                }
                if (i21 == 0 && i28 == 0) {
                    i7 = i15;
                    if (i7 == 0 && i20 == 0) {
                        track2 = track;
                        jArr = jArr6;
                    }
                } else {
                    i7 = i15;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                track2 = track;
                sb.append(track2.id);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i21);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i28);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i7);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i20);
                sb.toString();
                jArr = jArr6;
            } else {
                track2 = track;
                i4 = sampleCount;
                SampleSizeBox sampleSizeBox2 = stz2SampleSizeBox;
                int i29 = chunkIterator.length;
                long[] jArr7 = new long[i29];
                int[] iArr7 = new int[i29];
                while (chunkIterator.moveNext()) {
                    int i30 = chunkIterator.index;
                    jArr7[i30] = chunkIterator.offset;
                    iArr7[i30] = chunkIterator.numSamples;
                }
                FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(sampleSizeBox2.readNextSampleSize(), jArr7, iArr7, readUnsignedIntToInt3);
                jArr = rechunk.offsets;
                iArr = rechunk.sizes;
                i5 = rechunk.maximumSize;
                jArr2 = rechunk.timestamps;
                iArr2 = rechunk.flags;
                j2 = 0;
            }
            if (track2.editListDurations != null && !gaplessInfoHolder.hasGaplessInfo()) {
                long[] jArr8 = track2.editListDurations;
                if (jArr8.length == 1 && track2.type == 1 && jArr2.length >= 2) {
                    long j6 = track2.editListMediaTimes[0];
                    long scaleLargeTimestamp = Util.scaleLargeTimestamp(jArr8[0], track2.timescale, track2.movieTimescale) + j6;
                    if (jArr2[0] <= j6 && j6 < jArr2[1] && jArr2[jArr2.length - 1] < scaleLargeTimestamp && scaleLargeTimestamp <= j2) {
                        long j7 = j2 - scaleLargeTimestamp;
                        long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j6 - jArr2[0], track2.format.sampleRate, track2.timescale);
                        long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j7, track2.format.sampleRate, track2.timescale);
                        if ((scaleLargeTimestamp2 != 0 || scaleLargeTimestamp3 != 0) && scaleLargeTimestamp2 <= 2147483647L && scaleLargeTimestamp3 <= 2147483647L) {
                            gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp2;
                            gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp3;
                            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                            return new TrackSampleTable(jArr, iArr, i5, jArr2, iArr2);
                        }
                    }
                }
                long[] jArr9 = track2.editListDurations;
                if (jArr9.length == 1) {
                    char c2 = 0;
                    if (jArr9[0] == 0) {
                        int i31 = 0;
                        while (i31 < jArr2.length) {
                            jArr2[i31] = Util.scaleLargeTimestamp(jArr2[i31] - track2.editListMediaTimes[c2], 1000000L, track2.timescale);
                            i31++;
                            c2 = 0;
                        }
                        return new TrackSampleTable(jArr, iArr, i5, jArr2, iArr2);
                    }
                }
                boolean z3 = track2.type == 1;
                boolean z4 = false;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                while (true) {
                    long[] jArr10 = track2.editListDurations;
                    j3 = -1;
                    if (i32 >= jArr10.length) {
                        break;
                    }
                    long j8 = track2.editListMediaTimes[i32];
                    if (j8 != -1) {
                        i6 = i5;
                        iArr6 = iArr;
                        long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(jArr10[i32], track2.timescale, track2.movieTimescale);
                        int binarySearchCeil = Util.binarySearchCeil(jArr2, j8, true, true);
                        int binarySearchCeil2 = Util.binarySearchCeil(jArr2, j8 + scaleLargeTimestamp4, z3, false);
                        i33 += binarySearchCeil2 - binarySearchCeil;
                        z4 |= i34 != binarySearchCeil;
                        i34 = binarySearchCeil2;
                    } else {
                        i6 = i5;
                        iArr6 = iArr;
                    }
                    i32++;
                    iArr = iArr6;
                    i5 = i6;
                }
                int i35 = i5;
                int[] iArr8 = iArr;
                boolean z5 = z4 | (i33 != i4);
                long[] jArr11 = z5 ? new long[i33] : jArr;
                int[] iArr9 = z5 ? new int[i33] : iArr8;
                int i36 = z5 ? 0 : i35;
                int[] iArr10 = z5 ? new int[i33] : iArr2;
                long[] jArr12 = new long[i33];
                int i37 = i36;
                int i38 = 0;
                int i39 = 0;
                while (true) {
                    long[] jArr13 = track2.editListDurations;
                    if (i38 >= jArr13.length) {
                        break;
                    }
                    long[] jArr14 = jArr12;
                    int[] iArr11 = iArr10;
                    long j9 = track2.editListMediaTimes[i38];
                    long j10 = jArr13[i38];
                    if (j9 != j3) {
                        int binarySearchCeil3 = Util.binarySearchCeil(jArr2, j9, true, true);
                        int binarySearchCeil4 = Util.binarySearchCeil(jArr2, Util.scaleLargeTimestamp(j10, track2.timescale, track2.movieTimescale) + j9, z3, false);
                        if (z5) {
                            int i40 = binarySearchCeil4 - binarySearchCeil3;
                            System.arraycopy(jArr, binarySearchCeil3, jArr11, i39, i40);
                            iArr5 = iArr8;
                            System.arraycopy(iArr5, binarySearchCeil3, iArr9, i39, i40);
                            z2 = z3;
                            iArr4 = iArr11;
                            System.arraycopy(iArr2, binarySearchCeil3, iArr4, i39, i40);
                        } else {
                            iArr5 = iArr8;
                            z2 = z3;
                            iArr4 = iArr11;
                        }
                        int i41 = i37;
                        while (binarySearchCeil3 < binarySearchCeil4) {
                            long[] jArr15 = jArr;
                            int[] iArr12 = iArr2;
                            long j11 = j9;
                            jArr14[i39] = Util.scaleLargeTimestamp(j4, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr2[binarySearchCeil3] - j9, 1000000L, track2.timescale);
                            if (z5 && iArr9[i39] > i41) {
                                i41 = iArr5[binarySearchCeil3];
                            }
                            i39++;
                            binarySearchCeil3++;
                            jArr = jArr15;
                            j9 = j11;
                            iArr2 = iArr12;
                        }
                        jArr3 = jArr;
                        iArr3 = iArr2;
                        i37 = i41;
                    } else {
                        z2 = z3;
                        iArr3 = iArr2;
                        iArr4 = iArr11;
                        iArr5 = iArr8;
                        jArr3 = jArr;
                    }
                    j4 += j10;
                    i38++;
                    jArr = jArr3;
                    iArr10 = iArr4;
                    iArr8 = iArr5;
                    z3 = z2;
                    jArr12 = jArr14;
                    iArr2 = iArr3;
                    j3 = -1;
                }
                int[] iArr13 = iArr8;
                long[] jArr16 = jArr;
                int[] iArr14 = iArr2;
                long[] jArr17 = jArr12;
                int[] iArr15 = iArr10;
                boolean z6 = false;
                for (int i42 = 0; i42 < iArr15.length && !z6; i42++) {
                    z6 |= (iArr15[i42] & 1) != 0;
                }
                if (!z6) {
                    Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
                    return new TrackSampleTable(jArr16, iArr13, i35, jArr2, iArr14);
                }
                return new TrackSampleTable(jArr11, iArr9, i37, jArr17, iArr15);
            }
            int i43 = i5;
            int[] iArr16 = iArr;
            Util.scaleLargeTimestampsInPlace(jArr2, 1000000L, track2.timescale);
            return new TrackSampleTable(jArr, iArr16, i43, jArr2, iArr2);
        }
        return (TrackSampleTable) invokeLLL.objValue;
    }

    public static StsdData parseStsd(ParsableByteArray parsableByteArray, int i2, int i3, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), str, drmInitData, Boolean.valueOf(z)})) == null) {
            parsableByteArray.setPosition(12);
            int readInt = parsableByteArray.readInt();
            StsdData stsdData = new StsdData(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                int position = parsableByteArray.getPosition();
                int readInt2 = parsableByteArray.readInt();
                Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
                int readInt3 = parsableByteArray.readInt();
                if (readInt3 != Atom.TYPE_avc1 && readInt3 != Atom.TYPE_avc3 && readInt3 != Atom.TYPE_encv && readInt3 != Atom.TYPE_mp4v && readInt3 != Atom.TYPE_hvc1 && readInt3 != Atom.TYPE_hev1 && readInt3 != Atom.TYPE_s263 && readInt3 != Atom.TYPE_vp08 && readInt3 != Atom.TYPE_vp09) {
                    if (readInt3 != Atom.TYPE_mp4a && readInt3 != Atom.TYPE_enca && readInt3 != Atom.TYPE_ac_3 && readInt3 != Atom.TYPE_ec_3 && readInt3 != Atom.TYPE_dtsc && readInt3 != Atom.TYPE_dtse && readInt3 != Atom.TYPE_dtsh && readInt3 != Atom.TYPE_dtsl && readInt3 != Atom.TYPE_samr && readInt3 != Atom.TYPE_sawb && readInt3 != Atom.TYPE_lpcm && readInt3 != Atom.TYPE_sowt && readInt3 != Atom.TYPE__mp3 && readInt3 != Atom.TYPE_alac) {
                        if (readInt3 != Atom.TYPE_TTML && readInt3 != Atom.TYPE_tx3g && readInt3 != Atom.TYPE_wvtt && readInt3 != Atom.TYPE_stpp && readInt3 != Atom.TYPE_c608) {
                            if (readInt3 == Atom.TYPE_camm) {
                                stsdData.format = Format.createSampleFormat(Integer.toString(i2), MimeTypes.APPLICATION_CAMERA_MOTION, null, -1, null);
                            }
                        } else {
                            parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i2, str, stsdData);
                        }
                    } else {
                        parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i2, str, z, drmInitData, stsdData, i4);
                    }
                } else {
                    parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i2, i3, drmInitData, stsdData, i4);
                }
                parsableByteArray.setPosition(position + readInt2);
            }
            return stsdData;
        }
        return (StsdData) invokeCommon.objValue;
    }

    public static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, String str, StsdData stsdData) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, stsdData}) == null) {
            parsableByteArray.setPosition(i3 + 8 + 8);
            int i6 = Atom.TYPE_TTML;
            String str2 = MimeTypes.APPLICATION_TTML;
            List list = null;
            long j2 = Long.MAX_VALUE;
            if (i2 != i6) {
                if (i2 == Atom.TYPE_tx3g) {
                    int i7 = (i4 - 8) - 8;
                    byte[] bArr = new byte[i7];
                    parsableByteArray.readBytes(bArr, 0, i7);
                    list = Collections.singletonList(bArr);
                    str2 = MimeTypes.APPLICATION_TX3G;
                } else if (i2 == Atom.TYPE_wvtt) {
                    str2 = MimeTypes.APPLICATION_MP4VTT;
                } else if (i2 == Atom.TYPE_stpp) {
                    j2 = 0;
                } else if (i2 == Atom.TYPE_c608) {
                    stsdData.requiredSampleTransformation = 1;
                    str2 = MimeTypes.APPLICATION_MP4CEA608;
                } else {
                    throw new IllegalStateException();
                }
            }
            stsdData.format = Format.createTextSampleFormat(Integer.toString(i5), str2, null, -1, 0, str, -1, null, j2, list);
        }
    }

    public static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, parsableByteArray)) == null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
            int readInt = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            int position = parsableByteArray.getPosition();
            int i2 = parseFullAtomVersion == 0 ? 4 : 8;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    z = true;
                    break;
                } else if (parsableByteArray.data[position + i4] != -1) {
                    z = false;
                    break;
                } else {
                    i4++;
                }
            }
            long j2 = C.TIME_UNSET;
            if (z) {
                parsableByteArray.skipBytes(i2);
            } else {
                long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (readUnsignedInt != 0) {
                    j2 = readUnsignedInt;
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
            return new TkhdData(readInt, j2, i3);
        }
        return (TkhdData) invokeL.objValue;
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j2, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        InterceptResult invokeCommon;
        Atom.LeafAtom leafAtom2;
        long j3;
        long[] jArr;
        long[] jArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{containerAtom, leafAtom, Long.valueOf(j2), drmInitData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
            int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
            if (parseHdlr == -1) {
                return null;
            }
            TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
            long j4 = C.TIME_UNSET;
            if (j2 == C.TIME_UNSET) {
                leafAtom2 = leafAtom;
                j3 = parseTkhd.duration;
            } else {
                leafAtom2 = leafAtom;
                j3 = j2;
            }
            long parseMvhd = parseMvhd(leafAtom2.data);
            if (j3 != C.TIME_UNSET) {
                j4 = Util.scaleLargeTimestamp(j3, 1000000L, parseMvhd);
            }
            long j5 = j4;
            Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
            Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
            StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
            if (z) {
                jArr = null;
                jArr2 = null;
            } else {
                Pair<long[], long[]> parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
                jArr2 = (long[]) parseEdts.second;
                jArr = (long[]) parseEdts.first;
            }
            if (parseStsd.format == null) {
                return null;
            }
            return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j5, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
        }
        return (Track) invokeCommon.objValue;
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

    public static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, StsdData stsdData, int i7) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{parsableByteArray, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), drmInitData, stsdData, Integer.valueOf(i7)}) == null) {
            DrmInitData drmInitData2 = drmInitData;
            parsableByteArray.setPosition(i3 + 8 + 8);
            parsableByteArray.skipBytes(16);
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(50);
            int position = parsableByteArray.getPosition();
            String str = null;
            int i8 = i2;
            if (i8 == Atom.TYPE_encv) {
                Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i3, i4);
                if (parseSampleEntryEncryptionData != null) {
                    i8 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                    drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                    stsdData.trackEncryptionBoxes[i7] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
                }
                parsableByteArray.setPosition(position);
            }
            DrmInitData drmInitData3 = drmInitData2;
            List<byte[]> list = null;
            byte[] bArr = null;
            boolean z = false;
            float f2 = 1.0f;
            int i9 = -1;
            while (position - i3 < i4) {
                parsableByteArray.setPosition(position);
                int position2 = parsableByteArray.getPosition();
                int readInt = parsableByteArray.readInt();
                if (readInt == 0 && parsableByteArray.getPosition() - i3 == i4) {
                    break;
                }
                Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
                int readInt2 = parsableByteArray.readInt();
                if (readInt2 == Atom.TYPE_avcC) {
                    Assertions.checkState(str == null);
                    parsableByteArray.setPosition(position2 + 8);
                    AvcConfig parse = AvcConfig.parse(parsableByteArray);
                    list = parse.initializationData;
                    stsdData.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                    if (!z) {
                        f2 = parse.pixelWidthAspectRatio;
                    }
                    str = "video/avc";
                } else if (readInt2 == Atom.TYPE_hvcC) {
                    Assertions.checkState(str == null);
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                    list = parse2.initializationData;
                    stsdData.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str = MimeTypes.VIDEO_H265;
                } else if (readInt2 == Atom.TYPE_vpcC) {
                    Assertions.checkState(str == null);
                    str = i8 == Atom.TYPE_vp08 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (readInt2 == Atom.TYPE_d263) {
                    Assertions.checkState(str == null);
                    str = MimeTypes.VIDEO_H263;
                } else if (readInt2 == Atom.TYPE_esds) {
                    Assertions.checkState(str == null);
                    Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                    str = (String) parseEsdsFromParent.first;
                    list = Collections.singletonList(parseEsdsFromParent.second);
                } else if (readInt2 == Atom.TYPE_pasp) {
                    f2 = parsePaspFromParent(parsableByteArray, position2);
                    z = true;
                } else if (readInt2 == Atom.TYPE_sv3d) {
                    bArr = parseProjFromParent(parsableByteArray, position2, readInt);
                } else if (readInt2 == Atom.TYPE_st3d) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(3);
                    if (readUnsignedByte == 0) {
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        if (readUnsignedByte2 == 0) {
                            i9 = 0;
                        } else if (readUnsignedByte2 == 1) {
                            i9 = 1;
                        } else if (readUnsignedByte2 == 2) {
                            i9 = 2;
                        } else if (readUnsignedByte2 == 3) {
                            i9 = 3;
                        }
                    }
                }
                position += readInt;
            }
            if (str == null) {
                return;
            }
            stsdData.format = Format.createVideoSampleFormat(Integer.toString(i5), str, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list, i6, f2, bArr, i9, null, drmInitData3);
        }
    }
}
