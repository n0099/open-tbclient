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
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPaySignMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PaySignMethodFactory {
    public static final /* synthetic */ PaySignMethodFactory[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PaySignMethodFactory ALIPAY_PAY_SIGN;
    public transient /* synthetic */ FieldHolder $fh;
    public final String clazz;
    public IPayAliSignMethod method;

    /* renamed from: com.yy.mobile.framework.revenuesdk.payservice.PaySignMethodFactory$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(895838352, "Lcom/yy/mobile/framework/revenuesdk/payservice/PaySignMethodFactory$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(895838352, "Lcom/yy/mobile/framework/revenuesdk/payservice/PaySignMethodFactory$1;");
                    return;
                }
            }
            int[] iArr = new int[PayType.values().length];
            $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType = iArr;
            try {
                iArr[PayType.ALI_PAY_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(470205437, "Lcom/yy/mobile/framework/revenuesdk/payservice/PaySignMethodFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(470205437, "Lcom/yy/mobile/framework/revenuesdk/payservice/PaySignMethodFactory;");
                return;
            }
        }
        PaySignMethodFactory paySignMethodFactory = new PaySignMethodFactory("ALIPAY_PAY_SIGN", 0, "com.yy.mobile.framework.revenue.alipay.RevenueAlipaySignImpl");
        ALIPAY_PAY_SIGN = paySignMethodFactory;
        $VALUES = new PaySignMethodFactory[]{paySignMethodFactory};
    }

    private void initPayMethod() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                this.method = (IPayAliSignMethod) Class.forName(this.clazz).newInstance();
            } catch (Exception e) {
                this.method = new DefaultPaySignMethod();
                RLog.error("AppPayServiceImpl", "init PayMethod error.clazz = " + this.clazz, e);
            }
        }
    }

    public PaySignMethodFactory(String str, int i, String str2) {
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

    private IPayAliSignMethod getPayMethodImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            IPayAliSignMethod iPayAliSignMethod = this.method;
            if (iPayAliSignMethod != null) {
                return iPayAliSignMethod;
            }
            initPayMethod();
            return this.method;
        }
        return (IPayAliSignMethod) invokeV.objValue;
    }

    public static PaySignMethodFactory[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return (PaySignMethodFactory[]) $VALUES.clone();
        }
        return (PaySignMethodFactory[]) invokeV.objValue;
    }

    public static IPayAliSignMethod valueOf(PayType payType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, payType)) == null) {
            if (AnonymousClass1.$SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[payType.ordinal()] != 1) {
                return new DefaultPaySignMethod();
            }
            return ALIPAY_PAY_SIGN.getPayMethodImpl();
        }
        return (IPayAliSignMethod) invokeL.objValue;
    }

    public static PaySignMethodFactory valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return (PaySignMethodFactory) Enum.valueOf(PaySignMethodFactory.class, str);
        }
        return (PaySignMethodFactory) invokeL.objValue;
    }
}
