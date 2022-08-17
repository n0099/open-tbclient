package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.repackage.r0a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, r0a r0aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, r0a r0aVar);
}
