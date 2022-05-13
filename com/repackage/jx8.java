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
public class jx8 {
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

    public static mx8 b(ox8 ox8Var, ex8 ex8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, ox8Var, ex8Var)) == null) {
            if (ox8Var == null || ex8Var == null || ox8Var.e == null) {
                return null;
            }
            long[] a = a(ox8Var.b, ox8Var.a);
            MultiMediaData multiMediaData = ox8Var.e;
            mx8 mx8Var = new mx8();
            mx8Var.e = new ArrayList();
            mx8Var.a = multiMediaData.path;
            mx8Var.c = ox8Var.c;
            mx8Var.d = ox8Var.d;
            mx8Var.b = multiMediaData.rotation;
            for (int i = 0; i < ox8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                gx8 gx8Var = new gx8();
                gx8Var.a = zw8.b(multiMediaData.path, j, multiMediaData.type);
                gx8Var.b = multiMediaData.path;
                gx8Var.f = i;
                gx8Var.g = multiMediaData.type;
                gx8Var.h = ox8Var.c;
                gx8Var.i = ox8Var.d;
                gx8Var.j = ex8Var;
                gx8Var.d = j;
                gx8Var.c = multiMediaData.rotation;
                mx8Var.e.add(gx8Var);
            }
            return mx8Var;
        }
        return (mx8) invokeLL.objValue;
    }

    public static List<mx8> c(nx8 nx8Var, ex8 ex8Var) {
        InterceptResult invokeLL;
        List<gx8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, nx8Var, ex8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (nx8Var == null || ex8Var == null || nx8Var.b <= 0 || ab9.e(nx8Var.e) || ab9.e(nx8Var.f)) {
                return null;
            }
            long[] a = a(nx8Var.b, nx8Var.a);
            ArrayList arrayList = new ArrayList();
            mx8 mx8Var = null;
            for (int i = 0; i < nx8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(nx8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) ab9.c(nx8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        mx8Var = new mx8();
                        mx8Var.e = new ArrayList();
                        mx8Var.a = multiMediaData2.path;
                        mx8Var.c = nx8Var.c;
                        mx8Var.d = nx8Var.d;
                        mx8Var.b = multiMediaData2.rotation;
                        arrayList.add(mx8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) ab9.c(nx8Var.e, findInputIndexInSegments), j) * 1000;
                    gx8 gx8Var = new gx8();
                    gx8Var.a = zw8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    gx8Var.b = multiMediaData2.path;
                    gx8Var.f = i;
                    gx8Var.g = multiMediaData2.type;
                    gx8Var.h = nx8Var.c;
                    gx8Var.i = nx8Var.d;
                    gx8Var.d = multiMediaDataSeekTime;
                    gx8Var.j = ex8Var;
                    gx8Var.c = multiMediaData2.rotation;
                    if (mx8Var != null && (list = mx8Var.e) != null) {
                        list.add(gx8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
