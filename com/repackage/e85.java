package com.repackage;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.q75;
/* loaded from: classes6.dex */
public class e85<T extends q75> extends b85<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e85(int i, String str, Class<T> cls) {
        super(i, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        InterceptResult invokeL;
        String l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
                return null;
            }
            WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.a);
            WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            q75 q75Var = (q75) a();
            if (q75Var != null) {
                if (q75Var instanceof p75) {
                    cr4.f();
                    te<byte[]> e = cr4.e(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        q75 q75Var2 = (q75) writeCacheMessage.getData();
                        if (q75Var2 == null) {
                            BdCacheService.k().j(e);
                        } else {
                            e.remove(q75Var2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        q75 q75Var3 = (q75) writeCacheMessage.getData();
                        if (q75Var3 == null) {
                            return writeCacheRespMsg;
                        }
                        e.g(q75Var3.getCacheKey(), ((p75) q75Var3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (q75Var instanceof s75) {
                    cr4.f();
                    te<String> h = cr4.h(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        q75 q75Var4 = (q75) writeCacheMessage.getData();
                        if (q75Var4 == null) {
                            BdCacheService.k().j(h);
                        } else {
                            h.remove(q75Var4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        q75 q75Var5 = (q75) writeCacheMessage.getData();
                        if (q75Var5 != null && (l = ((s75) q75Var5).l()) != null) {
                            h.g(q75Var5.getCacheKey(), l);
                            writeCacheRespMsg.setSuccess(true);
                        }
                    }
                }
            }
            return writeCacheRespMsg;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
