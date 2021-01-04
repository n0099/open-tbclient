package com.kwad.sdk.reward.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.fsg.base.activity.BaseActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ap;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.reward.d implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    private Handler f10825b;
    private AdInfo c;
    private com.kwad.sdk.reward.c.a d;
    private BroadcastReceiver e = new BroadcastReceiver() { // from class: com.kwad.sdk.reward.b.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = null;
            if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction()) && intent.getData() != null) {
                str = intent.getData().getSchemeSpecificPart();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Message obtainMessage = a.this.f10825b.obtainMessage(BaseActivity.DIALOG_LOADING);
            obtainMessage.obj = str;
            obtainMessage.sendToTarget();
        }
    };

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.f10949a.g.registerReceiver(this.e, intentFilter);
    }

    private void f() {
        Activity activity = this.f10949a.g;
        if (activity != null) {
            activity.unregisterReceiver(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = com.kwad.sdk.core.response.b.c.j(this.f10949a.f);
        this.d = this.f10949a.i;
        this.f10825b = new ap(this);
        e();
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 242 && message.obj != null && message.obj.equals(this.c.adBaseInfo.appPackageName)) {
            if (this.f10949a.f10824b != null) {
                this.f10949a.f10824b.e();
            }
            this.d.h();
            this.f10949a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        f();
    }
}
