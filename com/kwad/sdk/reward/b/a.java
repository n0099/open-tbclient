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
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.reward.d implements ao.a {

    /* renamed from: b  reason: collision with root package name */
    public Handler f33501b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f33502c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f33503d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f33504e = new BroadcastReceiver() { // from class: com.kwad.sdk.reward.b.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String schemeSpecificPart = (!TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction()) || intent.getData() == null) ? null : intent.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                return;
            }
            Message obtainMessage = a.this.f33501b.obtainMessage(BaseActivity.DIALOG_LOADING);
            obtainMessage.obj = schemeSpecificPart;
            obtainMessage.sendToTarget();
        }
    };

    private void e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
        intentFilter.addDataScheme(AsInstallService.SCHEME_PACKAGE_ADDED);
        ((com.kwad.sdk.reward.d) this).f33768a.f33496g.registerReceiver(this.f33504e, intentFilter);
    }

    private void m() {
        Activity activity = ((com.kwad.sdk.reward.d) this).f33768a.f33496g;
        if (activity != null) {
            activity.unregisterReceiver(this.f33504e);
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33502c = com.kwad.sdk.core.response.b.c.g(((com.kwad.sdk.reward.d) this).f33768a.f33495f);
        this.f33503d = ((com.kwad.sdk.reward.d) this).f33768a.f33498i;
        this.f33501b = new ao(this);
        e();
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        Object obj;
        if (message.what == 242 && (obj = message.obj) != null && obj.equals(this.f33502c.adBaseInfo.appPackageName)) {
            com.kwad.sdk.reward.a.b bVar = ((com.kwad.sdk.reward.d) this).f33768a.f33491b;
            if (bVar != null) {
                bVar.e();
            }
            this.f33503d.h();
            ((com.kwad.sdk.reward.d) this).f33768a.b();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        m();
    }
}
