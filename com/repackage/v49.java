package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubs.analytics.SampleResult;
/* loaded from: classes7.dex */
public final class v49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SampleResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str != null && !str.equals("")) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 79) {
                    switch (hashCode) {
                        case 2126:
                            if (str.equals("C1")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 2127:
                            if (str.equals("C2")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 2128:
                            if (str.equals("C3")) {
                                c = 7;
                                break;
                            }
                            break;
                        default:
                            switch (hashCode) {
                                case 2653:
                                    if (str.equals("T1")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 2654:
                                    if (str.equals("T2")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 2655:
                                    if (str.equals("T3")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 2656:
                                    if (str.equals("T4")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                                case 2657:
                                    if (str.equals("T5")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                            }
                    }
                } else if (str.equals("O")) {
                    c = '\b';
                }
                switch (c) {
                    case 0:
                        return SampleResult.T1;
                    case 1:
                        return SampleResult.T2;
                    case 2:
                        return SampleResult.T3;
                    case 3:
                        return SampleResult.T4;
                    case 4:
                        return SampleResult.T5;
                    case 5:
                        return SampleResult.C1;
                    case 6:
                        return SampleResult.C2;
                    case 7:
                        return SampleResult.C3;
                    case '\b':
                        return SampleResult.OTHERE;
                    default:
                        return SampleResult.OTHERE;
                }
            }
            return SampleResult.OTHERE;
        }
        return (SampleResult) invokeL.objValue;
    }
}
