package d.b.i0.f2;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f54738b;

    /* renamed from: a  reason: collision with root package name */
    public Context f54739a;

    public b(Context context) {
        this.f54739a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        if (f54738b == null) {
            synchronized (b.class) {
                if (f54738b == null) {
                    f54738b = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return f54738b;
    }

    public void b() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f54739a, 0);
        feedbackInputIntent.addFlags(268435456);
        this.f54739a.startActivity(feedbackInputIntent);
    }
}
