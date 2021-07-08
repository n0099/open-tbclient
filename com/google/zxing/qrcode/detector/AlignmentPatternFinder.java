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
/* loaded from: classes6.dex */
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

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, float f2, ResultPointCallback resultPointCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2), resultPointCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList(5);
        this.startX = i2;
        this.startY = i3;
        this.width = i4;
        this.height = i5;
        this.moduleSize = f2;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = resultPointCallback;
    }

    public static float centerFromEnd(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i2)) == null) ? (i2 - iArr[2]) - (iArr[1] / 2.0f) : invokeLI.floatValue;
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
    private float crossCheckVertical(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, this, i2, i3, i4, i5)) == null) {
            BitMatrix bitMatrix = this.image;
            int height = bitMatrix.getHeight();
            int[] iArr = this.crossCheckStateCount;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i6 = i2;
            while (i6 >= 0 && bitMatrix.get(i3, i6) && iArr[1] <= i4) {
                iArr[1] = iArr[1] + 1;
                i6--;
            }
            if (i6 >= 0 && iArr[1] <= i4) {
                while (i6 >= 0 && !bitMatrix.get(i3, i6) && iArr[0] <= i4) {
                    iArr[0] = iArr[0] + 1;
                    i6--;
                }
                if (iArr[0] > i4) {
                    return Float.NaN;
                }
                int i7 = i2 + 1;
                while (i7 < height && bitMatrix.get(i3, i7) && iArr[1] <= i4) {
                    iArr[1] = iArr[1] + 1;
                    i7++;
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
            float f2 = this.moduleSize;
            float f3 = f2 / 2.0f;
            for (int i2 = 0; i2 < 3; i2++) {
                if (Math.abs(f2 - iArr[i2]) >= f3) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, iArr, i2, i3)) == null) {
            int i4 = iArr[0] + iArr[1] + iArr[2];
            float centerFromEnd = centerFromEnd(iArr, i3);
            float crossCheckVertical = crossCheckVertical(i2, (int) centerFromEnd, iArr[1] * 2, i4);
            if (Float.isNaN(crossCheckVertical)) {
                return null;
            }
            float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
            for (AlignmentPattern alignmentPattern : this.possibleCenters) {
                if (alignmentPattern.aboutEquals(f2, crossCheckVertical, centerFromEnd)) {
                    return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f2);
                }
            }
            AlignmentPattern alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f2);
            this.possibleCenters.add(alignmentPattern2);
            ResultPointCallback resultPointCallback = this.resultPointCallback;
            if (resultPointCallback != null) {
                resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
                return null;
            }
            return null;
        }
        return (AlignmentPattern) invokeLII.objValue;
    }

    public AlignmentPattern find() throws NotFoundException {
        InterceptResult invokeV;
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
                int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                int i8 = i2;
                while (i8 < i4 && !this.image.get(i8, i7)) {
                    i8++;
                }
                int i9 = 0;
                while (i8 < i4) {
                    if (!this.image.get(i8, i7)) {
                        if (i9 == 1) {
                            i9++;
                        }
                        iArr[i9] = iArr[i9] + 1;
                    } else if (i9 == 1) {
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
