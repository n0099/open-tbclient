package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.repackage.p0a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, p0a p0aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, p0a p0aVar);
}
