package d.a.n0.s.a;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Domain f54184a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f54185b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f54186c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f54185b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f54185b = false;
            } else {
                f54185b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f54185b = false;
        } else {
            f54185b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f54185b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f54185b = true;
    }

    public static b b() {
        return f54186c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f54186c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f54186c = (b) runTask.getData();
    }
}
