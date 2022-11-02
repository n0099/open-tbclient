package tv.athena.revenue.payui.model;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Keep
/* loaded from: classes9.dex */
public final class PayScene {
    public static final /* synthetic */ PayScene[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayScene DIALOG_PAY_SCENE;
    public static final PayScene DIALOG_QUICK_PAY;
    public static final PayScene DIALOG_TARGET_PAY;
    public transient /* synthetic */ FieldHolder $fh;
    public final int sceneId;
    public final String sceneName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1018430816, "Ltv/athena/revenue/payui/model/PayScene;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1018430816, "Ltv/athena/revenue/payui/model/PayScene;");
                return;
            }
        }
        DIALOG_PAY_SCENE = new PayScene("DIALOG_PAY_SCENE", 0, 1, "半窗默认支付场景");
        DIALOG_QUICK_PAY = new PayScene("DIALOG_QUICK_PAY", 1, 2, "半窗快捷支付场景");
        PayScene payScene = new PayScene("DIALOG_TARGET_PAY", 2, 3, "半窗设置目标金额支付");
        DIALOG_TARGET_PAY = payScene;
        $VALUES = new PayScene[]{DIALOG_PAY_SCENE, DIALOG_QUICK_PAY, payScene};
    }

    public PayScene(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.sceneId = i2;
        this.sceneName = str2;
    }

    public static PayScene valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PayScene) Enum.valueOf(PayScene.class, str);
        }
        return (PayScene) invokeL.objValue;
    }

    public static PayScene[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PayScene[]) $VALUES.clone();
        }
        return (PayScene[]) invokeV.objValue;
    }
}
