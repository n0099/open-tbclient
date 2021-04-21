package d.b.i0.g0.e;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import d.b.c.e.d.l;
import d.b.i0.g0.b.c;
import d.b.i0.g0.b.e;
/* loaded from: classes3.dex */
public class d<T extends d.b.i0.g0.b.c> extends a<T> {
    public d(int i, String str, Class<T> cls) {
        super(i, str, cls);
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<T> customMessage) {
        String l;
        if (customMessage == null || !(customMessage instanceof WriteCacheMessage)) {
            return null;
        }
        WriteCacheRespMsg writeCacheRespMsg = new WriteCacheRespMsg(this.f50954e);
        WriteCacheMessage writeCacheMessage = (WriteCacheMessage) customMessage;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null) {
            currentAccount = "";
        }
        d.b.i0.g0.b.c cVar = (d.b.i0.g0.b.c) a();
        if (cVar != null) {
            if (cVar instanceof d.b.i0.g0.b.b) {
                l<byte[]> e2 = d.b.i0.r.r.a.f().e(this.f50952f, currentAccount);
                if (writeCacheMessage.isClear()) {
                    d.b.i0.g0.b.c cVar2 = (d.b.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar2 == null) {
                        BdCacheService.l().k(e2);
                    } else {
                        e2.remove(cVar2.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    d.b.i0.g0.b.c cVar3 = (d.b.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar3 == null) {
                        return writeCacheRespMsg;
                    }
                    e2.g(cVar3.getCacheKey(), ((d.b.i0.g0.b.b) cVar3).toCacheByteArray());
                    writeCacheRespMsg.setSuccess(true);
                }
            } else if (cVar instanceof e) {
                l<String> h2 = d.b.i0.r.r.a.f().h(this.f50952f, currentAccount);
                if (writeCacheMessage.isClear()) {
                    d.b.i0.g0.b.c cVar4 = (d.b.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar4 == null) {
                        BdCacheService.l().k(h2);
                    } else {
                        h2.remove(cVar4.getCacheKey());
                    }
                    writeCacheRespMsg.setSuccess(true);
                } else {
                    d.b.i0.g0.b.c cVar5 = (d.b.i0.g0.b.c) writeCacheMessage.getData();
                    if (cVar5 != null && (l = ((e) cVar5).l()) != null) {
                        h2.g(cVar5.getCacheKey(), l);
                        writeCacheRespMsg.setSuccess(true);
                    }
                }
            }
        }
        return writeCacheRespMsg;
    }
}
