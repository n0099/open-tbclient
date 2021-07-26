package d.a.q0.z3.m.c.d;

import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
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
            if (pVar == null || fVar == null || pVar.f67619e == null) {
                return null;
            }
            long[] a2 = a(pVar.f67616b, pVar.f67615a);
            MultiMediaData multiMediaData = pVar.f67619e;
            n nVar = new n();
            nVar.f67608e = new ArrayList();
            nVar.f67604a = multiMediaData.path;
            nVar.f67606c = pVar.f67617c;
            nVar.f67607d = pVar.f67618d;
            nVar.f67605b = multiMediaData.rotation;
            for (int i2 = 0; i2 < pVar.f67616b; i2++) {
                long j = multiMediaData.start + a2[i2];
                h hVar = new h();
                hVar.f67586a = a.b(multiMediaData.path, j, multiMediaData.type);
                hVar.f67587b = multiMediaData.path;
                hVar.f67591f = i2;
                hVar.f67592g = multiMediaData.type;
                hVar.f67593h = pVar.f67617c;
                hVar.f67594i = pVar.f67618d;
                hVar.j = fVar;
                hVar.f67589d = j;
                hVar.f67588c = multiMediaData.rotation;
                nVar.f67608e.add(hVar);
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
            if (oVar == null || fVar == null || oVar.f67610b <= 0 || d.a.w0.t.h.e(oVar.f67613e) || d.a.w0.t.h.e(oVar.f67614f)) {
                return null;
            }
            long[] a2 = a(oVar.f67610b, oVar.f67609a);
            ArrayList arrayList = new ArrayList();
            n nVar = null;
            for (int i2 = 0; i2 < oVar.f67610b; i2++) {
                long j = ((float) a2[i2]) / 1000.0f;
                int findInputIndexInSegments = MultiDataSourceUtil.findInputIndexInSegments(oVar.f67613e, j);
                MultiMediaData multiMediaData2 = (MultiMediaData) d.a.w0.t.h.c(oVar.f67614f, findInputIndexInSegments);
                if (multiMediaData2 != null) {
                    if (multiMediaData2 != multiMediaData) {
                        nVar = new n();
                        nVar.f67608e = new ArrayList();
                        nVar.f67604a = multiMediaData2.path;
                        nVar.f67606c = oVar.f67611c;
                        nVar.f67607d = oVar.f67612d;
                        nVar.f67605b = multiMediaData2.rotation;
                        arrayList.add(nVar);
                    }
                    long multiMediaDataSeekTime = MultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData2, (MediaSegment) d.a.w0.t.h.c(oVar.f67613e, findInputIndexInSegments), j) * 1000;
                    h hVar = new h();
                    hVar.f67586a = a.b(multiMediaData2.path, multiMediaDataSeekTime, multiMediaData2.type);
                    hVar.f67587b = multiMediaData2.path;
                    hVar.f67591f = i2;
                    hVar.f67592g = multiMediaData2.type;
                    hVar.f67593h = oVar.f67611c;
                    hVar.f67594i = oVar.f67612d;
                    hVar.f67589d = multiMediaDataSeekTime;
                    hVar.j = fVar;
                    hVar.f67588c = multiMediaData2.rotation;
                    if (nVar != null && (list = nVar.f67608e) != null) {
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
