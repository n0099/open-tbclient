package d.b.i0.p1.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.service.ext.ExtLiveJumpPageService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
/* loaded from: classes3.dex */
public class b implements ExtLiveJumpPageService {
    @Override // com.baidu.searchbox.live.interfaces.service.ext.ExtLiveJumpPageService
    public void goToLiveShowPlayBack(Context context, String str, String str2) {
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ext.ExtLiveJumpPageService
    public void goToPersonCenter(Context context, String str) {
        if (context == null || StringUtils.isNull(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(context).createNormalConfig(d.b.b.e.m.b.f(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
    }
}
