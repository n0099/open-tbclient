package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alipay.sdk.util.l;
import com.baidu.android.lbspay.channelpay.alipay.Result;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.c.j;
import d.r.b.a.a.i.d.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b>\u0010=J1\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u0019\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J)\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010\"\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\f\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\"\u0010#JM\u0010\"\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\"\u0010%JM\u0010&\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b&\u0010%J\u001b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b)\u0010*J%\u0010.\u001a\u00020-2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010+H\u0002¢\u0006\u0004\b.\u0010/J_\u00103\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010\r2\u0006\u00102\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016¢\u0006\u0004\b3\u00104R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/AlipayProxy;", "Ld/r/b/a/a/i/e/a;", "Landroid/app/Activity;", "act", "", "type", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", "iResult", "", "clearHangPayJob", "(Landroid/app/Activity;ILcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)V", "info", "", "result", "", "doHangJob", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "isSupported", "(Landroid/app/Activity;)Z", l.f1974a, "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "callback", "onPayResult", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "onProxyPayResult", "product", "queryHistoryPurchaseByProductId", "(Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/baseapi/IResult;)Z", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "payload", "isSetAccountId", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "requestSubscription", "aliRecharge", "Lorg/json/JSONObject;", "splitPayResult", "(Ljava/lang/String;)Lorg/json/JSONObject;", "", "rawResult", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "transToPayResult", "(Ljava/util/Map;)Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/PayResult;", "oldProductId", "newProductId", "prorationMode", "updateSubscription", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "alipayServiceService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "getAlipayServiceService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;", "setAlipayServiceService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IAlipaySdkServiceProxy;)V", "<init>", "payapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class AlipayProxy extends d.r.b.a.a.i.e.a {
    public String TAG = "AlipayProxy";
    public c alipayServiceService;

    /* loaded from: classes7.dex */
    public static final class a implements d.r.b.a.a.i.d.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f38301b;

        public a(IPayCallback iPayCallback) {
            this.f38301b = iPayCallback;
        }

        @Override // d.r.b.a.a.i.d.b
        public void a(String str) {
            String str2 = AlipayProxy.this.TAG;
            d.e(str2, "onFail failReasonn:" + str, new Object[0]);
            IPayCallback iPayCallback = this.f38301b;
            if (iPayCallback != null) {
                iPayCallback.onFail(-1, "Proxy 支付异常", null);
            }
        }

        @Override // d.r.b.a.a.i.d.b
        public void onSuccess(String str) {
            AlipayProxy.this.onProxyPayResult(str, this.f38301b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d.r.b.a.a.i.d.b {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f38303b;

        public b(IPayCallback iPayCallback) {
            this.f38303b = iPayCallback;
        }

        @Override // d.r.b.a.a.i.d.b
        public void a(String str) {
            String str2 = AlipayProxy.this.TAG;
            d.e(str2, "onFail failReasonn:" + str, new Object[0]);
            IPayCallback iPayCallback = this.f38303b;
            if (iPayCallback != null) {
                iPayCallback.onFail(-1, "Proxy 支付异常", null);
            }
        }

        @Override // d.r.b.a.a.i.d.b
        public void onSuccess(String str) {
            AlipayProxy.this.onProxyPayResult(str, this.f38303b);
        }
    }

    public AlipayProxy(c cVar) {
        this.alipayServiceService = cVar;
    }

    private final void onPayResult(String str, IPayCallback<PurchaseInfo> iPayCallback) {
        switch (str.hashCode()) {
            case 1596796:
                if (str.equals(Result.RESULT_FAILED)) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(4000, "订单支付失败", null);
                        return;
                    }
                    return;
                }
                break;
            case 1626587:
                if (str.equals("5000")) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(5000, "重复请求", null);
                        return;
                    }
                    return;
                }
                break;
            case 1656379:
                if (str.equals(Result.RESULT_CANCLE)) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "取消支付", null);
                        return;
                    }
                    return;
                }
                break;
            case 1656380:
                if (str.equals(Result.RESULT_NETWROK_ERROR)) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(6002, "网络连接出错", null);
                        return;
                    }
                    return;
                }
                break;
            case 1656382:
                if (str.equals("6004")) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(6004, "支付结果未知", null);
                        return;
                    }
                    return;
                }
                break;
            case 1715960:
                if (str.equals("8000")) {
                    if (iPayCallback != null) {
                        iPayCallback.onFail(8000, "正在处理中", null);
                        return;
                    }
                    return;
                }
                break;
            case 1745751:
                if (str.equals(Result.RESULT_SUCCESS)) {
                    if (iPayCallback != null) {
                        iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
                        return;
                    }
                    return;
                }
                break;
        }
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        int intValue = intOrNull != null ? intOrNull.intValue() : -1;
        if (iPayCallback != null) {
            iPayCallback.onFail(intValue, "其它支付错误", null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.yy.mobile.framework.revenuesdk.payapi.payproxy.AlipayProxy */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onProxyPayResult(String str, IPayCallback<PurchaseInfo> iPayCallback) {
        Map<String, Object> a2;
        if (str == null) {
            d.e(this.TAG, "onPayResult result null", new Object[0]);
            if (iPayCallback != null) {
                iPayCallback.onFail(-1, "onPayResult null", null);
                return;
            }
            return;
        }
        try {
            a2 = d.r.b.a.a.i.g.a.a(str);
        } catch (Exception unused) {
            d.b(this.TAG, "getMapForJson exception split");
            JSONObject splitPayResult = splitPayResult(str);
            if (splitPayResult == null) {
                d.e(this.TAG, "onPayResult jsonResultString null", new Object[0]);
                if (iPayCallback != null) {
                    iPayCallback.onFail(-1, "onPayResult jsonResultString null", null);
                    return;
                }
                return;
            }
            a2 = d.r.b.a.a.i.g.a.a(splitPayResult.toString());
            if (a2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            }
        }
        if (a2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        } else if (a2 == null) {
            if (iPayCallback != null) {
                iPayCallback.onFail(-2, "onPayResult jsonResult null", null);
            }
        } else {
            PayResult transToPayResult = transToPayResult(a2);
            if (transToPayResult == null) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(-3, "onPayResult payResult null", null);
                    return;
                }
                return;
            }
            String resultStatus = transToPayResult.getResultStatus();
            if (resultStatus == null) {
                Intrinsics.throwNpe();
            }
            onPayResult(resultStatus, iPayCallback);
        }
    }

    private final JSONObject splitPayResult(String str) {
        String str2;
        String str3 = this.TAG;
        d.b(str3, "aliRechargeResult " + str);
        if (str == null) {
            return null;
        }
        List<String> split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        JSONObject jSONObject = new JSONObject();
        for (String str4 : split$default) {
            List split$default2 = StringsKt__StringsKt.split$default((CharSequence) str4, new String[]{"="}, false, 0, 6, (Object) null);
            if (split$default2.size() > 1) {
                String str5 = (String) split$default2.get(1);
                if (str5.length() > 2) {
                    int length = str5.length() - 1;
                    if (str5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    str2 = str5.substring(1, length);
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    str2 = "";
                }
                jSONObject.put((String) split$default2.get(0), str2);
            }
        }
        String str6 = this.TAG;
        d.b(str6, "aliRechargeResult " + jSONObject);
        return jSONObject;
    }

    private final PayResult transToPayResult(Map<String, String> map) {
        PayResult payResult = new PayResult("-1", "失败", "");
        if (map != null) {
            for (String str : map.keySet()) {
                if (TextUtils.equals(str, l.f1974a)) {
                    payResult.setResultStatus(map.get(str));
                } else if (TextUtils.equals(str, "result")) {
                    payResult.setResult(map.get(str));
                } else if (TextUtils.equals(str, l.f1975b)) {
                    payResult.setMemo(map.get(str));
                }
            }
        }
        return payResult;
    }

    @Override // d.r.b.a.a.i.e.a
    public void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult) {
    }

    @Override // d.r.b.a.a.i.e.a
    public boolean doHangJob(PurchaseInfo purchaseInfo, IResult<String> iResult) {
        return true;
    }

    public final c getAlipayServiceService() {
        return this.alipayServiceService;
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        return true;
    }

    @Override // d.r.b.a.a.i.e.a
    public boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult) {
        return false;
    }

    @Override // d.r.b.a.a.i.e.a
    public void requestPay(Activity activity, long j, j jVar, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.alipayServiceService.sendPay(j, activity, str, new a(iPayCallback));
    }

    @Override // d.r.b.a.a.i.e.a
    public void requestSubscription(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e(this.TAG, "Alipay can't requestSubscription", new Object[0]);
    }

    public final void setAlipayServiceService(c cVar) {
        this.alipayServiceService = cVar;
    }

    @Override // d.r.b.a.a.i.e.a
    public void updateSubscription(Activity activity, long j, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        d.e(this.TAG, "Alipay can't updateSubscription", new Object[0]);
    }

    @Override // d.r.b.a.a.i.e.a, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback) {
        this.alipayServiceService.sendPay(j, activity, str2, new b(iPayCallback));
    }
}
