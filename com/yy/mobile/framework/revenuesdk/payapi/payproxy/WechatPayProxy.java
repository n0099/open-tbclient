package com.yy.mobile.framework.revenuesdk.payapi.payproxy;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
import com.baidu.tieba.wallet.YYPayManager;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.PackageInstallUtil;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod;
import java.util.Map;
import kotlin.Metadata;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b.\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0013\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJE\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001fJ;\u0010!\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010$R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/WechatPayProxy;", "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/DefaultPayMethod;", "Landroid/app/Activity;", "act", "", "isSupported", "(Landroid/app/Activity;)Z", "", "code", "", "msg", "Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/PurchaseInfo;", WebChromeClient.KEY_ARG_CALLBACK, "", "onPayResult", "(ILjava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "", "result", "onProxyPayResult", "(Ljava/util/Map;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "onWxPayResult", "(ILjava/lang/String;)V", "", "uid", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;", "info", "payload", "requestPay", "(Landroid/app/Activity;JLcom/yy/mobile/framework/revenuesdk/payapi/bean/ProductInfo;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "productId", "(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "activity", "wxPayInterval", "(JLandroid/app/Activity;Ljava/lang/String;Lcom/yy/mobile/framework/revenuesdk/payapi/IPayCallback;)V", "TAG", "Ljava/lang/String;", "errCodeKey", "errStrKey", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "wxPayService", "Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "getWxPayService", "()Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;", "setWxPayService", "(Lcom/yy/mobile/framework/revenuesdk/payapi/payproxy/IWechatSdkServiceProxy;)V", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WechatPayProxy extends DefaultPayMethod {
    public String TAG = "WechatPayProxy";
    public final String errCodeKey = YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_CODE;
    public final String errStrKey = YYPayManager.KEY_WX_RECHARGE_RESULT_ERROR_STR;
    public IWechatSdkServiceProxy wxPayService;

    public WechatPayProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        this.wxPayService = iWechatSdkServiceProxy;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public boolean isSupported(Activity activity) {
        return PackageInstallUtil.isInstallWechat(activity);
    }

    public final void setWxPayService(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        this.wxPayService = iWechatSdkServiceProxy;
    }

    private final void onPayResult(int i, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        if (i != -2) {
            if (i != 0) {
                if (iPayCallback != null) {
                    iPayCallback.onFail(i, PayFailMsg.THIRD_PARTY_CALLBACK_OTHER_STATE, null);
                }
            } else if (iPayCallback != null) {
                iPayCallback.onSuccess(new PurchaseInfo("", ""), null);
            }
        } else if (iPayCallback != null) {
            iPayCallback.onFail(com.yy.mobile.framework.revenuesdk.payapi.PayStatus.CANCEL.getCode(), "取消支付", null);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void onWxPayResult(int i, String str) {
        RLog.info(this.TAG, "onWxPayResult");
        this.wxPayService.onWxPayResult(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onProxyPayResult(Map<String, String> map, IPayCallback<PurchaseInfo> iPayCallback) {
        Integer num;
        if (map == null) {
            RLog.error(this.TAG, " onProxyPayResult null", new Object[0]);
            if (iPayCallback != null) {
                iPayCallback.onFail(DlnaManager.DLNA_SUB_ERROR_NETWORK_NOT_WIFI, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
                return;
            }
            return;
        }
        String str = map.get(this.errCodeKey);
        if (str != null) {
            num = Integer.valueOf(Integer.parseInt(str));
        } else {
            num = null;
        }
        String str2 = map.get(this.errStrKey);
        if (num != null) {
            onPayResult(num.intValue(), str2, iPayCallback);
            return;
        }
        RLog.error(this.TAG, " onProxyPayResult errCode null", new Object[0]);
        if (iPayCallback != null) {
            iPayCallback.onFail(DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE, PayFailMsg.FAILED_PARSE_THIRD_PARTY_CALLBACK, null);
        }
    }

    private final void wxPayInterval(long j, Activity activity, String str, final IPayCallback<PurchaseInfo> iPayCallback) {
        if (activity == null) {
            RLog.error(this.TAG, "pay failed params activity null", new Object[0]);
            if (iPayCallback != null) {
                iPayCallback.onFail(-1008, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                return;
            }
            return;
        }
        RLog.info(this.TAG, "wxPayInterval");
        this.wxPayService.sendPay(j, activity, str, new IWechatProxyCallback() { // from class: com.yy.mobile.framework.revenuesdk.payapi.payproxy.WechatPayProxy$wxPayInterval$1
            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback
            public void onFail(String str2) {
                String str3;
                str3 = WechatPayProxy.this.TAG;
                RLog.error(str3, " onFail failReasonn:" + str2, new Object[0]);
                IPayCallback iPayCallback2 = iPayCallback;
                if (iPayCallback2 != null) {
                    iPayCallback2.onFail(-1005, PayFailMsg.FAILED_CALL_THIRD_PARTY_SDK, null);
                }
            }

            @Override // com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatProxyCallback
            public void onSuccess(Map<String, String> map) {
                String str2;
                str2 = WechatPayProxy.this.TAG;
                RLog.info(str2, "wxPayInterval onSuccess result:" + map);
                WechatPayProxy.this.onProxyPayResult(map, iPayCallback);
            }
        });
    }

    public final IWechatSdkServiceProxy getWxPayService() {
        return this.wxPayService;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, ProductInfo productInfo, String str, IPayCallback<PurchaseInfo> iPayCallback) {
        wxPayInterval(j, activity, str, iPayCallback);
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.payservice.DefaultPayMethod, com.yy.mobile.framework.revenuesdk.payapi.payservice.IPayMethod
    public void requestPay(Activity activity, long j, String str, String str2, IPayCallback<PurchaseInfo> iPayCallback) {
        wxPayInterval(j, activity, str2, iPayCallback);
    }
}
