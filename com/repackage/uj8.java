package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uj8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int c = 524288;
    public static int d = 6144000;
    public static int e = 524288;
    public transient /* synthetic */ FieldHolder $fh;
    public yj8 a;
    public kl7 b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755258930, "Lcom/repackage/uj8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755258930, "Lcom/repackage/uj8;");
        }
    }

    public uj8(kl7 kl7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kl7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = kl7Var;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (i <= 0) {
                d = 6144000;
            } else {
                d = i;
            }
        }
    }

    public static void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i) == null) {
            if (i <= 0) {
                c = 524288;
            } else {
                c = i;
            }
        }
    }

    public static void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) {
            if (i <= 0) {
                e = 524288;
            } else {
                e = i;
            }
        }
    }

    public void a() {
        yj8 yj8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (yj8Var = this.a) == null) {
            return;
        }
        yj8Var.cancel();
    }

    public VideoFinishResult e(String str, String str2, int i, bk8 bk8Var) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i, bk8Var)) == null) {
            try {
                if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                    this.a = new ak8(str2, e, this.b);
                } else {
                    this.a = new zj8(str, c, d, this.b);
                }
                this.a.a(bk8Var);
                return this.a.b(str2, i);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                kl7 kl7Var = this.b;
                if (kl7Var != null) {
                    kl7Var.f(306, -4399, el7.a(e2));
                    return null;
                }
                return null;
            }
        }
        return (VideoFinishResult) invokeLLIL.objValue;
    }
}
