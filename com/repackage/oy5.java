package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes6.dex */
public class oy5 extends b75<tinfo, v65, a75<tinfo, v65>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oy5(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, clsArr, iArr, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class[]) objArr2[1], (int[]) objArr2[2], (ViewEventCenter) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.b75
    public int n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            tinfo item = getItem(i);
            if (item == null) {
                return -1;
            }
            List<Pic> list = item.pics;
            if (list != null) {
                int size = list.size();
                if (size >= 3) {
                    return 0;
                }
                if (size > 0 && size < 3) {
                    return 2;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public void o(long j) {
        List<tinfo> d;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0 || (d = d()) == null || d.size() <= 0) {
            return;
        }
        tinfo tinfoVar = null;
        int size = d.size();
        int i = 0;
        while (true) {
            if (i < size) {
                tinfo tinfoVar2 = d.get(i);
                if (tinfoVar2 != null && (l = tinfoVar2.thread_id) != null && l.longValue() == j) {
                    tinfoVar = d.get(i);
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (tinfoVar != null) {
            h(tinfoVar);
        }
    }
}
