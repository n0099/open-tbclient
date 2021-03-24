package d.b.h0.f0.r;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import d.b.h0.f0.b;
/* loaded from: classes3.dex */
public class a implements b<ShareEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.f0.b
    /* renamed from: a */
    public boolean onEvent(ShareEvent shareEvent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true) && shareEvent.status == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921406, shareEvent));
            String str = shareEvent.tid;
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921417, str));
                return true;
            }
        }
        return false;
    }
}
