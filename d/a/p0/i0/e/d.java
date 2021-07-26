package d.a.p0.i0.e;

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
import d.a.d.e.d.l;
import d.a.p0.i0.b.c;
import d.a.p0.i0.b.e;
/* loaded from: classes7.dex */
public class d<T extends d.a.p0.i0.b.c> extends a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str, Class<T> cls) {
        super(i2, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        String i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
                return null;
            }
            WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.f52683e);
            WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            d.a.p0.i0.b.c cVar = (d.a.p0.i0.b.c) a();
            if (cVar != null) {
                if (cVar instanceof d.a.p0.i0.b.b) {
                    l<byte[]> e2 = d.a.p0.s.r.a.f().e(this.f52681f, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        d.a.p0.i0.b.c cVar2 = (d.a.p0.i0.b.c) writeCacheMessage.getData();
                        if (cVar2 == null) {
                            BdCacheService.l().k(e2);
                        } else {
                            e2.remove(cVar2.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        d.a.p0.i0.b.c cVar3 = (d.a.p0.i0.b.c) writeCacheMessage.getData();
                        if (cVar3 == null) {
                            return writeCacheRespMsg;
                        }
                        e2.g(cVar3.getCacheKey(), ((d.a.p0.i0.b.b) cVar3).toCacheByteArray());
                        writeCacheRespMsg.setSuccess(true);
                    }
                } else if (cVar instanceof e) {
                    l<String> h2 = d.a.p0.s.r.a.f().h(this.f52681f, currentAccount);
                    if (writeCacheMessage.isClear()) {
                        d.a.p0.i0.b.c cVar4 = (d.a.p0.i0.b.c) writeCacheMessage.getData();
                        if (cVar4 == null) {
                            BdCacheService.l().k(h2);
                        } else {
                            h2.remove(cVar4.getCacheKey());
                        }
                        writeCacheRespMsg.setSuccess(true);
                    } else {
                        d.a.p0.i0.b.c cVar5 = (d.a.p0.i0.b.c) writeCacheMessage.getData();
                        if (cVar5 != null && (i2 = ((e) cVar5).i()) != null) {
                            h2.g(cVar5.getCacheKey(), i2);
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
