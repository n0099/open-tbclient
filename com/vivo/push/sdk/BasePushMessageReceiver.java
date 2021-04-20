package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.p;
import com.vivo.push.util.s;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback {
    public static final String TAG = "PushMessageReceiver";

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(Context context) {
        if (context == null) {
            p.a("PushMessageReceiver", "isAllowNet sContext is null");
            return false;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            p.a("PushMessageReceiver", "isAllowNet pkgName is null");
            return false;
        }
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(packageName);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            return s.a(context, packageName);
        }
        p.a("PushMessageReceiver", "this is client sdk");
        return true;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(Context context, int i, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(Context context, int i, List<String> list, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(Context context, String str, int i, boolean z) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(Context context, int i, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        com.vivo.push.p.a().a(applicationContext);
        try {
            int intExtra = intent.getIntExtra("method", -1);
            String stringExtra = intent.getStringExtra(IAdRequestParam.REQ_ID);
            p.d("PushMessageReceiver", "PushMessageReceiver " + applicationContext.getPackageName() + " ; type = " + intExtra + " ; requestId = " + stringExtra);
            try {
                com.vivo.push.p.a().a(intent, this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            p.b("PushMessageReceiver", "get method error", e3);
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context context, int i, List<String> list, List<String> list2, String str) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(Context context, int i, String str) {
    }
}
