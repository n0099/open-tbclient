package com.repackage;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class gy8 {
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

    public static jy8 b(ly8 ly8Var, by8 by8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ly8Var, by8Var)) == null) {
            if (ly8Var == null || by8Var == null || ly8Var.e == null) {
                return null;
            }
            long[] a = a(ly8Var.b, ly8Var.a);
            MultiMediaData multiMediaData = ly8Var.e;
            jy8 jy8Var = new jy8();
            jy8Var.e = new ArrayList();
            jy8Var.a = multiMediaData.path;
            jy8Var.c = ly8Var.c;
            jy8Var.d = ly8Var.d;
            jy8Var.b = multiMediaData.rotation;
            for (int i = 0; i < ly8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                dy8 dy8Var = new dy8();
                dy8Var.a = wx8.b(multiMediaData.path, j, multiMediaData.type);
                dy8Var.b = multiMediaData.path;
                dy8Var.f = i;
                dy8Var.g = multiMediaData.type;
                dy8Var.h = ly8Var.c;
                dy8Var.i = ly8Var.d;
                dy8Var.j = by8Var;
                dy8Var.d = j;
                dy8Var.c = multiMediaData.rotation;
                jy8Var.e.add(dy8Var);
            }
            return jy8Var;
        }
        return (jy8) invokeLL.objValue;
    }

    public static List<jy8> c(ky8 ky8Var, by8 by8Var) {
        InterceptResult invokeLL;
        List<dy8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ky8Var, by8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (ky8Var == null || by8Var == null || ky8Var.b <= 0 || wb9.e(ky8Var.e) || wb9.e(ky8Var.f)) {
                return null;
            }
            long[] a = a(ky8Var.b, ky8Var.a);
            ArrayList arrayList = new ArrayList();
            jy8 jy8Var = null;
            for (int i = 0; i < ky8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(ky8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) wb9.c(ky8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        jy8Var = new jy8();
                        jy8Var.e = new ArrayList();
                        jy8Var.a = multiMediaData2.path;
                        jy8Var.c = ky8Var.c;
                        jy8Var.d = ky8Var.d;
                        jy8Var.b = multiMediaData2.rotation;
                        arrayList.add(jy8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) wb9.c(ky8Var.e, findInputIndexInSegments), j) * 1000;
                    dy8 dy8Var = new dy8();
                    dy8Var.a = wx8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    dy8Var.b = multiMediaData2.path;
                    dy8Var.f = i;
                    dy8Var.g = multiMediaData2.type;
                    dy8Var.h = ky8Var.c;
                    dy8Var.i = ky8Var.d;
                    dy8Var.d = multiMediaDataSeekTime;
                    dy8Var.j = by8Var;
                    dy8Var.c = multiMediaData2.rotation;
                    if (jy8Var != null && (list = jy8Var.e) != null) {
                        list.add(dy8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
