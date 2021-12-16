package com.google.zxing.multi.qrcode;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    public static /* synthetic */ Interceptable $ic;
    public static final Result[] EMPTY_RESULT_ARRAY;
    public static final ResultPoint[] NO_POINTS;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.zxing.multi.qrcode.QRCodeMultiReader$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class SAComparator implements Serializable, Comparator<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SAComparator() {
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

        public /* synthetic */ SAComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Result result, Result result2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, result, result2)) == null) {
                int intValue = ((Integer) result.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
                int intValue2 = ((Integer) result2.getResultMetadata().get(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)).intValue();
                if (intValue < intValue2) {
                    return -1;
                }
                return intValue > intValue2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1983133329, "Lcom/google/zxing/multi/qrcode/QRCodeMultiReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1983133329, "Lcom/google/zxing/multi/qrcode/QRCodeMultiReader;");
                return;
            }
        }
        EMPTY_RESULT_ARRAY = new Result[0];
        NO_POINTS = new ResultPoint[0];
    }

    public QRCodeMultiReader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<Result> processStructuredAppend(List<Result> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            Iterator<Result> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                ArrayList<Result> arrayList2 = new ArrayList();
                for (Result result : list) {
                    arrayList.add(result);
                    if (result.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                        arrayList2.add(result);
                    }
                }
                Collections.sort(arrayList2, new SAComparator(null));
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                int i3 = 0;
                for (Result result2 : arrayList2) {
                    sb.append(result2.getText());
                    i2 += result2.getRawBytes().length;
                    if (result2.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                        for (byte[] bArr : (Iterable) result2.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)) {
                            i3 += bArr.length;
                        }
                    }
                }
                byte[] bArr2 = new byte[i2];
                byte[] bArr3 = new byte[i3];
                int i4 = 0;
                int i5 = 0;
                for (Result result3 : arrayList2) {
                    System.arraycopy(result3.getRawBytes(), 0, bArr2, i4, result3.getRawBytes().length);
                    i4 += result3.getRawBytes().length;
                    if (result3.getResultMetadata().containsKey(ResultMetadataType.BYTE_SEGMENTS)) {
                        for (byte[] bArr4 : (Iterable) result3.getResultMetadata().get(ResultMetadataType.BYTE_SEGMENTS)) {
                            System.arraycopy(bArr4, 0, bArr3, i5, bArr4.length);
                            i5 += bArr4.length;
                        }
                    }
                }
                Result result4 = new Result(sb.toString(), bArr2, NO_POINTS, BarcodeFormat.QR_CODE);
                if (i3 > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(bArr3);
                    result4.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
                }
                arrayList.add(result4);
                return arrayList;
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, binaryBitmap)) == null) ? decodeMultiple(binaryBitmap, null) : (Result[]) invokeL.objValue;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        InterceptResult invokeLL;
        DetectorResult[] detectMulti;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, binaryBitmap, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (DetectorResult detectorResult : new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map)) {
                try {
                    DecoderResult decode = getDecoder().decode(detectorResult.getBits(), map);
                    ResultPoint[] points = detectorResult.getPoints();
                    if (decode.getOther() instanceof QRCodeDecoderMetaData) {
                        ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
                    }
                    Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
                    List<byte[]> byteSegments = decode.getByteSegments();
                    if (byteSegments != null) {
                        result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                    }
                    String eCLevel = decode.getECLevel();
                    if (eCLevel != null) {
                        result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                    }
                    if (decode.hasStructuredAppend()) {
                        result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
                        result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
                    }
                    arrayList.add(result);
                } catch (ReaderException unused) {
                }
            }
            if (arrayList.isEmpty()) {
                return EMPTY_RESULT_ARRAY;
            }
            List<Result> processStructuredAppend = processStructuredAppend(arrayList);
            return (Result[]) processStructuredAppend.toArray(new Result[processStructuredAppend.size()]);
        }
        return (Result[]) invokeLL.objValue;
    }
}
