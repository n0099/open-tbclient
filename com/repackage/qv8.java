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
public class qv8 {
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

    public static tv8 b(vv8 vv8Var, lv8 lv8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, vv8Var, lv8Var)) == null) {
            if (vv8Var == null || lv8Var == null || vv8Var.e == null) {
                return null;
            }
            long[] a = a(vv8Var.b, vv8Var.a);
            MultiMediaData multiMediaData = vv8Var.e;
            tv8 tv8Var = new tv8();
            tv8Var.e = new ArrayList();
            tv8Var.a = multiMediaData.path;
            tv8Var.c = vv8Var.c;
            tv8Var.d = vv8Var.d;
            tv8Var.b = multiMediaData.rotation;
            for (int i = 0; i < vv8Var.b; i++) {
                long j = multiMediaData.start + a[i];
                nv8 nv8Var = new nv8();
                nv8Var.a = gv8.b(multiMediaData.path, j, multiMediaData.type);
                nv8Var.b = multiMediaData.path;
                nv8Var.f = i;
                nv8Var.g = multiMediaData.type;
                nv8Var.h = vv8Var.c;
                nv8Var.i = vv8Var.d;
                nv8Var.j = lv8Var;
                nv8Var.d = j;
                nv8Var.c = multiMediaData.rotation;
                tv8Var.e.add(nv8Var);
            }
            return tv8Var;
        }
        return (tv8) invokeLL.objValue;
    }

    public static List<tv8> c(uv8 uv8Var, lv8 lv8Var) {
        InterceptResult invokeLL;
        List<nv8> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uv8Var, lv8Var)) == null) {
            MultiMediaData multiMediaData = null;
            if (uv8Var == null || lv8Var == null || uv8Var.b <= 0 || b99.e(uv8Var.e) || b99.e(uv8Var.f)) {
                return null;
            }
            long[] a = a(uv8Var.b, uv8Var.a);
            ArrayList arrayList = new ArrayList();
            tv8 tv8Var = null;
            for (int i = 0; i < uv8Var.b; i++) {
                long j = ((float) a[i]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(uv8Var.e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) b99.c(uv8Var.f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        tv8Var = new tv8();
                        tv8Var.e = new ArrayList();
                        tv8Var.a = multiMediaData2.path;
                        tv8Var.c = uv8Var.c;
                        tv8Var.d = uv8Var.d;
                        tv8Var.b = multiMediaData2.rotation;
                        arrayList.add(tv8Var);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) b99.c(uv8Var.e, findInputIndexInSegments), j) * 1000;
                    nv8 nv8Var = new nv8();
                    nv8Var.a = gv8.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    nv8Var.b = multiMediaData2.path;
                    nv8Var.f = i;
                    nv8Var.g = multiMediaData2.type;
                    nv8Var.h = uv8Var.c;
                    nv8Var.i = uv8Var.d;
                    nv8Var.d = multiMediaDataSeekTime;
                    nv8Var.j = lv8Var;
                    nv8Var.c = multiMediaData2.rotation;
                    if (tv8Var != null && (list = tv8Var.e) != null) {
                        list.add(nv8Var);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
