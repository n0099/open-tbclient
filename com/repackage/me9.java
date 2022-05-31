package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes6.dex */
public class me9 implements PidLoaderCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public me9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fun.ad.sdk.internal.api.PidLoaderCreator
    public PidLoader create(Ssp.Pid pid) {
        InterceptResult invokeL;
        char c;
        PidLoader gf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            String str = pid.type;
            str.hashCode();
            switch (str.hashCode()) {
                case -1900686778:
                    if (str.equals(FunAdType.JY_NATIVE)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1743934314:
                    if (str.equals(FunAdType.JY_SPLASH)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1659486968:
                    if (str.equals(FunAdType.JY_DRAW_VIDEO)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -39027267:
                    if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1872382491:
                    if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                gf9Var = new gf9(pid);
            } else if (c == 1) {
                gf9Var = new jf9(pid);
            } else if (c == 2) {
                gf9Var = new df9(pid);
            } else if (c == 3) {
                gf9Var = new if9(pid);
            } else if (c != 4) {
                return null;
            } else {
                gf9Var = new ff9(pid);
            }
            return gf9Var;
        }
        return (PidLoader) invokeL.objValue;
    }
}
