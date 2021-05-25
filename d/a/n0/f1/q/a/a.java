package d.a.n0.f1.q.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import d.a.c.e.d.l;
import tbclient.Bigvip.BigvipResIdl;
import tbclient.Bigvip.UserInfoBigVip;
/* loaded from: classes4.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        UserInfoBigVip userInfoBigVip = null;
        if (customMessage != null && (customMessage.getData() instanceof Long)) {
            long longValue = ((Long) customMessage.getData()).longValue();
            l<byte[]> d2 = d.a.m0.r.r.a.f().d("tb.im_recommend_detail");
            if (d2 == null) {
                return new CustomResponsedMessage<>(2001306, null);
            }
            byte[] bArr = d2.get(longValue + "");
            if (bArr == null) {
                return new CustomResponsedMessage<>(2001306, null);
            }
            try {
                userInfoBigVip = ((BigvipResIdl) new Wire(new Class[0]).parseFrom(bArr, BigvipResIdl.class)).data.user_info;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return new CustomResponsedMessage<>(2001306, userInfoBigVip);
        }
        return new CustomResponsedMessage<>(2001306, null);
    }
}
