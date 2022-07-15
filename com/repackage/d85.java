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
import com.repackage.p75;
/* loaded from: classes5.dex */
public class d85<T extends p75> extends a85<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d85(int i, String str, Class<T> cls) {
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
            p75 p75Var = (p75) a();
            if (p75Var != null) {
                if (p75Var instanceof o75) {
                    br4.f();
                    te<byte[]> e = br4.e(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        p75 p75Var2 = (p75) writeCacheMessage.getData();
                        if (p75Var2 == null) {
                            BdCacheService.k().j(e);
                        } else {
                            e.remove(p75Var2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        p75 p75Var3 = (p75) writeCacheMessage.getData();
                        if (p75Var3 == null) {
                            return writeCacheRespMsg;
                        }
                        e.g(p75Var3.getCacheKey(), ((o75) p75Var3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (p75Var instanceof r75) {
                    br4.f();
                    te<String> h = br4.h(this.b, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        p75 p75Var4 = (p75) writeCacheMessage.getData();
                        if (p75Var4 == null) {
                            BdCacheService.k().j(h);
                        } else {
                            h.remove(p75Var4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        p75 p75Var5 = (p75) writeCacheMessage.getData();
                        if (p75Var5 != null && (l = ((r75) p75Var5).l()) != null) {
                            h.g(p75Var5.getCacheKey(), l);
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
