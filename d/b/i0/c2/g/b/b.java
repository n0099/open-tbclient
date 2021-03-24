package d.b.i0.c2.g.b;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.squareup.wire.Wire;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcPbPageResIdl;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        ExcPbPageResIdl excPbPageResIdl;
        DataRes dataRes;
        a aVar = null;
        if (customMessage != null && customMessage.getCmd() == 2001314) {
            byte[] bArr = d.b.h0.r.r.a.f().d("tb.pb_normal").get(PbChosenActivity.CHOSEN_PB_TABLE_NAME);
            if (bArr != null) {
                try {
                    excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
                } catch (Exception unused) {
                    excPbPageResIdl = null;
                }
                if (excPbPageResIdl != null && (dataRes = excPbPageResIdl.data) != null) {
                    aVar = new a(dataRes.user_info, dataRes.thread_info, dataRes.post_list, dataRes.user_list);
                }
            }
            return new ReadChosenPbCacheResponse(aVar);
        }
        return null;
    }
}
