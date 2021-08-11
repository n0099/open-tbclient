package com.google.zxing.qrcode.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;
/* loaded from: classes10.dex */
public class Detector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitMatrix image;
    public ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, resultPoint, resultPoint2)) == null) {
            float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
            float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
            return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays) ? sizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
        }
        return invokeLL.floatValue;
    }

    public static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f2) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{resultPoint, resultPoint2, resultPoint3, Float.valueOf(f2)})) == null) {
            int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f2) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f2)) / 2) + 7;
            int i2 = round & 3;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return round;
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                return round - 1;
            }
            return round + 1;
        }
        return invokeCommon.intValue;
    }

    public static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        InterceptResult invokeCommon;
        float x;
        float y;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{resultPoint, resultPoint2, resultPoint3, resultPoint4, Integer.valueOf(i2)})) == null) {
            float f3 = i2 - 3.5f;
            if (resultPoint4 != null) {
                x = resultPoint4.getX();
                y = resultPoint4.getY();
                f2 = f3 - 3.0f;
            } else {
                x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
                y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
                f2 = f3;
            }
            return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
        }
        return (PerspectiveTransform) invokeCommon.objValue;
    }

    public static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i2) throws NotFoundException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bitMatrix, perspectiveTransform, i2)) == null) ? GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, perspectiveTransform) : (BitMatrix) invokeLLI.objValue;
    }

    private float sizeOfBlackWhiteBlackRun(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Detector detector;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.AD_TEXT_ID, this, i2, i3, i4, i5)) == null) {
            int i11 = 1;
            boolean z3 = Math.abs(i5 - i3) > Math.abs(i4 - i2);
            if (z3) {
                i7 = i2;
                i6 = i3;
                i9 = i4;
                i8 = i5;
            } else {
                i6 = i2;
                i7 = i3;
                i8 = i4;
                i9 = i5;
            }
            int abs = Math.abs(i8 - i6);
            int abs2 = Math.abs(i9 - i7);
            int i12 = (-abs) / 2;
            int i13 = i6 < i8 ? 1 : -1;
            int i14 = i7 < i9 ? 1 : -1;
            int i15 = i8 + i13;
            int i16 = i6;
            int i17 = i7;
            int i18 = 0;
            while (true) {
                if (i16 == i15) {
                    i10 = i15;
                    break;
                }
                int i19 = z3 ? i17 : i16;
                int i20 = z3 ? i16 : i17;
                if (i18 == i11) {
                    detector = this;
                    z = z3;
                    i10 = i15;
                    z2 = true;
                } else {
                    detector = this;
                    z = z3;
                    i10 = i15;
                    z2 = false;
                }
                if (z2 == detector.image.get(i19, i20)) {
                    if (i18 == 2) {
                        return MathUtils.distance(i16, i17, i6, i7);
                    }
                    i18++;
                }
                i12 += abs2;
                if (i12 > 0) {
                    if (i17 == i9) {
                        break;
                    }
                    i17 += i14;
                    i12 -= abs;
                }
                i16 += i13;
                i15 = i10;
                z3 = z;
                i11 = 1;
            }
            if (i18 == 2) {
                return MathUtils.distance(i10, i9, i6, i7);
            }
            return Float.NaN;
        }
        return invokeIIII.floatValue;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(AdIconUtil.BAIDU_LOGO_ID, this, i2, i3, i4, i5)) == null) {
            float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i2, i3, i4, i5);
            int i6 = i2 - (i4 - i2);
            int i7 = 0;
            if (i6 < 0) {
                f2 = i2 / (i2 - i6);
                i6 = 0;
            } else if (i6 >= this.image.getWidth()) {
                f2 = ((this.image.getWidth() - 1) - i2) / (i6 - i2);
                i6 = this.image.getWidth() - 1;
            } else {
                f2 = 1.0f;
            }
            float f4 = i3;
            int i8 = (int) (f4 - ((i5 - i3) * f2));
            if (i8 < 0) {
                f3 = f4 / (i3 - i8);
            } else if (i8 >= this.image.getHeight()) {
                f3 = ((this.image.getHeight() - 1) - i3) / (i8 - i3);
                i7 = this.image.getHeight() - 1;
            } else {
                i7 = i8;
                f3 = 1.0f;
            }
            return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i2, i3, (int) (i2 + ((i6 - i2) * f3)), i7)) - 1.0f;
        }
        return invokeIIII.floatValue;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, resultPoint, resultPoint2, resultPoint3)) == null) ? (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f : invokeLLL.floatValue;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? detect(null) : (DetectorResult) invokeV.objValue;
    }

    public final AlignmentPattern findAlignmentInRegion(float f2, int i2, int i3, float f3) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f3)})) == null) {
            int i4 = (int) (f3 * f2);
            int max = Math.max(0, i2 - i4);
            int min = Math.min(this.image.getWidth() - 1, i2 + i4) - max;
            float f4 = 3.0f * f2;
            if (min >= f4) {
                int max2 = Math.max(0, i3 - i4);
                int min2 = Math.min(this.image.getHeight() - 1, i3 + i4) - max2;
                if (min2 >= f4) {
                    return new AlignmentPatternFinder(this.image, max, max2, min, min2, f2, this.resultPointCallback).find();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (AlignmentPattern) invokeCommon.objValue;
    }

    public final BitMatrix getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.image : (BitMatrix) invokeV.objValue;
    }

    public final ResultPointCallback getResultPointCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.resultPointCallback : (ResultPointCallback) invokeV.objValue;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, finderPatternInfo)) == null) {
            FinderPattern topLeft = finderPatternInfo.getTopLeft();
            FinderPattern topRight = finderPatternInfo.getTopRight();
            FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
            float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
            if (calculateModuleSize >= 1.0f) {
                int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
                Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
                int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
                AlignmentPattern alignmentPattern = null;
                if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                    float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                    float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                    float f2 = 1.0f - (3.0f / dimensionForVersion);
                    int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f2));
                    int y2 = (int) (topLeft.getY() + (f2 * (y - topLeft.getY())));
                    for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                        try {
                            alignmentPattern = findAlignmentInRegion(calculateModuleSize, x2, y2, i2);
                            break;
                        } catch (NotFoundException unused) {
                        }
                    }
                }
                return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension), alignmentPattern == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern});
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (DetectorResult) invokeL.objValue;
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            this.resultPointCallback = resultPointCallback;
            return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
        }
        return (DetectorResult) invokeL.objValue;
    }
}
