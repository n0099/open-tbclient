package com.google.android.exoplayer2.extractor.mp4;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Sniffer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] COMPATIBLE_BRANDS;
    public static final int SEARCH_LENGTH = 4096;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-135443481, "Lcom/google/android/exoplayer2/extractor/mp4/Sniffer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-135443481, "Lcom/google/android/exoplayer2/extractor/mp4/Sniffer;");
                return;
            }
        }
        COMPATIBLE_BRANDS = new int[]{Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString(MediaCodecUtil.CODEC_ID_HVC1), Util.getIntegerCodeForString(MediaCodecUtil.CODEC_ID_HEV1), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    }

    public Sniffer() {
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

    public static boolean isCompatibleBrand(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if ((i >>> 8) == Util.getIntegerCodeForString("3gp")) {
                return true;
            }
            for (int i2 : COMPATIBLE_BRANDS) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, extractorInput)) == null) ? sniffInternal(extractorInput, true) : invokeL.booleanValue;
    }

    public static boolean sniffInternal(ExtractorInput extractorInput, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, extractorInput, z)) == null) {
            long length = extractorInput.getLength();
            long j = -1;
            if (length == -1 || length > 4096) {
                length = 4096;
            }
            int i = (int) length;
            ParsableByteArray parsableByteArray = new ParsableByteArray(64);
            int i2 = 0;
            boolean z3 = false;
            while (i2 < i) {
                parsableByteArray.reset(8);
                extractorInput.peekFully(parsableByteArray.data, 0, 8);
                long readUnsignedInt = parsableByteArray.readUnsignedInt();
                int readInt = parsableByteArray.readInt();
                int i3 = 16;
                if (readUnsignedInt == 1) {
                    extractorInput.peekFully(parsableByteArray.data, 8, 8);
                    parsableByteArray.setLimit(16);
                    readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
                } else {
                    if (readUnsignedInt == 0) {
                        long length2 = extractorInput.getLength();
                        if (length2 != j) {
                            readUnsignedInt = 8 + (length2 - extractorInput.getPosition());
                        }
                    }
                    i3 = 8;
                }
                long j2 = i3;
                if (readUnsignedInt < j2) {
                    return false;
                }
                i2 += i3;
                if (readInt != Atom.TYPE_moov) {
                    if (readInt == Atom.TYPE_moof || readInt == Atom.TYPE_mvex) {
                        z2 = true;
                        break;
                    } else if ((i2 + readUnsignedInt) - j2 >= i) {
                        break;
                    } else {
                        int i4 = (int) (readUnsignedInt - j2);
                        i2 += i4;
                        if (readInt == Atom.TYPE_ftyp) {
                            if (i4 < 8) {
                                return false;
                            }
                            parsableByteArray.reset(i4);
                            extractorInput.peekFully(parsableByteArray.data, 0, i4);
                            int i5 = i4 / 4;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    break;
                                }
                                if (i6 == 1) {
                                    parsableByteArray.skipBytes(4);
                                } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                                    z3 = true;
                                    break;
                                }
                                i6++;
                            }
                            if (!z3) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            extractorInput.advancePeekPosition(i4);
                        }
                        j = -1;
                    }
                }
            }
            z2 = false;
            return z3 && z == z2;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, extractorInput)) == null) ? sniffInternal(extractorInput, false) : invokeL.booleanValue;
    }
}
