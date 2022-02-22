package com.google.zxing.oned.rss.expanded;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.tieba.advert.sdk.stretagy.SplashNativePolicy;
import com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.utils.ContactPermissionUtil;
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
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
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
        WEIGHTS = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, w0.x0, 7, 21, 63}, new int[]{189, w0.n, 13, 39, 117, PbFullScreenEditorActivity.REPLY_MAX_SIZE, 209, 205}, new int[]{193, w0.p0, 49, 147, 19, 57, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 91}, new int[]{62, w0.e0, 136, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 169, 85, 44, 132}, new int[]{185, SplashNativePolicy.SPLASH_CMD_ERROR, Opcodes.NEWARRAY, 142, 4, 12, 36, 108}, new int[]{113, 128, w0.f55510i, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, Opcodes.NEW, w0.o, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, a.f32571e}, new int[]{43, SplashNativePolicy.SPLASH_CMD_SHOW_PLG, Opcodes.ARETURN, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 200, 178, 112, 125, IChannelPay.ID_IPAY_PAY_GAME}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, 179, 115}, new int[]{134, w0.M, Opcodes.DCMPL, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, Opcodes.IFNULL, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, Opcodes.IFNE, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, Opcodes.INVOKEVIRTUAL, 124}, new int[]{161, 61, 183, 127, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
        FINDER_PATTERN_SEQUENCES = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    }

    public RSSExpandedReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.pairs = new ArrayList(11);
        this.rows = new ArrayList();
        this.startEnd = new int[2];
    }

    private void adjustOddEvenCounts(int i2) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
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
            int i3 = (sum + sum2) - i2;
            boolean z6 = (sum & 1) == 1;
            boolean z7 = (sum2 & 1) == 0;
            if (i3 == 1) {
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
            } else if (i3 == -1) {
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
            } else if (i3 != 0) {
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
            int i2 = 2;
            for (int i3 = 1; i3 < this.pairs.size(); i3++) {
                ExpandedPair expandedPair2 = this.pairs.get(i3);
                checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
                i2++;
                DataCharacter rightChar2 = expandedPair2.getRightChar();
                if (rightChar2 != null) {
                    checksumPortion += rightChar2.getChecksumPortion();
                    i2++;
                }
            }
            return ((i2 + (-4)) * w0.A) + (checksumPortion % w0.A) == leftChar.getValue();
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

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i2) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, this, bitArray, list, i2) == null) {
            int[] decodeFinderCounters = getDecodeFinderCounters();
            decodeFinderCounters[0] = 0;
            decodeFinderCounters[1] = 0;
            decodeFinderCounters[2] = 0;
            decodeFinderCounters[3] = 0;
            int size = bitArray.getSize();
            if (i2 < 0) {
                i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
            boolean z = list.size() % 2 != 0;
            if (this.startFromEven) {
                z = !z;
            }
            boolean z2 = false;
            while (i2 < size) {
                z2 = !bitArray.get(i2);
                if (!z2) {
                    break;
                }
                i2++;
            }
            boolean z3 = z2;
            int i3 = 0;
            int i4 = i2;
            while (i2 < size) {
                if (bitArray.get(i2) ^ z3) {
                    decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
                } else {
                    if (i3 == 3) {
                        if (z) {
                            reverseCounters(decodeFinderCounters);
                        }
                        if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                            int[] iArr = this.startEnd;
                            iArr[0] = i4;
                            iArr[1] = i2;
                            return;
                        }
                        if (z) {
                            reverseCounters(decodeFinderCounters);
                        }
                        i4 += decodeFinderCounters[0] + decodeFinderCounters[1];
                        decodeFinderCounters[0] = decodeFinderCounters[2];
                        decodeFinderCounters[1] = decodeFinderCounters[3];
                        decodeFinderCounters[2] = 0;
                        decodeFinderCounters[3] = 0;
                        i3--;
                    } else {
                        i3++;
                    }
                    decodeFinderCounters[i3] = 1;
                    z3 = !z3;
                }
                i2++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static int getNextSecondBar(BitArray bitArray, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bitArray, i2)) == null) {
            if (bitArray.get(i2)) {
                return bitArray.getNextSet(bitArray.getNextUnset(i2));
            }
            return bitArray.getNextUnset(bitArray.getNextSet(i2));
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
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list.size()) {
                            z = true;
                            break;
                        } else if (list.get(i2).getFinderPattern().getValue() != iArr2[i2]) {
                            z = false;
                            break;
                        } else {
                            i2++;
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

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, this, new Object[]{bitArray, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                int i6 = this.startEnd[0] - 1;
                while (i6 >= 0 && !bitArray.get(i6)) {
                    i6--;
                }
                int i7 = i6 + 1;
                int[] iArr = this.startEnd;
                i5 = iArr[0] - i7;
                i3 = iArr[1];
                i4 = i7;
            } else {
                int[] iArr2 = this.startEnd;
                int i8 = iArr2[0];
                int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
                i3 = nextUnset;
                i4 = i8;
                i5 = nextUnset - this.startEnd[1];
            }
            int[] decodeFinderCounters = getDecodeFinderCounters();
            System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
            decodeFinderCounters[0] = i5;
            try {
                return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i4, i3}, i4, i3, i2);
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
            for (int i2 = 0; i2 < length / 2; i2++) {
                int i3 = iArr[i2];
                int i4 = (length - i2) - 1;
                iArr[i2] = iArr[i4];
                iArr[i4] = i3;
            }
        }
    }

    private void storeRow(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            boolean z2 = false;
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                if (i3 >= this.rows.size()) {
                    break;
                }
                ExpandedRow expandedRow = this.rows.get(i3);
                if (expandedRow.getRowNumber() > i2) {
                    z2 = expandedRow.isEquivalent(this.pairs);
                    break;
                } else {
                    z3 = expandedRow.isEquivalent(this.pairs);
                    i3++;
                }
            }
            if (z2 || z3 || isPartialRow(this.pairs, this.rows)) {
                return;
            }
            this.rows.add(i3, new ExpandedRow(this.pairs, i2, z));
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
                int i2 = 0;
                for (int length = dataCharacterCounters.length - 1; i2 < length; length--) {
                    int i3 = dataCharacterCounters[i2];
                    dataCharacterCounters[i2] = dataCharacterCounters[length];
                    dataCharacterCounters[length] = i3;
                    i2++;
                }
            }
            float sum = MathUtils.sum(dataCharacterCounters) / 17.0f;
            float f2 = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
            if (Math.abs(sum - f2) / f2 <= 0.3f) {
                int[] oddCounts = getOddCounts();
                int[] evenCounts = getEvenCounts();
                float[] oddRoundingErrors = getOddRoundingErrors();
                float[] evenRoundingErrors = getEvenRoundingErrors();
                for (int i4 = 0; i4 < dataCharacterCounters.length; i4++) {
                    float f3 = (dataCharacterCounters[i4] * 1.0f) / sum;
                    int i5 = (int) (0.5f + f3);
                    if (i5 <= 0) {
                        if (f3 < 0.3f) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i5 = 1;
                    } else if (i5 > 8) {
                        if (f3 > 8.7f) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i5 = 8;
                    }
                    int i6 = i4 / 2;
                    if ((i4 & 1) == 0) {
                        oddCounts[i6] = i5;
                        oddRoundingErrors[i6] = f3 - i5;
                    } else {
                        evenCounts[i6] = i5;
                        evenRoundingErrors[i6] = f3 - i5;
                    }
                }
                adjustOddEvenCounts(17);
                int value = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
                int i7 = 0;
                int i8 = 0;
                for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                    if (isNotA1left(finderPattern, z, z2)) {
                        i7 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                    }
                    i8 += oddCounts[length2];
                }
                int i9 = 0;
                for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                    if (isNotA1left(finderPattern, z, z2)) {
                        i9 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                    }
                }
                int i10 = i7 + i9;
                if ((i8 & 1) == 0 && i8 <= 13 && i8 >= 4) {
                    int i11 = (13 - i8) / 2;
                    int i12 = SYMBOL_WIDEST[i11];
                    return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i12, true) * EVEN_TOTAL_SUBSET[i11]) + RSSUtils.getRSSvalue(evenCounts, 9 - i12, false) + GSUM[i11], i10);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (DataCharacter) invokeCommon.objValue;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bitArray, map)) == null) {
            this.pairs.clear();
            this.startFromEven = false;
            try {
                return constructResult(decodeRow2pairs(i2, bitArray));
            } catch (NotFoundException unused) {
                this.pairs.clear();
                this.startFromEven = true;
                return constructResult(decodeRow2pairs(i2, bitArray));
            }
        }
        return (Result) invokeILL.objValue;
    }

    public List<ExpandedPair> decodeRow2pairs(int i2, BitArray bitArray) throws NotFoundException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bitArray)) != null) {
            return (List) invokeIL.objValue;
        }
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i2));
            } catch (NotFoundException e2) {
                if (!this.pairs.isEmpty()) {
                    if (checkChecksum()) {
                        return this.pairs;
                    }
                    boolean z = !this.rows.isEmpty();
                    storeRow(i2, false);
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
                throw e2;
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

    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i2) throws NotFoundException {
        InterceptResult invokeLLI;
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, bitArray, list, i2)) == null) {
            boolean z = list.size() % 2 == 0;
            if (this.startFromEven) {
                z = !z;
            }
            int i3 = -1;
            boolean z2 = true;
            do {
                findNextPair(bitArray, list, i3);
                parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i2, z);
                if (parseFoundFinderPattern == null) {
                    i3 = getNextSecondBar(bitArray, this.startEnd[0]);
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

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i2) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, list, i2)) == null) {
            while (i2 < this.rows.size()) {
                ExpandedRow expandedRow = this.rows.get(i2);
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
                        return checkRows(arrayList, i2 + 1);
                    } catch (NotFoundException unused) {
                        continue;
                    }
                }
                i2++;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (List) invokeLI.objValue;
    }
}
