package com.google.zxing.oned.rss.expanded;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] EVEN_TOTAL_SUBSET;
    public static final int[][] FINDER_PATTERNS;
    public static final int[][] FINDER_PATTERN_SEQUENCES;
    public static final int FINDER_PAT_A = 0;
    public static final int FINDER_PAT_B = 1;
    public static final int FINDER_PAT_C = 2;
    public static final int FINDER_PAT_D = 3;
    public static final int FINDER_PAT_E = 4;
    public static final int FINDER_PAT_F = 5;
    public static final int[] GSUM;
    public static final int MAX_PAIRS = 11;
    public static final int[] SYMBOL_WIDEST;
    public static final int[][] WEIGHTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ExpandedPair> pairs;
    public final List<ExpandedRow> rows;
    public final int[] startEnd;
    public boolean startFromEven;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1046126884, "Lcom/google/zxing/oned/rss/expanded/RSSExpandedReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1046126884, "Lcom/google/zxing/oned/rss/expanded/RSSExpandedReader;");
                return;
            }
        }
        SYMBOL_WIDEST = new int[]{7, 5, 4, 3, 1};
        EVEN_TOTAL_SUBSET = new int[]{4, 20, 52, 104, 204};
        GSUM = new int[]{0, 348, 1388, 2948, 3988};
        FINDER_PATTERNS = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
        WEIGHTS = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Cea708Decoder.COMMAND_RST, 7, 21, 63}, new int[]{PsExtractor.PRIVATE_STREAM_1, Cea708Decoder.COMMAND_SPC, 13, 39, 117, Cea708Decoder.COMMAND_DLW, 209, 205}, new int[]{193, Cea708Decoder.COMMAND_DF5, 49, 147, 19, 57, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 91}, new int[]{62, MatroskaExtractor.ID_PIXEL_HEIGHT, 136, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 169, 85, 44, 132}, new int[]{Constants.METHOD_IM_SEND_MCAST_MSG, 133, TsExtractor.TS_PACKET_SIZE, Cea708Decoder.COMMAND_DLC, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, Cea708Decoder.COMMAND_DF6, 52, Cea708Decoder.COMMAND_DS4}, new int[]{46, 138, 203, MatroskaExtractor.ID_CUE_POINT, Cea708Decoder.COMMAND_TGW, 206, 196, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, MatroskaExtractor.ID_PIXEL_WIDTH, 106, 107, 110, 119, Cea708Decoder.COMMAND_SPL}, new int[]{16, 48, Cea708Decoder.COMMAND_SPA, 10, 30, 90, 59, 177}, new int[]{109, 116, Cea708Decoder.COMMAND_DSW, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, H262Reader.START_GROUP, 130, 179, 115}, new int[]{134, 191, Cea708Decoder.COMMAND_SWA, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, BDLocation.TypeServerDecryptError, 64, 192, Cea708Decoder.COMMAND_DF2, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, MatroskaExtractor.ID_TRACK_ENTRY, 100, 89}};
        FINDER_PATTERN_SEQUENCES = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    }

    public RSSExpandedReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pairs = new ArrayList(11);
        this.rows = new ArrayList();
        this.startEnd = new int[2];
    }

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            int sum = MathUtils.sum(getOddCounts());
            int sum2 = MathUtils.sum(getEvenCounts());
            boolean z5 = true;
            if (sum > 13) {
                z = false;
                z2 = true;
            } else {
                z = sum < 4;
                z2 = false;
            }
            if (sum2 > 13) {
                z3 = false;
                z4 = true;
            } else {
                z3 = sum2 < 4;
                z4 = false;
            }
            int i2 = (sum + sum2) - i;
            boolean z6 = (sum & 1) == 1;
            boolean z7 = (sum2 & 1) == 0;
            if (i2 == 1) {
                if (z6) {
                    if (z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z5 = z;
                    z2 = true;
                } else if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z5 = z;
                    z4 = true;
                }
            } else if (i2 == -1) {
                if (z6) {
                    if (z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z5 = z;
                    z3 = true;
                }
            } else if (i2 != 0) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                if (z6) {
                    if (!z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (sum >= sum2) {
                        z5 = z;
                        z3 = true;
                        z2 = true;
                    }
                    z4 = true;
                } else if (z7) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    z5 = z;
                }
            }
            if (z5) {
                if (!z2) {
                    AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z2) {
                AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
            }
            if (z3) {
                if (!z4) {
                    AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
                } else {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z4) {
                AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
            }
        }
    }

    private boolean checkChecksum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ExpandedPair expandedPair = this.pairs.get(0);
            DataCharacter leftChar = expandedPair.getLeftChar();
            DataCharacter rightChar = expandedPair.getRightChar();
            if (rightChar == null) {
                return false;
            }
            int checksumPortion = rightChar.getChecksumPortion();
            int i = 2;
            for (int i2 = 1; i2 < this.pairs.size(); i2++) {
                ExpandedPair expandedPair2 = this.pairs.get(i2);
                checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
                i++;
                DataCharacter rightChar2 = expandedPair2.getRightChar();
                if (rightChar2 != null) {
                    checksumPortion += rightChar2.getChecksumPortion();
                    i++;
                }
            }
            return ((i + (-4)) * 211) + (checksumPortion % 211) == leftChar.getValue();
        }
        return invokeV.booleanValue;
    }

    private List<ExpandedPair> checkRows(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65541, this, z)) == null) {
            List<ExpandedPair> list = null;
            if (this.rows.size() > 25) {
                this.rows.clear();
                return null;
            }
            this.pairs.clear();
            if (z) {
                Collections.reverse(this.rows);
            }
            try {
                list = checkRows(new ArrayList(), 0);
            } catch (NotFoundException unused) {
            }
            if (z) {
                Collections.reverse(this.rows);
            }
            return list;
        }
        return (List) invokeZ.objValue;
    }

    public static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
            ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
            ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
            return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
        }
        return (Result) invokeL.objValue;
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, this, bitArray, list, i) == null) {
            int[] decodeFinderCounters = getDecodeFinderCounters();
            decodeFinderCounters[0] = 0;
            decodeFinderCounters[1] = 0;
            decodeFinderCounters[2] = 0;
            decodeFinderCounters[3] = 0;
            int size = bitArray.getSize();
            if (i < 0) {
                i = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
            boolean z = list.size() % 2 != 0;
            if (this.startFromEven) {
                z = !z;
            }
            boolean z2 = false;
            while (i < size) {
                z2 = !bitArray.get(i);
                if (!z2) {
                    break;
                }
                i++;
            }
            boolean z3 = z2;
            int i2 = 0;
            int i3 = i;
            while (i < size) {
                if (bitArray.get(i) ^ z3) {
                    decodeFinderCounters[i2] = decodeFinderCounters[i2] + 1;
                } else {
                    if (i2 == 3) {
                        if (z) {
                            reverseCounters(decodeFinderCounters);
                        }
                        if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                            int[] iArr = this.startEnd;
                            iArr[0] = i3;
                            iArr[1] = i;
                            return;
                        }
                        if (z) {
                            reverseCounters(decodeFinderCounters);
                        }
                        i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                        decodeFinderCounters[0] = decodeFinderCounters[2];
                        decodeFinderCounters[1] = decodeFinderCounters[3];
                        decodeFinderCounters[2] = 0;
                        decodeFinderCounters[3] = 0;
                        i2--;
                    } else {
                        i2++;
                    }
                    decodeFinderCounters[i2] = 1;
                    z3 = !z3;
                }
                i++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static int getNextSecondBar(BitArray bitArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bitArray, i)) == null) {
            if (bitArray.get(i)) {
                return bitArray.getNextSet(bitArray.getNextUnset(i));
            }
            return bitArray.getNextUnset(bitArray.getNextSet(i));
        }
        return invokeLI.intValue;
    }

    public static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{finderPattern, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? (finderPattern.getValue() == 0 && z && z2) ? false : true : invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, iterable, iterable2)) == null) {
            Iterator<ExpandedRow> it = iterable2.iterator();
            do {
                z = false;
                if (!it.hasNext()) {
                    return false;
                }
                ExpandedRow next = it.next();
                Iterator<ExpandedPair> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    ExpandedPair next2 = it2.next();
                    Iterator<ExpandedPair> it3 = next.getPairs().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = false;
                            continue;
                            break;
                        } else if (next2.equals(it3.next())) {
                            z2 = true;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
            } while (!z);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isValidSequence(List<ExpandedPair> list) {
        InterceptResult invokeL;
        int[][] iArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, list)) == null) {
            for (int[] iArr2 : FINDER_PATTERN_SEQUENCES) {
                if (list.size() <= iArr2.length) {
                    int i = 0;
                    while (true) {
                        if (i >= list.size()) {
                            z = true;
                            break;
                        } else if (list.get(i).getFinderPattern().getValue() != iArr2[i]) {
                            z = false;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (z) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{bitArray, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                int i5 = this.startEnd[0] - 1;
                while (i5 >= 0 && !bitArray.get(i5)) {
                    i5--;
                }
                int i6 = i5 + 1;
                int[] iArr = this.startEnd;
                i4 = iArr[0] - i6;
                i2 = iArr[1];
                i3 = i6;
            } else {
                int[] iArr2 = this.startEnd;
                int i7 = iArr2[0];
                int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
                i2 = nextUnset;
                i3 = i7;
                i4 = nextUnset - this.startEnd[1];
            }
            int[] decodeFinderCounters = getDecodeFinderCounters();
            System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
            decodeFinderCounters[0] = i4;
            try {
                return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i3, i2}, i3, i2, i);
            } catch (NotFoundException unused) {
                return null;
            }
        }
        return (FinderPattern) invokeCommon.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0050, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, list, list2) == null) {
            Iterator<ExpandedRow> it = list2.iterator();
            while (it.hasNext()) {
                ExpandedRow next = it.next();
                if (next.getPairs().size() != list.size()) {
                    Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                    while (true) {
                        z = false;
                        boolean z2 = true;
                        if (!it2.hasNext()) {
                            z = true;
                            break;
                        }
                        ExpandedPair next2 = it2.next();
                        Iterator<ExpandedPair> it3 = list.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z2 = false;
                                continue;
                                break;
                            } else if (next2.equals(it3.next())) {
                                break;
                            }
                        }
                        if (!z2) {
                            break;
                        }
                    }
                    if (z) {
                        it.remove();
                    }
                }
            }
        }
    }

    public static void reverseCounters(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, iArr) == null) {
            int length = iArr.length;
            for (int i = 0; i < length / 2; i++) {
                int i2 = iArr[i];
                int i3 = (length - i) - 1;
                iArr[i] = iArr[i3];
                iArr[i3] = i2;
            }
        }
    }

    private void storeRow(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            boolean z2 = false;
            int i2 = 0;
            boolean z3 = false;
            while (true) {
                if (i2 >= this.rows.size()) {
                    break;
                }
                ExpandedRow expandedRow = this.rows.get(i2);
                if (expandedRow.getRowNumber() > i) {
                    z2 = expandedRow.isEquivalent(this.pairs);
                    break;
                } else {
                    z3 = expandedRow.isEquivalent(this.pairs);
                    i2++;
                }
            }
            if (z2 || z3 || isPartialRow(this.pairs, this.rows)) {
                return;
            }
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitArray, finderPattern, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] dataCharacterCounters = getDataCharacterCounters();
            dataCharacterCounters[0] = 0;
            dataCharacterCounters[1] = 0;
            dataCharacterCounters[2] = 0;
            dataCharacterCounters[3] = 0;
            dataCharacterCounters[4] = 0;
            dataCharacterCounters[5] = 0;
            dataCharacterCounters[6] = 0;
            dataCharacterCounters[7] = 0;
            if (z2) {
                OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
            } else {
                OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
                int i = 0;
                for (int length = dataCharacterCounters.length - 1; i < length; length--) {
                    int i2 = dataCharacterCounters[i];
                    dataCharacterCounters[i] = dataCharacterCounters[length];
                    dataCharacterCounters[length] = i2;
                    i++;
                }
            }
            float sum = MathUtils.sum(dataCharacterCounters) / 17.0f;
            float f = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
            if (Math.abs(sum - f) / f <= 0.3f) {
                int[] oddCounts = getOddCounts();
                int[] evenCounts = getEvenCounts();
                float[] oddRoundingErrors = getOddRoundingErrors();
                float[] evenRoundingErrors = getEvenRoundingErrors();
                for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
                    float f2 = (dataCharacterCounters[i3] * 1.0f) / sum;
                    int i4 = (int) (0.5f + f2);
                    if (i4 <= 0) {
                        if (f2 < 0.3f) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i4 = 1;
                    } else if (i4 > 8) {
                        if (f2 > 8.7f) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i4 = 8;
                    }
                    int i5 = i3 / 2;
                    if ((i3 & 1) == 0) {
                        oddCounts[i5] = i4;
                        oddRoundingErrors[i5] = f2 - i4;
                    } else {
                        evenCounts[i5] = i4;
                        evenRoundingErrors[i5] = f2 - i4;
                    }
                }
                adjustOddEvenCounts(17);
                int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
                int i6 = 0;
                int i7 = 0;
                for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                    if (isNotA1left(finderPattern, z, z2)) {
                        i6 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                    }
                    i7 += oddCounts[length2];
                }
                int i8 = 0;
                for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                    if (isNotA1left(finderPattern, z, z2)) {
                        i8 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                    }
                }
                int i9 = i6 + i8;
                if ((i7 & 1) == 0 && i7 <= 13 && i7 >= 4) {
                    int i10 = (13 - i7) / 2;
                    int i11 = SYMBOL_WIDEST[i10];
                    return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i11, true) * EVEN_TOTAL_SUBSET[i10]) + RSSUtils.getRSSvalue(evenCounts, 9 - i11, false) + GSUM[i10], i9);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (DataCharacter) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bitArray, map)) == null) {
            this.pairs.clear();
            this.startFromEven = false;
            try {
                return constructResult(decodeRow2pairs(i, bitArray));
            } catch (NotFoundException unused) {
                this.pairs.clear();
                this.startFromEven = true;
                return constructResult(decodeRow2pairs(i, bitArray));
            }
        }
        return (Result) invokeILL.objValue;
    }

    public List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bitArray)) != null) {
            return (List) invokeIL.objValue;
        }
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (!this.pairs.isEmpty()) {
                    if (checkChecksum()) {
                        return this.pairs;
                    }
                    boolean z = !this.rows.isEmpty();
                    storeRow(i, false);
                    if (z) {
                        List<ExpandedPair> checkRows = checkRows(false);
                        if (checkRows != null) {
                            return checkRows;
                        }
                        List<ExpandedPair> checkRows2 = checkRows(true);
                        if (checkRows2 != null) {
                            return checkRows2;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw e;
            }
        }
    }

    public List<ExpandedRow> getRows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rows : (List) invokeV.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.pairs.clear();
            this.rows.clear();
        }
    }

    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        InterceptResult invokeLLI;
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, bitArray, list, i)) == null) {
            boolean z = list.size() % 2 == 0;
            if (this.startFromEven) {
                z = !z;
            }
            int i2 = -1;
            boolean z2 = true;
            do {
                findNextPair(bitArray, list, i2);
                parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
                if (parseFoundFinderPattern == null) {
                    i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
            } while (z2);
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
            if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
                throw NotFoundException.getNotFoundInstance();
            }
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
        }
        return (ExpandedPair) invokeLLI.objValue;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, list, i)) == null) {
            while (i < this.rows.size()) {
                ExpandedRow expandedRow = this.rows.get(i);
                this.pairs.clear();
                for (ExpandedRow expandedRow2 : list) {
                    this.pairs.addAll(expandedRow2.getPairs());
                }
                this.pairs.addAll(expandedRow.getPairs());
                if (isValidSequence(this.pairs)) {
                    if (checkChecksum()) {
                        return this.pairs;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    arrayList.add(expandedRow);
                    try {
                        return checkRows(arrayList, i + 1);
                    } catch (NotFoundException unused) {
                        continue;
                    }
                }
                i++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (List) invokeLI.objValue;
    }
}
