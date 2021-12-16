package com.google.zxing.qrcode.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FinderPatternFinder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CENTER_QUORUM = 2;
    public static final int MAX_MODULES = 57;
    public static final int MIN_SKIP = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] crossCheckStateCount;
    public boolean hasSkipped;
    public final BitMatrix image;
    public final List<FinderPattern> possibleCenters;
    public final ResultPointCallback resultPointCallback;

    /* renamed from: com.google.zxing.qrcode.detector.FinderPatternFinder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float average;

        public /* synthetic */ CenterComparator(float f2, AnonymousClass1 anonymousClass1) {
            this(f2);
        }

        public CenterComparator(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.average = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, finderPattern, finderPattern2)) == null) {
                if (finderPattern2.getCount() == finderPattern.getCount()) {
                    float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
                    float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
                    if (abs < abs2) {
                        return 1;
                    }
                    return abs == abs2 ? 0 : -1;
                }
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float average;

        public /* synthetic */ FurthestFromAverageComparator(float f2, AnonymousClass1 anonymousClass1) {
            this(f2);
        }

        public FurthestFromAverageComparator(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.average = f2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, finderPattern, finderPattern2)) == null) {
                float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
                float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
                if (abs < abs2) {
                    return -1;
                }
                return abs == abs2 ? 0 : 1;
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BitMatrix) objArr2[0], (ResultPointCallback) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static float centerFromEnd(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, iArr, i2)) == null) ? ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f) : invokeLI.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r18 >= r6) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r17 < r6) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r18 < r6) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r16.image.get(r18 - r6, r17 - r6) != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r4[1] > r19) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        r4[1] = r4[1] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        if (r17 < r6) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r18 < r6) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r4[1] <= r19) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
        if (r17 < r6) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r18 < r6) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r16.image.get(r18 - r6, r17 - r6) == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        if (r4[0] > r19) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
        r4[0] = r4[0] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r4[0] <= r19) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
        r6 = r16.image.getHeight();
        r9 = r16.image.getWidth();
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
        if (r11 >= r6) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        r12 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
        if (r12 >= r9) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        if (r16.image.get(r12, r11) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
        r4[2] = r4[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r11 >= r6) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
        if ((r18 + r10) < r9) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a6, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
        if (r11 >= r6) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ab, code lost:
        r13 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ad, code lost:
        if (r13 >= r9) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
        if (r16.image.get(r13, r11) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b9, code lost:
        if (r4[3] >= r19) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bb, code lost:
        r4[3] = r4[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c3, code lost:
        if (r11 >= r6) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
        if ((r18 + r10) >= r9) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cb, code lost:
        if (r4[3] < r19) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d1, code lost:
        if (r11 >= r6) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d3, code lost:
        r14 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r14 >= r9) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00dd, code lost:
        if (r16.image.get(r14, r11) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
        if (r4[4] >= r19) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e3, code lost:
        r4[4] = r4[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ed, code lost:
        if (r4[4] < r19) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ef, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0106, code lost:
        if (java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r20) >= (r20 * 2)) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010c, code lost:
        if (foundPatternCross(r4) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010e, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean crossCheckDiagonal(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, this, i2, i3, i4, i5)) == null) {
            int[] crossCheckStateCount = getCrossCheckStateCount();
            int i6 = 0;
            while (i2 >= i6 && i3 >= i6 && this.image.get(i3 - i6, i2 - i6)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6++;
            }
            return false;
        }
        return invokeIIII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r2[1] <= r13) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r3 < 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r0.get(r3, r12) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
        if (r2[0] > r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r2[0] <= r13) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
        if (r11 >= r1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
        if (r0.get(r11, r12) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0071, code lost:
        if (r11 >= r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
        if (r0.get(r11, r12) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
        if (r2[3] >= r13) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007d, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r11 == r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
        if (r2[3] < r13) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r0.get(r11, r12) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r2[4] >= r13) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
        if (r2[4] < r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bb, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bd, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c2, code lost:
        if (foundPatternCross(r2) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c8, code lost:
        return centerFromEnd(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckHorizontal(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, i4, i5)) == null) {
            BitMatrix bitMatrix = this.image;
            int width = bitMatrix.getWidth();
            int[] crossCheckStateCount = getCrossCheckStateCount();
            int i6 = i2;
            while (i6 >= 0 && bitMatrix.get(i6, i3)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6--;
            }
            if (i6 < 0) {
                return Float.NaN;
            }
            while (i6 >= 0 && !bitMatrix.get(i6, i3) && crossCheckStateCount[1] <= i4) {
                crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
                i6--;
            }
            return Float.NaN;
        }
        return invokeIIII.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r2[1] <= r13) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r3 < 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r0.get(r12, r3) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
        if (r2[0] > r13) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r2[0] <= r13) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
        if (r11 >= r1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
        if (r0.get(r12, r11) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r11 != r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0071, code lost:
        if (r11 >= r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
        if (r0.get(r12, r11) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
        if (r2[3] >= r13) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007d, code lost:
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r11 == r1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
        if (r2[3] < r13) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
        if (r11 >= r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0093, code lost:
        if (r0.get(r12, r11) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r2[4] >= r13) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a3, code lost:
        if (r2[4] < r13) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bd, code lost:
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bf, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c4, code lost:
        if (foundPatternCross(r2) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        return centerFromEnd(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65541, this, i2, i3, i4, i5)) == null) {
            BitMatrix bitMatrix = this.image;
            int height = bitMatrix.getHeight();
            int[] crossCheckStateCount = getCrossCheckStateCount();
            int i6 = i2;
            while (i6 >= 0 && bitMatrix.get(i3, i6)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i6--;
            }
            if (i6 < 0) {
                return Float.NaN;
            }
            while (i6 >= 0 && !bitMatrix.get(i3, i6) && crossCheckStateCount[1] <= i4) {
                crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
                i6--;
            }
            return Float.NaN;
        }
        return invokeIIII.floatValue;
    }

    private int findRowSkip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.possibleCenters.size() <= 1) {
                return 0;
            }
            FinderPattern finderPattern = null;
            for (FinderPattern finderPattern2 : this.possibleCenters) {
                if (finderPattern2.getCount() >= 2) {
                    if (finderPattern != null) {
                        this.hasSkipped = true;
                        return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                    }
                    finderPattern = finderPattern2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean foundPatternCross(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, iArr)) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = iArr[i3];
                if (i4 == 0) {
                    return false;
                }
                i2 += i4;
            }
            if (i2 < 7) {
                return false;
            }
            float f2 = i2 / 7.0f;
            float f3 = f2 / 2.0f;
            return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
        }
        return invokeL.booleanValue;
    }

    private int[] getCrossCheckStateCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int[] iArr = this.crossCheckStateCount;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    private boolean haveMultiplyConfirmedCenters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int size = this.possibleCenters.size();
            float f2 = 0.0f;
            int i2 = 0;
            float f3 = 0.0f;
            for (FinderPattern finderPattern : this.possibleCenters) {
                if (finderPattern.getCount() >= 2) {
                    i2++;
                    f3 += finderPattern.getEstimatedModuleSize();
                }
            }
            if (i2 < 3) {
                return false;
            }
            float f4 = f3 / size;
            for (FinderPattern finderPattern2 : this.possibleCenters) {
                f2 += Math.abs(finderPattern2.getEstimatedModuleSize() - f4);
            }
            return f2 <= f3 * 0.05f;
        }
        return invokeV.booleanValue;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        InterceptResult invokeV;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int size = this.possibleCenters.size();
            if (size >= 3) {
                float f3 = 0.0f;
                if (size > 3) {
                    float f4 = 0.0f;
                    float f5 = 0.0f;
                    for (FinderPattern finderPattern : this.possibleCenters) {
                        float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                        f4 += estimatedModuleSize;
                        f5 += estimatedModuleSize * estimatedModuleSize;
                    }
                    float f6 = f4 / size;
                    float sqrt = (float) Math.sqrt((f5 / f2) - (f6 * f6));
                    Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f6, null));
                    float max = Math.max(0.2f * f6, sqrt);
                    int i2 = 0;
                    while (i2 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                        if (Math.abs(this.possibleCenters.get(i2).getEstimatedModuleSize() - f6) > max) {
                            this.possibleCenters.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                }
                if (this.possibleCenters.size() > 3) {
                    for (FinderPattern finderPattern2 : this.possibleCenters) {
                        f3 += finderPattern2.getEstimatedModuleSize();
                    }
                    Collections.sort(this.possibleCenters, new CenterComparator(f3 / this.possibleCenters.size(), null));
                    List<FinderPattern> list = this.possibleCenters;
                    list.subList(3, list.size()).clear();
                }
                return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (FinderPattern[]) invokeV.objValue;
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
            boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
            int height = this.image.getHeight();
            int width = this.image.getWidth();
            int i2 = ((height * 3) / 228 < 3 || z) ? 3 : 3;
            int[] iArr = new int[5];
            int i3 = i2 - 1;
            boolean z3 = false;
            while (i3 < height && !z3) {
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                int i4 = 0;
                int i5 = 0;
                while (i4 < width) {
                    if (this.image.get(i4, i3)) {
                        if ((i5 & 1) == 1) {
                            i5++;
                        }
                        iArr[i5] = iArr[i5] + 1;
                    } else if ((i5 & 1) != 0) {
                        iArr[i5] = iArr[i5] + 1;
                    } else if (i5 == 4) {
                        if (foundPatternCross(iArr)) {
                            if (handlePossibleCenter(iArr, i3, i4, z2)) {
                                if (this.hasSkipped) {
                                    z3 = haveMultiplyConfirmedCenters();
                                } else {
                                    int findRowSkip = findRowSkip();
                                    if (findRowSkip > iArr[2]) {
                                        i3 += (findRowSkip - iArr[2]) - 2;
                                        i4 = width - 1;
                                    }
                                }
                                iArr[0] = 0;
                                iArr[1] = 0;
                                iArr[2] = 0;
                                iArr[3] = 0;
                                iArr[4] = 0;
                                i2 = 2;
                                i5 = 0;
                            } else {
                                iArr[0] = iArr[2];
                                iArr[1] = iArr[3];
                                iArr[2] = iArr[4];
                                iArr[3] = 1;
                                iArr[4] = 0;
                            }
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                        }
                        i5 = 3;
                    } else {
                        i5++;
                        iArr[i5] = iArr[i5] + 1;
                    }
                    i4++;
                }
                if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, width, z2)) {
                    i2 = iArr[0];
                    if (this.hasSkipped) {
                        z3 = haveMultiplyConfirmedCenters();
                    }
                }
                i3 += i2;
            }
            FinderPattern[] selectBestPatterns = selectBestPatterns();
            ResultPoint.orderBestPatterns(selectBestPatterns);
            return new FinderPatternInfo(selectBestPatterns);
        }
        return (FinderPatternInfo) invokeL.objValue;
    }

    public final BitMatrix getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.image : (BitMatrix) invokeV.objValue;
    }

    public final List<FinderPattern> getPossibleCenters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.possibleCenters : (List) invokeV.objValue;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{iArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
            int centerFromEnd = (int) centerFromEnd(iArr, i3);
            float crossCheckVertical = crossCheckVertical(i2, centerFromEnd, iArr[2], i4);
            if (!Float.isNaN(crossCheckVertical)) {
                int i5 = (int) crossCheckVertical;
                float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i5, iArr[2], i4);
                if (!Float.isNaN(crossCheckHorizontal) && (!z || crossCheckDiagonal(i5, (int) crossCheckHorizontal, iArr[2], i4))) {
                    float f2 = i4 / 7.0f;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.possibleCenters.size()) {
                            break;
                        }
                        FinderPattern finderPattern = this.possibleCenters.get(i6);
                        if (finderPattern.aboutEquals(f2, crossCheckVertical, crossCheckHorizontal)) {
                            this.possibleCenters.set(i6, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f2));
                            z2 = true;
                            break;
                        }
                        i6++;
                    }
                    if (!z2) {
                        FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f2);
                        this.possibleCenters.add(finderPattern2);
                        ResultPointCallback resultPointCallback = this.resultPointCallback;
                        if (resultPointCallback != null) {
                            resultPointCallback.foundPossibleResultPoint(finderPattern2);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, resultPointCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }
}
