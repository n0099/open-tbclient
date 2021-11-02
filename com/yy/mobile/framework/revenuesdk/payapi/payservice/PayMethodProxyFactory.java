package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.DxmPayProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.WechatPayProxy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PayMethodProxyFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public Map<String, IPaySdkServiceProxy> payMethodProxyMap;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final PayMethodProxyFactory instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-94796701, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/PayMethodProxyFactory$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-94796701, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/PayMethodProxyFactory$Holder;");
                    return;
                }
            }
            instance = new PayMethodProxyFactory();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public PayMethodProxyFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayMethodProxyFactory";
        this.payMethodProxyMap = new HashMap(5);
    }

    public static PayMethodProxyFactory instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Holder.instance : (PayMethodProxyFactory) invokeV.objValue;
    }

    public synchronized void addPayServiceProxyMap(PayType payType, IPaySdkServiceProxy iPaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, payType, iPaySdkServiceProxy) == null) {
            synchronized (this) {
                if (this.payMethodProxyMap.containsKey(payType.getChannel())) {
                    RLog.info("PayMethodProxyFactory", "addPayMethodProxyMap but contains paychannel:" + payType.getChannel());
                    return;
                }
                RLog.info("PayMethodProxyFactory", "addPayMethodProxyMap paychannel:" + payType.getChannel());
                this.payMethodProxyMap.put(payType.getChannel(), iPaySdkServiceProxy);
            }
        }
    }

    public synchronized IPayMethod findProxyPayMethod(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payType)) == null) {
            synchronized (this) {
                IPaySdkServiceProxy findProxyPayService = findProxyPayService(payType);
                if (findProxyPayService == null) {
                    RLog.info("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
                    return null;
                } else if (payType == PayType.ALI_PAY) {
                    if (findProxyPayService instanceof IAlipaySdkServiceProxy) {
                        return new AlipayProxy((IAlipaySdkServiceProxy) findProxyPayService);
                    }
                    RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IAlipaySdkProxy ", new Object[0]);
                    return null;
                } else if (payType == PayType.WECHAT_PAY) {
                    if (findProxyPayService instanceof IWechatSdkServiceProxy) {
                        return new WechatPayProxy((IWechatSdkServiceProxy) findProxyPayService);
                    }
                    RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IWechatSdkProxy ", new Object[0]);
                    return null;
                } else if (payType == PayType.DXM_PAY) {
                    if (findProxyPayService instanceof IDxmSdkServiceProxy) {
                        return new DxmPayProxy((IDxmSdkServiceProxy) findProxyPayService);
                    }
                    RLog.error("PayMethodProxyFactory", "paySdkServiceProxy is not IDxmSdkServiceProxy ", new Object[0]);
                    return null;
                } else {
                    return null;
                }
            }
        }
        return (IPayMethod) invokeL.objValue;
    }

    public synchronized IPaySdkServiceProxy findProxyPayService(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payType)) == null) {
            synchronized (this) {
                IPaySdkServiceProxy iPaySdkServiceProxy = this.payMethodProxyMap.get(payType.getChannel());
                if (iPaySdkServiceProxy == null) {
                    RLog.info("PayMethodProxyFactory", "findProxyPayMethod null paychannel:" + payType.getChannel());
                    return null;
                }
                return iPaySdkServiceProxy;
            }
        }
        return (IPaySdkServiceProxy) invokeL.objValue;
    }

    public String getProxyMapKey(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, str)) == null) {
            return i2 + "-" + i3 + "-" + str;
        }
        return (String) invokeIIL.objValue;
    }

    public synchronized void removePayServiceProxyMap(PayType payType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, payType) == null) {
            synchronized (this) {
                if (!this.payMethodProxyMap.containsKey(payType.getChannel())) {
                    RLog.info("PayMethodProxyFactory", "removePayMethodProxyMap but not contains paychannel:" + payType.getChannel());
                    return;
                }
                RLog.info("PayMethodProxyFactory", "removePayMethodProxyMap paychannel:" + payType.getChannel());
                this.payMethodProxyMap.remove(payType.getChannel());
            }
        }
    }
}
