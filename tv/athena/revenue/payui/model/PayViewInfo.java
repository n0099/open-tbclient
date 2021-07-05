package tv.athena.revenue.payui.model;

import android.app.Dialog;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
@Keep
/* loaded from: classes10.dex */
public class PayViewInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CancelType clickArea;
    public PayDialogType payDialogType;
    public Dialog viewDialog;

    public PayViewInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
