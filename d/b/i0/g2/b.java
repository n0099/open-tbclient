package d.b.i0.g2;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f56209b;

    /* renamed from: a  reason: collision with root package name */
    public Context f56210a;

    public b(Context context) {
        this.f56210a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        if (f56209b == null) {
            synchronized (b.class) {
                if (f56209b == null) {
                    f56209b = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return f56209b;
    }

    public void b() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f56210a, 0);
        feedbackInputIntent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        this.f56210a.startActivity(feedbackInputIntent);
    }
}
