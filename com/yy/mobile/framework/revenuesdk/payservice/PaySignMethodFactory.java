package com.yy.mobile.framework.revenuesdk.payservice;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPaySignMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayAliSignMethod;
/* loaded from: classes9.dex */
public enum PaySignMethodFactory {
    ALIPAY_PAY_SIGN("com.yy.mobile.framework.revenue.alipay.RevenueAlipaySignImpl");
    
    public final String clazz;
    public IPayAliSignMethod method;

    /* renamed from: com.yy.mobile.framework.revenuesdk.payservice.PaySignMethodFactory$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType;

        static {
            int[] iArr = new int[PayType.values().length];
            $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType = iArr;
            try {
                iArr[PayType.ALI_PAY_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private IPayAliSignMethod getPayMethodImpl() {
        IPayAliSignMethod iPayAliSignMethod = this.method;
        if (iPayAliSignMethod != null) {
            return iPayAliSignMethod;
        }
        initPayMethod();
        return this.method;
    }

    private void initPayMethod() {
        try {
            this.method = (IPayAliSignMethod) Class.forName(this.clazz).newInstance();
        } catch (Exception e) {
            this.method = new DefaultPaySignMethod();
            RLog.error("AppPayServiceImpl", "init PayMethod error.clazz = " + this.clazz, e);
        }
    }

    PaySignMethodFactory(String str) {
        this.clazz = str;
    }

    public static IPayAliSignMethod valueOf(PayType payType) {
        if (AnonymousClass1.$SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType[payType.ordinal()] != 1) {
            return new DefaultPaySignMethod();
        }
        return ALIPAY_PAY_SIGN.getPayMethodImpl();
    }
}
