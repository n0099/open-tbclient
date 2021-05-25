package d.r.b.a.a.i.d;

import android.app.Activity;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import d.r.b.a.a.i.c.j;
/* loaded from: classes7.dex */
public final class a extends d.r.b.a.a.i.e.a {

    /* renamed from: a  reason: collision with root package name */
    public String f67853a = "DxmPayProxy";

    /* renamed from: b  reason: collision with root package name */
    public e f67854b;

    /* renamed from: d.r.b.a.a.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1902a implements d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f67856b;

        public C1902a(IPayCallback iPayCallback) {
            this.f67856b = iPayCallback;
        }

        @Override // d.r.b.a.a.i.d.d
        public void onSuccess(int i2, String str) {
            a.this.onPayResult(i2, str, this.f67856b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f67858b;

        public b(IPayCallback iPayCallback) {
            this.f67858b = iPayCallback;
        }

        @Override // d.r.b.a.a.i.d.d
        public void onSuccess(int i2, String str) {
            a.this.onPayResult(i2, str, this.f67858b);
        }
    }

    public a(e eVar) {
        this.f67854b = eVar;
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isPayingStatus() {
        return super.isPayingStatus();
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        return true;
    }

    public final void onPayResult(int i2, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        String str2 = this.f67853a;
        d.r.b.a.a.f.d.d.b(str2, "onPayResult state=" + i2 + " p1=" + str);
        if (i2 == 0) {
            if (iPayCallback != null) {
                iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
            }
        } else if (i2 == 1) {
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, "正常调起支付，支付中", null);
            }
        } else if (i2 != 2 || iPayCallback == null) {
        } else {
            iPayCallback.onFail(PayStatus.CANCEL.getCode(), "正常调起支付，支付取消", null);
        }
    }

    @Override // d.r.b.a.a.i.e.a
    public void requestPay(Activity activity, long j, j jVar, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.f67854b.sendPay(j, activity, str, new C1902a(iPayCallback));
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.f67854b.sendPay(j, activity, str2, new b(iPayCallback));
    }
}
