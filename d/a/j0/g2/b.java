package d.a.j0.g2;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f54528b;

    /* renamed from: a  reason: collision with root package name */
    public Context f54529a;

    public b(Context context) {
        this.f54529a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        if (f54528b == null) {
            synchronized (b.class) {
                if (f54528b == null) {
                    f54528b = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return f54528b;
    }

    public void b() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f54529a, 0);
        feedbackInputIntent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.f54529a.startActivity(feedbackInputIntent);
    }
}
