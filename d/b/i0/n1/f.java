package d.b.i0.n1;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.mainentrance.RequestSearchPersonHistoryWriteMessage;
import com.baidu.tieba.mainentrance.ResponseSearchPersonHistoryWriteMessage;
import d.b.b.e.d.l;
/* loaded from: classes3.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage != null && (customMessage instanceof RequestSearchPersonHistoryWriteMessage)) {
            RequestSearchPersonHistoryWriteMessage requestSearchPersonHistoryWriteMessage = (RequestSearchPersonHistoryWriteMessage) customMessage;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null) {
                currentAccount = "";
            }
            l<String> h2 = d.b.h0.r.r.a.f().h("tb.searchperson_history", currentAccount);
            if (requestSearchPersonHistoryWriteMessage.isClear()) {
                BdCacheService.l().k(h2);
            } else {
                Object data = requestSearchPersonHistoryWriteMessage.getData();
                if (data != null && (data instanceof String)) {
                    h2.g((String) data, null);
                }
            }
            return new ResponseSearchPersonHistoryWriteMessage();
        }
        return null;
    }
}
