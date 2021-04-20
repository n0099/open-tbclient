package d.b.h0.f0.t;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import d.b.h0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<ShowReplyInPbEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.f0.b
    /* renamed from: a */
    public boolean onEvent(ShowReplyInPbEvent showReplyInPbEvent) {
        if (showReplyInPbEvent == null) {
            return false;
        }
        if (showReplyInPbEvent.isSubPbReply) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921481, showReplyInPbEvent.writeData));
            return true;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921480, showReplyInPbEvent.writeData));
        return true;
    }
}
