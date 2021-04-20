package d.b.h0.s.a;

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
    public static Domain f51531a = Domain.DOMAIN_ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f51532b = true;

    /* renamed from: c  reason: collision with root package name */
    public static b f51533c = null;

    public static void a() {
        if (TbConfig.USE_OLD_LOGIN) {
            f51532b = true;
            return;
        }
        if (Build.VERSION.SDK_INT < 9) {
            if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                f51532b = false;
            } else {
                f51532b = true;
            }
        } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
            f51532b = false;
        } else {
            f51532b = true;
        }
        if (Build.VERSION.SDK_INT > 10 || f51532b || !UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
            return;
        }
        TbadkCoreApplication.getInst().incPassportV6CrashCount();
        f51532b = true;
    }

    public static b b() {
        return f51533c;
    }

    public static void c() {
        CustomResponsedMessage runTask;
        if (f51533c != null || (runTask = MessageManager.getInstance().runTask(2001268, b.class)) == null || runTask.getData() == null) {
            return;
        }
        f51533c = (b) runTask.getData();
    }
}
