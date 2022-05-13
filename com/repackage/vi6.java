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
public class vi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public List<ro> d;
    public boolean e;
    public int f;

    public vi6() {
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

    public int a(List<ro> list) {
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
                ro roVar = list.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.d.size()) {
                        z = false;
                        break;
                    }
                    ro roVar2 = this.d.get(i2);
                    if (roVar != null && (roVar instanceof ui6) && roVar2 != null && (roVar2 instanceof ui6)) {
                        ThreadData threadData = ((ui6) roVar).getThreadData();
                        ThreadData threadData2 = ((ui6) roVar2).getThreadData();
                        if (threadData != null && threadData2 != null && threadData.getTid() != null && threadData2.getTid() != null && threadData.getTid().equals(threadData2.getTid())) {
                            z = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (!z) {
                    ListUtils.add(linkedList2, roVar);
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
