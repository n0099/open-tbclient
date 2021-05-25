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
    public static Domain f50401a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f50402b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f50403c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f50402b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f50402b = false;
            } else {
                f50402b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f50402b = false;
        } else {
            f50402b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f50402b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f50402b = true;
    }

    public static b b() {
        return f50403c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f50403c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f50403c = (b) runTask.getData();
    }
}
