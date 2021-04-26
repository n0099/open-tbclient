package d.a.i0.g0.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import d.a.c.e.d.l;
import d.a.i0.g0.b.c;
import d.a.i0.g0.b.e;
/* loaded from: classes3.dex */
public class d<T extends d.a.i0.g0.b.c> extends a<T> {
    public d(int i2, String str, Class<T> cls) {
        super(i2, str, cls);
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        String f2;
        if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
            return null;
        }
        WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.f48533e);
        WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        d.a.i0.g0.b.c cVar = (d.a.i0.g0.b.c) a();
        if (cVar != null) {
            if (cVar instanceof d.a.i0.g0.b.b) {
                l<byte[]> e2 = d.a.i0.r.r.a.f().e(this.f48531f, currentAccount);
                if (writeCacheMessage.isClear()) {
                    d.a.i0.g0.b.c cVar2 = (d.a.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar2 == null) {
                        BdCacheService.l().k(e2);
                    } else {
                        e2.remove(cVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    d.a.i0.g0.b.c cVar3 = (d.a.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    e2.g(cVar3.getCacheKey(), ((d.a.i0.g0.b.b) cVar3).toCacheByteArray());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (cVar instanceof e) {
                l<String> h2 = d.a.i0.r.r.a.f().h(this.f48531f, currentAccount);
                if (writeCacheMessage.isClear()) {
                    d.a.i0.g0.b.c cVar4 = (d.a.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar4 == null) {
                        BdCacheService.l().k(h2);
                    } else {
                        h2.remove(cVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    d.a.i0.g0.b.c cVar5 = (d.a.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar5 != null && (f2 = ((e) cVar5).f()) != null) {
                        h2.g(cVar5.getCacheKey(), f2);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
