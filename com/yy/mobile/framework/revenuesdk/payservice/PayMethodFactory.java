package com.yy.mobile.framework.revenuesdk.payservice;

import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.e.b;
import d.r.b.a.a.i.e.c;
/* loaded from: classes7.dex */
public enum PayMethodFactory {
    GOOGLE_PLAY("com.yy.mobile.framework.revenue.gppay.PayMethodImpl"),
    WECHAT_PAY("com.yy.mobile.framework.revenue.wxpay.RevenueWechatPayImpl"),
    ALIPAY_PAY("com.yy.mobile.framework.revenue.alipay.RevenueAlipayImpl"),
    DXM_PAY("com.yy.mobile.framework.revenue.dxmpay.RevenueDxmpayImpl");
    
    public final String clazz;
    public IPayMethod method;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38306a;

        static {
            int[] iArr = new int[PayType.values().length];
            f38306a = iArr;
            try {
                iArr[PayType.WECHAT_PAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38306a[PayType.ALI_PAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38306a[PayType.DXM_PAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38306a[PayType.PAYTM_PAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
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
        } catch (Exception e2) {
            this.method = new d.r.b.a.a.i.e.a();
            d.d("AppPayServiceImpl", "init PayMethod error.clazz = " + this.clazz, e2);
        }
    }

    public static IPayMethod valueOf(PayType payType) {
        IPayMethod b2 = c.d().b(payType);
        if (b2 != null) {
            d.b("AppPayServiceImpl", "use proxyPayMethod channel:" + payType.getChannel());
            return b2;
        }
        int i2 = a.f38306a[payType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return new d.r.b.a.a.i.e.a();
                    }
                    return new b();
                }
                return DXM_PAY.getPayMethodImpl();
            }
            return ALIPAY_PAY.getPayMethodImpl();
        }
        return WECHAT_PAY.getPayMethodImpl();
    }
}
