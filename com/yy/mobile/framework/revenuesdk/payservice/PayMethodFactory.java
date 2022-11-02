package com.yy.mobile.framework.revenuesdk.payservice;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.H5PayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PayMethodFactory {
    public static final /* synthetic */ PayMethodFactory[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayMethodFactory ALIPAY_PAY;
    public static final PayMethodFactory DXM_PAY;
    public static final PayMethodFactory QQ_PAY;
    public static final PayMethodFactory WECHAT_PAY;
    public transient /* synthetic */ FieldHolder $fh;
    public final String clazz;
    public IPayMethod method;

    /* renamed from: com.yy.mobile.framework.revenuesdk.payservice.PayMethodFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1503004595, "Lcom/yy/mobile/framework/revenuesdk/payservice/PayMethodFactory$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1503004595, "Lcom/yy/mobile/framework/revenuesdk/payservice/PayMethodFactory$1;");
                    return;
                }
            }
            int[] iArr = new int[PayType.values().length];
            $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType = iArr;
            try {
                iArr[PayType.WECHAT_PAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.ALI_PAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.DXM_PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.QQ_PAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.UNION_PAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.MOCK_TEST_PAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.DXM_PAY_KJ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[PayType.DXM_PAY_H5.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1896533984, "Lcom/yy/mobile/framework/revenuesdk/payservice/PayMethodFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1896533984, "Lcom/yy/mobile/framework/revenuesdk/payservice/PayMethodFactory;");
                return;
            }
        }
        WECHAT_PAY = new PayMethodFactory("WECHAT_PAY", 0, "com.yy.mobile.framework.revenue.wxpay.RevenueWechatPayImpl");
        ALIPAY_PAY = new PayMethodFactory("ALIPAY_PAY", 1, "com.yy.mobile.framework.revenue.alipay.RevenueAlipayImpl");
        DXM_PAY = new PayMethodFactory("DXM_PAY", 2, "com.yy.mobile.framework.revenue.dxmpay.RevenueDxmpayImpl");
        PayMethodFactory payMethodFactory = new PayMethodFactory("QQ_PAY", 3, "com.yy.mobile.framework.revenue.qqpay.RevenueQQpayImpl");
        QQ_PAY = payMethodFactory;
        $VALUES = new PayMethodFactory[]{WECHAT_PAY, ALIPAY_PAY, DXM_PAY, payMethodFactory};
    }

    public PayMethodFactory(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.clazz = str2;
    }

    private IPayMethod getPayMethodImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            IPayMethod iPayMethod = this.method;
            if (iPayMethod != null) {
                return iPayMethod;
            }
            initPayMethod();
            return this.method;
        }
        return (IPayMethod) invokeV.objValue;
    }

    public static PayMethodFactory[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return (PayMethodFactory[]) $VALUES.clone();
        }
        return (PayMethodFactory[]) invokeV.objValue;
    }

    private void initPayMethod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.method = (IPayMethod) Class.forName(this.clazz).newInstance();
            } catch (Exception e) {
                this.method = new DefaultPayMethod();
                RLog.error("AppPayServiceImpl", "init PayMethod error.clazz = " + this.clazz, e);
            }
        }
    }

    public static IPayMethod valueOf(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, payType)) == null) {
            IPayMethod findProxyPayMethod = PayMethodProxyFactory.instance().findProxyPayMethod(payType);
            if (findProxyPayMethod != null) {
                RLog.info("AppPayServiceImpl", "use proxyPayMethod channel:" + payType.getChannel());
                return findProxyPayMethod;
            }
            switch (AnonymousClass1.$SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[payType.ordinal()]) {
                case 1:
                    return WECHAT_PAY.getPayMethodImpl();
                case 2:
                    return ALIPAY_PAY.getPayMethodImpl();
                case 3:
                    return DXM_PAY.getPayMethodImpl();
                case 4:
                    return QQ_PAY.getPayMethodImpl();
                case 5:
                case 6:
                case 7:
                case 8:
                    return new H5PayMethod();
                default:
                    return new DefaultPayMethod();
            }
        }
        return (IPayMethod) invokeL.objValue;
    }

    public static PayMethodFactory valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return (PayMethodFactory) Enum.valueOf(PayMethodFactory.class, str);
        }
        return (PayMethodFactory) invokeL.objValue;
    }
}
