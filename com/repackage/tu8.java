package com.repackage;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class tu8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (i < 0) {
                i = 0;
            }
            float[] fArr = new float[i];
            if (i > 1) {
                float f = 1.0f / i;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    if (i3 == i) {
                        int i4 = i2 - 1;
                        fArr[i2] = fArr[i4] + ((1.0f - fArr[i4]) / 2.0f);
                    } else {
                        fArr[i2] = i3 * f;
                    }
                    i2 = i3;
                }
            } else if (i == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i];
            for (int i5 = 0; i5 < i; i5++) {
                jArr[i5] = fArr[i5] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static wu8 b(yu8 yu8Var, ou8 ou8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yu8Var, ou8Var)) == null) {
            if (yu8Var == null || ou8Var == null || yu8Var.e == null) {
                return null;
            }
            long[] a = a(yu8Var.b, yu8Var.a);
            MultiMediaData multiMediaData = yu8Var.e;
            wu8 wu8Var = new wu8();
            wu8Var.e = new ArrayList();
            wu8Var.a = multiMediaData.path;
            wu8Var.c = yu8Var.c;
            wu8Var.d = yu8Var.d;
            wu8Var.b = multiMediaData.rotation;
            for (int i = 0; i < yu8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                qu8 qu8Var = new qu8();
                qu8Var.a = ju8.b(multiMediaData.path, j, multiMediaData.type);
                qu8Var.b = multiMediaData.path;
                qu8Var.f = i;
                qu8Var.g = multiMediaData.type;
                qu8Var.h = yu8Var.c;
                qu8Var.i = yu8Var.d;
                qu8Var.j = ou8Var;
                qu8Var.d = j;
                qu8Var.c = multiMediaData.rotation;
                wu8Var.e.add(qu8Var);
            }
            return wu8Var;
        }
        return (wu8) invokeLL.objValue;
    }

    public static List<wu8> c(xu8 xu8Var, ou8 ou8Var) {
        InterceptResult invokeLL;
        List<qu8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xu8Var, ou8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (xu8Var == null || ou8Var == null || xu8Var.b <= 0 || c89.e(xu8Var.e) || c89.e(xu8Var.f)) {
                return null;
            }
            long[] a = a(xu8Var.b, xu8Var.a);
            ArrayList arrayList = new ArrayList();
            wu8 wu8Var = null;
            for (int i = 0; i < xu8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(xu8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) c89.c(xu8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        wu8Var = new wu8();
                        wu8Var.e = new ArrayList();
                        wu8Var.a = multiMediaData2.path;
                        wu8Var.c = xu8Var.c;
                        wu8Var.d = xu8Var.d;
                        wu8Var.b = multiMediaData2.rotation;
                        arrayList.add(wu8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) c89.c(xu8Var.e, findInputIndexInSegments), j) * 1000;
                    qu8 qu8Var = new qu8();
                    qu8Var.a = ju8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    qu8Var.b = multiMediaData2.path;
                    qu8Var.f = i;
                    qu8Var.g = multiMediaData2.type;
                    qu8Var.h = xu8Var.c;
                    qu8Var.i = xu8Var.d;
                    qu8Var.d = multiMediaDataSeekTime;
                    qu8Var.j = ou8Var;
                    qu8Var.c = multiMediaData2.rotation;
                    if (wu8Var != null && (list = wu8Var.e) != null) {
                        list.add(qu8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
