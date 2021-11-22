package com.google.zxing.aztec.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import kotlin.text.Typography;
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static final class Point {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int x;
        public final int y;

        public Point(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x = i2;
            this.y = i3;
        }

        public int getX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.x : invokeV.intValue;
        }

        public int getY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.y : invokeV.intValue;
        }

        public ResultPoint toResultPoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new ResultPoint(getX(), getY()) : (ResultPoint) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "<" + this.x + ' ' + this.y + Typography.greater;
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

    public Detector(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
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
    }

    public static float distance(Point point, Point point2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, point, point2)) == null) ? MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY()) : invokeLL.floatValue;
    }

    public static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{resultPointArr, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f3 / (f2 * 2.0f);
            float x = resultPointArr[0].getX() - resultPointArr[2].getX();
            float y = resultPointArr[0].getY() - resultPointArr[2].getY();
            float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
            float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
            float f5 = x * f4;
            float f6 = y * f4;
            ResultPoint resultPoint = new ResultPoint(x2 + f5, y2 + f6);
            ResultPoint resultPoint2 = new ResultPoint(x2 - f5, y2 - f6);
            float x3 = resultPointArr[1].getX() - resultPointArr[3].getX();
            float y3 = resultPointArr[1].getY() - resultPointArr[3].getY();
            float x4 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
            float y4 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
            float f7 = x3 * f4;
            float f8 = f4 * y3;
            return new ResultPoint[]{resultPoint, new ResultPoint(x4 + f7, y4 + f8), resultPoint2, new ResultPoint(x4 - f7, y4 - f8)};
        }
        return (ResultPoint[]) invokeCommon.objValue;
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, resultPointArr) == null) {
            if (isValid(resultPointArr[0]) && isValid(resultPointArr[1]) && isValid(resultPointArr[2]) && isValid(resultPointArr[3])) {
                int i2 = this.nbCenterLayers * 2;
                int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i2), sampleLine(resultPointArr[1], resultPointArr[2], i2), sampleLine(resultPointArr[2], resultPointArr[3], i2), sampleLine(resultPointArr[3], resultPointArr[0], i2)};
                this.shift = getRotation(iArr, i2);
                long j3 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    int i4 = iArr[(this.shift + i3) % 4];
                    if (this.compact) {
                        j = j3 << 7;
                        j2 = (i4 >> 1) & 127;
                    } else {
                        j = j3 << 10;
                        j2 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, point)) == null) {
            this.nbCenterLayers = 1;
            Point point2 = point;
            Point point3 = point2;
            Point point4 = point3;
            Point point5 = point4;
            boolean z = true;
            while (this.nbCenterLayers < 9) {
                Point firstDifferent = getFirstDifferent(point2, z, 1, -1);
                Point firstDifferent2 = getFirstDifferent(point3, z, 1, 1);
                Point firstDifferent3 = getFirstDifferent(point4, z, -1, 1);
                Point firstDifferent4 = getFirstDifferent(point5, z, -1, -1);
                if (this.nbCenterLayers > 2) {
                    double distance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point5, point2) * (this.nbCenterLayers + 2));
                    if (distance < 0.75d || distance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                        break;
                    }
                }
                z = !z;
                this.nbCenterLayers++;
                point5 = firstDifferent4;
                point2 = firstDifferent;
                point3 = firstDifferent2;
                point4 = firstDifferent3;
            }
            int i2 = this.nbCenterLayers;
            if (i2 != 5 && i2 != 7) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.compact = this.nbCenterLayers == 5;
            ResultPoint[] resultPointArr = {new ResultPoint(point2.getX() + 0.5f, point2.getY() - 0.5f), new ResultPoint(point3.getX() + 0.5f, point3.getY() + 0.5f), new ResultPoint(point4.getX() - 0.5f, point4.getY() + 0.5f), new ResultPoint(point5.getX() - 0.5f, point5.getY() - 0.5f)};
            int i3 = this.nbCenterLayers;
            return expandSquare(resultPointArr, (i3 * 2) - 3, i3 * 2);
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
            int i2 = 0;
            for (int i3 = 0; i3 < ceil; i3++) {
                x2 += x;
                y2 += y;
                if (this.image.get(MathUtils.round(x2), MathUtils.round(y2)) != z) {
                    i2++;
                }
            }
            float f2 = i2 / distance;
            if (f2 <= 0.1f || f2 >= 0.9f) {
                return (f2 <= 0.1f) == z ? 1 : -1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int getCorrectedParameterData(long j, boolean z) throws NotFoundException {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (z) {
                i2 = 7;
                i3 = 2;
            } else {
                i2 = 10;
                i3 = 4;
            }
            int i4 = i2 - i3;
            int[] iArr = new int[i2];
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                iArr[i5] = ((int) j) & 15;
                j >>= 4;
            }
            try {
                new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i4);
                int i6 = 0;
                for (int i7 = 0; i7 < i3; i7++) {
                    i6 = (i6 << 4) + iArr[i7];
                }
                return i6;
            } catch (ReedSolomonException unused) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        return invokeCommon.intValue;
    }

    private int getDimension() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (this.compact) {
                return (this.nbLayers * 4) + 11;
            }
            int i2 = this.nbLayers;
            return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
        }
        return invokeV.intValue;
    }

    private Point getFirstDifferent(Point point, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{point, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int x = point.getX() + i2;
            int y = point.getY();
            while (true) {
                y += i3;
                if (!isValid(x, y) || this.image.get(x, y) != z) {
                    break;
                }
                x += i2;
            }
            int i4 = x - i2;
            int i5 = y - i3;
            while (isValid(i4, i5) && this.image.get(i4, i5) == z) {
                i4 += i2;
            }
            int i6 = i4 - i2;
            while (isValid(i6, i5) && this.image.get(i6, i5) == z) {
                i5 += i3;
            }
            return new Point(i6, i5 - i3);
        }
        return (Point) invokeCommon.objValue;
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
                int i2 = width + 7;
                int i3 = height - 7;
                ResultPoint resultPoint9 = getFirstDifferent(new Point(i2, i3), false, 1, -1).toResultPoint();
                int i4 = height + 7;
                ResultPoint resultPoint10 = getFirstDifferent(new Point(i2, i4), false, 1, 1).toResultPoint();
                int i5 = width - 7;
                ResultPoint resultPoint11 = getFirstDifferent(new Point(i5, i4), false, -1, 1).toResultPoint();
                resultPoint = getFirstDifferent(new Point(i5, i3), false, -1, -1).toResultPoint();
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
                int i6 = round + 7;
                int i7 = round2 - 7;
                resultPoint5 = getFirstDifferent(new Point(i6, i7), false, 1, -1).toResultPoint();
                int i8 = round2 + 7;
                resultPoint6 = getFirstDifferent(new Point(i6, i8), false, 1, 1).toResultPoint();
                int i9 = round - 7;
                resultPoint7 = getFirstDifferent(new Point(i9, i8), false, -1, 1).toResultPoint();
                resultPoint8 = getFirstDifferent(new Point(i9, i7), false, -1, -1).toResultPoint();
            }
            return new Point(MathUtils.round((((resultPoint5.getX() + resultPoint8.getX()) + resultPoint6.getX()) + resultPoint7.getX()) / 4.0f), MathUtils.round((((resultPoint5.getY() + resultPoint8.getY()) + resultPoint6.getY()) + resultPoint7.getY()) / 4.0f));
        }
        return (Point) invokeV.objValue;
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, resultPointArr)) == null) ? expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension()) : (ResultPoint[]) invokeL.objValue;
    }

    public static int getRotation(int[] iArr, int i2) throws NotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, iArr, i2)) == null) {
            int i3 = 0;
            for (int i4 : iArr) {
                i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
            }
            int i5 = ((i3 & 1) << 11) + (i3 >> 1);
            for (int i6 = 0; i6 < 4; i6++) {
                if (Integer.bitCount(EXPECTED_CORNER_BITS[i6] ^ i5) <= 2) {
                    return i6;
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return invokeLI.intValue;
    }

    private boolean isValid(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65550, this, i2, i3)) == null) ? i2 >= 0 && i2 < this.image.getWidth() && i3 > 0 && i3 < this.image.getHeight() : invokeII.booleanValue;
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
            return color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color;
        }
        return invokeLLLL.booleanValue;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65553, this, bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4)) == null) {
            GridSampler gridSampler = GridSampler.getInstance();
            int dimension = getDimension();
            float f2 = dimension / 2.0f;
            int i2 = this.nbCenterLayers;
            float f3 = f2 - i2;
            float f4 = f2 + i2;
            return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f3, f3, f4, f3, f4, f4, f3, f4, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
        }
        return (BitMatrix) invokeLLLLL.objValue;
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, this, resultPoint, resultPoint2, i2)) == null) {
            float distance = distance(resultPoint, resultPoint2);
            float f2 = distance / i2;
            float x = resultPoint.getX();
            float y = resultPoint.getY();
            float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f2) / distance;
            float y2 = (f2 * (resultPoint2.getY() - resultPoint.getY())) / distance;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                float f3 = i4;
                if (this.image.get(MathUtils.round((f3 * x2) + x), MathUtils.round((f3 * y2) + y))) {
                    i3 |= 1 << ((i2 - i4) - 1);
                }
            }
            return i3;
        }
        return invokeLLI.intValue;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? detect(false) : (AztecDetectorResult) invokeV.objValue;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resultPoint, resultPoint2)) == null) ? MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY()) : invokeLL.floatValue;
    }

    private boolean isValid(ResultPoint resultPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, this, resultPoint)) == null) ? isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY())) : invokeL.booleanValue;
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
            int i2 = this.shift;
            return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i2 % 4], bullsEyeCorners[(i2 + 1) % 4], bullsEyeCorners[(i2 + 2) % 4], bullsEyeCorners[(i2 + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
        }
        return (AztecDetectorResult) invokeZ.objValue;
    }
}
