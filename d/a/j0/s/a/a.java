package d.a.j0.s.a;

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
    public static Domain f50337a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50338b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f50339c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f50338b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f50338b = false;
            } else {
                f50338b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f50338b = false;
        } else {
            f50338b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f50338b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f50338b = true;
    }

    public static b b() {
        return f50339c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f50339c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f50339c = (b) runTask.getData();
    }
}
