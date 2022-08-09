package com.vivo.push.d;

import com.baidu.android.imsdk.IMConstants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ag() {
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
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.vivo.push.l a(com.vivo.push.o oVar) {
        InterceptResult invokeL;
        com.vivo.push.l afVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oVar)) == null) {
            int b = oVar.b();
            if (b == 20) {
                afVar = new af(oVar);
            } else if (b == 100) {
                afVar = new b(oVar);
            } else if (b != 101) {
                switch (b) {
                    case 0:
                        afVar = new ah(oVar);
                        break;
                    case 1:
                        afVar = new aa(oVar);
                        break;
                    case 2:
                        afVar = new h(oVar);
                        break;
                    case 3:
                        afVar = new p(oVar);
                        break;
                    case 4:
                        afVar = new r(oVar);
                        break;
                    case 5:
                        afVar = new u(oVar);
                        break;
                    case 6:
                        afVar = new x(oVar);
                        break;
                    case 7:
                        afVar = new n(oVar);
                        break;
                    case 8:
                        afVar = new l(oVar);
                        break;
                    case 9:
                        afVar = new g(oVar);
                        break;
                    case 10:
                        afVar = new d(oVar);
                        break;
                    case 11:
                        afVar = new ad(oVar);
                        break;
                    case 12:
                        afVar = new f(oVar);
                        break;
                    default:
                        switch (b) {
                            case 2000:
                            case 2001:
                            case 2002:
                            case 2003:
                            case 2004:
                            case 2005:
                            case 2008:
                            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE /* 2009 */:
                            case 2010:
                            case IMConstants.IM_MSG_TYPE_SHIELD /* 2011 */:
                            case IMConstants.IM_MSG_TYPE_SHIELD_ME /* 2012 */:
                            case 2013:
                            case 2014:
                            case 2015:
                                break;
                            case 2006:
                                afVar = new a(oVar);
                                break;
                            case 2007:
                                afVar = new ai(oVar);
                                break;
                            default:
                                return null;
                        }
                }
            } else {
                afVar = new c(oVar);
            }
            return afVar;
        }
        return (com.vivo.push.l) invokeL.objValue;
    }

    public static z b(com.vivo.push.o oVar) {
        InterceptResult invokeL;
        z afVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oVar)) == null) {
            int b = oVar.b();
            if (b == 20) {
                afVar = new af(oVar);
            } else if (b != 2016) {
                switch (b) {
                    case 1:
                        afVar = new aa(oVar);
                        break;
                    case 2:
                        afVar = new h(oVar);
                        break;
                    case 3:
                        afVar = new p(oVar);
                        break;
                    case 4:
                        afVar = new r(oVar);
                        break;
                    case 5:
                        afVar = new u(oVar);
                        break;
                    case 6:
                        afVar = new x(oVar);
                        break;
                    case 7:
                        afVar = new n(oVar);
                        break;
                    case 8:
                        afVar = new l(oVar);
                        break;
                    case 9:
                        afVar = new g(oVar);
                        break;
                    case 10:
                        afVar = new d(oVar);
                        break;
                    case 11:
                        afVar = new ad(oVar);
                        break;
                    default:
                        return null;
                }
            } else {
                afVar = new k(oVar);
            }
            return afVar;
        }
        return (z) invokeL.objValue;
    }
}
