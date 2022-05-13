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
import com.repackage.a75;
/* loaded from: classes6.dex */
public class p75<T extends a75> extends m75<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p75(int i, String str, Class<T> cls) {
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
        String j;
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
            a75 a75Var = (a75) a();
            if (a75Var != null) {
                if (a75Var instanceof z65) {
                    mr4.f();
                    qe<byte[]> e = mr4.e(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        a75 a75Var2 = (a75) writeCacheMessage.getData();
                        if (a75Var2 == null) {
                            BdCacheService.k().j(e);
                        } else {
                            e.remove(a75Var2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        a75 a75Var3 = (a75) writeCacheMessage.getData();
                        if (a75Var3 == null) {
                            return writeCacheRespMsg;
                        }
                        e.g(a75Var3.getCacheKey(), ((z65) a75Var3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (a75Var instanceof c75) {
                    mr4.f();
                    qe<String> h = mr4.h(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        a75 a75Var4 = (a75) writeCacheMessage.getData();
                        if (a75Var4 == null) {
                            BdCacheService.k().j(h);
                        } else {
                            h.remove(a75Var4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        a75 a75Var5 = (a75) writeCacheMessage.getData();
                        if (a75Var5 != null && (j = ((c75) a75Var5).j()) != null) {
                            h.g(a75Var5.getCacheKey(), j);
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
