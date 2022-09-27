package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.h3a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, h3a h3aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, h3a h3aVar);
}
