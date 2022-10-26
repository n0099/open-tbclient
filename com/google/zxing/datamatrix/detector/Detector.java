package com.google.zxing.datamatrix.detector;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Detector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitMatrix image;
    public final WhiteRectangleDetector rectangleDetector;

    /* renamed from: com.google.zxing.datamatrix.detector.Detector$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class ResultPointsAndTransitions {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResultPoint from;
        public final ResultPoint to;
        public final int transitions;

        public ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {resultPoint, resultPoint2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        public /* synthetic */ ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i, AnonymousClass1 anonymousClass1) {
            this(resultPoint, resultPoint2, i);
        }

        public ResultPoint getFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.from;
            }
            return (ResultPoint) invokeV.objValue;
        }

        public ResultPoint getTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.to;
            }
            return (ResultPoint) invokeV.objValue;
        }

        public int getTransitions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.transitions;
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.from + "/" + this.to + WebvttCueParser.CHAR_SLASH + this.transitions;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class ResultPointsAndTransitionsComparator implements Serializable, Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ResultPointsAndTransitionsComparator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ ResultPointsAndTransitionsComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, resultPointsAndTransitions, resultPointsAndTransitions2)) == null) {
                return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
            }
            return invokeLL.intValue;
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private boolean isValid(ResultPoint resultPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, resultPoint)) == null) {
            if (resultPoint.getX() >= 0.0f && resultPoint.getX() < this.image.getWidth() && resultPoint.getY() > 0.0f && resultPoint.getY() < this.image.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{resultPoint, resultPoint2, resultPoint3, resultPoint4, Integer.valueOf(i)})) == null) {
            float f = i;
            float distance = distance(resultPoint, resultPoint2) / f;
            float distance2 = distance(resultPoint3, resultPoint4);
            ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
            float distance3 = distance(resultPoint, resultPoint3) / f;
            float distance4 = distance(resultPoint2, resultPoint4);
            ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
            if (!isValid(resultPoint5)) {
                if (isValid(resultPoint6)) {
                    return resultPoint6;
                }
                return null;
            } else if (!isValid(resultPoint6)) {
                return resultPoint5;
            } else {
                if (Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                    return resultPoint5;
                }
                return resultPoint6;
            }
        }
        return (ResultPoint) invokeCommon.objValue;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{resultPoint, resultPoint2, resultPoint3, resultPoint4, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float distance = distance(resultPoint, resultPoint2) / i;
            float distance2 = distance(resultPoint3, resultPoint4);
            ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
            float distance3 = distance(resultPoint, resultPoint3) / i2;
            float distance4 = distance(resultPoint2, resultPoint4);
            ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
            if (!isValid(resultPoint5)) {
                if (isValid(resultPoint6)) {
                    return resultPoint6;
                }
                return null;
            } else if (!isValid(resultPoint6)) {
                return resultPoint5;
            } else {
                if (Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                    return resultPoint5;
                }
                return resultPoint6;
            }
        }
        return (ResultPoint) invokeCommon.objValue;
    }

    public static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, resultPoint, resultPoint2)) == null) {
            return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
        }
        return invokeLL.intValue;
    }

    public static void increment(Map map, ResultPoint resultPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, resultPoint) == null) {
            Integer num = (Integer) map.get(resultPoint);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            map.put(resultPoint, Integer.valueOf(i));
        }
    }

    public static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float f = i - 0.5f;
            float f2 = i2 - 0.5f;
            return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
        }
        return (BitMatrix) invokeCommon.objValue;
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, resultPoint, resultPoint2)) == null) {
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            int x2 = (int) resultPoint2.getX();
            int y2 = (int) resultPoint2.getY();
            int i6 = 0;
            int i7 = 1;
            if (Math.abs(y2 - y) > Math.abs(x2 - x)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                y = x;
                x = y;
                y2 = x2;
                x2 = y2;
            }
            int abs = Math.abs(x2 - x);
            int abs2 = Math.abs(y2 - y);
            int i8 = (-abs) / 2;
            if (y < y2) {
                i = 1;
            } else {
                i = -1;
            }
            if (x >= x2) {
                i7 = -1;
            }
            BitMatrix bitMatrix = this.image;
            if (z) {
                i2 = y;
            } else {
                i2 = x;
            }
            if (z) {
                i3 = x;
            } else {
                i3 = y;
            }
            boolean z2 = bitMatrix.get(i2, i3);
            while (x != x2) {
                BitMatrix bitMatrix2 = this.image;
                if (z) {
                    i4 = y;
                } else {
                    i4 = x;
                }
                if (z) {
                    i5 = x;
                } else {
                    i5 = y;
                }
                boolean z3 = bitMatrix2.get(i4, i5);
                if (z3 != z2) {
                    i6++;
                    z2 = z3;
                }
                i8 += abs2;
                if (i8 > 0) {
                    if (y == y2) {
                        break;
                    }
                    y += i;
                    i8 -= abs;
                }
                x += i7;
            }
            return new ResultPointsAndTransitions(resultPoint, resultPoint2, i6, null);
        }
        return (ResultPointsAndTransitions) invokeLL.objValue;
    }

    public DetectorResult detect() throws NotFoundException {
        InterceptResult invokeV;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BitMatrix sampleGrid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ResultPoint[] detect = this.rectangleDetector.detect();
            ResultPoint resultPoint3 = detect[0];
            ResultPoint resultPoint4 = detect[1];
            ResultPoint resultPoint5 = detect[2];
            ResultPoint resultPoint6 = detect[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
            arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
            arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
            arrayList.add(transitionsBetween(resultPoint5, resultPoint6));
            ResultPoint resultPoint7 = null;
            Collections.sort(arrayList, new ResultPointsAndTransitionsComparator(null));
            ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
            ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
            HashMap hashMap = new HashMap();
            increment(hashMap, resultPointsAndTransitions.getFrom());
            increment(hashMap, resultPointsAndTransitions.getTo());
            increment(hashMap, resultPointsAndTransitions2.getFrom());
            increment(hashMap, resultPointsAndTransitions2.getTo());
            ResultPoint resultPoint8 = null;
            ResultPoint resultPoint9 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                ResultPoint resultPoint10 = (ResultPoint) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    resultPoint8 = resultPoint10;
                } else if (resultPoint7 == null) {
                    resultPoint7 = resultPoint10;
                } else {
                    resultPoint9 = resultPoint10;
                }
            }
            if (resultPoint7 != null && resultPoint8 != null && resultPoint9 != null) {
                ResultPoint[] resultPointArr = {resultPoint7, resultPoint8, resultPoint9};
                ResultPoint.orderBestPatterns(resultPointArr);
                ResultPoint resultPoint11 = resultPointArr[0];
                ResultPoint resultPoint12 = resultPointArr[1];
                ResultPoint resultPoint13 = resultPointArr[2];
                if (!hashMap.containsKey(resultPoint3)) {
                    resultPoint = resultPoint3;
                } else if (!hashMap.containsKey(resultPoint4)) {
                    resultPoint = resultPoint4;
                } else if (!hashMap.containsKey(resultPoint5)) {
                    resultPoint = resultPoint5;
                } else {
                    resultPoint = resultPoint6;
                }
                int transitions = transitionsBetween(resultPoint13, resultPoint).getTransitions();
                int transitions2 = transitionsBetween(resultPoint11, resultPoint).getTransitions();
                if ((transitions & 1) == 1) {
                    transitions++;
                }
                int i = transitions + 2;
                if ((transitions2 & 1) == 1) {
                    transitions2++;
                }
                int i2 = transitions2 + 2;
                if (i * 4 < i2 * 7 && i2 * 4 < i * 7) {
                    ResultPoint correctTopRight = correctTopRight(resultPoint12, resultPoint11, resultPoint13, resultPoint, Math.min(i2, i));
                    if (correctTopRight != null) {
                        resultPoint = correctTopRight;
                    }
                    int max = Math.max(transitionsBetween(resultPoint13, resultPoint).getTransitions(), transitionsBetween(resultPoint11, resultPoint).getTransitions()) + 1;
                    if ((max & 1) == 1) {
                        max++;
                    }
                    int i3 = max;
                    sampleGrid = sampleGrid(this.image, resultPoint13, resultPoint12, resultPoint11, resultPoint, i3, i3);
                    resultPoint2 = resultPoint13;
                } else {
                    resultPoint2 = resultPoint13;
                    ResultPoint correctTopRightRectangular = correctTopRightRectangular(resultPoint12, resultPoint11, resultPoint13, resultPoint, i, i2);
                    if (correctTopRightRectangular != null) {
                        resultPoint = correctTopRightRectangular;
                    }
                    int transitions3 = transitionsBetween(resultPoint2, resultPoint).getTransitions();
                    int transitions4 = transitionsBetween(resultPoint11, resultPoint).getTransitions();
                    if ((transitions3 & 1) == 1) {
                        transitions3++;
                    }
                    int i4 = transitions3;
                    if ((transitions4 & 1) == 1) {
                        transitions4++;
                    }
                    sampleGrid = sampleGrid(this.image, resultPoint2, resultPoint12, resultPoint11, resultPoint, i4, transitions4);
                }
                return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint2, resultPoint12, resultPoint11, resultPoint});
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (DetectorResult) invokeV.objValue;
    }
}
