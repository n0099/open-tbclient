package d.a.n0.h2;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f55509b;

    /* renamed from: a  reason: collision with root package name */
    public Context f55510a;

    public b(Context context) {
        this.f55510a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        if (f55509b == null) {
            synchronized (b.class) {
                if (f55509b == null) {
                    f55509b = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return f55509b;
    }

    public void b() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f55510a, 0);
        feedbackInputIntent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.f55510a.startActivity(feedbackInputIntent);
    }
}
