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
import com.google.zxing.ReaderException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.detector.Detector;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public final class MultiDetector extends Detector {
    public static /* synthetic */ Interceptable $ic;
    public static final DetectorResult[] EMPTY_DETECTOR_RESULTS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1189443423, "Lcom/google/zxing/multi/qrcode/detector/MultiDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1189443423, "Lcom/google/zxing/multi/qrcode/detector/MultiDetector;");
                return;
            }
        }
        EMPTY_DETECTOR_RESULTS = new DetectorResult[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BitMatrix) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DetectorResult[] detectMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            FinderPatternInfo[] findMulti = new MultiFinderPatternFinder(getImage(), map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)).findMulti(map);
            if (findMulti.length != 0) {
                ArrayList arrayList = new ArrayList();
                for (FinderPatternInfo finderPatternInfo : findMulti) {
                    try {
                        arrayList.add(processFinderPatternInfo(finderPatternInfo));
                    } catch (ReaderException unused) {
                    }
                }
                if (arrayList.isEmpty()) {
                    return EMPTY_DETECTOR_RESULTS;
                }
                return (DetectorResult[]) arrayList.toArray(new DetectorResult[arrayList.size()]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (DetectorResult[]) invokeL.objValue;
    }
}
