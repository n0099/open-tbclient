package d.a.s0.h3.l0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, List<b>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public c addObserver(String str, c cVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, str, cVar, z)) == null) {
            if (cVar == null) {
                cVar = new c();
            }
            if (this.mNotificationNameList.contains(str)) {
                cVar.k(false);
                cVar.p(true);
                List<b> list = this.mAsyncCallBackMethodList.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                }
                b bVar = new b();
                bVar.d(cVar.c());
                bVar.c(z);
                list.add(bVar);
                this.mAsyncCallBackMethodList.put(str, list);
            }
            return cVar;
        }
        return (c) invokeLLZ.objValue;
    }

    public abstract c dispatch(e eVar, c cVar);

    public abstract List<c> processNotification(String str, HashMap hashMap);
}
