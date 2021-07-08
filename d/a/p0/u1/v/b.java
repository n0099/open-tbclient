package d.a.p0.u1.v;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.searchbox.live.interfaces.toast.ToastClickListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes8.dex */
public class b implements ToastService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showClickableToast(Context context, String str, String str2, int i2, ToastClickListener toastClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i2), toastClickListener}) == null) {
            l.M(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showNormal(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, i2) == null) {
            l.M(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.ToastService
    public void showToastBottom(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, i2) == null) {
            l.M(TbadkCoreApplication.getInst(), str);
        }
    }
}
