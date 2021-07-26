package d.a.q0.e1.g.h;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import tbclient.MoreTreasureTrove.DataRes;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                b2 b2Var = new b2();
                b2Var.K2(threadInfo);
                b2Var.d2 = true;
                arrayList.add(b2Var);
            }
            return d.a.q0.e1.f.a.c.a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(MoreTreasureTroveResIdl moreTreasureTroveResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, moreTreasureTroveResIdl)) == null) {
            if (moreTreasureTroveResIdl == null || (dataRes = moreTreasureTroveResIdl.data) == null || ListUtils.isEmpty(dataRes.hot_thread_info)) {
                return null;
            }
            return a(moreTreasureTroveResIdl.data.hot_thread_info);
        }
        return (List) invokeL.objValue;
    }
}
