package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
@Keep
/* loaded from: classes2.dex */
public enum PayScene {
    DIALOG_PAY_SCENE(1, "半窗默认支付场景"),
    DIALOG_QUICK_PAY(2, "半窗快捷支付场景"),
    DIALOG_TARGET_PAY(3, "半窗设置目标金额支付");
    
    public final int sceneId;
    public final String sceneName;

    PayScene(int i, String str) {
        this.sceneId = i;
        this.sceneName = str;
    }
}
