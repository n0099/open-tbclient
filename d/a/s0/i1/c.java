package d.a.s0.i1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d.a.r0.v0.a a(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, cls)) == null) {
            try {
                d.a.r0.v0.a aVar = new d.a.r0.v0.a(i2, cls.newInstance());
                MessageManager.getInstance().registerTask(aVar);
                return aVar;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (d.a.r0.v0.a) invokeIL.objValue;
    }

    public static d.a.r0.v0.b b(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) {
            d.a.r0.v0.b bVar = new d.a.r0.v0.b(i2);
            bVar.setResponsedClass(cls);
            bVar.h(z);
            bVar.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(bVar);
            return bVar;
        }
        return (d.a.r0.v0.b) invokeCommon.objValue;
    }
}
