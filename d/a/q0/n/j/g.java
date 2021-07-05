package d.a.q0.n.j;

import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d a(Node node) {
        InterceptResult invokeL;
        Class<? extends d> processor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, node)) == null) {
            if (node == null || (processor = node.getProcessor()) == null) {
                return null;
            }
            try {
                return processor.newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (d) invokeL.objValue;
    }
}
