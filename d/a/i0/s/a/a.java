package d.a.i0.s.a;

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
    public static Domain f49518a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f49519b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f49520c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f49519b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f49519b = false;
            } else {
                f49519b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f49519b = false;
        } else {
            f49519b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f49519b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f49519b = true;
    }

    public static b b() {
        return f49520c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f49520c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f49520c = (b) runTask.getData();
    }
}
