package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes7.dex */
public class rh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static th9 a(Context context, Ssp.Pid pid) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, pid)) == null) {
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                return null;
                            }
                            return new ai9(context.getApplicationContext(), pid.pid);
                        }
                        return new ci9(context.getApplicationContext(), pid.pid);
                    }
                    return new zh9(context.getApplicationContext(), pid.pid);
                }
                return new di9(context.getApplicationContext(), pid.pid);
            }
            return new bi9(context.getApplicationContext(), pid.pid);
        }
        return (th9) invokeLL.objValue;
    }
}
