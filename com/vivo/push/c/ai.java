package com.vivo.push.c;

import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class ai {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ai() {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.vivo.push.v a(com.vivo.push.y yVar) {
        InterceptResult invokeL;
        com.vivo.push.v ahVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yVar)) == null) {
            int b2 = yVar.b();
            if (b2 == 20) {
                ahVar = new ah(yVar);
            } else if (b2 == 100) {
                ahVar = new b(yVar);
            } else if (b2 != 101) {
                switch (b2) {
                    case 0:
                        ahVar = new aj(yVar);
                        break;
                    case 1:
                        ahVar = new ac(yVar);
                        break;
                    case 2:
                        ahVar = new h(yVar);
                        break;
                    case 3:
                        ahVar = new p(yVar);
                        break;
                    case 4:
                        ahVar = new r(yVar);
                        break;
                    case 5:
                        ahVar = new t(yVar);
                        break;
                    case 6:
                        ahVar = new z(yVar);
                        break;
                    case 7:
                        ahVar = new n(yVar);
                        break;
                    case 8:
                        ahVar = new l(yVar);
                        break;
                    case 9:
                        ahVar = new g(yVar);
                        break;
                    case 10:
                        ahVar = new d(yVar);
                        break;
                    case 11:
                        ahVar = new af(yVar);
                        break;
                    case 12:
                        ahVar = new f(yVar);
                        break;
                    default:
                        switch (b2) {
                            case 2000:
                            case 2001:
                            case 2002:
                            case 2003:
                            case 2004:
                            case 2005:
                            case 2008:
                            case 2009:
                            case 2010:
                            case 2011:
                            case 2012:
                            case 2013:
                            case 2014:
                            case SpeedStatsStampTable.INIT_VERSION_STAMP_KEY /* 2015 */:
                                break;
                            case 2006:
                                ahVar = new a(yVar);
                                break;
                            case 2007:
                                ahVar = new ak(yVar);
                                break;
                            default:
                                return null;
                        }
                }
            } else {
                ahVar = new c(yVar);
            }
            return ahVar;
        }
        return (com.vivo.push.v) invokeL.objValue;
    }

    public static ab b(com.vivo.push.y yVar) {
        InterceptResult invokeL;
        ab ahVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yVar)) == null) {
            int b2 = yVar.b();
            if (b2 == 20) {
                ahVar = new ah(yVar);
            } else if (b2 != 2016) {
                switch (b2) {
                    case 1:
                        ahVar = new ac(yVar);
                        break;
                    case 2:
                        ahVar = new h(yVar);
                        break;
                    case 3:
                        ahVar = new p(yVar);
                        break;
                    case 4:
                        ahVar = new r(yVar);
                        break;
                    case 5:
                        ahVar = new t(yVar);
                        break;
                    case 6:
                        ahVar = new z(yVar);
                        break;
                    case 7:
                        ahVar = new n(yVar);
                        break;
                    case 8:
                        ahVar = new l(yVar);
                        break;
                    case 9:
                        ahVar = new g(yVar);
                        break;
                    case 10:
                        ahVar = new d(yVar);
                        break;
                    case 11:
                        ahVar = new af(yVar);
                        break;
                    default:
                        return null;
                }
            } else {
                ahVar = new k(yVar);
            }
            return ahVar;
        }
        return (ab) invokeL.objValue;
    }
}
