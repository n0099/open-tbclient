package tv.athena.revenue.payui.model;

import android.app.Dialog;
import androidx.annotation.Keep;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
@Keep
/* loaded from: classes2.dex */
public class PayViewInfo {
    public CancelType clickArea;
    public PayDialogType payDialogType;
    public Dialog viewDialog;

    public String toString() {
        return "PayViewInfo {payDialogType=" + this.payDialogType + ", clickArea=" + this.clickArea + ", viewDialog=" + this.viewDialog + '}';
    }
}
