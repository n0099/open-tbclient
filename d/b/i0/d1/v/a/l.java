package d.b.i0.d1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
/* loaded from: classes4.dex */
public class l implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestOfficialBarMenuLocalMessage)) {
            return null;
        }
        String forum_id = ((RequestOfficialBarMenuLocalMessage) customMessage).getForum_id();
        byte[] bArr = d.b.h0.r.r.a.f().d("tb.official_bar_menu").get(ResponseOfficialBarMenuMessage.OFFICIAL_BAR_MENU_KEY_PRE + forum_id);
        ResponseOfficialBarMenuLocalMessage responseOfficialBarMenuLocalMessage = new ResponseOfficialBarMenuLocalMessage();
        try {
            responseOfficialBarMenuLocalMessage.decodeInBackGround(2001177, bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return responseOfficialBarMenuLocalMessage;
    }
}
