package d.a.s0.k2;

import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static b f62597b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f62598a;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62598a = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f62597b == null) {
                synchronized (b.class) {
                    if (f62597b == null) {
                        f62597b = new b(TbadkCoreApplication.getInst());
                    }
                }
            }
            return f62597b;
        }
        return (b) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                TbadkCoreApplication.getInst();
                UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
            }
            UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
            UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
            Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.f62598a, 0);
            feedbackInputIntent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            this.f62598a.startActivity(feedbackInputIntent);
        }
    }
}
