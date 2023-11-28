package com.yy.mobile.framework.revenuesdk.payservice;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.H5PayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
/* loaded from: classes2.dex */
public enum PayMethodFactory {
    WECHAT_PAY("com.yy.mobile.framework.revenue.wxpay.RevenueWechatPayImpl"),
    ALIPAY_PAY("com.yy.mobile.framework.revenue.alipay.RevenueAlipayImpl"),
    DXM_PAY("com.yy.mobile.framework.revenue.dxmpay.RevenueDxmpayImpl"),
    QQ_PAY("com.yy.mobile.framework.revenue.qqpay.RevenueQQpayImpl");
    
    public final String clazz;
    public IPayMethod method;

    /* renamed from: com.yy.mobile.framework.revenuesdk.payservice.PayMethodFactory$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$yy$mobile$framework$revenuesdk$payapi$PayType;

        static {
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

    PayMethodFactory(String str) {
        this.clazz = str;
    }

    private IPayMethod getPayMethodImpl() {
        IPayMethod iPayMethod = this.method;
        if (iPayMethod != null) {
            return iPayMethod;
        }
        initPayMethod();
        return this.method;
    }

    private void initPayMethod() {
        try {
            this.method = (IPayMethod) Class.forName(this.clazz).newInstance();
        } catch (Exception e) {
            this.method = new DefaultPayMethod();
            RLog.error("AppPayServiceImpl", "init PayMethod error.clazz = " + this.clazz, e);
        }
    }

    public static IPayMethod valueOf(PayType payType) {
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
}
