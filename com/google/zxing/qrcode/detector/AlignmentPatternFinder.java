package com.google.zxing.qrcode.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class AlignmentPatternFinder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] crossCheckStateCount;
    public final int height;
    public final BitMatrix image;
    public final float moduleSize;
    public final List<AlignmentPattern> possibleCenters;
    public final ResultPointCallback resultPointCallback;
    public final int startX;
    public final int startY;
    public final int width;

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), resultPointCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList(5);
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = resultPointCallback;
    }

    public static float centerFromEnd(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i)) == null) {
            return (i - iArr[2]) - (iArr[1] / 2.0f);
        }
        return invokeLI.floatValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r2[1] <= r12) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
        if (r10 >= r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
        if (r0.get(r11, r10) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
        if (r2[2] > r12) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
        if (r2[2] <= r12) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0095, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009a, code lost:
        if (foundPatternCross(r2) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
        return centerFromEnd(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, this, i, i2, i3, i4)) == null) {
            BitMatrix bitMatrix = this.image;
            int height = bitMatrix.getHeight();
            int[] iArr = this.crossCheckStateCount;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i5 = i;
            while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
                iArr[1] = iArr[1] + 1;
                i5--;
            }
            if (i5 >= 0 && iArr[1] <= i3) {
                while (i5 >= 0 && !bitMatrix.get(i2, i5) && iArr[0] <= i3) {
                    iArr[0] = iArr[0] + 1;
                    i5--;
                }
                if (iArr[0] > i3) {
                    return Float.NaN;
                }
                int i6 = i + 1;
                while (i6 < height && bitMatrix.get(i2, i6) && iArr[1] <= i3) {
                    iArr[1] = iArr[1] + 1;
                    i6++;
                }
            }
            return Float.NaN;
        }
        return invokeIIII.floatValue;
    }

    private boolean foundPatternCross(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, iArr)) == null) {
            float f = this.moduleSize;
            float f2 = f / 2.0f;
            for (int i = 0; i < 3; i++) {
                if (Math.abs(f - iArr[i]) >= f2) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, iArr, i, i2)) == null) {
            int i3 = iArr[0] + iArr[1] + iArr[2];
            float centerFromEnd = centerFromEnd(iArr, i2);
            float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[1] * 2, i3);
            if (!Float.isNaN(crossCheckVertical)) {
                float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
                for (AlignmentPattern alignmentPattern : this.possibleCenters) {
                    if (alignmentPattern.aboutEquals(f, crossCheckVertical, centerFromEnd)) {
                        return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f);
                    }
                }
                AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f);
                this.possibleCenters.add(alignmentPattern2);
                ResultPointCallback resultPointCallback = this.resultPointCallback;
                if (resultPointCallback != null) {
                    resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
                    return null;
                }
                return null;
            }
            return null;
        }
        return (AlignmentPattern) invokeLII.objValue;
    }

    public AlignmentPattern find() throws NotFoundException {
        InterceptResult invokeV;
        int i;
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.startX;
            int i3 = this.height;
            int i4 = this.width + i2;
            int i5 = this.startY + (i3 / 2);
            int[] iArr = new int[3];
            for (int i6 = 0; i6 < i3; i6++) {
                if ((i6 & 1) == 0) {
                    i = (i6 + 1) / 2;
                } else {
                    i = -((i6 + 1) / 2);
                }
                int i7 = i + i5;
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                int i8 = i2;
                while (i8 < i4 && !this.image.get(i8, i7)) {
                    i8++;
                }
                int i9 = 0;
                while (i8 < i4) {
                    if (this.image.get(i8, i7)) {
                        if (i9 == 1) {
                            iArr[1] = iArr[1] + 1;
                        } else if (i9 == 2) {
                            if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i7, i8)) != null) {
                                return handlePossibleCenter2;
                            }
                            iArr[0] = iArr[2];
                            iArr[1] = 1;
                            iArr[2] = 0;
                            i9 = 1;
                        } else {
                            i9++;
                            iArr[i9] = iArr[i9] + 1;
                        }
                    } else {
                        if (i9 == 1) {
                            i9++;
                        }
                        iArr[i9] = iArr[i9] + 1;
                    }
                    i8++;
                }
                if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i7, i4)) != null) {
                    return handlePossibleCenter;
                }
            }
            if (!this.possibleCenters.isEmpty()) {
                return this.possibleCenters.get(0);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (AlignmentPattern) invokeV.objValue;
    }
}
