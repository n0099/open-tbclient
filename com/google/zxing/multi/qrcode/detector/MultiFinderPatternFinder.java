package com.google.zxing.multi.qrcode.detector;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    public static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    public static final FinderPatternInfo[] EMPTY_RESULT_ARRAY;
    public static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    public static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.zxing.multi.qrcode.detector.MultiFinderPatternFinder$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ModuleSizeComparator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ ModuleSizeComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, finderPattern, finderPattern2)) == null) {
                double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
                if (estimatedModuleSize < 0.0d) {
                    return -1;
                }
                return estimatedModuleSize > 0.0d ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(179363327, "Lcom/google/zxing/multi/qrcode/detector/MultiFinderPatternFinder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(179363327, "Lcom/google/zxing/multi/qrcode/detector/MultiFinderPatternFinder;");
                return;
            }
        }
        EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BitMatrix) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            List<FinderPattern> possibleCenters = getPossibleCenters();
            int size = possibleCenters.size();
            int i2 = 3;
            if (size >= 3) {
                char c2 = 0;
                if (size == 3) {
                    return new FinderPattern[][]{new FinderPattern[]{possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2)}};
                }
                Collections.sort(possibleCenters, new ModuleSizeComparator(null));
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                while (i3 < size - 2) {
                    FinderPattern finderPattern = possibleCenters.get(i3);
                    if (finderPattern != null) {
                        int i4 = i3 + 1;
                        while (i4 < size - 1) {
                            FinderPattern finderPattern2 = possibleCenters.get(i4);
                            if (finderPattern2 != null) {
                                float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                                float f2 = 0.05f;
                                float f3 = 0.5f;
                                if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) <= 0.5f || estimatedModuleSize < 0.05f) {
                                    int i5 = i4 + 1;
                                    while (i5 < size) {
                                        FinderPattern finderPattern3 = possibleCenters.get(i5);
                                        if (finderPattern3 != null) {
                                            float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                            if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) <= f3 || estimatedModuleSize2 < f2) {
                                                FinderPattern[] finderPatternArr = new FinderPattern[i2];
                                                finderPatternArr[c2] = finderPattern;
                                                finderPatternArr[1] = finderPattern2;
                                                finderPatternArr[2] = finderPattern3;
                                                ResultPoint.orderBestPatterns(finderPatternArr);
                                                FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                                float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                                float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                                float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                                float estimatedModuleSize3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                                if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= 9.0f && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                                    float sqrt = (float) Math.sqrt((distance * distance) + (distance3 * distance3));
                                                    if (Math.abs((distance2 - sqrt) / Math.min(distance2, sqrt)) < 0.1f) {
                                                        arrayList.add(finderPatternArr);
                                                    }
                                                }
                                            }
                                        }
                                        i5++;
                                        i2 = 3;
                                        c2 = 0;
                                        f2 = 0.05f;
                                        f3 = 0.5f;
                                    }
                                }
                            }
                            i4++;
                            i2 = 3;
                            c2 = 0;
                        }
                    }
                    i3++;
                    i2 = 3;
                    c2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    return (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()]);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (FinderPattern[][]) invokeV.objValue;
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
            boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
            BitMatrix image = getImage();
            int height = image.getHeight();
            int width = image.getWidth();
            int i2 = (((int) ((((float) height) / 228.0f) * 3.0f)) < 3 || z) ? 3 : 3;
            int[] iArr = new int[5];
            for (int i3 = i2 - 1; i3 < height; i3 += i2) {
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                iArr[4] = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < width; i5++) {
                    if (image.get(i5, i3)) {
                        if ((i4 & 1) == 1) {
                            i4++;
                        }
                        iArr[i4] = iArr[i4] + 1;
                    } else if ((i4 & 1) != 0) {
                        iArr[i4] = iArr[i4] + 1;
                    } else if (i4 == 4) {
                        if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, i5, z2)) {
                            iArr[0] = 0;
                            iArr[1] = 0;
                            iArr[2] = 0;
                            iArr[3] = 0;
                            iArr[4] = 0;
                            i4 = 0;
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                            i4 = 3;
                        }
                    } else {
                        i4++;
                        iArr[i4] = iArr[i4] + 1;
                    }
                }
                if (FinderPatternFinder.foundPatternCross(iArr)) {
                    handlePossibleCenter(iArr, i3, width, z2);
                }
            }
            FinderPattern[][] selectMutipleBestPatterns = selectMutipleBestPatterns();
            ArrayList arrayList = new ArrayList();
            for (FinderPattern[] finderPatternArr : selectMutipleBestPatterns) {
                ResultPoint.orderBestPatterns(finderPatternArr);
                arrayList.add(new FinderPatternInfo(finderPatternArr));
            }
            if (arrayList.isEmpty()) {
                return EMPTY_RESULT_ARRAY;
            }
            return (FinderPatternInfo[]) arrayList.toArray(new FinderPatternInfo[arrayList.size()]);
        }
        return (FinderPatternInfo[]) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix, resultPointCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BitMatrix) objArr2[0], (ResultPointCallback) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
