package d.a.s0.z3.m.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            float[] fArr = new float[i2];
            if (i2 > 1) {
                float f2 = 1.0f / i2;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    if (i4 == i2) {
                        int i5 = i3 - 1;
                        fArr[i3] = fArr[i5] + ((1.0f - fArr[i5]) / 2.0f);
                    } else {
                        fArr[i3] = i4 * f2;
                    }
                    i3 = i4;
                }
            } else if (i2 == 1) {
                fArr[0] = 0.5f;
            }
            long[] jArr = new long[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                jArr[i6] = fArr[i6] * ((float) j) * 1000.0f;
            }
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }

    public static n b(p pVar, f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, pVar, fVar)) == null) {
            if (pVar == null || fVar == null || pVar.f70138e == null) {
                return null;
            }
            long[] a2 = a(pVar.f70135b, pVar.f70134a);
            MultiMediaData multiMediaData = pVar.f70138e;
            n nVar = new n();
            nVar.f70127e = new ArrayList();
            nVar.f70123a = multiMediaData.path;
            nVar.f70125c = pVar.f70136c;
            nVar.f70126d = pVar.f70137d;
            nVar.f70124b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f70135b; i2++) {
                long j = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f70105a = a.b(multiMediaData.path, j, multiMediaData.type);
                hVar.f70106b = multiMediaData.path;
                hVar.f70110f = i2;
                hVar.f70111g = multiMediaData.type;
                hVar.f70112h = pVar.f70136c;
                hVar.f70113i = pVar.f70137d;
                hVar.j = fVar;
                hVar.f70108d = j;
                hVar.f70107c = multiMediaData.rotation;
                nVar.f70127e.add(hVar);
            }
            return nVar;
        }
        return (n) invokeLL.objValue;
    }

    public static List<n> c(o oVar, f fVar) {
        InterceptResult invokeLL;
        List<h> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, oVar, fVar)) == null) {
            MultiMediaData multiMediaData = null;
            if (oVar == null || fVar == null || oVar.f70129b <= 0 || d.a.y0.t.h.e(oVar.f70132e) || d.a.y0.t.h.e(oVar.f70133f)) {
                return null;
            }
            long[] a2 = a(oVar.f70129b, oVar.f70128a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f70129b; i2++) {
                long j = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f70132e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) d.a.y0.t.h.c(oVar.f70133f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f70127e = new ArrayList();
                        nVar.f70123a = multiMediaData2.path;
                        nVar.f70125c = oVar.f70130c;
                        nVar.f70126d = oVar.f70131d;
                        nVar.f70124b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) d.a.y0.t.h.c(oVar.f70132e, findInputIndexInSegments), j) * 1000;
                    h hVar = new h();
                    hVar.f70105a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f70106b = multiMediaData2.path;
                    hVar.f70110f = i2;
                    hVar.f70111g = multiMediaData2.type;
                    hVar.f70112h = oVar.f70130c;
                    hVar.f70113i = oVar.f70131d;
                    hVar.f70108d = multiMediaDataSeekTime;
                    hVar.j = fVar;
                    hVar.f70107c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f70127e) != null) {
                        list.add(hVar);
                    }
                    multiMediaData = multiMediaData2;
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
