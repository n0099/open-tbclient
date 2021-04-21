package d.b.i0.s.a;

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
    public static Domain f51867a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f51868b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f51869c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f51868b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f51868b = false;
            } else {
                f51868b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f51868b = false;
        } else {
            f51868b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f51868b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f51868b = true;
    }

    public static b b() {
        return f51869c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f51869c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f51869c = (b) runTask.getData();
    }
}
