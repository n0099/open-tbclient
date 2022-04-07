package com.yy.hiidostatis.defs.obj;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class EventInfo extends Info<EventElementInfo> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2909020670205500872L;
    public transient /* synthetic */ FieldHolder $fh;

    public EventInfo() {
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

    private long parseAsInt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                L.debug(this, "Failed to parse %s as number", str);
                return 1L;
            }
        }
        return invokeL.longValue;
    }

    public int getRealElemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Iterator<EventElementInfo> it = iterator();
            int i = 0;
            while (it.hasNext()) {
                EventElementInfo next = it.next();
                i = next.ctype == 1 ? (int) (i + parseAsInt(next.cvalue)) : i + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }
}
