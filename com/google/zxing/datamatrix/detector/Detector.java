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
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class ResultPointsAndTransitions {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResultPoint from;
        public final ResultPoint to;
        public final int transitions;

        public /* synthetic */ ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i, AnonymousClass1 anonymousClass1) {
            this(resultPoint, resultPoint2, i);
        }

        public ResultPoint getFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.from : (ResultPoint) invokeV.objValue;
        }

        public ResultPoint getTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.to : (ResultPoint) invokeV.objValue;
        }

        public int getTransitions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.transitions : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.from + "/" + this.to + WebvttCueParser.CHAR_SLASH + this.transitions;
            }
            return (String) invokeV.objValue;
        }

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
    }

    /* loaded from: classes7.dex */
    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, resultPointsAndTransitions, resultPointsAndTransitions2)) == null) ? resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions() : invokeLL.intValue;
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
            if (isValid(resultPoint5)) {
                return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
            } else if (isValid(resultPoint6)) {
                return resultPoint6;
            } else {
                return null;
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
            if (isValid(resultPoint5)) {
                return (isValid(resultPoint6) && Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
            } else if (isValid(resultPoint6)) {
                return resultPoint6;
            } else {
                return null;
            }
        }
        return (ResultPoint) invokeCommon.objValue;
    }

    public static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, resultPoint, resultPoint2)) == null) ? MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2)) : invokeLL.intValue;
    }

    public static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, resultPoint) == null) {
            Integer num = map.get(resultPoint);
            map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    private boolean isValid(ResultPoint resultPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, resultPoint)) == null) ? resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight()) : invokeL.booleanValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, resultPoint, resultPoint2)) == null) {
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            int x2 = (int) resultPoint2.getX();
            int y2 = (int) resultPoint2.getY();
            int i = 0;
            boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
            if (z) {
                y = x;
                x = y;
                y2 = x2;
                x2 = y2;
            }
            int abs = Math.abs(x2 - x);
            int abs2 = Math.abs(y2 - y);
            int i2 = (-abs) / 2;
            int i3 = y < y2 ? 1 : -1;
            int i4 = x >= x2 ? -1 : 1;
            boolean z2 = this.image.get(z ? y : x, z ? x : y);
            while (x != x2) {
                boolean z3 = this.image.get(z ? y : x, z ? x : y);
                if (z3 != z2) {
                    i++;
                    z2 = z3;
                }
                i2 += abs2;
                if (i2 > 0) {
                    if (y == y2) {
                        break;
                    }
                    y += i3;
                    i2 -= abs;
                }
                x += i4;
            }
            return new ResultPointsAndTransitions(resultPoint, resultPoint2, i, null);
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
                } else if (hashMap.containsKey(resultPoint4)) {
                    resultPoint = !hashMap.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
                } else {
                    resultPoint = resultPoint4;
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
