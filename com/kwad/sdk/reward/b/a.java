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
import com.baidu.tieba.service.AsInstallService;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ap;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.reward.d implements ap.a {

    /* renamed from: b  reason: collision with root package name */
    public Handler f37057b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f37058c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f37059d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f37060e = new BroadcastReceiver() { // from class: com.kwad.sdk.reward.b.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = a.this.f37057b.obtainMessage(BaseActivity.DIALOG_LOADING);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        ((com.kwad.sdk.reward.d) this).f37299a.f37054g.registerReceiver(this.f37060e, intentFilter);
    }

    private void f() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f37299a.f37054g;
        if (activity != null) {
            activity.unregisterReceiver(this.f37060e);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f37058c = com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.reward.d) this).f37299a.f37053f);
        this.f37059d = ((com.kwad.sdk.reward.d) this).f37299a.f37056i;
        this.f37057b = new ap(this);
        e();
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Object obj;
        if (message.what == 242 && (obj = message.obj) != null && obj.equals(this.f37058c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.d) this).f37299a.f37049b;
            if (bVar != null) {
                bVar.e();
            }
            this.f37059d.h();
            ((com.kwad.sdk.reward.d) this).f37299a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        f();
    }
}
