package d.b.j0.g3;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tieba.R;
import d.b.i0.r.g;
import d.b.i0.r.q.j1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56757a;

    public e(TbPageContext tbPageContext) {
        this.f56757a = tbPageContext;
        MessageManager.getInstance().registerStickyMode(2921453);
    }

    public void a(Intent intent, d dVar) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(MainTabActivityConfig.PUSH_DES_PAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            String string = this.f56757a.getString(R.string.des_page_home_recommend);
            j1 j1Var = new j1();
            Matcher matcher = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)").matcher(intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME));
            int i = 1;
            if (matcher.find()) {
                j1Var.f51568c = matcher.group(1);
            }
            if (stringExtra.equals(string)) {
                j1Var.f51566a = 1;
            } else {
                j1Var.f51566a = 2;
                j1Var.f51567b = stringExtra;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921453, j1Var));
            if (stringExtra.equals(string)) {
                intent.putExtra("sub_locate_type", 1);
                i = 2;
            } else {
                intent.putExtra("sub_locate_type", stringExtra);
            }
            if (dVar != null && dVar.C() != null) {
                dVar.C().setCurrentTabByType(i);
                FragmentTabHost.b g2 = dVar.C().g(i);
                if (g2 != null) {
                    Fragment fragment = g2.f12982c;
                    if (fragment instanceof g) {
                        ((g) fragment).o0(intent);
                    }
                }
            }
        }
        intent.removeExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION);
        intent.removeExtra(MainTabActivityConfig.PUSH_DES_PAGE);
    }

    public boolean b(Intent intent) {
        return intent.getIntExtra(MainTabActivityConfig.PUSH_FOLLOW_UP_ACTION, 0) == 1;
    }
}
