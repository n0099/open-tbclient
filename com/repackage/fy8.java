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
public class fy8 {
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

    public static iy8 b(ky8 ky8Var, ay8 ay8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ky8Var, ay8Var)) == null) {
            if (ky8Var == null || ay8Var == null || ky8Var.e == null) {
                return null;
            }
            long[] a = a(ky8Var.b, ky8Var.a);
            MultiMediaData multiMediaData = ky8Var.e;
            iy8 iy8Var = new iy8();
            iy8Var.e = new ArrayList();
            iy8Var.a = multiMediaData.path;
            iy8Var.c = ky8Var.c;
            iy8Var.d = ky8Var.d;
            iy8Var.b = multiMediaData.rotation;
            for (int i = 0; i < ky8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                cy8 cy8Var = new cy8();
                cy8Var.a = vx8.b(multiMediaData.path, j, multiMediaData.type);
                cy8Var.b = multiMediaData.path;
                cy8Var.f = i;
                cy8Var.g = multiMediaData.type;
                cy8Var.h = ky8Var.c;
                cy8Var.i = ky8Var.d;
                cy8Var.j = ay8Var;
                cy8Var.d = j;
                cy8Var.c = multiMediaData.rotation;
                iy8Var.e.add(cy8Var);
            }
            return iy8Var;
        }
        return (iy8) invokeLL.objValue;
    }

    public static List<iy8> c(jy8 jy8Var, ay8 ay8Var) {
        InterceptResult invokeLL;
        List<cy8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jy8Var, ay8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (jy8Var == null || ay8Var == null || jy8Var.b <= 0 || yb9.e(jy8Var.e) || yb9.e(jy8Var.f)) {
                return null;
            }
            long[] a = a(jy8Var.b, jy8Var.a);
            ArrayList arrayList = new ArrayList();
            iy8 iy8Var = null;
            for (int i = 0; i < jy8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(jy8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) yb9.c(jy8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        iy8Var = new iy8();
                        iy8Var.e = new ArrayList();
                        iy8Var.a = multiMediaData2.path;
                        iy8Var.c = jy8Var.c;
                        iy8Var.d = jy8Var.d;
                        iy8Var.b = multiMediaData2.rotation;
                        arrayList.add(iy8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) yb9.c(jy8Var.e, findInputIndexInSegments), j) * 1000;
                    cy8 cy8Var = new cy8();
                    cy8Var.a = vx8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    cy8Var.b = multiMediaData2.path;
                    cy8Var.f = i;
                    cy8Var.g = multiMediaData2.type;
                    cy8Var.h = jy8Var.c;
                    cy8Var.i = jy8Var.d;
                    cy8Var.d = multiMediaDataSeekTime;
                    cy8Var.j = ay8Var;
                    cy8Var.c = multiMediaData2.rotation;
                    if (iy8Var != null && (list = iy8Var.e) != null) {
                        list.add(cy8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
