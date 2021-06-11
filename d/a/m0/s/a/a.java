package d.a.m0.s.a;

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
    public static Domain f54077a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f54078b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f54079c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f54078b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f54078b = false;
            } else {
                f54078b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f54078b = false;
        } else {
            f54078b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f54078b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f54078b = true;
    }

    public static b b() {
        return f54079c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f54079c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f54079c = (b) runTask.getData();
    }
}
