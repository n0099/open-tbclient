package com.google.zxing.aztec.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
/* loaded from: classes7.dex */
public final class Detector {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] EXPECTED_CORNER_BITS;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean compact;
    public final BitMatrix image;
    public int nbCenterLayers;
    public int nbDataBlocks;
    public int nbLayers;
    public int shift;

    /* loaded from: classes7.dex */
    public static final class Point {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int x;
        public final int y;

        public Point(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x = i;
            this.y = i2;
        }

        public int getX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.x;
            }
            return invokeV.intValue;
        }

        public int getY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.y;
            }
            return invokeV.intValue;
        }

        public ResultPoint toResultPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new ResultPoint(getX(), getY());
            }
            return (ResultPoint) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "<" + this.x + WebvttCueParser.CHAR_SPACE + this.y + '>';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1647329321, "Lcom/google/zxing/aztec/detector/Detector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1647329321, "Lcom/google/zxing/aztec/detector/Detector;");
                return;
            }
        }
        EXPECTED_CORNER_BITS = new int[]{3808, 476, 2107, 1799};
    }

    private int getDimension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.compact) {
                return (this.nbLayers * 4) + 11;
            }
            int i = this.nbLayers;
            if (i <= 4) {
                return (i * 4) + 15;
            }
            return (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
        }
        return invokeV.intValue;
    }

    public Detector(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, resultPointArr)) == null) {
            return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
        }
        return (ResultPoint[]) invokeL.objValue;
    }

    private boolean isValid(ResultPoint resultPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, resultPoint)) == null) {
            return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
        }
        return invokeL.booleanValue;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resultPoint, resultPoint2)) == null) {
            return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
        }
        return invokeLL.floatValue;
    }

    private boolean isValid(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, this, i, i2)) == null) {
            if (i >= 0 && i < this.image.getWidth() && i2 > 0 && i2 < this.image.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static float distance(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, point, point2)) == null) {
            return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
        }
        return invokeLL.floatValue;
    }

    public static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{resultPointArr, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = f2 / (f * 2.0f);
            float x = resultPointArr[0].getX() - resultPointArr[2].getX();
            float y = resultPointArr[0].getY() - resultPointArr[2].getY();
            float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
            float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
            float f4 = x * f3;
            float f5 = y * f3;
            ResultPoint resultPoint = new ResultPoint(x2 + f4, y2 + f5);
            ResultPoint resultPoint2 = new ResultPoint(x2 - f4, y2 - f5);
            float x3 = resultPointArr[1].getX() - resultPointArr[3].getX();
            float y3 = resultPointArr[1].getY() - resultPointArr[3].getY();
            float x4 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
            float y4 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
            float f6 = x3 * f3;
            float f7 = f3 * y3;
            return new ResultPoint[]{resultPoint, new ResultPoint(x4 + f6, y4 + f7), resultPoint2, new ResultPoint(x4 - f6, y4 - f7)};
        }
        return (ResultPoint[]) invokeCommon.objValue;
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, resultPointArr) == null) {
            if (isValid(resultPointArr[0]) && isValid(resultPointArr[1]) && isValid(resultPointArr[2]) && isValid(resultPointArr[3])) {
                int i = this.nbCenterLayers * 2;
                int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i), sampleLine(resultPointArr[1], resultPointArr[2], i), sampleLine(resultPointArr[2], resultPointArr[3], i), sampleLine(resultPointArr[3], resultPointArr[0], i)};
                this.shift = getRotation(iArr, i);
                long j3 = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    int i3 = iArr[(this.shift + i2) % 4];
                    if (this.compact) {
                        j = j3 << 7;
                        j2 = (i3 >> 1) & 127;
                    } else {
                        j = j3 << 10;
                        j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
                    }
                    j3 = j + j2;
                }
                int correctedParameterData = getCorrectedParameterData(j3, this.compact);
                if (this.compact) {
                    this.nbLayers = (correctedParameterData >> 6) + 1;
                    this.nbDataBlocks = (correctedParameterData & 63) + 1;
                    return;
                }
                this.nbLayers = (correctedParameterData >> 11) + 1;
                this.nbDataBlocks = (correctedParameterData & 2047) + 1;
                return;
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private ResultPoint[] getBullsEyeCorners(Point point) throws NotFoundException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, point)) == null) {
            this.nbCenterLayers = 1;
            Point point2 = point;
            Point point3 = point2;
            Point point4 = point3;
            Point point5 = point4;
            boolean z2 = true;
            while (this.nbCenterLayers < 9) {
                Point firstDifferent = getFirstDifferent(point2, z2, 1, -1);
                Point firstDifferent2 = getFirstDifferent(point3, z2, 1, 1);
                Point firstDifferent3 = getFirstDifferent(point4, z2, -1, 1);
                Point firstDifferent4 = getFirstDifferent(point5, z2, -1, -1);
                if (this.nbCenterLayers > 2) {
                    double distance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point5, point2) * (this.nbCenterLayers + 2));
                    if (distance < 0.75d || distance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                        break;
                    }
                }
                z2 = !z2;
                this.nbCenterLayers++;
                point5 = firstDifferent4;
                point2 = firstDifferent;
                point3 = firstDifferent2;
                point4 = firstDifferent3;
            }
            int i = this.nbCenterLayers;
            if (i != 5 && i != 7) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (this.nbCenterLayers == 5) {
                z = true;
            } else {
                z = false;
            }
            this.compact = z;
            ResultPoint[] resultPointArr = {new ResultPoint(point2.getX() + 0.5f, point2.getY() - 0.5f), new ResultPoint(point3.getX() + 0.5f, point3.getY() + 0.5f), new ResultPoint(point4.getX() - 0.5f, point4.getY() + 0.5f), new ResultPoint(point5.getX() - 0.5f, point5.getY() - 0.5f)};
            int i2 = this.nbCenterLayers;
            return expandSquare(resultPointArr, (i2 * 2) - 3, i2 * 2);
        }
        return (ResultPoint[]) invokeL.objValue;
    }

    private int getColor(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, point, point2)) == null) {
            float distance = distance(point, point2);
            float x = (point2.getX() - point.getX()) / distance;
            float y = (point2.getY() - point.getY()) / distance;
            float x2 = point.getX();
            float y2 = point.getY();
            boolean z = this.image.get(point.getX(), point.getY());
            int ceil = (int) Math.ceil(distance);
            boolean z2 = false;
            int i = 0;
            for (int i2 = 0; i2 < ceil; i2++) {
                x2 += x;
                y2 += y;
                if (this.image.get(MathUtils.round(x2), MathUtils.round(y2)) != z) {
                    i++;
                }
            }
            float f = i / distance;
            if (f > 0.1f && f < 0.9f) {
                return 0;
            }
            if (f <= 0.1f) {
                z2 = true;
            }
            if (z2 == z) {
                return 1;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static int getCorrectedParameterData(long j, boolean z) throws NotFoundException {
        InterceptResult invokeCommon;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (z) {
                i = 7;
                i2 = 2;
            } else {
                i = 10;
                i2 = 4;
            }
            int i3 = i - i2;
            int[] iArr = new int[i];
            for (int i4 = i - 1; i4 >= 0; i4--) {
                iArr[i4] = ((int) j) & 15;
                j >>= 4;
            }
            try {
                new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i3);
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    i5 = (i5 << 4) + iArr[i6];
                }
                return i5;
            } catch (ReedSolomonException unused) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        return invokeCommon.intValue;
    }

    public static int getRotation(int[] iArr, int i) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, iArr, i)) == null) {
            int i2 = 0;
            for (int i3 : iArr) {
                i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
            }
            int i4 = ((i2 & 1) << 11) + (i2 >> 1);
            for (int i5 = 0; i5 < 4; i5++) {
                if (Integer.bitCount(EXPECTED_CORNER_BITS[i5] ^ i4) <= 2) {
                    return i5;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLI.intValue;
    }

    private Point getFirstDifferent(Point point, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{point, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int x = point.getX() + i;
            int y = point.getY();
            while (true) {
                y += i2;
                if (!isValid(x, y) || this.image.get(x, y) != z) {
                    break;
                }
                x += i;
            }
            int i3 = x - i;
            int i4 = y - i2;
            while (isValid(i3, i4) && this.image.get(i3, i4) == z) {
                i3 += i;
            }
            int i5 = i3 - i;
            while (isValid(i5, i4) && this.image.get(i5, i4) == z) {
                i4 += i2;
            }
            return new Point(i5, i4 - i2);
        }
        return (Point) invokeCommon.objValue;
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, this, point, point2, point3, point4)) == null) {
            Point point5 = new Point(point.getX() - 3, point.getY() + 3);
            Point point6 = new Point(point2.getX() - 3, point2.getY() - 3);
            Point point7 = new Point(point3.getX() + 3, point3.getY() - 3);
            Point point8 = new Point(point4.getX() + 3, point4.getY() + 3);
            int color = getColor(point8, point5);
            if (color == 0 || getColor(point5, point6) != color || getColor(point6, point7) != color || getColor(point7, point8) != color) {
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    private Point getMatrixCenter() {
        InterceptResult invokeV;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                ResultPoint[] detect = new WhiteRectangleDetector(this.image).detect();
                resultPoint3 = detect[0];
                resultPoint4 = detect[1];
                resultPoint2 = detect[2];
                resultPoint = detect[3];
            } catch (NotFoundException unused) {
                int width = this.image.getWidth() / 2;
                int height = this.image.getHeight() / 2;
                int i = width + 7;
                int i2 = height - 7;
                ResultPoint resultPoint9 = getFirstDifferent(new Point(i, i2), false, 1, -1).toResultPoint();
                int i3 = height + 7;
                ResultPoint resultPoint10 = getFirstDifferent(new Point(i, i3), false, 1, 1).toResultPoint();
                int i4 = width - 7;
                ResultPoint resultPoint11 = getFirstDifferent(new Point(i4, i3), false, -1, 1).toResultPoint();
                resultPoint = getFirstDifferent(new Point(i4, i2), false, -1, -1).toResultPoint();
                resultPoint2 = resultPoint11;
                resultPoint3 = resultPoint9;
                resultPoint4 = resultPoint10;
            }
            int round = MathUtils.round((((resultPoint3.getX() + resultPoint.getX()) + resultPoint4.getX()) + resultPoint2.getX()) / 4.0f);
            int round2 = MathUtils.round((((resultPoint3.getY() + resultPoint.getY()) + resultPoint4.getY()) + resultPoint2.getY()) / 4.0f);
            try {
                ResultPoint[] detect2 = new WhiteRectangleDetector(this.image, 15, round, round2).detect();
                resultPoint5 = detect2[0];
                resultPoint6 = detect2[1];
                resultPoint7 = detect2[2];
                resultPoint8 = detect2[3];
            } catch (NotFoundException unused2) {
                int i5 = round + 7;
                int i6 = round2 - 7;
                resultPoint5 = getFirstDifferent(new Point(i5, i6), false, 1, -1).toResultPoint();
                int i7 = round2 + 7;
                resultPoint6 = getFirstDifferent(new Point(i5, i7), false, 1, 1).toResultPoint();
                int i8 = round - 7;
                resultPoint7 = getFirstDifferent(new Point(i8, i7), false, -1, 1).toResultPoint();
                resultPoint8 = getFirstDifferent(new Point(i8, i6), false, -1, -1).toResultPoint();
            }
            return new Point(MathUtils.round((((resultPoint5.getX() + resultPoint8.getX()) + resultPoint6.getX()) + resultPoint7.getX()) / 4.0f), MathUtils.round((((resultPoint5.getY() + resultPoint8.getY()) + resultPoint6.getY()) + resultPoint7.getY()) / 4.0f));
        }
        return (Point) invokeV.objValue;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65553, this, bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4)) == null) {
            GridSampler gridSampler = GridSampler.getInstance();
            int dimension = getDimension();
            float f = dimension / 2.0f;
            int i = this.nbCenterLayers;
            float f2 = f - i;
            float f3 = f + i;
            return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f2, f2, f3, f2, f3, f3, f2, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
        }
        return (BitMatrix) invokeLLLLL.objValue;
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, this, resultPoint, resultPoint2, i)) == null) {
            float distance = distance(resultPoint, resultPoint2);
            float f = distance / i;
            float x = resultPoint.getX();
            float y = resultPoint.getY();
            float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f) / distance;
            float y2 = (f * (resultPoint2.getY() - resultPoint.getY())) / distance;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                float f2 = i3;
                if (this.image.get(MathUtils.round((f2 * x2) + x), MathUtils.round((f2 * y2) + y))) {
                    i2 |= 1 << ((i - i3) - 1);
                }
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return detect(false);
        }
        return (AztecDetectorResult) invokeV.objValue;
    }

    public AztecDetectorResult detect(boolean z) throws NotFoundException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
            if (z) {
                ResultPoint resultPoint = bullsEyeCorners[0];
                bullsEyeCorners[0] = bullsEyeCorners[2];
                bullsEyeCorners[2] = resultPoint;
            }
            extractParameters(bullsEyeCorners);
            BitMatrix bitMatrix = this.image;
            int i = this.shift;
            return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i % 4], bullsEyeCorners[(i + 1) % 4], bullsEyeCorners[(i + 2) % 4], bullsEyeCorners[(i + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
        }
        return (AztecDetectorResult) invokeZ.objValue;
    }
}
