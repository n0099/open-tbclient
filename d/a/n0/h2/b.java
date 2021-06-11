package d.a.n0.h2;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f59198b;

    /* renamed from: a  reason: collision with root package name */
    public Context f59199a;

    public b(Context context) {
        this.f59199a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        if (f59198b == null) {
            synchronized (b.class) {
                if (f59198b == null) {
                    f59198b = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return f59198b;
    }

    public void b() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f59199a, 0);
        feedbackInputIntent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.f59199a.startActivity(feedbackInputIntent);
    }
}
