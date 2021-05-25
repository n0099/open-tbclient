package d.a.n0.r0.n2;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.FrsFragment;
/* loaded from: classes4.dex */
public class j {
    public static boolean a(FrsFragment frsFragment, String str, String str2, boolean z) {
        if (z && frsFragment != null && !TextUtils.isEmpty(str) && frsFragment.isAdded() && m.i(TbadkCoreApplication.getInst().getApplicationContext(), frsFragment.getActivity().getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra(DealIntentService.KEY_CLASS, 2);
            intent.putExtra("fname", str);
            intent.putExtra(str2, "short_cut");
            frsFragment.sendMessage(new CustomMessage(2002001, new LogoActivityConfig(frsFragment.getPageContext().getPageActivity(), intent)));
            return false;
        }
        return true;
    }
}
