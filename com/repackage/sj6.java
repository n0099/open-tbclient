package com.repackage;

import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class sj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public List<uo> d;
    public boolean e;
    public int f;

    public sj6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int a(List<uo> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return 0;
            }
            if (ListUtils.isEmpty(this.d)) {
                LinkedList linkedList = new LinkedList();
                this.d = linkedList;
                linkedList.addAll(list);
                return list.size();
            }
            LinkedList linkedList2 = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                uo uoVar = list.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.d.size()) {
                        z = false;
                        break;
                    }
                    uo uoVar2 = this.d.get(i2);
                    if (uoVar != null && (uoVar instanceof rj6) && uoVar2 != null && (uoVar2 instanceof rj6)) {
                        ThreadData threadData = ((rj6) uoVar).getThreadData();
                        ThreadData threadData2 = ((rj6) uoVar2).getThreadData();
                        if (threadData != null && threadData2 != null && threadData.getTid() != null && threadData2.getTid() != null && threadData.getTid().equals(threadData2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    ListUtils.add(linkedList2, uoVar);
                }
            }
            if (linkedList2.size() != 0) {
                ListUtils.addAll(this.d, 0, linkedList2);
            }
            return linkedList2.size();
        }
        return invokeL.intValue;
    }
}
