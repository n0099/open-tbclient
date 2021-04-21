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
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ap;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    public Handler f36609b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f36610c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f36611d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f36612e = new BroadcastReceiver() { // from class: com.kwad.sdk.reward.b.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = a.this.f36609b.obtainMessage(BaseActivity.DIALOG_LOADING);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme("package");
        ((com.kwad.sdk.reward.d) this).f36842a.f36607g.registerReceiver(this.f36612e, intentFilter);
    }

    private void f() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f36842a.f36607g;
        if (activity != null) {
            activity.unregisterReceiver(this.f36612e);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f36610c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f36842a.f36606f);
        this.f36611d = ((com.kwad.sdk.reward.d) this).f36842a.i;
        this.f36609b = new ap(this);
        e();
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Object obj;
        if (message.what == 242 && (obj = message.obj) != null && obj.equals(this.f36610c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.d) this).f36842a.f36602b;
            if (bVar != null) {
                bVar.e();
            }
            this.f36611d.h();
            ((com.kwad.sdk.reward.d) this).f36842a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        f();
    }
}
